package io.ktor.http;

import com.yalantis.ucrop.view.CropImageView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import okhttp3.internal.http.StatusLine;

/* compiled from: HttpStatusCode.kt */
/* loaded from: classes5.dex */
public final class HttpStatusCode {

    /* renamed from: d0  reason: collision with root package name */
    private static final List<HttpStatusCode> f46858d0;

    /* renamed from: e0  reason: collision with root package name */
    private static final Map<Integer, HttpStatusCode> f46860e0;

    /* renamed from: a  reason: collision with root package name */
    private final int f46882a;

    /* renamed from: b  reason: collision with root package name */
    private final String f46883b;

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f46855c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private static final HttpStatusCode f46857d = new HttpStatusCode(100, "Continue");

    /* renamed from: e  reason: collision with root package name */
    private static final HttpStatusCode f46859e = new HttpStatusCode(101, "Switching Protocols");

    /* renamed from: f  reason: collision with root package name */
    private static final HttpStatusCode f46861f = new HttpStatusCode(102, "Processing");

    /* renamed from: g  reason: collision with root package name */
    private static final HttpStatusCode f46862g = new HttpStatusCode(200, "OK");

    /* renamed from: h  reason: collision with root package name */
    private static final HttpStatusCode f46863h = new HttpStatusCode(201, "Created");

    /* renamed from: i  reason: collision with root package name */
    private static final HttpStatusCode f46864i = new HttpStatusCode(202, "Accepted");

    /* renamed from: j  reason: collision with root package name */
    private static final HttpStatusCode f46865j = new HttpStatusCode(203, "Non-Authoritative Information");

    /* renamed from: k  reason: collision with root package name */
    private static final HttpStatusCode f46866k = new HttpStatusCode(204, "No Content");

    /* renamed from: l  reason: collision with root package name */
    private static final HttpStatusCode f46867l = new HttpStatusCode(205, "Reset Content");

    /* renamed from: m  reason: collision with root package name */
    private static final HttpStatusCode f46868m = new HttpStatusCode(206, "Partial Content");

    /* renamed from: n  reason: collision with root package name */
    private static final HttpStatusCode f46869n = new HttpStatusCode(207, "Multi-Status");

    /* renamed from: o  reason: collision with root package name */
    private static final HttpStatusCode f46870o = new HttpStatusCode(300, "Multiple Choices");

    /* renamed from: p  reason: collision with root package name */
    private static final HttpStatusCode f46871p = new HttpStatusCode(301, "Moved Permanently");

    /* renamed from: q  reason: collision with root package name */
    private static final HttpStatusCode f46872q = new HttpStatusCode(302, "Found");

    /* renamed from: r  reason: collision with root package name */
    private static final HttpStatusCode f46873r = new HttpStatusCode(303, "See Other");

    /* renamed from: s  reason: collision with root package name */
    private static final HttpStatusCode f46874s = new HttpStatusCode(304, "Not Modified");

    /* renamed from: t  reason: collision with root package name */
    private static final HttpStatusCode f46875t = new HttpStatusCode(305, "Use Proxy");

    /* renamed from: u  reason: collision with root package name */
    private static final HttpStatusCode f46876u = new HttpStatusCode(306, "Switch Proxy");

    /* renamed from: v  reason: collision with root package name */
    private static final HttpStatusCode f46877v = new HttpStatusCode(StatusLine.HTTP_TEMP_REDIRECT, "Temporary Redirect");

    /* renamed from: w  reason: collision with root package name */
    private static final HttpStatusCode f46878w = new HttpStatusCode(StatusLine.HTTP_PERM_REDIRECT, "Permanent Redirect");

    /* renamed from: x  reason: collision with root package name */
    private static final HttpStatusCode f46879x = new HttpStatusCode(400, "Bad Request");

    /* renamed from: y  reason: collision with root package name */
    private static final HttpStatusCode f46880y = new HttpStatusCode(401, "Unauthorized");

