package eu.bolt.chat.client;

import eu.bolt.chat.network.engine.MqttClient;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$destroy$1", f = "DefaultChatClient.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$destroy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38719g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38720h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$destroy$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$destroy$1> continuation) {
        super(2, continuation);
        this.f38720h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultChatClient$destroy$1(this.f38720h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultChatClient$destroy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MqttClient U;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38719g == 0) {
            ResultKt.b(obj);
            U = this.f38720h.U();
            U.disconnect();
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
