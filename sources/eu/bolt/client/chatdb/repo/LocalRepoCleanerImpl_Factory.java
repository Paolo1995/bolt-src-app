package eu.bolt.client.chatdb.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.client.chatdb.room.ChatDatabaseHelper;
import eu.bolt.client.chatdb.room.chat.ChatDao;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class LocalRepoCleanerImpl_Factory implements Factory<LocalRepoCleanerImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MessagesDao> f39768a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatDao> f39769b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TerminalMessagesDao> f39770c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatDatabaseHelper> f39771d;

    public LocalRepoCleanerImpl_Factory(Provider<MessagesDao> provider, Provider<ChatDao> provider2, Provider<TerminalMessagesDao> provider3, Provider<ChatDatabaseHelper> provider4) {
        this.f39768a = provider;
        this.f39769b = provider2;
        this.f39770c = provider3;
        this.f39771d = provider4;
    }

    public static LocalRepoCleanerImpl_Factory a(Provider<MessagesDao> provider, Provider<ChatDao> provider2, Provider<TerminalMessagesDao> provider3, Provider<ChatDatabaseHelper> provider4) {
        return new LocalRepoCleanerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static LocalRepoCleanerImpl c(MessagesDao messagesDao, ChatDao chatDao, TerminalMessagesDao terminalMessagesDao, ChatDatabaseHelper chatDatabaseHelper) {
        return new LocalRepoCleanerImpl(messagesDao, chatDao, terminalMessagesDao, chatDatabaseHelper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocalRepoCleanerImpl get() {
        return c(this.f39768a.get(), this.f39769b.get(), this.f39770c.get(), this.f39771d.get());
    }
}
