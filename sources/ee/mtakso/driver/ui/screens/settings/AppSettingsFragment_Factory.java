package ee.mtakso.driver.ui.screens.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class AppSettingsFragment_Factory implements Factory<AppSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f32999a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverPricingAnalytics> f33000b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppThemeManager> f33001c;

    public AppSettingsFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DriverPricingAnalytics> provider2, Provider<AppThemeManager> provider3) {
        this.f32999a = provider;
        this.f33000b = provider2;
        this.f33001c = provider3;
    }

    public static AppSettingsFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DriverPricingAnalytics> provider2, Provider<AppThemeManager> provider3) {
        return new AppSettingsFragment_Factory(provider, provider2, provider3);
    }

    public static AppSettingsFragment c(BaseUiDependencies baseUiDependencies, DriverPricingAnalytics driverPricingAnalytics, AppThemeManager appThemeManager) {
        return new AppSettingsFragment(baseUiDependencies, driverPricingAnalytics, appThemeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppSettingsFragment get() {
        return c(this.f32999a.get(), this.f33000b.get(), this.f33001c.get());
    }
}
