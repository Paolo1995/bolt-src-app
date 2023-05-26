package com.sinch.android.rtc;

/* loaded from: classes3.dex */
public interface PushTokenUnregistrationCallback {
    void onPushTokenUnregistered();

    void onPushTokenUnregistrationFailed(SinchError sinchError);
}
