package ee.mtakso.driver.service.modules.distance;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UpcomingStopDistanceService_Factory implements Factory<UpcomingStopDistanceService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f24603a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f24604b;

    public UpcomingStopDistanceService_Factory(Provider<GeoLocationManager> provider, Provider<OrderProvider> provider2) {
        this.f24603a = provider;
        this.f24604b = provider2;
    }

    public static UpcomingStopDistanceService_Factory a(Provider<GeoLocationManager> provider, Provider<OrderProvider> provider2) {
        return new UpcomingStopDistanceService_Factory(provider, provider2);
    }

    public static UpcomingStopDistanceService c(GeoLocationManager geoLocationManager, OrderProvider orderProvider) {
        return new UpcomingStopDistanceService(geoLocationManager, orderProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public UpcomingStopDistanceService get() {
        return c(this.f24603a.get(), this.f24604b.get());
    }
}
