package eu.bolt.chat.network.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformMqttClientDelegateImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl", f = "PlatformMqttClientDelegateImpl.kt", l = {119}, m = "cleanPublishingMessages")
/* loaded from: classes5.dex */
public final class PlatformMqttClientDelegateImpl$cleanPublishingMessages$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39493f;

    /* renamed from: g  reason: collision with root package name */
    Object f39494g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f39495h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ PlatformMqttClientDelegateImpl f39496i;

    /* renamed from: j  reason: collision with root package name */
    int f39497j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformMqttClientDelegateImpl$cleanPublishingMessages$1(PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl, Continuation<? super PlatformMqttClientDelegateImpl$cleanPublishingMessages$1> continuation) {
        super(continuation);
        this.f39496i = platformMqttClientDelegateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39495h = obj;
        this.f39497j |= Integer.MIN_VALUE;
        return this.f39496i.g(this);
    }
}
