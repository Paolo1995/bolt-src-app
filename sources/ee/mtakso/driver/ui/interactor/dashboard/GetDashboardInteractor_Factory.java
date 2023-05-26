package ee.mtakso.driver.ui.interactor.dashboard;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.dashboard.DashboardService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetDashboardInteractor_Factory implements Factory<GetDashboardInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DashboardService> f26423a;

    public GetDashboardInteractor_Factory(Provider<DashboardService> provider) {
        this.f26423a = provider;
    }

    public static GetDashboardInteractor_Factory a(Provider<DashboardService> provider) {
        return new GetDashboardInteractor_Factory(provider);
    }

    public static GetDashboardInteractor c(DashboardService dashboardService) {
        return new GetDashboardInteractor(dashboardService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetDashboardInteractor get() {
        return c(this.f26423a.get());
    }
}
