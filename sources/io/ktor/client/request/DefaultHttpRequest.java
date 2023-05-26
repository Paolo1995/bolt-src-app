package io.ktor.client.request;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultHttpRequest.kt */
/* loaded from: classes5.dex */
public class DefaultHttpRequest implements HttpRequest {

    /* renamed from: f  reason: collision with root package name */
    private final HttpClientCall f46606f;

    /* renamed from: g  reason: collision with root package name */
    private final HttpMethod f46607g;

    /* renamed from: h  reason: collision with root package name */
    private final Url f46608h;

    /* renamed from: i  reason: collision with root package name */
    private final OutgoingContent f46609i;

    /* renamed from: j  reason: collision with root package name */
    private final Headers f46610j;

    /* renamed from: k  reason: collision with root package name */
    private final Attributes f46611k;

    public DefaultHttpRequest(HttpClientCall call, HttpRequestData data) {
        Intrinsics.f(call, "call");
        Intrinsics.f(data, "data");
        this.f46606f = call;
        this.f46607g = data.f();
        this.f46608h = data.h();
        this.f46609i = data.b();
        this.f46610j = data.e();
        this.f46611k = data.a();
    }

    @Override // io.ktor.client.request.HttpRequest
    public HttpClientCall Y() {
        return this.f46606f;
    }

    @Override // io.ktor.client.request.HttpRequest
    public Attributes getAttributes() {
        return this.f46611k;
    }

    @Override // io.ktor.client.request.HttpRequest
    public OutgoingContent getContent() {
        return this.f46609i;
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.f46610j;
    }

    @Override // io.ktor.client.request.HttpRequest
    public HttpMethod getMethod() {
        return this.f46607g;
    }

    @Override // io.ktor.client.request.HttpRequest
    public Url getUrl() {
        return this.f46608h;
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return Y().j();
    }
}
