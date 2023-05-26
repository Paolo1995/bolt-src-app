package ee.mtakso.driver.service.geo.transmitter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TransmissionService_Factory implements Factory<TransmissionService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f24502a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<GeoLocationManager> f24503b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderProvider> f24504c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LocationTransmitter> f24505d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverConfig> f24506e;

    public TransmissionService_Factory(Provider<DriverStatusProvider> provider, Provider<GeoLocationManager> provider2, Provider<OrderProvider> provider3, Provider<LocationTransmitter> provider4, Provider<DriverConfig> provider5) {
        this.f24502a = provider;
        this.f24503b = provider2;
        this.f24504c = provider3;
        this.f24505d = provider4;
        this.f24506e = provider5;
    }

    public static TransmissionService_Factory a(Provider<DriverStatusProvider> provider, Provider<GeoLocationManager> provider2, Provider<OrderProvider> provider3, Provider<LocationTransmitter> provider4, Provider<DriverConfig> provider5) {
        return new TransmissionService_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransmissionService c(DriverStatusProvider driverStatusProvider, GeoLocationManager geoLocationManager, OrderProvider orderProvider, LocationTransmitter locationTransmitter, DriverConfig driverConfig) {
        return new TransmissionService(driverStatusProvider, geoLocationManager, orderProvider, locationTransmitter, driverConfig);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TransmissionService get() {
        return c(this.f24502a.get(), this.f24503b.get(), this.f24504c.get(), this.f24505d.get(), this.f24506e.get());
    }
}
