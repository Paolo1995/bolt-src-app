package ee.mtakso.driver.service.restriction;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LocationStateService_Factory implements Factory<LocationStateService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f25849a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverRestrictionManager> f25850b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f25851c;

    public LocationStateService_Factory(Provider<GeoLocationManager> provider, Provider<DriverRestrictionManager> provider2, Provider<DriverStatusProvider> provider3) {
        this.f25849a = provider;
        this.f25850b = provider2;
        this.f25851c = provider3;
    }

    public static LocationStateService_Factory a(Provider<GeoLocationManager> provider, Provider<DriverRestrictionManager> provider2, Provider<DriverStatusProvider> provider3) {
        return new LocationStateService_Factory(provider, provider2, provider3);
    }

    public static LocationStateService c(GeoLocationManager geoLocationManager, DriverRestrictionManager driverRestrictionManager, DriverStatusProvider driverStatusProvider) {
        return new LocationStateService(geoLocationManager, driverRestrictionManager, driverStatusProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationStateService get() {
        return c(this.f25849a.get(), this.f25850b.get(), this.f25851c.get());
    }
}
