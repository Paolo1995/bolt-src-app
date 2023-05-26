package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class AuthorisedStaffModule_ProvideAuthorisedUiDependenciesFactory implements Factory<BaseUiDependencies> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedStaffModule f20369a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f20370b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ViewModelFactory> f20371c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PermissionManager> f20372d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AppThemeManager> f20373e;

    public AuthorisedStaffModule_ProvideAuthorisedUiDependenciesFactory(AuthorisedStaffModule authorisedStaffModule, Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4) {
        this.f20369a = authorisedStaffModule;
        this.f20370b = provider;
        this.f20371c = provider2;
        this.f20372d = provider3;
        this.f20373e = provider4;
    }

    public static AuthorisedStaffModule_ProvideAuthorisedUiDependenciesFactory a(AuthorisedStaffModule authorisedStaffModule, Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4) {
        return new AuthorisedStaffModule_ProvideAuthorisedUiDependenciesFactory(authorisedStaffModule, provider, provider2, provider3, provider4);
    }

    public static BaseUiDependencies c(AuthorisedStaffModule authorisedStaffModule, ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        return (BaseUiDependencies) Preconditions.checkNotNullFromProvides(authorisedStaffModule.b(screenAnalytics, viewModelFactory, permissionManager, appThemeManager));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BaseUiDependencies get() {
        return c(this.f20369a, this.f20370b.get(), this.f20371c.get(), this.f20372d.get(), this.f20373e.get());
    }
}
