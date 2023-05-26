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
public final class u7 extends BaseDynamicRouter<v7> {
    private final p2 B;
    private final DynamicStateController1Arg<o2> C;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function2<ViewGroup, o2, Router> {
        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final Router s(ViewGroup container, o2 args) {
            Intrinsics.f(container, "container");
            Intrinsics.f(args, "args");
            return u7.this.B.e(container, args);
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<RibGenericTransition<BaseDynamicRouter.DynamicState>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f45340f = new b();

        b() {
            super(1);
        }

        public final void b(RibGenericTransition<BaseDynamicRouter.DynamicState> genericTransition) {
            Intrinsics.f(genericTransition, "$this$genericTransition");
            RibGenericTransition.G(genericTransition, new RibTransitionAnimation.SlideFrom(null, null, 0L, 0L, 15, null), false, 2, null);
            RibGenericTransition.K(genericTransition, new RibTransitionAnimation.SlideTo(null, null, 0L, 0L, 15, null), false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RibGenericTransition<BaseDynamicRouter.DynamicState> ribGenericTransition) {
            b(ribGenericTransition);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u7(v7 view, r7 interactor, ViewGroup fullScreenView, p2 countryPickerRibBuilder) {
        super(view, interactor, null, 4, null);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(fullScreenView, "fullScreenView");
        Intrinsics.f(countryPickerRibBuilder, "countryPickerRibBuilder");
        this.B = countryPickerRibBuilder;
        this.C = BaseDynamicRouter.W0(this, "countryPicker", new a(), e6.d(this, b.f45340f), null, fullScreenView, false, false, 104, null);
    }

    public final DynamicStateController1Arg<o2> f1() {
        return this.C;
    }
}
