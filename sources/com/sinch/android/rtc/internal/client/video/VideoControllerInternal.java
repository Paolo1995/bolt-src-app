package com.sinch.android.rtc.internal.client.video;

import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface;
import com.sinch.android.rtc.video.LocalVideoFrameListener;
import com.sinch.android.rtc.video.RemoteVideoFrameListener;
import com.sinch.android.rtc.video.VideoController;
import org.webrtc.EglBase;
import org.webrtc.SurfaceViewRenderer;

/* loaded from: classes3.dex */
public interface VideoControllerInternal extends VideoController {
    void dispose();

    EglBase getEglBase();

    SurfaceViewRenderer getLocalRenderer();

    LocalVideoFrameListener getLocalVideoFrameListener();

    SurfaceViewRenderer getRemoteRenderer();

    RemoteVideoFrameListener getRemoteVideoFrameListener();

    void setPeerConnectionClient(PeerConnectionClientInterface peerConnectionClientInterface);
}
