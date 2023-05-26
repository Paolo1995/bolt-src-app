package io.ktor.client.plugins.logging;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientCallLogger.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", l = {34}, m = "logResponseBody")
/* loaded from: classes5.dex */
public final class HttpClientCallLogger$logResponseBody$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46507f;

    /* renamed from: g  reason: collision with root package name */
    Object f46508g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46509h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ HttpClientCallLogger f46510i;

    /* renamed from: j  reason: collision with root package name */
    int f46511j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCallLogger$logResponseBody$1(HttpClientCallLogger httpClientCallLogger, Continuation<? super HttpClientCallLogger$logResponseBody$1> continuation) {
        super(continuation);
        this.f46510i = httpClientCallLogger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46509h = obj;
        this.f46511j |= Integer.MIN_VALUE;
        return this.f46510i.d(null, this);
    }
}
