package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.CallToRiderInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipCallErrorViewModel_Factory implements Factory<VoipCallErrorViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipCallErrorInteractor> f27878a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CallToRiderInteractor> f27879b;

    public VoipCallErrorViewModel_Factory(Provider<VoipCallErrorInteractor> provider, Provider<CallToRiderInteractor> provider2) {
        this.f27878a = provider;
        this.f27879b = provider2;
    }

    public static VoipCallErrorViewModel_Factory a(Provider<VoipCallErrorInteractor> provider, Provider<CallToRiderInteractor> provider2) {
        return new VoipCallErrorViewModel_Factory(provider, provider2);
    }

    public static VoipCallErrorViewModel c(VoipCallErrorInteractor voipCallErrorInteractor, CallToRiderInteractor callToRiderInteractor) {
        return new VoipCallErrorViewModel(voipCallErrorInteractor, callToRiderInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipCallErrorViewModel get() {
        return c(this.f27878a.get(), this.f27879b.get());
    }
}
