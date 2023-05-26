package ee.mtakso.driver.service.order.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrdersCache_Factory implements Factory<OrdersCache> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final OrdersCache_Factory f25480a = new OrdersCache_Factory();

        private InstanceHolder() {
        }
    }

    public static OrdersCache_Factory a() {
        return InstanceHolder.f25480a;
    }

    public static OrdersCache c() {
        return new OrdersCache();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrdersCache get() {
        return c();
    }
}
