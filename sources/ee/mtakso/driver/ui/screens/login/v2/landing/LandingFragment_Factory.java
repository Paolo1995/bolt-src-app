package ee.mtakso.driver.ui.screens.login.v2.landing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LandingFragment_Factory implements Factory<LandingFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RoutingManager> f30482a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f30483b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ViewModelFactory> f30484c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PermissionManager> f30485d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AppThemeManager> f30486e;

    public LandingFragment_Factory(Provider<RoutingManager> provider, Provider<ScreenAnalytics> provider2, Provider<ViewModelFactory> provider3, Provider<PermissionManager> provider4, Provider<AppThemeManager> provider5) {
        this.f30482a = provider;
        this.f30483b = provider2;
        this.f30484c = provider3;
        this.f30485d = provider4;
        this.f30486e = provider5;
    }

    public static LandingFragment_Factory a(Provider<RoutingManager> provider, Provider<ScreenAnalytics> provider2, Provider<ViewModelFactory> provider3, Provider<PermissionManager> provider4, Provider<AppThemeManager> provider5) {
        return new LandingFragment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LandingFragment c(RoutingManager routingManager, ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        return new LandingFragment(routingManager, screenAnalytics, viewModelFactory, permissionManager, appThemeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LandingFragment get() {
        return c(this.f30482a.get(), this.f30483b.get(), this.f30484c.get(), this.f30485d.get(), this.f30486e.get());
    }
}
