package io.ktor.client.plugins.cache;

import io.ktor.http.HeaderValue;

/* compiled from: HttpCache.kt */
/* loaded from: classes5.dex */
public final class CacheControl {

    /* renamed from: a  reason: collision with root package name */
    public static final CacheControl f46413a = new CacheControl();

    /* renamed from: b  reason: collision with root package name */
    private static final HeaderValue f46414b = new HeaderValue("no-store", null, 2, null);

    /* renamed from: c  reason: collision with root package name */
    private static final HeaderValue f46415c = new HeaderValue("no-cache", null, 2, null);

    /* renamed from: d  reason: collision with root package name */
    private static final HeaderValue f46416d = new HeaderValue("private", null, 2, null);

    /* renamed from: e  reason: collision with root package name */
    private static final HeaderValue f46417e = new HeaderValue("only-if-cached", null, 2, null);

    /* renamed from: f  reason: collision with root package name */
    private static final HeaderValue f46418f = new HeaderValue("must-revalidate", null, 2, null);

    private CacheControl() {
    }

    public final HeaderValue a() {
        return f46418f;
    }

    public final HeaderValue b() {
        return f46415c;
    }

    public final HeaderValue c() {
        return f46414b;
    }

    public final HeaderValue d() {
        return f46417e;
    }

    public final HeaderValue e() {
        return f46416d;
    }
}
