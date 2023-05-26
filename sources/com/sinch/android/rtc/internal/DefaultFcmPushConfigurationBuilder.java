package com.sinch.android.rtc.internal;

import com.sinch.android.rtc.FcmPushConfigurationBuilder;
import com.sinch.android.rtc.PushConfiguration;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class DefaultFcmPushConfigurationBuilder implements FcmPushConfigurationBuilder {
    public static final String FCM_SENDER_ID_KEY = "fcmSenderId";
    private String mRegistrationToken;
    private String mSenderID;

    @Override // com.sinch.android.rtc.FcmPushConfigurationBuilder
    public PushConfiguration build() {
        HashMap hashMap = new HashMap();
        hashMap.put(FCM_SENDER_ID_KEY, this.mSenderID);
        return new DefaultPushConfiguration(this.mRegistrationToken, ManagedPushVendor.FCM, hashMap);
    }

    @Override // com.sinch.android.rtc.FcmPushConfigurationBuilder
    public FcmPushConfigurationBuilder registrationToken(String str) {
        this.mRegistrationToken = str;
        return this;
    }

    @Override // com.sinch.android.rtc.FcmPushConfigurationBuilder
    public FcmPushConfigurationBuilder senderID(String str) {
        this.mSenderID = str;
        return this;
    }
}
