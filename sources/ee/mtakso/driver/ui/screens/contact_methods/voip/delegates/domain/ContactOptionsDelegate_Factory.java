package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.contact.ContactClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ContactOptionsDelegate_Factory implements Factory<ContactOptionsDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ContactClient> f27919a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VoipOrderInformationDelegate> f27920b;

    public ContactOptionsDelegate_Factory(Provider<ContactClient> provider, Provider<VoipOrderInformationDelegate> provider2) {
        this.f27919a = provider;
        this.f27920b = provider2;
    }

    public static ContactOptionsDelegate_Factory a(Provider<ContactClient> provider, Provider<VoipOrderInformationDelegate> provider2) {
        return new ContactOptionsDelegate_Factory(provider, provider2);
    }

    public static ContactOptionsDelegate c(ContactClient contactClient, VoipOrderInformationDelegate voipOrderInformationDelegate) {
        return new ContactOptionsDelegate(contactClient, voipOrderInformationDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ContactOptionsDelegate get() {
        return c(this.f27919a.get(), this.f27920b.get());
    }
}
