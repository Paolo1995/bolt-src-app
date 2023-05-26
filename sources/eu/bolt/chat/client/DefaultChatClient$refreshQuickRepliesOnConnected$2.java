package eu.bolt.chat.client;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ClientStatus;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$2", f = "DefaultChatClient.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class DefaultChatClient$refreshQuickRepliesOnConnected$2 extends SuspendLambda implements Function3<List<? extends Chat>, ClientStatus, Continuation<? super Pair<? extends List<? extends Chat>, ? extends ClientStatus>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38803g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38804h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f38805i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChatClient$refreshQuickRepliesOnConnected$2(Continuation<? super DefaultChatClient$refreshQuickRepliesOnConnected$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(List<Chat> list, ClientStatus clientStatus, Continuation<? super Pair<? extends List<Chat>, ? extends ClientStatus>> continuation) {
        DefaultChatClient$refreshQuickRepliesOnConnected$2 defaultChatClient$refreshQuickRepliesOnConnected$2 = new DefaultChatClient$refreshQuickRepliesOnConnected$2(continuation);
        defaultChatClient$refreshQuickRepliesOnConnected$2.f38804h = list;
        defaultChatClient$refreshQuickRepliesOnConnected$2.f38805i = clientStatus;
        return defaultChatClient$refreshQuickRepliesOnConnected$2.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38803g == 0) {
            ResultKt.b(obj);
            return TuplesKt.a((List) this.f38804h, (ClientStatus) this.f38805i);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
