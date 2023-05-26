package com.sinch.android.rtc;

/* loaded from: classes3.dex */
public interface PushTokenRegistrationCallback {
    void onPushTokenRegistered();

    void onPushTokenRegistrationFailed(SinchError sinchError);
}
