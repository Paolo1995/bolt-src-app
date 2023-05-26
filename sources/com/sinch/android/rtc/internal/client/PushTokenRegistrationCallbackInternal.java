package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.SinchError;

/* loaded from: classes3.dex */
public interface PushTokenRegistrationCallbackInternal {
    void tokenUpdateFailed(int i8, SinchError sinchError);

    void tokenUpdated(int i8);
}
