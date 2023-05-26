package com.hivemq.client.internal.util;

/* loaded from: classes3.dex */
public final class ByteArrayUtil {
    private ByteArrayUtil() {
    }

    public static boolean a(byte[] bArr, int i8, int i9, byte[] bArr2, int i10, int i11) {
        if (i9 - i8 != i11 - i10) {
            return false;
        }
        if (bArr == bArr2 && i8 == i10) {
            return true;
        }
        while (i8 < i9) {
            if (bArr[i8] != bArr2[i10]) {
                return false;
            }
            i8++;
            i10++;
        }
        return true;
    }

    public static int b(byte[] bArr, int i8, int i9) {
        int i10 = 1;
        while (i8 < i9) {
            i10 = (i10 * 31) + bArr[i8];
            i8++;
        }
        return i10;
    }

    public static int c(byte[] bArr, int i8, byte b8) {
        while (i8 < bArr.length) {
            if (bArr[i8] == b8) {
                return i8;
            }
            i8++;
        }
        return bArr.length;
    }
}
