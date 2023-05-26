package ee.mtakso.driver.service.restriction;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MockLocationService_Factory implements Factory<MockLocationService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f25857a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverRestrictionManager> f25858b;

    public MockLocationService_Factory(Provider<GeoLocationManager> provider, Provider<DriverRestrictionManager> provider2) {
        this.f25857a = provider;
        this.f25858b = provider2;
    }

    public static MockLocationService_Factory a(Provider<GeoLocationManager> provider, Provider<DriverRestrictionManager> provider2) {
        return new MockLocationService_Factory(provider, provider2);
    }

    public static MockLocationService c(GeoLocationManager geoLocationManager, DriverRestrictionManager driverRestrictionManager) {
        return new MockLocationService(geoLocationManager, driverRestrictionManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MockLocationService get() {
        return c(this.f25857a.get(), this.f25858b.get());
    }
}
