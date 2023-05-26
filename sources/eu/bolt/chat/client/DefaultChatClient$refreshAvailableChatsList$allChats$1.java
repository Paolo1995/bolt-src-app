package eu.bolt.chat.client;

import eu.bolt.chat.data.Chat;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$allChats$1", f = "DefaultChatClient.kt", l = {212}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$refreshAvailableChatsList$allChats$1 extends SuspendLambda implements Function2<Set<? extends String>, Continuation<? super List<? extends Chat>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f38798g;

    /* renamed from: h  reason: collision with root package name */
    Object f38799h;

    /* renamed from: i  reason: collision with root package name */
    int f38800i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f38801j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38802k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$refreshAvailableChatsList$allChats$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$refreshAvailableChatsList$allChats$1> continuation) {
        super(2, continuation);
        this.f38802k = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultChatClient$refreshAvailableChatsList$allChats$1 defaultChatClient$refreshAvailableChatsList$allChats$1 = new DefaultChatClient$refreshAvailableChatsList$allChats$1(this.f38802k, continuation);
        defaultChatClient$refreshAvailableChatsList$allChats$1.f38801j = obj;
        return defaultChatClient$refreshAvailableChatsList$allChats$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(Set<String> set, Continuation<? super List<Chat>> continuation) {
        return ((DefaultChatClient$refreshAvailableChatsList$allChats$1) create(set, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x005c -> B:15:0x0063). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r7.f38800i
            r2 = 1
            if (r1 == 0) goto L28
            if (r1 != r2) goto L20
            java.lang.Object r1 = r7.f38799h
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r7.f38798g
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.Object r4 = r7.f38801j
            eu.bolt.chat.client.DefaultChatClient r4 = (eu.bolt.chat.client.DefaultChatClient) r4
            kotlin.ResultKt.b(r8)
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r7
            goto L63
        L20:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L28:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.f38801j
            java.util.Set r8 = (java.util.Set) r8
            eu.bolt.chat.client.DefaultChatClient r1 = r7.f38802k
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r8 = r8.iterator()
            r4 = r1
            r1 = r8
            r8 = r7
        L3d:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L70
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            eu.bolt.chat.client.InternalChatManager r5 = eu.bolt.chat.client.DefaultChatClient.l(r4, r5)
            r8.f38801j = r4
            r8.f38798g = r3
            r8.f38799h = r1
            r8.f38800i = r2
            java.lang.Object r5 = r5.g(r8)
            if (r5 != r0) goto L5c
            return r0
        L5c:
            r6 = r0
            r0 = r8
            r8 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r6
        L63:
            eu.bolt.chat.data.Chat r8 = (eu.bolt.chat.data.Chat) r8
            if (r8 == 0) goto L6a
            r4.add(r8)
        L6a:
            r8 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r4 = r5
            goto L3d
        L70:
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClient$refreshAvailableChatsList$allChats$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
