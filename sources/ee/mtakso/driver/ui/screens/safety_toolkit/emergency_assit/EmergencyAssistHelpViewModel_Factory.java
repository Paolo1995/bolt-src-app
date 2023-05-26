package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmergencyAssistHelpViewModel_Factory implements Factory<EmergencyAssistHelpViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmergencyAssistManager> f32714a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EmergencyAssistDataMapper> f32715b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverSettings> f32716c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SafetyToolkitAnalytics> f32717d;

    public EmergencyAssistHelpViewModel_Factory(Provider<EmergencyAssistManager> provider, Provider<EmergencyAssistDataMapper> provider2, Provider<DriverSettings> provider3, Provider<SafetyToolkitAnalytics> provider4) {
        this.f32714a = provider;
        this.f32715b = provider2;
        this.f32716c = provider3;
        this.f32717d = provider4;
    }

    public static EmergencyAssistHelpViewModel_Factory a(Provider<EmergencyAssistManager> provider, Provider<EmergencyAssistDataMapper> provider2, Provider<DriverSettings> provider3, Provider<SafetyToolkitAnalytics> provider4) {
        return new EmergencyAssistHelpViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static EmergencyAssistHelpViewModel c(EmergencyAssistManager emergencyAssistManager, EmergencyAssistDataMapper emergencyAssistDataMapper, DriverSettings driverSettings, SafetyToolkitAnalytics safetyToolkitAnalytics) {
        return new EmergencyAssistHelpViewModel(emergencyAssistManager, emergencyAssistDataMapper, driverSettings, safetyToolkitAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmergencyAssistHelpViewModel get() {
        return c(this.f32714a.get(), this.f32715b.get(), this.f32716c.get(), this.f32717d.get());
    }
}
