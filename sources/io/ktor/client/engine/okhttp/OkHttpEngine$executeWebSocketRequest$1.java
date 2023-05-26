package io.ktor.client.engine.okhttp;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {102}, m = "executeWebSocketRequest")
/* loaded from: classes5.dex */
public final class OkHttpEngine$executeWebSocketRequest$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46178f;

    /* renamed from: g  reason: collision with root package name */
    Object f46179g;

    /* renamed from: h  reason: collision with root package name */
    Object f46180h;

    /* renamed from: i  reason: collision with root package name */
    Object f46181i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f46182j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ OkHttpEngine f46183k;

    /* renamed from: l  reason: collision with root package name */
    int f46184l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine$executeWebSocketRequest$1(OkHttpEngine okHttpEngine, Continuation<? super OkHttpEngine$executeWebSocketRequest$1> continuation) {
        super(continuation);
        this.f46183k = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object w7;
        this.f46182j = obj;
        this.f46184l |= Integer.MIN_VALUE;
        w7 = this.f46183k.w(null, null, null, this);
        return w7;
    }
}
