package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.analytics.ChatAnalytics;
import eu.bolt.driver.chat.service.conversation.ConversationData;
import eu.bolt.driver.chat.service.conversation.ConversationManager;
import eu.bolt.driver.chat.ui.notification.ChatNotificationManager;
import eu.bolt.driver.core.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.ui.common.lifecycle.LiveEvent;
import eu.bolt.driver.core.util.CompletableExtKt;
import eu.bolt.driver.core.util.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationViewModel.kt */
/* loaded from: classes5.dex */
public final class ConversationViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final ChatRepo f40673f;

    /* renamed from: g  reason: collision with root package name */
    private final SendChatMessageInteractor f40674g;

    /* renamed from: h  reason: collision with root package name */
    private final RequestReplySuggestionsInteractor f40675h;

    /* renamed from: i  reason: collision with root package name */
    private final ChatAnalytics f40676i;

    /* renamed from: j  reason: collision with root package name */
    private final ChatConnectionProvider f40677j;

    /* renamed from: k  reason: collision with root package name */
    private final ChatManager f40678k;

    /* renamed from: l  reason: collision with root package name */
    private final ChatNotificationManager f40679l;

    /* renamed from: m  reason: collision with root package name */
    private ConversationManager f40680m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<ConversationData> f40681n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveEvent<ConversationNotification> f40682o;

    /* renamed from: p  reason: collision with root package name */
    private String f40683p;

    /* renamed from: q  reason: collision with root package name */
    private final MutableLiveData<ReconnectionState> f40684q;

    @Inject
    public ConversationViewModel(ChatRepo chatRepo, SendChatMessageInteractor sendChatMessageInteractor, RequestReplySuggestionsInteractor quickReplySuggestionsInteractor, ChatAnalytics chatAnalytics, ChatConnectionProvider chatConnectionProvider) {
        Intrinsics.f(chatRepo, "chatRepo");
        Intrinsics.f(sendChatMessageInteractor, "sendChatMessageInteractor");
        Intrinsics.f(quickReplySuggestionsInteractor, "quickReplySuggestionsInteractor");
        Intrinsics.f(chatAnalytics, "chatAnalytics");
        Intrinsics.f(chatConnectionProvider, "chatConnectionProvider");
        this.f40673f = chatRepo;
        this.f40674g = sendChatMessageInteractor;
        this.f40675h = quickReplySuggestionsInteractor;
        this.f40676i = chatAnalytics;
        this.f40677j = chatConnectionProvider;
        DriverChatSdk driverChatSdk = DriverChatSdk.f40388a;
        this.f40678k = driverChatSdk.c();
        this.f40679l = driverChatSdk.d();
        this.f40681n = new MutableLiveData<>();
        this.f40682o = new LiveEvent<>();
        this.f40684q = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(ConversationNotification conversationNotification) {
        this.f40682o.o(conversationNotification);
    }

    private final void L() {
        Observable<Unit> f8 = this.f40677j.f();
        final ConversationViewModel$observeConnectionStatus$1 conversationViewModel$observeConnectionStatus$1 = new ConversationViewModel$observeConnectionStatus$1(this);
        Observable startWith = f8.switchMap(new Function() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.x
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource M;
                M = ConversationViewModel.M(Function1.this, obj);
                return M;
            }
        }).startWith((Observable<R>) ReconnectionState.CONNECTED);
        final Function1<ReconnectionState, Unit> function1 = new Function1<ReconnectionState, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel$observeConnectionStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ReconnectionState reconnectionState) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ConversationViewModel.this.f40684q;
                mutableLiveData.m(reconnectionState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReconnectionState reconnectionState) {
                b(reconnectionState);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.y
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConversationViewModel.N(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel$observeConnectionStatus$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                ConversationViewModel conversationViewModel = ConversationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.m(conversationViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = startWith.subscribe(consumer, new Consumer() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConversationViewModel.O(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeConne…     .autoDispose()\n    }");
        h(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P() {
        ConversationManager conversationManager = this.f40680m;
        if (conversationManager == null) {
            Intrinsics.w("conversationManager");
            conversationManager = null;
        }
        Observable a8 = ObservableExtKt.a(conversationManager.g());
        final Function1<ConversationData, Unit> function1 = new Function1<ConversationData, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel$observerConversation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ConversationData conversationData) {
                ConversationManager conversationManager2;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                conversationManager2 = ConversationViewModel.this.f40680m;
                List<ChatMessageEntity> list = null;
                if (conversationManager2 == null) {
                    Intrinsics.w("conversationManager");
                    conversationManager2 = null;
                }
                mutableLiveData = ConversationViewModel.this.f40681n;
                ConversationData conversationData2 = (ConversationData) mutableLiveData.f();
                if (conversationData2 != null) {
                    list = conversationData2.a();
                }
                if (conversationManager2.f(list, conversationData.a())) {
                    ConversationViewModel.this.Z();
                    ConversationViewModel.this.G(ConversationNotification.NEW_MESSAGE_RECEIVED);
                }
                mutableLiveData2 = ConversationViewModel.this.f40681n;
                mutableLiveData2.o(conversationData);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConversationData conversationData) {
                b(conversationData);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConversationViewModel.Q(Function1.this, obj);
            }
        };
        final ConversationViewModel$observerConversation$2 conversationViewModel$observerConversation$2 = new Function1<Throwable, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel$observerConversation$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Conversation data emitted the error");
            }
        };
        Disposable subscribe = a8.subscribe(consumer, new Consumer() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConversationViewModel.R(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observerConv…     .autoDispose()\n    }");
        h(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void T(ConversationViewModel conversationViewModel, String str, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        conversationViewModel.S(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ConversationViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.G(ConversationNotification.NEW_MESSAGE_SENT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        ConversationManager conversationManager = this.f40680m;
        if (conversationManager == null) {
            Intrinsics.w("conversationManager");
            conversationManager = null;
        }
        Completable a8 = CompletableExtKt.a(conversationManager.j());
        Action action = new Action() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.t
            @Override // io.reactivex.functions.Action
            public final void run() {
                ConversationViewModel.a0();
            }
        };
        final ConversationViewModel$updateQuickReplies$2 conversationViewModel$updateQuickReplies$2 = new Function1<Throwable, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel$updateQuickReplies$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable e8) {
                Intrinsics.e(e8, "e");
                Kalev.e(e8, "Failed to request quick replies update");
            }
        };
        Disposable G = a8.G(action, new Consumer() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConversationViewModel.b0(Function1.this, obj);
            }
        });
        Intrinsics.e(G, "conversationManager.requ…s update\")\n            })");
        h(G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final boolean E(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return this.f40679l.a(chatId);
    }

    public final void F() {
        this.f40678k.f();
    }

    public final LiveData<ConversationData> H() {
        return this.f40681n;
    }

    public final LiveData<ConversationNotification> I() {
        return this.f40682o;
    }

    public final LiveData<ReconnectionState> J() {
        return this.f40684q;
    }

    public final void K(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Kalev.b("Conversation Viewmodel init executed");
        this.f40683p = chatId;
        this.f40680m = new ConversationManager(chatId, this.f40673f, this.f40674g, this.f40675h);
        P();
        Z();
        L();
        F();
    }

    public final void S(String text, String str) {
        Intrinsics.f(text, "text");
        Kalev.b("ConversationVM sendMessage() executed");
        if (str != null) {
            this.f40676i.p2(str);
        }
        ConversationManager conversationManager = this.f40680m;
        if (conversationManager == null) {
            Intrinsics.w("conversationManager");
            conversationManager = null;
        }
        Completable a8 = CompletableExtKt.a(conversationManager.k(text, str));
        Action action = new Action() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.r
            @Override // io.reactivex.functions.Action
            public final void run() {
                ConversationViewModel.U(ConversationViewModel.this);
            }
        };
        final ConversationViewModel$sendMessage$2 conversationViewModel$sendMessage$2 = new Function1<Throwable, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel$sendMessage$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to send message");
            }
        };
        Disposable G = a8.G(action, new Consumer() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConversationViewModel.V(Function1.this, obj);
            }
        });
        Intrinsics.e(G, "conversationManager.send… message\")\n            })");
        h(G);
    }

    public final void W() {
        ChatNotificationManager chatNotificationManager = this.f40679l;
        String str = this.f40683p;
        if (str == null) {
            Intrinsics.w("currentChatId");
            str = null;
        }
        chatNotificationManager.d(str);
    }

    public final void X() {
        ChatNotificationManager chatNotificationManager = this.f40679l;
        String str = this.f40683p;
        if (str == null) {
            Intrinsics.w("currentChatId");
            str = null;
        }
        chatNotificationManager.c(str);
    }

    public final void Y() {
        this.f40676i.j3();
    }

    @Override // eu.bolt.driver.core.ui.base.mvvm.BaseViewModel
    public void n() {
        Kalev.b("Conversation Viewmodel onStart executed");
    }
}
