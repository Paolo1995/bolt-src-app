package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import eu.bolt.android.rib.RouterNavigatorState;
import eu.bolt.android.rib.ViewRouter;
import eu.bolt.android.rib.transition.RibGenericTransition;
import eu.bolt.android.rib.transition.RibTransitionAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l8<State extends RouterNavigatorState> extends RibGenericTransition<State> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l8(ViewGroup container, Function0<? extends ViewRouter<?>> routerFactory) {
        super(container, routerFactory);
        Intrinsics.f(container, "container");
        Intrinsics.f(routerFactory, "routerFactory");
        RibGenericTransition.G(this, RibTransitionAnimation.FadeIn.f37344g, false, 2, null);
        RibGenericTransition.K(this, RibTransitionAnimation.FadeOut.f37345g, false, 2, null);
    }
}
