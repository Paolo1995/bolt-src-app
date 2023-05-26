package eu.bolt.client.chatdb.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.client.chatdb.room.ChatDatabase;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_DataBase$chat_db_releaseFactory implements Factory<ChatDatabase> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39722a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Context> f39723b;

    public ChatDbModule_DataBase$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<Context> provider) {
        this.f39722a = chatDbModule;
        this.f39723b = provider;
    }

    public static ChatDbModule_DataBase$chat_db_releaseFactory a(ChatDbModule chatDbModule, Provider<Context> provider) {
        return new ChatDbModule_DataBase$chat_db_releaseFactory(chatDbModule, provider);
    }

    public static ChatDatabase b(ChatDbModule chatDbModule, Context context) {
        return (ChatDatabase) Preconditions.checkNotNullFromProvides(chatDbModule.h(context));
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public ChatDatabase get() {
        return b(this.f39722a, this.f39723b.get());
    }
}
