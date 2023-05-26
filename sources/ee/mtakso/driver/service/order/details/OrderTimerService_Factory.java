package ee.mtakso.driver.service.order.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderTimerService_Factory implements Factory<OrderTimerService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrdersCache> f25467a;

    public OrderTimerService_Factory(Provider<OrdersCache> provider) {
        this.f25467a = provider;
    }

    public static OrderTimerService_Factory a(Provider<OrdersCache> provider) {
        return new OrderTimerService_Factory(provider);
    }

    public static OrderTimerService c(OrdersCache ordersCache) {
        return new OrderTimerService(ordersCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderTimerService get() {
        return c(this.f25467a.get());
    }
}
