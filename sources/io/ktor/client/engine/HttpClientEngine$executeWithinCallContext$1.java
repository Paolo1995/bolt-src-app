package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngine;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$DefaultImpls", f = "HttpClientEngine.kt", l = {91, 100}, m = "executeWithinCallContext")
/* loaded from: classes5.dex */
public final class HttpClientEngine$executeWithinCallContext$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46109f;

    /* renamed from: g  reason: collision with root package name */
    Object f46110g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46111h;

    /* renamed from: i  reason: collision with root package name */
    int f46112i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpClientEngine$executeWithinCallContext$1(Continuation<? super HttpClientEngine$executeWithinCallContext$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e8;
        this.f46111h = obj;
        this.f46112i |= Integer.MIN_VALUE;
        e8 = HttpClientEngine.DefaultImpls.e(null, null, this);
        return e8;
    }
}
