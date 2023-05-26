package eu.bolt.client.chatdb.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.client.chatdb.room.ChatDatabase;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_ChatMessagesDao$chat_db_releaseFactory implements Factory<MessagesDao> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39712a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatDatabase> f39713b;

    public ChatDbModule_ChatMessagesDao$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<ChatDatabase> provider) {
        this.f39712a = chatDbModule;
        this.f39713b = provider;
    }

    public static MessagesDao a(ChatDbModule chatDbModule, ChatDatabase chatDatabase) {
        return (MessagesDao) Preconditions.checkNotNullFromProvides(chatDbModule.c(chatDatabase));
    }

    public static ChatDbModule_ChatMessagesDao$chat_db_releaseFactory b(ChatDbModule chatDbModule, Provider<ChatDatabase> provider) {
        return new ChatDbModule_ChatMessagesDao$chat_db_releaseFactory(chatDbModule, provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public MessagesDao get() {
        return a(this.f39712a, this.f39713b.get());
    }
}
