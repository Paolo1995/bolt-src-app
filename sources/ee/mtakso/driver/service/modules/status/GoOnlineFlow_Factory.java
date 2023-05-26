package ee.mtakso.driver.service.modules.status;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GoOnlineFlow_Factory implements Factory<GoOnlineFlow> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GeoLocationManager> f25262a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverClient> f25263b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f25264c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<EnvironmentDataProvider> f25265d;

    public GoOnlineFlow_Factory(Provider<GeoLocationManager> provider, Provider<DriverClient> provider2, Provider<DriverProvider> provider3, Provider<EnvironmentDataProvider> provider4) {
        this.f25262a = provider;
        this.f25263b = provider2;
        this.f25264c = provider3;
        this.f25265d = provider4;
    }

    public static GoOnlineFlow_Factory a(Provider<GeoLocationManager> provider, Provider<DriverClient> provider2, Provider<DriverProvider> provider3, Provider<EnvironmentDataProvider> provider4) {
        return new GoOnlineFlow_Factory(provider, provider2, provider3, provider4);
    }

    public static GoOnlineFlow c(GeoLocationManager geoLocationManager, DriverClient driverClient, DriverProvider driverProvider, EnvironmentDataProvider environmentDataProvider) {
        return new GoOnlineFlow(geoLocationManager, driverClient, driverProvider, environmentDataProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GoOnlineFlow get() {
        return c(this.f25262a.get(), this.f25263b.get(), this.f25264c.get(), this.f25265d.get());
    }
}
