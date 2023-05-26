package eu.bolt.chat.client;

import eu.bolt.chat.data.QuickReplySuggestion;
import eu.bolt.chat.util.CoroutineRunner;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl$sendQuickReply$1", f = "ChatManagerImpl.kt", l = {273, 274, 281}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChatManagerImpl$sendQuickReply$1 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f38599g;

    /* renamed from: h  reason: collision with root package name */
    int f38600h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38601i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ QuickReplySuggestion f38602j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$sendQuickReply$1(ChatManagerImpl chatManagerImpl, QuickReplySuggestion quickReplySuggestion, Continuation<? super ChatManagerImpl$sendQuickReply$1> continuation) {
        super(2, continuation);
        this.f38601i = chatManagerImpl;
        this.f38602j = quickReplySuggestion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatManagerImpl$sendQuickReply$1(this.f38601i, this.f38602j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((ChatManagerImpl$sendQuickReply$1) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f38600h
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L32
            if (r2 == r5) goto L2a
            if (r2 == r4) goto L20
            if (r2 != r3) goto L18
            kotlin.ResultKt.b(r18)
            goto La7
        L18:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L20:
            java.lang.Object r2 = r0.f38599g
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.b(r18)
            r3 = r18
            goto L92
        L2a:
            java.lang.Object r2 = r0.f38599g
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.b(r18)
            goto L70
        L32:
            kotlin.ResultKt.b(r18)
            eu.bolt.chat.util.UUID r2 = eu.bolt.chat.util.UUID.f39707a
            java.lang.String r2 = r2.a()
            kotlinx.datetime.LocalDateTime$Companion r6 = kotlinx.datetime.LocalDateTime.Companion
            kotlinx.datetime.LocalDateTime r9 = eu.bolt.chat.util.DateTimeUtilsKt.a(r6)
            eu.bolt.chat.data.message.UserTextMessage r15 = new eu.bolt.chat.data.message.UserTextMessage
            eu.bolt.chat.client.ChatManagerImpl r6 = r0.f38601i
            java.lang.String r8 = eu.bolt.chat.client.ChatManagerImpl.t(r6)
            eu.bolt.chat.data.message.MessageStatus r10 = eu.bolt.chat.data.message.MessageStatus.SENDING
            eu.bolt.chat.data.QuickReplySuggestion r6 = r0.f38602j
            java.lang.String r11 = r6.b()
            r12 = 1
            eu.bolt.chat.client.ChatManagerImpl r6 = r0.f38601i
            eu.bolt.chat.data.message.MessageSender r13 = eu.bolt.chat.client.ChatManagerImpl.v(r6)
            r14 = 0
            r16 = 0
            r6 = r15
            r7 = r2
            r3 = r15
            r15 = r16
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            eu.bolt.chat.client.ChatManagerImpl r6 = r0.f38601i
            r0.f38599g = r2
            r0.f38600h = r5
            java.lang.Object r3 = r6.p(r3, r0)
            if (r3 != r1) goto L70
            return r1
        L70:
            eu.bolt.chat.client.ChatManagerImpl r3 = r0.f38601i
            eu.bolt.chat.client.MessagePublisher r3 = eu.bolt.chat.client.ChatManagerImpl.x(r3)
            eu.bolt.chat.data.message.QuickReplyMessage r5 = new eu.bolt.chat.data.message.QuickReplyMessage
            eu.bolt.chat.client.ChatManagerImpl r6 = r0.f38601i
            java.lang.String r6 = eu.bolt.chat.client.ChatManagerImpl.t(r6)
            eu.bolt.chat.data.QuickReplySuggestion r7 = r0.f38602j
            java.lang.String r7 = r7.a()
            r5.<init>(r2, r6, r7)
            r0.f38599g = r2
            r0.f38600h = r4
            java.lang.Object r3 = r3.a(r5, r0)
            if (r3 != r1) goto L92
            return r1
        L92:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            eu.bolt.chat.client.ChatManagerImpl r4 = r0.f38601i
            r5 = 0
            r0.f38599g = r5
            r5 = 3
            r0.f38600h = r5
            java.lang.Object r2 = eu.bolt.chat.client.ChatManagerImpl.G(r4, r3, r2, r0)
            if (r2 != r1) goto La7
            return r1
        La7:
            kotlin.Unit r1 = kotlin.Unit.f50853a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl$sendQuickReply$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
