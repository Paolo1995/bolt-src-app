package eu.bolt.chat.network.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MqttClientImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.MqttClientImpl", f = "MqttClientImpl.kt", l = {80, 84}, m = "publish")
/* loaded from: classes5.dex */
public final class MqttClientImpl$publish$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39454f;

    /* renamed from: g  reason: collision with root package name */
    Object f39455g;

    /* renamed from: h  reason: collision with root package name */
    Object f39456h;

    /* renamed from: i  reason: collision with root package name */
    int f39457i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f39458j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ MqttClientImpl f39459k;

    /* renamed from: l  reason: collision with root package name */
    int f39460l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttClientImpl$publish$1(MqttClientImpl mqttClientImpl, Continuation<? super MqttClientImpl$publish$1> continuation) {
        super(continuation);
        this.f39459k = mqttClientImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39458j = obj;
        this.f39460l |= Integer.MIN_VALUE;
        return this.f39459k.d(null, null, this);
    }
}
