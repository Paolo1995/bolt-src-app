package ee.mtakso.driver.ui.screens.settings.auto_acceptance;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.AutoAcceptanceAnalytics;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class AutoAcceptanceSettingsViewModel_Factory implements Factory<AutoAcceptanceSettingsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f33169a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AutoAcceptanceAnalytics> f33170b;

    public AutoAcceptanceSettingsViewModel_Factory(Provider<DispatchSettingsManager> provider, Provider<AutoAcceptanceAnalytics> provider2) {
        this.f33169a = provider;
        this.f33170b = provider2;
    }

    public static AutoAcceptanceSettingsViewModel_Factory a(Provider<DispatchSettingsManager> provider, Provider<AutoAcceptanceAnalytics> provider2) {
        return new AutoAcceptanceSettingsViewModel_Factory(provider, provider2);
    }

    public static AutoAcceptanceSettingsViewModel c(DispatchSettingsManager dispatchSettingsManager, AutoAcceptanceAnalytics autoAcceptanceAnalytics) {
        return new AutoAcceptanceSettingsViewModel(dispatchSettingsManager, autoAcceptanceAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AutoAcceptanceSettingsViewModel get() {
        return c(this.f33169a.get(), this.f33170b.get());
    }
}
