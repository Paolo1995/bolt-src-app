package eu.bolt.client.chatdb.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo;
import eu.bolt.client.chatdb.room.ChatDatabaseHelper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatLocalHistoryRepoImpl_Factory implements Factory<ChatLocalHistoryRepoImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatLocalMessagesRepo> f39732a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatLocalRepo> f39733b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ChatLocalTerminalInfoRepo> f39734c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatDatabaseHelper> f39735d;

    public ChatLocalHistoryRepoImpl_Factory(Provider<ChatLocalMessagesRepo> provider, Provider<ChatLocalRepo> provider2, Provider<ChatLocalTerminalInfoRepo> provider3, Provider<ChatDatabaseHelper> provider4) {
        this.f39732a = provider;
        this.f39733b = provider2;
        this.f39734c = provider3;
        this.f39735d = provider4;
    }

    public static ChatLocalHistoryRepoImpl_Factory a(Provider<ChatLocalMessagesRepo> provider, Provider<ChatLocalRepo> provider2, Provider<ChatLocalTerminalInfoRepo> provider3, Provider<ChatDatabaseHelper> provider4) {
        return new ChatLocalHistoryRepoImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ChatLocalHistoryRepoImpl c(ChatLocalMessagesRepo chatLocalMessagesRepo, ChatLocalRepo chatLocalRepo, ChatLocalTerminalInfoRepo chatLocalTerminalInfoRepo, ChatDatabaseHelper chatDatabaseHelper) {
        return new ChatLocalHistoryRepoImpl(chatLocalMessagesRepo, chatLocalRepo, chatLocalTerminalInfoRepo, chatDatabaseHelper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatLocalHistoryRepoImpl get() {
        return c(this.f39732a.get(), this.f39733b.get(), this.f39734c.get(), this.f39735d.get());
    }
}
