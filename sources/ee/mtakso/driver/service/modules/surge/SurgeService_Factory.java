package ee.mtakso.driver.service.modules.surge;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SurgeService_Factory implements Factory<SurgeService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SurgeManager> f25311a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f25312b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverClient> f25313c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<GeoLocationManager> f25314d;

    public SurgeService_Factory(Provider<SurgeManager> provider, Provider<DriverStatusProvider> provider2, Provider<DriverClient> provider3, Provider<GeoLocationManager> provider4) {
        this.f25311a = provider;
        this.f25312b = provider2;
        this.f25313c = provider3;
        this.f25314d = provider4;
    }

    public static SurgeService_Factory a(Provider<SurgeManager> provider, Provider<DriverStatusProvider> provider2, Provider<DriverClient> provider3, Provider<GeoLocationManager> provider4) {
        return new SurgeService_Factory(provider, provider2, provider3, provider4);
    }

    public static SurgeService c(SurgeManager surgeManager, DriverStatusProvider driverStatusProvider, DriverClient driverClient, GeoLocationManager geoLocationManager) {
        return new SurgeService(surgeManager, driverStatusProvider, driverClient, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SurgeService get() {
        return c(this.f25311a.get(), this.f25312b.get(), this.f25313c.get(), this.f25314d.get());
    }
}
