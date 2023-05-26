package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.internal.ManagedPush;

/* loaded from: classes3.dex */
public interface ManagedPushImpl extends ManagedPush, PushTokenRegistrationCallbackInternal {
    void dispose();

    void setSenderId(String str);
}
