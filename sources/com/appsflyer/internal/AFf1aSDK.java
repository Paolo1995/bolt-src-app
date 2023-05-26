package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFf1aSDK {
    public static int AFInAppEventType;
    public static int AFKeystoreWrapper;
    public static final Object values = new Object();

    public static char[] values(long j8, char[] cArr, int i8) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        int i9 = 0;
        int i10 = 4;
        for (int i11 = 0; i11 < cArr.length; i11++) {
            if ((((j8 >>> i11) & 1) != i8 || i9 >= 4) && i10 < length) {
                cArr2[i10] = cArr[i11];
                i10++;
            } else {
                cArr2[i9] = cArr[i11];
                i9++;
            }
        }
        return cArr2;
    }
}
