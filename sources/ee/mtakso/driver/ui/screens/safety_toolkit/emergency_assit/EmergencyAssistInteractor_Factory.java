package ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmergencyAssistInteractor_Factory implements Factory<EmergencyAssistInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmergencyAssistManager> f32719a;

    public EmergencyAssistInteractor_Factory(Provider<EmergencyAssistManager> provider) {
        this.f32719a = provider;
    }

    public static EmergencyAssistInteractor_Factory a(Provider<EmergencyAssistManager> provider) {
        return new EmergencyAssistInteractor_Factory(provider);
    }

    public static EmergencyAssistInteractor c(EmergencyAssistManager emergencyAssistManager) {
        return new EmergencyAssistInteractor(emergencyAssistManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmergencyAssistInteractor get() {
        return c(this.f32719a.get());
    }
}
