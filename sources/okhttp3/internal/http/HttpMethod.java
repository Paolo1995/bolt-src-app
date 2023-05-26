package okhttp3.internal.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMethod.kt */
/* loaded from: classes5.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String method) {
        Intrinsics.f(method, "method");
        if (!Intrinsics.a(method, "GET") && !Intrinsics.a(method, "HEAD")) {
            return true;
        }
        return false;
    }

    public static final boolean requiresRequestBody(String method) {
        Intrinsics.f(method, "method");
        if (!Intrinsics.a(method, "POST") && !Intrinsics.a(method, "PUT") && !Intrinsics.a(method, "PATCH") && !Intrinsics.a(method, "PROPPATCH") && !Intrinsics.a(method, "REPORT")) {
            return false;
        }
        return true;
    }

    public final boolean invalidatesCache(String method) {
        Intrinsics.f(method, "method");
        if (!Intrinsics.a(method, "POST") && !Intrinsics.a(method, "PATCH") && !Intrinsics.a(method, "PUT") && !Intrinsics.a(method, "DELETE") && !Intrinsics.a(method, "MOVE")) {
            return false;
        }
        return true;
    }

    public final boolean redirectsToGet(String method) {
        Intrinsics.f(method, "method");
        return !Intrinsics.a(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(String method) {
        Intrinsics.f(method, "method");
        return Intrinsics.a(method, "PROPFIND");
    }
}
