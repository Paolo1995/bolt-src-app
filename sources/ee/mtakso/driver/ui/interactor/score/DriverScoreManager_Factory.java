package ee.mtakso.driver.ui.interactor.score;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.score.DriverScoreClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverScoreManager_Factory implements Factory<DriverScoreManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverScoreClient> f26857a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f26858b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverScoreAnalytics> f26859c;

    public DriverScoreManager_Factory(Provider<DriverScoreClient> provider, Provider<DriverProvider> provider2, Provider<DriverScoreAnalytics> provider3) {
        this.f26857a = provider;
        this.f26858b = provider2;
        this.f26859c = provider3;
    }

    public static DriverScoreManager_Factory a(Provider<DriverScoreClient> provider, Provider<DriverProvider> provider2, Provider<DriverScoreAnalytics> provider3) {
        return new DriverScoreManager_Factory(provider, provider2, provider3);
    }

    public static DriverScoreManager c(DriverScoreClient driverScoreClient, DriverProvider driverProvider, DriverScoreAnalytics driverScoreAnalytics) {
        return new DriverScoreManager(driverScoreClient, driverProvider, driverScoreAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreManager get() {
        return c(this.f26857a.get(), this.f26858b.get(), this.f26859c.get());
    }
}
