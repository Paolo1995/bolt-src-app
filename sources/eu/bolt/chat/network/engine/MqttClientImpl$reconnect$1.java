package eu.bolt.chat.network.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MqttClientImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl", f = "MqttClientImpl.kt", l = {96, 97}, m = "reconnect")
/* loaded from: classes5.dex */
public final class MqttClientImpl$reconnect$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39464f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f39465g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ MqttClientImpl f39466h;

    /* renamed from: i  reason: collision with root package name */
    int f39467i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttClientImpl$reconnect$1(MqttClientImpl mqttClientImpl, Continuation<? super MqttClientImpl$reconnect$1> continuation) {
        super(continuation);
        this.f39466h = mqttClientImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object p8;
        this.f39465g = obj;
        this.f39467i |= Integer.MIN_VALUE;
        p8 = this.f39466h.p(0, this);
        return p8;
    }
}
