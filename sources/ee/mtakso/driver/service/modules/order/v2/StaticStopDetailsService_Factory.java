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
public final class StaticStopDetailsService_Factory implements Factory<StaticStopDetailsService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderClient> f25029a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f25030b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrdersCache> f25031c;

    public StaticStopDetailsService_Factory(Provider<OrderClient> provider, Provider<OrderProvider> provider2, Provider<OrdersCache> provider3) {
        this.f25029a = provider;
        this.f25030b = provider2;
        this.f25031c = provider3;
    }

    public static StaticStopDetailsService_Factory a(Provider<OrderClient> provider, Provider<OrderProvider> provider2, Provider<OrdersCache> provider3) {
        return new StaticStopDetailsService_Factory(provider, provider2, provider3);
    }

    public static StaticStopDetailsService c(OrderClient orderClient, OrderProvider orderProvider, OrdersCache ordersCache) {
        return new StaticStopDetailsService(orderClient, orderProvider, ordersCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StaticStopDetailsService get() {
        return c(this.f25029a.get(), this.f25030b.get(), this.f25031c.get());
    }
}
