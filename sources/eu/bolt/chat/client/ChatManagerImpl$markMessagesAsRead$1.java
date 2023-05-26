package eu.bolt.chat.client;

import eu.bolt.chat.util.CoroutineRunner;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ChatManagerImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.client.ChatManagerImpl$markMessagesAsRead$1", f = "ChatManagerImpl.kt", l = {345, 349}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChatManagerImpl$markMessagesAsRead$1 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f38579g;

    /* renamed from: h  reason: collision with root package name */
    Object f38580h;

    /* renamed from: i  reason: collision with root package name */
    Object f38581i;

    /* renamed from: j  reason: collision with root package name */
    int f38582j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ List<String> f38583k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ ChatManagerImpl f38584l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManagerImpl$markMessagesAsRead$1(List<String> list, ChatManagerImpl chatManagerImpl, Continuation<? super ChatManagerImpl$markMessagesAsRead$1> continuation) {
        super(2, continuation);
        this.f38583k = list;
        this.f38584l = chatManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatManagerImpl$markMessagesAsRead$1(this.f38583k, this.f38584l, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((ChatManagerImpl$markMessagesAsRead$1) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0062 -> B:17:0x0069). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.ChatManagerImpl$markMessagesAsRead$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
