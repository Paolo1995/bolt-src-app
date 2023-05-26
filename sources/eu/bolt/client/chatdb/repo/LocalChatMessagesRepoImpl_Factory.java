package eu.bolt.client.chatdb.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import eu.bolt.client.chatdb.room.message.mapper.MessageMapper;
import eu.bolt.client.chatdb.room.message.mapper.MessageStatusMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class LocalChatMessagesRepoImpl_Factory implements Factory<LocalChatMessagesRepoImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MessagesDao> f39745a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserInfoProvider> f39746b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MessageMapper> f39747c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MessageStatusMapper> f39748d;

    public LocalChatMessagesRepoImpl_Factory(Provider<MessagesDao> provider, Provider<UserInfoProvider> provider2, Provider<MessageMapper> provider3, Provider<MessageStatusMapper> provider4) {
        this.f39745a = provider;
        this.f39746b = provider2;
        this.f39747c = provider3;
        this.f39748d = provider4;
    }

    public static LocalChatMessagesRepoImpl_Factory a(Provider<MessagesDao> provider, Provider<UserInfoProvider> provider2, Provider<MessageMapper> provider3, Provider<MessageStatusMapper> provider4) {
        return new LocalChatMessagesRepoImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static LocalChatMessagesRepoImpl c(MessagesDao messagesDao, UserInfoProvider userInfoProvider, MessageMapper messageMapper, MessageStatusMapper messageStatusMapper) {
        return new LocalChatMessagesRepoImpl(messagesDao, userInfoProvider, messageMapper, messageStatusMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocalChatMessagesRepoImpl get() {
        return c(this.f39745a.get(), this.f39746b.get(), this.f39747c.get(), this.f39748d.get());
    }
}
