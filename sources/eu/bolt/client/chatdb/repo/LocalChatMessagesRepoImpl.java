package eu.bolt.client.chatdb.repo;

import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.client.chatdb.room.message.MessageDBModel;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import eu.bolt.client.chatdb.room.message.mapper.MessageMapper;
import eu.bolt.client.chatdb.room.message.mapper.MessageStatusMapper;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalChatMessagesRepoImpl.kt */
/* loaded from: classes5.dex */
public final class LocalChatMessagesRepoImpl implements ChatLocalMessagesRepo {

    /* renamed from: a  reason: collision with root package name */
    private final MessagesDao f39736a;

    /* renamed from: b  reason: collision with root package name */
    private final UserInfoProvider f39737b;

    /* renamed from: c  reason: collision with root package name */
    private final MessageMapper f39738c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageStatusMapper f39739d;

    /* renamed from: e  reason: collision with root package name */
    private final PublishRelay<ChatMessageEntity> f39740e;

    @Inject
    public LocalChatMessagesRepoImpl(MessagesDao messagesDao, UserInfoProvider userInfoProvider, MessageMapper messageMapper, MessageStatusMapper messageStatusMapper) {
        Intrinsics.f(messagesDao, "messagesDao");
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        Intrinsics.f(messageMapper, "messageMapper");
        Intrinsics.f(messageStatusMapper, "messageStatusMapper");
        this.f39736a = messagesDao;
        this.f39737b = userInfoProvider;
        this.f39738c = messageMapper;
        this.f39739d = messageStatusMapper;
        PublishRelay<ChatMessageEntity> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<ChatMessageEntity>()");
        this.f39740e = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(LocalChatMessagesRepoImpl this$0, ChatMessageEntity message) {
        MessageDBModel b8;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(message, "$message");
        synchronized (this$0) {
            MessageDBModel c8 = this$0.f39736a.c(message.b(), message.d());
            if (c8 == null) {
                this$0.f39740e.accept(message);
            }
            if (c8 != null) {
                b8 = this$0.v(c8, this$0.f39738c.b(message));
            } else {
                b8 = this$0.f39738c.b(message);
            }
            this$0.f39736a.g(b8);
            Unit unit = Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    private final MessageDBModel v(MessageDBModel messageDBModel, MessageDBModel messageDBModel2) {
        MessageDBModel a8;
        if (messageDBModel.k().c() > messageDBModel2.k().c()) {
            a8 = messageDBModel2.a((r30 & 1) != 0 ? messageDBModel2.f39823a : null, (r30 & 2) != 0 ? messageDBModel2.f39824b : null, (r30 & 4) != 0 ? messageDBModel2.f39825c : 0, (r30 & 8) != 0 ? messageDBModel2.f39826d : null, (r30 & 16) != 0 ? messageDBModel2.f39827e : null, (r30 & 32) != 0 ? messageDBModel2.f39828f : null, (r30 & 64) != 0 ? messageDBModel2.f39829g : null, (r30 & 128) != 0 ? messageDBModel2.f39830h : null, (r30 & Spliterator.NONNULL) != 0 ? messageDBModel2.f39831i : 0L, (r30 & 512) != 0 ? messageDBModel2.f39832j : messageDBModel.k(), (r30 & Spliterator.IMMUTABLE) != 0 ? messageDBModel2.f39833k : 0, (r30 & 2048) != 0 ? messageDBModel2.f39834l : false, (r30 & 4096) != 0 ? messageDBModel2.f39835m : null);
            return a8;
        }
        return messageDBModel2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Flowable<List<ChatMessageEntity>> b(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Flowable<List<MessageDBModel>> d8 = this.f39736a.d(chatId);
        final Function1<List<? extends MessageDBModel>, List<? extends ChatMessageEntity>> function1 = new Function1<List<? extends MessageDBModel>, List<? extends ChatMessageEntity>>() { // from class: eu.bolt.client.chatdb.repo.LocalChatMessagesRepoImpl$observeChatMessages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChatMessageEntity> invoke(List<MessageDBModel> list) {
                int v7;
                MessageMapper messageMapper;
                Intrinsics.f(list, "list");
                LocalChatMessagesRepoImpl localChatMessagesRepoImpl = LocalChatMessagesRepoImpl.this;
                v7 = CollectionsKt__IterablesKt.v(list, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (MessageDBModel messageDBModel : list) {
                    messageMapper = localChatMessagesRepoImpl.f39738c;
                    arrayList.add(messageMapper.a(messageDBModel));
                }
                return arrayList;
            }
        };
        Flowable<List<ChatMessageEntity>> m8 = d8.J(new Function() { // from class: eu.bolt.client.chatdb.repo.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List x7;
                x7 = LocalChatMessagesRepoImpl.x(Function1.this, obj);
                return x7;
            }
        }).m();
        Intrinsics.e(m8, "override fun observeChat…  .distinctUntilChanged()");
        return m8;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Flowable<Integer> e(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Flowable<Integer> m8 = this.f39736a.i(this.f39737b.k(), chatId).m();
        Intrinsics.e(m8, "messagesDao.observeUnrea… ).distinctUntilChanged()");
        return m8;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Completable f(List<String> ids) {
        Intrinsics.f(ids, "ids");
        return this.f39736a.k(ids);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Completable g(final ChatMessageEntity message) {
        Intrinsics.f(message, "message");
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.client.chatdb.repo.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                LocalChatMessagesRepoImpl.s(LocalChatMessagesRepoImpl.this, message);
            }
        });
        Intrinsics.e(u7, "fromAction {\n        syn…toInsert)\n        }\n    }");
        return u7;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Flowable<ChatMessageEntity> h() {
        Flowable<ChatMessageEntity> flowable = this.f39740e.toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.e(flowable, "addMessageRelay.toFlowab…kpressureStrategy.LATEST)");
        return flowable;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Single<List<ChatMessageEntity>> i(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Single<List<MessageDBModel>> f8 = this.f39736a.f(this.f39737b.k(), chatId);
        final Function1<List<? extends MessageDBModel>, List<? extends ChatMessageEntity>> function1 = new Function1<List<? extends MessageDBModel>, List<? extends ChatMessageEntity>>() { // from class: eu.bolt.client.chatdb.repo.LocalChatMessagesRepoImpl$getUnreadMessages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChatMessageEntity> invoke(List<MessageDBModel> list) {
                int v7;
                MessageMapper messageMapper;
                Intrinsics.f(list, "list");
                LocalChatMessagesRepoImpl localChatMessagesRepoImpl = LocalChatMessagesRepoImpl.this;
                v7 = CollectionsKt__IterablesKt.v(list, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (MessageDBModel messageDBModel : list) {
                    messageMapper = localChatMessagesRepoImpl.f39738c;
                    arrayList.add(messageMapper.a(messageDBModel));
                }
                return arrayList;
            }
        };
        Single x7 = f8.x(new Function() { // from class: eu.bolt.client.chatdb.repo.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List u7;
                u7 = LocalChatMessagesRepoImpl.u(Function1.this, obj);
                return u7;
            }
        });
        Intrinsics.e(x7, "override fun getUnreadMe…messageMapper.map(it) } }");
        return x7;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Completable j(List<String> ids) {
        Intrinsics.f(ids, "ids");
        return this.f39736a.j(ids);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Completable k(ChatMessageEntity message) {
        Intrinsics.f(message, "message");
        return this.f39736a.l(message.d(), message.f() - 1);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Completable l(String id, ChatMessageStatus state) {
        Intrinsics.f(id, "id");
        Intrinsics.f(state, "state");
        return this.f39736a.m(id, this.f39739d.b(state));
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Flowable<List<ChatMessageEntity>> m() {
        Flowable<List<MessageDBModel>> a8 = this.f39736a.a();
        final Function1<List<? extends MessageDBModel>, List<? extends ChatMessageEntity>> function1 = new Function1<List<? extends MessageDBModel>, List<? extends ChatMessageEntity>>() { // from class: eu.bolt.client.chatdb.repo.LocalChatMessagesRepoImpl$observeAllMessages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChatMessageEntity> invoke(List<MessageDBModel> list) {
                int v7;
                MessageMapper messageMapper;
                Intrinsics.f(list, "list");
                LocalChatMessagesRepoImpl localChatMessagesRepoImpl = LocalChatMessagesRepoImpl.this;
                v7 = CollectionsKt__IterablesKt.v(list, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (MessageDBModel messageDBModel : list) {
                    messageMapper = localChatMessagesRepoImpl.f39738c;
                    arrayList.add(messageMapper.a(messageDBModel));
                }
                return arrayList;
            }
        };
        Flowable<List<ChatMessageEntity>> m8 = a8.J(new Function() { // from class: eu.bolt.client.chatdb.repo.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List w7;
                w7 = LocalChatMessagesRepoImpl.w(Function1.this, obj);
                return w7;
            }
        }).m();
        Intrinsics.e(m8, "override fun observeAllM…  .distinctUntilChanged()");
        return m8;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public synchronized void n(List<ChatMessageEntity> messages) {
        int v7;
        MessageDBModel b8;
        Intrinsics.f(messages, "messages");
        MessagesDao messagesDao = this.f39736a;
        v7 = CollectionsKt__IterablesKt.v(messages, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (ChatMessageEntity chatMessageEntity : messages) {
            MessageDBModel c8 = this.f39736a.c(chatMessageEntity.b(), chatMessageEntity.d());
            if (c8 != null) {
                b8 = v(c8, this.f39738c.b(chatMessageEntity));
            } else {
                b8 = this.f39738c.b(chatMessageEntity);
            }
            arrayList.add(b8);
        }
        messagesDao.h(arrayList);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo
    public Single<List<ChatMessageEntity>> o() {
        Single<List<MessageDBModel>> e8 = this.f39736a.e();
        final Function1<List<? extends MessageDBModel>, List<? extends ChatMessageEntity>> function1 = new Function1<List<? extends MessageDBModel>, List<? extends ChatMessageEntity>>() { // from class: eu.bolt.client.chatdb.repo.LocalChatMessagesRepoImpl$getReadButNotSentMessages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChatMessageEntity> invoke(List<MessageDBModel> list) {
                int v7;
                MessageMapper messageMapper;
                Intrinsics.f(list, "list");
                LocalChatMessagesRepoImpl localChatMessagesRepoImpl = LocalChatMessagesRepoImpl.this;
                v7 = CollectionsKt__IterablesKt.v(list, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (MessageDBModel messageDBModel : list) {
                    messageMapper = localChatMessagesRepoImpl.f39738c;
                    arrayList.add(messageMapper.a(messageDBModel));
                }
                return arrayList;
            }
        };
        Single x7 = e8.x(new Function() { // from class: eu.bolt.client.chatdb.repo.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List t7;
                t7 = LocalChatMessagesRepoImpl.t(Function1.this, obj);
                return t7;
            }
        });
        Intrinsics.e(x7, "override fun getReadButN…messageMapper.map(it) } }");
        return x7;
    }
}
