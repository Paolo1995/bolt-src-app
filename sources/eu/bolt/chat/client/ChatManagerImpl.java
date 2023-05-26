package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.async.FlowBufferedChunksKt;
import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ChatStatus;
import eu.bolt.chat.data.QuickReplySuggestion;
import eu.bolt.chat.data.message.ChatMessage;
import eu.bolt.chat.data.message.MessageSender;
import eu.bolt.chat.data.message.MessageStatus;
import eu.bolt.chat.data.message.QuickReplyRequestMessage;
import eu.bolt.chat.data.message.ServiceMessage;
import eu.bolt.chat.data.message.UserMessage;
import eu.bolt.chat.network.data.ChatConfig;
import eu.bolt.chat.storage.ChatStorage;
import eu.bolt.chat.storage.data.MessageUpdateResult;
import eu.bolt.chat.util.CoroutineRunner;
import eu.bolt.chat.util.UUID;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ChatManagerImpl.kt */
/* loaded from: classes5.dex */
public final class ChatManagerImpl implements InternalChatManager {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f38531o = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f38532a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatConfig f38533b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineRunner f38534c;

    /* renamed from: d  reason: collision with root package name */
    private final ChatStorage f38535d;

    /* renamed from: e  reason: collision with root package name */
    private final MessagePublisher f38536e;

    /* renamed from: f  reason: collision with root package name */
    private final InternalNotificationManager f38537f;

    /* renamed from: g  reason: collision with root package name */
    private final Logger f38538g;

    /* renamed from: h  reason: collision with root package name */
    private MutableStateFlow<ChatStatus> f38539h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableStateFlow<Integer> f38540i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableStateFlow<List<ChatMessage>> f38541j;

    /* renamed from: k  reason: collision with root package name */
    private final MutableSharedFlow<List<String>> f38542k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableStateFlow<List<QuickReplySuggestion>> f38543l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableSharedFlow<ChatMessage> f38544m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableSharedFlow<ChatMessage> f38545n;

