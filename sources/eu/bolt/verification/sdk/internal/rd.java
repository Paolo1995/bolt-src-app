package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.td;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class rd {

    /* renamed from: a  reason: collision with root package name */
    private final a0 f44809a;

    @Inject
    public rd(a0 authenticator) {
        Intrinsics.f(authenticator, "authenticator");
        this.f44809a = authenticator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
        r3 = kotlin.collections.MapsKt__MapsKt.u(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Map<java.lang.String, java.lang.String> b(java.util.Map<java.lang.String, java.lang.String> r3, java.lang.Boolean r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L8
            java.util.Map r3 = kotlin.collections.MapsKt.u(r3)
            if (r3 != 0) goto Ld
        L8:
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
        Ld:
            eu.bolt.verification.sdk.internal.a0 r0 = r2.f44809a
            java.lang.String r0 = r0.a()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r4, r1)
            if (r4 == 0) goto L22
            if (r0 == 0) goto L22
            java.lang.String r4 = "Authorization"
            r3.put(r4, r0)
        L22:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.rd.b(java.util.Map, java.lang.Boolean):java.util.Map");
    }

    public final td.a a(String url, String title, Map<String, String> map, Boolean bool) {
        Intrinsics.f(url, "url");
        Intrinsics.f(title, "title");
        return new td.a(url, title, b(map, bool));
    }
}
