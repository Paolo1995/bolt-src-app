package eu.bolt.android.stories.widget.slide.decorators;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.LottieAnimationView;
import eu.bolt.android.stories.R$dimen;
import eu.bolt.android.stories.R$id;
import eu.bolt.android.stories.R$layout;
import eu.bolt.android.stories.util.DimensKt;
import eu.bolt.android.stories.util.ViewExtKt;
import eu.bolt.android.stories.widget.helper.StoryButton;
import eu.bolt.android.stories.widget.slide.ARiderXKt;
import eu.bolt.android.stories.widget.slide.ScrollBasedElevationHelper;
import eu.bolt.android.stories.widget.slide.StoryAssetDimensions;
import eu.bolt.android.stories.widget.slide.StorySlide;
import eu.bolt.android.stories.widget.slide.StorySlideAsset;
import eu.bolt.android.stories.widget.slide.StorySlideButton;
import eu.bolt.android.stories.widget.slide.StorySlideContent;
import eu.bolt.android.stories.widget.slide.StorySlideListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;

/* compiled from: TopArrayContentWithFooterSlideDecorator.kt */
/* loaded from: classes5.dex */
public final class TopArrayContentWithFooterSlideDecorator extends StorySlideLayoutDecorator<StorySlide.ArrayContentWithFooter> {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f37763p = new Companion(null);

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup f37764h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f37765i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f37766j;

    /* renamed from: k  reason: collision with root package name */
    private NestedScrollView f37767k;

    /* renamed from: l  reason: collision with root package name */
    private Button f37768l;

    /* renamed from: m  reason: collision with root package name */
    private final LinkedHashMap<LottieAnimationView, StorySlideAsset> f37769m;

    /* renamed from: n  reason: collision with root package name */
    private final LinkedHashMap<View, ViewGroup.LayoutParams> f37770n;

    /* renamed from: o  reason: collision with root package name */
    private final ScrollBasedElevationHelper f37771o;

