package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.dynamic.controller.DynamicStateControllerNoArgs;
import eu.bolt.android.rib.transition.RibGenericTransition;
import eu.bolt.client.updateapp.rib.UpdateAppRibArgs;
import eu.bolt.client.updateapp.rib.UpdateAppRibBuilder;
import eu.bolt.client.updateapp.ui.UpdateAppUiModel;
import eu.bolt.verification.sdk.internal.ok;
import eu.bolt.verification.sdk.internal.xi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class bj extends BaseDynamicRouter<ViewGroup> {
    private final sh B;
    private final pi C;
    private final UpdateAppRibBuilder D;
    private final DynamicStateController1Arg<xi.b> E;
    private final DynamicStateController1Arg<xi.a> F;
    private final DynamicStateControllerNoArgs G;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function2<ViewGroup, xi.a, Router> {
        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, xi.a args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return bj.this.C.f(container, new kj(args.a(), false, 2, null));
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f42352f = new b();

        b() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            RibGenericTransition.G(genericTransition, new ok.a(), false, 2, null);
            RibGenericTransition.K(genericTransition, new ok.c(), false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function2<ViewGroup, xi.b, Router> {
        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, xi.b args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return bj.this.B.f(container, new di(args.a(), args.b()));
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final d f42354f = new d();

        d() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            RibGenericTransition.G(genericTransition, new ok.a(), false, 2, null);
            RibGenericTransition.K(genericTransition, new ok.c(), false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class e extends Lambda implements Function1<ViewGroup, Router> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Router invoke(ViewGroup container) {
            Intrinsics.f(container, "container");
            return bj.this.D.build(container, new UpdateAppRibArgs((UpdateAppUiModel) null, 1, (DefaultConstructorMarker) null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(ViewGroup view, yi interactor, sh storySetBuilder, pi singleStoryBuilder, UpdateAppRibBuilder updateAppRibBuilder) {
        super(view, interactor, null, 4, null);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(storySetBuilder, "storySetBuilder");
        Intrinsics.f(singleStoryBuilder, "singleStoryBuilder");
        Intrinsics.f(updateAppRibBuilder, "updateAppRibBuilder");
        this.B = storySetBuilder;
        this.C = singleStoryBuilder;
        this.D = updateAppRibBuilder;
        this.E = BaseDynamicRouter.W0(this, "story_set", new c(), e6.d(this, d.f42354f), null, null, false, false, 120, null);
        this.F = BaseDynamicRouter.W0(this, "single_story", new a(), e6.d(this, b.f42352f), null, null, false, false, 120, null);
        this.G = BaseDynamicRouter.X0(this, "update_app", new e(), e6.e(this, null, 1, null), null, null, false, 56, null);
    }

    public final DynamicStateController1Arg<xi.a> f1() {
        return this.F;
    }

    public final DynamicStateController1Arg<xi.b> h1() {
        return this.E;
    }

    public final DynamicStateControllerNoArgs j1() {
        return this.G;
    }
}
