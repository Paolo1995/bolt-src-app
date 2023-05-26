package eu.bolt.chat.client;

import eu.bolt.chat.network.engine.ConnectionEvent;
import eu.bolt.chat.network.engine.MqttClient;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$initialize$1", f = "DefaultChatClient.kt", l = {71}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38770g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38771h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$initialize$1(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$initialize$1> continuation) {
        super(2, continuation);
        this.f38771h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultChatClient$initialize$1(this.f38771h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultChatClient$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AtomicBoolean atomicBoolean;
        MqttClient U;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38770g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            atomicBoolean = this.f38771h.f38656n;
            atomicBoolean.c(false);
            U = this.f38771h.U();
            Flow<ConnectionEvent> a8 = U.a();
            final DefaultChatClient defaultChatClient = this.f38771h;
            FlowCollector<? super ConnectionEvent> flowCollector = new FlowCollector() { // from class: eu.bolt.chat.client.DefaultChatClient$initialize$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: a */
                public final Object b(ConnectionEvent connectionEvent, Continuation<? super Unit> continuation) {
                    Object a02;
                    Object d9;
                    a02 = DefaultChatClient.this.a0(connectionEvent, continuation);
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    if (a02 == d9) {
                        return a02;
                    }
                    return Unit.f50853a;
                }
            };
            this.f38770g = 1;
            if (a8.a(flowCollector, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
