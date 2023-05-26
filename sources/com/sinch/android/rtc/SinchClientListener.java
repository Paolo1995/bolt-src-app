package com.sinch.android.rtc;

/* loaded from: classes3.dex */
public interface SinchClientListener extends UserRegistrationCallback, PushTokenRegistrationCallback, PushTokenUnregistrationCallback {
    void onClientFailed(SinchClient sinchClient, SinchError sinchError);

    void onClientStarted(SinchClient sinchClient);

    void onLogMessage(int i8, String str, String str2);
}
