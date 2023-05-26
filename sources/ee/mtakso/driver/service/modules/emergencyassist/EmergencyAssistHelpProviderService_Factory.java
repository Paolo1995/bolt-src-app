package ee.mtakso.driver.service.modules.emergencyassist;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmergencyAssistHelpProviderService_Factory implements Factory<EmergencyAssistHelpProviderService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f24677a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EmergencyAssistManager> f24678b;

    public EmergencyAssistHelpProviderService_Factory(Provider<PollerSource> provider, Provider<EmergencyAssistManager> provider2) {
        this.f24677a = provider;
        this.f24678b = provider2;
    }

    public static EmergencyAssistHelpProviderService_Factory a(Provider<PollerSource> provider, Provider<EmergencyAssistManager> provider2) {
        return new EmergencyAssistHelpProviderService_Factory(provider, provider2);
    }

    public static EmergencyAssistHelpProviderService c(PollerSource pollerSource, EmergencyAssistManager emergencyAssistManager) {
        return new EmergencyAssistHelpProviderService(pollerSource, emergencyAssistManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmergencyAssistHelpProviderService get() {
        return c(this.f24677a.get(), this.f24678b.get());
    }
}
