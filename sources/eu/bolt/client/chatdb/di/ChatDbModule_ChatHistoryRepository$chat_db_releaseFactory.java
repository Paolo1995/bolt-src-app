package eu.bolt.client.chatdb.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.repo.ChatLocalHistoryRepo;
import eu.bolt.client.chatdb.repo.ChatLocalHistoryRepoImpl;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_ChatHistoryRepository$chat_db_releaseFactory implements Factory<ChatLocalHistoryRepo> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39710a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatLocalHistoryRepoImpl> f39711b;

    public ChatDbModule_ChatHistoryRepository$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<ChatLocalHistoryRepoImpl> provider) {
        this.f39710a = chatDbModule;
        this.f39711b = provider;
    }

    public static ChatLocalHistoryRepo a(ChatDbModule chatDbModule, ChatLocalHistoryRepoImpl chatLocalHistoryRepoImpl) {
        return (ChatLocalHistoryRepo) Preconditions.checkNotNullFromProvides(chatDbModule.b(chatLocalHistoryRepoImpl));
    }

    public static ChatDbModule_ChatHistoryRepository$chat_db_releaseFactory b(ChatDbModule chatDbModule, Provider<ChatLocalHistoryRepoImpl> provider) {
        return new ChatDbModule_ChatHistoryRepository$chat_db_releaseFactory(chatDbModule, provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public ChatLocalHistoryRepo get() {
        return a(this.f39710a, this.f39711b.get());
    }
}
