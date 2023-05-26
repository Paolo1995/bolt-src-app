package ee.mtakso.driver.ui.screens.settings.pricing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverPricingConfigurationClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class PricingSettingsViewModel_Factory implements Factory<PricingSettingsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverPricingConfigurationClient> f33289a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f33290b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f33291c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverPricingAnalytics> f33292d;

    public PricingSettingsViewModel_Factory(Provider<DriverPricingConfigurationClient> provider, Provider<DispatchSettingsManager> provider2, Provider<DriverProvider> provider3, Provider<DriverPricingAnalytics> provider4) {
        this.f33289a = provider;
        this.f33290b = provider2;
        this.f33291c = provider3;
        this.f33292d = provider4;
    }

    public static PricingSettingsViewModel_Factory a(Provider<DriverPricingConfigurationClient> provider, Provider<DispatchSettingsManager> provider2, Provider<DriverProvider> provider3, Provider<DriverPricingAnalytics> provider4) {
        return new PricingSettingsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static PricingSettingsViewModel c(DriverPricingConfigurationClient driverPricingConfigurationClient, DispatchSettingsManager dispatchSettingsManager, DriverProvider driverProvider, DriverPricingAnalytics driverPricingAnalytics) {
        return new PricingSettingsViewModel(driverPricingConfigurationClient, dispatchSettingsManager, driverProvider, driverPricingAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PricingSettingsViewModel get() {
        return c(this.f33289a.get(), this.f33290b.get(), this.f33291c.get(), this.f33292d.get());
    }
}
