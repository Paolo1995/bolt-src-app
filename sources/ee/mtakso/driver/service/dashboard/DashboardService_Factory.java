package ee.mtakso.driver.service.dashboard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.dashboard.DashboardClient;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DashboardService_Factory implements Factory<DashboardService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollingRetryStrategy> f24272a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DashboardClient> f24273b;

    public DashboardService_Factory(Provider<PollingRetryStrategy> provider, Provider<DashboardClient> provider2) {
        this.f24272a = provider;
        this.f24273b = provider2;
    }

    public static DashboardService_Factory a(Provider<PollingRetryStrategy> provider, Provider<DashboardClient> provider2) {
        return new DashboardService_Factory(provider, provider2);
    }

    public static DashboardService c(PollingRetryStrategy pollingRetryStrategy, DashboardClient dashboardClient) {
        return new DashboardService(pollingRetryStrategy, dashboardClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DashboardService get() {
        return c(this.f24272a.get(), this.f24273b.get());
    }
}
