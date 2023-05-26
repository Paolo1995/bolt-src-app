package ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help;

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
public final class DidYouGetHelpInteractor_Factory implements Factory<DidYouGetHelpInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmergencyAssistManager> f32623a;

    public DidYouGetHelpInteractor_Factory(Provider<EmergencyAssistManager> provider) {
        this.f32623a = provider;
    }

    public static DidYouGetHelpInteractor_Factory a(Provider<EmergencyAssistManager> provider) {
        return new DidYouGetHelpInteractor_Factory(provider);
    }

    public static DidYouGetHelpInteractor c(EmergencyAssistManager emergencyAssistManager) {
        return new DidYouGetHelpInteractor(emergencyAssistManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DidYouGetHelpInteractor get() {
        return c(this.f32623a.get());
    }
}
