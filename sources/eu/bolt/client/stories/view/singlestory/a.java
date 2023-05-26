package eu.bolt.client.stories.view.singlestory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.transition.TransitionManager;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.transition.MaterialFadeThrough;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.stories.view.storyprogress.StoryProgressView;
import eu.bolt.client.stories.view.storyslide.StorySlideView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$string;
import eu.bolt.verification.sdk.internal.bi;
import eu.bolt.verification.sdk.internal.cj;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.ik;
import eu.bolt.verification.sdk.internal.jf;
import eu.bolt.verification.sdk.internal.jh;
import eu.bolt.verification.sdk.internal.ki;
import eu.bolt.verification.sdk.internal.li;
import eu.bolt.verification.sdk.internal.q;
import eu.bolt.verification.sdk.internal.qa;
import eu.bolt.verification.sdk.internal.rj;
import eu.bolt.verification.sdk.internal.s;
import eu.bolt.verification.sdk.internal.sj;
import eu.bolt.verification.sdk.internal.tj;
import eu.bolt.verification.sdk.internal.u9;
import eu.bolt.verification.sdk.internal.ug;
import eu.bolt.verification.sdk.internal.ui;
import eu.bolt.verification.sdk.internal.uq;
import eu.bolt.verification.sdk.internal.v9;
import eu.bolt.verification.sdk.internal.vh;
import eu.bolt.verification.sdk.internal.wq;
import eu.bolt.verification.sdk.internal.xg;
import eu.bolt.verification.sdk.internal.xj;
import eu.bolt.verification.sdk.internal.xl;
import eu.bolt.verification.sdk.internal.yj;
import eu.bolt.verification.sdk.internal.z1;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class a extends FrameLayout implements ik {
    public static final C0027a B = new C0027a(null);
    private final wq A;
    @Inject

    /* renamed from: f */
    public bi f40268f;
    @Inject

    /* renamed from: g */
    public xg f40269g;
    @Inject

    /* renamed from: h */
    public rj f40270h;
    @Inject

    /* renamed from: i */
    public s f40271i;

    /* renamed from: j */
    private String f40272j;

    /* renamed from: k */
    private ki f40273k;

    /* renamed from: l */
    private int f40274l;

    /* renamed from: m */
    private cj f40275m;

    /* renamed from: n */
    private xj f40276n;

    /* renamed from: o */
    private boolean f40277o;

    /* renamed from: p */
    private boolean f40278p;

    /* renamed from: q */
    private boolean f40279q;

    /* renamed from: r */
    private boolean f40280r;

    /* renamed from: s */
    private final Set<Integer> f40281s;

    /* renamed from: t */
    private Disposable f40282t;

    /* renamed from: u */
    private Throwable f40283u;

    /* renamed from: v */
    private Disposable f40284v;

    /* renamed from: w */
    private final Handler f40285w;

    /* renamed from: x */
    private final Runnable f40286x;

    /* renamed from: y */
    private q.b.a f40287y;

    /* renamed from: z */
    private final Function1<Boolean, Unit> f40288z;

    /* renamed from: eu.bolt.client.stories.view.singlestory.a$a */
    /* loaded from: classes5.dex */
    public static final class C0027a {
        private C0027a() {
        }

        public /* synthetic */ C0027a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        TIMER,
        SLIDE_TAP,
        ERROR
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f40293a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f40294b;

        static {
            int[] iArr = new int[ui.values().length];
            try {
                iArr[ui.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ui.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ui.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f40293a = iArr;
            int[] iArr2 = new int[b.values().length];
            try {
                iArr2[b.TIMER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[b.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[b.SLIDE_TAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f40294b = iArr2;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends qa {
        d() {
            a.this = r1;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e8) {
            Intrinsics.f(e8, "e");
            a.this.getBinding().f45591g.performClick();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements v9 {

        /* renamed from: a */
        final /* synthetic */ tj.a f40296a;

        /* renamed from: b */
        final /* synthetic */ int f40297b;

        e(tj.a aVar, int i8) {
            this.f40296a = aVar;
            this.f40297b = i8;
        }

        @Override // eu.bolt.verification.sdk.internal.v9
        public void a(Throwable error) {
            Intrinsics.f(error, "error");
            Timber.Forest forest = Timber.f53064a;
            String b8 = this.f40296a.b();
            int i8 = this.f40297b;
            forest.h("Drawable: failed to cache " + b8 + ", index= " + i8, new Object[0]);
        }

        @Override // eu.bolt.verification.sdk.internal.v9
        public void b(Drawable image) {
            Intrinsics.f(image, "image");
            Timber.Forest forest = Timber.f53064a;
            String b8 = this.f40296a.b();
            int i8 = this.f40297b;
            forest.h("Drawable: cached " + b8 + ", index= " + i8, new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends ViewOutlineProvider {

        /* renamed from: a */
        final /* synthetic */ float f40298a;

        f(float f8) {
            this.f40298a = f8;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.f(view, "view");
            Intrinsics.f(outline, "outline");
            int width = view.getWidth();
            float f8 = this.f40298a;
            outline.setRoundRect(0, 0, width, (int) (view.getHeight() + f8), f8);
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends Lambda implements Function1<Float, Unit> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g() {
            super(1);
            a.this = r1;
        }

        public final void b(float f8) {
            a.this.getBinding().f45592h.b(a.this.f40274l, f8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Float f8) {
            b(f8.floatValue());
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends Lambda implements Function0<Unit> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h() {
            super(0);
            a.this = r1;
        }

        public final void b() {
            a.this.s(b.TIMER);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class i extends Lambda implements Function1<Boolean, Unit> {

        /* renamed from: g */
        final /* synthetic */ Drawable f40302g;

        /* renamed from: h */
        final /* synthetic */ Drawable f40303h;

        /* renamed from: i */
        final /* synthetic */ DesignImageView f40304i;

        /* renamed from: j */
        final /* synthetic */ Drawable f40305j;

        /* renamed from: k */
        final /* synthetic */ Drawable f40306k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Drawable drawable, Drawable drawable2, DesignImageView designImageView, Drawable drawable3, Drawable drawable4) {
            super(1);
            a.this = r1;
            this.f40302g = drawable;
            this.f40303h = drawable2;
            this.f40304i = designImageView;
            this.f40305j = drawable3;
            this.f40306k = drawable4;
        }

        public final void b(boolean z7) {
            a.this.getBinding().f45591g.setImageDrawable(z7 ? this.f40302g : this.f40303h);
            this.f40304i.setBackground(z7 ? this.f40305j : this.f40306k);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            b(bool.booleanValue());
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class j extends Lambda implements Function1<Boolean, Unit> {

        /* renamed from: f */
        public static final j f40307f = new j();

        j() {
            super(1);
        }

        public final void b(boolean z7) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            b(bool.booleanValue());
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class k extends Lambda implements Function1<ki, Unit> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k() {
            super(1);
            a.this = r1;
        }

        public final void b(ki story) {
            a aVar = a.this;
            Intrinsics.e(story, "story");
            aVar.z(story);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ki kiVar) {
            b(kiVar);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class l extends Lambda implements Function1<Throwable, Unit> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l() {
            super(1);
            a.this = r1;
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            a.this.G(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class m extends Lambda implements Function1<Disposable, Unit> {

        /* renamed from: f */
        final /* synthetic */ jf f40310f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(jf jfVar) {
            super(1);
            this.f40310f = jfVar;
        }

        public final void b(Disposable disposable) {
            this.f40310f.a();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
            b(disposable);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class n extends Lambda implements Function1<Throwable, Unit> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n() {
            super(1);
            a.this = r1;
        }

        public final void b(Throwable it) {
            Intrinsics.f(it, "it");
            Timber.f53064a.c(it, "Failed to share story", new Object[0]);
            Context context = a.this.getContext();
            li liVar = context instanceof li ? (li) context : null;
            if (liVar != null) {
                liVar.a();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            b(th);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f40274l = -1;
        this.f40281s = new LinkedHashSet();
        Disposable a8 = Disposables.a();
        Intrinsics.e(a8, "disposed()");
        this.f40282t = a8;
        Disposable a9 = Disposables.a();
        Intrinsics.e(a9, "disposed()");
        this.f40284v = a9;
        this.f40285w = new Handler(Looper.getMainLooper());
        this.f40286x = new Runnable() { // from class: eu.bolt.client.stories.view.singlestory.b
            @Override // java.lang.Runnable
            public final void run() {
                a.N(a.this);
            }
        };
        this.f40287y = q.b.a.BACK_BUTTON;
        wq a10 = wq.a(uq.Y(this), this);
        Intrinsics.e(a10, "inflate(inflater(), this)");
        this.A = a10;
        vh.f45453c.b().a(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        L();
        T();
        this.f40288z = U();
    }

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void A(sj sjVar) {
        xj xjVar;
        Long b8 = sjVar.b();
        if (b8 == null) {
            if (this.f40279q) {
                this.A.f45592h.b(this.f40274l, 1.0f);
                return;
            }
            return;
        }
        long longValue = b8.longValue();
        if (this.f40277o && this.f40279q) {
            xj xjVar2 = this.f40276n;
            if (xjVar2 == null) {
                xj p8 = p(longValue);
                p8.l();
                this.f40276n = p8;
                return;
            }
            if (!(!xjVar2.i()) || (xjVar = this.f40276n) == null) {
                return;
            }
            xjVar.k();
        }
    }

    private final void B(tj.a aVar, int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        u9.b(context, aVar.b(), new e(aVar, i8));
    }

    private final void C(final tj.b bVar, final int i8) {
        LottieCompositionFactory.w(getContext(), bVar.b()).d(new LottieListener() { // from class: eu.bolt.client.stories.view.singlestory.c
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                a.D(tj.b.this, i8, (LottieComposition) obj);
            }
        }).c(new LottieListener() { // from class: eu.bolt.client.stories.view.singlestory.d
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                a.E(tj.b.this, i8, (Throwable) obj);
            }
        });
    }

    public static final void D(tj.b slideAsset, int i8, LottieComposition lottieComposition) {
        Intrinsics.f(slideAsset, "$slideAsset");
        Timber.Forest forest = Timber.f53064a;
        String b8 = slideAsset.b();
        forest.h("Lottie: cached " + b8 + " index= " + i8, new Object[0]);
    }

    public static final void E(tj.b slideAsset, int i8, Throwable th) {
        Intrinsics.f(slideAsset, "$slideAsset");
        Timber.Forest forest = Timber.f53064a;
        String b8 = slideAsset.b();
        forest.h("Lottie: failed to cache " + b8 + ", index= " + i8, new Object[0]);
    }

    public final void G(final Throwable th) {
        cj cjVar;
        this.f40288z.invoke(Boolean.FALSE);
        Q();
        Timber.f53064a.b(th);
        this.f40283u = th;
        wq wqVar = this.A;
        ConstraintLayout root = wqVar.f45586b.getRoot();
        Intrinsics.e(root, "errorContent.root");
        if (!(root.getVisibility() == 0)) {
            ConstraintLayout root2 = wqVar.f45586b.getRoot();
            Intrinsics.e(root2, "errorContent.root");
            r(root2);
        }
        ConstraintLayout root3 = wqVar.f45586b.getRoot();
        Intrinsics.e(root3, "errorContent.root");
        M(root3);
        wqVar.f45586b.f45698d.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.client.stories.view.singlestory.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.H(th, this, view);
            }
        });
        String str = this.f40272j;
        if (str == null || (cjVar = this.f40275m) == null) {
            return;
        }
        cjVar.l(str, th);
    }

    public static final void H(Throwable exception, a this$0, View view) {
        Intrinsics.f(exception, "$exception");
        Intrinsics.f(this$0, "this$0");
        if (exception instanceof jh) {
            this$0.setSlideWithIndex(this$0.f40274l);
        } else {
            this$0.X();
        }
    }

    private final void I(List<? extends tj> list, int i8) {
        for (tj tjVar : list) {
            if (tjVar instanceof tj.b) {
                C((tj.b) tjVar, i8);
            } else if (tjVar instanceof tj.a) {
                B((tj.a) tjVar, i8);
            }
        }
    }

    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final boolean K(GestureDetectorCompat closeGestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.f(closeGestureDetector, "$closeGestureDetector");
        view.getParent().requestDisallowInterceptTouchEvent(true);
        closeGestureDetector.a(motionEvent);
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void L() {
        this.A.f45590f.setListener(this);
        this.A.f45591g.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.client.stories.view.singlestory.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.t(a.this, view);
            }
        });
        final GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), new d());
        this.A.f45591g.setOnTouchListener(new View.OnTouchListener() { // from class: eu.bolt.client.stories.view.singlestory.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean K;
                K = a.K(GestureDetectorCompat.this, view, motionEvent);
                return K;
            }
        });
    }

    private final void M(View view) {
        ProgressBar progressBar = this.A.f45587c;
        Intrinsics.e(progressBar, "binding.loading");
        progressBar.setVisibility(this.A.f45587c == view ? 0 : 8);
        ConstraintLayout root = this.A.f45586b.getRoot();
        Intrinsics.e(root, "binding.errorContent.root");
        root.setVisibility(this.A.f45586b.getRoot() == view ? 0 : 8);
        StorySlideView storySlideView = this.A.f45590f;
        Intrinsics.e(storySlideView, "binding.slideView");
        storySlideView.setVisibility(this.A.f45590f == view ? 0 : 8);
    }

    public static final void N(a this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.d0();
    }

    private final boolean O(PointF pointF) {
        boolean Z = uq.Z(this);
        float f8 = pointF.x;
        return Z ? f8 >= ((float) ((getMeasuredWidth() * 2) / 3)) : f8 < ((float) (getMeasuredWidth() / 3));
    }

    private final void P() {
        this.f40284v.dispose();
        this.A.f45590f.C();
        xj xjVar = this.f40276n;
        if (xjVar != null) {
            xjVar.g();
        }
        this.f40276n = null;
        this.f40279q = false;
    }

    private final void Q() {
        this.f40285w.removeCallbacks(this.f40286x);
    }

    private final void R() {
        P();
        this.f40282t.dispose();
        this.f40280r = false;
        this.f40281s.clear();
        this.f40272j = null;
        this.f40273k = null;
        this.f40274l = -1;
    }

    private final void S() {
        cj cjVar;
        String str = this.f40272j;
        if (str == null || (cjVar = this.f40275m) == null) {
            return;
        }
        cjVar.k(str, this.f40283u);
    }

    private final void T() {
        wq wqVar = this.A;
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.f41701j);
        ShapeAppearanceModel m8 = wqVar.f45588d.getShapeAppearanceModel().v().E(dimensionPixelSize).A(dimensionPixelSize).s(0.0f).w(0.0f).m();
        Intrinsics.e(m8, "slideCard.shapeAppearanc…\n                .build()");
        wqVar.f45588d.setShapeAppearanceModel(m8);
        wqVar.f45588d.setOutlineProvider(new f(dimensionPixelSize));
        wqVar.f45588d.setClipToOutline(true);
    }

    private final Function1<Boolean, Unit> U() {
        Drawable newDrawable;
        Drawable mutate;
        DesignImageView designImageView = this.A.f45591g;
        Context context = designImageView.getContext();
        Intrinsics.e(context, "context");
        int b8 = f2.b(context, R$color.f41694m);
        Context context2 = designImageView.getContext();
        Intrinsics.e(context2, "context");
        int b9 = f2.b(context2, R$color.f41693j);
        Context context3 = designImageView.getContext();
        Intrinsics.e(context3, "context");
        Drawable o8 = f2.o(context3, R$drawable.f41709k4);
        Drawable.ConstantState constantState = o8.getConstantState();
        if (constantState == null || (newDrawable = constantState.newDrawable()) == null || (mutate = newDrawable.mutate()) == null) {
            return j.f40307f;
        }
        o8.setTint(b9);
        mutate.setTint(b8);
        Context context4 = designImageView.getContext();
        Intrinsics.e(context4, "context");
        Drawable o9 = f2.o(context4, R$drawable.f41711u);
        Context context5 = designImageView.getContext();
        Intrinsics.e(context5, "context");
        return new i(mutate, o8, designImageView, o9, f2.o(context5, R$drawable.f41710t));
    }

    private final void V() {
        ki kiVar = this.f40273k;
        if (kiVar == null) {
            return;
        }
        int i8 = this.f40274l - 1;
        if (i8 >= 0) {
            setSlideWithIndex(i8);
            return;
        }
        cj cjVar = this.f40275m;
        if (cjVar != null) {
            cjVar.j(kiVar.a());
        }
    }

    private final void X() {
        String str = this.f40272j;
        if (str == null) {
            return;
        }
        c0();
        Observable<ki> observeOn = getStoriesRepository().g(str).observeOn(getRxSchedulers().c());
        Intrinsics.e(observeOn, "storiesRepository.observ…erveOn(rxSchedulers.main)");
        this.f40282t = ug.r(observeOn, new k(), new l(), null, null, null, 28, null);
    }

    private final void c0() {
        Q();
        this.f40285w.postDelayed(this.f40286x, 300L);
    }

    private final void d0() {
        wq wqVar = this.A;
        ProgressBar loading = wqVar.f45587c;
        Intrinsics.e(loading, "loading");
        if (loading.getVisibility() == 0) {
            return;
        }
        ProgressBar loading2 = wqVar.f45587c;
        Intrinsics.e(loading2, "loading");
        r(loading2);
        ProgressBar loading3 = wqVar.f45587c;
        Intrinsics.e(loading3, "loading");
        M(loading3);
        this.f40283u = null;
    }

    private final void e0() {
        cj cjVar;
        wq wqVar = this.A;
        Q();
        StorySlideView slideView = wqVar.f45590f;
        Intrinsics.e(slideView, "slideView");
        if (slideView.getVisibility() == 0) {
            return;
        }
        StorySlideView slideView2 = wqVar.f45590f;
        Intrinsics.e(slideView2, "slideView");
        r(slideView2);
        StorySlideView slideView3 = wqVar.f45590f;
        Intrinsics.e(slideView3, "slideView");
        M(slideView3);
        this.f40283u = null;
        String str = this.f40272j;
        if (str == null || (cjVar = this.f40275m) == null) {
            return;
        }
        cj.a.b(cjVar, str, null, 2, null);
    }

    private final sj getCurrentSlide() {
        List<sj> b8;
        ki kiVar = this.f40273k;
        if (kiVar == null || (b8 = kiVar.b()) == null || this.f40274l == -1) {
            return null;
        }
        int size = b8.size();
        int i8 = this.f40274l;
        if (size > i8) {
            return b8.get(i8);
        }
        return null;
    }

    private final xj p(long j8) {
        return new xj(j8, new g(), new h());
    }

    private final void q(int i8, List<? extends sj> list) {
        if (i8 >= list.size() || this.f40281s.contains(Integer.valueOf(i8))) {
            return;
        }
        this.f40281s.add(Integer.valueOf(i8));
        I(list.get(i8).f(), i8);
    }

    private final void r(View view) {
        MaterialFadeThrough materialFadeThrough = new MaterialFadeThrough();
        materialFadeThrough.c0(400L);
        materialFadeThrough.c(view);
        TransitionManager.b(this, materialFadeThrough);
    }

    public final void s(b bVar) {
        q.b.a aVar;
        ki kiVar = this.f40273k;
        if (kiVar == null) {
            return;
        }
        int i8 = this.f40274l + 1;
        if (i8 < kiVar.b().size()) {
            setSlideWithIndex(i8);
            return;
        }
        int i9 = c.f40294b[bVar.ordinal()];
        if (i9 == 1) {
            aVar = q.b.a.AUTO;
        } else if (i9 == 2) {
            aVar = q.b.a.ERROR;
        } else if (i9 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            aVar = q.b.a.LAST_SLIDE_TAP;
        }
        this.f40287y = aVar;
        cj cjVar = this.f40275m;
        if (cjVar != null) {
            cjVar.i(kiVar.a());
        }
    }

    private final void setSlideWithIndex(int i8) {
        StoryProgressView storyProgressView;
        int i9;
        float f8;
        ki kiVar = this.f40273k;
        if (kiVar == null) {
            return;
        }
        P();
        this.f40274l = i8;
        sj sjVar = kiVar.b().get(this.f40274l);
        this.A.f45590f.setSlide(sjVar);
        if (kiVar.b().size() == 1 && sjVar.b() == null) {
            StoryProgressView storyProgressView2 = this.A.f45592h;
            Intrinsics.e(storyProgressView2, "binding.storyProgress");
            storyProgressView2.setVisibility(8);
        } else {
            if (sjVar.b() == null) {
                storyProgressView = this.A.f45592h;
                i9 = this.f40274l;
                f8 = 1.0f;
            } else {
                storyProgressView = this.A.f45592h;
                i9 = this.f40274l;
                f8 = 0.0f;
            }
            storyProgressView.b(i9, f8);
        }
        if (this.f40277o) {
            this.A.f45590f.K();
            A(sjVar);
        }
        q(i8 + 1, kiVar.b());
        cj cjVar = this.f40275m;
        if (cjVar != null) {
            cjVar.f(sjVar.e());
        }
        this.f40288z.invoke(Boolean.valueOf(z1.b(sjVar.c())));
    }

    public static final void t(a this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f40287y = q.b.a.CLOSE_BUTTON;
        this$0.S();
    }

    public static /* synthetic */ void w(a aVar, String str, boolean z7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStoryId");
        }
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        aVar.F(str, z7);
    }

    public static final void y(jf progressController) {
        Intrinsics.f(progressController, "$progressController");
        progressController.b();
    }

    public final void z(ki kiVar) {
        this.f40273k = kiVar;
        int size = kiVar.b().size();
        if (size > 0) {
            this.A.f45592h.setSlidesCount(size);
            setSlideWithIndex(0);
            return;
        }
        cj cjVar = this.f40275m;
        if (cjVar != null) {
            cjVar.l(kiVar.a(), new xl());
        }
    }

    public final void F(String storyId, boolean z7) {
        cj cjVar;
        Intrinsics.f(storyId, "storyId");
        if (!Intrinsics.a(storyId, this.f40272j) || z7) {
            R();
            this.f40272j = storyId;
            if (this.f40277o && (cjVar = this.f40275m) != null) {
                cjVar.c(storyId);
            }
            X();
        }
    }

    public final boolean W() {
        return this.f40277o;
    }

    public final void Y() {
        sj currentSlide;
        if (this.f40278p) {
            return;
        }
        Z();
        this.f40278p = true;
        this.A.f45590f.H();
        xj xjVar = this.f40276n;
        if (xjVar != null) {
            xjVar.g();
        }
        this.f40276n = null;
        this.f40284v.dispose();
        this.f40282t.dispose();
        String str = this.f40272j;
        if (str == null || (currentSlide = getCurrentSlide()) == null) {
            return;
        }
        getAnalyticsManager().a(new q.b(str, this.f40280r, this.f40287y, currentSlide.e()));
    }

    public final void Z() {
        if (this.f40277o) {
            this.f40277o = false;
            this.A.f45590f.I();
            xj xjVar = this.f40276n;
            if (xjVar != null) {
                xjVar.j();
            }
        }
    }

    @Override // eu.bolt.verification.sdk.internal.ik
    public void a() {
        this.f40287y = q.b.a.SWIPE_DOWN;
        S();
    }

    public final void a0() {
        int m8;
        cj cjVar;
        if (this.f40277o) {
            return;
        }
        this.f40277o = true;
        this.f40278p = false;
        this.A.f45590f.K();
        String str = this.f40272j;
        if (str != null && (cjVar = this.f40275m) != null) {
            cjVar.c(str);
        }
        ki kiVar = this.f40273k;
        if (kiVar != null) {
            A(kiVar.b().get(this.f40274l));
            int i8 = this.f40274l;
            m8 = CollectionsKt__CollectionsKt.m(kiVar.b());
            if (i8 == m8) {
                this.f40280r = true;
            }
        }
    }

    @Override // eu.bolt.verification.sdk.internal.zj
    public void b(sj slide, final jf progressController) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(progressController, "progressController");
        ki kiVar = this.f40273k;
        if (kiVar == null) {
            return;
        }
        sj sjVar = kiVar.b().get(this.f40274l);
        if (!Intrinsics.a(slide, sjVar)) {
            Timber.Forest forest = Timber.f53064a;
            forest.a("Slide view contains different slide model than currently selected:\ncurrent slide=" + sjVar + "\nview model=" + slide, new Object[0]);
        }
        yj d8 = slide.d();
        Unit unit = null;
        ui f8 = d8 != null ? d8.f() : null;
        int i8 = f8 == null ? -1 : c.f40293a[f8.ordinal()];
        if (i8 == 1) {
            String a8 = slide.d().a();
            if (a8 != null) {
                this.f40287y = q.b.a.DEEPLINK;
                S();
                Context context = getContext();
                Intrinsics.e(context, "context");
                f2.g(context, a8, R$string.error_cant_open_link, 0, null, 12, null);
                unit = Unit.f50853a;
            }
            if (unit == null) {
                s(b.ERROR);
            }
            getAnalyticsManager().a(new q.d(kiVar.a(), slide.e()));
            return;
        }
        if (i8 == 2) {
            String a9 = slide.d().a();
            if (a9 != null) {
                getAnalyticsManager().a(new q.f(kiVar.a(), slide.e()));
                Completable z7 = getStoryShareHelper().e(kiVar.a(), slide.e(), a9, slide.d().c(), slide.d().b()).z(getRxSchedulers().c());
                final m mVar = new m(progressController);
                Completable m8 = z7.r(new Consumer() { // from class: eu.bolt.client.stories.view.singlestory.h
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        a.J(Function1.this, obj);
                    }
                }).m(new Action() { // from class: eu.bolt.client.stories.view.singlestory.i
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        a.y(jf.this);
                    }
                });
                Intrinsics.e(m8, "progressController: Prog…ntroller.hideProgress() }");
                this.f40284v = ug.p(m8, null, new n(), null, 5, null);
                unit = Unit.f50853a;
            }
            if (unit != null) {
                return;
            }
        } else if (i8 == 3) {
            S();
            return;
        }
        s(b.ERROR);
    }

    public final void b0() {
        Z();
        this.A.f45592h.b(this.f40274l, 0.0f);
        xj xjVar = this.f40276n;
        if (xjVar != null) {
            xjVar.g();
        }
        this.f40276n = null;
        this.f40284v.dispose();
    }

    @Override // eu.bolt.verification.sdk.internal.uj
    public void c(tj tjVar) {
        int m8;
        ki kiVar = this.f40273k;
        if (kiVar == null) {
            return;
        }
        this.f40279q = true;
        e0();
        A(kiVar.b().get(this.f40274l));
        int i8 = this.f40274l;
        m8 = CollectionsKt__CollectionsKt.m(kiVar.b());
        if (i8 == m8) {
            this.f40280r = true;
        }
        this.A.f45590f.J(kiVar.b().get(this.f40274l));
    }

    @Override // eu.bolt.verification.sdk.internal.uj
    public void d(tj tjVar) {
        c0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        xj xjVar;
        Intrinsics.f(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            xj xjVar2 = this.f40276n;
            if (xjVar2 != null) {
                xjVar2.j();
            }
        } else if (action == 1 && (xjVar = this.f40276n) != null) {
            xjVar.k();
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // eu.bolt.verification.sdk.internal.uj
    public void e(tj tjVar, jh exception) {
        Intrinsics.f(exception, "exception");
        G(exception);
    }

    @Override // eu.bolt.verification.sdk.internal.ik
    public void f(PointF at) {
        Intrinsics.f(at, "at");
        if (O(at)) {
            V();
        } else {
            s(b.SLIDE_TAP);
        }
    }

    public final s getAnalyticsManager() {
        s sVar = this.f40271i;
        if (sVar != null) {
            return sVar;
        }
        Intrinsics.w("analyticsManager");
        return null;
    }

    protected final wq getBinding() {
        return this.A;
    }

    public final xg getRxSchedulers() {
        xg xgVar = this.f40269g;
        if (xgVar != null) {
            return xgVar;
        }
        Intrinsics.w("rxSchedulers");
        return null;
    }

    public final bi getStoriesRepository() {
        bi biVar = this.f40268f;
        if (biVar != null) {
            return biVar;
        }
        Intrinsics.w("storiesRepository");
        return null;
    }

    public final rj getStoryShareHelper() {
        rj rjVar = this.f40270h;
        if (rjVar != null) {
            return rjVar;
        }
        Intrinsics.w("storyShareHelper");
        return null;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.f(event, "event");
        Timber.Forest forest = Timber.f53064a;
        forest.h("onTouch " + event, new Object[0]);
        int action = event.getAction();
        return action == 0 || action == 1 || action == 2;
    }

    public final void setAnalyticsManager(s sVar) {
        Intrinsics.f(sVar, "<set-?>");
        this.f40271i = sVar;
    }

    public final void setCloseButtonVisible(boolean z7) {
        DesignImageView designImageView = this.A.f45591g;
        Intrinsics.e(designImageView, "binding.storyClose");
        designImageView.setVisibility(z7 ? 0 : 8);
    }

    public final void setListener(cj storyListener) {
        Intrinsics.f(storyListener, "storyListener");
        this.f40275m = storyListener;
    }

    public final void setNavBarPaddings(int i8) {
        ConstraintLayout constraintLayout = this.A.f45589e;
        Intrinsics.e(constraintLayout, "binding.slideContent");
        uq.v(constraintLayout, 0, 0, 0, i8, 7, null);
        this.A.f45589e.invalidate();
    }

    public final void setRxSchedulers(xg xgVar) {
        Intrinsics.f(xgVar, "<set-?>");
        this.f40269g = xgVar;
    }

    public final void setStoriesRepository(bi biVar) {
        Intrinsics.f(biVar, "<set-?>");
        this.f40268f = biVar;
    }

    public final void setStoryShareHelper(rj rjVar) {
        Intrinsics.f(rjVar, "<set-?>");
        this.f40270h = rjVar;
    }
}
