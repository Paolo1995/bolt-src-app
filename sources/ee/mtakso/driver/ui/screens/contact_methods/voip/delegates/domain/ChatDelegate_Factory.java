package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.chat.ChatMessageMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChatDelegate_Factory implements Factory<ChatDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ContactOptionsDelegate> f27902a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatMessageMapper> f27903b;

    public ChatDelegate_Factory(Provider<ContactOptionsDelegate> provider, Provider<ChatMessageMapper> provider2) {
        this.f27902a = provider;
        this.f27903b = provider2;
    }

    public static ChatDelegate_Factory a(Provider<ContactOptionsDelegate> provider, Provider<ChatMessageMapper> provider2) {
        return new ChatDelegate_Factory(provider, provider2);
    }

    public static ChatDelegate c(ContactOptionsDelegate contactOptionsDelegate, ChatMessageMapper chatMessageMapper) {
        return new ChatDelegate(contactOptionsDelegate, chatMessageMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatDelegate get() {
        return c(this.f27902a.get(), this.f27903b.get());
    }
}
