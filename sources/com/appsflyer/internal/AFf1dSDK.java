package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFf1dSDK {
    public static void AFInAppEventParameterName(int i8, int i9, boolean z7, int i10, int[] iArr, int[][] iArr2, int[] iArr3) {
        if (!z7) {
            AFKeystoreWrapper(iArr);
        }
        int i11 = 0;
        while (i11 < i10) {
            int i12 = i8 ^ iArr[i11];
            int valueOf = i9 ^ valueOf(i12, iArr2);
            i11++;
            i9 = i12;
            i8 = valueOf;
        }
        int i13 = i8 ^ iArr[iArr.length - 2];
        int i14 = i9 ^ iArr[iArr.length - 1];
        if (!z7) {
            AFKeystoreWrapper(iArr);
        }
        iArr3[0] = i14;
        iArr3[1] = i13;
    }

    private static void AFKeystoreWrapper(int[] iArr) {
        for (int i8 = 0; i8 < iArr.length / 2; i8++) {
            int i9 = iArr[i8];
            iArr[i8] = iArr[(iArr.length - i8) - 1];
            iArr[(iArr.length - i8) - 1] = i9;
        }
    }

    private static int valueOf(int i8, int[][] iArr) {
        return ((iArr[0][i8 >>> 24] + iArr[1][(i8 >>> 16) & 255]) ^ iArr[2][(i8 >>> 8) & 255]) + iArr[3][i8 & 255];
    }
}
