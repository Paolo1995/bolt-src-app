package io.ktor.client.engine.okhttp;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {113}, m = "executeHttpRequest")
/* loaded from: classes5.dex */
public final class OkHttpEngine$executeHttpRequest$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46170f;

    /* renamed from: g  reason: collision with root package name */
    Object f46171g;

    /* renamed from: h  reason: collision with root package name */
    Object f46172h;

    /* renamed from: i  reason: collision with root package name */
    Object f46173i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f46174j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ OkHttpEngine f46175k;

    /* renamed from: l  reason: collision with root package name */
    int f46176l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine$executeHttpRequest$1(OkHttpEngine okHttpEngine, Continuation<? super OkHttpEngine$executeHttpRequest$1> continuation) {
        super(continuation);
        this.f46175k = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object t7;
        this.f46174j = obj;
        this.f46176l |= Integer.MIN_VALUE;
        t7 = this.f46175k.t(null, null, null, null, this);
        return t7;
    }
}
