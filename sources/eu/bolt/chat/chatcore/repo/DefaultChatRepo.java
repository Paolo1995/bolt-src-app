package eu.bolt.chat.chatcore.repo;

import com.jakewharton.rxrelay2.BehaviorRelay;
import eu.bolt.chat.chatcore.connection.ChatConnectionController;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatHistoryEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageSeenConfirmationEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.entity.NewChatMessageEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.entity.TerminationInfoStatus;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import eu.bolt.chat.chatcore.network.external.ChatExternalTerminationMessageProvider;
import eu.bolt.chat.chatcore.network.repo.ChatEvent;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegate;
import eu.bolt.chat.extensions.ChatRxExtensionsKt;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.exception.DiagnosisException;
import eu.bolt.chat.tools.logger.Logger;
import eu.bolt.chat.tools.network.NetworkUtilsKt;
import eu.bolt.chat.tools.rx.RetryWithDelaySingle;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.reactivestreams.Publisher;

/* compiled from: DefaultChatRepo.kt */
/* loaded from: classes5.dex */
public final class DefaultChatRepo implements InternalChatRepo {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f38401w = new Companion(null);

    /* renamed from: x  reason: collision with root package name */
    private static final long f38402x = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a  reason: collision with root package name */
    private final ChatLocalMessagesRepo f38403a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatLocalRepo f38404b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatLocalTerminalInfoRepo f38405c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatNetworkRepo f38406d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f38407e;

    /* renamed from: f  reason: collision with root package name */
    private final ChatConnectionController f38408f;

    /* renamed from: g  reason: collision with root package name */
    private final LocalRepoCleaner f38409g;

    /* renamed from: h  reason: collision with root package name */
    private final IdGenerator f38410h;

    /* renamed from: i  reason: collision with root package name */
    private final ChatPushDelegate f38411i;

    /* renamed from: j  reason: collision with root package name */
    private final RxSchedulers f38412j;

    /* renamed from: k  reason: collision with root package name */
    private final QuickRepliesDelegate f38413k;

    /* renamed from: l  reason: collision with root package name */
    private final ChatLocalHistoryRepo f38414l;

    /* renamed from: m  reason: collision with root package name */
    private final ChatExternalTerminationMessageProvider f38415m;

    /* renamed from: n  reason: collision with root package name */
    private final SecurityProviderInstaller f38416n;

    /* renamed from: o  reason: collision with root package name */
    private final CompositeDisposable f38417o;

    /* renamed from: p  reason: collision with root package name */
    private final CompositeDisposable f38418p;

    /* renamed from: q  reason: collision with root package name */
    private final BehaviorRelay<List<ChatMessageEntity>> f38419q;

    /* renamed from: r  reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f38420r;

    /* renamed from: s  reason: collision with root package name */
    private Disposable f38421s;

    /* renamed from: t  reason: collision with root package name */
    private final BehaviorSubject<List<QuickReplyEntity>> f38422t;

    /* renamed from: u  reason: collision with root package name */
    private final Map<String, Disposable> f38423u;

    /* renamed from: v  reason: collision with root package name */
    private final long f38424v;

