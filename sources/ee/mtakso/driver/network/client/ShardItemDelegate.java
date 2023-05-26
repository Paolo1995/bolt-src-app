package ee.mtakso.driver.network.client;

import ee.mtakso.driver.param.DriverProvider;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: ShardApiProvider.kt */
/* loaded from: classes3.dex */
public final class ShardItemDelegate<T> {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f21347a;

    /* renamed from: b  reason: collision with root package name */
    private final ShardItem<T> f21348b;

    public ShardItemDelegate(DriverProvider driverProvider, Function1<? super String, ? extends T> computation) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(computation, "computation");
        this.f21347a = driverProvider;
        this.f21348b = new ShardItem<>(computation);
    }

    public T a(Object thisRef, KProperty<?> property) {
        Intrinsics.f(thisRef, "thisRef");
        Intrinsics.f(property, "property");
        return this.f21348b.a(this.f21347a.m().B());
    }
}
