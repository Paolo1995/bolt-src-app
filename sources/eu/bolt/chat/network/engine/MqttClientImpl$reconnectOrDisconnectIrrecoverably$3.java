package eu.bolt.chat.network.engine;

import eu.bolt.chat.util.CoroutineRunner;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MqttClientImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl$reconnectOrDisconnectIrrecoverably$3", f = "MqttClientImpl.kt", l = {142}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class MqttClientImpl$reconnectOrDisconnectIrrecoverably$3 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39473g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ MqttClientImpl f39474h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ int f39475i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttClientImpl$reconnectOrDisconnectIrrecoverably$3(MqttClientImpl mqttClientImpl, int i8, Continuation<? super MqttClientImpl$reconnectOrDisconnectIrrecoverably$3> continuation) {
        super(2, continuation);
        this.f39474h = mqttClientImpl;
        this.f39475i = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MqttClientImpl$reconnectOrDisconnectIrrecoverably$3(this.f39474h, this.f39475i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((MqttClientImpl$reconnectOrDisconnectIrrecoverably$3) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object p8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39473g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            MqttClientImpl mqttClientImpl = this.f39474h;
            int i9 = this.f39475i;
            this.f39473g = 1;
            p8 = mqttClientImpl.p(i9, this);
            if (p8 == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
