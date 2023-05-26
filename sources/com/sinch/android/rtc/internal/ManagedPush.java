package com.sinch.android.rtc.internal;

import com.sinch.android.rtc.PushTokenRegistrationCallback;
import com.sinch.android.rtc.PushTokenUnregistrationCallback;

/* loaded from: classes3.dex */
public interface ManagedPush {
    void registerPushToken(PushTokenRegistrationCallback pushTokenRegistrationCallback) throws UnsupportedOperationException;

    void unregisterPushToken(PushTokenUnregistrationCallback pushTokenUnregistrationCallback) throws UnsupportedOperationException;
}
