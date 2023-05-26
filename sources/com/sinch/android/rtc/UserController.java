package com.sinch.android.rtc;

/* loaded from: classes3.dex */
public interface UserController {
    void registerUser(UserRegistrationCallback userRegistrationCallback, PushTokenRegistrationCallback pushTokenRegistrationCallback) throws UnsupportedOperationException;

    void unregisterPushToken(PushTokenUnregistrationCallback pushTokenUnregistrationCallback) throws UnsupportedOperationException;
}
