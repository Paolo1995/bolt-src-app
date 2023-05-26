package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFg1wSDK {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static long[] values(int i8, int i9) {
        long[] jArr = new long[4];
        jArr[0] = (i9 & 4294967295L) | ((i8 & 4294967295L) << 32);
        for (int i10 = 1; i10 < 4; i10++) {
            long j8 = jArr[i10 - 1];
            jArr[i10] = ((j8 ^ (j8 >> 30)) * 1812433253) + i10;
        }
        return jArr;
    }
}
