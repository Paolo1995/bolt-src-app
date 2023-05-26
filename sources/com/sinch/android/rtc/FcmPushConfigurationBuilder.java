package com.sinch.android.rtc;

/* loaded from: classes3.dex */
public interface FcmPushConfigurationBuilder {
    PushConfiguration build();

    FcmPushConfigurationBuilder registrationToken(String str);

    FcmPushConfigurationBuilder senderID(String str);
}
