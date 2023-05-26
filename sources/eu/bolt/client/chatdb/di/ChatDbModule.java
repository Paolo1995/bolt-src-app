package eu.bolt.client.chatdb.di;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import dagger.Module;
import dagger.Provides;
import eu.bolt.chat.chatcore.repo.ChatLocalHistoryRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo;
import eu.bolt.chat.chatcore.repo.LocalRepoCleaner;
import eu.bolt.client.chatdb.repo.ChatLocalHistoryRepoImpl;
import eu.bolt.client.chatdb.repo.LocalChatMessagesRepoImpl;
import eu.bolt.client.chatdb.repo.LocalChatRepoImpl;
import eu.bolt.client.chatdb.repo.LocalChatTerminalInfoRepoImpl;
import eu.bolt.client.chatdb.repo.LocalRepoCleanerImpl;
import eu.bolt.client.chatdb.room.ChatDatabase;
import eu.bolt.client.chatdb.room.chat.ChatDao;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDbModule.kt */
@Module
/* loaded from: classes5.dex */
public final class ChatDbModule {
    @Provides
    @Singleton
    public final ChatDao a(ChatDatabase database) {
        Intrinsics.f(database, "database");
        return database.G();
    }

    @Provides
    @Singleton
    public final ChatLocalHistoryRepo b(ChatLocalHistoryRepoImpl repo) {
        Intrinsics.f(repo, "repo");
        return repo;
    }

    @Provides
    @Singleton
    public final MessagesDao c(ChatDatabase database) {
        Intrinsics.f(database, "database");
        return database.H();
    }

    @Provides
    @Singleton
    public final ChatLocalMessagesRepo d(LocalChatMessagesRepoImpl chatLocalChatMessagesRepo) {
        Intrinsics.f(chatLocalChatMessagesRepo, "chatLocalChatMessagesRepo");
        return chatLocalChatMessagesRepo;
    }

    @Provides
    @Singleton
    public final ChatLocalRepo e(LocalChatRepoImpl chatLocalChatRepo) {
        Intrinsics.f(chatLocalChatRepo, "chatLocalChatRepo");
        return chatLocalChatRepo;
    }

    @Provides
    @Singleton
    public final ChatLocalTerminalInfoRepo f(LocalChatTerminalInfoRepoImpl chatTerminalInfoRepoImpl) {
        Intrinsics.f(chatTerminalInfoRepoImpl, "chatTerminalInfoRepoImpl");
        return chatTerminalInfoRepoImpl;
    }

    @Provides
    @Singleton
    public final LocalRepoCleaner g(LocalRepoCleanerImpl chatLocalChatRepo) {
        Intrinsics.f(chatLocalChatRepo, "chatLocalChatRepo");
        return chatLocalChatRepo;
    }

    @Provides
    @Singleton
    public final ChatDatabase h(Context context) {
        Intrinsics.f(context, "context");
        RoomDatabase d8 = Room.a(context, ChatDatabase.class, "chat_db").e().d();
        Intrinsics.e(d8, "databaseBuilder(\n       …on()\n            .build()");
        return (ChatDatabase) d8;
    }

    @Provides
    @Singleton
    public final TerminalMessagesDao i(ChatDatabase database) {
        Intrinsics.f(database, "database");
        return database.I();
    }
}
