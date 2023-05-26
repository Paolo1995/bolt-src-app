package eu.bolt.client.chatdb.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.repo.ChatLocalRepo;
import eu.bolt.client.chatdb.room.ChatDatabaseHelper;
import eu.bolt.client.chatdb.room.chat.ChatDBModel;
import eu.bolt.client.chatdb.room.chat.ChatDao;
import eu.bolt.client.chatdb.room.chat.OrderHandleDbModel;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalChatRepoImpl.kt */
/* loaded from: classes5.dex */
public final class LocalChatRepoImpl implements ChatLocalRepo {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDao f39749a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatDatabaseHelper f39750b;

    @Inject
    public LocalChatRepoImpl(ChatDao chatDao, ChatDatabaseHelper chatDatabaseHelper) {
        Intrinsics.f(chatDao, "chatDao");
        Intrinsics.f(chatDatabaseHelper, "chatDatabaseHelper");
        this.f39749a = chatDao;
        this.f39750b = chatDatabaseHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatEntity n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ChatEntity) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatEntity o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ChatEntity) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatEntity q(ChatDBModel chatDBModel) {
        return new ChatEntity(chatDBModel.b(), chatDBModel.e(), chatDBModel.f(), chatDBModel.a(), chatDBModel.d(), t(chatDBModel.c()));
    }

    private final ChatDBModel r(ChatEntity chatEntity) {
        return new ChatDBModel(chatEntity.b(), chatEntity.f(), chatEntity.a(), chatEntity.e(), chatEntity.d(), s(chatEntity.c()));
    }

    private final OrderHandleDbModel s(OrderHandleEntity orderHandleEntity) {
        return new OrderHandleDbModel(orderHandleEntity.b(), orderHandleEntity.c(), orderHandleEntity.a());
    }

    private final OrderHandleEntity t(OrderHandleDbModel orderHandleDbModel) {
        return new OrderHandleEntity(orderHandleDbModel.b(), orderHandleDbModel.c(), orderHandleDbModel.a());
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalRepo
    public Maybe<List<ChatEntity>> b() {
        Maybe<List<ChatDBModel>> b8 = this.f39749a.b();
        final Function1<List<? extends ChatDBModel>, List<? extends ChatEntity>> function1 = new Function1<List<? extends ChatDBModel>, List<? extends ChatEntity>>() { // from class: eu.bolt.client.chatdb.repo.LocalChatRepoImpl$getActiveChats$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChatEntity> invoke(List<ChatDBModel> list) {
                int v7;
                ChatEntity q8;
                Intrinsics.f(list, "list");
                LocalChatRepoImpl localChatRepoImpl = LocalChatRepoImpl.this;
                v7 = CollectionsKt__IterablesKt.v(list, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (ChatDBModel chatDBModel : list) {
                    q8 = localChatRepoImpl.q(chatDBModel);
                    arrayList.add(q8);
                }
                return arrayList;
            }
        };
        Maybe f8 = b8.f(new Function() { // from class: eu.bolt.client.chatdb.repo.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m8;
                m8 = LocalChatRepoImpl.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(f8, "override fun getActiveCh….toChatEntity() } }\n    }");
        return f8;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalRepo
    public Completable c(ChatEntity chat) {
        Intrinsics.f(chat, "chat");
        return this.f39749a.e(r(chat));
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalRepo
    public Observable<Optional<ChatEntity>> d(OrderHandleEntity orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Observable<List<ChatDBModel>> g8 = this.f39749a.g(orderHandle.b(), orderHandle.c(), orderHandle.a());
        final Function1<List<? extends ChatDBModel>, Optional<ChatEntity>> function1 = new Function1<List<? extends ChatDBModel>, Optional<ChatEntity>>() { // from class: eu.bolt.client.chatdb.repo.LocalChatRepoImpl$observeActiveChat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<ChatEntity> invoke(List<ChatDBModel> chats) {
                ChatEntity chatEntity;
                Intrinsics.f(chats, "chats");
                ChatDBModel chatDBModel = (ChatDBModel) CollectionsKt___CollectionsKt.Y(chats);
                if (chatDBModel != null) {
                    chatEntity = LocalChatRepoImpl.this.q(chatDBModel);
                } else {
                    chatEntity = null;
                }
                return Optional.ofNullable(chatEntity);
            }
        };
        Observable map = g8.map(new Function() { // from class: eu.bolt.client.chatdb.repo.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional p8;
                p8 = LocalChatRepoImpl.p(Function1.this, obj);
                return p8;
            }
        });
        Intrinsics.e(map, "@Suppress(\"NewApi\") // d…()?.toChatEntity())\n    }");
        return map;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalRepo
    public Single<ChatEntity> e(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Single<ChatDBModel> m8 = this.f39749a.c(chatId).m();
        final Function1<ChatDBModel, ChatEntity> function1 = new Function1<ChatDBModel, ChatEntity>() { // from class: eu.bolt.client.chatdb.repo.LocalChatRepoImpl$getChatById$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ChatEntity invoke(ChatDBModel it) {
                ChatEntity q8;
                Intrinsics.f(it, "it");
                q8 = LocalChatRepoImpl.this.q(it);
                return q8;
            }
        };
        Single x7 = m8.x(new Function() { // from class: eu.bolt.client.chatdb.repo.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ChatEntity n8;
                n8 = LocalChatRepoImpl.n(Function1.this, obj);
                return n8;
            }
        });
        Intrinsics.e(x7, "override fun getChatById…it.toChatEntity() }\n    }");
        return x7;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalRepo
    public Completable f(List<ChatEntity> chats) {
        int v7;
        Intrinsics.f(chats, "chats");
        v7 = CollectionsKt__IterablesKt.v(chats, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (ChatEntity chatEntity : chats) {
            arrayList.add(c(chatEntity));
        }
        Completable y7 = Completable.y(arrayList);
        Intrinsics.e(y7, "mergeDelayError(chats.map { addOrUpdateChat(it) })");
        return y7;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalRepo
    public Maybe<ChatEntity> g() {
        Maybe<ChatDBModel> d8 = this.f39749a.d();
        final Function1<ChatDBModel, ChatEntity> function1 = new Function1<ChatDBModel, ChatEntity>() { // from class: eu.bolt.client.chatdb.repo.LocalChatRepoImpl$getLatestActiveChat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ChatEntity invoke(ChatDBModel it) {
                ChatEntity q8;
                Intrinsics.f(it, "it");
                q8 = LocalChatRepoImpl.this.q(it);
                return q8;
            }
        };
        Maybe f8 = d8.f(new Function() { // from class: eu.bolt.client.chatdb.repo.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ChatEntity o8;
                o8 = LocalChatRepoImpl.o(Function1.this, obj);
                return o8;
            }
        });
        Intrinsics.e(f8, "override fun getLatestAc…it.toChatEntity() }\n    }");
        return f8;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatLocalRepo
    public void h(ChatEntity chat) {
        Intrinsics.f(chat, "chat");
        this.f39749a.f(r(chat));
    }
}
