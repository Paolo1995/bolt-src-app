package eu.bolt.client.chatdb.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.client.chatdb.room.ChatDatabaseHelper;
import eu.bolt.client.chatdb.room.chat.ChatDao;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class LocalChatRepoImpl_Factory implements Factory<LocalChatRepoImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatDao> f39755a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatDatabaseHelper> f39756b;

    public LocalChatRepoImpl_Factory(Provider<ChatDao> provider, Provider<ChatDatabaseHelper> provider2) {
        this.f39755a = provider;
        this.f39756b = provider2;
    }

    public static LocalChatRepoImpl_Factory a(Provider<ChatDao> provider, Provider<ChatDatabaseHelper> provider2) {
        return new LocalChatRepoImpl_Factory(provider, provider2);
    }

    public static LocalChatRepoImpl c(ChatDao chatDao, ChatDatabaseHelper chatDatabaseHelper) {
        return new LocalChatRepoImpl(chatDao, chatDatabaseHelper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocalChatRepoImpl get() {
        return c(this.f39755a.get(), this.f39756b.get());
    }
}
