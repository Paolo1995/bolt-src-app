package com.hivemq.client.internal.util;

/* loaded from: classes3.dex */
public final class Utf8Util {
    private Utf8Util() {
    }

    public static int a(String str) {
        int length = str.length();
        int i8 = 0;
        int i9 = length;
        while (i8 < length) {
            char charAt = str.charAt(i8);
            if (charAt > 127) {
                i9++;
                if (charAt > 2047) {
                    i9++;
                    if (Character.isHighSurrogate(charAt)) {
                        i8++;
                    }
                }
            }
            i8++;
        }
        return i9;
    }

    public static long b(byte[] bArr) {
        int length = bArr.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 + 1;
            byte b8 = bArr[i8];
            if (b8 < 0) {
                if (b8 < -32) {
                    if (i9 == length) {
                        return i9 - 4611686018427387904L;
                    }
                    if (b8 < -62) {
                        return i9 - Long.MIN_VALUE;
                    }
                    i8 = i9 + 1;
                    if (bArr[i9] > -65) {
                        return i8 - 4611686018427387904L;
                    }
                } else if (b8 < -16) {
                    int i10 = i9 + 1;
                    if (i10 >= length) {
                        return i9 - 4611686018427387904L;
                    }
                    byte b9 = bArr[i9];
                    if (b9 > -65) {
                        return i10 - 4611686018427387904L;
                    }
                    if (b8 == -32 && b9 < -96) {
                        return i10 - Long.MIN_VALUE;
                    }
                    if (b8 == -19 && b9 >= -96) {
                        return i10 - 2305843009213693952L;
                    }
                    i8 = i10 + 1;
                    if (bArr[i10] > -65) {
                        return i8 - 4611686018427387904L;
                    }
                } else if (i9 + 2 >= length) {
                    return i9 - 4611686018427387904L;
                } else {
                    int i11 = i9 + 1;
                    byte b10 = bArr[i9];
                    if (b10 > -65) {
                        return i11 - 4611686018427387904L;
                    }
                    if (b8 == -16 && b10 < -112) {
                        return i11 - Long.MIN_VALUE;
                    }
                    if ((b8 == -12 && b10 > -113) || b8 > -12) {
                        return i11 - 1152921504606846976L;
                    }
                    int i12 = i11 + 1;
                    if (bArr[i11] > -65) {
                        return i12 - 4611686018427387904L;
                    }
                    i9 = i12 + 1;
                    if (bArr[i12] > -65) {
                        return i9 - 4611686018427387904L;
                    }
                }
            }
            i8 = i9;
        }
        return 0L;
    }
}
