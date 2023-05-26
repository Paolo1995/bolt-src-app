package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.engine.ConnectionEvent;
import eu.bolt.chat.network.exception.MqttException;
import eu.bolt.chat.util.CoroutineRunner;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: PlatformMqttClientDelegateImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$onDisconnected$1", f = "PlatformMqttClientDelegateImpl.kt", l = {55}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class PlatformMqttClientDelegateImpl$onDisconnected$1 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39500g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ PlatformMqttClientDelegateImpl f39501h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ MqttException f39502i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformMqttClientDelegateImpl$onDisconnected$1(PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl, MqttException mqttException, Continuation<? super PlatformMqttClientDelegateImpl$onDisconnected$1> continuation) {
        super(2, continuation);
        this.f39501h = platformMqttClientDelegateImpl;
        this.f39502i = mqttException;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlatformMqttClientDelegateImpl$onDisconnected$1(this.f39501h, this.f39502i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((PlatformMqttClientDelegateImpl$onDisconnected$1) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        MutableSharedFlow mutableSharedFlow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39500g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            mutableSharedFlow = this.f39501h.f39480e;
            ConnectionEvent.Failure failure = new ConnectionEvent.Failure(this.f39502i);
            this.f39500g = 1;
            if (mutableSharedFlow.b(failure, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
