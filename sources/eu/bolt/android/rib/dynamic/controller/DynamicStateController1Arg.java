package eu.bolt.android.rib.dynamic.controller;

import android.view.ViewGroup;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.DynamicStateInfo;
import java.io.Serializable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicStateController1Arg.kt */
/* loaded from: classes5.dex */
public final class DynamicStateController1Arg<T extends Serializable> extends DynamicStateController {

    /* renamed from: c */
    private final Function2<ViewGroup, T, Router> f37125c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DynamicStateController1Arg(Function2<? super ViewGroup, ? super T, ? extends Router> routerFactory, BaseDynamicRouter<?> dynamicRouter, DynamicStateInfo stateInfo) {
        super(dynamicRouter, stateInfo);
        Intrinsics.f(routerFactory, "routerFactory");
        Intrinsics.f(dynamicRouter, "dynamicRouter");
        Intrinsics.f(stateInfo, "stateInfo");
        this.f37125c = routerFactory;
    }

    public static /* synthetic */ boolean k(DynamicStateController1Arg dynamicStateController1Arg, Serializable serializable, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return dynamicStateController1Arg.j(serializable, z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eu.bolt.android.rib.dynamic.controller.DynamicStateController
    public Router d(Serializable[] args) {
        Intrinsics.f(args, "args");
        ViewGroup b8 = i().b();
        Serializable serializable = args[0];
        Intrinsics.d(serializable, "null cannot be cast to non-null type T of eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg");
        return (Router) this.f37125c.s(b8, serializable);
    }

    public final boolean j(T a12, boolean z7) {
        Intrinsics.f(a12, "a1");
        return c(l(a12), z7);
    }

    public final BaseDynamicRouter.DynamicState l(T a12) {
        Intrinsics.f(a12, "a1");
        return new BaseDynamicRouter.DynamicState(i().e(), i().d(), new Serializable[]{a12});
    }
}
