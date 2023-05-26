package ee.mtakso.driver.ui.screens.work.dispatch;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.AutoAcceptanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class DispatchSettingsViewModel_Factory implements Factory<DispatchSettingsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f34025a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AutoAcceptanceAnalytics> f34026b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SurgeManager> f34027c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverFeatures> f34028d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverSettings> f34029e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<SettingsAnalytics> f34030f;

    public DispatchSettingsViewModel_Factory(Provider<DispatchSettingsManager> provider, Provider<AutoAcceptanceAnalytics> provider2, Provider<SurgeManager> provider3, Provider<DriverFeatures> provider4, Provider<DriverSettings> provider5, Provider<SettingsAnalytics> provider6) {
        this.f34025a = provider;
        this.f34026b = provider2;
        this.f34027c = provider3;
        this.f34028d = provider4;
        this.f34029e = provider5;
        this.f34030f = provider6;
    }

    public static DispatchSettingsViewModel_Factory a(Provider<DispatchSettingsManager> provider, Provider<AutoAcceptanceAnalytics> provider2, Provider<SurgeManager> provider3, Provider<DriverFeatures> provider4, Provider<DriverSettings> provider5, Provider<SettingsAnalytics> provider6) {
        return new DispatchSettingsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DispatchSettingsViewModel c(DispatchSettingsManager dispatchSettingsManager, AutoAcceptanceAnalytics autoAcceptanceAnalytics, SurgeManager surgeManager, DriverFeatures driverFeatures, DriverSettings driverSettings, SettingsAnalytics settingsAnalytics) {
        return new DispatchSettingsViewModel(dispatchSettingsManager, autoAcceptanceAnalytics, surgeManager, driverFeatures, driverSettings, settingsAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DispatchSettingsViewModel get() {
        return c(this.f34025a.get(), this.f34026b.get(), this.f34027c.get(), this.f34028d.get(), this.f34029e.get(), this.f34030f.get());
    }
}
