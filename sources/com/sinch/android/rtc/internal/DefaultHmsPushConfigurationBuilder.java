package com.sinch.android.rtc.internal;

import com.sinch.android.rtc.HmsPushConfigurationBuilder;
import com.sinch.android.rtc.PushConfiguration;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class DefaultHmsPushConfigurationBuilder implements HmsPushConfigurationBuilder {
    public static final String HMS_APP_ID_KEY = "hmsApplicationId";
    private String mApplicationId;
    private String mDeviceToken;

    @Override // com.sinch.android.rtc.HmsPushConfigurationBuilder
    public DefaultHmsPushConfigurationBuilder applicationId(String str) {
        this.mApplicationId = str;
        return this;
    }

    @Override // com.sinch.android.rtc.HmsPushConfigurationBuilder
    public PushConfiguration build() {
        HashMap hashMap = new HashMap();
        hashMap.put(HMS_APP_ID_KEY, this.mApplicationId);
        return new DefaultPushConfiguration(this.mDeviceToken, ManagedPushVendor.HMS, hashMap);
    }

    @Override // com.sinch.android.rtc.HmsPushConfigurationBuilder
    public DefaultHmsPushConfigurationBuilder deviceToken(String str) {
        this.mDeviceToken = str;
        return this;
    }
}
