package io.ktor.client.call;

import io.ktor.client.request.HttpRequest;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedCall.kt */
/* loaded from: classes5.dex */
public final class SavedHttpRequest implements HttpRequest {

    /* renamed from: f  reason: collision with root package name */
    private final SavedHttpCall f46090f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ HttpRequest f46091g;

    public SavedHttpRequest(SavedHttpCall call, HttpRequest origin) {
        Intrinsics.f(call, "call");
        Intrinsics.f(origin, "origin");
        this.f46090f = call;
        this.f46091g = origin;
    }

    @Override // io.ktor.client.request.HttpRequest
    /* renamed from: a */
    public SavedHttpCall Y() {
        return this.f46090f;
    }

    @Override // io.ktor.client.request.HttpRequest
    public Attributes getAttributes() {
        return this.f46091g.getAttributes();
    }

    @Override // io.ktor.client.request.HttpRequest
    public OutgoingContent getContent() {
        return this.f46091g.getContent();
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.f46091g.getHeaders();
    }

    @Override // io.ktor.client.request.HttpRequest
    public HttpMethod getMethod() {
        return this.f46091g.getMethod();
    }

    @Override // io.ktor.client.request.HttpRequest
    public Url getUrl() {
        return this.f46091g.getUrl();
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f46091g.j();
    }
}
