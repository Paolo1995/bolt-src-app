package io.ktor.http;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: HttpHeaderValueParser.kt */
/* loaded from: classes5.dex */
public final class HttpHeaderValueParserKt {
    private static final boolean a(String str, int i8) {
        int i9 = i8 + 1;
        while (i9 < str.length() && str.charAt(i9) == ' ') {
            i9++;
        }
        if (i9 == str.length() || str.charAt(i9) == ';') {
            return true;
        }
        return false;
    }

    public static final List<HeaderValue> b(String str) {
        List<HeaderValue> v02;
        v02 = CollectionsKt___CollectionsKt.v0(c(str), new Comparator() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a(Double.valueOf(((HeaderValue) t8).c()), Double.valueOf(((HeaderValue) t7).c()));
                return a8;
            }
        });
        return v02;
    }

    public static final List<HeaderValue> c(String str) {
        return d(str, false);
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0014 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<io.ktor.http.HeaderValue> d(java.lang.String r3, boolean r4) {
        /*
            if (r3 != 0) goto L7
            java.util.List r3 = kotlin.collections.CollectionsKt.k()
            return r3
        L7:
            r0 = 0
            kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.NONE
            io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1 r2 = new kotlin.jvm.functions.Function0<java.util.ArrayList<io.ktor.http.HeaderValue>>() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1
                static {
                    /*
                        io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1 r0 = new io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1) io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.f io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final java.util.ArrayList<io.ktor.http.HeaderValue> invoke() {
                    /*
                        r1 = this;
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.invoke():java.util.ArrayList");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.util.ArrayList<io.ktor.http.HeaderValue> invoke() {
                    /*
                        r1 = this;
                        java.util.ArrayList r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.invoke():java.lang.Object");
                }
            }
            kotlin.Lazy r1 = kotlin.LazyKt.a(r1, r2)
        L10:
            int r2 = kotlin.text.StringsKt.V(r3)
            if (r0 > r2) goto L1b
            int r0 = e(r3, r0, r1, r4)
            goto L10
        L1b:
            java.util.List r3 = k(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.d(java.lang.String, boolean):java.util.List");
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x0015 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int e(java.lang.String r5, int r6, kotlin.Lazy<? extends java.util.ArrayList<io.ktor.http.HeaderValue>> r7, boolean r8) {
        /*
            kotlin.LazyThreadSafetyMode r0 = kotlin.LazyThreadSafetyMode.NONE
            io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1 r1 = new kotlin.jvm.functions.Function0<java.util.ArrayList<io.ktor.http.HeaderValueParam>>() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1
                static {
                    /*
                        io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1 r0 = new io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1) io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.f io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final java.util.ArrayList<io.ktor.http.HeaderValueParam> invoke() {
                    /*
                        r1 = this;
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.invoke():java.util.ArrayList");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.util.ArrayList<io.ktor.http.HeaderValueParam> invoke() {
                    /*
                        r1 = this;
                        java.util.ArrayList r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.invoke():java.lang.Object");
                }
            }
            kotlin.Lazy r0 = kotlin.LazyKt.a(r0, r1)
            if (r8 == 0) goto Lf
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            goto L10
        Lf:
            r1 = 0
        L10:
            r2 = r6
        L11:
            int r3 = kotlin.text.StringsKt.V(r5)
            if (r2 > r3) goto L5b
            char r3 = r5.charAt(r2)
            r4 = 44
            if (r3 != r4) goto L40
            java.lang.Object r7 = r7.getValue()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            io.ktor.http.HeaderValue r8 = new io.ktor.http.HeaderValue
            if (r1 == 0) goto L2e
            int r1 = r1.intValue()
            goto L2f
        L2e:
            r1 = r2
        L2f:
            java.lang.String r5 = j(r5, r6, r1)
            java.util.List r6 = k(r0)
            r8.<init>(r5, r6)
            r7.add(r8)
            int r2 = r2 + 1
            return r2
        L40:
            r4 = 59
            if (r3 != r4) goto L51
            if (r1 != 0) goto L4a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
        L4a:
            int r2 = r2 + 1
            int r2 = f(r5, r2, r0)
            goto L11
        L51:
            if (r8 == 0) goto L58
            int r2 = f(r5, r2, r0)
            goto L11
        L58:
            int r2 = r2 + 1
            goto L11
        L5b:
            java.lang.Object r7 = r7.getValue()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            io.ktor.http.HeaderValue r8 = new io.ktor.http.HeaderValue
            if (r1 == 0) goto L6a
            int r1 = r1.intValue()
            goto L6b
        L6a:
            r1 = r2
        L6b:
            java.lang.String r5 = j(r5, r6, r1)
            java.util.List r6 = k(r0)
            r8.<init>(r5, r6)
            r7.add(r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.e(java.lang.String, int, kotlin.Lazy, boolean):int");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int f(java.lang.String r5, int r6, kotlin.Lazy<? extends java.util.ArrayList<io.ktor.http.HeaderValueParam>> r7) {
        /*
            r0 = r6
        L1:
            int r1 = kotlin.text.StringsKt.V(r5)
            java.lang.String r2 = ""
            if (r0 > r1) goto L40
            char r1 = r5.charAt(r0)
            r3 = 61
            if (r1 != r3) goto L2b
            int r1 = r0 + 1
            kotlin.Pair r1 = h(r5, r1)
            java.lang.Object r2 = r1.a()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.b()
            java.lang.String r1 = (java.lang.String) r1
            g(r7, r5, r6, r0, r1)
            return r2
        L2b:
            r3 = 59
            r4 = 1
            if (r1 != r3) goto L31
            goto L37
        L31:
            r3 = 44
            if (r1 != r3) goto L36
            goto L37
        L36:
            r4 = 0
        L37:
            if (r4 == 0) goto L3d
            g(r7, r5, r6, r0, r2)
            return r0
        L3d:
            int r0 = r0 + 1
            goto L1
        L40:
            g(r7, r5, r6, r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.f(java.lang.String, int, kotlin.Lazy):int");
    }

    private static final void g(Lazy<? extends ArrayList<HeaderValueParam>> lazy, String str, int i8, int i9, String str2) {
        boolean z7;
        String j8 = j(str, i8, i9);
        if (j8.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        lazy.getValue().add(new HeaderValueParam(j8, str2));
    }

    /* JADX WARN: Incorrect condition in loop: B:12:0x0025 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlin.Pair<java.lang.Integer, java.lang.String> h(java.lang.String r4, int r5) {
        /*
            int r0 = r4.length()
            if (r0 != r5) goto L11
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = ""
            kotlin.Pair r4 = kotlin.TuplesKt.a(r4, r5)
            return r4
        L11:
            char r0 = r4.charAt(r5)
            r1 = 34
            r2 = 1
            if (r0 != r1) goto L20
            int r5 = r5 + r2
            kotlin.Pair r4 = i(r4, r5)
            return r4
        L20:
            r0 = r5
        L21:
            int r1 = kotlin.text.StringsKt.V(r4)
            if (r0 > r1) goto L49
            char r1 = r4.charAt(r0)
            r3 = 59
            if (r1 != r3) goto L31
        L2f:
            r1 = 1
            goto L37
        L31:
            r3 = 44
            if (r1 != r3) goto L36
            goto L2f
        L36:
            r1 = 0
        L37:
            if (r1 == 0) goto L46
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = j(r4, r5, r0)
            kotlin.Pair r4 = kotlin.TuplesKt.a(r1, r4)
            return r4
        L46:
            int r0 = r0 + 1
            goto L21
        L49:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = j(r4, r5, r0)
            kotlin.Pair r4 = kotlin.TuplesKt.a(r1, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.h(java.lang.String, int):kotlin.Pair");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlin.Pair<java.lang.Integer, java.lang.String> i(java.lang.String r4, int r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L5:
            int r1 = kotlin.text.StringsKt.V(r4)
            java.lang.String r2 = "builder.toString()"
            r3 = 34
            if (r5 > r1) goto L4b
            char r1 = r4.charAt(r5)
            if (r1 != r3) goto L2d
            boolean r3 = a(r4, r5)
            if (r3 == 0) goto L2d
            int r5 = r5 + 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = r0.toString()
            kotlin.jvm.internal.Intrinsics.e(r5, r2)
            kotlin.Pair r4 = kotlin.TuplesKt.a(r4, r5)
            return r4
        L2d:
            r2 = 92
            if (r1 != r2) goto L45
            int r2 = kotlin.text.StringsKt.V(r4)
            int r2 = r2 + (-2)
            if (r5 >= r2) goto L45
            int r1 = r5 + 1
            char r1 = r4.charAt(r1)
            r0.append(r1)
            int r5 = r5 + 2
            goto L5
        L45:
            r0.append(r1)
            int r5 = r5 + 1
            goto L5
        L4b:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = r0.toString()
            kotlin.jvm.internal.Intrinsics.e(r5, r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            kotlin.Pair r4 = kotlin.TuplesKt.a(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.i(java.lang.String, int):kotlin.Pair");
    }

    private static final String j(String str, int i8, int i9) {
        CharSequence Y0;
        String substring = str.substring(i8, i9);
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Y0 = StringsKt__StringsKt.Y0(substring);
        return Y0.toString();
    }

    private static final <T> List<T> k(Lazy<? extends List<? extends T>> lazy) {
        List<T> k8;
        if (lazy.isInitialized()) {
            return (List) ((List<? extends T>) lazy.getValue());
        }
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }
}
