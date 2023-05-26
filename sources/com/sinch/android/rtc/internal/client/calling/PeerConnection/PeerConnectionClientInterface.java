package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import com.sinch.android.rtc.internal.client.calling.JsepMessage;
import com.sinch.android.rtc.video.LocalVideoFrameListener;
import com.sinch.android.rtc.video.RemoteVideoFrameListener;
import java.util.List;

/* loaded from: classes3.dex */
public interface PeerConnectionClientInterface {
    void close();

    void enableMedia(boolean z7, boolean z8, boolean z9, boolean z10);

    void enableStatsEvents(boolean z7, int i8);

    void enableVideoTrack(boolean z7);

    void onJsepMessageReceive(String str, JsepMessage jsepMessage);

    void onRemoteInstanceIdResolved(String str);

    void onRemotePeerCapabilitiesChange(String str, List<String> list);

    void sendDtmf(String str);

    void setBandwidthLimits(int i8, int i9);

    void setCommunicationMode(boolean z7);

    void setLocalVideoFrameListener(LocalVideoFrameListener localVideoFrameListener);

    void setRemoteVideoFrameListener(RemoteVideoFrameListener remoteVideoFrameListener);

    void setTorchMode(boolean z7);

    void switchCamera();
}
