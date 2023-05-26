package ee.mtakso.driver.ui.screens.login.v2.pswrd;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PasswordLoginFragment_Factory implements Factory<PasswordLoginFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f30516a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f30517b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PermissionManager> f30518c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AppThemeManager> f30519d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AppResolver> f30520e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PlatformManager> f30521f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<RoutingManager> f30522g;

    public PasswordLoginFragment_Factory(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4, Provider<AppResolver> provider5, Provider<PlatformManager> provider6, Provider<RoutingManager> provider7) {
        this.f30516a = provider;
        this.f30517b = provider2;
        this.f30518c = provider3;
        this.f30519d = provider4;
        this.f30520e = provider5;
        this.f30521f = provider6;
        this.f30522g = provider7;
    }

    public static PasswordLoginFragment_Factory a(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4, Provider<AppResolver> provider5, Provider<PlatformManager> provider6, Provider<RoutingManager> provider7) {
        return new PasswordLoginFragment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PasswordLoginFragment c(ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager, AppResolver appResolver, PlatformManager platformManager, RoutingManager routingManager) {
        return new PasswordLoginFragment(screenAnalytics, viewModelFactory, permissionManager, appThemeManager, appResolver, platformManager, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PasswordLoginFragment get() {
        return c(this.f30516a.get(), this.f30517b.get(), this.f30518c.get(), this.f30519d.get(), this.f30520e.get(), this.f30521f.get(), this.f30522g.get());
    }
}
