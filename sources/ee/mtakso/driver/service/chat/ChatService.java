package ee.mtakso.driver.service.chat;

import dagger.Lazy;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.contact.ChatConfiguration;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.token.TokenManager;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.foreground.ChatForegroundProvider;
import eu.bolt.driver.chat.ui.notification.ChatNotificationManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatService.kt */
@Singleton
/* loaded from: classes3.dex */
public final class ChatService {

    /* renamed from: a  reason: collision with root package name */
    private final DriverChatUserInfoProvider f23999a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy<ChatRepo> f24000b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderProvider f24001c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatConfigManager f24002d;

    /* renamed from: e  reason: collision with root package name */
    private final TokenManager f24003e;

    /* renamed from: f  reason: collision with root package name */
    private final ChatForegroundProvider f24004f;

    /* renamed from: g  reason: collision with root package name */
    private final Lazy<ChatManager> f24005g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f24006h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f24007i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f24008j;

    /* renamed from: k  reason: collision with root package name */
    private final BehaviorSubject<ChatScreenState> f24009k;

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.Lazy f24010l;

    /* renamed from: m  reason: collision with root package name */
    private final kotlin.Lazy f24011m;

    /* renamed from: n  reason: collision with root package name */
    private final kotlin.Lazy f24012n;

    /* compiled from: ChatService.kt */
    /* loaded from: classes3.dex */
    public static final class ChatScreenState {

        /* renamed from: a  reason: collision with root package name */
        private final List<ChatState> f24013a;

        /* JADX WARN: Multi-variable type inference failed */
        public ChatScreenState(List<? extends ChatState> chatStates) {
            Intrinsics.f(chatStates, "chatStates");
            this.f24013a = chatStates;
        }

        public final List<ChatState> a() {
            return this.f24013a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ChatScreenState) && Intrinsics.a(this.f24013a, ((ChatScreenState) obj).f24013a);
        }

        public int hashCode() {
            return this.f24013a.hashCode();
        }

