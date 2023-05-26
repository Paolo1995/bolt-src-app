package io.ktor.http;

import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpHeaders.kt */
/* loaded from: classes5.dex */
public final class HttpHeaders {
    private static final String[] V0;
    private static final List<String> W0;

    /* renamed from: a  reason: collision with root package name */
    public static final HttpHeaders f46782a = new HttpHeaders();

    /* renamed from: b  reason: collision with root package name */
    private static final String f46784b = "Accept";

    /* renamed from: c  reason: collision with root package name */
    private static final String f46786c = "Accept-Charset";

    /* renamed from: d  reason: collision with root package name */
    private static final String f46788d = "Accept-Encoding";

    /* renamed from: e  reason: collision with root package name */
    private static final String f46790e = "Accept-Language";

    /* renamed from: f  reason: collision with root package name */
    private static final String f46792f = "Accept-Ranges";

    /* renamed from: g  reason: collision with root package name */
    private static final String f46794g = "Age";

    /* renamed from: h  reason: collision with root package name */
    private static final String f46796h = "Allow";

    /* renamed from: i  reason: collision with root package name */
    private static final String f46798i = "ALPN";

    /* renamed from: j  reason: collision with root package name */
    private static final String f46800j = "Authentication-Info";

    /* renamed from: k  reason: collision with root package name */
    private static final String f46802k = "Authorization";

    /* renamed from: l  reason: collision with root package name */
    private static final String f46804l = "Cache-Control";

    /* renamed from: m  reason: collision with root package name */
    private static final String f46806m = "Connection";

    /* renamed from: n  reason: collision with root package name */
    private static final String f46808n = "Content-Disposition";

    /* renamed from: o  reason: collision with root package name */
    private static final String f46810o = "Content-Encoding";

    /* renamed from: p  reason: collision with root package name */
    private static final String f46812p = "Content-Language";

    /* renamed from: q  reason: collision with root package name */
    private static final String f46814q = "Content-Length";

    /* renamed from: r  reason: collision with root package name */
    private static final String f46816r = "Content-Location";

    /* renamed from: s  reason: collision with root package name */
    private static final String f46818s = "Content-Range";

    /* renamed from: t  reason: collision with root package name */
    private static final String f46820t = "Content-Type";

    /* renamed from: u  reason: collision with root package name */
    private static final String f46822u = "Cookie";

    /* renamed from: v  reason: collision with root package name */
    private static final String f46824v = "DASL";

    /* renamed from: w  reason: collision with root package name */
    private static final String f46826w = "Date";

    /* renamed from: x  reason: collision with root package name */
    private static final String f46828x = "DAV";

    /* renamed from: y  reason: collision with root package name */
    private static final String f46830y = "Depth";

    /* renamed from: z  reason: collision with root package name */
    private static final String f46832z = "Destination";
    private static final String A = "ETag";
    private static final String B = "Expect";
    private static final String C = "Expires";
    private static final String D = "From";
    private static final String E = "Forwarded";
    private static final String F = "Host";
    private static final String G = "HTTP2-Settings";
    private static final String H = "If";
    private static final String I = "If-Match";
    private static final String J = "If-Modified-Since";
    private static final String K = "If-None-Match";
    private static final String L = "If-Range";
    private static final String M = "If-Schedule-Tag-Match";
    private static final String N = "If-Unmodified-Since";
    private static final String O = "Last-Modified";
    private static final String P = "Location";
    private static final String Q = "Lock-Token";
    private static final String R = "Link";
    private static final String S = "Max-Forwards";
    private static final String T = "MIME-Version";
    private static final String U = "Ordering-Type";
    private static final String V = "Origin";
    private static final String W = "Overwrite";
    private static final String X = "Position";
    private static final String Y = "Pragma";
    private static final String Z = "Prefer";

    /* renamed from: a0  reason: collision with root package name */
    private static final String f46783a0 = "Preference-Applied";

    /* renamed from: b0  reason: collision with root package name */
    private static final String f46785b0 = "Proxy-Authenticate";

    /* renamed from: c0  reason: collision with root package name */
    private static final String f46787c0 = "Proxy-Authentication-Info";

    /* renamed from: d0  reason: collision with root package name */
    private static final String f46789d0 = "Proxy-Authorization";

    /* renamed from: e0  reason: collision with root package name */
    private static final String f46791e0 = "Public-Key-Pins";

    /* renamed from: f0  reason: collision with root package name */
    private static final String f46793f0 = "Public-Key-Pins-Report-Only";

    /* renamed from: g0  reason: collision with root package name */
    private static final String f46795g0 = "Range";

    /* renamed from: h0  reason: collision with root package name */
    private static final String f46797h0 = "Referer";

    /* renamed from: i0  reason: collision with root package name */
    private static final String f46799i0 = "Retry-After";

    /* renamed from: j0  reason: collision with root package name */
    private static final String f46801j0 = "Schedule-Reply";

