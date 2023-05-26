package kotlin.text;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversions.kt */
/* loaded from: classes5.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void l(String input) {
        Intrinsics.f(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static Integer m(String str) {
        Intrinsics.f(str, "<this>");
        return n(str, 10);
    }

    public static final Integer n(String str, int i8) {
        boolean z7;
        int i9;
        Intrinsics.f(str, "<this>");
        CharsKt__CharJVMKt.a(i8);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char charAt = str.charAt(0);
        int i11 = -2147483647;
        int i12 = 1;
        if (Intrinsics.h(charAt, 48) < 0) {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i11 = Integer.MIN_VALUE;
                z7 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
            i12 = 0;
        }
        int i13 = -59652323;
        while (i12 < length) {
            int b8 = CharsKt__CharJVMKt.b(str.charAt(i12), i8);
            if (b8 < 0) {
                return null;
            }
            if ((i10 < i13 && (i13 != -59652323 || i10 < (i13 = i11 / i8))) || (i9 = i10 * i8) < i11 + b8) {
                return null;
            }
            i10 = i9 - b8;
            i12++;
        }
        if (z7) {
            return Integer.valueOf(i10);
        }
        return Integer.valueOf(-i10);
    }

    public static Long o(String str) {
        Intrinsics.f(str, "<this>");
        return p(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Long p(java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r0, r2)
            kotlin.text.CharsKt.a(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.Intrinsics.h(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r6 >= 0) goto L39
            if (r2 != r9) goto L2a
            return r3
        L2a:
            r6 = 45
            if (r5 != r6) goto L32
            r7 = -9223372036854775808
            r4 = 1
            goto L3a
        L32:
            r6 = 43
            if (r5 != r6) goto L38
            r4 = 1
            goto L39
        L38:
            return r3
        L39:
            r9 = 0
        L3a:
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r10 = 0
            r12 = r5
        L42:
            if (r4 >= r2) goto L73
            char r14 = r0.charAt(r4)
            int r14 = kotlin.text.CharsKt__CharJVMKt.b(r14, r1)
            if (r14 >= 0) goto L4f
            return r3
        L4f:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5f
            int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r15 != 0) goto L5e
            long r12 = (long) r1
            long r12 = r7 / r12
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5f
        L5e:
            return r3
        L5f:
            long r5 = (long) r1
            long r10 = r10 * r5
            long r5 = (long) r14
            long r16 = r7 + r5
            int r14 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r14 >= 0) goto L6a
            return r3
        L6a:
            long r10 = r10 - r5
            int r4 = r4 + 1
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L42
        L73:
            if (r9 == 0) goto L7a
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L7f
        L7a:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.p(java.lang.String, int):java.lang.Long");
    }
}