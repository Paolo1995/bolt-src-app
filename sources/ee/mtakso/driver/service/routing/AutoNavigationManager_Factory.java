package ee.mtakso.driver.service.routing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.utils.BackgroundManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AutoNavigationManager_Factory implements Factory<AutoNavigationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f25879a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NavigationManager> f25880b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<BackgroundManager> f25881c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RoutingManager> f25882d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<OrderAnalytics> f25883e;

    public AutoNavigationManager_Factory(Provider<DriverProvider> provider, Provider<NavigationManager> provider2, Provider<BackgroundManager> provider3, Provider<RoutingManager> provider4, Provider<OrderAnalytics> provider5) {
        this.f25879a = provider;
        this.f25880b = provider2;
        this.f25881c = provider3;
        this.f25882d = provider4;
        this.f25883e = provider5;
    }

    public static AutoNavigationManager_Factory a(Provider<DriverProvider> provider, Provider<NavigationManager> provider2, Provider<BackgroundManager> provider3, Provider<RoutingManager> provider4, Provider<OrderAnalytics> provider5) {
        return new AutoNavigationManager_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AutoNavigationManager c(DriverProvider driverProvider, NavigationManager navigationManager, BackgroundManager backgroundManager, RoutingManager routingManager, OrderAnalytics orderAnalytics) {
        return new AutoNavigationManager(driverProvider, navigationManager, backgroundManager, routingManager, orderAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AutoNavigationManager get() {
        return c(this.f25879a.get(), this.f25880b.get(), this.f25881c.get(), this.f25882d.get(), this.f25883e.get());
    }
}
