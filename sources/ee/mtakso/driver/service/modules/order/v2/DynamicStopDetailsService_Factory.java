package ee.mtakso.driver.service.modules.order.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrdersCache;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DynamicStopDetailsService_Factory implements Factory<DynamicStopDetailsService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderClient> f24905a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f24906b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrdersCache> f24907c;

    public DynamicStopDetailsService_Factory(Provider<OrderClient> provider, Provider<OrderProvider> provider2, Provider<OrdersCache> provider3) {
        this.f24905a = provider;
        this.f24906b = provider2;
        this.f24907c = provider3;
    }

    public static DynamicStopDetailsService_Factory a(Provider<OrderClient> provider, Provider<OrderProvider> provider2, Provider<OrdersCache> provider3) {
        return new DynamicStopDetailsService_Factory(provider, provider2, provider3);
    }

    public static DynamicStopDetailsService c(OrderClient orderClient, OrderProvider orderProvider, OrdersCache ordersCache) {
        return new DynamicStopDetailsService(orderClient, orderProvider, ordersCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DynamicStopDetailsService get() {
        return c(this.f24905a.get(), this.f24906b.get(), this.f24907c.get());
    }
}