        public String toString() {
            List<ChatState> list = this.f24013a;
            return "ChatScreenState(chatStates=" + list + ")";
        }
    }

    /* compiled from: ChatService.kt */
    /* loaded from: classes3.dex */
    public static abstract class ChatState {

        /* compiled from: ChatService.kt */
        /* loaded from: classes3.dex */
        public static final class Active extends ChatState {

            /* renamed from: a  reason: collision with root package name */
            private final OrderDetails f24014a;

            /* renamed from: b  reason: collision with root package name */
            private final ChatEntity f24015b;

            /* renamed from: c  reason: collision with root package name */
            private final int f24016c;

            /* renamed from: d  reason: collision with root package name */
            private final ChatMessageEntity f24017d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Active(OrderDetails orderDetails, ChatEntity chatInfo, int i8, ChatMessageEntity chatMessageEntity) {
                super(null);
                Intrinsics.f(orderDetails, "orderDetails");
                Intrinsics.f(chatInfo, "chatInfo");
                this.f24014a = orderDetails;
                this.f24015b = chatInfo;
                this.f24016c = i8;
                this.f24017d = chatMessageEntity;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Active) {
                    Active active = (Active) obj;
                    return Intrinsics.a(this.f24014a, active.f24014a) && Intrinsics.a(this.f24015b, active.f24015b) && this.f24016c == active.f24016c && Intrinsics.a(this.f24017d, active.f24017d);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = ((((this.f24014a.hashCode() * 31) + this.f24015b.hashCode()) * 31) + this.f24016c) * 31;
                ChatMessageEntity chatMessageEntity = this.f24017d;
                return hashCode + (chatMessageEntity == null ? 0 : chatMessageEntity.hashCode());
            }

            public String toString() {
                OrderDetails orderDetails = this.f24014a;
                ChatEntity chatEntity = this.f24015b;
                int i8 = this.f24016c;
                ChatMessageEntity chatMessageEntity = this.f24017d;
                return "Active(orderDetails=" + orderDetails + ", chatInfo=" + chatEntity + ", unreadMessagesCount=" + i8 + ", lastUnreadMessage=" + chatMessageEntity + ")";
            }
        }

        /* compiled from: ChatService.kt */
        /* loaded from: classes3.dex */
        public static final class Inactive extends ChatState {

            /* renamed from: a  reason: collision with root package name */
            public static final Inactive f24018a = new Inactive();

            private Inactive() {
                super(null);
            }
        }

        /* compiled from: ChatService.kt */
        /* loaded from: classes3.dex */
        public static final class LoadingActive extends ChatState {

            /* renamed from: a  reason: collision with root package name */
            private final OrderDetails f24019a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadingActive(OrderDetails orderDetails) {
                super(null);
                Intrinsics.f(orderDetails, "orderDetails");
                this.f24019a = orderDetails;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof LoadingActive) && Intrinsics.a(this.f24019a, ((LoadingActive) obj).f24019a);
            }

            public int hashCode() {
                return this.f24019a.hashCode();
            }

            public String toString() {
                OrderDetails orderDetails = this.f24019a;
                return "LoadingActive(orderDetails=" + orderDetails + ")";
            }
        }

        private ChatState() {
        }

        public /* synthetic */ ChatState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ChatService(DriverChatUserInfoProvider userInfoProvider, Lazy<ChatRepo> lazyChatRepo, OrderProvider orderProvider, ChatConfigManager chatConfigManager, TokenManager tokenManager, ChatForegroundProvider chatForegroundProvider, Lazy<ChatManager> lazyChatManager) {
        List k8;
        kotlin.Lazy b8;
        kotlin.Lazy b9;
        kotlin.Lazy b10;
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        Intrinsics.f(lazyChatRepo, "lazyChatRepo");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(chatConfigManager, "chatConfigManager");
        Intrinsics.f(tokenManager, "tokenManager");
        Intrinsics.f(chatForegroundProvider, "chatForegroundProvider");
        Intrinsics.f(lazyChatManager, "lazyChatManager");
        this.f23999a = userInfoProvider;
        this.f24000b = lazyChatRepo;
        this.f24001c = orderProvider;
        this.f24002d = chatConfigManager;
        this.f24003e = tokenManager;
        this.f24004f = chatForegroundProvider;
        this.f24005g = lazyChatManager;
        Disposable a8 = Disposables.a();
        Intrinsics.e(a8, "disposed()");
        this.f24006h = a8;
        Disposable a9 = Disposables.a();
        Intrinsics.e(a9, "disposed()");
        this.f24007i = a9;
        Disposable a10 = Disposables.a();
        Intrinsics.e(a10, "disposed()");
        this.f24008j = a10;
        k8 = CollectionsKt__CollectionsKt.k();
        BehaviorSubject<ChatScreenState> f8 = BehaviorSubject.f(new ChatScreenState(k8));
        Intrinsics.e(f8, "createDefault(ChatScreenState(emptyList()))");
        this.f24009k = f8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ChatRepo>() { // from class: ee.mtakso.driver.service.chat.ChatService$chatRepo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ChatRepo invoke() {
                Lazy lazy;
                lazy = ChatService.this.f24000b;
                return (ChatRepo) lazy.get();
            }
        });
        this.f24010l = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<ChatNotificationManager>() { // from class: ee.mtakso.driver.service.chat.ChatService$uiNotification$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ChatNotificationManager invoke() {
                return DriverChatSdk.f40388a.d();
            }
        });
        this.f24011m = b9;
        b10 = LazyKt__LazyJVMKt.b(new Function0<ChatManager>() { // from class: ee.mtakso.driver.service.chat.ChatService$chatManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ChatManager invoke() {
                Lazy lazy;
                lazy = ChatService.this.f24005g;
                return (ChatManager) lazy.get();
            }
        });
        this.f24012n = b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        D().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatManager D() {
        return (ChatManager) this.f24012n.getValue();
    }

    private final ChatRepo E() {
        return (ChatRepo) this.f24010l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair G(ChatScreenState lifecycleState, boolean z7) {
        Intrinsics.f(lifecycleState, "lifecycleState");
        return TuplesKt.a(lifecycleState, Boolean.valueOf(z7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ChatService this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.D().h();
        this$0.f24008j.dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final OrderHandleEntity K(OrderHandle orderHandle) {
        return new OrderHandleEntity(orderHandle.b(), orderHandle.c(), Long.valueOf(orderHandle.a()));
    }

    private final Observable<ChatScreenState> L() {
        Observable<List<OrderDetails>> a8 = this.f24001c.a();
        final ChatService$observableLifecycleState$1 chatService$observableLifecycleState$1 = new Function1<List<? extends OrderDetails>, List<? extends OrderDetails>>() { // from class: ee.mtakso.driver.service.chat.ChatService$observableLifecycleState$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<OrderDetails> invoke(List<? extends OrderDetails> list) {
                List<OrderDetails> v02;
                List n8;
                Intrinsics.f(list, "list");
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    n8 = CollectionsKt__CollectionsKt.n(OrderState.ORDER_STATE_DRIVER_ACCEPTED, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT, OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP);
                    if (n8.contains(((OrderDetails) obj).b())) {
                        arrayList.add(obj);
                    }
                }
                v02 = CollectionsKt___CollectionsKt.v0(arrayList, new Comparator() { // from class: ee.mtakso.driver.service.chat.ChatService$observableLifecycleState$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t7, T t8) {
                        int a9;
                        a9 = ComparisonsKt__ComparisonsKt.a(Long.valueOf(((OrderDetails) t7).a().b()), Long.valueOf(((OrderDetails) t8).a().b()));
                        return a9;
                    }
                });
                return v02;
            }
        };
        Observable<R> map = a8.map(new Function() { // from class: ee.mtakso.driver.service.chat.p
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List M;
                M = ChatService.M(Function1.this, obj);
                return M;
            }
        });
        final ChatService$observableLifecycleState$2 chatService$observableLifecycleState$2 = new Function1<List<? extends OrderDetails>, List<? extends OrderHandle>>() { // from class: ee.mtakso.driver.service.chat.ChatService$observableLifecycleState$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<OrderHandle> invoke(List<? extends OrderDetails> orders) {
                int v7;
                Intrinsics.f(orders, "orders");
                v7 = CollectionsKt__IterablesKt.v(orders, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (OrderDetails orderDetails : orders) {
                    arrayList.add(orderDetails.a());
                }
                return arrayList;
            }
        };
        Observable observeOn = map.distinctUntilChanged(new Function() { // from class: ee.mtakso.driver.service.chat.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List N;
                N = ChatService.N(Function1.this, obj);
                return N;
            }
        }).observeOn(Schedulers.c());
        final Function1<List<? extends OrderDetails>, ObservableSource<? extends ChatScreenState>> function1 = new Function1<List<? extends OrderDetails>, ObservableSource<? extends ChatScreenState>>() { // from class: ee.mtakso.driver.service.chat.ChatService$observableLifecycleState$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends ChatService.ChatScreenState> invoke(List<? extends OrderDetails> ordersList) {
                List k8;
                ChatManager D;
                Observable U;
                Intrinsics.f(ordersList, "ordersList");
                if (!ordersList.isEmpty()) {
                    D = ChatService.this.D();
                    D.o();
                    U = ChatService.this.U(ordersList);
                    return U;
                }
                k8 = CollectionsKt__CollectionsKt.k();
                Observable just = Observable.just(new ChatService.ChatScreenState(k8));
                Intrinsics.e(just, "{\n                    Ob…ist()))\n                }");
                return just;
            }
        };
        Observable<ChatScreenState> switchMap = observeOn.switchMap(new Function() { // from class: ee.mtakso.driver.service.chat.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource O;
                O = ChatService.O(Function1.this, obj);
                return O;
            }
        });
        Intrinsics.e(switchMap, "private fun observableLi…    }\n            }\n    }");
        return switchMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    private final Observable<Optional<ChatEntity>> P(OrderHandle orderHandle) {
        Observable<j$.util.Optional<ChatEntity>> d8 = E().d(K(orderHandle));
        final ChatService$observeChatEntity$1 chatService$observeChatEntity$1 = new Function1<j$.util.Optional<ChatEntity>, Optional<ChatEntity>>() { // from class: ee.mtakso.driver.service.chat.ChatService$observeChatEntity$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<ChatEntity> invoke(j$.util.Optional<ChatEntity> optionalChat) {
                Intrinsics.f(optionalChat, "optionalChat");
                if (optionalChat.isPresent()) {
                    return Optional.f(optionalChat.get());
                }
                return Optional.a();
            }
        };
        Observable map = d8.map(new Function() { // from class: ee.mtakso.driver.service.chat.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional Q;
                Q = ChatService.Q(Function1.this, obj);
                return Q;
            }
        });
        Intrinsics.e(map, "chatRepo.observeActiveCh…)\n            }\n        }");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    private final Observable<ChatState> R(final OrderDetails orderDetails) {
        Observable just = Observable.just(new ChatState.LoadingActive(orderDetails));
        Observable<Optional<ChatEntity>> P = P(orderDetails.a());
        final Function1<Optional<ChatEntity>, ObservableSource<? extends ChatState>> function1 = new Function1<Optional<ChatEntity>, ObservableSource<? extends ChatState>>() { // from class: ee.mtakso.driver.service.chat.ChatService$observeChatOrderLifecycleState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends ChatService.ChatState> invoke(Optional<ChatEntity> chatEntity) {
                Observable X;
                Intrinsics.f(chatEntity, "chatEntity");
                ChatEntity c8 = chatEntity.c();
                if (c8 != null) {
                    X = this.X(OrderDetails.this, c8);
                    return X;
                }
                Observable just2 = Observable.just(new ChatService.ChatState.LoadingActive(OrderDetails.this));
                Intrinsics.e(just2, "just(ChatState.LoadingActive(chatOrder))");
                return just2;
            }
        };
        Observable<ChatState> mergeWith = just.mergeWith(P.switchMap(new Function() { // from class: ee.mtakso.driver.service.chat.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource S;
                S = ChatService.S(Function1.this, obj);
                return S;
            }
        }));
        Intrinsics.e(mergeWith, "private fun observeChatO…          }\n            )");
        return mergeWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    private final Observable<ChatState> T(OrderDetails orderDetails) {
        if (orderDetails == null) {
            Observable<ChatState> just = Observable.just(ChatState.Inactive.f24018a);
            Intrinsics.e(just, "{\n            Observable…State.Inactive)\n        }");
            return just;
        }
        return R(orderDetails);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<ChatScreenState> U(List<? extends OrderDetails> list) {
        Object obj;
        List n8;
        Object W;
        List k8;
        if (list.isEmpty()) {
            k8 = CollectionsKt__CollectionsKt.k();
            Observable<ChatScreenState> just = Observable.just(new ChatScreenState(k8));
            Intrinsics.e(just, "just(ChatScreenState(emptyList()))");
            return just;
        } else if (list.size() == 1) {
            W = CollectionsKt___CollectionsKt.W(list);
            Observable<ChatState> R = R((OrderDetails) W);
            final ChatService$observeChatOrderLifecycleStates$1 chatService$observeChatOrderLifecycleStates$1 = new Function1<ChatState, ChatScreenState>() { // from class: ee.mtakso.driver.service.chat.ChatService$observeChatOrderLifecycleStates$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ChatService.ChatScreenState invoke(ChatService.ChatState it) {
                    List e8;
                    Intrinsics.f(it, "it");
                    e8 = CollectionsKt__CollectionsJVMKt.e(it);
                    return new ChatService.ChatScreenState(e8);
                }
            };
            Observable map = R.map(new Function() { // from class: ee.mtakso.driver.service.chat.d
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj2) {
                    ChatService.ChatScreenState V;
                    V = ChatService.V(Function1.this, obj2);
                    return V;
                }
            });
            Intrinsics.e(map, "observeChatOrderLifecycl…Of(it))\n                }");
            return map;
        } else {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    n8 = CollectionsKt__CollectionsKt.n(OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP);
                    if (n8.contains(((OrderDetails) obj).b())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            OrderDetails orderDetails = (OrderDetails) obj;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (!Intrinsics.a((OrderDetails) obj2, orderDetails)) {
                    arrayList.add(obj2);
                }
            }
            Observable<ChatState> T = T(orderDetails);
            Observable<ChatState> T2 = T((OrderDetails) CollectionsKt___CollectionsKt.Y(arrayList));
            final ChatService$observeChatOrderLifecycleStates$2 chatService$observeChatOrderLifecycleStates$2 = new Function2<ChatState, ChatState, ChatScreenState>() { // from class: ee.mtakso.driver.service.chat.ChatService$observeChatOrderLifecycleStates$2
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ChatService.ChatScreenState s(ChatService.ChatState ongoingState, ChatService.ChatState nextState) {
                    List n9;
                    Intrinsics.f(ongoingState, "ongoingState");
                    Intrinsics.f(nextState, "nextState");
                    n9 = CollectionsKt__CollectionsKt.n(ongoingState, nextState);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : n9) {
                        if (!Intrinsics.a((ChatService.ChatState) obj3, ChatService.ChatState.Inactive.f24018a)) {
                            arrayList2.add(obj3);
                        }
                    }
                    return new ChatService.ChatScreenState(arrayList2);
                }
            };
            Observable<ChatScreenState> combineLatest = Observable.combineLatest(T, T2, new BiFunction() { // from class: ee.mtakso.driver.service.chat.e
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj3, Object obj4) {
                    ChatService.ChatScreenState W2;
                    W2 = ChatService.W(Function2.this, obj3, obj4);
                    return W2;
                }
            });
            Intrinsics.e(combineLatest, "combineLatest(\n         …)\n            }\n        )");
            return combineLatest;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatScreenState V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ChatScreenState) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatScreenState W(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ChatScreenState) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<ChatState> X(final OrderDetails orderDetails, final ChatEntity chatEntity) {
        Observable<ChatState> f02 = Flowable.g(E().e(chatEntity.b()), e0(chatEntity.b()), new BiFunction() { // from class: ee.mtakso.driver.service.chat.j
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                ChatService.ChatState.Active Y;
                Y = ChatService.Y(OrderDetails.this, chatEntity, (Integer) obj, (Optional) obj2);
                return Y;
            }
        }).f0();
        Intrinsics.e(f02, "combineLatest<Int, Optio…          .toObservable()");
        return f02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatState.Active Y(OrderDetails chatOrder, ChatEntity chatInfo, Integer unreadMessagesCount, Optional lastUnseenMessage) {
        Intrinsics.f(chatOrder, "$chatOrder");
        Intrinsics.f(chatInfo, "$chatInfo");
        Intrinsics.f(unreadMessagesCount, "unreadMessagesCount");
        Intrinsics.f(lastUnseenMessage, "lastUnseenMessage");
        return new ChatState.Active(chatOrder, chatInfo, unreadMessagesCount.intValue(), (ChatMessageEntity) lastUnseenMessage.c());
    }

    private final void Z() {
        Observable<ChatConnectionState> n8 = D().n();
        final Function1<ChatConnectionState, Unit> function1 = new Function1<ChatConnectionState, Unit>() { // from class: ee.mtakso.driver.service.chat.ChatService$observeConnectionStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ChatConnectionState state) {
                Kalev.h("chat: isConnected = " + state);
                ChatService chatService = ChatService.this;
                Intrinsics.e(state, "state");
                chatService.g0(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatConnectionState chatConnectionState) {
                b(chatConnectionState);
                return Unit.f50853a;
            }
        };
        Consumer<? super ChatConnectionState> consumer = new Consumer() { // from class: ee.mtakso.driver.service.chat.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatService.a0(Function1.this, obj);
            }
        };
        final ChatService$observeConnectionStatus$2 chatService$observeConnectionStatus$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.chat.ChatService$observeConnectionStatus$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable e8) {
                Intrinsics.e(e8, "e");
                Kalev.e(e8, "Reconnect failure");
            }
        };
        Disposable subscribe = n8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.chat.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatService.b0(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeConne…onnect failure\") })\n    }");
        this.f24007i = subscribe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Observable<Boolean> c0() {
        Observable<ChatConfiguration> c8 = this.f24002d.c();
        final ChatService$observeEagerConnectionState$1 chatService$observeEagerConnectionState$1 = new Function1<ChatConfiguration, Boolean>() { // from class: ee.mtakso.driver.service.chat.ChatService$observeEagerConnectionState$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ChatConfiguration it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(it.b());
            }
        };
        Observable map = c8.map(new Function() { // from class: ee.mtakso.driver.service.chat.u
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean d02;
                d02 = ChatService.d0(Function1.this, obj);
                return d02;
            }
        });
        Intrinsics.e(map, "chatConfigManager.observ… .map { it.eagerConnect }");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    private final Flowable<Optional<ChatMessageEntity>> e0(String str) {
        Flowable<List<ChatMessageEntity>> b8 = E().b(str);
        final ChatService$observeLastUnseenMessage$1 chatService$observeLastUnseenMessage$1 = new Function1<List<? extends ChatMessageEntity>, Optional<ChatMessageEntity>>() { // from class: ee.mtakso.driver.service.chat.ChatService$observeLastUnseenMessage$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<ChatMessageEntity> invoke(List<ChatMessageEntity> messages) {
                ChatMessageEntity chatMessageEntity;
                boolean z7;
                Intrinsics.f(messages, "messages");
                ListIterator<ChatMessageEntity> listIterator = messages.listIterator(messages.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        chatMessageEntity = listIterator.previous();
                        ChatMessageEntity chatMessageEntity2 = chatMessageEntity;
                        if (!chatMessageEntity2.o() && !chatMessageEntity2.n() && Intrinsics.a(chatMessageEntity2.i(), ChatMessageStatus.DeliveredToBackend.f38163b)) {
                            z7 = true;
                            continue;
                        } else {
                            z7 = false;
                            continue;
                        }
                        if (z7) {
                            break;
                        }
                    } else {
                        chatMessageEntity = null;
                        break;
                    }
                }
                ChatMessageEntity chatMessageEntity3 = chatMessageEntity;
                if (chatMessageEntity3 == null) {
                    return Optional.a();
                }
                return Optional.f(chatMessageEntity3);
            }
        };
        Flowable J = b8.J(new Function() { // from class: ee.mtakso.driver.service.chat.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional f02;
                f02 = ChatService.f0(Function1.this, obj);
                return f02;
            }
        });
        Intrinsics.e(J, "chatRepo.observeChatMess…          }\n            }");
        return J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(ChatConnectionState chatConnectionState) {
        List<ChatState> a8;
        ChatScreenState g8 = this.f24009k.g();
        boolean z7 = false;
        if (g8 != null && (a8 = g8.a()) != null && !a8.isEmpty()) {
            Iterator<T> it = a8.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!(((ChatState) it.next()) instanceof ChatState.Inactive)) {
                    z7 = true;
                    break;
                }
            }
        }
        if (chatConnectionState == ChatConnectionState.DISCONNECTED && z7) {
            Maybe<Boolean> firstElement = this.f24004f.a().firstElement();
            final Function1<Boolean, CompletableSource> function1 = new Function1<Boolean, CompletableSource>() { // from class: ee.mtakso.driver.service.chat.ChatService$reconnectIfNeeded$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CompletableSource invoke(Boolean it2) {
                    TokenManager tokenManager;
                    Intrinsics.f(it2, "it");
                    if (!it2.booleanValue()) {
                        tokenManager = ChatService.this.f24003e;
                        return tokenManager.H().v();
                    }
                    return Completable.g();
                }
            };
            Completable d8 = firstElement.d(new Function() { // from class: ee.mtakso.driver.service.chat.f
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    CompletableSource h02;
                    h02 = ChatService.h0(Function1.this, obj);
                    return h02;
                }
            });
            Intrinsics.e(d8, "private fun reconnectIfN…oken\") })\n        }\n    }");
            Completable a9 = CompletableExtKt.a(d8);
            Action action = new Action() { // from class: ee.mtakso.driver.service.chat.g
                @Override // io.reactivex.functions.Action
                public final void run() {
                    ChatService.i0(ChatService.this);
                }
            };
            final ChatService$reconnectIfNeeded$3 chatService$reconnectIfNeeded$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.chat.ChatService$reconnectIfNeeded$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable e8) {
                    Intrinsics.e(e8, "e");
                    Kalev.e(e8, "Error updating access token");
                }
            };
            Disposable G = a9.G(action, new Consumer() { // from class: ee.mtakso.driver.service.chat.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ChatService.j0(Function1.this, obj);
                }
            });
            Intrinsics.e(G, "private fun reconnectIfN…oken\") })\n        }\n    }");
            this.f24008j = G;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource h0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(ChatService this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void F() {
        String h8 = this.f23999a.h();
        Kalev.b("chat key: " + h8);
        Observable doOnDispose = Observable.combineLatest(L(), c0(), new BiFunction() { // from class: ee.mtakso.driver.service.chat.c
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair G;
                G = ChatService.G((ChatService.ChatScreenState) obj, ((Boolean) obj2).booleanValue());
                return G;
            }
        }).distinctUntilChanged().doOnDispose(new Action() { // from class: ee.mtakso.driver.service.chat.m
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatService.H(ChatService.this);
            }
        });
        final Function1<Pair<? extends ChatScreenState, ? extends Boolean>, Unit> function1 = new Function1<Pair<? extends ChatScreenState, ? extends Boolean>, Unit>() { // from class: ee.mtakso.driver.service.chat.ChatService$init$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Pair<ChatService.ChatScreenState, Boolean> pair) {
                BehaviorSubject behaviorSubject;
                boolean z7;
                ChatManager D;
                ChatService.ChatScreenState a8 = pair.a();
                boolean booleanValue = pair.b().booleanValue();
                behaviorSubject = ChatService.this.f24009k;
                behaviorSubject.onNext(a8);
                List<ChatService.ChatState> a9 = a8.a();
                boolean z8 = false;
                if (!(a9 instanceof Collection) || !a9.isEmpty()) {
                    for (ChatService.ChatState chatState : a9) {
                        if (!(chatState instanceof ChatService.ChatState.Inactive)) {
                            z7 = false;
                            break;
                        }
                    }
                }
                z7 = true;
                List<ChatService.ChatState> a10 = a8.a();
                if (!(a10 instanceof Collection) || !a10.isEmpty()) {
                    Iterator<T> it = a10.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((ChatService.ChatState) it.next()) instanceof ChatService.ChatState.LoadingActive) {
                                z8 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z8) {
                    if (booleanValue) {
                        ChatService.this.C();
                    }
                } else if (z7) {
                    D = ChatService.this.D();
                    D.h();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends ChatService.ChatScreenState, ? extends Boolean> pair) {
                b(pair);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.chat.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatService.I(Function1.this, obj);
            }
        };
        final ChatService$init$4 chatService$init$4 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.chat.ChatService$init$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable e8) {
                Intrinsics.e(e8, "e");
                Kalev.e(e8, "error updating lifecycle");
            }
        };
        Disposable subscribe = doOnDispose.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.chat.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatService.J(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "fun init() {\n        Kal…eConnectionStatus()\n    }");
        this.f24006h = subscribe;
        Z();
    }

    public final void k0() {
        this.f24002d.e();
    }

    public final void l0(ChatConfiguration configuration) {
        Intrinsics.f(configuration, "configuration");
        this.f24002d.f(configuration);
    }
}
