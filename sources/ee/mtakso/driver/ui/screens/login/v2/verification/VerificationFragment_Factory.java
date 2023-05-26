package ee.mtakso.driver.ui.screens.login.v2.verification;

import androidx.fragment.app.FragmentFactory;
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
public final class VerificationFragment_Factory implements Factory<VerificationFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f30567a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f30568b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PermissionManager> f30569c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AppThemeManager> f30570d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<FragmentFactory> f30571e;

    public VerificationFragment_Factory(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4, Provider<FragmentFactory> provider5) {
        this.f30567a = provider;
        this.f30568b = provider2;
        this.f30569c = provider3;
        this.f30570d = provider4;
        this.f30571e = provider5;
    }

    public static VerificationFragment_Factory a(Provider<ScreenAnalytics> provider, Provider<ViewModelFactory> provider2, Provider<PermissionManager> provider3, Provider<AppThemeManager> provider4, Provider<FragmentFactory> provider5) {
        return new VerificationFragment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static VerificationFragment c(ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager, FragmentFactory fragmentFactory) {
        return new VerificationFragment(screenAnalytics, viewModelFactory, permissionManager, appThemeManager, fragmentFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VerificationFragment get() {
        return c(this.f30567a.get(), this.f30568b.get(), this.f30569c.get(), this.f30570d.get(), this.f30571e.get());
    }
}
