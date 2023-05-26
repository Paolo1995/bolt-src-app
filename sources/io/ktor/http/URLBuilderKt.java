package io.ktor.http;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: URLBuilder.kt */
/* loaded from: classes5.dex */
public final class URLBuilderKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final io.ktor.http.URLBuilder b(io.ktor.http.URLBuilder r4, java.util.List<java.lang.String> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "segments"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.util.List r0 = r4.g()
            int r0 = r0.size()
            r1 = 0
            r2 = 1
            if (r0 <= r2) goto L34
            java.util.List r0 = r4.g()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.h0(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L28
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            if (r0 == 0) goto L34
            boolean r0 = r5.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            int r3 = r5.size()
            if (r3 <= r2) goto L58
            java.lang.Object r3 = kotlin.collections.CollectionsKt.W(r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L49
            r3 = 1
            goto L4a
        L49:
            r3 = 0
        L4a:
            if (r3 == 0) goto L58
            java.util.List r3 = r4.g()
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 == 0) goto L58
            r1 = 1
        L58:
            if (r0 == 0) goto L6d
            if (r1 == 0) goto L6d
            java.util.List r0 = r4.g()
            java.util.List r0 = kotlin.collections.CollectionsKt.S(r0, r2)
            java.util.List r5 = kotlin.collections.CollectionsKt.R(r5, r2)
            java.util.List r5 = kotlin.collections.CollectionsKt.n0(r0, r5)
            goto L93
        L6d:
            if (r0 == 0) goto L7c
            java.util.List r0 = r4.g()
            java.util.List r0 = kotlin.collections.CollectionsKt.S(r0, r2)
            java.util.List r5 = kotlin.collections.CollectionsKt.n0(r0, r5)
            goto L93
        L7c:
            if (r1 == 0) goto L8b
            java.util.List r0 = r4.g()
            java.util.List r5 = kotlin.collections.CollectionsKt.R(r5, r2)
            java.util.List r5 = kotlin.collections.CollectionsKt.n0(r0, r5)
            goto L93
        L8b:
            java.util.List r0 = r4.g()
            java.util.List r5 = kotlin.collections.CollectionsKt.n0(r0, r5)
        L93:
            r4.u(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLBuilderKt.b(io.ktor.http.URLBuilder, java.util.List):io.ktor.http.URLBuilder");
    }

    private static final void c(Appendable appendable, String str, String str2) {
        boolean H0;
        appendable.append("://");
        appendable.append(str);
        H0 = StringsKt__StringsKt.H0(str2, '/', false, 2, null);
        if (!H0) {
            appendable.append('/');
        }
        appendable.append(str2);
    }

    private static final void d(Appendable appendable, String str, String str2) {
        appendable.append(":");
        appendable.append(str);
        appendable.append(str2);
    }

    public static final URLBuilder e(URLBuilder uRLBuilder, List<String> segments, boolean z7) {
        int v7;
        List B0;
        Intrinsics.f(uRLBuilder, "<this>");
        Intrinsics.f(segments, "segments");
        if (!z7) {
            ArrayList arrayList = new ArrayList();
            for (String str : segments) {
                B0 = StringsKt__StringsKt.B0(str, new char[]{'/'}, false, 0, 6, null);
                CollectionsKt__MutableCollectionsKt.A(arrayList, B0);
            }
            segments = arrayList;
        }
        v7 = CollectionsKt__IterablesKt.v(segments, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (String str2 : segments) {
            arrayList2.add(CodecsKt.p(str2));
        }
        b(uRLBuilder, arrayList2);
        return uRLBuilder;
    }

    public static /* synthetic */ URLBuilder f(URLBuilder uRLBuilder, List list, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return e(uRLBuilder, list, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <A extends Appendable> A g(URLBuilder uRLBuilder, A a8) {
        boolean z7;
        a8.append(uRLBuilder.o().e());
        String e8 = uRLBuilder.o().e();
        if (Intrinsics.a(e8, "file")) {
            c(a8, uRLBuilder.j(), i(uRLBuilder));
            return a8;
        } else if (Intrinsics.a(e8, "mailto")) {
            d(a8, j(uRLBuilder), uRLBuilder.j());
            return a8;
        } else {
            a8.append("://");
            a8.append(h(uRLBuilder));
            URLUtilsKt.e(a8, i(uRLBuilder), uRLBuilder.e(), uRLBuilder.p());
            if (uRLBuilder.d().length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                a8.append('#');
                a8.append(uRLBuilder.d());
            }
            return a8;
        }
    }

    public static final String h(URLBuilder uRLBuilder) {
        Intrinsics.f(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(j(uRLBuilder));
        sb.append(uRLBuilder.j());
        if (uRLBuilder.n() != 0 && uRLBuilder.n() != uRLBuilder.o().d()) {
            sb.append(":");
            sb.append(String.valueOf(uRLBuilder.n()));
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String i(URLBuilder uRLBuilder) {
        Intrinsics.f(uRLBuilder, "<this>");
        return k(uRLBuilder.g());
    }

    public static final String j(URLBuilder uRLBuilder) {
        Intrinsics.f(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        URLUtilsKt.f(sb, uRLBuilder.h(), uRLBuilder.f());
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final String k(List<String> list) {
        String f02;
        Object W;
        Object W2;
        if (list.isEmpty()) {
            return "";
        }
        boolean z7 = true;
        if (list.size() == 1) {
            W = CollectionsKt___CollectionsKt.W(list);
            if (((CharSequence) W).length() != 0) {
                z7 = false;
            }
            if (z7) {
                return "/";
            }
            W2 = CollectionsKt___CollectionsKt.W(list);
            return (String) W2;
        }
        f02 = CollectionsKt___CollectionsKt.f0(list, "/", null, null, 0, null, null, 62, null);
        return f02;
    }

    public static final void l(URLBuilder uRLBuilder, String value) {
        boolean y7;
        List B0;
        List<String> J0;
        Intrinsics.f(uRLBuilder, "<this>");
        Intrinsics.f(value, "value");
        y7 = StringsKt__StringsJVMKt.y(value);
        if (y7) {
            J0 = CollectionsKt__CollectionsKt.k();
        } else if (Intrinsics.a(value, "/")) {
            J0 = URLParserKt.d();
        } else {
            B0 = StringsKt__StringsKt.B0(value, new char[]{'/'}, false, 0, 6, null);
            J0 = CollectionsKt___CollectionsKt.J0(B0);
        }
        uRLBuilder.u(J0);
    }
}
