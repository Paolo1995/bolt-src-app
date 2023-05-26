package eu.bolt.client.chatdb.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.repo.ChatLocalRepo;
import eu.bolt.client.chatdb.repo.LocalChatRepoImpl;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_ChatRepository$chat_db_releaseFactory implements Factory<ChatLocalRepo> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39716a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LocalChatRepoImpl> f39717b;

    public ChatDbModule_ChatRepository$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<LocalChatRepoImpl> provider) {
        this.f39716a = chatDbModule;
        this.f39717b = provider;
    }

    public static ChatLocalRepo a(ChatDbModule chatDbModule, LocalChatRepoImpl localChatRepoImpl) {
        return (ChatLocalRepo) Preconditions.checkNotNullFromProvides(chatDbModule.e(localChatRepoImpl));
    }

    public static ChatDbModule_ChatRepository$chat_db_releaseFactory b(ChatDbModule chatDbModule, Provider<LocalChatRepoImpl> provider) {
        return new ChatDbModule_ChatRepository$chat_db_releaseFactory(chatDbModule, provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public ChatLocalRepo get() {
        return a(this.f39716a, this.f39717b.get());
    }
}
