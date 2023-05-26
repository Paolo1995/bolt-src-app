package io.ktor.http;

import java.nio.charset.Charset;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMessageProperties.kt */
/* loaded from: classes5.dex */
public final class HttpMessagePropertiesKt {
    public static final List<HeaderValue> a(HttpMessage httpMessage) {
        List<HeaderValue> k8;
        List<HeaderValue> c8;
        Intrinsics.f(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.f46782a.f());
        if (str == null || (c8 = HttpHeaderValueParserKt.c(str)) == null) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        return c8;
    }

    public static final Charset b(HttpMessage httpMessage) {
        Intrinsics.f(httpMessage, "<this>");
        ContentType d8 = d(httpMessage);
        if (d8 != null) {
            return ContentTypesKt.a(d8);
        }
        return null;
    }

    public static final Long c(HttpMessage httpMessage) {
        Intrinsics.f(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.f46782a.h());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final ContentType d(HttpMessage httpMessage) {
        Intrinsics.f(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.f46782a.i());
        if (str != null) {
            return ContentType.f46727f.b(str);
        }
        return null;
    }

    public static final ContentType e(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.f(httpMessageBuilder, "<this>");
        String j8 = httpMessageBuilder.getHeaders().j(HttpHeaders.f46782a.i());
        if (j8 != null) {
            return ContentType.f46727f.b(j8);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
        r7 = kotlin.text.StringsKt__StringsKt.C0(r1, new java.lang.String[]{","}, false, 0, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<java.lang.String> f(io.ktor.http.HttpMessage r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            io.ktor.http.Headers r7 = r7.getHeaders()
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.f46782a
            java.lang.String r0 = r0.t()
            java.lang.String r1 = r7.get(r0)
            if (r1 == 0) goto L4c
            java.lang.String r7 = ","
            java.lang.String[] r2 = new java.lang.String[]{r7}
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.util.List r7 = kotlin.text.StringsKt.C0(r1, r2, r3, r4, r5, r6)
            if (r7 == 0) goto L4c
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.v(r7, r1)
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L34:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L4d
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.Y0(r1)
            java.lang.String r1 = r1.toString()
            r0.add(r1)
            goto L34
        L4c:
            r0 = 0
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpMessagePropertiesKt.f(io.ktor.http.HttpMessage):java.util.List");
    }
}
