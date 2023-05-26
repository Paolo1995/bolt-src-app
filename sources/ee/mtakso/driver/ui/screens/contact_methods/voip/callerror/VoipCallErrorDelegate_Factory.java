package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.voip.VoipCache;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipCallErrorDelegate_Factory implements Factory<VoipCallErrorDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ContactOptionsDelegate> f27848a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VoipOrderInformationDelegate> f27849b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<VoipCache> f27850c;

    public VoipCallErrorDelegate_Factory(Provider<ContactOptionsDelegate> provider, Provider<VoipOrderInformationDelegate> provider2, Provider<VoipCache> provider3) {
        this.f27848a = provider;
        this.f27849b = provider2;
        this.f27850c = provider3;
    }

    public static VoipCallErrorDelegate_Factory a(Provider<ContactOptionsDelegate> provider, Provider<VoipOrderInformationDelegate> provider2, Provider<VoipCache> provider3) {
        return new VoipCallErrorDelegate_Factory(provider, provider2, provider3);
    }

    public static VoipCallErrorDelegate c(ContactOptionsDelegate contactOptionsDelegate, VoipOrderInformationDelegate voipOrderInformationDelegate, VoipCache voipCache) {
        return new VoipCallErrorDelegate(contactOptionsDelegate, voipOrderInformationDelegate, voipCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipCallErrorDelegate get() {
        return c(this.f27848a.get(), this.f27849b.get(), this.f27850c.get());
    }
}
