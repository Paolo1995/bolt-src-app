package com.sinch.android.rtc;

/* loaded from: classes3.dex */
public interface UserRegistrationCallback {
    void onCredentialsRequired(ClientRegistration clientRegistration);

    void onUserRegistered();

    void onUserRegistrationFailed(SinchError sinchError);
}
