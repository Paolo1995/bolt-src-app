package ee.mtakso.driver.service.modules.order.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrdersCache;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderStateManager_Factory implements Factory<OrderStateManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f24984a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrdersCache> f24985b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderClient> f24986c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LocationTransmitter> f24987d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f24988e;

    public OrderStateManager_Factory(Provider<OrderProvider> provider, Provider<OrdersCache> provider2, Provider<OrderClient> provider3, Provider<LocationTransmitter> provider4, Provider<DriverDestinationsManager> provider5) {
        this.f24984a = provider;
        this.f24985b = provider2;
        this.f24986c = provider3;
        this.f24987d = provider4;
        this.f24988e = provider5;
    }

    public static OrderStateManager_Factory a(Provider<OrderProvider> provider, Provider<OrdersCache> provider2, Provider<OrderClient> provider3, Provider<LocationTransmitter> provider4, Provider<DriverDestinationsManager> provider5) {
        return new OrderStateManager_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static OrderStateManager c(OrderProvider orderProvider, OrdersCache ordersCache, OrderClient orderClient, LocationTransmitter locationTransmitter, DriverDestinationsManager driverDestinationsManager) {
        return new OrderStateManager(orderProvider, ordersCache, orderClient, locationTransmitter, driverDestinationsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderStateManager get() {
        return c(this.f24984a.get(), this.f24985b.get(), this.f24986c.get(), this.f24987d.get(), this.f24988e.get());
    }
}
