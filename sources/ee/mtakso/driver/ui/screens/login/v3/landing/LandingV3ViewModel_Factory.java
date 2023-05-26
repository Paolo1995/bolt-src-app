package ee.mtakso.driver.ui.screens.login.v3.landing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.ui.interactor.driver.DriverSessionExpireMessageInteractor;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LandingV3ViewModel_Factory implements Factory<LandingV3ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LoginAnalytics> f30683a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverSessionExpireMessageInteractor> f30684b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DeviceSettings> f30685c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<StartUpTracing> f30686d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RoutingManager> f30687e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<AuthManager> f30688f;

    public LandingV3ViewModel_Factory(Provider<LoginAnalytics> provider, Provider<DriverSessionExpireMessageInteractor> provider2, Provider<DeviceSettings> provider3, Provider<StartUpTracing> provider4, Provider<RoutingManager> provider5, Provider<AuthManager> provider6) {
        this.f30683a = provider;
        this.f30684b = provider2;
        this.f30685c = provider3;
        this.f30686d = provider4;
        this.f30687e = provider5;
        this.f30688f = provider6;
    }

    public static LandingV3ViewModel_Factory a(Provider<LoginAnalytics> provider, Provider<DriverSessionExpireMessageInteractor> provider2, Provider<DeviceSettings> provider3, Provider<StartUpTracing> provider4, Provider<RoutingManager> provider5, Provider<AuthManager> provider6) {
        return new LandingV3ViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static LandingV3ViewModel c(LoginAnalytics loginAnalytics, DriverSessionExpireMessageInteractor driverSessionExpireMessageInteractor, DeviceSettings deviceSettings, StartUpTracing startUpTracing, RoutingManager routingManager, AuthManager authManager) {
        return new LandingV3ViewModel(loginAnalytics, driverSessionExpireMessageInteractor, deviceSettings, startUpTracing, routingManager, authManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LandingV3ViewModel get() {
        return c(this.f30683a.get(), this.f30684b.get(), this.f30685c.get(), this.f30686d.get(), this.f30687e.get(), this.f30688f.get());
    }
}
