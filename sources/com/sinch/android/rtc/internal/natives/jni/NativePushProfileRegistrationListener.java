package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.SinchError;

/* loaded from: classes3.dex */
public interface NativePushProfileRegistrationListener {
    void onNewPushProfileRequired(String str);

    void onPushProfileUpdateFailed(int i8, SinchError sinchError);

    void onPushProfileUpdated(int i8);
}
