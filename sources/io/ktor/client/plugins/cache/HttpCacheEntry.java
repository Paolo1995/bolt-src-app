package io.ktor.client.plugins.cache;

import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCacheEntry.kt */
/* loaded from: classes5.dex */
public final class HttpCacheEntry {

    /* renamed from: a  reason: collision with root package name */
    private final GMTDate f46439a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f46440b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpResponse f46441c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f46442d;

    /* renamed from: e  reason: collision with root package name */
    private final Headers f46443e;

    public HttpCacheEntry(GMTDate expires, Map<String, String> varyKeys, HttpResponse response, byte[] body) {
        Intrinsics.f(expires, "expires");
        Intrinsics.f(varyKeys, "varyKeys");
        Intrinsics.f(response, "response");
        Intrinsics.f(body, "body");
        this.f46439a = expires;
        this.f46440b = varyKeys;
        this.f46441c = response;
        this.f46442d = body;
        Headers.Companion companion = Headers.f46777a;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.d(response.getHeaders());
        this.f46443e = headersBuilder.p();
    }

    public final byte[] a() {
        return this.f46442d;
    }

    public final GMTDate b() {
        return this.f46439a;
    }

    public final HttpResponse c() {
        return this.f46441c;
    }

    public final Headers d() {
        return this.f46443e;
    }

    public final Map<String, String> e() {
        return this.f46440b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof HttpCacheEntry)) {
            if (obj == this) {
                return true;
            }
            return Intrinsics.a(this.f46440b, ((HttpCacheEntry) obj).f46440b);
        }
        return false;
    }

    public final HttpResponse f() {
        return new SavedHttpCall(this.f46441c.Y().c(), this.f46441c.Y().e(), this.f46441c, this.f46442d).f();
    }

    public int hashCode() {
        return this.f46440b.hashCode();
    }
}
