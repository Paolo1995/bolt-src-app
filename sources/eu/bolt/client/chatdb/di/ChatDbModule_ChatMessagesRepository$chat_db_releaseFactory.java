package eu.bolt.client.chatdb.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo;
import eu.bolt.client.chatdb.repo.LocalChatMessagesRepoImpl;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_ChatMessagesRepository$chat_db_releaseFactory implements Factory<ChatLocalMessagesRepo> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39714a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LocalChatMessagesRepoImpl> f39715b;

    public ChatDbModule_ChatMessagesRepository$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<LocalChatMessagesRepoImpl> provider) {
        this.f39714a = chatDbModule;
        this.f39715b = provider;
    }

    public static ChatLocalMessagesRepo a(ChatDbModule chatDbModule, LocalChatMessagesRepoImpl localChatMessagesRepoImpl) {
        return (ChatLocalMessagesRepo) Preconditions.checkNotNullFromProvides(chatDbModule.d(localChatMessagesRepoImpl));
    }

    public static ChatDbModule_ChatMessagesRepository$chat_db_releaseFactory b(ChatDbModule chatDbModule, Provider<LocalChatMessagesRepoImpl> provider) {
        return new ChatDbModule_ChatMessagesRepository$chat_db_releaseFactory(chatDbModule, provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public ChatLocalMessagesRepo get() {
        return a(this.f39714a, this.f39715b.get());
    }
}
