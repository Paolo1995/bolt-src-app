package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.engine.ConnectionEvent;
import eu.bolt.chat.util.CoroutineRunner;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: MqttClientImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl$connect$2", f = "MqttClientImpl.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class MqttClientImpl$connect$2 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39442g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ MqttClientImpl f39443h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttClientImpl$connect$2(MqttClientImpl mqttClientImpl, Continuation<? super MqttClientImpl$connect$2> continuation) {
        super(2, continuation);
        this.f39443h = mqttClientImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MqttClientImpl$connect$2(this.f39443h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((MqttClientImpl$connect$2) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        InternalPlatformMqttClientDelegate internalPlatformMqttClientDelegate;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39442g;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            internalPlatformMqttClientDelegate = this.f39443h.f39416c;
            SharedFlow<ConnectionEvent> j8 = internalPlatformMqttClientDelegate.j();
            final MqttClientImpl mqttClientImpl = this.f39443h;
            FlowCollector<? super ConnectionEvent> flowCollector = new FlowCollector() { // from class: eu.bolt.chat.network.engine.MqttClientImpl$connect$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: a */
                public final Object b(ConnectionEvent connectionEvent, Continuation<? super Unit> continuation) {
                    boolean a8;
                    Object n8;
                    Object d9;
                    Object m8;
                    Object d10;
                    if (connectionEvent instanceof ConnectionEvent.Connected) {
                        m8 = MqttClientImpl.this.m(continuation);
                        d10 = IntrinsicsKt__IntrinsicsKt.d();
                        if (m8 == d10) {
                            return m8;
                        }
                        return Unit.f50853a;
                    } else if (connectionEvent instanceof ConnectionEvent.Failure) {
                        n8 = MqttClientImpl.this.n(((ConnectionEvent.Failure) connectionEvent).a(), continuation);
                        d9 = IntrinsicsKt__IntrinsicsKt.d();
                        if (n8 == d9) {
                            return n8;
                        }
                        return Unit.f50853a;
                    } else {
                        if (Intrinsics.a(connectionEvent, ConnectionEvent.Disconnected.f39408a)) {
                            a8 = true;
                        } else {
                            a8 = Intrinsics.a(connectionEvent, ConnectionEvent.Reconnecting.f39410a);
                        }
                        if (!a8) {
                            return Unit.f50853a;
                        }
                        throw new IllegalStateException(("Platform Client doesn't support event " + connectionEvent).toString());
                    }
                }
            };
            this.f39442g = 1;
            if (j8.a(flowCollector, this) == d8) {
                return d8;
            }
        }
        throw new KotlinNothingValueException();
    }
}
