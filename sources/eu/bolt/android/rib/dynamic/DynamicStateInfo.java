package eu.bolt.android.rib.dynamic;

import android.view.ViewGroup;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicStateInfo.kt */
/* loaded from: classes5.dex */
public final class DynamicStateInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f37112a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f37113b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> f37114c;

    /* renamed from: d  reason: collision with root package name */
    private final DynamicAttachConfig f37115d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f37116e;

    /* JADX WARN: Multi-variable type inference failed */
    public DynamicStateInfo(String stateName, ViewGroup container, Function1<? super DynamicTransitionFactoryArgs, ? extends RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> dynamicTransitionFactory, DynamicAttachConfig attachConfig, boolean z7) {
        Intrinsics.f(stateName, "stateName");
        Intrinsics.f(container, "container");
        Intrinsics.f(dynamicTransitionFactory, "dynamicTransitionFactory");
        Intrinsics.f(attachConfig, "attachConfig");
        this.f37112a = stateName;
        this.f37113b = container;
        this.f37114c = dynamicTransitionFactory;
        this.f37115d = attachConfig;
        this.f37116e = z7;
    }

    public final DynamicAttachConfig a() {
        return this.f37115d;
    }

    public final ViewGroup b() {
        return this.f37113b;
    }

    public final Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, BaseDynamicRouter.DynamicState>> c() {
        return this.f37114c;
    }

    public final boolean d() {
        return this.f37116e;
    }

    public final String e() {
        return this.f37112a;
    }
}
