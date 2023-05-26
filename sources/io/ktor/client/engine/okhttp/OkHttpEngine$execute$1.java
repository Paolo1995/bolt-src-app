package io.ktor.client.engine.okhttp;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {71, 78, 80}, m = "execute")
/* loaded from: classes5.dex */
public final class OkHttpEngine$execute$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46165f;

    /* renamed from: g  reason: collision with root package name */
    Object f46166g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46167h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OkHttpEngine f46168i;

    /* renamed from: j  reason: collision with root package name */
    int f46169j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine$execute$1(OkHttpEngine okHttpEngine, Continuation<? super OkHttpEngine$execute$1> continuation) {
        super(continuation);
        this.f46168i = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46167h = obj;
        this.f46169j |= Integer.MIN_VALUE;
        return this.f46168i.Y0(null, this);
    }
}
