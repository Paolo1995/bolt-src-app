package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.client.DefaultChatSubscriber;
import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ChatStatus;
import eu.bolt.chat.data.ClientStatus;
import eu.bolt.chat.data.EndChatInfo;
import eu.bolt.chat.data.message.MessageEvent;
import eu.bolt.chat.di.ChatKitScopeComponent;
import eu.bolt.chat.network.data.ChatConfig;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.endpoint.ChatApiService;
import eu.bolt.chat.network.endpoint.EndpointError;
import eu.bolt.chat.network.engine.ConnectionEvent;
import eu.bolt.chat.network.engine.MqttClient;
import eu.bolt.chat.storage.ActiveChatIdStorage;
import eu.bolt.chat.storage.PendingRawMessageStorage;
import eu.bolt.chat.util.DateTimeUtilsKt;
import eu.bolt.chat.util.UUID;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.LocalDateTime;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: DefaultChatClient.kt */
/* loaded from: classes5.dex */
public final class DefaultChatClient implements InternalChatClient, ChatKitScopeComponent {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f38642t = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Logger f38643a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f38644b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f38645c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f38646d;

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f38647e;

    /* renamed from: f  reason: collision with root package name */
    private final Lazy f38648f;

    /* renamed from: g  reason: collision with root package name */
    private final Lazy f38649g;

    /* renamed from: h  reason: collision with root package name */
    private final Lazy f38650h;

    /* renamed from: i  reason: collision with root package name */
    private final Lazy f38651i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f38652j;

    /* renamed from: k  reason: collision with root package name */
    private final Lazy f38653k;

    /* renamed from: l  reason: collision with root package name */
    private final Lazy f38654l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableStateFlow<ClientStatus> f38655m;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicBoolean f38656n;

    /* renamed from: o  reason: collision with root package name */
    private final ObservableStateFlow<ClientStatus> f38657o;

    /* renamed from: p  reason: collision with root package name */
    private final MutableStateFlow<List<Chat>> f38658p;

    /* renamed from: q  reason: collision with root package name */
    private final ObservableStateFlow<List<Chat>> f38659q;

    /* renamed from: r  reason: collision with root package name */
    private final MutableStateFlow<Integer> f38660r;

    /* renamed from: s  reason: collision with root package name */
    private final ObservableStateFlow<Integer> f38661s;

