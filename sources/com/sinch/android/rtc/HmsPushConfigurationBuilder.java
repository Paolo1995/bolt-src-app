package com.sinch.android.rtc;

/* loaded from: classes3.dex */
public interface HmsPushConfigurationBuilder {
    HmsPushConfigurationBuilder applicationId(String str);

    PushConfiguration build();

    HmsPushConfigurationBuilder deviceToken(String str);
}
