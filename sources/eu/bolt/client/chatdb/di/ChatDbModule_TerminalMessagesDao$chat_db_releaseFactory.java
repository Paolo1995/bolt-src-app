package eu.bolt.client.chatdb.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.client.chatdb.room.ChatDatabase;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_TerminalMessagesDao$chat_db_releaseFactory implements Factory<TerminalMessagesDao> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39724a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatDatabase> f39725b;

    public ChatDbModule_TerminalMessagesDao$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<ChatDatabase> provider) {
        this.f39724a = chatDbModule;
        this.f39725b = provider;
    }

    public static ChatDbModule_TerminalMessagesDao$chat_db_releaseFactory a(ChatDbModule chatDbModule, Provider<ChatDatabase> provider) {
        return new ChatDbModule_TerminalMessagesDao$chat_db_releaseFactory(chatDbModule, provider);
    }

    public static TerminalMessagesDao c(ChatDbModule chatDbModule, ChatDatabase chatDatabase) {
        return (TerminalMessagesDao) Preconditions.checkNotNullFromProvides(chatDbModule.i(chatDatabase));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TerminalMessagesDao get() {
        return c(this.f39724a, this.f39725b.get());
    }
}
