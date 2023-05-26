package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultHttpResponse.kt */
/* loaded from: classes5.dex */
public final class DefaultHttpResponse extends HttpResponse {

    /* renamed from: f  reason: collision with root package name */
    private final HttpClientCall f46649f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineContext f46650g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpStatusCode f46651h;

    /* renamed from: i  reason: collision with root package name */
    private final HttpProtocolVersion f46652i;

    /* renamed from: j  reason: collision with root package name */
    private final GMTDate f46653j;

    /* renamed from: k  reason: collision with root package name */
    private final GMTDate f46654k;

    /* renamed from: l  reason: collision with root package name */
    private final ByteReadChannel f46655l;

    /* renamed from: m  reason: collision with root package name */
    private final Headers f46656m;

    public DefaultHttpResponse(HttpClientCall call, HttpResponseData responseData) {
        ByteReadChannel byteReadChannel;
        Intrinsics.f(call, "call");
        Intrinsics.f(responseData, "responseData");
        this.f46649f = call;
        this.f46650g = responseData.b();
        this.f46651h = responseData.f();
        this.f46652i = responseData.g();
        this.f46653j = responseData.d();
        this.f46654k = responseData.e();
        Object a8 = responseData.a();
        if (a8 instanceof ByteReadChannel) {
            byteReadChannel = (ByteReadChannel) a8;
        } else {
            byteReadChannel = null;
        }
        this.f46655l = byteReadChannel == null ? ByteReadChannel.f47328a.a() : byteReadChannel;
        this.f46656m = responseData.c();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpClientCall Y() {
        return this.f46649f;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public ByteReadChannel a() {
        return this.f46655l;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate b() {
        return this.f46653j;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate c() {
        return this.f46654k;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpStatusCode e() {
        return this.f46651h;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpProtocolVersion f() {
        return this.f46652i;
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.f46656m;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f46650g;
    }
}
