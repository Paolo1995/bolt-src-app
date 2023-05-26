package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ContactOptionsInteractor_Factory implements Factory<ContactOptionsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatDelegate> f27790a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ContactOptionsDelegate> f27791b;

    public ContactOptionsInteractor_Factory(Provider<ChatDelegate> provider, Provider<ContactOptionsDelegate> provider2) {
        this.f27790a = provider;
        this.f27791b = provider2;
    }

    public static ContactOptionsInteractor_Factory a(Provider<ChatDelegate> provider, Provider<ContactOptionsDelegate> provider2) {
        return new ContactOptionsInteractor_Factory(provider, provider2);
    }

    public static ContactOptionsInteractor c(ChatDelegate chatDelegate, ContactOptionsDelegate contactOptionsDelegate) {
        return new ContactOptionsInteractor(chatDelegate, contactOptionsDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ContactOptionsInteractor get() {
        return c(this.f27790a.get(), this.f27791b.get());
    }
}
