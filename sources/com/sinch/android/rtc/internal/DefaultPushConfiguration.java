package com.sinch.android.rtc.internal;

import com.sinch.android.rtc.PushConfiguration;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultPushConfiguration implements PushConfiguration {
    private final String mDeviceToken;
    private final ManagedPushVendor mVendor;
    private final Map<String, String> mVendorData;

    public DefaultPushConfiguration(String str, ManagedPushVendor managedPushVendor, Map<String, String> map) {
        this.mDeviceToken = str;
        this.mVendor = managedPushVendor;
        this.mVendorData = map;
    }

    @Override // com.sinch.android.rtc.PushConfiguration
    public String getDeviceToken() {
        return this.mDeviceToken;
    }

    @Override // com.sinch.android.rtc.PushConfiguration
    public Map<String, String> getVendorData() {
        return this.mVendorData;
    }

    @Override // com.sinch.android.rtc.PushConfiguration
    public String getVendorId() {
        return this.mVendor.getVendorID();
    }
}
