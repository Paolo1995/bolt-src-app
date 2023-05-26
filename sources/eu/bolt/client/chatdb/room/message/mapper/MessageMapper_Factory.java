package eu.bolt.client.chatdb.room.message.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MessageMapper_Factory implements Factory<MessageMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TranslationMapper> f39886a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MessageStatusMapper> f39887b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MessageTypeMapper> f39888c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserInfoProvider> f39889d;

    public MessageMapper_Factory(Provider<TranslationMapper> provider, Provider<MessageStatusMapper> provider2, Provider<MessageTypeMapper> provider3, Provider<UserInfoProvider> provider4) {
        this.f39886a = provider;
        this.f39887b = provider2;
        this.f39888c = provider3;
        this.f39889d = provider4;
    }

    public static MessageMapper_Factory a(Provider<TranslationMapper> provider, Provider<MessageStatusMapper> provider2, Provider<MessageTypeMapper> provider3, Provider<UserInfoProvider> provider4) {
        return new MessageMapper_Factory(provider, provider2, provider3, provider4);
    }

    public static MessageMapper c(TranslationMapper translationMapper, MessageStatusMapper messageStatusMapper, MessageTypeMapper messageTypeMapper, UserInfoProvider userInfoProvider) {
        return new MessageMapper(translationMapper, messageStatusMapper, messageTypeMapper, userInfoProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MessageMapper get() {
        return c(this.f39886a.get(), this.f39887b.get(), this.f39888c.get(), this.f39889d.get());
    }
}
