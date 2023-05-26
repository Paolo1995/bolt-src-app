package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.transition.RibGenericTransition;
import eu.bolt.android.rib.transition.RibTransitionAnimation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class in extends BaseDynamicRouter<jn> {
    private final DynamicStateController1Arg<q5> B;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function2<ViewGroup, q5, Router> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ o5 f43575f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(o5 o5Var) {
            super(2);
            this.f43575f = o5Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, q5 args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return this.f43575f.e(container, args);
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f43576f = new b();

        b() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            RibGenericTransition.G(genericTransition, RibTransitionAnimation.FadeIn.f37344g, false, 2, null);
            RibGenericTransition.K(genericTransition, RibTransitionAnimation.FadeOut.f37345g, false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public in(jn view, fn interactor, ViewGroup fullScreenContainer, o5 dialogErrorBuilder) {
        super(view, interactor, null, 4, null);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(fullScreenContainer, "fullScreenContainer");
        Intrinsics.f(dialogErrorBuilder, "dialogErrorBuilder");
        this.B = BaseDynamicRouter.W0(this, "dialog_error", new a(dialogErrorBuilder), e6.d(this, b.f43576f), null, fullScreenContainer, false, false, 104, null);
    }

    public final DynamicStateController1Arg<q5> f1() {
        return this.B;
    }
}
