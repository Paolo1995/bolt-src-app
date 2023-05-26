package ee.mtakso.driver.navigation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.App;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NavigationManager_Factory implements Factory<NavigationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<App> f21210a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f21211b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<NavigationAppTypeFactory> f21212c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<GeoLocationManager> f21213d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AppResolver> f21214e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DynamicNavigationProvider> f21215f;

    public NavigationManager_Factory(Provider<App> provider, Provider<DriverProvider> provider2, Provider<NavigationAppTypeFactory> provider3, Provider<GeoLocationManager> provider4, Provider<AppResolver> provider5, Provider<DynamicNavigationProvider> provider6) {
        this.f21210a = provider;
        this.f21211b = provider2;
        this.f21212c = provider3;
        this.f21213d = provider4;
        this.f21214e = provider5;
        this.f21215f = provider6;
    }

    public static NavigationManager_Factory a(Provider<App> provider, Provider<DriverProvider> provider2, Provider<NavigationAppTypeFactory> provider3, Provider<GeoLocationManager> provider4, Provider<AppResolver> provider5, Provider<DynamicNavigationProvider> provider6) {
        return new NavigationManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static NavigationManager c(App app, DriverProvider driverProvider, NavigationAppTypeFactory navigationAppTypeFactory, GeoLocationManager geoLocationManager, AppResolver appResolver, DynamicNavigationProvider dynamicNavigationProvider) {
        return new NavigationManager(app, driverProvider, navigationAppTypeFactory, geoLocationManager, appResolver, dynamicNavigationProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigationManager get() {
        return c(this.f21210a.get(), this.f21211b.get(), this.f21212c.get(), this.f21213d.get(), this.f21214e.get(), this.f21215f.get());
    }
}
