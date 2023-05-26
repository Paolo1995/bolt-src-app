package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.network.client.voip.VoipClient;
import ee.mtakso.driver.service.voip.VoipCache;
import ee.mtakso.driver.service.voip.VoipService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class VoipCallDelegate_Factory implements Factory<VoipCallDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VoipService> f27931a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VoipClient> f27932b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ContactClient> f27933c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<VoipCache> f27934d;

    public VoipCallDelegate_Factory(Provider<VoipService> provider, Provider<VoipClient> provider2, Provider<ContactClient> provider3, Provider<VoipCache> provider4) {
        this.f27931a = provider;
        this.f27932b = provider2;
        this.f27933c = provider3;
        this.f27934d = provider4;
    }

    public static VoipCallDelegate_Factory a(Provider<VoipService> provider, Provider<VoipClient> provider2, Provider<ContactClient> provider3, Provider<VoipCache> provider4) {
        return new VoipCallDelegate_Factory(provider, provider2, provider3, provider4);
    }

    public static VoipCallDelegate c(VoipService voipService, VoipClient voipClient, ContactClient contactClient, VoipCache voipCache) {
        return new VoipCallDelegate(voipService, voipClient, contactClient, voipCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VoipCallDelegate get() {
        return c(this.f27931a.get(), this.f27932b.get(), this.f27933c.get(), this.f27934d.get());
    }
}
