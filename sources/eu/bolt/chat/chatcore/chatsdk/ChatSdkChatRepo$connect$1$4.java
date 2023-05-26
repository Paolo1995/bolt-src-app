package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo;
import eu.bolt.chat.chatcore.chatsdk.ChatSdkStatus;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller;
import eu.bolt.chat.client.ChatClient;
import io.reactivex.Completable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.rx2.RxAwaitKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4", f = "ChatSdkChatRepo.kt", l = {128, 132}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$connect$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38012g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f38013h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$connect$1$4(ChatSdkChatRepo chatSdkChatRepo, Continuation<? super ChatSdkChatRepo$connect$1$4> continuation) {
        super(2, continuation);
        this.f38013h = chatSdkChatRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatSdkChatRepo$connect$1$4(this.f38013h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChatSdkChatRepo$connect$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        SecurityProviderInstaller securityProviderInstaller;
        ChatSdkInitializer chatSdkInitializer;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38012g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            securityProviderInstaller = this.f38013h.f37901c;
            Completable a8 = securityProviderInstaller.a();
            this.f38012g = 1;
            if (RxAwaitKt.a(a8, this) == d8) {
                return d8;
            }
        }
        chatSdkInitializer = this.f38013h.f37899a;
        final StateFlow<ChatSdkStatus> b8 = chatSdkInitializer.b();
        Flow<Object> flow = new Flow<Object>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1

            /* compiled from: Emitters.kt */
            /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ FlowCollector f37916f;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1$2", f = "ChatSdkChatRepo.kt", l = {224}, m = "emit")
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: f  reason: collision with root package name */
                    /* synthetic */ Object f37917f;

                    /* renamed from: g  reason: collision with root package name */
                    int f37918g;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f37917f = obj;
                        this.f37918g |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.b(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f37916f = flowCollector;
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
                        boolean r0 = r6 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f37918g
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f37918g = r1
                        goto L18
                    L13:
                        eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f37917f
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                        int r2 = r0.f37918g
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f37916f
                        boolean r2 = r5 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkStatus.Initialized
                        if (r2 == 0) goto L43
                        r0.f37918g = r3
                        java.lang.Object r5 = r6.b(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r5 = kotlin.Unit.f50853a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4$invokeSuspend$$inlined$filterIsInstance$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object d9;
                Object a9 = Flow.this.a(new AnonymousClass2(flowCollector), continuation);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (a9 == d9) {
                    return a9;
                }
                return Unit.f50853a;
            }
        };
        final ChatSdkChatRepo chatSdkChatRepo = this.f38013h;
        FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$connect$1$4.1
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a */
            public final Object b(ChatSdkStatus.Initialized initialized, Continuation<? super Unit> continuation) {
                MutableStateFlow mutableStateFlow;
                Object d9;
                ChatClient b9 = initialized.a().b();
                mutableStateFlow = ChatSdkChatRepo.this.f37911m;
                Object b10 = mutableStateFlow.b(new ChatSdkChatRepo.RepoStatus.Active(b9), continuation);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (b10 == d9) {
                    return b10;
                }
                return Unit.f50853a;
            }
        };
        this.f38012g = 2;
        if (flow.a(flowCollector, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
