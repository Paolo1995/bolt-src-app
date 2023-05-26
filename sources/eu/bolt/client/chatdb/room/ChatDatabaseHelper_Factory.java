package eu.bolt.client.chatdb.room;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDatabaseHelper_Factory implements Factory<ChatDatabaseHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatDatabase> f39786a;

    public ChatDatabaseHelper_Factory(Provider<ChatDatabase> provider) {
        this.f39786a = provider;
    }

    public static ChatDatabaseHelper_Factory a(Provider<ChatDatabase> provider) {
        return new ChatDatabaseHelper_Factory(provider);
    }

    public static ChatDatabaseHelper c(ChatDatabase chatDatabase) {
        return new ChatDatabaseHelper(chatDatabase);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatDatabaseHelper get() {
        return c(this.f39786a.get());
    }
}
