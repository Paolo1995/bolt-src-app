package eu.bolt.client.chatdb.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo;
import eu.bolt.client.chatdb.repo.LocalChatTerminalInfoRepoImpl;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_ChatTerminalInfoRepository$chat_db_releaseFactory implements Factory<ChatLocalTerminalInfoRepo> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39718a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LocalChatTerminalInfoRepoImpl> f39719b;

    public ChatDbModule_ChatTerminalInfoRepository$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<LocalChatTerminalInfoRepoImpl> provider) {
        this.f39718a = chatDbModule;
        this.f39719b = provider;
    }

    public static ChatLocalTerminalInfoRepo a(ChatDbModule chatDbModule, LocalChatTerminalInfoRepoImpl localChatTerminalInfoRepoImpl) {
        return (ChatLocalTerminalInfoRepo) Preconditions.checkNotNullFromProvides(chatDbModule.f(localChatTerminalInfoRepoImpl));
    }

    public static ChatDbModule_ChatTerminalInfoRepository$chat_db_releaseFactory b(ChatDbModule chatDbModule, Provider<LocalChatTerminalInfoRepoImpl> provider) {
        return new ChatDbModule_ChatTerminalInfoRepository$chat_db_releaseFactory(chatDbModule, provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public ChatLocalTerminalInfoRepo get() {
        return a(this.f39718a, this.f39719b.get());
    }
}
