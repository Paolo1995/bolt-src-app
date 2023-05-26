package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.client.ChatClient;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1", f = "ChatSdkChatRepo.kt", l = {376}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$launchWhenActive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38021g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f38022h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f38023i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function2<ChatClient, Continuation<? super Unit>, Object> f38024j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChatSdkChatRepo.kt */
    /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Function2<ChatClient, Continuation<? super Unit>, Object> f38025f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ CoroutineScope f38026g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ChatSdkChatRepo f38027h;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super ChatClient, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineScope coroutineScope, ChatSdkChatRepo chatSdkChatRepo) {
            this.f38025f = function2;
            this.f38026g = coroutineScope;
            this.f38027h = chatSdkChatRepo;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object b(eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.RepoStatus r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1$1$emit$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1$1$emit$1) r0
                int r1 = r0.f38031i
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f38031i = r1
                goto L18
            L13:
                eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1$1$emit$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f38029g
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r2 = r0.f38031i
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r5 = r0.f38028f
                eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1$1 r5 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1.AnonymousClass1) r5
                kotlin.ResultKt.b(r6)
                goto L50
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L35:
                kotlin.ResultKt.b(r6)
                boolean r6 = r5 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.RepoStatus.Active
                if (r6 == 0) goto L57
                kotlin.jvm.functions.Function2<eu.bolt.chat.client.ChatClient, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r4.f38025f
                eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$RepoStatus$Active r5 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.RepoStatus.Active) r5
                eu.bolt.chat.client.ChatClient r5 = r5.a()
                r0.f38028f = r4
                r0.f38031i = r3
                java.lang.Object r5 = r6.s(r5, r0)
                if (r5 != r1) goto L4f
                return r1
            L4f:
                r5 = r4
            L50:
                kotlinx.coroutines.CoroutineScope r5 = r5.f38026g
                r6 = 0
                kotlinx.coroutines.CoroutineScopeKt.d(r5, r6, r3, r6)
                goto L62
            L57:
                eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo r5 = r4.f38027h
                eu.bolt.chat.tools.logger.Logger r5 = eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.v(r5)
                java.lang.String r6 = "Chat Client is not available yet"
                r5.b(r6)
            L62:
                kotlin.Unit r5 = kotlin.Unit.f50853a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1.AnonymousClass1.b(eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$RepoStatus, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatSdkChatRepo$launchWhenActive$1(ChatSdkChatRepo chatSdkChatRepo, Function2<? super ChatClient, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ChatSdkChatRepo$launchWhenActive$1> continuation) {
        super(2, continuation);
        this.f38023i = chatSdkChatRepo;
        this.f38024j = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatSdkChatRepo$launchWhenActive$1 chatSdkChatRepo$launchWhenActive$1 = new ChatSdkChatRepo$launchWhenActive$1(this.f38023i, this.f38024j, continuation);
        chatSdkChatRepo$launchWhenActive$1.f38022h = obj;
        return chatSdkChatRepo$launchWhenActive$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChatSdkChatRepo$launchWhenActive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        MutableStateFlow mutableStateFlow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38021g;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            mutableStateFlow = this.f38023i.f37911m;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f38024j, (CoroutineScope) this.f38022h, this.f38023i);
            this.f38021g = 1;
            if (mutableStateFlow.a(anonymousClass1, this) == d8) {
                return d8;
            }
        }
        throw new KotlinNothingValueException();
    }
}
