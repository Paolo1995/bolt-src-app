package eu.bolt.android.rib.dynamic;

import eu.bolt.android.rib.RibNavigator;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDynamicRouter.kt */
/* loaded from: classes5.dex */
/* synthetic */ class BaseDynamicRouter$initNavigator$1 extends FunctionReferenceImpl implements Function1<BaseDynamicRouter.DynamicState, RibNavigator.TransitionBundle<BaseDynamicRouter.DynamicState>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseDynamicRouter$initNavigator$1(Object obj) {
        super(1, obj, BaseDynamicRouter.class, "createDynamicStateTransition", "createDynamicStateTransition(Leu/bolt/android/rib/dynamic/BaseDynamicRouter$DynamicState;)Leu/bolt/android/rib/RibNavigator$TransitionBundle;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final RibNavigator.TransitionBundle<BaseDynamicRouter.DynamicState> invoke(BaseDynamicRouter.DynamicState p02) {
        RibNavigator.TransitionBundle<BaseDynamicRouter.DynamicState> T0;
        Intrinsics.f(p02, "p0");
        T0 = ((BaseDynamicRouter) this.f50989g).T0(p02);
        return T0;
    }
}
