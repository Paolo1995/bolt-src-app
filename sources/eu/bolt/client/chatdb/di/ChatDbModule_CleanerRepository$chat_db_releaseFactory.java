package eu.bolt.client.chatdb.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.repo.LocalRepoCleaner;
import eu.bolt.client.chatdb.repo.LocalRepoCleanerImpl;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatDbModule_CleanerRepository$chat_db_releaseFactory implements Factory<LocalRepoCleaner> {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDbModule f39720a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LocalRepoCleanerImpl> f39721b;

    public ChatDbModule_CleanerRepository$chat_db_releaseFactory(ChatDbModule chatDbModule, Provider<LocalRepoCleanerImpl> provider) {
        this.f39720a = chatDbModule;
        this.f39721b = provider;
    }

    public static LocalRepoCleaner a(ChatDbModule chatDbModule, LocalRepoCleanerImpl localRepoCleanerImpl) {
        return (LocalRepoCleaner) Preconditions.checkNotNullFromProvides(chatDbModule.g(localRepoCleanerImpl));
    }

    public static ChatDbModule_CleanerRepository$chat_db_releaseFactory b(ChatDbModule chatDbModule, Provider<LocalRepoCleanerImpl> provider) {
        return new ChatDbModule_CleanerRepository$chat_db_releaseFactory(chatDbModule, provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public LocalRepoCleaner get() {
        return a(this.f39720a, this.f39721b.get());
    }
}
