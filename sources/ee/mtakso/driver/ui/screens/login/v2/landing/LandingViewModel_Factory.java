package ee.mtakso.driver.ui.screens.login.v2.landing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.ui.interactor.driver.DriverSessionExpireMessageInteractor;
import ee.mtakso.driver.utils.CompositeChromeFirstUrlLauncher;
import ee.mtakso.driver.utils.UrlFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LandingViewModel_Factory implements Factory<LandingViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LoginAnalytics> f30496a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverSessionExpireMessageInteractor> f30497b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeChromeFirstUrlLauncher> f30498c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UrlFactory> f30499d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<StartUpTracing> f30500e;

    public LandingViewModel_Factory(Provider<LoginAnalytics> provider, Provider<DriverSessionExpireMessageInteractor> provider2, Provider<CompositeChromeFirstUrlLauncher> provider3, Provider<UrlFactory> provider4, Provider<StartUpTracing> provider5) {
        this.f30496a = provider;
        this.f30497b = provider2;
        this.f30498c = provider3;
        this.f30499d = provider4;
        this.f30500e = provider5;
    }

    public static LandingViewModel_Factory a(Provider<LoginAnalytics> provider, Provider<DriverSessionExpireMessageInteractor> provider2, Provider<CompositeChromeFirstUrlLauncher> provider3, Provider<UrlFactory> provider4, Provider<StartUpTracing> provider5) {
        return new LandingViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LandingViewModel c(LoginAnalytics loginAnalytics, DriverSessionExpireMessageInteractor driverSessionExpireMessageInteractor, CompositeChromeFirstUrlLauncher compositeChromeFirstUrlLauncher, UrlFactory urlFactory, StartUpTracing startUpTracing) {
        return new LandingViewModel(loginAnalytics, driverSessionExpireMessageInteractor, compositeChromeFirstUrlLauncher, urlFactory, startUpTracing);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LandingViewModel get() {
        return c(this.f30496a.get(), this.f30497b.get(), this.f30498c.get(), this.f30499d.get(), this.f30500e.get());
    }
}
