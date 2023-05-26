package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.DynamicTransitionFactoryArgs;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.multistack.BaseMultiStackRouter;
import eu.bolt.android.rib.transition.RibAttachAnimationFactory;
import eu.bolt.android.rib.transition.RibDetachAnimationFactory;
import eu.bolt.android.rib.transition.RibGenericTransition;
import eu.bolt.android.rib.transition.RibTransitionAnimation;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.verification.sdk.internal.xi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes5.dex */
public final class eo extends Cdo {
    private static final a P = new a(null);
    private final wm B;
    private final l7 C;
    private final o0 D;
    private final vi E;
    private final yq F;
    private final e8 G;
    private final b H;
    private final e I;
    private final DynamicStateController1Arg<q7> J;
    private final DynamicStateController1Arg<en> K;
    private final DynamicStateController1Arg<ga> L;
    private final DynamicStateController1Arg<td> M;
    private final DynamicStateController1Arg<xi.a> N;
    private final DynamicStateController1Arg<x6> O;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements RibAttachAnimationFactory<BaseDynamicRouter.DynamicState> {
        b() {
        }

        @Override // eu.bolt.android.rib.transition.RibAttachAnimationFactory
        /* renamed from: b */
        public RibTransitionAnimation a(boolean z7, BaseDynamicRouter.DynamicState dynamicState, BaseDynamicRouter.DynamicState toState) {
            Intrinsics.f(toState, "toState");
            return z7 ? new RibTransitionAnimation.SlideFrom(RibTransitionAnimation.Direction.LEFT, new LinearOutSlowInInterpolator(), 0L, 0L, 12, null) : eo.this.k0() > 1 ? new RibTransitionAnimation.SlideFrom(RibTransitionAnimation.Direction.RIGHT, new LinearOutSlowInInterpolator(), 0L, 0L, 12, null) : new RibTransitionAnimation.SlideFrom(RibTransitionAnimation.Direction.BOTTOM, null, 0L, 0L, 14, null);
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function2<ViewGroup, en, Router> {
        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, en args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return eo.this.B.e(container, args);
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {
        d() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            genericTransition.H(eo.this.H);
            genericTransition.L(eo.this.I);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements RibDetachAnimationFactory<BaseDynamicRouter.DynamicState> {
        e() {
        }

        @Override // eu.bolt.android.rib.transition.RibDetachAnimationFactory
        /* renamed from: b */
        public RibTransitionAnimation a(boolean z7, BaseDynamicRouter.DynamicState fromState, BaseDynamicRouter.DynamicState dynamicState) {
            Intrinsics.f(fromState, "fromState");
            return z7 ? new RibTransitionAnimation.SlideTo(RibTransitionAnimation.Direction.LEFT, new LinearInterpolator(), 0L, 0L, 12, null) : eo.this.k0() >= 1 ? new RibTransitionAnimation.SlideTo(RibTransitionAnimation.Direction.RIGHT, new LinearInterpolator(), 0L, 0L, 12, null) : new RibTransitionAnimation.SlideTo(RibTransitionAnimation.Direction.BOTTOM, null, 0L, 0L, 14, null);
        }
    }

    /* loaded from: classes5.dex */
    static final class f extends Lambda implements Function2<ViewGroup, q7, Router> {
        f() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, q7 args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return eo.this.C.e(container, args);
        }
    }

    /* loaded from: classes5.dex */
    static final class g extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<ViewGroup, Integer> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ eo f42846f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(eo eoVar) {
                super(1);
                this.f42846f = eoVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Integer invoke(ViewGroup it) {
                Intrinsics.f(it, "it");
                boolean X = this.f42846f.X("web_page");
                int childCount = it.getChildCount();
                if (X) {
                    childCount--;
                }
                return Integer.valueOf(childCount);
            }
        }

        g() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            genericTransition.I(new a(eo.this));
            genericTransition.H(eo.this.H);
            genericTransition.L(eo.this.I);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class h extends Lambda implements Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> {

        /* renamed from: f  reason: collision with root package name */
        public static final h f42847f = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState> invoke(DynamicTransitionFactoryArgs it) {
            Intrinsics.f(it, "it");
            Function0<Router> c8 = it.c();
            Intrinsics.d(c8, "null cannot be cast to non-null type kotlin.Function0<eu.bolt.android.rib.ViewRouter<*>>");
            return new l8(it.b(), (Function0) TypeIntrinsics.e(c8, 0));
        }
    }

    /* loaded from: classes5.dex */
    static final class i extends Lambda implements Function2<ViewGroup, x6, Router> {
        i() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, x6 args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return eo.this.G.e(container, new h8(args, DesignToolbarView.c.b.f40251h));
        }
    }

    /* loaded from: classes5.dex */
    static final class j extends Lambda implements Function2<ViewGroup, ga, Router> {
        j() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, ga args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return eo.this.D.e(container, args);
        }
    }

    /* loaded from: classes5.dex */
    static final class k extends Lambda implements Function2<ViewGroup, xi.a, Router> {
        k() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, xi.a args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return eo.this.E.b(container, args);
        }
    }

