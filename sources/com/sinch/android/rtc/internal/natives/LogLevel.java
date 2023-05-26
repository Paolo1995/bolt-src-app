package com.sinch.android.rtc.internal.natives;

/* loaded from: classes3.dex */
public class LogLevel {
    public static final int CRITICAL = 3;
    public static final int INFO = 1;
    public static final int TRACE = 0;
    public static final int WARN = 2;

    public static int nativeToAndroid(int i8) {
        if (i8 != 0) {
            if (i8 != 2) {
                return i8 != 3 ? 4 : 6;
            }
            return 5;
        }
        return 2;
    }
}