    /* compiled from: TopArrayContentWithFooterSlideDecorator.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TopArrayContentWithFooterSlideDecorator.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37772a;

        static {
            int[] iArr = new int[StorySlideContent.Align.values().length];
            try {
                iArr[StorySlideContent.Align.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StorySlideContent.Align.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StorySlideContent.Align.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f37772a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopArrayContentWithFooterSlideDecorator(StorySlideListener listener) {
        super(listener);
        Intrinsics.f(listener, "listener");
        this.f37769m = new LinkedHashMap<>();
        this.f37770n = new LinkedHashMap<>();
        this.f37771o = new ScrollBasedElevationHelper(0.0f, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A(eu.bolt.android.stories.widget.slide.StorySlideContent.Item.Text r6, int r7) {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.f37764h
            if (r0 != 0) goto La
            java.lang.String r0 = "slideContentContainer"
            kotlin.jvm.internal.Intrinsics.w(r0)
            r0 = 0
        La:
            int r1 = eu.bolt.android.stories.R$layout.view_story_slide_list_item
            android.view.View r0 = eu.bolt.android.stories.widget.slide.ARiderXKt.e(r0, r1)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            int r1 = eu.bolt.android.stories.R$id.slideContentText
            android.view.View r2 = r0.findViewById(r1)
            android.widget.TextView r2 = (android.widget.TextView) r2
            eu.bolt.android.stories.utils.StoriesHtmlEngine r3 = eu.bolt.android.stories.utils.StoriesHtmlEngine.f37614a
            kotlin.jvm.functions.Function1 r3 = r3.a()
            java.lang.String r4 = r6.c()
            java.lang.Object r3 = r3.invoke(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            eu.bolt.android.stories.widget.slide.StorySlideContent$Align r2 = r6.a()
            int r2 = r5.K(r2)
            r1.setGravity(r2)
            int r1 = eu.bolt.android.stories.R$id.slideContentTextStartIcon
            android.view.View r2 = r0.findViewById(r1)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            java.lang.String r3 = "slideContentTextStartIcon"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
            java.lang.String r3 = r6.b()
            r4 = 1
            if (r3 == 0) goto L5b
            boolean r3 = kotlin.text.StringsKt.y(r3)
            if (r3 == 0) goto L59
            goto L5b
        L59:
            r3 = 0
            goto L5c
        L5b:
            r3 = 1
        L5c:
            r3 = r3 ^ r4
            eu.bolt.android.stories.widget.slide.ARiderXKt.g(r2, r3)
            android.view.View r2 = r0.findViewById(r1)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            android.content.Context r2 = r2.getContext()
            java.lang.String r3 = "slideContentTextStartIcon.context"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
            boolean r2 = eu.bolt.android.stories.util.ContextExtKt.a(r2)
            if (r2 == 0) goto L90
            android.view.View r2 = r0.findViewById(r1)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.u(r2)
            java.lang.String r6 = r6.b()
            com.bumptech.glide.RequestBuilder r6 = r2.s(r6)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.B0(r1)
        L90:
            android.view.ViewGroup$MarginLayoutParams r6 = new android.view.ViewGroup$MarginLayoutParams
            r1 = -1
            r2 = -2
            r6.<init>(r1, r2)
            r6.topMargin = r7
            java.util.LinkedHashMap<android.view.View, android.view.ViewGroup$LayoutParams> r7 = r5.f37770n
            r7.put(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.stories.widget.slide.decorators.TopArrayContentWithFooterSlideDecorator.A(eu.bolt.android.stories.widget.slide.StorySlideContent$Item$Text, int):void");
    }

    private final Button C(StorySlideButton storySlideButton, final StorySlide storySlide) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        LinearLayout linearLayout = this.f37766j;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.w("buttonContainer");
            linearLayout = null;
        }
        Context context = linearLayout.getContext();
        Intrinsics.e(context, "buttonContainer.context");
        int i8 = R$dimen.f37427a;
        int b8 = ARiderXKt.b(context, i8);
        LinearLayout linearLayout3 = this.f37766j;
        if (linearLayout3 == null) {
            Intrinsics.w("buttonContainer");
            linearLayout3 = null;
        }
        Context context2 = linearLayout3.getContext();
        Intrinsics.e(context2, "buttonContainer.context");
        int i9 = R$dimen.f37428b;
        int b9 = ARiderXKt.b(context2, i9);
        LinearLayout linearLayout4 = this.f37766j;
        if (linearLayout4 == null) {
            Intrinsics.w("buttonContainer");
            linearLayout4 = null;
        }
        Context context3 = linearLayout4.getContext();
        Intrinsics.e(context3, "buttonContainer.context");
        int b10 = ARiderXKt.b(context3, i8);
        LinearLayout linearLayout5 = this.f37766j;
        if (linearLayout5 == null) {
            Intrinsics.w("buttonContainer");
            linearLayout5 = null;
        }
        Context context4 = linearLayout5.getContext();
        Intrinsics.e(context4, "buttonContainer.context");
        marginLayoutParams.setMargins(b8, b9, b10, ARiderXKt.b(context4, i9));
        StoryButton.Companion companion = StoryButton.f37626k;
        LinearLayout linearLayout6 = this.f37766j;
        if (linearLayout6 == null) {
            Intrinsics.w("buttonContainer");
        } else {
            linearLayout2 = linearLayout6;
        }
        Context context5 = linearLayout2.getContext();
        Intrinsics.e(context5, "buttonContainer.context");
        StoryButton a8 = companion.a(context5, storySlideButton.b().a());
        a8.setLayoutParams(marginLayoutParams);
        a8.setId(R$id.f37450n);
        a8.setText(storySlideButton.c());
        a8.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.android.stories.widget.slide.decorators.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopArrayContentWithFooterSlideDecorator.D(TopArrayContentWithFooterSlideDecorator.this, storySlide, view);
            }
        });
        return a8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(TopArrayContentWithFooterSlideDecorator this$0, StorySlide slide, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(slide, "$slide");
        this$0.j().d(slide, this$0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void F() {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.f51012f = true;
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        NestedScrollView nestedScrollView = this.f37767k;
        NestedScrollView nestedScrollView2 = null;
        if (nestedScrollView == null) {
            Intrinsics.w("scrollView");
            nestedScrollView = null;
        }
        nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: eu.bolt.android.stories.widget.slide.decorators.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean G;
                G = TopArrayContentWithFooterSlideDecorator.G(Ref$FloatRef.this, ref$FloatRef2, ref$BooleanRef, this, view, motionEvent);
                return G;
            }
        });
        NestedScrollView nestedScrollView3 = this.f37767k;
        if (nestedScrollView3 == null) {
            Intrinsics.w("scrollView");
        } else {
            nestedScrollView2 = nestedScrollView3;
        }
        nestedScrollView2.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: eu.bolt.android.stories.widget.slide.decorators.b
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void a(NestedScrollView nestedScrollView4, int i8, int i9, int i10, int i11) {
                TopArrayContentWithFooterSlideDecorator.H(Ref$BooleanRef.this, nestedScrollView4, i8, i9, i10, i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(Ref$FloatRef downX, Ref$FloatRef downY, Ref$BooleanRef scrollTopReached, TopArrayContentWithFooterSlideDecorator this$0, View view, MotionEvent event) {
        Intrinsics.f(downX, "$downX");
        Intrinsics.f(downY, "$downY");
        Intrinsics.f(scrollTopReached, "$scrollTopReached");
        Intrinsics.f(this$0, "this$0");
        int action = event.getAction();
        NestedScrollView nestedScrollView = null;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    NestedScrollView nestedScrollView2 = this$0.f37767k;
                    if (nestedScrollView2 == null) {
                        Intrinsics.w("scrollView");
                        nestedScrollView2 = null;
                    }
                    Intrinsics.e(event, "event");
                    if (ViewExtKt.b(nestedScrollView2, event, downX.f51013f, downY.f51013f) && scrollTopReached.f51012f) {
                        this$0.j().b(event);
                    }
                }
            } else if (scrollTopReached.f51012f) {
                StorySlideListener j8 = this$0.j();
                Intrinsics.e(event, "event");
                j8.f(event);
            }
        } else {
            downX.f51013f = event.getX();
            downY.f51013f = event.getY();
            if (scrollTopReached.f51012f) {
                StorySlideListener j9 = this$0.j();
                Intrinsics.e(event, "event");
                j9.g(event);
            }
        }
        NestedScrollView nestedScrollView3 = this$0.f37767k;
        if (nestedScrollView3 == null) {
            Intrinsics.w("scrollView");
        } else {
            nestedScrollView = nestedScrollView3;
        }
        return nestedScrollView.onTouchEvent(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Ref$BooleanRef scrollTopReached, NestedScrollView nestedScrollView, int i8, int i9, int i10, int i11) {
        boolean z7;
        Intrinsics.f(scrollTopReached, "$scrollTopReached");
        Intrinsics.f(nestedScrollView, "<anonymous parameter 0>");
        if (i9 <= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        scrollTopReached.f51012f = z7;
    }

    private final void I(StorySlide storySlide) {
        LinearLayout linearLayout = this.f37766j;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.w("buttonContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        if (storySlide.c() != null) {
            this.f37768l = C(storySlide.c(), storySlide);
            LinearLayout linearLayout3 = this.f37766j;
            if (linearLayout3 == null) {
                Intrinsics.w("buttonContainer");
            } else {
                linearLayout2 = linearLayout3;
            }
            linearLayout2.addView(this.f37768l);
            return;
        }
        this.f37768l = null;
    }

    private final int J(StorySlideContent.Align align) {
        int i8 = WhenMappings.f37772a[align.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return 8388613;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 17;
        }
        return 8388611;
    }

    private final int K(StorySlideContent.Align align) {
        int i8 = WhenMappings.f37772a[align.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return 8388613;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 17;
        }
        return 8388611;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void M(java.lang.String r6) {
        /*
            r5 = this;
            android.widget.TextView r0 = r5.f37765i
            java.lang.String r1 = "slideFooterTextView"
            r2 = 0
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.w(r1)
            r0 = r2
        Lb:
            r3 = 1
            if (r6 == 0) goto L17
            boolean r4 = kotlin.text.StringsKt.y(r6)
            if (r4 == 0) goto L15
            goto L17
        L15:
            r4 = 0
            goto L18
        L17:
            r4 = 1
        L18:
            r3 = r3 ^ r4
            eu.bolt.android.stories.widget.slide.ARiderXKt.g(r0, r3)
            android.widget.TextView r0 = r5.f37765i
            if (r0 != 0) goto L24
            kotlin.jvm.internal.Intrinsics.w(r1)
            r0 = r2
        L24:
            if (r6 == 0) goto L33
            eu.bolt.android.stories.utils.StoriesHtmlEngine r1 = eu.bolt.android.stories.utils.StoriesHtmlEngine.f37614a
            kotlin.jvm.functions.Function1 r1 = r1.a()
            java.lang.Object r6 = r1.invoke(r6)
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L33:
            r0.setText(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.stories.widget.slide.decorators.TopArrayContentWithFooterSlideDecorator.M(java.lang.String):void");
    }

    private final void y(StorySlideContent.Item.Asset asset, int i8) {
        LinearLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.f37764h;
        if (viewGroup == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup = null;
        }
        LottieAnimationView lottieAnimationView = new LottieAnimationView(viewGroup.getContext());
        this.f37769m.put(lottieAnimationView, asset.b());
        StoryAssetDimensions a8 = asset.b().a();
        if (a8 instanceof StoryAssetDimensions.MatchWidth) {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
            lottieAnimationView.setAdjustViewBounds(true);
        } else if (a8 instanceof StoryAssetDimensions.Fixed) {
            Context context = lottieAnimationView.getContext();
            Intrinsics.e(context, "view.context");
            StoryAssetDimensions.Fixed fixed = (StoryAssetDimensions.Fixed) a8;
            int c8 = ARiderXKt.c(context, fixed.b());
            Context context2 = lottieAnimationView.getContext();
            Intrinsics.e(context2, "view.context");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c8, ARiderXKt.c(context2, fixed.a()));
            layoutParams2.gravity = J(asset.a());
            layoutParams = layoutParams2;
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = J(asset.a());
            lottieAnimationView.setAdjustViewBounds(true);
            layoutParams = layoutParams3;
        }
        layoutParams.topMargin = i8;
        this.f37770n.put(lottieAnimationView, layoutParams);
    }

    private final void z(List<? extends StorySlideContent.Item> list, int i8) {
        int i9;
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            StorySlideContent.Item item = (StorySlideContent.Item) obj;
            if (i10 > 0) {
                i9 = i8;
            } else {
                i9 = 0;
            }
            if (item instanceof StorySlideContent.Item.Text) {
                A((StorySlideContent.Item.Text) item, i9);
            } else if (item instanceof StorySlideContent.Item.Asset) {
                y((StorySlideContent.Item.Asset) item, i9);
            }
            i10 = i11;
        }
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    /* renamed from: B */
    public void f(StorySlide.ArrayContentWithFooter slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        View findViewById = view.findViewById(R$id.f37447k);
        Intrinsics.e(findViewById, "view.findViewById(R.id.slideFooterTextView)");
        this.f37765i = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.f37445g);
        Intrinsics.e(findViewById2, "view.findViewById(R.id.slideContentContainer)");
        this.f37764h = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R$id.f37440a);
        Intrinsics.e(findViewById3, "view.findViewById(R.id.buttonContainer)");
        this.f37766j = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R$id.f37442d);
        Intrinsics.e(findViewById4, "view.findViewById(R.id.scrollContainer)");
        this.f37767k = (NestedScrollView) findViewById4;
        ViewGroup viewGroup = this.f37764h;
        LinearLayout linearLayout = null;
        if (viewGroup == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup = null;
        }
        viewGroup.setClipToOutline(true);
        ViewGroup viewGroup2 = this.f37764h;
        if (viewGroup2 == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup2 = null;
        }
        viewGroup2.setOutlineProvider(new ViewOutlineProvider() { // from class: eu.bolt.android.stories.widget.slide.decorators.TopArrayContentWithFooterSlideDecorator$bindViews$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                Intrinsics.f(view2, "view");
                Intrinsics.f(outline, "outline");
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), DimensKt.a(12.0f));
            }
        });
        ScrollBasedElevationHelper scrollBasedElevationHelper = this.f37771o;
        NestedScrollView nestedScrollView = this.f37767k;
        if (nestedScrollView == null) {
            Intrinsics.w("scrollView");
            nestedScrollView = null;
        }
        LinearLayout linearLayout2 = this.f37766j;
        if (linearLayout2 == null) {
            Intrinsics.w("buttonContainer");
        } else {
            linearLayout = linearLayout2;
        }
        scrollBasedElevationHelper.c(nestedScrollView, linearLayout);
        F();
        super.f(slide, view);
    }

    public void E(StorySlide.ArrayContentWithFooter slide) {
        Intrinsics.f(slide, "slide");
        ViewGroup viewGroup = this.f37764h;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        for (Map.Entry<View, ViewGroup.LayoutParams> entry : this.f37770n.entrySet()) {
            ViewGroup viewGroup3 = this.f37764h;
            if (viewGroup3 == null) {
                Intrinsics.w("slideContentContainer");
                viewGroup3 = null;
            }
            viewGroup3.addView(entry.getKey(), entry.getValue());
        }
        ViewGroup viewGroup4 = this.f37764h;
        if (viewGroup4 == null) {
            Intrinsics.w("slideContentContainer");
        } else {
            viewGroup2 = viewGroup4;
        }
        ARiderXKt.g(viewGroup2, true);
        M(slide.f());
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    /* renamed from: L */
    public void s(StorySlide.ArrayContentWithFooter slide) {
        List<? extends LottieAnimationView> H0;
        Intrinsics.f(slide, "slide");
        super.s(slide);
        ViewGroup viewGroup = this.f37764h;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup = null;
        }
        this.f37769m.clear();
        this.f37770n.clear();
        viewGroup.removeAllViews();
        viewGroup.setBackgroundColor(slide.e().a());
        StorySlideContent.Padding d8 = slide.e().d();
        viewGroup.setPadding(DimensKt.b(d8.b()), DimensKt.b(d8.d()), DimensKt.b(d8.c()), DimensKt.b(d8.a()));
        LinearLayout linearLayout = this.f37766j;
        if (linearLayout == null) {
            Intrinsics.w("buttonContainer");
            linearLayout = null;
        }
        linearLayout.setBackgroundColor(slide.b());
        ViewGroup viewGroup3 = this.f37764h;
        if (viewGroup3 == null) {
            Intrinsics.w("slideContentContainer");
        } else {
            viewGroup2 = viewGroup3;
        }
        Context context = viewGroup2.getContext();
        Intrinsics.e(context, "slideContentContainer.context");
        z(slide.e().b(), ARiderXKt.c(context, slide.e().c()));
        Set<LottieAnimationView> keySet = this.f37769m.keySet();
        Intrinsics.e(keySet, "slideImageAssets.keys");
        H0 = CollectionsKt___CollectionsKt.H0(keySet);
        t(H0);
        if (this.f37769m.isEmpty()) {
            E(slide);
            return;
        }
        for (Map.Entry<LottieAnimationView, StorySlideAsset> entry : this.f37769m.entrySet()) {
            e(entry.getValue(), entry.getKey());
        }
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void a() {
        LinearLayout linearLayout = this.f37766j;
        if (linearLayout == null) {
            Intrinsics.w("buttonContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        this.f37768l = null;
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void b(StorySlide slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        I(slide);
    }

    @Override // eu.bolt.android.stories.widget.slide.ButtonController
    public void c(StorySlide slide) {
        Intrinsics.f(slide, "slide");
        I(slide);
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    public void g() {
        super.g();
        this.f37769m.clear();
        this.f37770n.clear();
        TextView textView = this.f37765i;
        ViewGroup viewGroup = null;
        if (textView == null) {
            Intrinsics.w("slideFooterTextView");
            textView = null;
        }
        textView.setText((CharSequence) null);
        ViewGroup viewGroup2 = this.f37764h;
        if (viewGroup2 == null) {
            Intrinsics.w("slideContentContainer");
            viewGroup2 = null;
        }
        viewGroup2.removeAllViews();
        ViewGroup viewGroup3 = this.f37764h;
        if (viewGroup3 == null) {
            Intrinsics.w("slideContentContainer");
        } else {
            viewGroup = viewGroup3;
        }
        ARiderXKt.g(viewGroup, false);
    }

    @Override // eu.bolt.android.stories.widget.slide.decorators.StorySlideLayoutDecorator
    public int i() {
        return R$layout.f37454f;
    }
}
