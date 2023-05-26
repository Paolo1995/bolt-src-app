package com.mixpanel.android.util;

/* loaded from: classes3.dex */
public class Base64Coder {

    /* renamed from: a  reason: collision with root package name */
    private static char[] f19423a = new char[64];

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f19424b;

    static {
        char c8 = 'A';
        int i8 = 0;
        while (c8 <= 'Z') {
            f19423a[i8] = c8;
            c8 = (char) (c8 + 1);
            i8++;
        }
        char c9 = 'a';
        while (c9 <= 'z') {
            f19423a[i8] = c9;
            c9 = (char) (c9 + 1);
            i8++;
        }
        char c10 = '0';
        while (c10 <= '9') {
            f19423a[i8] = c10;
            c10 = (char) (c10 + 1);
            i8++;
        }
        char[] cArr = f19423a;
        cArr[i8] = '+';
        cArr[i8 + 1] = '/';
        f19424b = new byte[128];
        int i9 = 0;
        while (true) {
            byte[] bArr = f19424b;
            if (i9 >= bArr.length) {
                break;
            }
            bArr[i9] = -1;
            i9++;
        }
        for (int i10 = 0; i10 < 64; i10++) {
            f19424b[f19423a[i10]] = (byte) i10;
        }
    }

    public static char[] a(byte[] bArr) {
        return b(bArr, bArr.length);
    }

    public static char[] b(byte[] bArr, int i8) {
        int i9;
        int i10;
        int i11;
        char c8;
        int i12 = ((i8 * 4) + 2) / 3;
        char[] cArr = new char[((i8 + 2) / 3) * 4];
        int i13 = 0;
        int i14 = 0;
        while (i13 < i8) {
            int i15 = i13 + 1;
            int i16 = bArr[i13] & 255;
            if (i15 < i8) {
                i9 = i15 + 1;
                i10 = bArr[i15] & 255;
            } else {
                i9 = i15;
                i10 = 0;
            }
            if (i9 < i8) {
                i11 = bArr[i9] & 255;
                i9++;
            } else {
                i11 = 0;
            }
            int i17 = i16 >>> 2;
            int i18 = ((i16 & 3) << 4) | (i10 >>> 4);
            int i19 = ((i10 & 15) << 2) | (i11 >>> 6);
            int i20 = i11 & 63;
            int i21 = i14 + 1;
            char[] cArr2 = f19423a;
            cArr[i14] = cArr2[i17];
            int i22 = i21 + 1;
            cArr[i21] = cArr2[i18];
            char c9 = '=';
            if (i22 < i12) {
                c8 = cArr2[i19];
            } else {
                c8 = '=';
            }
            cArr[i22] = c8;
            int i23 = i22 + 1;
            if (i23 < i12) {
                c9 = cArr2[i20];
            }
            cArr[i23] = c9;
            i14 = i23 + 1;
            i13 = i9;
        }
        return cArr;
    }

    public static String c(String str) {
        return new String(a(str.getBytes()));
    }
}
