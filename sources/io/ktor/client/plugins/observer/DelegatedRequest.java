package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
/* loaded from: classes5.dex */
public final class DelegatedRequest implements HttpRequest {

    /* renamed from: f  reason: collision with root package name */
    private final HttpClientCall f46580f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ HttpRequest f46581g;

    public DelegatedRequest(HttpClientCall call, HttpRequest origin) {
        Intrinsics.f(call, "call");
        Intrinsics.f(origin, "origin");
        this.f46580f = call;
        this.f46581g = origin;
    }

    @Override // io.ktor.client.request.HttpRequest
    public HttpClientCall Y() {
        return this.f46580f;
    }

    @Override // io.ktor.client.request.HttpRequest
    public Attributes getAttributes() {
        return this.f46581g.getAttributes();
    }

    @Override // io.ktor.client.request.HttpRequest
    public OutgoingContent getContent() {
        return this.f46581g.getContent();
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.f46581g.getHeaders();
    }

    @Override // io.ktor.client.request.HttpRequest
    public HttpMethod getMethod() {
        return this.f46581g.getMethod();
    }

    @Override // io.ktor.client.request.HttpRequest
    public Url getUrl() {
        return this.f46581g.getUrl();
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f46581g.j();
    }
}
