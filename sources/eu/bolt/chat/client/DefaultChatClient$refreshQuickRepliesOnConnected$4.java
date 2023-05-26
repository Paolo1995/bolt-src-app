package eu.bolt.chat.client;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ClientStatus;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$refreshQuickRepliesOnConnected$4", f = "DefaultChatClient.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$refreshQuickRepliesOnConnected$4 extends SuspendLambda implements Function2<Pair<? extends List<? extends Chat>, ? extends ClientStatus>, Continuation<? super Flow<? extends Chat>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38806g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38807h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChatClient$refreshQuickRepliesOnConnected$4(Continuation<? super DefaultChatClient$refreshQuickRepliesOnConnected$4> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultChatClient$refreshQuickRepliesOnConnected$4 defaultChatClient$refreshQuickRepliesOnConnected$4 = new DefaultChatClient$refreshQuickRepliesOnConnected$4(continuation);
        defaultChatClient$refreshQuickRepliesOnConnected$4.f38807h = obj;
        return defaultChatClient$refreshQuickRepliesOnConnected$4;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(Pair<? extends List<Chat>, ? extends ClientStatus> pair, Continuation<? super Flow<Chat>> continuation) {
        return ((DefaultChatClient$refreshQuickRepliesOnConnected$4) create(pair, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38806g == 0) {
            ResultKt.b(obj);
            return FlowKt.a((List) ((Pair) this.f38807h).a());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