    /* renamed from: z  reason: collision with root package name */
    private static final HttpStatusCode f46881z = new HttpStatusCode(402, "Payment Required");
    private static final HttpStatusCode A = new HttpStatusCode(403, "Forbidden");
    private static final HttpStatusCode B = new HttpStatusCode(404, "Not Found");
    private static final HttpStatusCode C = new HttpStatusCode(405, "Method Not Allowed");
    private static final HttpStatusCode D = new HttpStatusCode(406, "Not Acceptable");
    private static final HttpStatusCode E = new HttpStatusCode(407, "Proxy Authentication Required");
    private static final HttpStatusCode F = new HttpStatusCode(408, "Request Timeout");
    private static final HttpStatusCode G = new HttpStatusCode(409, "Conflict");
    private static final HttpStatusCode H = new HttpStatusCode(410, "Gone");
    private static final HttpStatusCode I = new HttpStatusCode(411, "Length Required");
    private static final HttpStatusCode J = new HttpStatusCode(412, "Precondition Failed");
    private static final HttpStatusCode K = new HttpStatusCode(413, "Payload Too Large");
    private static final HttpStatusCode L = new HttpStatusCode(414, "Request-URI Too Long");
    private static final HttpStatusCode M = new HttpStatusCode(415, "Unsupported Media Type");
    private static final HttpStatusCode N = new HttpStatusCode(416, "Requested Range Not Satisfiable");
    private static final HttpStatusCode O = new HttpStatusCode(417, "Expectation Failed");
    private static final HttpStatusCode P = new HttpStatusCode(422, "Unprocessable Entity");
    private static final HttpStatusCode Q = new HttpStatusCode(423, "Locked");
    private static final HttpStatusCode R = new HttpStatusCode(424, "Failed Dependency");
    private static final HttpStatusCode S = new HttpStatusCode(426, "Upgrade Required");
    private static final HttpStatusCode T = new HttpStatusCode(429, "Too Many Requests");
    private static final HttpStatusCode U = new HttpStatusCode(431, "Request Header Fields Too Large");
    private static final HttpStatusCode V = new HttpStatusCode(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, "Internal Server Error");
    private static final HttpStatusCode W = new HttpStatusCode(501, "Not Implemented");
    private static final HttpStatusCode X = new HttpStatusCode(502, "Bad Gateway");
    private static final HttpStatusCode Y = new HttpStatusCode(503, "Service Unavailable");
    private static final HttpStatusCode Z = new HttpStatusCode(504, "Gateway Timeout");

    /* renamed from: a0  reason: collision with root package name */
    private static final HttpStatusCode f46853a0 = new HttpStatusCode(505, "HTTP Version Not Supported");

    /* renamed from: b0  reason: collision with root package name */
    private static final HttpStatusCode f46854b0 = new HttpStatusCode(506, "Variant Also Negotiates");

    /* renamed from: c0  reason: collision with root package name */
    private static final HttpStatusCode f46856c0 = new HttpStatusCode(507, "Insufficient Storage");

