package eu.bolt.android.rib.dynamic;

import android.view.ViewGroup;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicTransitionFactory.kt */
/* loaded from: classes5.dex */
public final class DynamicTransitionFactoryArgs {

    /* renamed from: a  reason: collision with root package name */
    private final String f37117a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f37118b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Router> f37119c;

    /* renamed from: d  reason: collision with root package name */
    private final DynamicStateController f37120d;

    /* JADX WARN: Multi-variable type inference failed */
    public DynamicTransitionFactoryArgs(String stateName, ViewGroup parentView, Function0<? extends Router> routerFactory, DynamicStateController controller) {
        Intrinsics.f(stateName, "stateName");
        Intrinsics.f(parentView, "parentView");
        Intrinsics.f(routerFactory, "routerFactory");
        Intrinsics.f(controller, "controller");
        this.f37117a = stateName;
        this.f37118b = parentView;
        this.f37119c = routerFactory;
        this.f37120d = controller;
    }

    public final DynamicStateController a() {
        return this.f37120d;
    }

    public final ViewGroup b() {
        return this.f37118b;
    }

    public final Function0<Router> c() {
        return this.f37119c;
    }
}
