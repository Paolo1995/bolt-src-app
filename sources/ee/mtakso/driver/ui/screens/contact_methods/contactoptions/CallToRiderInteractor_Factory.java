package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipCallDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CallToRiderInteractor_Factory implements Factory<CallToRiderInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipCallDelegate> f27764a;

    public CallToRiderInteractor_Factory(Provider<VoipCallDelegate> provider) {
        this.f27764a = provider;
    }

    public static CallToRiderInteractor_Factory a(Provider<VoipCallDelegate> provider) {
        return new CallToRiderInteractor_Factory(provider);
    }

    public static CallToRiderInteractor c(VoipCallDelegate voipCallDelegate) {
        return new CallToRiderInteractor(voipCallDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CallToRiderInteractor get() {
        return c(this.f27764a.get());
    }
}
