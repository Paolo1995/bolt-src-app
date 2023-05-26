package com.sinch.android.rtc.internal.natives;

import com.sinch.android.rtc.ClientRegistration;
import com.sinch.android.rtc.SinchError;
import com.sinch.android.rtc.internal.natives.jni.UserAgent;

/* loaded from: classes3.dex */
public interface UserAgentEventListener {
    void log(int i8, String str, String str2);

    void onAudioFeaturesChanged(int i8, int i9, boolean z7);

    void onConfigChanged(String str);

    void onExtendedSessionReportFlag(boolean z7);

    void onFailed(UserAgent userAgent, SinchError sinchError);

    void onNewPushProfileRequired(String str);

    void onPushProfileRegistered(int i8);

    void onPushProfileRegistrationFailed(int i8, SinchError sinchError);

    void onRegisterInstance(UserAgent userAgent, ClientRegistration clientRegistration);

    void onSDPSemanticChanged(boolean z7);

    void onStarted(UserAgent userAgent);

    void onUseTurnChanged(boolean z7);
}
