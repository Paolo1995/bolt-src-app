package ee.mtakso.driver.ui.screens.settings.theme;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ThemeSettingsViewModel_Factory implements Factory<ThemeSettingsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AppThemeManager> f33309a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SettingsAnalytics> f33310b;

    public ThemeSettingsViewModel_Factory(Provider<AppThemeManager> provider, Provider<SettingsAnalytics> provider2) {
        this.f33309a = provider;
        this.f33310b = provider2;
    }

    public static ThemeSettingsViewModel_Factory a(Provider<AppThemeManager> provider, Provider<SettingsAnalytics> provider2) {
        return new ThemeSettingsViewModel_Factory(provider, provider2);
    }

    public static ThemeSettingsViewModel c(AppThemeManager appThemeManager, SettingsAnalytics settingsAnalytics) {
        return new ThemeSettingsViewModel(appThemeManager, settingsAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ThemeSettingsViewModel get() {
        return c(this.f33309a.get(), this.f33310b.get());
    }
}
