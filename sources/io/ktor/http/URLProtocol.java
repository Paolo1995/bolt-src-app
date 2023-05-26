package io.ktor.http;

import io.ktor.util.CharsetKt;
import io.ktor.util.TextKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: URLProtocol.kt */
/* loaded from: classes5.dex */
public final class URLProtocol {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f46905c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private static final URLProtocol f46906d;

    /* renamed from: e  reason: collision with root package name */
    private static final URLProtocol f46907e;

    /* renamed from: f  reason: collision with root package name */
    private static final URLProtocol f46908f;

    /* renamed from: g  reason: collision with root package name */
    private static final URLProtocol f46909g;

    /* renamed from: h  reason: collision with root package name */
    private static final URLProtocol f46910h;

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, URLProtocol> f46911i;

    /* renamed from: a  reason: collision with root package name */
    private final String f46912a;

    /* renamed from: b  reason: collision with root package name */
    private final int f46913b;

    /* compiled from: URLProtocol.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final URLProtocol a(String name) {
            Intrinsics.f(name, "name");
            String c8 = TextKt.c(name);
            URLProtocol uRLProtocol = URLProtocol.f46905c.b().get(c8);
            if (uRLProtocol == null) {
                return new URLProtocol(c8, 0);
            }
            return uRLProtocol;
        }

        public final Map<String, URLProtocol> b() {
            return URLProtocol.f46911i;
        }

        public final URLProtocol c() {
            return URLProtocol.f46906d;
        }

        public final URLProtocol d() {
            return URLProtocol.f46907e;
        }
    }

    static {
        List n8;
        int v7;
        int b8;
        int d8;
        URLProtocol uRLProtocol = new URLProtocol("http", 80);
        f46906d = uRLProtocol;
        URLProtocol uRLProtocol2 = new URLProtocol("https", 443);
        f46907e = uRLProtocol2;
        URLProtocol uRLProtocol3 = new URLProtocol("ws", 80);
        f46908f = uRLProtocol3;
        URLProtocol uRLProtocol4 = new URLProtocol("wss", 443);
        f46909g = uRLProtocol4;
        URLProtocol uRLProtocol5 = new URLProtocol("socks", 1080);
        f46910h = uRLProtocol5;
        n8 = CollectionsKt__CollectionsKt.n(uRLProtocol, uRLProtocol2, uRLProtocol3, uRLProtocol4, uRLProtocol5);
        v7 = CollectionsKt__IterablesKt.v(n8, 10);
        b8 = MapsKt__MapsJVMKt.b(v7);
        d8 = RangesKt___RangesKt.d(b8, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(d8);
        for (Object obj : n8) {
            linkedHashMap.put(((URLProtocol) obj).f46912a, obj);
        }
        f46911i = linkedHashMap;
    }

    public URLProtocol(String name, int i8) {
        Intrinsics.f(name, "name");
        this.f46912a = name;
        this.f46913b = i8;
        boolean z7 = false;
        int i9 = 0;
        while (true) {
            if (i9 < name.length()) {
                if (!CharsetKt.a(name.charAt(i9))) {
                    break;
                }
                i9++;
            } else {
                z7 = true;
                break;
            }
        }
        if (z7) {
            return;
        }
        throw new IllegalArgumentException("All characters should be lower case".toString());
    }

    public final int d() {
        return this.f46913b;
    }

    public final String e() {
        return this.f46912a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof URLProtocol) {
            URLProtocol uRLProtocol = (URLProtocol) obj;
            return Intrinsics.a(this.f46912a, uRLProtocol.f46912a) && this.f46913b == uRLProtocol.f46913b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f46912a.hashCode() * 31) + this.f46913b;
    }

    public String toString() {
        return "URLProtocol(name=" + this.f46912a + ", defaultPort=" + this.f46913b + ')';
    }
}
