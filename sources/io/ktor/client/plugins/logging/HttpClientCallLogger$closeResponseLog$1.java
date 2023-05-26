package io.ktor.client.plugins.logging;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientCallLogger.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", l = {52}, m = "closeResponseLog")
/* loaded from: classes5.dex */
public final class HttpClientCallLogger$closeResponseLog$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46503f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f46504g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ HttpClientCallLogger f46505h;

    /* renamed from: i  reason: collision with root package name */
    int f46506i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCallLogger$closeResponseLog$1(HttpClientCallLogger httpClientCallLogger, Continuation<? super HttpClientCallLogger$closeResponseLog$1> continuation) {
        super(continuation);
        this.f46505h = httpClientCallLogger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46504g = obj;
        this.f46506i |= Integer.MIN_VALUE;
        return this.f46505h.b(this);
    }
}
