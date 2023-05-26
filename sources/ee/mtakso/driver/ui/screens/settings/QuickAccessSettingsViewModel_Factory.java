package ee.mtakso.driver.ui.screens.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class QuickAccessSettingsViewModel_Factory implements Factory<QuickAccessSettingsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f33031a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f33032b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<QuickAccessStateAnalytics> f33033c;

    public QuickAccessSettingsViewModel_Factory(Provider<DriverProvider> provider, Provider<Features> provider2, Provider<QuickAccessStateAnalytics> provider3) {
        this.f33031a = provider;
        this.f33032b = provider2;
        this.f33033c = provider3;
    }

    public static QuickAccessSettingsViewModel_Factory a(Provider<DriverProvider> provider, Provider<Features> provider2, Provider<QuickAccessStateAnalytics> provider3) {
        return new QuickAccessSettingsViewModel_Factory(provider, provider2, provider3);
    }

    public static QuickAccessSettingsViewModel c(DriverProvider driverProvider, Features features, QuickAccessStateAnalytics quickAccessStateAnalytics) {
        return new QuickAccessSettingsViewModel(driverProvider, features, quickAccessStateAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public QuickAccessSettingsViewModel get() {
        return c(this.f33031a.get(), this.f33032b.get(), this.f33033c.get());
    }
}
