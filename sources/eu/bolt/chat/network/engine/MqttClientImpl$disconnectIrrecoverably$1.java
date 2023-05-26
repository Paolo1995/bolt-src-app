package eu.bolt.chat.network.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MqttClientImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl", f = "MqttClientImpl.kt", l = {131, 132}, m = "disconnectIrrecoverably")
/* loaded from: classes5.dex */
public final class MqttClientImpl$disconnectIrrecoverably$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39445f;

    /* renamed from: g  reason: collision with root package name */
    Object f39446g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f39447h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ MqttClientImpl f39448i;

    /* renamed from: j  reason: collision with root package name */
    int f39449j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttClientImpl$disconnectIrrecoverably$1(MqttClientImpl mqttClientImpl, Continuation<? super MqttClientImpl$disconnectIrrecoverably$1> continuation) {
        super(continuation);
        this.f39448i = mqttClientImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object k8;
        this.f39447h = obj;
        this.f39449j |= Integer.MIN_VALUE;
        k8 = this.f39448i.k(null, this);
        return k8;
    }
}
