package io.ktor.http;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpProtocolVersion.kt */
/* loaded from: classes5.dex */
public final class HttpProtocolVersion {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f46844d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final HttpProtocolVersion f46845e = new HttpProtocolVersion("HTTP", 2, 0);

    /* renamed from: f  reason: collision with root package name */
    private static final HttpProtocolVersion f46846f = new HttpProtocolVersion("HTTP", 1, 1);

    /* renamed from: g  reason: collision with root package name */
    private static final HttpProtocolVersion f46847g = new HttpProtocolVersion("HTTP", 1, 0);

    /* renamed from: h  reason: collision with root package name */
    private static final HttpProtocolVersion f46848h = new HttpProtocolVersion("SPDY", 3, 0);

    /* renamed from: i  reason: collision with root package name */
    private static final HttpProtocolVersion f46849i = new HttpProtocolVersion("QUIC", 1, 0);

    /* renamed from: a  reason: collision with root package name */
    private final String f46850a;

    /* renamed from: b  reason: collision with root package name */
    private final int f46851b;

    /* renamed from: c  reason: collision with root package name */
    private final int f46852c;

    /* compiled from: HttpProtocolVersion.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpProtocolVersion a() {
            return HttpProtocolVersion.f46847g;
        }

        public final HttpProtocolVersion b() {
            return HttpProtocolVersion.f46846f;
        }

        public final HttpProtocolVersion c() {
            return HttpProtocolVersion.f46845e;
        }

        public final HttpProtocolVersion d() {
            return HttpProtocolVersion.f46849i;
        }

        public final HttpProtocolVersion e() {
            return HttpProtocolVersion.f46848h;
        }
    }

    public HttpProtocolVersion(String name, int i8, int i9) {
        Intrinsics.f(name, "name");
        this.f46850a = name;
        this.f46851b = i8;
        this.f46852c = i9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HttpProtocolVersion) {
            HttpProtocolVersion httpProtocolVersion = (HttpProtocolVersion) obj;
            return Intrinsics.a(this.f46850a, httpProtocolVersion.f46850a) && this.f46851b == httpProtocolVersion.f46851b && this.f46852c == httpProtocolVersion.f46852c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f46850a.hashCode() * 31) + this.f46851b) * 31) + this.f46852c;
    }

    public String toString() {
        return this.f46850a + '/' + this.f46851b + '.' + this.f46852c;
    }
}
