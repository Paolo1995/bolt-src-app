package com.sinch.android.rtc.internal;

import com.sinch.android.rtc.internal.service.http.SinchHttpServiceObserver;

/* loaded from: classes3.dex */
public interface SinchClientPrivate {
    void relayPlainPushPayload(String str);

    void setHttpServiceObserver(SinchHttpServiceObserver sinchHttpServiceObserver);

    void setSupportActiveConnection(boolean z7);

    void setUseRelayCandidatesOnly(boolean z7);

    void startListeningOnActiveConnection();

    void stopListeningOnActiveConnection();

    void terminateForcefully();
}
