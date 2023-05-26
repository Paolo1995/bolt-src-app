package eu.bolt.chat.chatcore.chatsdk;

import android.annotation.SuppressLint;
import eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo;
import eu.bolt.chat.chatcore.chatsdk.ChatSdkStatus;
import eu.bolt.chat.chatcore.chatsdk.mapper.ChatMapper;
import eu.bolt.chat.chatcore.chatsdk.mapper.MessageMapper;
import eu.bolt.chat.chatcore.chatsdk.mapper.OrderMapper;
import eu.bolt.chat.chatcore.connection.ChatConnectionController;
import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.entity.connection.ChatConnectionEntity;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import eu.bolt.chat.chatcore.repo.ClientAlreadyConnectingException;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.client.ChatClient;
import eu.bolt.chat.client.ChatClientManager;
import eu.bolt.chat.client.ChatNotificationManager;
import eu.bolt.chat.data.ChatPushMessage;
import eu.bolt.chat.data.ClientStatus;
import eu.bolt.chat.data.OrderHandle;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import j$.util.Optional;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.rx2.RxConvertKt;
import kotlinx.coroutines.rx2.RxSchedulerKt;

/* compiled from: ChatSdkChatRepo.kt */
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo implements InternalChatRepo {

    /* renamed from: a  reason: collision with root package name */
    private final ChatSdkInitializer f37899a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatConnectionController f37900b;

    /* renamed from: c  reason: collision with root package name */
    private final SecurityProviderInstaller f37901c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatPushDelegate f37902d;

    /* renamed from: e  reason: collision with root package name */
    private final RxSchedulers f37903e;

    /* renamed from: f  reason: collision with root package name */
    private final ChatMapper f37904f;

    /* renamed from: g  reason: collision with root package name */
    private final OrderMapper f37905g;

    /* renamed from: h  reason: collision with root package name */
    private final MessageMapper f37906h;

    /* renamed from: i  reason: collision with root package name */
    private final Logger f37907i;

    /* renamed from: j  reason: collision with root package name */
    private final ReentrantLock f37908j;

    /* renamed from: k  reason: collision with root package name */
    private CoroutineScope f37909k;

    /* renamed from: l  reason: collision with root package name */
    private CoroutineScope f37910l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableStateFlow<RepoStatus> f37911m;

    /* renamed from: n  reason: collision with root package name */
    private final Flow<ClientStatus> f37912n;

    /* renamed from: o  reason: collision with root package name */
    private final Flow<ChatPushMessage> f37913o;

    /* renamed from: p  reason: collision with root package name */
    private final Flow<String> f37914p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChatSdkChatRepo.kt */
    /* loaded from: classes5.dex */
    public interface RepoStatus {

        /* compiled from: ChatSdkChatRepo.kt */
        /* loaded from: classes5.dex */
        public static final class Active implements RepoStatus {

            /* renamed from: a  reason: collision with root package name */
            private final ChatClient f38003a;

            public Active(ChatClient chatClient) {
                Intrinsics.f(chatClient, "chatClient");
                this.f38003a = chatClient;
            }

            public final ChatClient a() {
                return this.f38003a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Active) && Intrinsics.a(this.f38003a, ((Active) obj).f38003a);
            }

            public int hashCode() {
                return this.f38003a.hashCode();
            }

            public String toString() {
                return "Active(chatClient=" + this.f38003a + ')';
            }
        }

        /* compiled from: ChatSdkChatRepo.kt */
        /* loaded from: classes5.dex */
        public static final class Idle implements RepoStatus {

            /* renamed from: a  reason: collision with root package name */
            public static final Idle f38004a = new Idle();

            private Idle() {
            }
        }
    }

    /* compiled from: ChatSdkChatRepo.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38005a;

        static {
            int[] iArr = new int[ClientStatus.values().length];
            try {
                iArr[ClientStatus.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClientStatus.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClientStatus.RECONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ClientStatus.DISCONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f38005a = iArr;
        }
    }

    public ChatSdkChatRepo(ChatSdkInitializer chatSdkInitializer, ChatConnectionController connectionController, SecurityProviderInstaller securityProviderInstaller, ChatPushDelegate chatPushDelegate, RxSchedulers rxSchedulers, ChatMapper chatMapper, OrderMapper orderMapper, MessageMapper messageMapper, Logger logger) {
        Intrinsics.f(chatSdkInitializer, "chatSdkInitializer");
        Intrinsics.f(connectionController, "connectionController");
        Intrinsics.f(securityProviderInstaller, "securityProviderInstaller");
        Intrinsics.f(chatPushDelegate, "chatPushDelegate");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(chatMapper, "chatMapper");
        Intrinsics.f(orderMapper, "orderMapper");
        Intrinsics.f(messageMapper, "messageMapper");
        Intrinsics.f(logger, "logger");
        this.f37899a = chatSdkInitializer;
        this.f37900b = connectionController;
        this.f37901c = securityProviderInstaller;
        this.f37902d = chatPushDelegate;
        this.f37903e = rxSchedulers;
        this.f37904f = chatMapper;
        this.f37905g = orderMapper;
        this.f37906h = messageMapper;
        this.f37907i = logger;
        this.f37908j = new ReentrantLock();
        this.f37911m = StateFlowKt.a(RepoStatus.Idle.f38004a);
        this.f37912n = FlowKt.F(FlowKt.I(J(), new ChatSdkChatRepo$special$$inlined$flatMapLatest$1(null)), new ChatSdkChatRepo$connectionStatus$2(this, null));
        this.f37913o = FlowKt.F(FlowKt.I(L(), new ChatSdkChatRepo$special$$inlined$flatMapLatest$2(null)), new ChatSdkChatRepo$showNotificationObserver$2(this, null));
        this.f37914p = FlowKt.F(FlowKt.I(L(), new ChatSdkChatRepo$special$$inlined$flatMapLatest$3(null)), new ChatSdkChatRepo$dismissNotificationObserver$2(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ChatSdkChatRepo this$0, ChatMessageEntity messageEntity) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(messageEntity, "$messageEntity");
        Logger logger = this$0.f37907i;
        logger.b("Attempt to add a message " + messageEntity + " received via a push message. Not allowed anymore in Chat SDK");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ChatSdkChatRepo this$0, ChatEntity chatEntity) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(chatEntity, "$chatEntity");
        Logger logger = this$0.f37907i;
        logger.b("Requested to add a chat " + chatEntity + ". Not allowed anymore in Chat SDK");
    }

    private final CoroutineScope D() {
        return CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).s0(G()));
    }

    private final <T> Flow<T> E(Flow<? extends RepoStatus> flow, T t7, Function2<? super ChatClient, ? super Continuation<? super Flow<? extends T>>, ? extends Object> function2) {
        return FlowKt.I(flow, new ChatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1(null, function2, t7));
    }

    private final ChatSdkStatus F() {
        return this.f37899a.b().getValue();
    }

    private final CoroutineDispatcher G() {
        return RxSchedulerKt.d(this.f37903e.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H(ClientStatus clientStatus, Continuation<? super Unit> continuation) {
        Object d8;
        int i8 = WhenMappings.f38005a[clientStatus.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        if (this.f37900b.c() == ChatConnectionState.RECONNECTING) {
                            this.f37900b.a();
                        } else {
                            this.f37900b.e();
                        }
                        ReentrantLock reentrantLock = this.f37908j;
                        reentrantLock.lock();
                        try {
                            CoroutineScope coroutineScope = this.f37910l;
                            if (coroutineScope != null) {
                                CoroutineScopeKt.d(coroutineScope, null, 1, null);
                            }
                            CoroutineScope coroutineScope2 = this.f37909k;
                            if (coroutineScope2 != null) {
                                CoroutineScopeKt.d(coroutineScope2, null, 1, null);
                            }
                            this.f37910l = null;
                            this.f37909k = null;
                            Unit unit = Unit.f50853a;
                            reentrantLock.unlock();
                            Object b8 = this.f37911m.b(RepoStatus.Idle.f38004a, continuation);
                            d8 = IntrinsicsKt__IntrinsicsKt.d();
                            if (b8 == d8) {
                                return b8;
                            }
                            return Unit.f50853a;
                        } catch (Throwable th) {
                            reentrantLock.unlock();
                            throw th;
                        }
                    }
                } else {
                    this.f37900b.b(ChatConnectionState.RECONNECTING);
                }
            } else {
                this.f37900b.b(ChatConnectionState.CONNECTING);
            }
        } else {
            this.f37900b.g();
        }
        return Unit.f50853a;
    }

    private final void I(CoroutineScope coroutineScope, Function2<? super ChatClient, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ChatSdkChatRepo$launchWhenActive$1(this, function2, null), 3, null);
        } else {
            this.f37907i.d("An action on Chat Client can be performed only after making a connect");
        }
    }

    private final Flow<ChatClient> J() {
        final MutableStateFlow<RepoStatus> mutableStateFlow = this.f37911m;
        final Flow<Object> flow = new Flow<Object>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37940f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1$2", f = "ChatSdkChatRepo.kt", l = {224}, m = "emit")
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37941f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37942g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37941f = obj;
                        this.f37942g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f37940f = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37942g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37942g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f37941f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37942g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f37940f
                        boolean r2 = r5 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.RepoStatus.Active
                        if (r2 == 0) goto L43
                        r0.f37942g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$filterIsInstance$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        };
        return new Flow<ChatClient>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37945f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1$2", f = "ChatSdkChatRepo.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37946f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37947g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37946f = obj;
                        this.f37947g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f37945f = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37947g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37947g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f37946f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37947g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f37945f
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$RepoStatus$Active r5 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.RepoStatus.Active) r5
                        eu.bolt.chat.client.ChatClient r5 = r5.a()
                        r0.f37947g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatClientActive$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super ChatClient> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        };
    }

    @SuppressLint({"NewApi"})
    private final Flow<Optional<TerminationInfo>> K(String str) {
        List k8;
        MutableStateFlow<RepoStatus> mutableStateFlow = this.f37911m;
        k8 = CollectionsKt__CollectionsKt.k();
        final Flow E = E(mutableStateFlow, k8, new ChatSdkChatRepo$observeEndingServiceMessage$1(str, null));
        return FlowKt.j(new Flow<Optional<TerminationInfo>>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37963f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ ChatSdkChatRepo f37964g;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1$2", f = "ChatSdkChatRepo.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37965f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37966g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37965f = obj;
                        this.f37966g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ChatSdkChatRepo chatSdkChatRepo) {
                    this.f37963f = flowCollector;
                    this.f37964g = chatSdkChatRepo;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37966g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37966g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f37965f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37966g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r8)
                        goto L79
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f37963f
                        java.util.List r7 = (java.util.List) r7
                        int r2 = r7.size()
                        java.util.ListIterator r7 = r7.listIterator(r2)
                    L40:
                        boolean r2 = r7.hasPrevious()
                        r4 = 0
                        if (r2 == 0) goto L53
                        java.lang.Object r2 = r7.previous()
                        r5 = r2
                        eu.bolt.chat.data.message.ChatMessage r5 = (eu.bolt.chat.data.message.ChatMessage) r5
                        boolean r5 = r5 instanceof eu.bolt.chat.data.message.EndingServiceMessage
                        if (r5 == 0) goto L40
                        goto L54
                    L53:
                        r2 = r4
                    L54:
                        eu.bolt.chat.data.message.ChatMessage r2 = (eu.bolt.chat.data.message.ChatMessage) r2
                        if (r2 == 0) goto L6c
                        boolean r7 = r2 instanceof eu.bolt.chat.data.message.EndingServiceMessage
                        if (r7 == 0) goto L5f
                        eu.bolt.chat.data.message.EndingServiceMessage r2 = (eu.bolt.chat.data.message.EndingServiceMessage) r2
                        goto L60
                    L5f:
                        r2 = r4
                    L60:
                        if (r2 == 0) goto L6c
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo r7 = r6.f37964g
                        eu.bolt.chat.chatcore.chatsdk.mapper.MessageMapper r7 = eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.w(r7)
                        eu.bolt.chat.chatcore.entity.TerminationInfo r4 = r7.j(r2)
                    L6c:
                        j$.util.Optional r7 = j$.util.Optional.ofNullable(r4)
                        r0.f37966g = r3
                        java.lang.Object r7 = r8.b(r7, r0)
                        if (r7 != r1) goto L79
                        return r1
                    L79:
                        kotlin.Unit r7 = kotlin.Unit.f50853a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeEndingServiceMessage$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Optional<TerminationInfo>> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector, this), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        });
    }

    private final Flow<ChatNotificationManager> L() {
        final StateFlow<ChatSdkStatus> b8 = this.f37899a.b();
        final Flow<Object> flow = new Flow<Object>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37969f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1$2", f = "ChatSdkChatRepo.kt", l = {224}, m = "emit")
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37970f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37971g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37970f = obj;
                        this.f37971g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f37969f = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37971g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37971g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f37970f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37971g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f37969f
                        boolean r2 = r5 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkStatus.Initialized
                        if (r2 == 0) goto L43
                        r0.f37971g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$filterIsInstance$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        };
        return new Flow<ChatNotificationManager>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37974f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1$2", f = "ChatSdkChatRepo.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37975f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37976g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37975f = obj;
                        this.f37976g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f37974f = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37976g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37976g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f37975f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37976g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f37974f
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkStatus$Initialized r5 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkStatus.Initialized) r5
                        eu.bolt.chat.client.ChatNotificationManager r5 = r5.b()
                        r0.f37976g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeNotificationManagerAvailable$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super ChatNotificationManager> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        };
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public void a(ChatRequestReplySuggestionsEntity entity) {
        Intrinsics.f(entity, "entity");
        this.f37907i.b("Requested quick reply suggestions. Not allowed anymore in Chat SDK");
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public Flowable<List<ChatMessageEntity>> b(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return RxConvertKt.c(FlowKt.I(J(), new ChatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1(null, chatId, this)), G());
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public Completable c(final ChatEntity chatEntity) {
        Intrinsics.f(chatEntity, "chatEntity");
        Completable u7 = Completable.u(new Action() { // from class: k6.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatSdkChatRepo.C(ChatSdkChatRepo.this, chatEntity);
            }
        });
        Intrinsics.e(u7, "fromAction {\n        // …ymore in Chat SDK\")\n    }");
        return u7;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    @SuppressLint({"NewApi"})
    public Observable<Optional<ChatEntity>> d(OrderHandleEntity orderHandle) {
        List k8;
        Intrinsics.f(orderHandle, "orderHandle");
        final OrderHandle a8 = this.f37905g.a(orderHandle);
        MutableStateFlow<RepoStatus> mutableStateFlow = this.f37911m;
        k8 = CollectionsKt__CollectionsKt.k();
        final Flow E = E(mutableStateFlow, k8, new ChatSdkChatRepo$observeActiveChat$1(null));
        return RxConvertKt.d(FlowKt.j(new Flow<Optional<ChatEntity>>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37933f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ OrderHandle f37934g;

                /* renamed from: h  reason: collision with root package name */
                final /* synthetic */ ChatSdkChatRepo f37935h;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1$2", f = "ChatSdkChatRepo.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37936f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37937g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37936f = obj;
                        this.f37937g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, OrderHandle orderHandle, ChatSdkChatRepo chatSdkChatRepo) {
                    this.f37933f = flowCollector;
                    this.f37934g = orderHandle;
                    this.f37935h = chatSdkChatRepo;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37937g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37937g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.f37936f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37937g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r9)
                        goto L73
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        kotlin.ResultKt.b(r9)
                        kotlinx.coroutines.flow.FlowCollector r9 = r7.f37933f
                        java.util.List r8 = (java.util.List) r8
                        java.util.Iterator r8 = r8.iterator()
                    L3c:
                        boolean r2 = r8.hasNext()
                        r4 = 0
                        if (r2 == 0) goto L57
                        java.lang.Object r2 = r8.next()
                        r5 = r2
                        eu.bolt.chat.data.Chat r5 = (eu.bolt.chat.data.Chat) r5
                        eu.bolt.chat.data.OrderHandle r5 = r5.e()
                        eu.bolt.chat.data.OrderHandle r6 = r7.f37934g
                        boolean r5 = kotlin.jvm.internal.Intrinsics.a(r5, r6)
                        if (r5 == 0) goto L3c
                        goto L58
                    L57:
                        r2 = r4
                    L58:
                        eu.bolt.chat.data.Chat r2 = (eu.bolt.chat.data.Chat) r2
                        if (r2 == 0) goto L66
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo r8 = r7.f37935h
                        eu.bolt.chat.chatcore.chatsdk.mapper.ChatMapper r8 = eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.q(r8)
                        eu.bolt.chat.chatcore.entity.ChatEntity r4 = r8.a(r2)
                    L66:
                        j$.util.Optional r8 = j$.util.Optional.ofNullable(r4)
                        r0.f37937g = r3
                        java.lang.Object r8 = r9.b(r8, r0)
                        if (r8 != r1) goto L73
                        return r1
                    L73:
                        kotlin.Unit r8 = kotlin.Unit.f50853a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeActiveChat$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Optional<ChatEntity>> flowCollector, Continuation continuation) {
                Object d8;
                Object a9 = Flow.this.a(new AnonymousClass2(flowCollector, a8, this), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a9 == d8) {
                    return a9;
                }
                return Unit.f50853a;
            }
        }), G());
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public Flowable<Integer> e(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return RxConvertKt.c(FlowKt.I(J(), new ChatSdkChatRepo$observeUnreadNonSilentCount$$inlined$flatMapLatest$1(null, chatId)), G());
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public void f(List<ChatMessageEntity> chatMessageEntities) {
        Intrinsics.f(chatMessageEntities, "chatMessageEntities");
        I(this.f37910l, new ChatSdkChatRepo$readMessages$1(chatMessageEntities, null));
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public Completable g(final ChatMessageEntity messageEntity) {
        Intrinsics.f(messageEntity, "messageEntity");
        Completable u7 = Completable.u(new Action() { // from class: k6.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                ChatSdkChatRepo.B(ChatSdkChatRepo.this, messageEntity);
            }
        });
        Intrinsics.e(u7, "fromAction {\n        // …ymore in Chat SDK\")\n    }");
        return u7;
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public Flowable<List<QuickReplyEntity>> h(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return RxConvertKt.c(FlowKt.I(J(), new ChatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1(null, chatId, this)), G());
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public void i(ChatConnectionEntity chatConnectionEntity) {
        Intrinsics.f(chatConnectionEntity, "chatConnectionEntity");
        ReentrantLock reentrantLock = this.f37908j;
        reentrantLock.lock();
        try {
            if (this.f37911m.getValue() instanceof RepoStatus.Active) {
                this.f37907i.c(new ClientAlreadyConnectingException());
                return;
            }
            if (Intrinsics.a(F(), ChatSdkStatus.Uninitialized.f38060a)) {
                this.f37899a.a();
            }
            CoroutineScope D = D();
            this.f37909k = D;
            this.f37910l = D();
            BuildersKt__Builders_commonKt.d(D, null, null, new ChatSdkChatRepo$connect$1$1(this, null), 3, null);
            BuildersKt__Builders_commonKt.d(D, null, null, new ChatSdkChatRepo$connect$1$2(this, null), 3, null);
            BuildersKt__Builders_commonKt.d(D, null, null, new ChatSdkChatRepo$connect$1$3(this, null), 3, null);
            BuildersKt__Builders_commonKt.d(D, null, null, new ChatSdkChatRepo$connect$1$4(this, null), 3, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public void j(ChatConnectionEntity chatConnectionEntity) {
        Intrinsics.f(chatConnectionEntity, "chatConnectionEntity");
        Logger logger = this.f37907i;
        logger.b("Requested to update active chats for " + chatConnectionEntity + ". Not allowed anymore in Chat SDK");
        if (Intrinsics.a(this.f37911m.getValue(), RepoStatus.Idle.f38004a)) {
            this.f37907i.b("Connecting to chat client after requesting active chats update…");
            i(chatConnectionEntity);
        }
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public void k(ChatEntity chat, List<ChatMessageEntity> initialMessages) {
        Intrinsics.f(chat, "chat");
        Intrinsics.f(initialMessages, "initialMessages");
        Logger logger = this.f37907i;
        logger.b("Requested chat creation for " + chat + " with initial messages " + initialMessages + ". Not allowed anymore in Chat SDK");
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    public void l(Function0<Unit> function0) {
        ChatSdkStatus.Initialized initialized;
        RepoStatus.Active active;
        ChatClientManager chatClientManager;
        ReentrantLock reentrantLock = this.f37908j;
        reentrantLock.lock();
        try {
            ChatSdkStatus F = F();
            if (F instanceof ChatSdkStatus.Initialized) {
                initialized = (ChatSdkStatus.Initialized) F;
            } else {
                initialized = null;
            }
            RepoStatus value = this.f37911m.getValue();
            if (value instanceof RepoStatus.Active) {
                active = (RepoStatus.Active) value;
            } else {
                active = null;
            }
            if (initialized != null) {
                chatClientManager = initialized.a();
            } else {
                chatClientManager = null;
            }
            if (active != null && chatClientManager != null) {
                chatClientManager.c(active.a());
            }
            CoroutineScope coroutineScope = this.f37910l;
            if (coroutineScope != null) {
                CoroutineScopeKt.d(coroutineScope, null, 1, null);
            }
            this.f37910l = null;
            if (function0 != null) {
                function0.invoke();
                Unit unit = Unit.f50853a;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // eu.bolt.chat.chatcore.repo.InternalChatRepo
    public void m(ChatMessageEntity message) {
        Intrinsics.f(message, "message");
        I(this.f37910l, new ChatSdkChatRepo$sendMessage$1(message, this, null));
    }

    @Override // eu.bolt.chat.chatcore.repo.ChatRepo
    @SuppressLint({"NewApi"})
    public Single<TerminationInfo> n(String chatId) {
        Intrinsics.f(chatId, "chatId");
        final Flow<Optional<TerminationInfo>> K = K(chatId);
        Single<TerminationInfo> firstOrError = RxConvertKt.d(new Flow<TerminationInfo>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37926f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1$2", f = "ChatSdkChatRepo.kt", l = {225}, m = "emit")
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37927f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37928g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37927f = obj;
                        this.f37928g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f37926f = flowCollector;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37928g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37928g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f37927f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37928g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f37926f
                        j$.util.Optional r5 = (j$.util.Optional) r5
                        r2 = 0
                        java.lang.Object r5 = r5.orElse(r2)
                        if (r5 == 0) goto L48
                        r0.f37928g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$getTerminalEvent$$inlined$mapNotNull$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super TerminationInfo> flowCollector, Continuation continuation) {
                Object d8;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector), continuation);
                d8 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d8) {
                    return a8;
                }
                return Unit.f50853a;
            }
        }, G()).firstOrError();
        Intrinsics.e(firstOrError, "observeEndingServiceMess…          .firstOrError()");
        return firstOrError;
    }
}
