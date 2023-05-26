package eu.bolt.chat.network.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MqttClientImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl", f = "MqttClientImpl.kt", l = {123}, m = "disconnectRegularly")
/* loaded from: classes5.dex */
public final class MqttClientImpl$disconnectRegularly$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39450f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f39451g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ MqttClientImpl f39452h;

    /* renamed from: i  reason: collision with root package name */
    int f39453i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttClientImpl$disconnectRegularly$1(MqttClientImpl mqttClientImpl, Continuation<? super MqttClientImpl$disconnectRegularly$1> continuation) {
        super(continuation);
        this.f39452h = mqttClientImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l8;
        this.f39451g = obj;
        this.f39453i |= Integer.MIN_VALUE;
        l8 = this.f39452h.l(this);
        return l8;
    }
}
