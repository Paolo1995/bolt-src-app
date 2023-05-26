package ee.mtakso.driver.service.modules.polling;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.di.modules.TimingHooks;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.utils.BackgroundManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollerFactory_Factory implements Factory<PollerFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TimingHooks> f25107a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverClient> f25108b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrdersCache> f25109c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<BackgroundManager> f25110d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverProvider> f25111e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PollingRetryStrategy> f25112f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<GeoLocationManager> f25113g;

    public PollerFactory_Factory(Provider<TimingHooks> provider, Provider<DriverClient> provider2, Provider<OrdersCache> provider3, Provider<BackgroundManager> provider4, Provider<DriverProvider> provider5, Provider<PollingRetryStrategy> provider6, Provider<GeoLocationManager> provider7) {
        this.f25107a = provider;
        this.f25108b = provider2;
        this.f25109c = provider3;
        this.f25110d = provider4;
        this.f25111e = provider5;
        this.f25112f = provider6;
        this.f25113g = provider7;
    }

    public static PollerFactory_Factory a(Provider<TimingHooks> provider, Provider<DriverClient> provider2, Provider<OrdersCache> provider3, Provider<BackgroundManager> provider4, Provider<DriverProvider> provider5, Provider<PollingRetryStrategy> provider6, Provider<GeoLocationManager> provider7) {
        return new PollerFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PollerFactory c(TimingHooks timingHooks, DriverClient driverClient, OrdersCache ordersCache, BackgroundManager backgroundManager, DriverProvider driverProvider, PollingRetryStrategy pollingRetryStrategy, GeoLocationManager geoLocationManager) {
        return new PollerFactory(timingHooks, driverClient, ordersCache, backgroundManager, driverProvider, pollingRetryStrategy, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollerFactory get() {
        return c(this.f25107a.get(), this.f25108b.get(), this.f25109c.get(), this.f25110d.get(), this.f25111e.get(), this.f25112f.get(), this.f25113g.get());
    }
}
