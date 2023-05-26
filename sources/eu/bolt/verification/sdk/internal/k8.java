package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.ViewGroup;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$AttachParams;
import eu.bolt.android.rib.ViewRouter;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.transition.RibGenericTransition;
import eu.bolt.verification.R$dimen;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class k8 extends BaseDynamicRouter<m8> {
    private final DynamicStateController1Arg<x6> B;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function2<ViewGroup, x6, Router> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ n6 f43836f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(n6 n6Var) {
            super(2);
            this.f43836f = n6Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, x6 model) {
            Intrinsics.f(container, "container");
            Intrinsics.f(model, "model");
            return this.f43836f.e(container, new s6(model, null, null, null, null, 30, null));
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ m8 f43837f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function3<ViewRouter<?>, RouterNavigator$AttachParams<BaseDynamicRouter.DynamicState>, ViewGroup, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ m8 f43838f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(m8 m8Var) {
                super(3);
                this.f43838f = m8Var;
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View] */
            public final void b(ViewRouter<?> router, RouterNavigator$AttachParams<BaseDynamicRouter.DynamicState> routerNavigator$AttachParams, ViewGroup viewGroup) {
                Intrinsics.f(router, "router");
                Intrinsics.f(routerNavigator$AttachParams, "<anonymous parameter 1>");
                Intrinsics.f(viewGroup, "<anonymous parameter 2>");
                ?? A = router.A();
                Context context = this.f43838f.getContext();
                Intrinsics.e(context, "view.context");
                uq.v(A, 0, 0, 0, f2.n(context, R$dimen.big_margin), 7, null);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(ViewRouter<?> viewRouter, RouterNavigator$AttachParams<BaseDynamicRouter.DynamicState> routerNavigator$AttachParams, ViewGroup viewGroup) {
                b(viewRouter, routerNavigator$AttachParams, viewGroup);
                return Unit.f50853a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(m8 m8Var) {
            super(1);
            this.f43837f = m8Var;
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            genericTransition.N(new a(this.f43837f));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k8(m8 view, i8 interactor, n6 errorContentBuilder) {
        super(view, interactor, null, 4, null);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(errorContentBuilder, "errorContentBuilder");
        this.B = BaseDynamicRouter.W0(this, "error_content", new a(errorContentBuilder), e6.d(this, new b(view)), null, null, false, false, 120, null);
    }

    public final DynamicStateController1Arg<x6> f1() {
        return this.B;
    }
}
