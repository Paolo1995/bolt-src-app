package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.ClientRegistration;
import com.sinch.android.rtc.SinchError;

/* loaded from: classes3.dex */
public interface NativeInstanceRegistrationListener {
    void onCredentialsRequired(int i8, ClientRegistration clientRegistration);

    void onInstanceRegistered(int i8);

    void onInstanceRegistrationFailed(int i8, SinchError sinchError);
}
