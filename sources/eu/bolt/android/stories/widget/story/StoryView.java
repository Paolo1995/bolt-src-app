package eu.bolt.android.stories.widget.story;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GestureDetectorCompat;
import androidx.transition.TransitionManager;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.transition.MaterialFadeThrough;
import eu.bolt.android.stories.R$color;
import eu.bolt.android.stories.R$dimen;
import eu.bolt.android.stories.R$drawable;
import eu.bolt.android.stories.R$id;
import eu.bolt.android.stories.R$layout;
import eu.bolt.android.stories.analytics.StoryAnalyticListener;
import eu.bolt.android.stories.util.ViewExtKt;
import eu.bolt.android.stories.utils.CustomTabLauncher;
import eu.bolt.android.stories.widget.helper.StoryButton;
import eu.bolt.android.stories.widget.progress.StoryProgressView;
import eu.bolt.android.stories.widget.slide.ProgressController;
import eu.bolt.android.stories.widget.slide.SlideAssetNotLoadedException;
import eu.bolt.android.stories.widget.slide.StoryButtonType;
import eu.bolt.android.stories.widget.slide.StorySlide;
import eu.bolt.android.stories.widget.slide.StorySlideAsset;
import eu.bolt.android.stories.widget.slide.StorySlideButton;
import eu.bolt.android.stories.widget.slide.StorySlideListener;
import eu.bolt.android.stories.widget.slide.StorySlideView;
import eu.bolt.android.stories.widget.story.StoryView;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryView.kt */
/* loaded from: classes5.dex */
public final class StoryView extends FrameLayout implements StorySlideListener {

    /* renamed from: v  reason: collision with root package name */
    public static final Companion f37798v = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private StoryListener f37799f;

    /* renamed from: g  reason: collision with root package name */
    private StoryAnalyticListener f37800g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f37801h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37802i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f37803j;

    /* renamed from: k  reason: collision with root package name */
    private StoryAnalyticListener.CloseReason f37804k;

    /* renamed from: l  reason: collision with root package name */
    private final Function1<Boolean, Unit> f37805l;

    /* renamed from: m  reason: collision with root package name */
    private int f37806m;

    /* renamed from: n  reason: collision with root package name */
    private Story f37807n;

    /* renamed from: o  reason: collision with root package name */
    private final int f37808o;

    /* renamed from: p  reason: collision with root package name */
    private float f37809p;

    /* renamed from: q  reason: collision with root package name */
    private float f37810q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f37811r;

    /* renamed from: s  reason: collision with root package name */
    private long f37812s;

    /* renamed from: t  reason: collision with root package name */
    private StorySlideAutoSwitchTimer f37813t;

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f37814u;

    /* compiled from: StoryView.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StoryView.kt */
    /* loaded from: classes5.dex */
    public enum SlideSwitchReason {
        TIMER,
        SLIDE_TAP,
        ERROR
    }

