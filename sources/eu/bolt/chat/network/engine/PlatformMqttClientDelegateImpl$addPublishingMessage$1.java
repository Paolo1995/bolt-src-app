package eu.bolt.chat.network.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformMqttClientDelegateImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl", f = "PlatformMqttClientDelegateImpl.kt", l = {119}, m = "addPublishingMessage")
/* loaded from: classes5.dex */
public final class PlatformMqttClientDelegateImpl$addPublishingMessage$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39486f;

    /* renamed from: g  reason: collision with root package name */
    Object f39487g;

    /* renamed from: h  reason: collision with root package name */
    Object f39488h;

    /* renamed from: i  reason: collision with root package name */
    int f39489i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f39490j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ PlatformMqttClientDelegateImpl f39491k;

    /* renamed from: l  reason: collision with root package name */
    int f39492l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformMqttClientDelegateImpl$addPublishingMessage$1(PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl, Continuation<? super PlatformMqttClientDelegateImpl$addPublishingMessage$1> continuation) {
        super(continuation);
        this.f39491k = platformMqttClientDelegateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39490j = obj;
        this.f39492l |= Integer.MIN_VALUE;
        return this.f39491k.d(0, null, this);
    }
}
