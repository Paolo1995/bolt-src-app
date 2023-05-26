package io.ktor.client.plugins.logging;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientCallLogger.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", l = {29}, m = "logResponseException")
/* loaded from: classes5.dex */
public final class HttpClientCallLogger$logResponseException$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46512f;

    /* renamed from: g  reason: collision with root package name */
    Object f46513g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46514h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ HttpClientCallLogger f46515i;

    /* renamed from: j  reason: collision with root package name */
    int f46516j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCallLogger$logResponseException$1(HttpClientCallLogger httpClientCallLogger, Continuation<? super HttpClientCallLogger$logResponseException$1> continuation) {
        super(continuation);
        this.f46515i = httpClientCallLogger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46514h = obj;
        this.f46516j |= Integer.MIN_VALUE;
        return this.f46515i.e(null, this);
    }
}