    /* renamed from: k0  reason: collision with root package name */
    private static final String f46803k0 = "Schedule-Tag";

    /* renamed from: l0  reason: collision with root package name */
    private static final String f46805l0 = "Sec-WebSocket-Accept";

    /* renamed from: m0  reason: collision with root package name */
    private static final String f46807m0 = "Sec-WebSocket-Extensions";

    /* renamed from: n0  reason: collision with root package name */
    private static final String f46809n0 = "Sec-WebSocket-Key";

    /* renamed from: o0  reason: collision with root package name */
    private static final String f46811o0 = "Sec-WebSocket-Protocol";

    /* renamed from: p0  reason: collision with root package name */
    private static final String f46813p0 = "Sec-WebSocket-Version";

    /* renamed from: q0  reason: collision with root package name */
    private static final String f46815q0 = "Server";

    /* renamed from: r0  reason: collision with root package name */
    private static final String f46817r0 = "Set-Cookie";

    /* renamed from: s0  reason: collision with root package name */
    private static final String f46819s0 = "SLUG";

    /* renamed from: t0  reason: collision with root package name */
    private static final String f46821t0 = "Strict-Transport-Security";

    /* renamed from: u0  reason: collision with root package name */
    private static final String f46823u0 = "TE";

    /* renamed from: v0  reason: collision with root package name */
    private static final String f46825v0 = "Timeout";

    /* renamed from: w0  reason: collision with root package name */
    private static final String f46827w0 = "Trailer";

    /* renamed from: x0  reason: collision with root package name */
    private static final String f46829x0 = "Transfer-Encoding";

    /* renamed from: y0  reason: collision with root package name */
    private static final String f46831y0 = "Upgrade";

    /* renamed from: z0  reason: collision with root package name */
    private static final String f46833z0 = "User-Agent";
    private static final String A0 = "Vary";
    private static final String B0 = "Via";
    private static final String C0 = "Warning";
    private static final String D0 = "WWW-Authenticate";
    private static final String E0 = "Access-Control-Allow-Origin";
    private static final String F0 = "Access-Control-Allow-Methods";
    private static final String G0 = "Access-Control-Allow-Credentials";
    private static final String H0 = "Access-Control-Allow-Headers";
    private static final String I0 = "Access-Control-Request-Method";
    private static final String J0 = "Access-Control-Request-Headers";
    private static final String K0 = "Access-Control-Expose-Headers";
    private static final String L0 = "Access-Control-Max-Age";
    private static final String M0 = "X-Http-Method-Override";
    private static final String N0 = "X-Forwarded-Host";
    private static final String O0 = "X-Forwarded-Server";
    private static final String P0 = "X-Forwarded-Proto";
    private static final String Q0 = "X-Forwarded-For";
    private static final String R0 = "X-Forwarded-Port";
    private static final String S0 = "X-Request-ID";
    private static final String T0 = "X-Correlation-ID";
    private static final String U0 = "X-Total-Count";

    static {
        String[] strArr = {"Transfer-Encoding", "Upgrade"};
        V0 = strArr;
        W0 = ArraysKt.e(strArr);
    }

    private HttpHeaders() {
    }

    public final void a(String name) {
        Intrinsics.f(name, "name");
        int i8 = 0;
        int i9 = 0;
        while (i8 < name.length()) {
            char charAt = name.charAt(i8);
            int i10 = i9 + 1;
            if (Intrinsics.h(charAt, 32) > 0 && !HttpHeadersKt.a(charAt)) {
                i8++;
                i9 = i10;
            } else {
                throw new IllegalHeaderNameException(name, i9);
            }
        }
    }

    public final void b(String value) {
        Intrinsics.f(value, "value");
        int i8 = 0;
        int i9 = 0;
        while (i8 < value.length()) {
            char charAt = value.charAt(i8);
            int i10 = i9 + 1;
            if (charAt != ' ' && charAt != '\t' && Intrinsics.h(charAt, 32) < 0) {
                throw new IllegalHeaderValueException(value, i9);
            }
            i8++;
            i9 = i10;
        }
    }

    public final String c() {
        return f46784b;
    }

    public final String d() {
        return f46786c;
    }

    public final String e() {
        return f46802k;
    }

    public final String f() {
        return f46804l;
    }

    public final String g() {
        return f46810o;
    }

    public final String h() {
        return f46814q;
    }

    public final String i() {
        return f46820t;
    }

    public final String j() {
        return f46826w;
    }

    public final String k() {
        return A;
    }

    public final String l() {
        return C;
    }

    public final String m() {
        return J;
    }

    public final String n() {
        return K;
    }

    public final String o() {
        return N;
    }

    public final String p() {
        return O;
    }

    public final String q() {
        return P;
    }

    public final List<String> r() {
        return W0;
    }

    public final String s() {
        return f46833z0;
    }

    public final String t() {
        return A0;
    }

    public final String u() {
        return C0;
    }
}
