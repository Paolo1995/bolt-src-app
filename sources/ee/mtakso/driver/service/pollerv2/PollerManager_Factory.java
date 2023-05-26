package ee.mtakso.driver.service.pollerv2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.utils.BackgroundManager;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollerManager_Factory implements Factory<PollerManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverClient> f25552a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrdersCache> f25553b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<BackgroundManager> f25554c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f25555d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<GeoLocationManager> f25556e;

    public PollerManager_Factory(Provider<DriverClient> provider, Provider<OrdersCache> provider2, Provider<BackgroundManager> provider3, Provider<DriverProvider> provider4, Provider<GeoLocationManager> provider5) {
        this.f25552a = provider;
        this.f25553b = provider2;
        this.f25554c = provider3;
        this.f25555d = provider4;
        this.f25556e = provider5;
    }

    public static PollerManager_Factory a(Provider<DriverClient> provider, Provider<OrdersCache> provider2, Provider<BackgroundManager> provider3, Provider<DriverProvider> provider4, Provider<GeoLocationManager> provider5) {
        return new PollerManager_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PollerManager c(DriverClient driverClient, OrdersCache ordersCache, BackgroundManager backgroundManager, DriverProvider driverProvider, GeoLocationManager geoLocationManager) {
        return new PollerManager(driverClient, ordersCache, backgroundManager, driverProvider, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollerManager get() {
        return c(this.f25552a.get(), this.f25553b.get(), this.f25554c.get(), this.f25555d.get(), this.f25556e.get());
    }
}