    /* compiled from: DefaultChatRepo.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DefaultChatRepo(ChatLocalMessagesRepo chatMessagesLocalRepo, ChatLocalRepo chatLocalRepo, ChatLocalTerminalInfoRepo chatLocalTerminalInfoRepo, ChatNetworkRepo chatNetworkRepo, Logger logger, ChatConnectionController connectionController, LocalRepoCleaner localRepoCleaner, IdGenerator idGenerator, ChatPushDelegate pushDelegate, RxSchedulers rxSchedulers, QuickRepliesDelegate quickRepliesDelegate, ChatLocalHistoryRepo chatLocalHistoryRepo, ChatExternalTerminationMessageProvider terminationMessageProvider, SecurityProviderInstaller securityProviderInstaller) {
        List k8;
        Intrinsics.f(chatMessagesLocalRepo, "chatMessagesLocalRepo");
        Intrinsics.f(chatLocalRepo, "chatLocalRepo");
        Intrinsics.f(chatLocalTerminalInfoRepo, "chatLocalTerminalInfoRepo");
        Intrinsics.f(chatNetworkRepo, "chatNetworkRepo");
        Intrinsics.f(logger, "logger");
        Intrinsics.f(connectionController, "connectionController");
        Intrinsics.f(localRepoCleaner, "localRepoCleaner");
        Intrinsics.f(idGenerator, "idGenerator");
        Intrinsics.f(pushDelegate, "pushDelegate");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(quickRepliesDelegate, "quickRepliesDelegate");
        Intrinsics.f(chatLocalHistoryRepo, "chatLocalHistoryRepo");
        Intrinsics.f(terminationMessageProvider, "terminationMessageProvider");
        Intrinsics.f(securityProviderInstaller, "securityProviderInstaller");
        this.f38403a = chatMessagesLocalRepo;
        this.f38404b = chatLocalRepo;
        this.f38405c = chatLocalTerminalInfoRepo;
        this.f38406d = chatNetworkRepo;
        this.f38407e = logger;
        this.f38408f = connectionController;
        this.f38409g = localRepoCleaner;
        this.f38410h = idGenerator;
        this.f38411i = pushDelegate;
        this.f38412j = rxSchedulers;
        this.f38413k = quickRepliesDelegate;
        this.f38414l = chatLocalHistoryRepo;
        this.f38415m = terminationMessageProvider;
        this.f38416n = securityProviderInstaller;
        this.f38417o = new CompositeDisposable();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f38418p = compositeDisposable;
        BehaviorRelay<List<ChatMessageEntity>> e8 = BehaviorRelay.e();
        Intrinsics.e(e8, "create<List<ChatMessageEntity>>()");
        this.f38419q = e8;
        this.f38420r = new CopyOnWriteArraySet<>();
        Disposable a8 = Disposables.a();
        Intrinsics.e(a8, "disposed()");
        this.f38421s = a8;
        k8 = CollectionsKt__CollectionsKt.k();
        BehaviorSubject<List<QuickReplyEntity>> f8 = BehaviorSubject.f(k8);
        Intrinsics.e(f8, "createDefault(emptyList())");
        this.f38422t = f8;
        this.f38423u = new LinkedHashMap();
        this.f38424v = f38402x;
        Flowable<NewChatMessageEntity> L = T0().a0(rxSchedulers.a()).L(rxSchedulers.c());
        Intrinsics.e(L, "observeNewMessages()\n   …erveOn(rxSchedulers.main)");
        ChatRxExtensionsKt.p(ChatRxExtensionsKt.y(L, new Function1<NewChatMessageEntity, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo.1
            {
                super(1);
            }

            public final void b(NewChatMessageEntity newChatMessageEntity) {
                DefaultChatRepo.this.f38411i.b(newChatMessageEntity.a(), newChatMessageEntity.b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NewChatMessageEntity newChatMessageEntity) {
                b(newChatMessageEntity);
                return Unit.f50853a;
            }
        }, null, null, null, 14, null), compositeDisposable);
        Observable<ChatConnectionState> d8 = connectionController.d();
        final AnonymousClass2 anonymousClass2 = new Function1<ChatConnectionState, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo.2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ChatConnectionState it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it == ChatConnectionState.DISCONNECTED) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ChatConnectionState> filter = d8.filter(new Predicate() { // from class: eu.bolt.chat.chatcore.repo.l
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean U;
                U = DefaultChatRepo.U(Function1.this, obj);
                return U;
            }
        });
        Intrinsics.e(filter, "connectionController.obs…ctionState.DISCONNECTED }");
        ChatRxExtensionsKt.p(ChatRxExtensionsKt.A(filter, new Function1<ChatConnectionState, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo.3
            {
                super(1);
            }

            public final void b(ChatConnectionState chatConnectionState) {
                DefaultChatRepo.this.w0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatConnectionState chatConnectionState) {
                b(chatConnectionState);
                return Unit.f50853a;
            }
        }, null, null, null, null, 30, null), compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Maybe<List<ChatMessageEntity>> A0(final List<ChatMessageEntity> list) {
        Maybe<List<String>> C0 = C0();
        final Function1<List<? extends String>, List<? extends ChatMessageEntity>> function1 = new Function1<List<? extends String>, List<? extends ChatMessageEntity>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$filterForActiveChats$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChatMessageEntity> invoke(List<String> activeChatIds) {
                Intrinsics.f(activeChatIds, "activeChatIds");
                List<ChatMessageEntity> list2 = list;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list2) {
                    if (activeChatIds.contains(((ChatMessageEntity) obj).b())) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        };
        Maybe f8 = C0.f(new Function() { // from class: eu.bolt.chat.chatcore.repo.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List B0;
                B0 = DefaultChatRepo.B0(Function1.this, obj);
                return B0;
            }
        });
        Intrinsics.e(f8, "messages: List<ChatMessa…atId in activeChatIds } }");
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource A1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List B0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    private final Maybe<List<String>> C0() {
        Maybe<List<ChatEntity>> b8 = this.f38404b.b();
        final DefaultChatRepo$getActiveChatIds$1 defaultChatRepo$getActiveChatIds$1 = new Function1<List<? extends ChatEntity>, List<? extends String>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$getActiveChatIds$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<String> invoke(List<ChatEntity> list) {
                int v7;
                Intrinsics.f(list, "list");
                v7 = CollectionsKt__IterablesKt.v(list, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (ChatEntity chatEntity : list) {
                    arrayList.add(chatEntity.b());
                }
                return arrayList;
            }
        };
        Maybe f8 = b8.f(new Function() { // from class: eu.bolt.chat.chatcore.repo.t
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List D0;
                D0 = DefaultChatRepo.D0(Function1.this, obj);
                return D0;
            }
        });
        Intrinsics.e(f8, "chatLocalRepo.getActiveC…t -> list.map { it.id } }");
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource C1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List D0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    private final Completable D1(ChatMessageEntity chatMessageEntity, ChatMessageStatus chatMessageStatus) {
        return this.f38403a.l(chatMessageEntity.d(), chatMessageStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<NewChatMessageEntity> E0(final ChatMessageEntity chatMessageEntity) {
        Single<ChatEntity> e8 = this.f38404b.e(chatMessageEntity.b());
        final Function1<ChatEntity, ObservableSource<? extends NewChatMessageEntity>> function1 = new Function1<ChatEntity, ObservableSource<? extends NewChatMessageEntity>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$getChatByMessageObservable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends NewChatMessageEntity> invoke(ChatEntity it) {
                Intrinsics.f(it, "it");
                return Observable.just(new NewChatMessageEntity(ChatMessageEntity.this, it));
            }
        };
        Observable t7 = e8.t(new Function() { // from class: eu.bolt.chat.chatcore.repo.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource F0;
                F0 = DefaultChatRepo.F0(Function1.this, obj);
                return F0;
            }
        });
        Intrinsics.e(t7, "message: ChatMessageEnti…ageEntity(message, it)) }");
        return t7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource F0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    private final long G0() {
        return System.currentTimeMillis() - this.f38424v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable H0(ChatEvent chatEvent) {
        if (chatEvent instanceof ChatEvent.NewMessage) {
            return this.f38403a.g(((ChatEvent.NewMessage) chatEvent).a());
        }
        if (chatEvent instanceof ChatEvent.QuickReplies) {
            return L0(((ChatEvent.QuickReplies) chatEvent).a());
        }
        if (chatEvent instanceof ChatEvent.MessagesSeenConfirmation) {
            return K0(((ChatEvent.MessagesSeenConfirmation) chatEvent).a());
        }
        if (chatEvent instanceof ChatEvent.StartChat) {
            return s1(((ChatEvent.StartChat) chatEvent).a());
        }
        if (chatEvent instanceof ChatEvent.TerminalMessage) {
            Completable y12 = y1(((ChatEvent.TerminalMessage) chatEvent).a());
            Intrinsics.e(y12, "terminateChat(event.terminationInfo)");
            return y12;
        } else if (chatEvent instanceof ChatEvent.ServiceMessage) {
            return this.f38403a.g(((ChatEvent.ServiceMessage) chatEvent).a());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(final String str) {
        Single<Boolean> c8 = this.f38405c.c(str);
        final Function1<Boolean, CompletableSource> function1 = new Function1<Boolean, CompletableSource>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$handleChatNotExists$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(Boolean isTerminated) {
                ChatLocalTerminalInfoRepo chatLocalTerminalInfoRepo;
                TerminationInfo x02;
                Intrinsics.f(isTerminated, "isTerminated");
                if (!isTerminated.booleanValue()) {
                    chatLocalTerminalInfoRepo = DefaultChatRepo.this.f38405c;
                    x02 = DefaultChatRepo.this.x0(str);
                    return chatLocalTerminalInfoRepo.b(x02);
                }
                return Completable.g();
            }
        };
        Completable s7 = c8.s(new Function() { // from class: eu.bolt.chat.chatcore.repo.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource J0;
                J0 = DefaultChatRepo.J0(Function1.this, obj);
                return J0;
            }
        });
        Intrinsics.e(s7, "private fun handleChatNo…ongLivedDisposable)\n    }");
        ChatRxExtensionsKt.p(ChatRxExtensionsKt.x(s7, null, null, null, 7, null), this.f38418p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource J0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    private final Completable K0(List<String> list) {
        return this.f38403a.j(list);
    }

    private final Completable L0(final List<QuickReplyEntity> list) {
        Completable v7 = Completable.v(new Callable() { // from class: eu.bolt.chat.chatcore.repo.r
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit M0;
                M0 = DefaultChatRepo.M0(DefaultChatRepo.this, list);
                return M0;
            }
        });
        Intrinsics.e(v7, "fromCallable {\n        q…onNext(suggestions)\n    }");
        return v7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(DefaultChatRepo this$0, List suggestions) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(suggestions, "$suggestions");
        this$0.f38422t.onNext(suggestions);
        return Unit.f50853a;
    }

    private final synchronized void N0(final ChatConnectionEntity chatConnectionEntity) {
        this.f38408f.b(ChatConnectionState.CONNECTING);
        Completable I = this.f38416n.a().d(this.f38406d.d(chatConnectionEntity, new Function0<Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$initConnection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                DefaultChatRepo.this.V0();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        })).I(this.f38412j.b());
        Intrinsics.e(I, "@Synchronized\n    privat….addToDisposables()\n    }");
        v0(ChatRxExtensionsKt.x(I, new Function0<Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$initConnection$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                DefaultChatRepo.this.u1(chatConnectionEntity);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, new Function1<Throwable, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$initConnection$3
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
                Logger logger;
                ChatConnectionController chatConnectionController;
                Intrinsics.f(it, "it");
                logger = DefaultChatRepo.this.f38407e;
                logger.c(it);
                chatConnectionController = DefaultChatRepo.this.f38408f;
                chatConnectionController.e();
            }
        }, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean O0(ChatMessageStatus chatMessageStatus) {
        if (chatMessageStatus instanceof ChatMessageStatus.SendingError) {
            return true;
        }
        return chatMessageStatus instanceof ChatMessageStatus.Sending;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable P0(final ChatMessageEntity chatMessageEntity) {
        return D1(chatMessageEntity, ChatMessageStatus.SendingError.f38167b).n(new Action() { // from class: eu.bolt.chat.chatcore.repo.p
            @Override // io.reactivex.functions.Action
            public final void run() {
                DefaultChatRepo.Q0(DefaultChatRepo.this, chatMessageEntity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(DefaultChatRepo this$0, ChatMessageEntity message) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(message, "$message");
        this$0.f38420r.remove(message.d());
    }

    private final Completable R0(final ChatMessageEntity chatMessageEntity) {
        return D1(chatMessageEntity, ChatMessageStatus.PreliminaryDeliveredToBackend.f38164b).n(new Action() { // from class: eu.bolt.chat.chatcore.repo.u
            @Override // io.reactivex.functions.Action
            public final void run() {
                DefaultChatRepo.S0(DefaultChatRepo.this, chatMessageEntity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(DefaultChatRepo this$0, ChatMessageEntity message) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(message, "$message");
        this$0.f38420r.remove(message.d());
    }

    private final Flowable<NewChatMessageEntity> T0() {
        Flowable<ChatMessageEntity> h8 = this.f38403a.h();
        final Function1<ChatMessageEntity, Publisher<? extends NewChatMessageEntity>> function1 = new Function1<ChatMessageEntity, Publisher<? extends NewChatMessageEntity>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$observeNewMessages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Publisher<? extends NewChatMessageEntity> invoke(ChatMessageEntity message) {
                Observable E0;
                Intrinsics.f(message, "message");
                E0 = DefaultChatRepo.this.E0(message);
                return E0.onErrorResumeNext(Observable.empty()).toFlowable(BackpressureStrategy.LATEST);
            }
        };
        return h8.w(new Function() { // from class: eu.bolt.chat.chatcore.repo.z
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher U0;
                U0 = DefaultChatRepo.U0(Function1.this, obj);
                return U0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher U0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0() {
        Flowable<ChatEvent> g8 = this.f38406d.g();
        final DefaultChatRepo$onClientInit$1 defaultChatRepo$onClientInit$1 = new DefaultChatRepo$onClientInit$1(this);
        Completable I = g8.z(new Function() { // from class: eu.bolt.chat.chatcore.repo.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource W0;
                W0 = DefaultChatRepo.W0(Function1.this, obj);
                return W0;
            }
        }).I(this.f38412j.b());
        Intrinsics.e(I, "private fun onClientInit….addToDisposables()\n    }");
        v0(ChatRxExtensionsKt.x(I, null, null, null, 7, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource W0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable X0(List<ChatMessageEntity> list) {
        int v7;
        Sequence O;
        Sequence v8;
        List<String> D;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String b8 = ((ChatMessageEntity) obj).b();
            Object obj2 = linkedHashMap.get(b8);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(b8, obj2);
            }
            ((List) obj2).add(obj);
        }
        Set<Map.Entry> entrySet = linkedHashMap.entrySet();
        v7 = CollectionsKt__IterablesKt.v(entrySet, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Map.Entry entry : entrySet) {
            O = CollectionsKt___CollectionsKt.O((List) entry.getValue());
            v8 = SequencesKt___SequencesKt.v(O, new Function1<ChatMessageEntity, String>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessageSeenConfirmations$routines$2$messageIds$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final String invoke(ChatMessageEntity messageEntity) {
                    Intrinsics.f(messageEntity, "messageEntity");
                    return messageEntity.d();
                }
            });
            D = SequencesKt___SequencesKt.D(v8);
            arrayList.add(k1((String) entry.getKey(), D));
        }
        Completable x7 = Completable.x(arrayList);
        Intrinsics.e(x7, "merge(routines)");
        return x7;
    }

    private final void Y0() {
        Observable<ChatConnectionState> d8 = this.f38408f.d();
        final DefaultChatRepo$resendMessagesOnConnection$1 defaultChatRepo$resendMessagesOnConnection$1 = new Function1<ChatConnectionState, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ChatConnectionState it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it == ChatConnectionState.CONNECTED) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ChatConnectionState> filter = d8.filter(new Predicate() { // from class: eu.bolt.chat.chatcore.repo.d0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean Z0;
                Z0 = DefaultChatRepo.Z0(Function1.this, obj);
                return Z0;
            }
        });
        final Function1<ChatConnectionState, ObservableSource<? extends List<? extends ChatMessageEntity>>> function1 = new Function1<ChatConnectionState, ObservableSource<? extends List<? extends ChatMessageEntity>>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends List<ChatMessageEntity>> invoke(ChatConnectionState it) {
                BehaviorRelay behaviorRelay;
                Intrinsics.f(it, "it");
                behaviorRelay = DefaultChatRepo.this.f38419q;
                return behaviorRelay.take(1L);
            }
        };
        Observable<R> switchMap = filter.switchMap(new Function() { // from class: eu.bolt.chat.chatcore.repo.e0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource a12;
                a12 = DefaultChatRepo.a1(Function1.this, obj);
                return a12;
            }
        });
        final DefaultChatRepo$resendMessagesOnConnection$3 defaultChatRepo$resendMessagesOnConnection$3 = new Function1<List<? extends ChatMessageEntity>, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(List<ChatMessageEntity> it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(!it.isEmpty());
            }
        };
        Observable filter2 = switchMap.filter(new Predicate() { // from class: eu.bolt.chat.chatcore.repo.f0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean b12;
                b12 = DefaultChatRepo.b1(Function1.this, obj);
                return b12;
            }
        });
        final Function1<List<? extends ChatMessageEntity>, ObservableSource<? extends List<? extends ChatMessageEntity>>> function12 = new Function1<List<? extends ChatMessageEntity>, ObservableSource<? extends List<? extends ChatMessageEntity>>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends List<ChatMessageEntity>> invoke(List<ChatMessageEntity> it) {
                Maybe A0;
                Intrinsics.f(it, "it");
                A0 = DefaultChatRepo.this.A0(it);
                return A0.l();
            }
        };
        Observable flatMap = filter2.flatMap(new Function() { // from class: eu.bolt.chat.chatcore.repo.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource c12;
                c12 = DefaultChatRepo.c1(Function1.this, obj);
                return c12;
            }
        });
        final DefaultChatRepo$resendMessagesOnConnection$5 defaultChatRepo$resendMessagesOnConnection$5 = new Function1<List<? extends ChatMessageEntity>, Iterable<? extends ChatMessageEntity>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$5
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Iterable<ChatMessageEntity> invoke(List<ChatMessageEntity> it) {
                Intrinsics.f(it, "it");
                return it;
            }
        };
        Observable concatMapIterable = flatMap.concatMapIterable(new Function() { // from class: eu.bolt.chat.chatcore.repo.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Iterable d12;
                d12 = DefaultChatRepo.d1(Function1.this, obj);
                return d12;
            }
        });
        final Function1<ChatMessageEntity, Boolean> function13 = new Function1<ChatMessageEntity, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ChatMessageEntity it) {
                CopyOnWriteArraySet copyOnWriteArraySet;
                Intrinsics.f(it, "it");
                copyOnWriteArraySet = DefaultChatRepo.this.f38420r;
                return Boolean.valueOf(!copyOnWriteArraySet.contains(it.d()));
            }
        };
        Observable filter3 = concatMapIterable.filter(new Predicate() { // from class: eu.bolt.chat.chatcore.repo.d
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean e12;
                e12 = DefaultChatRepo.e1(Function1.this, obj);
                return e12;
            }
        });
        final Function1<ChatMessageEntity, CompletableSource> function14 = new Function1<ChatMessageEntity, CompletableSource>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(ChatMessageEntity it) {
                Completable n12;
                Intrinsics.f(it, "it");
                n12 = DefaultChatRepo.this.n1(it);
                return n12;
            }
        };
        Completable I = filter3.concatMapCompletable(new Function() { // from class: eu.bolt.chat.chatcore.repo.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource f12;
                f12 = DefaultChatRepo.f1(Function1.this, obj);
                return f12;
            }
        }).I(this.f38412j.b());
        Intrinsics.e(I, "private fun resendMessag….addToDisposables()\n    }");
        v0(ChatRxExtensionsKt.x(I, null, null, null, 7, null));
        Observable<ChatConnectionState> d9 = this.f38408f.d();
        final DefaultChatRepo$resendMessagesOnConnection$8 defaultChatRepo$resendMessagesOnConnection$8 = new Function1<ChatConnectionState, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$8
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ChatConnectionState it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it == ChatConnectionState.CONNECTED) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<ChatConnectionState> filter4 = d9.filter(new Predicate() { // from class: eu.bolt.chat.chatcore.repo.f
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean g12;
                g12 = DefaultChatRepo.g1(Function1.this, obj);
                return g12;
            }
        });
        final Function1<ChatConnectionState, CompletableSource> function15 = new Function1<ChatConnectionState, CompletableSource>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$resendMessagesOnConnection$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(ChatConnectionState it) {
                Completable i12;
                Intrinsics.f(it, "it");
                i12 = DefaultChatRepo.this.i1();
                return i12;
            }
        };
        Completable I2 = filter4.switchMapCompletable(new Function() { // from class: eu.bolt.chat.chatcore.repo.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource h12;
                h12 = DefaultChatRepo.h1(Function1.this, obj);
                return h12;
            }
        }).I(this.f38412j.b());
        Intrinsics.e(I2, "private fun resendMessag….addToDisposables()\n    }");
        v0(ChatRxExtensionsKt.x(I2, null, null, null, 7, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource a1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource c1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable d1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Iterable) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource f1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource h1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable i1() {
        Single<List<ChatMessageEntity>> o8 = this.f38403a.o();
        final DefaultChatRepo$resendPendingSeenConfirmations$1 defaultChatRepo$resendPendingSeenConfirmations$1 = new DefaultChatRepo$resendPendingSeenConfirmations$1(this);
        Completable s7 = o8.s(new Function() { // from class: eu.bolt.chat.chatcore.repo.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource j12;
                j12 = DefaultChatRepo.j1(Function1.this, obj);
                return j12;
            }
        });
        Intrinsics.e(s7, "chatMessagesLocalRepo.ge…MessageSeenConfirmations)");
        return s7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource j1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable k1(String str, List<String> list) {
        if (list.isEmpty()) {
            Completable g8 = Completable.g();
            Intrinsics.e(g8, "{\n            Completable.complete()\n        }");
            return g8;
        }
        Logger logger = this.f38407e;
        logger.b("repo sending read messages " + list);
        return p1(new ChatMessageSeenConfirmationEntity(this.f38410h.a(), str, list));
    }

    private final Completable l1(List<ChatMessageEntity> list) {
        int v7;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            String b8 = ((ChatMessageEntity) obj).b();
            Object obj2 = linkedHashMap.get(b8);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(b8, obj2);
            }
            ((List) obj2).add(obj);
        }
        Set<Map.Entry> entrySet = linkedHashMap.entrySet();
        v7 = CollectionsKt__IterablesKt.v(entrySet, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Map.Entry entry : entrySet) {
            final String str = (String) entry.getKey();
            final List list2 = (List) entry.getValue();
            Single<List<ChatMessageEntity>> i8 = this.f38403a.i(str);
            final Function1<List<? extends ChatMessageEntity>, CompletableSource> function1 = new Function1<List<? extends ChatMessageEntity>, CompletableSource>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$sendMessageSeenConfirmations$routines$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CompletableSource invoke(List<ChatMessageEntity> unreadMessages) {
                    Sequence O;
                    Sequence v8;
                    final Set F;
                    Sequence O2;
                    Sequence n8;
                    Sequence v9;
                    List D;
                    Completable k12;
                    Intrinsics.f(unreadMessages, "unreadMessages");
                    O = CollectionsKt___CollectionsKt.O(unreadMessages);
                    v8 = SequencesKt___SequencesKt.v(O, new Function1<ChatMessageEntity, String>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$sendMessageSeenConfirmations$routines$2$1$unreadMessagesIds$1
                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: b */
                        public final String invoke(ChatMessageEntity messageEntity) {
                            Intrinsics.f(messageEntity, "messageEntity");
                            return messageEntity.d();
                        }
                    });
                    F = SequencesKt___SequencesKt.F(v8);
                    O2 = CollectionsKt___CollectionsKt.O(list2);
                    n8 = SequencesKt___SequencesKt.n(O2, new Function1<ChatMessageEntity, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$sendMessageSeenConfirmations$routines$2$1$messageIds$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: b */
                        public final Boolean invoke(ChatMessageEntity it) {
                            Intrinsics.f(it, "it");
                            return Boolean.valueOf(F.contains(it.d()));
                        }
                    });
                    v9 = SequencesKt___SequencesKt.v(n8, new Function1<ChatMessageEntity, String>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$sendMessageSeenConfirmations$routines$2$1$messageIds$2
                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: b */
                        public final String invoke(ChatMessageEntity it) {
                            Intrinsics.f(it, "it");
                            return it.d();
                        }
                    });
                    D = SequencesKt___SequencesKt.D(v9);
                    k12 = this.k1(str, D);
                    return k12;
                }
            };
            arrayList.add(i8.s(new Function() { // from class: eu.bolt.chat.chatcore.repo.a
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj3) {
                    CompletableSource m12;
                    m12 = DefaultChatRepo.m1(Function1.this, obj3);
                    return m12;
                }
            }));
        }
        Completable x7 = Completable.x(arrayList);
        Intrinsics.e(x7, "merge(routines)");
        return x7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource m1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized Completable n1(final ChatMessageEntity chatMessageEntity) {
        Completable C;
        if (!chatMessageEntity.a()) {
            C = Completable.t(new IllegalStateException("Message cannot be resend again " + chatMessageEntity));
            Intrinsics.e(C, "{\n            Completabl…ain $message\"))\n        }");
        } else {
            if (!this.f38420r.contains(chatMessageEntity.d())) {
                this.f38420r.add(chatMessageEntity.d());
            }
            Completable d8 = this.f38403a.k(chatMessageEntity).d(this.f38406d.f(chatMessageEntity)).d(R0(chatMessageEntity));
            final Function1<Throwable, CompletableSource> function1 = new Function1<Throwable, CompletableSource>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$sendMessageToNetwork$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CompletableSource invoke(final Throwable it) {
                    Logger logger;
                    Completable P0;
                    Intrinsics.f(it, "it");
                    logger = DefaultChatRepo.this.f38407e;
                    final ChatMessageEntity chatMessageEntity2 = chatMessageEntity;
                    logger.c(new DiagnosisException("CLIENTAPP-8114", false, new Function1<Map<String, Object>, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$sendMessageToNetwork$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void b(Map<String, Object> $receiver) {
                            Intrinsics.f($receiver, "$this$$receiver");
                            $receiver.put("Description", "Sending message to network has failed");
                            $receiver.put("Message", ChatMessageEntity.this);
                            Throwable it2 = it;
                            Intrinsics.e(it2, "it");
                            $receiver.put("Throwable", it2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                            b(map);
                            return Unit.f50853a;
                        }
                    }, 2, null));
                    P0 = DefaultChatRepo.this.P0(chatMessageEntity);
                    return P0;
                }
            };
            C = d8.C(new Function() { // from class: eu.bolt.chat.chatcore.repo.j
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    CompletableSource o12;
                    o12 = DefaultChatRepo.o1(Function1.this, obj);
                    return o12;
                }
            });
            Intrinsics.e(C, "@Synchronized\n    privat…        }\n        }\n    }");
        }
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource o1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    private final Completable p1(ChatMessageSeenConfirmationEntity chatMessageSeenConfirmationEntity) {
        Completable d8 = this.f38403a.f(chatMessageSeenConfirmationEntity.c()).d(this.f38406d.e(chatMessageSeenConfirmationEntity)).d(this.f38403a.j(chatMessageSeenConfirmationEntity.c()));
        final DefaultChatRepo$sendSeenConfirmationsGroupedByChatId$1 defaultChatRepo$sendSeenConfirmationsGroupedByChatId$1 = new DefaultChatRepo$sendSeenConfirmationsGroupedByChatId$1(this.f38407e);
        Completable A = d8.p(new Consumer() { // from class: eu.bolt.chat.chatcore.repo.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DefaultChatRepo.q1(Function1.this, obj);
            }
        }).A();
        Intrinsics.e(A, "chatMessagesLocalRepo.re…       .onErrorComplete()");
        return A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void r1(List<ChatMessageEntity> list) {
        this.f38419q.accept(list);
    }

    private final Completable s1(final ChatEntity chatEntity) {
        Completable v7 = Completable.v(new Callable() { // from class: eu.bolt.chat.chatcore.repo.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit t12;
                t12 = DefaultChatRepo.t1(DefaultChatRepo.this, chatEntity);
                return t12;
            }
        });
        Intrinsics.e(v7, "fromCallable {\n        c…ateChat(chatEntity)\n    }");
        return v7;
    }

    private final Completable t0(final List<ChatMessageEntity> list) {
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.chat.chatcore.repo.y
            @Override // io.reactivex.functions.Action
            public final void run() {
                DefaultChatRepo.u0(list, this);
            }
        });
        Intrinsics.e(u7, "fromAction {\n        if …messages)\n        }\n    }");
        return u7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(DefaultChatRepo this$0, ChatEntity chatEntity) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(chatEntity, "$chatEntity");
        InternalChatRepo.DefaultImpls.a(this$0, chatEntity, null, 2, null);
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(List messages, DefaultChatRepo this$0) {
        Intrinsics.f(messages, "$messages");
        Intrinsics.f(this$0, "this$0");
        if (!messages.isEmpty()) {
            this$0.f38403a.n(messages);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(ChatConnectionEntity chatConnectionEntity) {
        Flowable<List<ChatMessageEntity>> m8 = this.f38403a.m().m();
        final Function1<List<? extends ChatMessageEntity>, List<? extends ChatMessageEntity>> function1 = new Function1<List<? extends ChatMessageEntity>, List<? extends ChatMessageEntity>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$subscribeInitialConnection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0010 A[SYNTHETIC] */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.util.List<eu.bolt.chat.chatcore.entity.ChatMessageEntity> invoke(java.util.List<eu.bolt.chat.chatcore.entity.ChatMessageEntity> r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = "list"
                    kotlin.jvm.internal.Intrinsics.f(r6, r0)
                    eu.bolt.chat.chatcore.repo.DefaultChatRepo r0 = eu.bolt.chat.chatcore.repo.DefaultChatRepo.this
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.Iterator r6 = r6.iterator()
                L10:
                    boolean r2 = r6.hasNext()
                    if (r2 == 0) goto L36
                    java.lang.Object r2 = r6.next()
                    r3 = r2
                    eu.bolt.chat.chatcore.entity.ChatMessageEntity r3 = (eu.bolt.chat.chatcore.entity.ChatMessageEntity) r3
                    boolean r4 = r3.a()
                    if (r4 == 0) goto L2f
                    eu.bolt.chat.chatcore.entity.ChatMessageStatus r3 = r3.i()
                    boolean r3 = eu.bolt.chat.chatcore.repo.DefaultChatRepo.k0(r0, r3)
                    if (r3 == 0) goto L2f
                    r3 = 1
                    goto L30
                L2f:
                    r3 = 0
                L30:
                    if (r3 == 0) goto L10
                    r1.add(r2)
                    goto L10
                L36:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.repo.DefaultChatRepo$subscribeInitialConnection$1.invoke(java.util.List):java.util.List");
            }
        };
        Flowable<R> J = m8.J(new Function() { // from class: eu.bolt.chat.chatcore.repo.a0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List v12;
                v12 = DefaultChatRepo.v1(Function1.this, obj);
                return v12;
            }
        });
        final Function1<List<? extends ChatMessageEntity>, Publisher<? extends List<? extends ChatMessageEntity>>> function12 = new Function1<List<? extends ChatMessageEntity>, Publisher<? extends List<? extends ChatMessageEntity>>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$subscribeInitialConnection$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Publisher<? extends List<ChatMessageEntity>> invoke(List<ChatMessageEntity> it) {
                Maybe A0;
                Intrinsics.f(it, "it");
                A0 = DefaultChatRepo.this.A0(it);
                return A0.k();
            }
        };
        Flowable m9 = J.w(new Function() { // from class: eu.bolt.chat.chatcore.repo.b0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher w12;
                w12 = DefaultChatRepo.w1(Function1.this, obj);
                return w12;
            }
        }).m();
        final Function1<List<? extends ChatMessageEntity>, Unit> function13 = new Function1<List<? extends ChatMessageEntity>, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$subscribeInitialConnection$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<ChatMessageEntity> it) {
                DefaultChatRepo defaultChatRepo = DefaultChatRepo.this;
                Intrinsics.e(it, "it");
                defaultChatRepo.r1(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChatMessageEntity> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Flowable a02 = m9.p(new Consumer() { // from class: eu.bolt.chat.chatcore.repo.c0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DefaultChatRepo.x1(Function1.this, obj);
            }
        }).a0(this.f38412j.b());
        Intrinsics.e(a02, "private fun subscribeIni…atConnectionEntity)\n    }");
        v0(ChatRxExtensionsKt.y(a02, null, null, null, null, 15, null));
        v0(ChatRxExtensionsKt.z(this.f38404b.g(), new Function1<ChatEntity, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$subscribeInitialConnection$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ChatEntity it) {
                Intrinsics.f(it, "it");
                DefaultChatRepo.this.B1(it.b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatEntity chatEntity) {
                b(chatEntity);
                return Unit.f50853a;
            }
        }, null, null, null, 14, null));
        j(chatConnectionEntity);
    }

    private final void v0(Disposable disposable) {
        this.f38417o.b(disposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List v1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void w0() {
        this.f38407e.b("clear chat repo disposables");
        this.f38417o.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher w1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TerminationInfo x0(String str) {
        return new TerminationInfo(this.f38410h.a(), str, this.f38415m.a(), TerminationInfoStatus.UNKNOWN.c(), System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Completable y0(String str) {
        Single<ChatHistoryEntity> F = this.f38406d.c(str).F(new RetryWithDelaySingle(0, 0, new Function1<Throwable, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$fetchChatHistory$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Throwable it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(NetworkUtilsKt.a(it));
            }
        }, this.f38412j.b(), 3, null));
        final Function1<ChatHistoryEntity, CompletableSource> function1 = new Function1<ChatHistoryEntity, CompletableSource>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$fetchChatHistory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(ChatHistoryEntity it) {
                Logger logger;
                ChatLocalHistoryRepo chatLocalHistoryRepo;
                Intrinsics.f(it, "it");
                logger = DefaultChatRepo.this.f38407e;
                logger.b("got history " + it);
                chatLocalHistoryRepo = DefaultChatRepo.this.f38414l;
                return chatLocalHistoryRepo.a(it);
            }
        };
        Completable s7 = F.s(new Function() { // from class: eu.bolt.chat.chatcore.repo.s
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource z02;
                z02 = DefaultChatRepo.z0(Function1.this, obj);
                return z02;
            }
        });
        Intrinsics.e(s7, "private fun fetchChatHis…t(it)\n            }\n    }");
        return s7;
    }

    private final Completable y1(final TerminationInfo terminationInfo) {
        return this.f38405c.b(terminationInfo).d(this.f38409g.a(G0())).d(Completable.v(new Callable() { // from class: eu.bolt.chat.chatcore.repo.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit z12;
                z12 = DefaultChatRepo.z1(DefaultChatRepo.this, terminationInfo);
                return z12;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource z0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(DefaultChatRepo this$0, TerminationInfo terminalMessage) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(terminalMessage, "$terminalMessage");
        this$0.f38411i.a(terminalMessage.a());
        this$0.f38413k.b(terminalMessage.a());
        return Unit.f50853a;
    }

    public synchronized void B1(final String chatId) {
        Intrinsics.f(chatId, "chatId");
        Disposable disposable = this.f38423u.get(chatId);
        if (disposable != null && !disposable.isDisposed()) {
            return;
        }
        Map<String, Disposable> map = this.f38423u;
        Single<Boolean> c8 = this.f38405c.c(chatId);
        final Function1<Boolean, CompletableSource> function1 = new Function1<Boolean, CompletableSource>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$updateChatHistory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(Boolean isTerminated) {
                Completable y02;
                Logger logger;
                Intrinsics.f(isTerminated, "isTerminated");
                if (isTerminated.booleanValue()) {
                    logger = DefaultChatRepo.this.f38407e;
                    logger.b("Chat '" + chatId + "' is terminated. No need to fetch chat history.");
                    return Completable.g();
                }
                y02 = DefaultChatRepo.this.y0(chatId);
                return y02;
            }
        };
        Completable I = c8.s(new Function() { // from class: eu.bolt.chat.chatcore.repo.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource C1;
                C1 = DefaultChatRepo.C1(Function1.this, obj);
                return C1;
            }
        }).I(this.f38412j.b());
        Intrinsics.e(I, "@Synchronized\n    overri…   }\n            })\n    }");
        map.put(chatId, ChatRxExtensionsKt.x(I, null, new Function1<Throwable, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$updateChatHistory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Logger logger;
                Logger logger2;
                Intrinsics.f(it, "it");
                if (it instanceof ChatNotExistsException) {
                    logger2 = DefaultChatRepo.this.f38407e;
                    logger2.d("chat " + chatId + " does not exist");
                    DefaultChatRepo.this.I0(chatId);
                    return;
                }
                logger = DefaultChatRepo.this.f38407e;
                logger.a(it, "got history error");
            }
        }, null, 5, null));
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public synchronized void a(ChatRequestReplySuggestionsEntity entity) {
        Intrinsics.f(entity, "entity");
        this.f38413k.a(entity);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public Flowable<List<ChatMessageEntity>> b(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return this.f38403a.b(chatId);
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public Completable c(ChatEntity chatEntity) {
        Intrinsics.f(chatEntity, "chatEntity");
        return this.f38404b.c(chatEntity);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public Observable<Optional<ChatEntity>> d(OrderHandleEntity orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Observable<Optional<ChatEntity>> subscribeOn = this.f38404b.d(orderHandle).distinctUntilChanged().subscribeOn(this.f38412j.b());
        Intrinsics.e(subscribeOn, "chatLocalRepo.observeAct…scribeOn(rxSchedulers.io)");
        return subscribeOn;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public Flowable<Integer> e(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return this.f38403a.e(chatId);
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public void f(List<ChatMessageEntity> chatMessageEntities) {
        Intrinsics.f(chatMessageEntities, "chatMessageEntities");
        Completable I = l1(chatMessageEntities).I(this.f38412j.b());
        Intrinsics.e(I, "sendMessageSeenConfirmat…scribeOn(rxSchedulers.io)");
        v0(ChatRxExtensionsKt.x(I, null, null, null, 7, null));
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public Completable g(ChatMessageEntity messageEntity) {
        Intrinsics.f(messageEntity, "messageEntity");
        return this.f38403a.g(messageEntity);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public Flowable<List<QuickReplyEntity>> h(String chatId) {
        Intrinsics.f(chatId, "chatId");
        Flowable<List<QuickReplyEntity>> flowable = this.f38422t.toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.e(flowable, "quickReplies.toFlowable(…kpressureStrategy.LATEST)");
        return flowable;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public synchronized void i(ChatConnectionEntity chatConnectionEntity) {
        Intrinsics.f(chatConnectionEntity, "chatConnectionEntity");
        if (this.f38408f.c().e()) {
            this.f38407e.c(new ClientAlreadyConnectingException());
            return;
        }
        N0(chatConnectionEntity);
        Y0();
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public synchronized void j(final ChatConnectionEntity chatConnectionEntity) {
        Intrinsics.f(chatConnectionEntity, "chatConnectionEntity");
        if (!this.f38421s.isDisposed()) {
            return;
        }
        Single<List<ChatEntity>> F = this.f38406d.b().F(new RetryWithDelaySingle(0, 0, new Function1<Throwable, Boolean>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$updateActiveChats$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Throwable it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(NetworkUtilsKt.a(it));
            }
        }, this.f38412j.b(), 3, null));
        final Function1<List<? extends ChatEntity>, SingleSource<? extends List<? extends ChatEntity>>> function1 = new Function1<List<? extends ChatEntity>, SingleSource<? extends List<? extends ChatEntity>>>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$updateActiveChats$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends List<ChatEntity>> invoke(List<ChatEntity> it) {
                ChatLocalRepo chatLocalRepo;
                Intrinsics.f(it, "it");
                chatLocalRepo = DefaultChatRepo.this.f38404b;
                return chatLocalRepo.f(it).f(Single.w(it));
            }
        };
        Single K = F.r(new Function() { // from class: eu.bolt.chat.chatcore.repo.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource A1;
                A1 = DefaultChatRepo.A1(Function1.this, obj);
                return A1;
            }
        }).K(this.f38412j.b());
        Intrinsics.e(K, "@Synchronized\n    overri…isposable.add(it) }\n    }");
        Disposable B = ChatRxExtensionsKt.B(K, new Function1<List<? extends ChatEntity>, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$updateActiveChats$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(List<ChatEntity> chats) {
                ChatConnectionController chatConnectionController;
                Object obj;
                Intrinsics.e(chats, "chats");
                if (!chats.isEmpty()) {
                    chatConnectionController = DefaultChatRepo.this.f38408f;
                    if (chatConnectionController.c() == ChatConnectionState.DISCONNECTED) {
                        DefaultChatRepo.this.i(chatConnectionEntity);
                    }
                    Iterator<T> it = chats.iterator();
                    if (!it.hasNext()) {
                        obj = null;
                    } else {
                        Object next = it.next();
                        if (!it.hasNext()) {
                            obj = next;
                        } else {
                            long d8 = ((ChatEntity) next).d();
                            do {
                                Object next2 = it.next();
                                long d9 = ((ChatEntity) next2).d();
                                if (d8 < d9) {
                                    next = next2;
                                    d8 = d9;
                                }
                            } while (it.hasNext());
                            obj = next;
                        }
                    }
                    ChatEntity chatEntity = (ChatEntity) obj;
                    if (chatEntity != null) {
                        DefaultChatRepo.this.B1(chatEntity.b());
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChatEntity> list) {
                b(list);
                return Unit.f50853a;
            }
        }, null, null, 6, null);
        this.f38418p.b(B);
        this.f38421s = B;
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public void k(ChatEntity chat, List<ChatMessageEntity> initialMessages) {
        Intrinsics.f(chat, "chat");
        Intrinsics.f(initialMessages, "initialMessages");
        Completable I = this.f38404b.c(chat).d(t0(initialMessages)).I(this.f38412j.b());
        Intrinsics.e(I, "chatLocalRepo.addOrUpdat…scribeOn(rxSchedulers.io)");
        ChatRxExtensionsKt.x(I, null, null, null, 7, null);
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public synchronized void l(final Function0<Unit> function0) {
        this.f38407e.b("Disconnecting from chat");
        this.f38413k.c();
        Completable I = this.f38406d.disconnect().I(this.f38412j.b());
        Intrinsics.e(I, "chatNetworkRepo.disconne…scribeOn(rxSchedulers.io)");
        ChatRxExtensionsKt.p(ChatRxExtensionsKt.x(I, null, null, new Function0<Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$disconnect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                Logger logger;
                logger = DefaultChatRepo.this.f38407e;
                logger.b("Disconnected from chat manually");
                Function0<Unit> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, 3, null), this.f38418p);
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public synchronized void m(final ChatMessageEntity message) {
        Intrinsics.f(message, "message");
        if (!this.f38420r.contains(message.d())) {
            this.f38420r.add(message.d());
            Completable I = this.f38403a.g(message).d(n1(message)).I(this.f38412j.b());
            Intrinsics.e(I, "chatMessagesLocalRepo.ad…scribeOn(rxSchedulers.io)");
            v0(ChatRxExtensionsKt.x(I, null, null, null, 7, null));
        } else {
            this.f38407e.c(new DiagnosisException("CLIENTAPP-8114", false, new Function1<Map<String, Object>, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$sendMessage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(Map<String, Object> $receiver) {
                    Intrinsics.f($receiver, "$this$$receiver");
                    $receiver.put("Description", "Trying to send a message that's already being sent");
                    $receiver.put("Message", ChatMessageEntity.this);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                    b(map);
                    return Unit.f50853a;
                }
            }, 2, null));
        }
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public Single<TerminationInfo> n(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return this.f38405c.a(chatId);
    }
}
