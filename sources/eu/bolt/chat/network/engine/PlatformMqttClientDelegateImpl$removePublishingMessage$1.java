package eu.bolt.chat.network.engine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformMqttClientDelegateImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl", f = "PlatformMqttClientDelegateImpl.kt", l = {119}, m = "removePublishingMessage")
/* loaded from: classes5.dex */
public final class PlatformMqttClientDelegateImpl$removePublishingMessage$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39520f;

    /* renamed from: g  reason: collision with root package name */
    Object f39521g;

    /* renamed from: h  reason: collision with root package name */
    int f39522h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f39523i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ PlatformMqttClientDelegateImpl f39524j;

    /* renamed from: k  reason: collision with root package name */
    int f39525k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformMqttClientDelegateImpl$removePublishingMessage$1(PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl, Continuation<? super PlatformMqttClientDelegateImpl$removePublishingMessage$1> continuation) {
        super(continuation);
        this.f39524j = platformMqttClientDelegateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object r7;
        this.f39523i = obj;
        this.f39525k |= Integer.MIN_VALUE;
        r7 = this.f39524j.r(0, this);
        return r7;
    }
}
