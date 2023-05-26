package io.ktor.client.request;

import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: HttpRequest.kt */
/* loaded from: classes5.dex */
public final class HttpRequestData {

    /* renamed from: a  reason: collision with root package name */
    private final Url f46620a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpMethod f46621b;

    /* renamed from: c  reason: collision with root package name */
    private final Headers f46622c;

    /* renamed from: d  reason: collision with root package name */
    private final OutgoingContent f46623d;

    /* renamed from: e  reason: collision with root package name */
    private final Job f46624e;

    /* renamed from: f  reason: collision with root package name */
    private final Attributes f46625f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<HttpClientEngineCapability<?>> f46626g;

    public HttpRequestData(Url url, HttpMethod method, Headers headers, OutgoingContent body, Job executionContext, Attributes attributes) {
        Set<HttpClientEngineCapability<?>> b8;
        Intrinsics.f(url, "url");
        Intrinsics.f(method, "method");
        Intrinsics.f(headers, "headers");
        Intrinsics.f(body, "body");
        Intrinsics.f(executionContext, "executionContext");
        Intrinsics.f(attributes, "attributes");
        this.f46620a = url;
        this.f46621b = method;
        this.f46622c = headers;
        this.f46623d = body;
        this.f46624e = executionContext;
        this.f46625f = attributes;
        Map map = (Map) attributes.f(HttpClientEngineCapabilityKt.a());
        this.f46626g = (map == null || (b8 = map.keySet()) == null) ? SetsKt__SetsKt.b() : b8;
    }

    public final Attributes a() {
        return this.f46625f;
    }

    public final OutgoingContent b() {
        return this.f46623d;
    }

    public final <T> T c(HttpClientEngineCapability<T> key) {
        Intrinsics.f(key, "key");
        Map map = (Map) this.f46625f.f(HttpClientEngineCapabilityKt.a());
        if (map != null) {
            return (T) map.get(key);
        }
        return null;
    }

    public final Job d() {
        return this.f46624e;
    }

    public final Headers e() {
        return this.f46622c;
    }

    public final HttpMethod f() {
        return this.f46621b;
    }

    public final Set<HttpClientEngineCapability<?>> g() {
        return this.f46626g;
    }

    public final Url h() {
        return this.f46620a;
    }

    public String toString() {
        return "HttpRequestData(url=" + this.f46620a + ", method=" + this.f46621b + ')';
    }
}