    /* loaded from: classes5.dex */
    static final class l extends Lambda implements Function2<ViewGroup, td, Router> {
        l() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, td args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return eo.this.F.e(container, args);
        }
    }

    /* loaded from: classes5.dex */
    static final class m extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final m f42852f = new m();

        m() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            RibTransitionAnimation.Direction direction = RibTransitionAnimation.Direction.BOTTOM;
            RibGenericTransition.G(genericTransition, new RibTransitionAnimation.SlideFrom(direction, null, 0L, 0L, 14, null), false, 2, null);
            RibGenericTransition.K(genericTransition, new RibTransitionAnimation.SlideTo(direction, null, 0L, 0L, 14, null), false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo(ViewGroup view, zn<Cdo> interactor, ViewGroup fullScreenContainer, wm cameraBuilder, l7 formBuilderBuilder, o0 bottomSheetInformationBuilder, vi storyFlowBuilder, yq webPageRibBuilder, e8 fullScreenErrorBuilder) {
        super(view, interactor);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(fullScreenContainer, "fullScreenContainer");
        Intrinsics.f(cameraBuilder, "cameraBuilder");
        Intrinsics.f(formBuilderBuilder, "formBuilderBuilder");
        Intrinsics.f(bottomSheetInformationBuilder, "bottomSheetInformationBuilder");
        Intrinsics.f(storyFlowBuilder, "storyFlowBuilder");
        Intrinsics.f(webPageRibBuilder, "webPageRibBuilder");
        Intrinsics.f(fullScreenErrorBuilder, "fullScreenErrorBuilder");
        this.B = cameraBuilder;
        this.C = formBuilderBuilder;
        this.D = bottomSheetInformationBuilder;
        this.E = storyFlowBuilder;
        this.F = webPageRibBuilder;
        this.G = fullScreenErrorBuilder;
        this.H = new b();
        this.I = new e();
        this.J = BaseDynamicRouter.W0(this, "FormBuilder", new f(), e6.d(this, new g()), null, fullScreenContainer, true, false, 72, null);
        this.K = BaseDynamicRouter.W0(this, "camera", new c(), e6.d(this, new d()), null, fullScreenContainer, true, false, 72, null);
        this.L = BaseDynamicRouter.W0(this, "infoBottomSheet", new j(), e6.b(this, null, 1, null), BaseDynamicRouter.S0(this, "bottom_sheet", false, false, 6, null), fullScreenContainer, true, false, 64, null);
        this.M = BaseDynamicRouter.W0(this, "web_page", new l(), e6.d(this, m.f42852f), BaseDynamicRouter.S0(this, "webview_stack", false, false, 6, null), fullScreenContainer, false, false, 96, null);
        this.N = BaseDynamicRouter.W0(this, "story", new k(), e6.g(this, null, 1, null), BaseDynamicRouter.S0(this, "story_stack", false, false, 6, null), fullScreenContainer, false, false, 96, null);
        this.O = BaseDynamicRouter.W0(this, "fullscreen_error", new i(), e6.c(h.f42847f), BaseDynamicRouter.S0(this, "full_screen_error", false, false, 6, null), fullScreenContainer, false, false, 96, null);
    }

    @Override // eu.bolt.verification.sdk.internal.Cdo
    public DynamicStateController1Arg<xi.a> f1() {
        return this.N;
    }

    public final DynamicStateController1Arg<en> h1() {
        return this.K;
    }

    public final DynamicStateController1Arg<q7> j1() {
        return this.J;
    }

    public final DynamicStateController1Arg<x6> l1() {
        return this.O;
    }

    public final DynamicStateController1Arg<ga> n1() {
        return this.L;
    }

    public final DynamicStateController1Arg<td> p1() {
        return this.M;
    }

    public final boolean s1() {
        return BaseMultiStackRouter.s0(this, false, "bottom_sheet", 1, null);
    }

    public final boolean u1() {
        return BaseMultiStackRouter.s0(this, false, "full_screen_error", 1, null);
    }

    public final boolean v1() {
        return BaseMultiStackRouter.s0(this, false, "story_stack", 1, null);
    }

    public final boolean w1() {
        return BaseMultiStackRouter.s0(this, false, "webview_stack", 1, null);
    }
}
