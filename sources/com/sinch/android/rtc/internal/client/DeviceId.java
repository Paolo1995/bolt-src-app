package com.sinch.android.rtc.internal.client;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* loaded from: classes3.dex */
public class DeviceId {
    private static final String DEVICE_ID = "DeviceId";
    private static final String PREF_NAME = "com.sinch.rtc";
    private static DeviceId mDeviceId;
    private final String mId;

    public DeviceId(Context context) {
        this.mId = getOrGenerateId(context);
    }

    public static synchronized String getDeviceId(Context context) {
        String deviceId;
        synchronized (DeviceId.class) {
            if (mDeviceId == null) {
                mDeviceId = new DeviceId(context);
            }
            deviceId = mDeviceId.getDeviceId();
        }
        return deviceId;
    }

    private String getOrGenerateId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        String string = sharedPreferences != null ? sharedPreferences.getString(DEVICE_ID, null) : null;
        if (string == null) {
            string = UUID.randomUUID().toString();
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(DEVICE_ID, string);
                edit.apply();
            }
        }
        return string;
    }

    public String getDeviceId() {
        return this.mId;
    }
}
