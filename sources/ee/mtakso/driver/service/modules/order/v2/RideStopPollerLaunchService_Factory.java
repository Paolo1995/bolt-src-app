package ee.mtakso.driver.service.modules.order.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrdersCache;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RideStopPollerLaunchService_Factory implements Factory<RideStopPollerLaunchService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrdersCache> f25012a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StopDetailsService> f25013b;

    public RideStopPollerLaunchService_Factory(Provider<OrdersCache> provider, Provider<StopDetailsService> provider2) {
        this.f25012a = provider;
        this.f25013b = provider2;
    }

    public static RideStopPollerLaunchService_Factory a(Provider<OrdersCache> provider, Provider<StopDetailsService> provider2) {
        return new RideStopPollerLaunchService_Factory(provider, provider2);
    }

    public static RideStopPollerLaunchService c(OrdersCache ordersCache, StopDetailsService stopDetailsService) {
        return new RideStopPollerLaunchService(ordersCache, stopDetailsService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RideStopPollerLaunchService get() {
        return c(this.f25012a.get(), this.f25013b.get());
    }
}