    /* compiled from: HttpStatusCode.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpStatusCode A() {
            return HttpStatusCode.f46862g;
        }

        public final HttpStatusCode B() {
            return HttpStatusCode.f46868m;
        }

        public final HttpStatusCode C() {
            return HttpStatusCode.K;
        }

        public final HttpStatusCode D() {
            return HttpStatusCode.f46881z;
        }

        public final HttpStatusCode E() {
            return HttpStatusCode.f46878w;
        }

        public final HttpStatusCode F() {
            return HttpStatusCode.J;
        }

        public final HttpStatusCode G() {
            return HttpStatusCode.f46861f;
        }

        public final HttpStatusCode H() {
            return HttpStatusCode.E;
        }

        public final HttpStatusCode I() {
            return HttpStatusCode.U;
        }

        public final HttpStatusCode J() {
            return HttpStatusCode.F;
        }

        public final HttpStatusCode K() {
            return HttpStatusCode.L;
        }

        public final HttpStatusCode L() {
            return HttpStatusCode.N;
        }

        public final HttpStatusCode M() {
            return HttpStatusCode.f46867l;
        }

        public final HttpStatusCode N() {
            return HttpStatusCode.f46873r;
        }

        public final HttpStatusCode O() {
            return HttpStatusCode.Y;
        }

        public final HttpStatusCode P() {
            return HttpStatusCode.f46876u;
        }

        public final HttpStatusCode Q() {
            return HttpStatusCode.f46859e;
        }

        public final HttpStatusCode R() {
            return HttpStatusCode.f46877v;
        }

        public final HttpStatusCode S() {
            return HttpStatusCode.T;
        }

        public final HttpStatusCode T() {
            return HttpStatusCode.f46880y;
        }

        public final HttpStatusCode U() {
            return HttpStatusCode.P;
        }

        public final HttpStatusCode V() {
            return HttpStatusCode.M;
        }

        public final HttpStatusCode W() {
            return HttpStatusCode.S;
        }

        public final HttpStatusCode X() {
            return HttpStatusCode.f46875t;
        }

        public final HttpStatusCode Y() {
            return HttpStatusCode.f46854b0;
        }

        public final HttpStatusCode Z() {
            return HttpStatusCode.f46853a0;
        }

        public final HttpStatusCode a() {
            return HttpStatusCode.f46864i;
        }

        public final HttpStatusCode b() {
            return HttpStatusCode.X;
        }

        public final HttpStatusCode c() {
            return HttpStatusCode.f46879x;
        }

        public final HttpStatusCode d() {
            return HttpStatusCode.G;
        }

        public final HttpStatusCode e() {
            return HttpStatusCode.f46857d;
        }

        public final HttpStatusCode f() {
            return HttpStatusCode.f46863h;
        }

        public final HttpStatusCode g() {
            return HttpStatusCode.O;
        }

        public final HttpStatusCode h() {
            return HttpStatusCode.R;
        }

        public final HttpStatusCode i() {
            return HttpStatusCode.A;
        }

        public final HttpStatusCode j() {
            return HttpStatusCode.f46872q;
        }

        public final HttpStatusCode k() {
            return HttpStatusCode.Z;
        }

        public final HttpStatusCode l() {
            return HttpStatusCode.H;
        }

        public final HttpStatusCode m() {
            return HttpStatusCode.f46856c0;
        }

        public final HttpStatusCode n() {
            return HttpStatusCode.V;
        }

        public final HttpStatusCode o() {
            return HttpStatusCode.I;
        }

        public final HttpStatusCode p() {
            return HttpStatusCode.Q;
        }

        public final HttpStatusCode q() {
            return HttpStatusCode.C;
        }

        public final HttpStatusCode r() {
            return HttpStatusCode.f46871p;
        }

        public final HttpStatusCode s() {
            return HttpStatusCode.f46869n;
        }

        public final HttpStatusCode t() {
            return HttpStatusCode.f46870o;
        }

        public final HttpStatusCode u() {
            return HttpStatusCode.f46866k;
        }

        public final HttpStatusCode v() {
            return HttpStatusCode.f46865j;
        }

        public final HttpStatusCode w() {
            return HttpStatusCode.D;
        }

        public final HttpStatusCode x() {
            return HttpStatusCode.B;
        }

        public final HttpStatusCode y() {
            return HttpStatusCode.W;
        }

        public final HttpStatusCode z() {
            return HttpStatusCode.f46874s;
        }
    }

    static {
        int v7;
        int b8;
        int d8;
        List<HttpStatusCode> a8 = HttpStatusCodeKt.a();
        f46858d0 = a8;
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        b8 = MapsKt__MapsJVMKt.b(v7);
        d8 = RangesKt___RangesKt.d(b8, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(d8);
        for (Object obj : a8) {
            linkedHashMap.put(Integer.valueOf(((HttpStatusCode) obj).f46882a), obj);
        }
        f46860e0 = linkedHashMap;
    }

    public HttpStatusCode(int i8, String description) {
        Intrinsics.f(description, "description");
        this.f46882a = i8;
        this.f46883b = description;
    }

    public final String a0() {
        return this.f46883b;
    }

    public final int b0() {
        return this.f46882a;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof HttpStatusCode) && ((HttpStatusCode) obj).f46882a == this.f46882a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f46882a;
    }

    public String toString() {
        return this.f46882a + ' ' + this.f46883b;
    }
}