    /* compiled from: StoryView.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37819a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f37820b;

        static {
            int[] iArr = new int[StoryButtonType.values().length];
            try {
                iArr[StoryButtonType.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StoryButtonType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StoryButtonType.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f37819a = iArr;
            int[] iArr2 = new int[SlideSwitchReason.values().length];
            try {
                iArr2[SlideSwitchReason.TIMER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SlideSwitchReason.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SlideSwitchReason.SLIDE_TAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f37820b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f37814u = new LinkedHashMap();
        this.f37804k = StoryAnalyticListener.CloseReason.BACK_BUTTON;
        this.f37806m = -1;
        View.inflate(context, R$layout.view_story_single, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        p();
        this.f37805l = v();
        this.f37808o = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private final boolean B() {
        if (this.f37812s == 0) {
            Kalev.d("isSimpleTap() is called before start of tap duration tracking");
            return true;
        } else if (SystemClock.elapsedRealtime() - this.f37812s < 300) {
            return true;
        } else {
            return false;
        }
    }

    private final void F() {
        StorySlide currentSlide;
        StoryAnalyticListener storyAnalyticListener;
        Story story = this.f37807n;
        if (story != null && (currentSlide = getCurrentSlide()) != null && (storyAnalyticListener = this.f37800g) != null) {
            storyAnalyticListener.b(this.f37804k, this.f37803j, story.a(), currentSlide.d());
        }
    }

    private final void G() {
        StorySlide currentSlide;
        StoryAnalyticListener storyAnalyticListener;
        Story story = this.f37807n;
        if (story != null && (currentSlide = getCurrentSlide()) != null && (storyAnalyticListener = this.f37800g) != null) {
            storyAnalyticListener.c(story.a(), currentSlide.d());
        }
    }

    private final boolean H(MotionEvent motionEvent) {
        if (ViewExtKt.a(this)) {
            if (motionEvent.getX() >= (getMeasuredWidth() * 2) / 3) {
                return true;
            }
            return false;
        } else if (motionEvent.getX() < getMeasuredWidth() / 3) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(StoryView this$0, Function1 tryAgain, View view) {
        String str;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(tryAgain, "$tryAgain");
        ((StoryProgressView) this$0.k(R$id.f37453u)).setVisibility(0);
        ((ProgressBar) this$0.k(R$id.f37441b)).setVisibility(0);
        ((StorySlideView) this$0.k(R$id.f37449m)).setVisibility(0);
        this$0.k(R$id.storyErrorContent).setVisibility(8);
        Story story = this$0.f37807n;
        if (story != null) {
            str = story.a();
        } else {
            str = null;
        }
        tryAgain.invoke(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(SlideSwitchReason slideSwitchReason) {
        StoryAnalyticListener.CloseReason closeReason;
        Story story = this.f37807n;
        if (story == null) {
            return;
        }
        int i8 = this.f37806m + 1;
        if (i8 < story.b().size()) {
            N(i8);
            return;
        }
        int i9 = WhenMappings.f37820b[slideSwitchReason.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    closeReason = StoryAnalyticListener.CloseReason.LAST_SLIDE_TAP;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                closeReason = StoryAnalyticListener.CloseReason.ERROR;
            }
        } else {
            closeReason = StoryAnalyticListener.CloseReason.AUTO;
        }
        this.f37804k = closeReason;
        StoryListener storyListener = this.f37799f;
        if (storyListener != null) {
            storyListener.d(story);
        }
    }

    private final void L() {
        Story story = this.f37807n;
        if (story == null) {
            return;
        }
        int i8 = this.f37806m;
        if (i8 - 1 >= 0) {
            N(i8 - 1);
            return;
        }
        StoryListener storyListener = this.f37799f;
        if (storyListener != null) {
            storyListener.h(story);
        }
    }

    private final void M(int i8) {
        Story story = this.f37807n;
        if (story != null) {
            int size = story.b().size();
            if (size == 1) {
                ((StoryProgressView) k(R$id.f37453u)).setVisibility(8);
                return;
            }
            int i9 = R$id.f37453u;
            ((StoryProgressView) k(i9)).setVisibility(0);
            ((StoryProgressView) k(i9)).setSlidesCount(size);
            Story story2 = this.f37807n;
            if (story2 != null) {
                StorySlide storySlide = story2.b().get(i8);
                if (storySlide.a() != null) {
                    ((StoryProgressView) k(i9)).g(i8, 0.0f);
                    this.f37813t = Q(storySlide.a().longValue());
                    return;
                }
                ((StoryProgressView) k(i9)).g(i8, 1.0f);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(int i8) {
        t();
        int i9 = R$id.f37449m;
        if (((StorySlideView) k(i9)).getVisibility() != 0) {
            StorySlideView slideView = (StorySlideView) k(i9);
            Intrinsics.e(slideView, "slideView");
            P(slideView);
        }
        this.f37806m = i8;
        Story story = this.f37807n;
        if (story != null) {
            StorySlide storySlide = story.b().get(i8);
            ((StorySlideView) k(i9)).setSlide(storySlide);
            ((StorySlideView) k(i9)).H(storySlide);
            ((StorySlideView) k(i9)).G();
            M(i8);
            this.f37805l.invoke(Boolean.valueOf(z(storySlide.b())));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void P(View view) {
        MaterialFadeThrough materialFadeThrough = new MaterialFadeThrough();
        materialFadeThrough.c0(400L);
        materialFadeThrough.c(view);
        TransitionManager.b(this, materialFadeThrough);
    }

    private final StorySlideAutoSwitchTimer Q(long j8) {
        StorySlideAutoSwitchTimer storySlideAutoSwitchTimer = new StorySlideAutoSwitchTimer(j8, new Function1<Float, Unit>() { // from class: eu.bolt.android.stories.widget.story.StoryView$startSlideTimer$timer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(float f8) {
                int i8;
                i8 = StoryView.this.f37806m;
                ((StoryProgressView) StoryView.this.k(R$id.f37453u)).g(i8, f8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f8) {
                b(f8.floatValue());
                return Unit.f50853a;
            }
        }, new Function0<Unit>() { // from class: eu.bolt.android.stories.widget.story.StoryView$startSlideTimer$timer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                StoryView.this.K(StoryView.SlideSwitchReason.TIMER);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        storySlideAutoSwitchTimer.l();
        return storySlideAutoSwitchTimer;
    }

    private final void R(StorySlide storySlide) {
        StorySlideAutoSwitchTimer storySlideAutoSwitchTimer;
        Long a8 = storySlide.a();
        if (a8 != null) {
            long longValue = a8.longValue();
            if (this.f37802i) {
                StorySlideAutoSwitchTimer storySlideAutoSwitchTimer2 = this.f37813t;
                if (storySlideAutoSwitchTimer2 == null) {
                    this.f37813t = Q(longValue);
                    return;
                }
                boolean z7 = false;
                if (storySlideAutoSwitchTimer2 != null && !storySlideAutoSwitchTimer2.i()) {
                    z7 = true;
                }
                if (z7 && (storySlideAutoSwitchTimer = this.f37813t) != null) {
                    storySlideAutoSwitchTimer.k();
                    return;
                }
                return;
            }
            return;
        }
        ((StoryProgressView) k(R$id.f37453u)).g(this.f37806m, 1.0f);
    }

    private final void S(View view) {
        int i8;
        int i9;
        int i10 = R$id.f37441b;
        ProgressBar progressBar = (ProgressBar) k(i10);
        int i11 = 0;
        if (Intrinsics.a(view, (ProgressBar) k(i10))) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        progressBar.setVisibility(i8);
        int i12 = R$id.f37449m;
        StorySlideView storySlideView = (StorySlideView) k(i12);
        if (Intrinsics.a(view, (StorySlideView) k(i12))) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        storySlideView.setVisibility(i9);
        int i13 = R$id.storyErrorContent;
        View k8 = k(i13);
        if (!Intrinsics.a(view, k(i13))) {
            i11 = 8;
        }
        k8.setVisibility(i11);
    }

    private final StorySlide getCurrentSlide() {
        List<StorySlide> b8;
        Story story = this.f37807n;
        if (story == null || (b8 = story.b()) == null || this.f37806m == -1) {
            return null;
        }
        int size = b8.size();
        int i8 = this.f37806m;
        if (size <= i8) {
            return null;
        }
        return b8.get(i8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void p() {
        ((StorySlideView) k(R$id.f37449m)).setListener(this);
        s();
        int i8 = R$id.f37452p;
        ((ImageView) k(i8)).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.android.stories.widget.story.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryView.q(StoryView.this, view);
            }
        });
        final GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: eu.bolt.android.stories.widget.story.StoryView$bindViews$closeGestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e8) {
                Intrinsics.f(e8, "e");
                ((ImageView) StoryView.this.k(R$id.f37452p)).performClick();
                return true;
            }
        });
        ((ImageView) k(i8)).setOnTouchListener(new View.OnTouchListener() { // from class: eu.bolt.android.stories.widget.story.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r7;
                r7 = StoryView.r(GestureDetectorCompat.this, view, motionEvent);
                return r7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(StoryView this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f37804k = StoryAnalyticListener.CloseReason.CLOSE_BUTTON;
        this$0.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(GestureDetectorCompat closeGestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.f(closeGestureDetector, "$closeGestureDetector");
        view.getParent().requestDisallowInterceptTouchEvent(true);
        closeGestureDetector.a(motionEvent);
        return true;
    }

    private final void s() {
        final float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.f37429c);
        int i8 = R$id.f37444f;
        ((MaterialCardView) k(i8)).setShapeAppearanceModel(((MaterialCardView) k(i8)).getShapeAppearanceModel().v().E(dimensionPixelSize).A(dimensionPixelSize).s(0.0f).w(0.0f).m());
        ((MaterialCardView) k(i8)).setOutlineProvider(new ViewOutlineProvider() { // from class: eu.bolt.android.stories.widget.story.StoryView$buildBackgroundCardView$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.f(view, "view");
                Intrinsics.f(outline, "outline");
                int width = view.getWidth();
                float f8 = dimensionPixelSize;
                outline.setRoundRect(0, 0, width, (int) (view.getHeight() + f8), f8);
            }
        });
        ((MaterialCardView) k(i8)).setClipToOutline(true);
    }

    private final void t() {
        ((StorySlideView) k(R$id.f37449m)).B();
        StorySlideAutoSwitchTimer storySlideAutoSwitchTimer = this.f37813t;
        if (storySlideAutoSwitchTimer != null) {
            storySlideAutoSwitchTimer.f();
        }
        this.f37813t = null;
    }

    private final void u() {
        F();
        StoryListener storyListener = this.f37799f;
        if (storyListener != null) {
            storyListener.e();
        }
    }

    private final Function1<Boolean, Unit> v() {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        final Drawable mutate;
        final ImageView imageView = (ImageView) k(R$id.f37452p);
        int color = ContextCompat.getColor(imageView.getContext(), R$color.f37421b);
        int color2 = ContextCompat.getColor(imageView.getContext(), R$color.f37420a);
        final Drawable b8 = AppCompatResources.b(imageView.getContext(), R$drawable.f37439g);
        if (b8 != null && (constantState = b8.getConstantState()) != null && (newDrawable = constantState.newDrawable()) != null && (mutate = newDrawable.mutate()) != null) {
            b8.setTint(color2);
            mutate.setTint(color);
            final Drawable b9 = AppCompatResources.b(imageView.getContext(), R$drawable.f37438f);
            final Drawable b10 = AppCompatResources.b(imageView.getContext(), R$drawable.f37437e);
            return new Function1<Boolean, Unit>() { // from class: eu.bolt.android.stories.widget.story.StoryView$createSetCloseStoryButtonForDarkContent$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(boolean z7) {
                    Drawable drawable;
                    Drawable drawable2;
                    ImageView imageView2 = (ImageView) imageView.findViewById(R$id.f37452p);
                    if (z7) {
                        drawable = mutate;
                    } else {
                        drawable = b8;
                    }
                    imageView2.setImageDrawable(drawable);
                    ImageView imageView3 = imageView;
                    if (z7) {
                        drawable2 = b9;
                    } else {
                        drawable2 = b10;
                    }
                    imageView3.setBackground(drawable2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    b(bool.booleanValue());
                    return Unit.f50853a;
                }
            };
        }
        return new Function1<Boolean, Unit>() { // from class: eu.bolt.android.stories.widget.story.StoryView$createSetCloseStoryButtonForDarkContent$1$darkModeIconDrawable$1
            public final void b(boolean z7) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool.booleanValue());
                return Unit.f50853a;
            }
        };
    }

    private final boolean w(MotionEvent motionEvent) {
        if (this.f37808o > ((float) Math.hypot(this.f37809p - motionEvent.getX(), this.f37810q - motionEvent.getY()))) {
            return true;
        }
        this.f37811r = true;
        return false;
    }

    private final boolean x(MotionEvent motionEvent) {
        this.f37811r = false;
        this.f37809p = motionEvent.getX();
        this.f37810q = motionEvent.getY();
        this.f37812s = SystemClock.elapsedRealtime();
        StorySlideAutoSwitchTimer storySlideAutoSwitchTimer = this.f37813t;
        if (storySlideAutoSwitchTimer != null) {
            storySlideAutoSwitchTimer.j();
        }
        StorySlideView storySlideView = (StorySlideView) k(R$id.f37449m);
        if (storySlideView != null) {
            storySlideView.F();
            return true;
        }
        return true;
    }

    private final boolean y(MotionEvent motionEvent) {
        if (this.f37811r) {
            if (ViewExtKt.b(this, motionEvent, this.f37809p, this.f37810q)) {
                this.f37804k = StoryAnalyticListener.CloseReason.SWIPE_DOWN;
                u();
                return true;
            }
            StorySlideAutoSwitchTimer storySlideAutoSwitchTimer = this.f37813t;
            if (storySlideAutoSwitchTimer != null) {
                storySlideAutoSwitchTimer.k();
            }
            StorySlideView storySlideView = (StorySlideView) k(R$id.f37449m);
            if (storySlideView != null) {
                storySlideView.G();
            }
            return false;
        }
        if (B()) {
            G();
            if (H(motionEvent)) {
                L();
            } else {
                K(SlideSwitchReason.SLIDE_TAP);
            }
        } else {
            StorySlideAutoSwitchTimer storySlideAutoSwitchTimer2 = this.f37813t;
            if (storySlideAutoSwitchTimer2 != null) {
                storySlideAutoSwitchTimer2.k();
            }
            StorySlideView storySlideView2 = (StorySlideView) k(R$id.f37449m);
            if (storySlideView2 != null) {
                storySlideView2.G();
            }
        }
        return true;
    }

    private final boolean z(int i8) {
        if (ColorUtils.c(i8) < 0.5d) {
            return true;
        }
        return false;
    }

    public final boolean A() {
        return this.f37802i;
    }

    public final void C() {
        if (this.f37801h) {
            return;
        }
        D();
        ((StorySlideView) k(R$id.f37449m)).E();
        StorySlideAutoSwitchTimer storySlideAutoSwitchTimer = this.f37813t;
        if (storySlideAutoSwitchTimer != null) {
            storySlideAutoSwitchTimer.f();
        }
        this.f37813t = null;
        this.f37801h = true;
        F();
    }

    public final void D() {
        if (!this.f37802i) {
            return;
        }
        ((StorySlideView) k(R$id.f37449m)).F();
        StorySlideAutoSwitchTimer storySlideAutoSwitchTimer = this.f37813t;
        if (storySlideAutoSwitchTimer != null) {
            storySlideAutoSwitchTimer.j();
        }
        this.f37802i = false;
    }

    public final void E() {
        int m8;
        StoryListener storyListener;
        if (this.f37802i) {
            return;
        }
        ((StorySlideView) k(R$id.f37449m)).G();
        Story story = this.f37807n;
        if (story != null && (storyListener = this.f37799f) != null) {
            storyListener.m(story);
        }
        this.f37802i = true;
        this.f37801h = false;
        Story story2 = this.f37807n;
        if (story2 != null) {
            int i8 = this.f37806m;
            m8 = CollectionsKt__CollectionsKt.m(story2.b());
            if (i8 == m8) {
                this.f37803j = true;
            }
            R(story2.b().get(this.f37806m));
        }
    }

    public final void I(final Function1<? super String, Unit> tryAgain) {
        Intrinsics.f(tryAgain, "tryAgain");
        this.f37805l.invoke(Boolean.FALSE);
        int i8 = R$id.storyErrorContent;
        if (k(i8).getVisibility() != 0) {
            View storyErrorContent = k(i8);
            Intrinsics.e(storyErrorContent, "storyErrorContent");
            P(storyErrorContent);
        }
        View storyErrorContent2 = k(i8);
        Intrinsics.e(storyErrorContent2, "storyErrorContent");
        S(storyErrorContent2);
        ((StoryProgressView) k(R$id.f37453u)).g(this.f37806m, 0.0f);
        StorySlideAutoSwitchTimer storySlideAutoSwitchTimer = this.f37813t;
        if (storySlideAutoSwitchTimer != null) {
            storySlideAutoSwitchTimer.j();
        }
        ((StoryButton) k(R$id.storyErrorButton)).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.android.stories.widget.story.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryView.J(StoryView.this, tryAgain, view);
            }
        });
    }

    public final void O(Story story) {
        Intrinsics.f(story, "story");
        StorySlideView slideView = (StorySlideView) k(R$id.f37449m);
        Intrinsics.e(slideView, "slideView");
        S(slideView);
        this.f37807n = story;
        StoryAnalyticListener storyAnalyticListener = this.f37800g;
        if (storyAnalyticListener != null) {
            storyAnalyticListener.d(story.a());
        }
        N(0);
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideAssetListener
    public void a(StorySlideAsset storySlideAsset, SlideAssetNotLoadedException exception) {
        Intrinsics.f(exception, "exception");
        I(new Function1<String, Unit>() { // from class: eu.bolt.android.stories.widget.story.StoryView$onAssetLoadFailed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                int i8;
                StoryView storyView = StoryView.this;
                i8 = storyView.f37806m;
                storyView.N(i8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideScrollListener
    public void b(MotionEvent event) {
        Intrinsics.f(event, "event");
        onTouchEvent(event);
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideAssetListener
    public void c(StorySlideAsset storySlideAsset) {
        Kalev.d("Loaded: " + storySlideAsset);
        if (((StorySlideView) k(R$id.f37449m)).getVisibility() != 0) {
            N(this.f37806m);
        }
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideButtonClickListener
    public void d(StorySlide slide, ProgressController progressController) {
        StoryButtonType storyButtonType;
        int i8;
        Intrinsics.f(slide, "slide");
        Intrinsics.f(progressController, "progressController");
        Story story = this.f37807n;
        if (story == null) {
            return;
        }
        StorySlide storySlide = story.b().get(this.f37806m);
        if (!Intrinsics.a(slide, storySlide)) {
            Kalev.d("Slide view contains different slide model than currently selected:\ncurrent slide=" + storySlide + "\nview model=" + slide);
        }
        StorySlideButton c8 = slide.c();
        if (c8 != null) {
            storyButtonType = c8.d();
        } else {
            storyButtonType = null;
        }
        if (storyButtonType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f37819a[storyButtonType.ordinal()];
        }
        if (i8 != -1) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        StoryAnalyticListener storyAnalyticListener = this.f37800g;
                        if (storyAnalyticListener != null) {
                            storyAnalyticListener.a(StoryAnalyticListener.ActionType.CLOSE, story.a(), storySlide.d());
                        }
                        u();
                        return;
                    }
                    return;
                }
                StoryAnalyticListener storyAnalyticListener2 = this.f37800g;
                if (storyAnalyticListener2 != null) {
                    storyAnalyticListener2.a(StoryAnalyticListener.ActionType.SHARE, story.a(), storySlide.d());
                    return;
                }
                return;
            }
            StoryAnalyticListener storyAnalyticListener3 = this.f37800g;
            if (storyAnalyticListener3 != null) {
                storyAnalyticListener3.a(StoryAnalyticListener.ActionType.LINK, story.a(), storySlide.d());
            }
            this.f37804k = StoryAnalyticListener.CloseReason.DEEPLINK;
            u();
            String a8 = slide.c().a();
            if (a8 != null) {
                CustomTabLauncher customTabLauncher = CustomTabLauncher.f37613a;
                Context context = getContext();
                Intrinsics.e(context, "context");
                CustomTabLauncher.b(customTabLauncher, context, a8, 0, null, new Function1<Exception, Unit>() { // from class: eu.bolt.android.stories.widget.story.StoryView$onSlideButtonTap$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void b(Exception exception) {
                        StoryListener storyListener;
                        Intrinsics.f(exception, "exception");
                        storyListener = StoryView.this.f37799f;
                        if (storyListener != null) {
                            storyListener.a(exception);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                        b(exc);
                        return Unit.f50853a;
                    }
                }, 12, null);
                return;
            }
            return;
        }
        K(SlideSwitchReason.ERROR);
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideAssetListener
    public void e(StorySlideAsset storySlideAsset) {
        Kalev.d("Loading: " + storySlideAsset);
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideScrollListener
    public void f(MotionEvent event) {
        Intrinsics.f(event, "event");
        onTouchEvent(event);
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideScrollListener
    public void g(MotionEvent event) {
        Intrinsics.f(event, "event");
        onTouchEvent(event);
    }

    public View k(int i8) {
        Map<Integer, View> map = this.f37814u;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        C();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.f(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                return w(event);
            }
            return y(event);
        }
        return x(event);
    }

    public final void setStoryAnalyticListener(StoryAnalyticListener storyAnalyticListener) {
        Intrinsics.f(storyAnalyticListener, "storyAnalyticListener");
        this.f37800g = storyAnalyticListener;
    }

    public final void setStoryListener(StoryListener storyListener) {
        Intrinsics.f(storyListener, "storyListener");
        this.f37799f = storyListener;
    }

    public /* synthetic */ StoryView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
