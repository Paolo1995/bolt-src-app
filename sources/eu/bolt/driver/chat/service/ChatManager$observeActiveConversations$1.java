package eu.bolt.driver.chat.service;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManager.kt */
/* loaded from: classes5.dex */
public final class ChatManager$observeActiveConversations$1 extends Lambda implements Function1<List<? extends OrderHandleEntity>, ObservableSource<? extends List<? extends ChatEntity>>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ChatManager f40462f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManager$observeActiveConversations$1(ChatManager chatManager) {
        super(1);
        this.f40462f = chatManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: d */
    public final ObservableSource<? extends List<ChatEntity>> invoke(List<OrderHandleEntity> orderHandles) {
        int v7;
        ChatRepo chatRepo;
        Intrinsics.f(orderHandles, "orderHandles");
        Kalev.b("Orders updated: " + orderHandles);
        ChatManager chatManager = this.f40462f;
        v7 = CollectionsKt__IterablesKt.v(orderHandles, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (OrderHandleEntity orderHandleEntity : orderHandles) {
            chatRepo = chatManager.f40456c;
            arrayList.add(chatRepo.d(orderHandleEntity));
        }
        final ChatManager$observeActiveConversations$1$combined$1 chatManager$observeActiveConversations$1$combined$1 = new Function1<Object[], List<? extends Optional<ChatEntity>>>() { // from class: eu.bolt.driver.chat.service.ChatManager$observeActiveConversations$1$combined$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<Optional<ChatEntity>> invoke(Object[] array) {
                Intrinsics.f(array, "array");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : array) {
                    if (obj instanceof Optional) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        };
        Observable combineLatest = Observable.combineLatest(arrayList, new Function() { // from class: eu.bolt.driver.chat.service.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List e8;
                e8 = ChatManager$observeActiveConversations$1.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(chatObserv…tEntity>>()\n            }");
        final AnonymousClass1 anonymousClass1 = new Function1<List<? extends Optional<ChatEntity>>, List<? extends ChatEntity>>() { // from class: eu.bolt.driver.chat.service.ChatManager$observeActiveConversations$1.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChatEntity> invoke(List<Optional<ChatEntity>> optionals) {
                ChatEntity chatEntity;
                Intrinsics.f(optionals, "optionals");
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = optionals.iterator();
                while (it.hasNext()) {
                    Optional optional = (Optional) it.next();
                    if (optional.isPresent()) {
                        chatEntity = (ChatEntity) optional.get();
                    } else {
                        chatEntity = null;
                    }
                    if (chatEntity != null) {
                        arrayList2.add(chatEntity);
                    }
                }
                return arrayList2;
            }
        };
        return combineLatest.map(new Function() { // from class: eu.bolt.driver.chat.service.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List g8;
                g8 = ChatManager$observeActiveConversations$1.g(Function1.this, obj);
                return g8;
            }
        });
    }
}
