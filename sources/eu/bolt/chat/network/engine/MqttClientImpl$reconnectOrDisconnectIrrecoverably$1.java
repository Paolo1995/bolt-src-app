package eu.bolt.chat.network.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MqttClientImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl", f = "MqttClientImpl.kt", l = {140, 144}, m = "reconnectOrDisconnectIrrecoverably")
/* loaded from: classes5.dex */
public final class MqttClientImpl$reconnectOrDisconnectIrrecoverably$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39468f;

    /* renamed from: g  reason: collision with root package name */
    int f39469g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f39470h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ MqttClientImpl f39471i;

    /* renamed from: j  reason: collision with root package name */
    int f39472j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttClientImpl$reconnectOrDisconnectIrrecoverably$1(MqttClientImpl mqttClientImpl, Continuation<? super MqttClientImpl$reconnectOrDisconnectIrrecoverably$1> continuation) {
        super(continuation);
        this.f39471i = mqttClientImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object q8;
        this.f39470h = obj;
        this.f39472j |= Integer.MIN_VALUE;
        q8 = this.f39471i.q(null, this);
        return q8;
    }
}
