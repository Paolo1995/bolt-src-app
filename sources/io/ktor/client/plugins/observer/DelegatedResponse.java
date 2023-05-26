package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
/* loaded from: classes5.dex */
public final class DelegatedResponse extends HttpResponse {

    /* renamed from: f  reason: collision with root package name */
    private final HttpClientCall f46582f;

    /* renamed from: g  reason: collision with root package name */
    private final ByteReadChannel f46583g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpResponse f46584h;

    /* renamed from: i  reason: collision with root package name */
    private final CoroutineContext f46585i;

    public DelegatedResponse(HttpClientCall call, ByteReadChannel content, HttpResponse origin) {
        Intrinsics.f(call, "call");
        Intrinsics.f(content, "content");
        Intrinsics.f(origin, "origin");
        this.f46582f = call;
        this.f46583g = content;
        this.f46584h = origin;
        this.f46585i = origin.j();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpClientCall Y() {
        return this.f46582f;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public ByteReadChannel a() {
        return this.f46583g;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate b() {
        return this.f46584h.b();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate c() {
        return this.f46584h.c();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpStatusCode e() {
        return this.f46584h.e();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpProtocolVersion f() {
        return this.f46584h.f();
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.f46584h.getHeaders();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f46585i;
    }
}
