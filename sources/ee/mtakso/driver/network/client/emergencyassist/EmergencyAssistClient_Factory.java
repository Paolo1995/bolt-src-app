package ee.mtakso.driver.network.client.emergencyassist;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmergencyAssistClient_Factory implements Factory<EmergencyAssistClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmergencyAssistApi> f22173a;

    public EmergencyAssistClient_Factory(Provider<EmergencyAssistApi> provider) {
        this.f22173a = provider;
    }

    public static EmergencyAssistClient_Factory a(Provider<EmergencyAssistApi> provider) {
        return new EmergencyAssistClient_Factory(provider);
    }

    public static EmergencyAssistClient c(EmergencyAssistApi emergencyAssistApi) {
        return new EmergencyAssistClient(emergencyAssistApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmergencyAssistClient get() {
        return c(this.f22173a.get());
    }
}
