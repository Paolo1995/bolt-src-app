package io.ktor.http;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: URLParser.kt */
/* loaded from: classes5.dex */
public final class URLParserKt {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f46903a;

    static {
        List<String> e8;
        e8 = CollectionsKt__CollectionsJVMKt.e("");
        f46903a = e8;
    }

    private static final int a(String str, int i8, int i9, char c8) {
        int i10 = 0;
        while (true) {
            int i11 = i8 + i10;
            if (i11 >= i9 || str.charAt(i11) != c8) {
                break;
            }
            i10++;
        }
        return i10;
    }

    private static final void b(URLBuilder uRLBuilder, String str, int i8, int i9) {
        boolean z7;
        int i10;
        Integer valueOf = Integer.valueOf(e(str, i8, i9));
        if (valueOf.intValue() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            valueOf = null;
        }
        if (valueOf != null) {
            i10 = valueOf.intValue();
        } else {
            i10 = i9;
        }
        String substring = str.substring(i8, i10);
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.w(substring);
        int i11 = i10 + 1;
        if (i11 < i9) {
            String substring2 = str.substring(i11, i9);
            Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.x(Integer.parseInt(substring2));
            return;
        }
        uRLBuilder.x(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int c(java.lang.String r12, int r13, int r14) {
        /*
            char r0 = r12.charAt(r13)
            r1 = 123(0x7b, float:1.72E-43)
            r2 = 97
            r3 = 1
            r4 = 0
            if (r2 > r0) goto L10
            if (r0 >= r1) goto L10
            r5 = 1
            goto L11
        L10:
            r5 = 0
        L11:
            r6 = 91
            r7 = 65
            r8 = -1
            if (r5 != 0) goto L24
            if (r7 > r0) goto L1e
            if (r0 >= r6) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 != 0) goto L24
            r0 = r13
            r5 = r0
            goto L26
        L24:
            r0 = r13
            r5 = -1
        L26:
            if (r0 >= r14) goto L87
            char r9 = r12.charAt(r0)
            r10 = 58
            if (r9 != r10) goto L4b
            if (r5 != r8) goto L34
            int r0 = r0 - r13
            return r0
        L34:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Illegal character in scheme at position "
            r13.append(r14)
            r13.append(r5)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L4b:
            r11 = 47
            if (r9 == r11) goto L87
            r11 = 63
            if (r9 == r11) goto L87
            r11 = 35
            if (r9 != r11) goto L58
            goto L87
        L58:
            if (r5 != r8) goto L84
            if (r2 > r9) goto L60
            if (r9 >= r1) goto L60
            r11 = 1
            goto L61
        L60:
            r11 = 0
        L61:
            if (r11 != 0) goto L84
            if (r7 > r9) goto L69
            if (r9 >= r6) goto L69
            r11 = 1
            goto L6a
        L69:
            r11 = 0
        L6a:
            if (r11 != 0) goto L84
            r11 = 48
            if (r11 > r9) goto L74
            if (r9 >= r10) goto L74
            r10 = 1
            goto L75
        L74:
            r10 = 0
        L75:
            if (r10 != 0) goto L84
            r10 = 46
            if (r9 == r10) goto L84
            r10 = 43
            if (r9 == r10) goto L84
            r10 = 45
            if (r9 == r10) goto L84
            r5 = r0
        L84:
            int r0 = r0 + 1
            goto L26
        L87:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLParserKt.c(java.lang.String, int, int):int");
    }

    public static final List<String> d() {
        return f46903a;
    }

    private static final int e(String str, int i8, int i9) {
        boolean z7 = false;
        while (i8 < i9) {
            char charAt = str.charAt(i8);
            if (charAt == '[') {
                z7 = true;
            } else if (charAt == ']') {
                z7 = false;
            } else if (charAt == ':' && !z7) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    private static final void f(URLBuilder uRLBuilder, String str, int i8, int i9, int i10) {
        int a02;
        if (i10 != 2) {
            if (i10 == 3) {
                uRLBuilder.w("");
                StringBuilder sb = new StringBuilder();
                sb.append('/');
                String substring = str.substring(i8, i9);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(substring);
                URLBuilderKt.l(uRLBuilder, sb.toString());
                return;
            }
            throw new IllegalArgumentException("Invalid file url: " + str);
        }
        a02 = StringsKt__StringsKt.a0(str, '/', i8, false, 4, null);
        if (a02 != -1 && a02 != i9) {
            String substring2 = str.substring(i8, a02);
            Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.w(substring2);
            String substring3 = str.substring(a02, i9);
            Intrinsics.e(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            URLBuilderKt.l(uRLBuilder, substring3);
            return;
        }
        String substring4 = str.substring(i8, i9);
        Intrinsics.e(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.w(substring4);
    }

    private static final void g(URLBuilder uRLBuilder, String str, int i8, int i9) {
        if (i8 < i9 && str.charAt(i8) == '#') {
            String substring = str.substring(i8 + 1, i9);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.r(substring);
        }
    }

    private static final void h(URLBuilder uRLBuilder, String str, int i8, int i9) {
        int b02;
        b02 = StringsKt__StringsKt.b0(str, "@", i8, false, 4, null);
        if (b02 != -1) {
            String substring = str.substring(i8, b02);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.A(CodecsKt.i(substring, 0, 0, null, 7, null));
            String substring2 = str.substring(b02 + 1, i9);
            Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.w(substring2);
            return;
        }
        throw new IllegalArgumentException("Invalid mailto url: " + str + ", it should contain '@'.");
    }

    private static final int i(final URLBuilder uRLBuilder, String str, int i8, int i9) {
        int a02;
        boolean z7 = true;
        int i10 = i8 + 1;
        if (i10 == i9) {
            uRLBuilder.z(true);
            return i9;
        }
        a02 = StringsKt__StringsKt.a0(str, '#', i10, false, 4, null);
        Integer valueOf = Integer.valueOf(a02);
        if (valueOf.intValue() <= 0) {
            z7 = false;
        }
        if (!z7) {
            valueOf = null;
        }
        if (valueOf != null) {
            i9 = valueOf.intValue();
        }
        String substring = str.substring(i10, i9);
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        QueryKt.d(substring, 0, 0, false, 6, null).d(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.http.URLParserKt$parseQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(String key, List<String> values) {
                Intrinsics.f(key, "key");
                Intrinsics.f(values, "values");
                URLBuilder.this.e().e(key, values);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(String str2, List<? extends String> list) {
                b(str2, list);
                return Unit.f50853a;
            }
        });
        return i9;
    }

    public static final URLBuilder j(URLBuilder uRLBuilder, String urlString) {
        boolean y7;
        Intrinsics.f(uRLBuilder, "<this>");
        Intrinsics.f(urlString, "urlString");
        y7 = StringsKt__StringsJVMKt.y(urlString);
        if (y7) {
            return uRLBuilder;
        }
        try {
            return k(uRLBuilder, urlString);
        } catch (Throwable th) {
            throw new URLParserException(urlString, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final io.ktor.http.URLBuilder k(io.ktor.http.URLBuilder r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLParserKt.k(io.ktor.http.URLBuilder, java.lang.String):io.ktor.http.URLBuilder");
    }
}
