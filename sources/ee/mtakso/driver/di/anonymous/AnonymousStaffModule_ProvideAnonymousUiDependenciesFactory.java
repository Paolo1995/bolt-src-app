package ee.mtakso.driver.di.anonymous;

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
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnonymousStaffModule_ProvideAnonymousUiDependenciesFactory implements Factory<BaseUiDependencies> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousStaffModule f20173a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f20174b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ViewModelFactory> f20175c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PermissionManager> f20176d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AppThemeManager> f20177e;

    public AnonymousStaffModule_ProvideAnonymousUiDependenciesFactory(AnonymousStaffModule anonymousStaffModule, Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4) {
        this.f20173a = anonymousStaffModule;
        this.f20174b = provider;
        this.f20175c = provider2;
        this.f20176d = provider3;
        this.f20177e = provider4;
    }

    public static AnonymousStaffModule_ProvideAnonymousUiDependenciesFactory a(AnonymousStaffModule anonymousStaffModule, Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4) {
        return new AnonymousStaffModule_ProvideAnonymousUiDependenciesFactory(anonymousStaffModule, provider, provider2, provider3, provider4);
    }

    public static BaseUiDependencies c(AnonymousStaffModule anonymousStaffModule, ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        return (BaseUiDependencies) Preconditions.checkNotNullFromProvides(anonymousStaffModule.a(screenAnalytics, viewModelFactory, permissionManager, appThemeManager));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BaseUiDependencies get() {
        return c(this.f20173a, this.f20174b.get(), this.f20175c.get(), this.f20176d.get(), this.f20177e.get());
    }
}
