package eu.bolt.android.rib.dynamic.controller;

import android.view.ViewGroup;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.DynamicStateInfo;
import java.io.Serializable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicStateControllerNoArgs.kt */
/* loaded from: classes5.dex */
public final class DynamicStateControllerNoArgs extends DynamicStateController {

    /* renamed from: c  reason: collision with root package name */
    private final Function1<ViewGroup, Router> f37126c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DynamicStateControllerNoArgs(Function1<? super ViewGroup, ? extends Router> routerFactory, BaseDynamicRouter<?> dynamicRouter, DynamicStateInfo stateInfo) {
        super(dynamicRouter, stateInfo);
        Intrinsics.f(routerFactory, "routerFactory");
        Intrinsics.f(dynamicRouter, "dynamicRouter");
        Intrinsics.f(stateInfo, "stateInfo");
        this.f37126c = routerFactory;
    }

    public static /* synthetic */ boolean k(DynamicStateControllerNoArgs dynamicStateControllerNoArgs, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return dynamicStateControllerNoArgs.j(z7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.dynamic.controller.DynamicStateController
    public Router d(Serializable[] args) {
        Intrinsics.f(args, "args");
        return this.f37126c.invoke(i().b());
    }

    public final boolean j(boolean z7) {
        return c(l(), z7);
    }

    public final BaseDynamicRouter.DynamicState l() {
        return new BaseDynamicRouter.DynamicState(i().e(), i().d(), null, 4, null);
    }
}
