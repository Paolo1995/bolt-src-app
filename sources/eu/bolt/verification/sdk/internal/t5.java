package eu.bolt.verification.sdk.internal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.DynamicTransitionFactoryArgs;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.transition.RibGenericTransition;
import eu.bolt.android.rib.transition.RibTransitionAnimation;
import eu.bolt.verification.R$id;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class t5 extends BaseDynamicRouter<u5> {
    private final DynamicStateController1Arg<s6> B;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function2<ViewGroup, s6, Router> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ n6 f45119f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(n6 n6Var) {
            super(2);
            this.f45119f = n6Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, s6 args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return this.f45119f.e(container, args);
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f45120f = new b();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function0<ViewGroup.LayoutParams> {

            /* renamed from: f  reason: collision with root package name */
            public static final a f45121f = new a();

            a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ViewGroup.LayoutParams invoke() {
                return new LinearLayout.LayoutParams(-1, -2);
            }
        }

        b() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            genericTransition.M(a.f45121f);
            RibGenericTransition.K(genericTransition, RibTransitionAnimation.Delay.f37336g, false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t5(u5 view, r5 interactor, n6 errorContentBuilder) {
        super(view, interactor, null, 4, null);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(errorContentBuilder, "errorContentBuilder");
        a aVar = new a(errorContentBuilder);
        Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> d8 = e6.d(this, b.f45120f);
        View findViewById = view.findViewById(R$id.errorContentContainer);
        Intrinsics.e(findViewById, "view.findViewById(R.id.errorContentContainer)");
        this.B = BaseDynamicRouter.W0(this, "dialog_error_content", aVar, d8, null, (ViewGroup) findViewById, false, false, 104, null);
    }

    public final DynamicStateController1Arg<s6> f1() {
        return this.B;
    }
}
