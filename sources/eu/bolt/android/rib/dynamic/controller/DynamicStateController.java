package eu.bolt.android.rib.dynamic.controller;

import eu.bolt.android.rib.Preconditions;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.DynamicStateInfo;
import eu.bolt.android.rib.dynamic.DynamicTransitionFactoryArgs;
import eu.bolt.android.rib.multistack.BaseMultiStackRouter;
import java.io.Serializable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicStateController.kt */
/* loaded from: classes5.dex */
public abstract class DynamicStateController {

    /* renamed from: a  reason: collision with root package name */
    private final BaseDynamicRouter<?> f37121a;

    /* renamed from: b  reason: collision with root package name */
    private final DynamicStateInfo f37122b;

    public DynamicStateController(BaseDynamicRouter<?> router, DynamicStateInfo stateInfo) {
        Intrinsics.f(router, "router");
        Intrinsics.f(stateInfo, "stateInfo");
        this.f37121a = router;
        this.f37122b = stateInfo;
    }

    private final boolean a(BaseDynamicRouter.DynamicState dynamicState, String str, boolean z7) {
        List e8;
        if (this.f37122b.a().b()) {
            return BaseMultiStackRouter.I0(this.f37121a, null, dynamicState, z7, str, 1, null);
        }
        BaseDynamicRouter<?> baseDynamicRouter = this.f37121a;
        e8 = CollectionsKt__CollectionsJVMKt.e(dynamicState);
        return BaseMultiStackRouter.I0(baseDynamicRouter, e8, null, z7, str, 2, null);
    }

    private final boolean b(BaseDynamicRouter.DynamicState dynamicState, String str, boolean z7) {
        if (this.f37122b.a().a()) {
            return a(dynamicState, str, z7);
        }
        return this.f37121a.P(dynamicState, this.f37122b.a().b(), z7, str);
    }

    public static /* synthetic */ void g(DynamicStateController dynamicStateController, boolean z7, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            dynamicStateController.f(z7);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: detach");
    }

    private final String h() {
        return this.f37122b.a().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c(BaseDynamicRouter.DynamicState state, boolean z7) {
        Intrinsics.f(state, "state");
        Preconditions.b();
        String h8 = h();
        if (h8 != null) {
            return b(state, h8, z7);
        }
        return BaseMultiStackRouter.O(this.f37121a, state, z7, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Router d(Serializable[] serializableArr);

    public final RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState> e(final Serializable[] args) {
        Intrinsics.f(args, "args");
        return this.f37122b.c().invoke(new DynamicTransitionFactoryArgs(this.f37122b.e(), this.f37122b.b(), new Function0<Router>() { // from class: eu.bolt.android.rib.dynamic.controller.DynamicStateController$createTransition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Router invoke() {
                return DynamicStateController.this.d(args);
            }
        }, this));
    }

    public boolean equals(Object obj) {
        DynamicStateController dynamicStateController;
        DynamicStateInfo dynamicStateInfo;
        String str = null;
        if (obj instanceof DynamicStateController) {
            dynamicStateController = (DynamicStateController) obj;
        } else {
            dynamicStateController = null;
        }
        if (dynamicStateController != null && (dynamicStateInfo = dynamicStateController.f37122b) != null) {
            str = dynamicStateInfo.e();
        }
        return Intrinsics.a(str, this.f37122b.e());
    }

    public final void f(boolean z7) {
        Preconditions.b();
        String h8 = h();
        if (h8 != null) {
            this.f37121a.d0(this.f37122b.e(), z7, h8);
        } else {
            this.f37121a.c0(this.f37122b.e(), z7);
        }
    }

    public int hashCode() {
        return this.f37122b.e().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DynamicStateInfo i() {
        return this.f37122b;
    }
}
