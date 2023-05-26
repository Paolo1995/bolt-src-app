package eu.bolt.client.chatdb.repo;

import eu.bolt.chat.chatcore.repo.LocalRepoCleaner;
import eu.bolt.client.chatdb.room.ChatDatabaseHelper;
import eu.bolt.client.chatdb.room.chat.ChatDao;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessageDBModel;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;
import io.reactivex.Completable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalRepoCleanerImpl.kt */
/* loaded from: classes5.dex */
public final class LocalRepoCleanerImpl implements LocalRepoCleaner {

    /* renamed from: a  reason: collision with root package name */
    private final MessagesDao f39762a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatDao f39763b;

    /* renamed from: c  reason: collision with root package name */
    private final TerminalMessagesDao f39764c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatDatabaseHelper f39765d;

    @Inject
    public LocalRepoCleanerImpl(MessagesDao messagesDao, ChatDao chatDao, TerminalMessagesDao terminalMessagesDao, ChatDatabaseHelper databaseHelper) {
        Intrinsics.f(messagesDao, "messagesDao");
        Intrinsics.f(chatDao, "chatDao");
        Intrinsics.f(terminalMessagesDao, "terminalMessagesDao");
        Intrinsics.f(databaseHelper, "databaseHelper");
        this.f39762a = messagesDao;
        this.f39763b = chatDao;
        this.f39764c = terminalMessagesDao;
        this.f39765d = databaseHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(List<TerminalMessageDBModel> list) {
        int v7;
        ChatDao chatDao = this.f39763b;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (TerminalMessageDBModel terminalMessageDBModel : list) {
            arrayList.add(terminalMessageDBModel.a());
        }
        chatDao.a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(List<TerminalMessageDBModel> list) {
        int v7;
        MessagesDao messagesDao = this.f39762a;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (TerminalMessageDBModel terminalMessageDBModel : list) {
            arrayList.add(terminalMessageDBModel.a());
        }
        messagesDao.b(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(List<TerminalMessageDBModel> list) {
        int v7;
        TerminalMessagesDao terminalMessagesDao = this.f39764c;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (TerminalMessageDBModel terminalMessageDBModel : list) {
            arrayList.add(terminalMessageDBModel.c());
        }
        terminalMessagesDao.a(arrayList);
    }

    @Override // eu.bolt.chat.chatcore.repo.LocalRepoCleaner
    public Completable a(final long j8) {
        return this.f39765d.c(new Function0<Unit>() { // from class: eu.bolt.client.chatdb.repo.LocalRepoCleanerImpl$cleanChatsTerminatedBefore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                TerminalMessagesDao terminalMessagesDao;
                terminalMessagesDao = LocalRepoCleanerImpl.this.f39764c;
                List<TerminalMessageDBModel> c8 = terminalMessagesDao.c(j8);
                if (!c8.isEmpty()) {
                    LocalRepoCleanerImpl.this.h(c8);
                    LocalRepoCleanerImpl.this.f(c8);
                    LocalRepoCleanerImpl.this.g(c8);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }
}