    /* compiled from: ChatManagerImpl.kt */
    @DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl$1", f = "ChatManagerImpl.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: eu.bolt.chat.client.ChatManagerImpl$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f38547g;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f38547g;
            if (i8 != 0) {
                if (i8 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.b(obj);
                ChatManagerImpl chatManagerImpl = ChatManagerImpl.this;
                this.f38547g = 1;
                if (chatManagerImpl.H(this) == d8) {
                    return d8;
                }
            }
            return Unit.f50853a;
        }
    }

    /* compiled from: ChatManagerImpl.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatManagerImpl.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38549a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f38550b;

        static {
            int[] iArr = new int[MessageUpdateResult.values().length];
            try {
                iArr[MessageUpdateResult.INSERTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageUpdateResult.CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageUpdateResult.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f38549a = iArr;
            int[] iArr2 = new int[ChatStatus.values().length];
            try {
                iArr2[ChatStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ChatStatus.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ChatStatus.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ChatStatus.ABORTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            f38550b = iArr2;
        }
    }

    public ChatManagerImpl(String chatId, ChatConfig chatConfig, CoroutineRunner clientRunner, ChatStorage chatStorage, MessagePublisher messagePublisher, InternalNotificationManager notificationManager, Logger logger) {
        List k8;
        List k9;
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(chatConfig, "chatConfig");
        Intrinsics.f(clientRunner, "clientRunner");
        Intrinsics.f(chatStorage, "chatStorage");
        Intrinsics.f(messagePublisher, "messagePublisher");
        Intrinsics.f(notificationManager, "notificationManager");
        Intrinsics.f(logger, "logger");
        this.f38532a = chatId;
        this.f38533b = chatConfig;
        this.f38534c = clientRunner;
        this.f38535d = chatStorage;
        this.f38536e = messagePublisher;
        this.f38537f = notificationManager;
        this.f38538g = logger;
        this.f38539h = StateFlowKt.a(ChatStatus.PENDING);
        this.f38540i = StateFlowKt.a(0);
        k8 = CollectionsKt__CollectionsKt.k();
        this.f38541j = StateFlowKt.a(k8);
        this.f38542k = SharedFlowKt.b(0, 0, null, 7, null);
        k9 = CollectionsKt__CollectionsKt.k();
        this.f38543l = StateFlowKt.a(k9);
        this.f38544m = SharedFlowKt.b(0, 0, null, 7, null);
        this.f38545n = SharedFlowKt.b(0, 0, null, 7, null);
        clientRunner.a(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H(Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = FlowBufferedChunksKt.a(this.f38542k, 1000L).a(new ChatManagerImpl$accumulateAndPublishSeenEvents$2(this), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    private final Object I(Continuation<? super Integer> continuation) {
        final List n8;
        n8 = CollectionsKt__CollectionsKt.n(MessageStatus.SEEN, MessageStatus.ERROR);
        return this.f38535d.f(this.f38532a, new Function1<ChatMessage, Boolean>() { // from class: eu.bolt.chat.client.ChatManagerImpl$calculateUnreadMessageCount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
                if (((eu.bolt.chat.data.message.ServiceMessage) r4).f() == false) goto L7;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
                if (r1.contains(r4.getStatus()) == false) goto L7;
             */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(eu.bolt.chat.data.message.ChatMessage r4) {
                /*
                    r3 = this;
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.Intrinsics.f(r4, r0)
                    boolean r0 = r4 instanceof eu.bolt.chat.data.message.UserMessage
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L23
                    r0 = r4
                    eu.bolt.chat.data.message.UserMessage r0 = (eu.bolt.chat.data.message.UserMessage) r0
                    boolean r0 = r0.c()
                    if (r0 == 0) goto L21
                    java.util.List<eu.bolt.chat.data.message.MessageStatus> r0 = r1
                    eu.bolt.chat.data.message.MessageStatus r4 = r4.getStatus()
                    boolean r4 = r0.contains(r4)
                    if (r4 != 0) goto L21
                    goto L2f
                L21:
                    r1 = 0
                    goto L2f
                L23:
                    boolean r0 = r4 instanceof eu.bolt.chat.data.message.ServiceMessage
                    if (r0 == 0) goto L34
                    eu.bolt.chat.data.message.ServiceMessage r4 = (eu.bolt.chat.data.message.ServiceMessage) r4
                    boolean r4 = r4.f()
                    if (r4 != 0) goto L21
                L2f:
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
                    return r4
                L34:
                    kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
                    r4.<init>()
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl$calculateUnreadMessageCount$2.invoke(eu.bolt.chat.data.message.ChatMessage):java.lang.Boolean");
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageSender J() {
        return this.f38533b.a().a();
    }

    private final Object K(Continuation<? super List<? extends ChatMessage>> continuation) {
        Logger logger = this.f38538g;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            String d8 = logger.d();
            logger.f(severity, d8, null, "Fetching chat messages in storage for " + this.f38532a);
        }
        return ChatStorage.DefaultImpls.a(this.f38535d, this.f38532a, null, continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$1 r0 = (eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$1) r0
            int r1 = r0.f38577j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38577j = r1
            goto L18
        L13:
            eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$1 r0 = new eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f38575h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38577j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r2 = r0.f38574g
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.f38573f
            eu.bolt.chat.client.ChatManagerImpl r4 = (eu.bolt.chat.client.ChatManagerImpl) r4
            kotlin.ResultKt.b(r7)
            goto L61
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.f38573f
            eu.bolt.chat.client.ChatManagerImpl r2 = (eu.bolt.chat.client.ChatManagerImpl) r2
            kotlin.ResultKt.b(r7)
            goto L59
        L44:
            kotlin.ResultKt.b(r7)
            eu.bolt.chat.storage.ChatStorage r7 = r6.f38535d
            java.lang.String r2 = r6.f38532a
            eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1 r5 = new kotlin.jvm.functions.Function1<eu.bolt.chat.data.message.ChatMessage, java.lang.Boolean>() { // from class: eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1
                static {
                    /*
                        eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1 r0 = new eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1) eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1.f eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final java.lang.Boolean invoke(eu.bolt.chat.data.message.ChatMessage r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.f(r2, r0)
                        eu.bolt.chat.data.message.MessageStatus r2 = r2.getStatus()
                        eu.bolt.chat.data.message.MessageStatus r0 = eu.bolt.chat.data.message.MessageStatus.SENDING
                        if (r2 != r0) goto Lf
                        r2 = 1
                        goto L10
                    Lf:
                        r2 = 0
                    L10:
                        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1.invoke(eu.bolt.chat.data.message.ChatMessage):java.lang.Boolean");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Boolean invoke(eu.bolt.chat.data.message.ChatMessage r1) {
                    /*
                        r0 = this;
                        eu.bolt.chat.data.message.ChatMessage r1 = (eu.bolt.chat.data.message.ChatMessage) r1
                        java.lang.Boolean r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl$holdOutgoingMessages$allSendingMessages$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            r0.f38573f = r6
            r0.f38577j = r4
            java.lang.Object r7 = r7.d(r2, r5, r0)
            if (r7 != r1) goto L58
            return r1
        L58:
            r2 = r6
        L59:
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r4 = r2
            r2 = r7
        L61:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L82
            java.lang.Object r7 = r2.next()
            eu.bolt.chat.data.message.ChatMessage r7 = (eu.bolt.chat.data.message.ChatMessage) r7
            eu.bolt.chat.data.message.MessageStatus r5 = eu.bolt.chat.data.message.MessageStatus.ERROR
            eu.bolt.chat.data.message.ChatMessage r7 = r7.a(r5)
            eu.bolt.chat.storage.ChatStorage r5 = r4.f38535d
            r0.f38573f = r4
            r0.f38574g = r2
            r0.f38577j = r3
            java.lang.Object r7 = r5.b(r7, r0)
            if (r7 != r1) goto L61
            return r1
        L82:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.L(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M() {
        int i8 = WhenMappings.f38550b[this.f38539h.getValue().ordinal()];
        if (i8 == 1 || i8 == 2) {
            return true;
        }
        if (i8 != 3 && i8 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        Logger logger = this.f38538g;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Error;
        if (a8.compareTo(severity) <= 0) {
            logger.f(severity, logger.d(), null, "Unable to send messages when chat is finished/aborted!");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N(ChatMessage chatMessage) {
        boolean z7;
        boolean z8;
        if (chatMessage.getStatus() != MessageStatus.SEEN) {
            z7 = true;
        } else {
            z7 = false;
        }
        if ((chatMessage instanceof UserMessage) && !((UserMessage) chatMessage).c()) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z7 && z8) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3 A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v8, types: [kotlinx.coroutines.flow.MutableSharedFlow] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object O(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof eu.bolt.chat.client.ChatManagerImpl$reloadMessagesState$1
            if (r0 == 0) goto L13
            r0 = r13
            eu.bolt.chat.client.ChatManagerImpl$reloadMessagesState$1 r0 = (eu.bolt.chat.client.ChatManagerImpl$reloadMessagesState$1) r0
            int r1 = r0.f38590k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38590k = r1
            goto L18
        L13:
            eu.bolt.chat.client.ChatManagerImpl$reloadMessagesState$1 r0 = new eu.bolt.chat.client.ChatManagerImpl$reloadMessagesState$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.f38588i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38590k
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L61
            if (r2 == r6) goto L59
            if (r2 == r5) goto L49
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            kotlin.ResultKt.b(r13)
            goto Lc4
        L34:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L3c:
            java.lang.Object r2 = r0.f38586g
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.f38585f
            eu.bolt.chat.client.ChatManagerImpl r4 = (eu.bolt.chat.client.ChatManagerImpl) r4
            kotlin.ResultKt.b(r13)
            goto Lb5
        L49:
            java.lang.Object r2 = r0.f38587h
            kotlinx.coroutines.flow.MutableStateFlow r2 = (kotlinx.coroutines.flow.MutableStateFlow) r2
            java.lang.Object r5 = r0.f38586g
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.f38585f
            eu.bolt.chat.client.ChatManagerImpl r6 = (eu.bolt.chat.client.ChatManagerImpl) r6
            kotlin.ResultKt.b(r13)
            goto La4
        L59:
            java.lang.Object r2 = r0.f38585f
            eu.bolt.chat.client.ChatManagerImpl r2 = (eu.bolt.chat.client.ChatManagerImpl) r2
            kotlin.ResultKt.b(r13)
            goto L8b
        L61:
            kotlin.ResultKt.b(r13)
            co.touchlab.kermit.Logger r13 = r12.f38538g
            co.touchlab.kermit.LoggerConfig r2 = r13.c()
            co.touchlab.kermit.Severity r2 = r2.a()
            co.touchlab.kermit.Severity r8 = co.touchlab.kermit.Severity.Debug
            int r2 = r2.compareTo(r8)
            if (r2 > 0) goto L7f
            java.lang.String r2 = r13.d()
            java.lang.String r9 = "Reloading ALL messages"
            r13.f(r8, r2, r7, r9)
        L7f:
            r0.f38585f = r12
            r0.f38590k = r6
            java.lang.Object r13 = r12.K(r0)
            if (r13 != r1) goto L8a
            return r1
        L8a:
            r2 = r12
        L8b:
            java.util.List r13 = (java.util.List) r13
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> r6 = r2.f38540i
            r0.f38585f = r2
            r0.f38586g = r13
            r0.f38587h = r6
            r0.f38590k = r5
            java.lang.Object r5 = r2.I(r0)
            if (r5 != r1) goto L9e
            return r1
        L9e:
            r10 = r5
            r5 = r13
            r13 = r10
            r11 = r6
            r6 = r2
            r2 = r11
        La4:
            r0.f38585f = r6
            r0.f38586g = r5
            r0.f38587h = r7
            r0.f38590k = r4
            java.lang.Object r13 = r2.b(r13, r0)
            if (r13 != r1) goto Lb3
            return r1
        Lb3:
            r2 = r5
            r4 = r6
        Lb5:
            kotlinx.coroutines.flow.MutableStateFlow<java.util.List<eu.bolt.chat.data.message.ChatMessage>> r13 = r4.f38541j
            r0.f38585f = r7
            r0.f38586g = r7
            r0.f38590k = r3
            java.lang.Object r13 = r13.b(r2, r0)
            if (r13 != r1) goto Lc4
            return r1
        Lc4:
            kotlin.Unit r13 = kotlin.Unit.f50853a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.O(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object P(eu.bolt.chat.data.message.UserMessage r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof eu.bolt.chat.client.ChatManagerImpl$sendMessage$3
            if (r0 == 0) goto L13
            r0 = r11
            eu.bolt.chat.client.ChatManagerImpl$sendMessage$3 r0 = (eu.bolt.chat.client.ChatManagerImpl$sendMessage$3) r0
            int r1 = r0.f38598j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38598j = r1
            goto L18
        L13:
            eu.bolt.chat.client.ChatManagerImpl$sendMessage$3 r0 = new eu.bolt.chat.client.ChatManagerImpl$sendMessage$3
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f38596h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38598j
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L60
            if (r2 == r7) goto L54
            if (r2 == r6) goto L44
            if (r2 == r5) goto L3c
            if (r2 != r4) goto L34
            kotlin.ResultKt.b(r11)
            goto Laa
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            java.lang.Object r10 = r0.f38594f
            eu.bolt.chat.client.ChatManagerImpl r10 = (eu.bolt.chat.client.ChatManagerImpl) r10
            kotlin.ResultKt.b(r11)
            goto L9f
        L44:
            java.lang.Object r10 = r0.f38595g
            eu.bolt.chat.data.message.UserMessage r10 = (eu.bolt.chat.data.message.UserMessage) r10
            java.lang.Object r2 = r0.f38594f
            eu.bolt.chat.client.ChatManagerImpl r2 = (eu.bolt.chat.client.ChatManagerImpl) r2
            kotlin.ResultKt.b(r11)
        L4f:
            r8 = r11
            r11 = r10
            r10 = r2
            r2 = r8
            goto L87
        L54:
            java.lang.Object r10 = r0.f38595g
            eu.bolt.chat.data.message.UserMessage r10 = (eu.bolt.chat.data.message.UserMessage) r10
            java.lang.Object r2 = r0.f38594f
            eu.bolt.chat.client.ChatManagerImpl r2 = (eu.bolt.chat.client.ChatManagerImpl) r2
            kotlin.ResultKt.b(r11)
            goto L75
        L60:
            kotlin.ResultKt.b(r11)
            boolean r11 = r10 instanceof eu.bolt.chat.data.message.UserTextMessage
            if (r11 == 0) goto L9e
            r0.f38594f = r9
            r0.f38595g = r10
            r0.f38598j = r7
            java.lang.Object r11 = r9.p(r10, r0)
            if (r11 != r1) goto L74
            return r1
        L74:
            r2 = r9
        L75:
            eu.bolt.chat.client.MessagePublisher r11 = r2.f38536e
            r7 = r10
            eu.bolt.chat.data.message.UserTextMessage r7 = (eu.bolt.chat.data.message.UserTextMessage) r7
            r0.f38594f = r2
            r0.f38595g = r10
            r0.f38598j = r6
            java.lang.Object r11 = r11.c(r7, r0)
            if (r11 != r1) goto L4f
            return r1
        L87:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.String r11 = r11.getId()
            r0.f38594f = r10
            r0.f38595g = r3
            r0.f38598j = r5
            java.lang.Object r11 = r10.S(r2, r11, r0)
            if (r11 != r1) goto L9f
            return r1
        L9e:
            r10 = r9
        L9f:
            r0.f38594f = r3
            r0.f38598j = r4
            java.lang.Object r10 = r10.O(r0)
            if (r10 != r1) goto Laa
            return r1
        Laa:
            kotlin.Unit r10 = kotlin.Unit.f50853a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.P(eu.bolt.chat.data.message.UserMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Q(eu.bolt.chat.data.message.ChatMessage r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof eu.bolt.chat.client.ChatManagerImpl$showNotification$1
            if (r0 == 0) goto L13
            r0 = r9
            eu.bolt.chat.client.ChatManagerImpl$showNotification$1 r0 = (eu.bolt.chat.client.ChatManagerImpl$showNotification$1) r0
            int r1 = r0.f38607j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38607j = r1
            goto L18
        L13:
            eu.bolt.chat.client.ChatManagerImpl$showNotification$1 r0 = new eu.bolt.chat.client.ChatManagerImpl$showNotification$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f38605h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38607j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r9)
            goto L81
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.f38604g
            eu.bolt.chat.data.message.ChatMessage r8 = (eu.bolt.chat.data.message.ChatMessage) r8
            java.lang.Object r2 = r0.f38603f
            eu.bolt.chat.client.ChatManagerImpl r2 = (eu.bolt.chat.client.ChatManagerImpl) r2
            kotlin.ResultKt.b(r9)
            goto L51
        L40:
            kotlin.ResultKt.b(r9)
            r0.f38603f = r7
            r0.f38604g = r8
            r0.f38607j = r4
            java.lang.Object r9 = r7.g(r0)
            if (r9 != r1) goto L50
            return r1
        L50:
            r2 = r7
        L51:
            eu.bolt.chat.data.Chat r9 = (eu.bolt.chat.data.Chat) r9
            boolean r5 = r2.N(r8)
            boolean r6 = r8 instanceof eu.bolt.chat.data.message.ServiceMessage
            if (r6 == 0) goto L66
            r6 = r8
            eu.bolt.chat.data.message.ServiceMessage r6 = (eu.bolt.chat.data.message.ServiceMessage) r6
            boolean r6 = r6.f()
            if (r6 != 0) goto L65
            goto L66
        L65:
            r4 = 0
        L66:
            if (r9 == 0) goto L84
            if (r4 == 0) goto L84
            if (r5 == 0) goto L84
            eu.bolt.chat.client.InternalNotificationManager r2 = r2.f38537f
            eu.bolt.chat.data.ChatPushMessage r4 = new eu.bolt.chat.data.ChatPushMessage
            r4.<init>(r9, r8)
            r8 = 0
            r0.f38603f = r8
            r0.f38604g = r8
            r0.f38607j = r3
            java.lang.Object r8 = r2.c(r4, r0)
            if (r8 != r1) goto L81
            return r1
        L81:
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        L84:
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.Q(eu.bolt.chat.data.message.ChatMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object R(eu.bolt.chat.data.message.ChatMessage r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.R(eu.bolt.chat.data.message.ChatMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S(boolean r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof eu.bolt.chat.client.ChatManagerImpl$updateMessageSentStatus$1
            if (r0 == 0) goto L13
            r0 = r9
            eu.bolt.chat.client.ChatManagerImpl$updateMessageSentStatus$1 r0 = (eu.bolt.chat.client.ChatManagerImpl$updateMessageSentStatus$1) r0
            int r1 = r0.f38633j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38633j = r1
            goto L18
        L13:
            eu.bolt.chat.client.ChatManagerImpl$updateMessageSentStatus$1 r0 = new eu.bolt.chat.client.ChatManagerImpl$updateMessageSentStatus$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f38631h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38633j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r9)
            goto L84
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            boolean r7 = r0.f38630g
            java.lang.Object r8 = r0.f38629f
            eu.bolt.chat.client.ChatManagerImpl r8 = (eu.bolt.chat.client.ChatManagerImpl) r8
            kotlin.ResultKt.b(r9)
            goto L51
        L3e:
            kotlin.ResultKt.b(r9)
            eu.bolt.chat.storage.ChatStorage r9 = r6.f38535d
            r0.f38629f = r6
            r0.f38630g = r7
            r0.f38633j = r4
            java.lang.Object r9 = r9.c(r8, r0)
            if (r9 != r1) goto L50
            return r1
        L50:
            r8 = r6
        L51:
            eu.bolt.chat.data.message.ChatMessage r9 = (eu.bolt.chat.data.message.ChatMessage) r9
            if (r9 == 0) goto L87
            boolean r2 = r9 instanceof eu.bolt.chat.data.message.UserMessage
            if (r2 != 0) goto L5a
            goto L87
        L5a:
            eu.bolt.chat.data.message.UserMessage r9 = (eu.bolt.chat.data.message.UserMessage) r9
            eu.bolt.chat.data.message.MessageStatus r2 = r9.getStatus()
            int r2 = r2.c()
            eu.bolt.chat.data.message.MessageStatus r4 = eu.bolt.chat.data.message.MessageStatus.SENT
            int r5 = r4.c()
            if (r2 < r5) goto L6f
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        L6f:
            if (r7 == 0) goto L72
            goto L74
        L72:
            eu.bolt.chat.data.message.MessageStatus r4 = eu.bolt.chat.data.message.MessageStatus.ERROR
        L74:
            eu.bolt.chat.data.message.UserMessage r7 = r9.a(r4)
            r9 = 0
            r0.f38629f = r9
            r0.f38633j = r3
            java.lang.Object r7 = r8.p(r7, r0)
            if (r7 != r1) goto L84
            return r1
        L84:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        L87:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.S(boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[RETURN] */
    @Override // eu.bolt.chat.client.InternalChatManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(eu.bolt.chat.data.Chat r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.client.ChatManagerImpl$updateChatDetails$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.client.ChatManagerImpl$updateChatDetails$1 r0 = (eu.bolt.chat.client.ChatManagerImpl$updateChatDetails$1) r0
            int r1 = r0.f38617j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f38617j = r1
            goto L18
        L13:
            eu.bolt.chat.client.ChatManagerImpl$updateChatDetails$1 r0 = new eu.bolt.chat.client.ChatManagerImpl$updateChatDetails$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f38615h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38617j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L67
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f38614g
            eu.bolt.chat.data.Chat r6 = (eu.bolt.chat.data.Chat) r6
            java.lang.Object r2 = r0.f38613f
            eu.bolt.chat.client.ChatManagerImpl r2 = (eu.bolt.chat.client.ChatManagerImpl) r2
            kotlin.ResultKt.b(r7)
            goto L53
        L40:
            kotlin.ResultKt.b(r7)
            eu.bolt.chat.storage.ChatStorage r7 = r5.f38535d
            r0.f38613f = r5
            r0.f38614g = r6
            r0.f38617j = r4
            java.lang.Object r7 = r7.a(r6, r0)
            if (r7 != r1) goto L52
            return r1
        L52:
            r2 = r5
        L53:
            kotlinx.coroutines.flow.MutableStateFlow<eu.bolt.chat.data.ChatStatus> r7 = r2.f38539h
            eu.bolt.chat.data.ChatStatus r6 = r6.f()
            r2 = 0
            r0.f38613f = r2
            r0.f38614g = r2
            r0.f38617j = r3
            java.lang.Object r6 = r7.b(r6, r0)
            if (r6 != r1) goto L67
            return r1
        L67:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.a(eu.bolt.chat.data.Chat, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x010d -> B:25:0x0084). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0122 -> B:44:0x0124). Please submit an issue!!! */
    @Override // eu.bolt.chat.client.InternalChatManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(eu.bolt.chat.data.Chat r18, java.util.List<? extends eu.bolt.chat.data.message.ChatMessage> r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.b(eu.bolt.chat.data.Chat, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.client.ChatManager
    public void c(List<String> messageIds) {
        Intrinsics.f(messageIds, "messageIds");
        this.f38534c.a(new ChatManagerImpl$markMessagesAsRead$1(messageIds, this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140 A[RETURN] */
    @Override // eu.bolt.chat.client.ChatLifeCycleManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(eu.bolt.chat.data.message.MessageEvent.LifeCycle.Finish r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.d(eu.bolt.chat.data.message.MessageEvent$LifeCycle$Finish, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    @Override // eu.bolt.chat.client.InternalChatManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.client.ChatManager
    public ObservableStateFlow<Integer> f() {
        return new ObservableStateFlow<>(this.f38540i);
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object g(Continuation<? super Chat> continuation) {
        return this.f38535d.e(this.f38532a, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    @Override // eu.bolt.chat.client.ChatLifeCycleManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object h(eu.bolt.chat.data.message.MessageEvent.LifeCycle.Start r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.h(eu.bolt.chat.data.message.MessageEvent$LifeCycle$Start, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object i(List<QuickReplySuggestion> list, Continuation<? super Unit> continuation) {
        Object d8;
        Logger logger = this.f38538g;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            String d9 = logger.d();
            logger.f(severity, d9, null, "Received " + list.size() + " new suggestions!");
        }
        Object b8 = this.f38543l.b(list, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (b8 == d8) {
            return b8;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public ObservableStateFlow<List<ChatMessage>> j() {
        if (this.f38541j.getValue().isEmpty()) {
            this.f38534c.a(new ChatManagerImpl$getMessagesFlow$1(this, null));
        }
        return new ObservableStateFlow<>(this.f38541j);
    }

    @Override // eu.bolt.chat.client.ChatManager
    public void k(String id) {
        Object obj;
        Intrinsics.f(id, "id");
        Iterator<T> it = this.f38543l.getValue().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.a(((QuickReplySuggestion) obj).a(), id)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        QuickReplySuggestion quickReplySuggestion = (QuickReplySuggestion) obj;
        if (M() && quickReplySuggestion != null) {
            this.f38534c.a(new ChatManagerImpl$sendQuickReply$1(this, quickReplySuggestion, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00bc -> B:29:0x00bf). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x010c -> B:45:0x010e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0110 -> B:33:0x00cd). Please submit an issue!!! */
    @Override // eu.bolt.chat.client.ChatLifeCycleManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object l(java.util.List<java.lang.String> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl.l(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.chat.client.ChatManager
    public ObservableStateFlow<List<QuickReplySuggestion>> m() {
        return new ObservableStateFlow<>(this.f38543l);
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object n(ServiceMessage serviceMessage, Continuation<? super Unit> continuation) {
        Object d8;
        if (!Intrinsics.a(serviceMessage.d(), this.f38532a)) {
            Logger logger = this.f38538g;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Error;
            if (a8.compareTo(severity) <= 0) {
                String d9 = logger.d();
                logger.f(severity, d9, null, "Service message (" + serviceMessage.getId() + ") received in a wrong chat. Expected chat: (" + this.f38532a + "). Actual: (" + serviceMessage.d() + ')');
            }
            return Unit.f50853a;
        }
        Object R = R(serviceMessage, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (R == d8) {
            return R;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public void o(String text) {
        Intrinsics.f(text, "text");
        if (!M()) {
            Logger logger = this.f38538g;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Warn;
            if (a8.compareTo(severity) <= 0) {
                logger.f(severity, logger.d(), null, "Unable to send message when it's not allowed");
                return;
            }
            return;
        }
        this.f38534c.a(new ChatManagerImpl$sendMessage$2(this, text, null));
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object p(UserMessage userMessage, Continuation<? super Unit> continuation) {
        Object d8;
        if (!Intrinsics.a(userMessage.d(), this.f38532a)) {
            Logger logger = this.f38538g;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Error;
            if (a8.compareTo(severity) <= 0) {
                String d9 = logger.d();
                logger.f(severity, d9, null, "User message (" + userMessage.getId() + ") received in a wrong chat. Expected chat: (" + this.f38532a + "). Actual: (" + userMessage.d() + ')');
            }
            return Unit.f50853a;
        }
        Object R = R(userMessage, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (R == d8) {
            return R;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.InternalChatManager
    public Object q(Continuation<? super Unit> continuation) {
        Object d8;
        Logger logger = this.f38538g;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            logger.f(severity, logger.d(), null, "trying to fetch available quick replies");
        }
        if (!M()) {
            Logger logger2 = this.f38538g;
            if (logger2.c().a().compareTo(severity) <= 0) {
                logger2.f(severity, logger2.d(), null, "Fetching quick reply suggestion is not allowed");
            }
            return Unit.f50853a;
        }
        Object d9 = this.f38536e.d(new QuickReplyRequestMessage(UUID.f39707a.a(), this.f38532a), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (d9 == d8) {
            return d9;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatManager
    public ObservableStateFlow<ChatStatus> r() {
        return new ObservableStateFlow<>(this.f38539h);
    }

    public String toString() {
        return "ChatManager { chatId = " + this.f38532a + ", status = " + this.f38539h.getValue() + '}';
    }
}
