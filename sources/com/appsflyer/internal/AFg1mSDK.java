package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFg1mSDK {
    public static int AFInAppEventParameterName;
    public static final Object AFKeystoreWrapper = new Object();
    public static int valueOf;
    public static int values;

    public static void AFInAppEventParameterName(int[] iArr) {
        for (int i8 = 0; i8 < iArr.length / 2; i8++) {
            int i9 = iArr[i8];
            iArr[i8] = iArr[(iArr.length - i8) - 1];
            iArr[(iArr.length - i8) - 1] = i9;
        }
    }

    public static int AFInAppEventType(int i8) {
        int[][] iArr = AFf1cSDK.AFInAppEventType.AFInAppEventParameterName;
        return ((iArr[0][i8 >>> 24] + iArr[1][(i8 >>> 16) & 255]) ^ iArr[2][(i8 >>> 8) & 255]) + iArr[3][i8 & 255];
    }
}
