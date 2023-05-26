package okhttp3.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;

/* compiled from: hostnames.kt */
/* loaded from: classes5.dex */
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int a02;
        int length = str.length();
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 + 1;
            char charAt = str.charAt(i8);
            if (Intrinsics.h(charAt, 31) <= 0 || Intrinsics.h(charAt, 127) >= 0) {
                return true;
            }
            a02 = StringsKt__StringsKt.a0(" #%/:?@[\\]", charAt, 0, false, 6, null);
            if (a02 != -1) {
                return true;
            }
            i8 = i9;
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i8, int i9, byte[] bArr, int i10) {
        int i11 = i10;
        while (i8 < i9) {
            if (i11 == bArr.length) {
                return false;
            }
            if (i11 != i10) {
                if (str.charAt(i8) != '.') {
                    return false;
                }
                i8++;
            }
            int i12 = i8;
            int i13 = 0;
            while (i12 < i9) {
                char charAt = str.charAt(i12);
                if (Intrinsics.h(charAt, 48) < 0 || Intrinsics.h(charAt, 57) > 0) {
                    break;
                } else if ((i13 == 0 && i8 != i12) || (i13 = ((i13 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i12++;
                }
            }
            if (i12 - i8 == 0) {
                return false;
            }
            bArr[i11] = (byte) i13;
            i11++;
            i8 = i12;
        }
        if (i11 != i10 + 4) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
        if (r13 == 16) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
        if (r14 != (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ad, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r18, int r19, int r20) {
        /*
            r6 = r18
            r7 = r20
            r8 = 16
            byte[] r9 = new byte[r8]
            r11 = -1
            r12 = r19
            r13 = 0
            r14 = -1
            r15 = -1
        Le:
            r16 = 0
            if (r12 >= r7) goto L97
            if (r13 != r8) goto L15
            return r16
        L15:
            int r5 = r12 + 2
            if (r5 > r7) goto L38
            r3 = 0
            r4 = 4
            r17 = 0
            java.lang.String r1 = "::"
            r0 = r18
            r2 = r12
            r10 = r5
            r5 = r17
            boolean r0 = kotlin.text.StringsKt.K(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L38
            if (r14 == r11) goto L2e
            return r16
        L2e:
            int r13 = r13 + 2
            if (r10 != r7) goto L35
            r14 = r13
            goto L97
        L35:
            r15 = r10
            r14 = r13
            goto L67
        L38:
            if (r13 == 0) goto L66
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.StringsKt.K(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L4b
            int r12 = r12 + 1
            goto L66
        L4b:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.StringsKt.K(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L65
            int r0 = r13 + (-2)
            boolean r0 = decodeIpv4Suffix(r6, r15, r7, r9, r0)
            if (r0 != 0) goto L62
            return r16
        L62:
            int r13 = r13 + 2
            goto L97
        L65:
            return r16
        L66:
            r15 = r12
        L67:
            r12 = r15
            r0 = 0
        L69:
            if (r12 >= r7) goto L7c
            char r1 = r6.charAt(r12)
            int r1 = okhttp3.internal.Util.parseHexDigit(r1)
            if (r1 != r11) goto L76
            goto L7c
        L76:
            int r0 = r0 << 4
            int r0 = r0 + r1
            int r12 = r12 + 1
            goto L69
        L7c:
            int r1 = r12 - r15
            if (r1 == 0) goto L96
            r2 = 4
            if (r1 <= r2) goto L84
            goto L96
        L84:
            int r1 = r13 + 1
            int r2 = r0 >>> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r9[r13] = r2
            int r13 = r1 + 1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r9[r1] = r0
            goto Le
        L96:
            return r16
        L97:
            if (r13 == r8) goto La9
            if (r14 != r11) goto L9c
            return r16
        L9c:
            int r0 = r13 - r14
            int r1 = 16 - r0
            java.lang.System.arraycopy(r9, r14, r9, r1, r0)
            int r8 = r8 - r13
            int r8 = r8 + r14
            r0 = 0
            java.util.Arrays.fill(r9, r14, r8, r0)
        La9:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i8 = 0;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        while (i10 < bArr.length) {
            int i12 = i10;
            while (i12 < 16 && bArr[i12] == 0 && bArr[i12 + 1] == 0) {
                i12 += 2;
            }
            int i13 = i12 - i10;
            if (i13 > i11 && i13 >= 4) {
                i9 = i10;
                i11 = i13;
            }
            i10 = i12 + 2;
        }
        Buffer buffer = new Buffer();
        while (i8 < bArr.length) {
            if (i8 == i9) {
                buffer.writeByte(58);
                i8 += i11;
                if (i8 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i8 > 0) {
                    buffer.writeByte(58);
                }
                buffer.M0((Util.and(bArr[i8], 255) << 8) | Util.and(bArr[i8 + 1], 255));
                i8 += 2;
            }
        }
        return buffer.k0();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String toCanonicalHost(java.lang.String r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = ":"
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r0 = kotlin.text.StringsKt.Q(r5, r0, r1, r2, r3)
            r4 = 1
            if (r0 == 0) goto L6e
            java.lang.String r0 = "["
            boolean r0 = kotlin.text.StringsKt.L(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L2b
            java.lang.String r0 = "]"
            boolean r0 = kotlin.text.StringsKt.v(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L2b
            int r0 = r5.length()
            int r0 = r0 - r4
            java.net.InetAddress r0 = decodeIpv6(r5, r4, r0)
            goto L33
        L2b:
            int r0 = r5.length()
            java.net.InetAddress r0 = decodeIpv6(r5, r1, r0)
        L33:
            if (r0 != 0) goto L36
            return r3
        L36:
            byte[] r1 = r0.getAddress()
            int r2 = r1.length
            r3 = 16
            if (r2 != r3) goto L49
            java.lang.String r5 = "address"
            kotlin.jvm.internal.Intrinsics.e(r1, r5)
            java.lang.String r5 = inet6AddressToAscii(r1)
            return r5
        L49:
            int r1 = r1.length
            r2 = 4
            if (r1 != r2) goto L52
            java.lang.String r5 = r0.getHostAddress()
            return r5
        L52:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid IPv6 address: '"
            r1.append(r2)
            r1.append(r5)
            r5 = 39
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L6e:
            java.lang.String r5 = java.net.IDN.toASCII(r5)     // Catch: java.lang.IllegalArgumentException -> L99
            java.lang.String r0 = "toASCII(host)"
            kotlin.jvm.internal.Intrinsics.e(r5, r0)     // Catch: java.lang.IllegalArgumentException -> L99
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.IllegalArgumentException -> L99
            java.lang.String r2 = "US"
            kotlin.jvm.internal.Intrinsics.e(r0, r2)     // Catch: java.lang.IllegalArgumentException -> L99
            java.lang.String r5 = r5.toLowerCase(r0)     // Catch: java.lang.IllegalArgumentException -> L99
            java.lang.String r0 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.e(r5, r0)     // Catch: java.lang.IllegalArgumentException -> L99
            int r0 = r5.length()     // Catch: java.lang.IllegalArgumentException -> L99
            if (r0 != 0) goto L8e
            r1 = 1
        L8e:
            if (r1 == 0) goto L91
            return r3
        L91:
            boolean r0 = containsInvalidHostnameAsciiCodes(r5)     // Catch: java.lang.IllegalArgumentException -> L99
            if (r0 == 0) goto L98
            goto L99
        L98:
            r3 = r5
        L99:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.toCanonicalHost(java.lang.String):java.lang.String");
    }
}
