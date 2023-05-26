package com.sinch.android.rtc.internal.client;

import android.os.Build;

/* loaded from: classes3.dex */
public class DeviceInformation {
    public static final String os;
    public static final String osApiVersion;
    public static final String osName = "Android";
    public static final String osVersion;
    public static final String sdkVersion = "5.10.7";
    public final String deviceId;
    public static final String modelName = orUnknown(getModelName());
    public static final String modelId = orUnknown(Build.DEVICE);

    static {
        String str = Build.VERSION.RELEASE;
        osVersion = str;
        os = "Android " + str;
        osApiVersion = new Integer(Build.VERSION.SDK_INT).toString();
    }

    public DeviceInformation(String str) {
        this.deviceId = str;
    }

    private static String getModelName() {
        return (Build.MANUFACTURER + " " + Build.MODEL).trim();
    }

    private static String orUnknown(String str) {
        return (str == null || str.isEmpty()) ? "unknown" : str;
    }
}
