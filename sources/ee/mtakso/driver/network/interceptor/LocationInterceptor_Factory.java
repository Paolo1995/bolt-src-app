package ee.mtakso.driver.network.interceptor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LocationInterceptor_Factory implements Factory<LocationInterceptor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f22958a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f22959b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f22960c;

    public LocationInterceptor_Factory(Provider<GeoLocationManager> provider, Provider<DriverProvider> provider2, Provider<TrueTimeProvider> provider3) {
        this.f22958a = provider;
        this.f22959b = provider2;
        this.f22960c = provider3;
    }

    public static LocationInterceptor_Factory a(Provider<GeoLocationManager> provider, Provider<DriverProvider> provider2, Provider<TrueTimeProvider> provider3) {
        return new LocationInterceptor_Factory(provider, provider2, provider3);
    }

    public static LocationInterceptor c(GeoLocationManager geoLocationManager, DriverProvider driverProvider, TrueTimeProvider trueTimeProvider) {
        return new LocationInterceptor(geoLocationManager, driverProvider, trueTimeProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocationInterceptor get() {
        return c(this.f22958a.get(), this.f22959b.get(), this.f22960c.get());
    }
}