    /* compiled from: DefaultChatClient.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DefaultChatClient(Logger logger) {
        Lazy b8;
        Lazy a8;
        Lazy a9;
        Lazy a10;
        Lazy a11;
        Lazy a12;
        Lazy a13;
        Lazy a14;
        Lazy a15;
        Lazy a16;
        Lazy a17;
        List k8;
        Intrinsics.f(logger, "logger");
        this.f38643a = logger;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Scope>() { // from class: eu.bolt.chat.client.DefaultChatClient$scope$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Scope invoke() {
                return KoinScopeComponentKt.b(DefaultChatClient.this, null, 1, null);
            }
        });
        this.f38644b = b8;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f52811a;
        a8 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<CoroutineScope>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(CoroutineScope.class), qualifier, function0);
            }
        });
        this.f38645c = a8;
        a9 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<ChatApiService>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, eu.bolt.chat.network.endpoint.ChatApiService] */
            @Override // kotlin.jvm.functions.Function0
            public final ChatApiService invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(ChatApiService.class), qualifier, function0);
            }
        });
        this.f38646d = a9;
        a10 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<MqttClient>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [eu.bolt.chat.network.engine.MqttClient, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MqttClient invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(MqttClient.class), qualifier, function0);
            }
        });
        this.f38647e = a10;
        a11 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<ChatSubscriber>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [eu.bolt.chat.client.ChatSubscriber, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ChatSubscriber invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(ChatSubscriber.class), qualifier, function0);
            }
        });
        this.f38648f = a11;
        a12 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<MessageRouter>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [eu.bolt.chat.client.MessageRouter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MessageRouter invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(MessageRouter.class), qualifier, function0);
            }
        });
        this.f38649g = a12;
        a13 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<ChatManagerFactory>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [eu.bolt.chat.client.ChatManagerFactory, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ChatManagerFactory invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(ChatManagerFactory.class), qualifier, function0);
            }
        });
        this.f38650h = a13;
        a14 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<PendingRawMessageStorage>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [eu.bolt.chat.storage.PendingRawMessageStorage, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PendingRawMessageStorage invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(PendingRawMessageStorage.class), qualifier, function0);
            }
        });
        this.f38651i = a14;
        a15 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<ChatPushReceiver>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, eu.bolt.chat.client.ChatPushReceiver] */
            @Override // kotlin.jvm.functions.Function0
            public final ChatPushReceiver invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(ChatPushReceiver.class), qualifier, function0);
            }
        });
        this.f38652j = a15;
        a16 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<ChatConfig>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [eu.bolt.chat.network.data.ChatConfig, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ChatConfig invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(ChatConfig.class), qualifier, function0);
            }
        });
        this.f38653k = a16;
        a17 = LazyKt__LazyJVMKt.a(koinPlatformTools.a(), new Function0<ActiveChatIdStorage>() { // from class: eu.bolt.chat.client.DefaultChatClient$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [eu.bolt.chat.storage.ActiveChatIdStorage, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ActiveChatIdStorage invoke() {
                Scope d8;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = r2;
                Function0<? extends ParametersHolder> function0 = r3;
                if (koinComponent instanceof KoinScopeComponent) {
                    d8 = ((KoinScopeComponent) koinComponent).a();
                } else {
                    d8 = koinComponent.e().e().d();
                }
                return d8.f(Reflection.b(ActiveChatIdStorage.class), qualifier, function0);
            }
        });
        this.f38654l = a17;
        MutableStateFlow<ClientStatus> a18 = StateFlowKt.a(ClientStatus.CONNECTING);
        this.f38655m = a18;
        this.f38656n = AtomicFU.a(false);
        this.f38657o = new ObservableStateFlow<>(a18);
        k8 = CollectionsKt__CollectionsKt.k();
        MutableStateFlow<List<Chat>> a19 = StateFlowKt.a(k8);
        this.f38658p = a19;
        this.f38659q = new ObservableStateFlow<>(a19);
        MutableStateFlow<Integer> a20 = StateFlowKt.a(0);
        this.f38660r = a20;
        this.f38661s = new ObservableStateFlow<>(a20);
    }

    private final Object F(List<Chat> list, Continuation<? super Unit> continuation) {
        Object d8;
        HashSet hashSet = new HashSet();
        for (Chat chat : list) {
            hashSet.add(chat.d());
        }
        Object d9 = V().d(hashSet, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (d9 == d8) {
            return d9;
        }
        return Unit.f50853a;
    }

    private final void G() {
        Logger logger = this.f38643a;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            logger.f(severity, logger.d(), null, "Clearing out chat client state");
        }
        this.f38656n.c(false);
        CoroutineScopeKt.d(R(), null, 1, null);
        Q().clear();
        O().clear();
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object I(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof eu.bolt.chat.client.DefaultChatClient$fetchChatHistory$1
            if (r0 == 0) goto L13
            r0 = r12
            eu.bolt.chat.client.DefaultChatClient$fetchChatHistory$1 r0 = (eu.bolt.chat.client.DefaultChatClient$fetchChatHistory$1) r0
            int r1 = r0.f38725j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38725j = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$fetchChatHistory$1 r0 = new eu.bolt.chat.client.DefaultChatClient$fetchChatHistory$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f38723h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38725j
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.b(r12)
            goto Lcf
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            kotlin.ResultKt.b(r12)
            goto Lb3
        L3d:
            java.lang.Object r11 = r0.f38722g
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r2 = r0.f38721f
            eu.bolt.chat.client.DefaultChatClient r2 = (eu.bolt.chat.client.DefaultChatClient) r2
            kotlin.ResultKt.b(r12)
            goto L5e
        L49:
            kotlin.ResultKt.b(r12)
            eu.bolt.chat.network.endpoint.ChatApiService r12 = r10.M()
            r0.f38721f = r10
            r0.f38722g = r11
            r0.f38725j = r5
            java.lang.Object r12 = r12.a(r11, r0)
            if (r12 != r1) goto L5d
            return r1
        L5d:
            r2 = r10
        L5e:
            eu.bolt.chat.util.Outcome r12 = (eu.bolt.chat.util.Outcome) r12
            boolean r5 = r12 instanceof eu.bolt.chat.util.Outcome.Success
            r6 = 0
            if (r5 == 0) goto Lb6
            co.touchlab.kermit.Logger r3 = r2.f38643a
            co.touchlab.kermit.LoggerConfig r5 = r3.c()
            co.touchlab.kermit.Severity r5 = r5.a()
            co.touchlab.kermit.Severity r7 = co.touchlab.kermit.Severity.Debug
            int r5 = r5.compareTo(r7)
            if (r5 > 0) goto L9e
            java.lang.String r5 = r3.d()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Chat History for chat "
            r8.append(r9)
            r8.append(r11)
            java.lang.String r9 = " is "
            r8.append(r9)
            r9 = r12
            eu.bolt.chat.util.Outcome$Success r9 = (eu.bolt.chat.util.Outcome.Success) r9
            java.lang.Object r9 = r9.a()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r3.f(r7, r5, r6, r8)
        L9e:
            eu.bolt.chat.util.Outcome$Success r12 = (eu.bolt.chat.util.Outcome.Success) r12
            java.lang.Object r12 = r12.a()
            eu.bolt.chat.data.ChatHistory r12 = (eu.bolt.chat.data.ChatHistory) r12
            r0.f38721f = r6
            r0.f38722g = r6
            r0.f38725j = r4
            java.lang.Object r11 = r2.p0(r11, r12, r0)
            if (r11 != r1) goto Lb3
            return r1
        Lb3:
            kotlin.Unit r11 = kotlin.Unit.f50853a
            return r11
        Lb6:
            boolean r4 = r12 instanceof eu.bolt.chat.util.Outcome.Failure
            if (r4 == 0) goto Ld2
            eu.bolt.chat.util.Outcome$Failure r12 = (eu.bolt.chat.util.Outcome.Failure) r12
            java.lang.Object r12 = r12.a()
            eu.bolt.chat.network.endpoint.EndpointError r12 = (eu.bolt.chat.network.endpoint.EndpointError) r12
            r0.f38721f = r6
            r0.f38722g = r6
            r0.f38725j = r3
            java.lang.Object r11 = r2.W(r11, r12, r0)
            if (r11 != r1) goto Lcf
            return r1
        Lcf:
            kotlin.Unit r11 = kotlin.Unit.f50853a
            return r11
        Ld2:
            kotlin.Unit r11 = kotlin.Unit.f50853a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.I(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J(kotlin.coroutines.Continuation<? super java.util.List<eu.bolt.chat.data.Chat>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.client.DefaultChatClient$fetchCurrentlyActiveChats$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.client.DefaultChatClient$fetchCurrentlyActiveChats$1 r0 = (eu.bolt.chat.client.DefaultChatClient$fetchCurrentlyActiveChats$1) r0
            int r1 = r0.f38729i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38729i = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$fetchCurrentlyActiveChats$1 r0 = new eu.bolt.chat.client.DefaultChatClient$fetchCurrentlyActiveChats$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f38727g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38729i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f38726f
            eu.bolt.chat.client.DefaultChatClient r0 = (eu.bolt.chat.client.DefaultChatClient) r0
            kotlin.ResultKt.b(r7)
            goto L48
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.b(r7)
            eu.bolt.chat.network.endpoint.ChatApiService r7 = r6.M()
            r0.f38726f = r6
            r0.f38729i = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            r0 = r6
        L48:
            eu.bolt.chat.util.Outcome r7 = (eu.bolt.chat.util.Outcome) r7
            boolean r1 = r7 instanceof eu.bolt.chat.util.Outcome.Success
            r2 = 0
            if (r1 == 0) goto L89
            co.touchlab.kermit.Logger r0 = r0.f38643a
            co.touchlab.kermit.LoggerConfig r1 = r0.c()
            co.touchlab.kermit.Severity r1 = r1.a()
            co.touchlab.kermit.Severity r3 = co.touchlab.kermit.Severity.Debug
            int r1 = r1.compareTo(r3)
            if (r1 > 0) goto L80
            java.lang.String r1 = r0.d()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Available active chats: "
            r4.append(r5)
            r5 = r7
            eu.bolt.chat.util.Outcome$Success r5 = (eu.bolt.chat.util.Outcome.Success) r5
            java.lang.Object r5 = r5.a()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.f(r3, r1, r2, r4)
        L80:
            eu.bolt.chat.util.Outcome$Success r7 = (eu.bolt.chat.util.Outcome.Success) r7
            java.lang.Object r7 = r7.a()
            java.util.List r7 = (java.util.List) r7
            goto Ld9
        L89:
            boolean r1 = r7 instanceof eu.bolt.chat.util.Outcome.Failure
            if (r1 == 0) goto Lda
            co.touchlab.kermit.Logger r0 = r0.f38643a
            co.touchlab.kermit.LoggerConfig r1 = r0.c()
            co.touchlab.kermit.Severity r1 = r1.a()
            co.touchlab.kermit.Severity r3 = co.touchlab.kermit.Severity.Error
            int r1 = r1.compareTo(r3)
            if (r1 > 0) goto Ld5
            java.lang.String r1 = r0.d()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unable to fetch currently active chats. Error code: "
            r4.append(r5)
            eu.bolt.chat.util.Outcome$Failure r7 = (eu.bolt.chat.util.Outcome.Failure) r7
            java.lang.Object r5 = r7.a()
            eu.bolt.chat.network.endpoint.EndpointError r5 = (eu.bolt.chat.network.endpoint.EndpointError) r5
            int r5 = r5.getCode()
            r4.append(r5)
            java.lang.String r5 = ", message = "
            r4.append(r5)
            java.lang.Object r7 = r7.a()
            eu.bolt.chat.network.endpoint.EndpointError r7 = (eu.bolt.chat.network.endpoint.EndpointError) r7
            java.lang.String r7 = r7.getMessage()
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r0.f(r3, r1, r2, r7)
        Ld5:
            java.util.List r7 = kotlin.collections.CollectionsKt.k()
        Ld9:
            return r7
        Lda:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.J(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object K(Continuation<? super Unit> continuation) {
        Object d8;
        final MutableStateFlow<ClientStatus> mutableStateFlow = this.f38655m;
        Object a8 = new Flow<ClientStatus>() { // from class: eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f38663f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1$2", f = "DefaultChatClient.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f38664f;

                    /* renamed from: g  reason: collision with root package name */
                    int f38665g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f38664f = obj;
                        this.f38665g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f38663f = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1$2$1 r0 = (eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f38665g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f38665g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1$2$1 r0 = new eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f38664f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f38665g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r7)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f38663f
                        r2 = r6
                        eu.bolt.chat.data.ClientStatus r2 = (eu.bolt.chat.data.ClientStatus) r2
                        eu.bolt.chat.data.ClientStatus r4 = eu.bolt.chat.data.ClientStatus.CONNECTED
                        if (r2 != r4) goto L3f
                        r2 = 1
                        goto L40
                    L3f:
                        r2 = 0
                    L40:
                        if (r2 == 0) goto L4b
                        r0.f38665g = r3
                        java.lang.Object r6 = r7.b(r6, r0)
                        if (r6 != r1) goto L4b
                        return r1
                    L4b:
                        kotlin.Unit r6 = kotlin.Unit.f50853a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient$flushPendingMessagesWhenConnected$$inlined$filter$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super ClientStatus> flowCollector, Continuation continuation2) {
                Object d9;
                Object a9 = Flow.this.a(new AnonymousClass2(flowCollector), continuation2);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (a9 == d9) {
                    return a9;
                }
                return Unit.f50853a;
            }
        }.a(new DefaultChatClient$flushPendingMessagesWhenConnected$3(this), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    private final ActiveChatIdStorage L() {
        return (ActiveChatIdStorage) this.f38654l.getValue();
    }

    private final ChatApiService M() {
        return (ChatApiService) this.f38646d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatConfig N() {
        return (ChatConfig) this.f38653k.getValue();
    }

    private final ChatManagerFactory O() {
        return (ChatManagerFactory) this.f38650h.getValue();
    }

    private final ChatPushReceiver P() {
        return (ChatPushReceiver) this.f38652j.getValue();
    }

    private final ChatSubscriber Q() {
        return (ChatSubscriber) this.f38648f.getValue();
    }

    private final CoroutineScope R() {
        return (CoroutineScope) this.f38645c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InternalChatManager S(String str) {
        return O().get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageRouter T() {
        return (MessageRouter) this.f38649g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MqttClient U() {
        return (MqttClient) this.f38647e.getValue();
    }

    private final PendingRawMessageStorage V() {
        return (PendingRawMessageStorage) this.f38651i.getValue();
    }

    private final Object W(String str, EndpointError endpointError, Continuation<? super Unit> continuation) {
        Object d8;
        if (endpointError instanceof EndpointError.NotExists) {
            Logger logger = this.f38643a;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Info;
            if (a8.compareTo(severity) <= 0) {
                String d9 = logger.d();
                logger.f(severity, d9, null, "Requested chat " + str + " does not exist");
            }
            String message = endpointError.getMessage();
            if (message == null) {
                message = "Chat not found";
            }
            Object n02 = n0(str, message, continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (n02 == d8) {
                return n02;
            }
            return Unit.f50853a;
        }
        Logger logger2 = this.f38643a;
        Severity a9 = logger2.c().a();
        Severity severity2 = Severity.Error;
        if (a9.compareTo(severity2) <= 0) {
            String d10 = logger2.d();
            logger2.f(severity2, d10, null, "Unable to obtain history for chat " + str + ". Error code: " + endpointError.getCode() + ", message = " + endpointError.getMessage());
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0113 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object X(java.lang.String r7, eu.bolt.chat.data.message.MessageEvent.LifeCycle r8, eu.bolt.chat.client.ChatLifeCycleManager r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.X(java.lang.String, eu.bolt.chat.data.message.MessageEvent$LifeCycle, eu.bolt.chat.client.ChatLifeCycleManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Y(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$1
            if (r0 == 0) goto L13
            r0 = r14
            eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$1 r0 = (eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$1) r0
            int r1 = r0.f38751i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38751i = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$1 r0 = new eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$1
            r0.<init>(r13, r14)
        L18:
            java.lang.Object r14 = r0.f38749g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38751i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f38748f
            eu.bolt.chat.client.DefaultChatClient r0 = (eu.bolt.chat.client.DefaultChatClient) r0
            kotlin.ResultKt.b(r14)
            goto L44
        L2d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L35:
            kotlin.ResultKt.b(r14)
            r0.f38748f = r13
            r0.f38751i = r3
            java.lang.Object r14 = r13.m0(r0)
            if (r14 != r1) goto L43
            return r1
        L43:
            r0 = r13
        L44:
            kotlinx.coroutines.CoroutineScope r1 = r0.R()
            r2 = 0
            r3 = 0
            eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$2 r4 = new eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$2
            r14 = 0
            r4.<init>(r0, r14)
            r5 = 3
            r6 = 0
            kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)
            kotlinx.coroutines.CoroutineScope r7 = r0.R()
            r8 = 0
            r9 = 0
            eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$3 r10 = new eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$3
            r10.<init>(r0, r14)
            r11 = 3
            r12 = 0
            kotlinx.coroutines.BuildersKt.d(r7, r8, r9, r10, r11, r12)
            kotlinx.coroutines.CoroutineScope r1 = r0.R()
            eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$4 r4 = new eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$4
            r4.<init>(r0, r14)
            kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)
            kotlinx.coroutines.CoroutineScope r7 = r0.R()
            eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$5 r10 = new eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$5
            r10.<init>(r0, r14)
            kotlinx.coroutines.BuildersKt.d(r7, r8, r9, r10, r11, r12)
            kotlinx.coroutines.CoroutineScope r1 = r0.R()
            eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$6 r4 = new eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$6
            r4.<init>(r0, r14)
            kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)
            kotlinx.coroutines.CoroutineScope r7 = r0.R()
            eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$7 r10 = new eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$7
            r10.<init>(r0, r14)
            kotlinx.coroutines.BuildersKt.d(r7, r8, r9, r10, r11, r12)
            kotlin.Unit r14 = kotlin.Unit.f50853a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.Y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Z(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof eu.bolt.chat.client.DefaultChatClient$handleConnectionRestored$1
            if (r0 == 0) goto L13
            r0 = r6
            eu.bolt.chat.client.DefaultChatClient$handleConnectionRestored$1 r0 = (eu.bolt.chat.client.DefaultChatClient$handleConnectionRestored$1) r0
            int r1 = r0.f38769i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38769i = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$handleConnectionRestored$1 r0 = new eu.bolt.chat.client.DefaultChatClient$handleConnectionRestored$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f38767g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38769i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.f38766f
            eu.bolt.chat.client.DefaultChatClient r0 = (eu.bolt.chat.client.DefaultChatClient) r0
            kotlin.ResultKt.b(r6)
            goto L5f
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            java.lang.Object r2 = r0.f38766f
            eu.bolt.chat.client.DefaultChatClient r2 = (eu.bolt.chat.client.DefaultChatClient) r2
            kotlin.ResultKt.b(r6)
            goto L4f
        L40:
            kotlin.ResultKt.b(r6)
            r0.f38766f = r5
            r0.f38769i = r4
            java.lang.Object r6 = r5.m0(r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r2 = r5
        L4f:
            kotlinx.coroutines.flow.MutableStateFlow<eu.bolt.chat.data.ClientStatus> r6 = r2.f38655m
            eu.bolt.chat.data.ClientStatus r4 = eu.bolt.chat.data.ClientStatus.CONNECTED
            r0.f38766f = r2
            r0.f38769i = r3
            java.lang.Object r6 = r6.b(r4, r0)
            if (r6 != r1) goto L5e
            return r1
        L5e:
            r0 = r2
        L5f:
            co.touchlab.kermit.Logger r6 = r0.f38643a
            co.touchlab.kermit.LoggerConfig r0 = r6.c()
            co.touchlab.kermit.Severity r0 = r0.a()
            co.touchlab.kermit.Severity r1 = co.touchlab.kermit.Severity.Info
            int r0 = r0.compareTo(r1)
            if (r0 > 0) goto L7b
            java.lang.String r0 = r6.d()
            r2 = 0
            java.lang.String r3 = "Chat client is back online and ready to be used"
            r6.f(r1, r0, r2, r3)
        L7b:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.Z(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a0(ConnectionEvent connectionEvent, Continuation<? super Unit> continuation) {
        Object d8;
        Object d9;
        Object d10;
        Object d11;
        if (Intrinsics.a(connectionEvent, ConnectionEvent.Connected.f39407a)) {
            Object f02 = f0(continuation);
            d11 = IntrinsicsKt__IntrinsicsKt.d();
            if (f02 == d11) {
                return f02;
            }
            return Unit.f50853a;
        } else if (Intrinsics.a(connectionEvent, ConnectionEvent.Reconnecting.f39410a)) {
            Object i02 = i0(continuation);
            d10 = IntrinsicsKt__IntrinsicsKt.d();
            if (i02 == d10) {
                return i02;
            }
            return Unit.f50853a;
        } else if (Intrinsics.a(connectionEvent, ConnectionEvent.Disconnected.f39408a)) {
            Object h02 = h0(continuation);
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            if (h02 == d9) {
                return h02;
            }
            return Unit.f50853a;
        } else if (connectionEvent instanceof ConnectionEvent.Failure) {
            Object g02 = g0(((ConnectionEvent.Failure) connectionEvent).a(), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (g02 == d8) {
                return g02;
            }
            return Unit.f50853a;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c0(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof eu.bolt.chat.client.DefaultChatClient$observeIncomingMessages$1
            if (r0 == 0) goto L13
            r0 = r5
            eu.bolt.chat.client.DefaultChatClient$observeIncomingMessages$1 r0 = (eu.bolt.chat.client.DefaultChatClient$observeIncomingMessages$1) r0
            int r1 = r0.f38775h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38775h = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$observeIncomingMessages$1 r0 = new eu.bolt.chat.client.DefaultChatClient$observeIncomingMessages$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f38773f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38775h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2d:
            kotlin.ResultKt.b(r5)
            goto L4a
        L31:
            kotlin.ResultKt.b(r5)
            eu.bolt.chat.client.MessageRouter r5 = r4.T()
            kotlinx.coroutines.flow.SharedFlow r5 = r5.b()
            eu.bolt.chat.client.DefaultChatClient$observeIncomingMessages$2 r2 = new eu.bolt.chat.client.DefaultChatClient$observeIncomingMessages$2
            r2.<init>()
            r0.f38775h = r3
            java.lang.Object r5 = r5.a(r2, r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.c0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d0(Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = P().a().a(new DefaultChatClient$observePushMessages$2(this), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e0(Continuation<? super Unit> continuation) {
        Flow c8;
        Object d8;
        final MutableStateFlow<List<Chat>> mutableStateFlow = this.f38658p;
        final Flow<List<? extends InternalChatManager>> flow = new Flow<List<? extends InternalChatManager>>() { // from class: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f38669f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ DefaultChatClient f38670g;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1$2", f = "DefaultChatClient.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f38671f;

                    /* renamed from: g  reason: collision with root package name */
                    int f38672g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f38671f = obj;
                        this.f38672g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, DefaultChatClient defaultChatClient) {
                    this.f38669f = flowCollector;
                    this.f38670g = defaultChatClient;
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
                        boolean r0 = r8 instanceof eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1$2$1 r0 = (eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f38672g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f38672g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1$2$1 r0 = new eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f38671f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f38672g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r8)
                        goto L6a
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f38669f
                        java.util.List r7 = (java.util.List) r7
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt.v(r7, r4)
                        r2.<init>(r4)
                        java.util.Iterator r7 = r7.iterator()
                    L47:
                        boolean r4 = r7.hasNext()
                        if (r4 == 0) goto L61
                        java.lang.Object r4 = r7.next()
                        eu.bolt.chat.data.Chat r4 = (eu.bolt.chat.data.Chat) r4
                        eu.bolt.chat.client.DefaultChatClient r5 = r6.f38670g
                        java.lang.String r4 = r4.d()
                        eu.bolt.chat.client.InternalChatManager r4 = eu.bolt.chat.client.DefaultChatClient.l(r5, r4)
                        r2.add(r4)
                        goto L47
                    L61:
                        r0.f38672g = r3
                        java.lang.Object r7 = r8.b(r2, r0)
                        if (r7 != r1) goto L6a
                        return r1
                    L6a:
                        kotlin.Unit r7 = kotlin.Unit.f50853a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super List<? extends InternalChatManager>> flowCollector, Continuation continuation2) {
                Object d9;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector, this), continuation2);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d9) {
                    return a8;
                }
                return Unit.f50853a;
            }
        };
        c8 = FlowKt__MergeKt.c(new Flow<List<? extends ObservableStateFlow<Integer>>>() { // from class: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f38675f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2$2", f = "DefaultChatClient.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f38676f;

                    /* renamed from: g  reason: collision with root package name */
                    int f38677g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f38676f = obj;
                        this.f38677g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f38675f = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2$2$1 r0 = (eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f38677g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f38677g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2$2$1 r0 = new eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f38676f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f38677g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r7)
                        goto L64
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f38675f
                        java.util.List r6 = (java.util.List) r6
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt.v(r6, r4)
                        r2.<init>(r4)
                        java.util.Iterator r6 = r6.iterator()
                    L47:
                        boolean r4 = r6.hasNext()
                        if (r4 == 0) goto L5b
                        java.lang.Object r4 = r6.next()
                        eu.bolt.chat.client.InternalChatManager r4 = (eu.bolt.chat.client.InternalChatManager) r4
                        eu.bolt.chat.async.ObservableStateFlow r4 = r4.f()
                        r2.add(r4)
                        goto L47
                    L5b:
                        r0.f38677g = r3
                        java.lang.Object r6 = r7.b(r2, r0)
                        if (r6 != r1) goto L64
                        return r1
                    L64:
                        kotlin.Unit r6 = kotlin.Unit.f50853a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$$inlined$map$2.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super List<? extends ObservableStateFlow<Integer>>> flowCollector, Continuation continuation2) {
                Object d9;
                Object a8 = Flow.this.a(new AnonymousClass2(flowCollector), continuation2);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d9) {
                    return a8;
                }
                return Unit.f50853a;
            }
        }, 0, new DefaultChatClient$observeUnreadCounterForAllChats$4(null), 1, null);
        Object a8 = c8.a(new FlowCollector() { // from class: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$5
            public final Object a(int i8, Continuation<? super Unit> continuation2) {
                MutableStateFlow mutableStateFlow2;
                Object d9;
                mutableStateFlow2 = DefaultChatClient.this.f38660r;
                Object b8 = mutableStateFlow2.b(Boxing.b(i8), continuation2);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (b8 == d9) {
                    return b8;
                }
                return Unit.f50853a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object b(Object obj, Continuation continuation2) {
                return a(((Number) obj).intValue(), continuation2);
            }
        }, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    private final Object f0(Continuation<? super Unit> continuation) {
        Object d8;
        Object d9;
        if (this.f38656n.a(false, true)) {
            Logger logger = this.f38643a;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Debug;
            if (a8.compareTo(severity) <= 0) {
                logger.f(severity, logger.d(), null, "Established a connection with the chat server");
            }
            Object Y = Y(continuation);
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            if (Y == d9) {
                return Y;
            }
            return Unit.f50853a;
        }
        Logger logger2 = this.f38643a;
        Severity a9 = logger2.c().a();
        Severity severity2 = Severity.Debug;
        if (a9.compareTo(severity2) <= 0) {
            logger2.f(severity2, logger2.d(), null, "Restored a connection with the chat server");
        }
        Object Z = Z(continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (Z == d8) {
            return Z;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g0(eu.bolt.chat.network.exception.MqttException r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof eu.bolt.chat.client.DefaultChatClient$onConnectionFailure$1
            if (r0 == 0) goto L13
            r0 = r10
            eu.bolt.chat.client.DefaultChatClient$onConnectionFailure$1 r0 = (eu.bolt.chat.client.DefaultChatClient$onConnectionFailure$1) r0
            int r1 = r0.f38789i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38789i = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$onConnectionFailure$1 r0 = new eu.bolt.chat.client.DefaultChatClient$onConnectionFailure$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f38787g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38789i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r9 = r0.f38786f
            eu.bolt.chat.client.DefaultChatClient r9 = (eu.bolt.chat.client.DefaultChatClient) r9
            kotlin.ResultKt.b(r10)
            goto L77
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.ResultKt.b(r10)
            co.touchlab.kermit.Logger r10 = r8.f38643a
            co.touchlab.kermit.LoggerConfig r2 = r10.c()
            co.touchlab.kermit.Severity r2 = r2.a()
            co.touchlab.kermit.Severity r4 = co.touchlab.kermit.Severity.Warn
            int r2 = r2.compareTo(r4)
            if (r2 > 0) goto L67
            java.lang.String r2 = r10.d()
            r5 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Disconnected from the chat server. Reason: "
            r6.append(r7)
            java.lang.String r9 = r9.getMessage()
            r6.append(r9)
            java.lang.String r9 = r6.toString()
            r10.f(r4, r2, r5, r9)
        L67:
            kotlinx.coroutines.flow.MutableStateFlow<eu.bolt.chat.data.ClientStatus> r9 = r8.f38655m
            eu.bolt.chat.data.ClientStatus r10 = eu.bolt.chat.data.ClientStatus.DISCONNECTED
            r0.f38786f = r8
            r0.f38789i = r3
            java.lang.Object r9 = r9.b(r10, r0)
            if (r9 != r1) goto L76
            return r1
        L76:
            r9 = r8
        L77:
            r9.G()
            kotlin.Unit r9 = kotlin.Unit.f50853a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.g0(eu.bolt.chat.network.exception.MqttException, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h0(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof eu.bolt.chat.client.DefaultChatClient$onDisconnected$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.chat.client.DefaultChatClient$onDisconnected$1 r0 = (eu.bolt.chat.client.DefaultChatClient$onDisconnected$1) r0
            int r1 = r0.f38793i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38793i = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$onDisconnected$1 r0 = new eu.bolt.chat.client.DefaultChatClient$onDisconnected$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f38791g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38793i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f38790f
            eu.bolt.chat.client.DefaultChatClient r0 = (eu.bolt.chat.client.DefaultChatClient) r0
            kotlin.ResultKt.b(r8)
            goto L64
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.b(r8)
            co.touchlab.kermit.Logger r8 = r7.f38643a
            co.touchlab.kermit.LoggerConfig r2 = r8.c()
            co.touchlab.kermit.Severity r2 = r2.a()
            co.touchlab.kermit.Severity r4 = co.touchlab.kermit.Severity.Debug
            int r2 = r2.compareTo(r4)
            if (r2 > 0) goto L54
            java.lang.String r2 = r8.d()
            r5 = 0
            java.lang.String r6 = "Disconnected from the chat server normally"
            r8.f(r4, r2, r5, r6)
        L54:
            kotlinx.coroutines.flow.MutableStateFlow<eu.bolt.chat.data.ClientStatus> r8 = r7.f38655m
            eu.bolt.chat.data.ClientStatus r2 = eu.bolt.chat.data.ClientStatus.DISCONNECTED
            r0.f38790f = r7
            r0.f38793i = r3
            java.lang.Object r8 = r8.b(r2, r0)
            if (r8 != r1) goto L63
            return r1
        L63:
            r0 = r7
        L64:
            r0.G()
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.h0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object i0(Continuation<? super Unit> continuation) {
        Object d8;
        Logger logger = this.f38643a;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            logger.f(severity, logger.d(), null, "Reconnecting to the chat server…");
        }
        Object b8 = this.f38655m.b(ClientStatus.RECONNECTING, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (b8 == d8) {
            return b8;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j0(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$1
            if (r0 == 0) goto L13
            r0 = r12
            eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$1 r0 = (eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$1) r0
            int r1 = r0.f38797i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38797i = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$1 r0 = new eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.f38795g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38797i
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3d
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.b(r12)
            goto L94
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L35:
            java.lang.Object r2 = r0.f38794f
            eu.bolt.chat.client.DefaultChatClient r2 = (eu.bolt.chat.client.DefaultChatClient) r2
            kotlin.ResultKt.b(r12)
            goto L55
        L3d:
            kotlin.ResultKt.b(r12)
            eu.bolt.chat.storage.ActiveChatIdStorage r12 = r11.L()
            eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$allChats$1 r2 = new eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$allChats$1
            r2.<init>(r11, r3)
            r0.f38794f = r11
            r0.f38797i = r5
            java.lang.Object r12 = r12.a(r2, r0)
            if (r12 != r1) goto L54
            return r1
        L54:
            r2 = r11
        L55:
            java.util.List r12 = (java.util.List) r12
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r12 = r12.iterator()
        L60:
            boolean r7 = r12.hasNext()
            if (r7 == 0) goto L87
            java.lang.Object r7 = r12.next()
            r8 = r7
            eu.bolt.chat.data.Chat r8 = (eu.bolt.chat.data.Chat) r8
            eu.bolt.chat.data.ChatStatus r9 = r8.f()
            eu.bolt.chat.data.ChatStatus r10 = eu.bolt.chat.data.ChatStatus.PENDING
            if (r9 == r10) goto L80
            eu.bolt.chat.data.ChatStatus r8 = r8.f()
            eu.bolt.chat.data.ChatStatus r9 = eu.bolt.chat.data.ChatStatus.STARTED
            if (r8 != r9) goto L7e
            goto L80
        L7e:
            r8 = 0
            goto L81
        L80:
            r8 = 1
        L81:
            if (r8 == 0) goto L60
            r6.add(r7)
            goto L60
        L87:
            kotlinx.coroutines.flow.MutableStateFlow<java.util.List<eu.bolt.chat.data.Chat>> r12 = r2.f38658p
            r0.f38794f = r3
            r0.f38797i = r4
            java.lang.Object r12 = r12.b(r6, r0)
            if (r12 != r1) goto L94
            return r1
        L94:
            kotlin.Unit r12 = kotlin.Unit.f50853a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.j0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k0(Continuation<? super Unit> continuation) {
        Object d8;
        final Flow h8 = FlowKt.h(this.f38658p, this.f38655m, new DefaultChatClient$refreshQuickRepliesOnConnected$2(null));
        Object a8 = FlowKt.t(new Flow<Pair<? extends List<? extends Chat>, ? extends ClientStatus>>() { // from class: eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f38685f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1$2", f = "DefaultChatClient.kt", l = {223}, m = "emit")
                /* renamed from: eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f38686f;

                    /* renamed from: g  reason: collision with root package name */
                    int f38687g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f38686f = obj;
                        this.f38687g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f38685f = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object b(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1$2$1 r0 = (eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f38687g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f38687g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1$2$1 r0 = new eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f38686f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f38687g
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r7)
                        goto L51
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f38685f
                        r2 = r6
                        kotlin.Pair r2 = (kotlin.Pair) r2
                        java.lang.Object r2 = r2.b()
                        eu.bolt.chat.data.ClientStatus r2 = (eu.bolt.chat.data.ClientStatus) r2
                        eu.bolt.chat.data.ClientStatus r4 = eu.bolt.chat.data.ClientStatus.CONNECTED
                        if (r2 != r4) goto L45
                        r2 = 1
                        goto L46
                    L45:
                        r2 = 0
                    L46:
                        if (r2 == 0) goto L51
                        r0.f38687g = r3
                        java.lang.Object r6 = r7.b(r6, r0)
                        if (r6 != r1) goto L51
                        return r1
                    L51:
                        kotlin.Unit r6 = kotlin.Unit.f50853a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$$inlined$filter$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Pair<? extends List<? extends Chat>, ? extends ClientStatus>> flowCollector, Continuation continuation2) {
                Object d9;
                Object a9 = Flow.this.a(new AnonymousClass2(flowCollector), continuation2);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (a9 == d9) {
                    return a9;
                }
                return Unit.f50853a;
            }
        }, new DefaultChatClient$refreshQuickRepliesOnConnected$4(null)).a(new FlowCollector() { // from class: eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$5
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a */
            public final Object b(Chat chat, Continuation<? super Unit> continuation2) {
                InternalChatManager S;
                Object d9;
                S = DefaultChatClient.this.S(chat.d());
                Object q8 = S.q(continuation2);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (q8 == d9) {
                    return q8;
                }
                return Unit.f50853a;
            }
        }, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l0(final Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = Q().a(N().c(), N().b(), new FlowCollector() { // from class: eu.bolt.chat.client.DefaultChatClient$subscribeToChatTopics$2

            /* compiled from: DefaultChatClient.kt */
            /* loaded from: classes5.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f38812a;

                static {
                    int[] iArr = new int[DefaultChatSubscriber.SubscriptionStatus.values().length];
                    try {
                        iArr[DefaultChatSubscriber.SubscriptionStatus.SUBSCRIBED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[DefaultChatSubscriber.SubscriptionStatus.FAILED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[DefaultChatSubscriber.SubscriptionStatus.SUBSCRIBING.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f38812a = iArr;
                }
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a */
            public final Object b(DefaultChatSubscriber.SubscriptionStatus subscriptionStatus, Continuation<? super Unit> continuation2) {
                Logger logger;
                Object d9;
                ChatConfig N;
                Logger logger2;
                ChatConfig N2;
                int i8 = WhenMappings.f38812a[subscriptionStatus.ordinal()];
                if (i8 == 1) {
                    logger = DefaultChatClient.this.f38643a;
                    DefaultChatClient defaultChatClient = DefaultChatClient.this;
                    Severity a9 = logger.c().a();
                    Severity severity = Severity.Debug;
                    if (a9.compareTo(severity) <= 0) {
                        String d10 = logger.d();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Subscribed successfully for [");
                        N = defaultChatClient.N();
                        sb.append(N.c());
                        sb.append("] topic");
                        logger.f(severity, d10, null, sb.toString());
                    }
                    Object invoke = function1.invoke(continuation2);
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    if (invoke == d9) {
                        return invoke;
                    }
                    return Unit.f50853a;
                }
                if (i8 == 2) {
                    logger2 = DefaultChatClient.this.f38643a;
                    DefaultChatClient defaultChatClient2 = DefaultChatClient.this;
                    Severity a10 = logger2.c().a();
                    Severity severity2 = Severity.Debug;
                    if (a10.compareTo(severity2) <= 0) {
                        String d11 = logger2.d();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Topic subscription failed badly, [");
                        N2 = defaultChatClient2.N();
                        sb2.append(N2.c());
                        sb2.append("] topic");
                        logger2.f(severity2, d11, null, sb2.toString());
                    }
                    DefaultChatClient.this.destroy();
                }
                return Unit.f50853a;
            }
        }, new FlowCollector() { // from class: eu.bolt.chat.client.DefaultChatClient$subscribeToChatTopics$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a */
            public final Object b(MqttMessage mqttMessage, Continuation<? super Unit> continuation2) {
                Logger logger;
                MessageRouter T;
                Object d9;
                logger = DefaultChatClient.this.f38643a;
                Severity a9 = logger.c().a();
                Severity severity = Severity.Debug;
                if (a9.compareTo(severity) <= 0) {
                    String d10 = logger.d();
                    logger.f(severity, d10, null, "Received message -> " + mqttMessage);
                }
                T = DefaultChatClient.this.T();
                Object a10 = T.a(mqttMessage, continuation2);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (a10 == d9) {
                    return a10;
                }
                return Unit.f50853a;
            }
        }, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0162 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016f A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0102 -> B:27:0x00c5). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m0(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.m0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object n0(String str, String str2, Continuation<? super Unit> continuation) {
        Object d8;
        Object X = X(str, new MessageEvent.LifeCycle.Finish(new EndChatInfo(UUID.f39707a.a(), DateTimeUtilsKt.a(LocalDateTime.Companion), str2, ChatStatus.FINISHED)), S(str), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (X == d8) {
            return X;
        }
        return Unit.f50853a;
    }

    private final Object o0(Chat chat, Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = S(chat.d()).a(chat, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p0(java.lang.String r7, eu.bolt.chat.data.ChatHistory r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof eu.bolt.chat.client.DefaultChatClient$updateMessagesForChat$1
            if (r0 == 0) goto L13
            r0 = r9
            eu.bolt.chat.client.DefaultChatClient$updateMessagesForChat$1 r0 = (eu.bolt.chat.client.DefaultChatClient$updateMessagesForChat$1) r0
            int r1 = r0.f38831l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38831l = r1
            goto L18
        L13:
            eu.bolt.chat.client.DefaultChatClient$updateMessagesForChat$1 r0 = new eu.bolt.chat.client.DefaultChatClient$updateMessagesForChat$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f38829j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38831l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r9)
            goto L88
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.f38828i
            eu.bolt.chat.client.InternalChatManager r7 = (eu.bolt.chat.client.InternalChatManager) r7
            java.lang.Object r8 = r0.f38827h
            eu.bolt.chat.data.ChatHistory r8 = (eu.bolt.chat.data.ChatHistory) r8
            java.lang.Object r2 = r0.f38826g
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.f38825f
            eu.bolt.chat.client.DefaultChatClient r4 = (eu.bolt.chat.client.DefaultChatClient) r4
            kotlin.ResultKt.b(r9)
            r9 = r7
            r7 = r2
            goto L6b
        L4a:
            kotlin.ResultKt.b(r9)
            eu.bolt.chat.client.InternalChatManager r9 = r6.S(r7)
            eu.bolt.chat.data.Chat r2 = r8.a()
            java.util.List r5 = r8.c()
            r0.f38825f = r6
            r0.f38826g = r7
            r0.f38827h = r8
            r0.f38828i = r9
            r0.f38831l = r4
            java.lang.Object r2 = r9.b(r2, r5, r0)
            if (r2 != r1) goto L6a
            return r1
        L6a:
            r4 = r6
        L6b:
            eu.bolt.chat.data.EndChatInfo r8 = r8.b()
            if (r8 == 0) goto L8b
            eu.bolt.chat.data.message.MessageEvent$LifeCycle$Finish r2 = new eu.bolt.chat.data.message.MessageEvent$LifeCycle$Finish
            r2.<init>(r8)
            r8 = 0
            r0.f38825f = r8
            r0.f38826g = r8
            r0.f38827h = r8
            r0.f38828i = r8
            r0.f38831l = r3
            java.lang.Object r7 = r4.X(r7, r2, r9, r0)
            if (r7 != r1) goto L88
            return r1
        L88:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        L8b:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient.p0(java.lang.String, eu.bolt.chat.data.ChatHistory, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void H() {
        ChatKitScopeComponent.DefaultImpls.a(this);
    }

    @Override // org.koin.core.component.KoinScopeComponent
    public Scope a() {
        return (Scope) this.f38644b.getValue();
    }

    @Override // eu.bolt.chat.client.ChatClient
    public ObservableStateFlow<List<Chat>> b() {
        return this.f38659q;
    }

    public void b0() {
        BuildersKt__Builders_commonKt.d(R(), null, null, new DefaultChatClient$initialize$1(this, null), 3, null);
    }

    @Override // eu.bolt.chat.client.ChatClient
    public ChatManager c(String chatId) {
        Intrinsics.f(chatId, "chatId");
        return S(chatId);
    }

    @Override // eu.bolt.chat.client.ChatClient
    public ObservableStateFlow<ClientStatus> d() {
        return this.f38657o;
    }

    @Override // eu.bolt.chat.client.InternalChatClient
    public void destroy() {
        BuildersKt__Builders_commonKt.d(R(), null, null, new DefaultChatClient$destroy$1(this, null), 3, null);
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin e() {
        return ChatKitScopeComponent.DefaultImpls.b(this);
    }

    @Override // eu.bolt.chat.client.ChatClient
    public ClientStatus getStatus() {
        return this.f38655m.getValue();
    }

    public String toString() {
        return "ChatClient { status = " + this.f38655m.getValue() + " }";
    }
}
