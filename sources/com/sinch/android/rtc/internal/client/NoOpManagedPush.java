package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.PushTokenRegistrationCallback;
import com.sinch.android.rtc.PushTokenUnregistrationCallback;
import com.sinch.android.rtc.SinchError;

/* loaded from: classes3.dex */
public class NoOpManagedPush implements ManagedPushImpl {
    @Override // com.sinch.android.rtc.internal.client.ManagedPushImpl
    public void dispose() {
    }

    @Override // com.sinch.android.rtc.internal.ManagedPush
    public void registerPushToken(PushTokenRegistrationCallback pushTokenRegistrationCallback) throws UnsupportedOperationException {
    }

    @Override // com.sinch.android.rtc.internal.client.ManagedPushImpl
    public void setSenderId(String str) {
    }

    @Override // com.sinch.android.rtc.internal.client.PushTokenRegistrationCallbackInternal
    public void tokenUpdateFailed(int i8, SinchError sinchError) {
    }

    @Override // com.sinch.android.rtc.internal.client.PushTokenRegistrationCallbackInternal
    public void tokenUpdated(int i8) {
    }

    @Override // com.sinch.android.rtc.internal.ManagedPush
    public void unregisterPushToken(PushTokenUnregistrationCallback pushTokenUnregistrationCallback) throws UnsupportedOperationException {
    }
}
