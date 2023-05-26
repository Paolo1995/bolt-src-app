package io.ktor.http;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMethod.kt */
/* loaded from: classes5.dex */
public final class HttpMethod {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f46834b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final HttpMethod f46835c;

    /* renamed from: d  reason: collision with root package name */
    private static final HttpMethod f46836d;

    /* renamed from: e  reason: collision with root package name */
    private static final HttpMethod f46837e;

    /* renamed from: f  reason: collision with root package name */
    private static final HttpMethod f46838f;

    /* renamed from: g  reason: collision with root package name */
    private static final HttpMethod f46839g;

    /* renamed from: h  reason: collision with root package name */
    private static final HttpMethod f46840h;

    /* renamed from: i  reason: collision with root package name */
    private static final HttpMethod f46841i;

    /* renamed from: j  reason: collision with root package name */
    private static final List<HttpMethod> f46842j;

    /* renamed from: a  reason: collision with root package name */
    private final String f46843a;

    /* compiled from: HttpMethod.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpMethod a() {
            return HttpMethod.f46835c;
        }

        public final HttpMethod b() {
            return HttpMethod.f46840h;
        }
    }

    static {
        List<HttpMethod> n8;
        HttpMethod httpMethod = new HttpMethod("GET");
        f46835c = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("POST");
        f46836d = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("PUT");
        f46837e = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod("PATCH");
        f46838f = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod("DELETE");
        f46839g = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("HEAD");
        f46840h = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("OPTIONS");
        f46841i = httpMethod7;
        n8 = CollectionsKt__CollectionsKt.n(httpMethod, httpMethod2, httpMethod3, httpMethod4, httpMethod5, httpMethod6, httpMethod7);
        f46842j = n8;
    }

    public HttpMethod(String value) {
        Intrinsics.f(value, "value");
        this.f46843a = value;
    }

    public final String c() {
        return this.f46843a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HttpMethod) && Intrinsics.a(this.f46843a, ((HttpMethod) obj).f46843a);
    }

    public int hashCode() {
        return this.f46843a.hashCode();
    }

    public String toString() {
        return "HttpMethod(value=" + this.f46843a + ')';
    }
}
