package ee.mtakso.driver.service.modules.map;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MapsConfigsService_Factory implements Factory<MapsConfigsService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollingRetryStrategy> f24858a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverClient> f24859b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f24860c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverFeatures> f24861d;

    public MapsConfigsService_Factory(Provider<PollingRetryStrategy> provider, Provider<DriverClient> provider2, Provider<DriverStatusProvider> provider3, Provider<DriverFeatures> provider4) {
        this.f24858a = provider;
        this.f24859b = provider2;
        this.f24860c = provider3;
        this.f24861d = provider4;
    }

    public static MapsConfigsService_Factory a(Provider<PollingRetryStrategy> provider, Provider<DriverClient> provider2, Provider<DriverStatusProvider> provider3, Provider<DriverFeatures> provider4) {
        return new MapsConfigsService_Factory(provider, provider2, provider3, provider4);
    }

    public static MapsConfigsService c(PollingRetryStrategy pollingRetryStrategy, DriverClient driverClient, DriverStatusProvider driverStatusProvider, DriverFeatures driverFeatures) {
        return new MapsConfigsService(pollingRetryStrategy, driverClient, driverStatusProvider, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MapsConfigsService get() {
        return c(this.f24858a.get(), this.f24859b.get(), this.f24860c.get(), this.f24861d.get());
    }
}
