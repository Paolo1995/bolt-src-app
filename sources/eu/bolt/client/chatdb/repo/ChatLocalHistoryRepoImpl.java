package eu.bolt.client.chatdb.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatHistoryEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.repo.ChatLocalHistoryRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo;
import eu.bolt.client.chatdb.room.ChatDatabaseHelper;
import io.reactivex.Completable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatLocalHistoryRepoImpl.kt */
/* loaded from: classes5.dex */
public final class ChatLocalHistoryRepoImpl implements ChatLocalHistoryRepo {

    /* renamed from: a  reason: collision with root package name */
    private final ChatLocalMessagesRepo f39726a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatLocalRepo f39727b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatLocalTerminalInfoRepo f39728c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatDatabaseHelper f39729d;

    @Inject
    public ChatLocalHistoryRepoImpl(ChatLocalMessagesRepo messagesLocalRepo, ChatLocalRepo chatLocalRepo, ChatLocalTerminalInfoRepo terminalMessagesRepo, ChatDatabaseHelper databaseHelper) {
        Intrinsics.f(messagesLocalRepo, "messagesLocalRepo");
        Intrinsics.f(chatLocalRepo, "chatLocalRepo");
        Intrinsics.f(terminalMessagesRepo, "terminalMessagesRepo");
        Intrinsics.f(databaseHelper, "databaseHelper");
        this.f39726a = messagesLocalRepo;
        this.f39727b = chatLocalRepo;
        this.f39728c = terminalMessagesRepo;
        this.f39729d = databaseHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(List<ChatMessageEntity> list) {
        this.f39726a.n(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(TerminationInfo terminationInfo) {
        this.f39728c.d(terminationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(ChatEntity chatEntity) {
        this.f39727b.h(chatEntity);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalHistoryRepo
    public Completable a(final ChatHistoryEntity chatHistoryEntity) {
        Intrinsics.f(chatHistoryEntity, "chatHistoryEntity");
        return this.f39729d.c(new Function0<Unit>() { // from class: eu.bolt.client.chatdb.repo.ChatLocalHistoryRepoImpl$updateChat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                ChatLocalHistoryRepoImpl.this.g(chatHistoryEntity.a());
                if (!chatHistoryEntity.b().isEmpty()) {
                    ChatLocalHistoryRepoImpl.this.e(chatHistoryEntity.b());
                }
                TerminationInfo c8 = chatHistoryEntity.c();
                if (c8 != null) {
                    ChatLocalHistoryRepoImpl.this.f(c8);
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
