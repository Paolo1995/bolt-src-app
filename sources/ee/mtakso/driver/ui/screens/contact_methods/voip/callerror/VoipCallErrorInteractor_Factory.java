package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipCallErrorInteractor_Factory implements Factory<VoipCallErrorInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ContactOptionsDelegate> f27860a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VoipCallErrorDelegate> f27861b;

    public VoipCallErrorInteractor_Factory(Provider<ContactOptionsDelegate> provider, Provider<VoipCallErrorDelegate> provider2) {
        this.f27860a = provider;
        this.f27861b = provider2;
    }

    public static VoipCallErrorInteractor_Factory a(Provider<ContactOptionsDelegate> provider, Provider<VoipCallErrorDelegate> provider2) {
        return new VoipCallErrorInteractor_Factory(provider, provider2);
    }

    public static VoipCallErrorInteractor c(ContactOptionsDelegate contactOptionsDelegate, VoipCallErrorDelegate voipCallErrorDelegate) {
        return new VoipCallErrorInteractor(contactOptionsDelegate, voipCallErrorDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipCallErrorInteractor get() {
        return c(this.f27860a.get(), this.f27861b.get());
    }
}
