package ee.mtakso.driver.ui.screens.launch;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DeviceAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.FullAuthFlow;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate;
import ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LauncherViewModel_Factory implements Factory<LauncherViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FullAuthFlow> f30428a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<InternetDataDelegate> f30429b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UnauthorizedWarningInteractor> f30430c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<StartUpTracing> f30431d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RoutingManager> f30432e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<AppPerformanceAnalytics> f30433f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ChatAnalytics> f30434g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DeviceAnalytics> f30435h;

    public LauncherViewModel_Factory(Provider<FullAuthFlow> provider, Provider<InternetDataDelegate> provider2, Provider<UnauthorizedWarningInteractor> provider3, Provider<StartUpTracing> provider4, Provider<RoutingManager> provider5, Provider<AppPerformanceAnalytics> provider6, Provider<ChatAnalytics> provider7, Provider<DeviceAnalytics> provider8) {
        this.f30428a = provider;
        this.f30429b = provider2;
        this.f30430c = provider3;
        this.f30431d = provider4;
        this.f30432e = provider5;
        this.f30433f = provider6;
        this.f30434g = provider7;
        this.f30435h = provider8;
    }

    public static LauncherViewModel_Factory a(Provider<FullAuthFlow> provider, Provider<InternetDataDelegate> provider2, Provider<UnauthorizedWarningInteractor> provider3, Provider<StartUpTracing> provider4, Provider<RoutingManager> provider5, Provider<AppPerformanceAnalytics> provider6, Provider<ChatAnalytics> provider7, Provider<DeviceAnalytics> provider8) {
        return new LauncherViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static LauncherViewModel c(FullAuthFlow fullAuthFlow, InternetDataDelegate internetDataDelegate, UnauthorizedWarningInteractor unauthorizedWarningInteractor, StartUpTracing startUpTracing, RoutingManager routingManager, AppPerformanceAnalytics appPerformanceAnalytics, ChatAnalytics chatAnalytics, DeviceAnalytics deviceAnalytics) {
        return new LauncherViewModel(fullAuthFlow, internetDataDelegate, unauthorizedWarningInteractor, startUpTracing, routingManager, appPerformanceAnalytics, chatAnalytics, deviceAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LauncherViewModel get() {
        return c(this.f30428a.get(), this.f30429b.get(), this.f30430c.get(), this.f30431d.get(), this.f30432e.get(), this.f30433f.get(), this.f30434g.get(), this.f30435h.get());
    }
}
