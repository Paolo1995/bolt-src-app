package eu.bolt.client.chatdb.repo;

import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessageDBModel;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalChatTerminalInfoRepoImpl.kt */
/* loaded from: classes5.dex */
public final class LocalChatTerminalInfoRepoImpl implements ChatLocalTerminalInfoRepo {

    /* renamed from: a  reason: collision with root package name */
    private final TerminalMessagesDao f39757a;

    @Inject
    public LocalChatTerminalInfoRepoImpl(TerminalMessagesDao terminalMessagesDao) {
        Intrinsics.f(terminalMessagesDao, "terminalMessagesDao");
        this.f39757a = terminalMessagesDao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TerminationInfo i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (TerminationInfo) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    private final TerminalMessageDBModel k(TerminationInfo terminationInfo) {
        return new TerminalMessageDBModel(terminationInfo.c(), terminationInfo.a(), terminationInfo.d(), terminationInfo.e(), terminationInfo.b());
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo
    public Single<TerminationInfo> a(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Flowable<List<TerminalMessageDBModel>> b8 = this.f39757a.b(chatId);
        final LocalChatTerminalInfoRepoImpl$getTerminalInfo$1 localChatTerminalInfoRepoImpl$getTerminalInfo$1 = new Function1<List<? extends TerminalMessageDBModel>, Boolean>() { // from class: eu.bolt.client.chatdb.repo.LocalChatTerminalInfoRepoImpl$getTerminalInfo$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(List<TerminalMessageDBModel> it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(!it.isEmpty());
            }
        };
        Flowable<List<TerminalMessageDBModel>> u7 = b8.u(new Predicate() { // from class: eu.bolt.client.chatdb.repo.j
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean h8;
                h8 = LocalChatTerminalInfoRepoImpl.h(Function1.this, obj);
                return h8;
            }
        });
        final LocalChatTerminalInfoRepoImpl$getTerminalInfo$2 localChatTerminalInfoRepoImpl$getTerminalInfo$2 = new Function1<List<? extends TerminalMessageDBModel>, TerminationInfo>() { // from class: eu.bolt.client.chatdb.repo.LocalChatTerminalInfoRepoImpl$getTerminalInfo$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final TerminationInfo invoke(List<TerminalMessageDBModel> list) {
                Object h02;
                Intrinsics.f(list, "list");
                h02 = CollectionsKt___CollectionsKt.h0(list);
                return LocalChatTerminalInfoRepoImplKt.a((TerminalMessageDBModel) h02);
            }
        };
        Single<TerminationInfo> v7 = u7.J(new Function() { // from class: eu.bolt.client.chatdb.repo.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TerminationInfo i8;
                i8 = LocalChatTerminalInfoRepoImpl.i(Function1.this, obj);
                return i8;
            }
        }).v();
        Intrinsics.e(v7, "terminalMessagesDao.getA…}\n        .firstOrError()");
        return v7;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo
    public Completable b(TerminationInfo terminationInfo) {
        Intrinsics.f(terminationInfo, "terminationInfo");
        return this.f39757a.d(k(terminationInfo));
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo
    public Single<Boolean> c(final String chatId) {
        Intrinsics.f(chatId, "chatId");
        Flowable<List<TerminalMessageDBModel>> b8 = this.f39757a.b(chatId);
        final Function1<List<? extends TerminalMessageDBModel>, Boolean> function1 = new Function1<List<? extends TerminalMessageDBModel>, Boolean>() { // from class: eu.bolt.client.chatdb.repo.LocalChatTerminalInfoRepoImpl$isTerminated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(List<TerminalMessageDBModel> messages) {
                Intrinsics.f(messages, "messages");
                String str = chatId;
                boolean z7 = false;
                if (!(messages instanceof Collection) || !messages.isEmpty()) {
                    Iterator<T> it = messages.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.a(((TerminalMessageDBModel) it.next()).a(), str)) {
                            z7 = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z7);
            }
        };
        Single<Boolean> v7 = b8.J(new Function() { // from class: eu.bolt.client.chatdb.repo.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean j8;
                j8 = LocalChatTerminalInfoRepoImpl.j(Function1.this, obj);
                return j8;
            }
        }).v();
        Intrinsics.e(v7, "chatId: String): Single<…}\n        .firstOrError()");
        return v7;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo
    public void d(TerminationInfo terminationInfo) {
        Intrinsics.f(terminationInfo, "terminationInfo");
        this.f39757a.e(k(terminationInfo));
    }
}
