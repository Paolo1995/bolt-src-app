package ee.mtakso.driver.ui.screens.login.v3.landing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LandingV3Fragment_Factory implements Factory<LandingV3Fragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f30668a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f30669b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PermissionManager> f30670c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AppThemeManager> f30671d;

    public LandingV3Fragment_Factory(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4) {
        this.f30668a = provider;
        this.f30669b = provider2;
        this.f30670c = provider3;
        this.f30671d = provider4;
    }

    public static LandingV3Fragment_Factory a(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4) {
        return new LandingV3Fragment_Factory(provider, provider2, provider3, provider4);
    }

    public static LandingV3Fragment c(ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        return new LandingV3Fragment(screenAnalytics, viewModelFactory, permissionManager, appThemeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LandingV3Fragment get() {
        return c(this.f30668a.get(), this.f30669b.get(), this.f30670c.get(), this.f30671d.get());
    }
}
