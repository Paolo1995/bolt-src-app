package com.sinch.android.rtc.internal.natives.jni;

import java.util.Map;

/* loaded from: classes3.dex */
public interface CallClientListener {
    void onIceServers(Call call, WebRtcIceServer[] webRtcIceServerArr);

    void onIncomingCall(Call call);

    void onNewExternalPushPayload(Call call, Map<String, String> map);
}
