package eu.bolt.client.chatdb.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.client.chatdb.room.ChatDatabase;
import eu.bolt.client.chatdb.room.chat.ChatDao;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_ChatDao$chat_db_releaseFactory implements Factory<ChatDao> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39708a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatDatabase> f39709b;

    public ChatDbModule_ChatDao$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<ChatDatabase> provider) {
        this.f39708a = chatDbModule;
        this.f39709b = provider;
    }

    public static ChatDao a(ChatDbModule chatDbModule, ChatDatabase chatDatabase) {
        return (ChatDao) Preconditions.checkNotNullFromProvides(chatDbModule.a(chatDatabase));
    }

    public static ChatDbModule_ChatDao$chat_db_releaseFactory b(ChatDbModule chatDbModule, Provider<ChatDatabase> provider) {
        return new ChatDbModule_ChatDao$chat_db_releaseFactory(chatDbModule, provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public ChatDao get() {
        return a(this.f39708a, this.f39709b.get());
    }
}
