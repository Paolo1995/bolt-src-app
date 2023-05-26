package io.ktor.client.request;

import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequest.kt */
/* loaded from: classes5.dex */
public final class HttpResponseData {

    /* renamed from: a  reason: collision with root package name */
    private final HttpStatusCode f46634a;

    /* renamed from: b  reason: collision with root package name */
    private final GMTDate f46635b;

    /* renamed from: c  reason: collision with root package name */
    private final Headers f46636c;

    /* renamed from: d  reason: collision with root package name */
    private final HttpProtocolVersion f46637d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f46638e;

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f46639f;

    /* renamed from: g  reason: collision with root package name */
    private final GMTDate f46640g;

    public HttpResponseData(HttpStatusCode statusCode, GMTDate requestTime, Headers headers, HttpProtocolVersion version, Object body, CoroutineContext callContext) {
        Intrinsics.f(statusCode, "statusCode");
        Intrinsics.f(requestTime, "requestTime");
        Intrinsics.f(headers, "headers");
        Intrinsics.f(version, "version");
        Intrinsics.f(body, "body");
        Intrinsics.f(callContext, "callContext");
        this.f46634a = statusCode;
        this.f46635b = requestTime;
        this.f46636c = headers;
        this.f46637d = version;
        this.f46638e = body;
        this.f46639f = callContext;
        this.f46640g = DateJvmKt.c(null, 1, null);
    }

    public final Object a() {
        return this.f46638e;
    }

    public final CoroutineContext b() {
        return this.f46639f;
    }

    public final Headers c() {
        return this.f46636c;
    }

    public final GMTDate d() {
        return this.f46635b;
    }

    public final GMTDate e() {
        return this.f46640g;
    }

    public final HttpStatusCode f() {
        return this.f46634a;
    }

    public final HttpProtocolVersion g() {
        return this.f46637d;
    }

    public String toString() {
        return "HttpResponseData=(statusCode=" + this.f46634a + ')';
    }
}
