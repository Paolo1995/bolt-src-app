package com.sinch.android.rtc.internal.client.video;

import android.view.View;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface;
import com.sinch.android.rtc.video.LocalVideoFrameListener;
import com.sinch.android.rtc.video.RemoteVideoFrameListener;
import com.sinch.android.rtc.video.VideoScalingType;
import org.webrtc.EglBase;
import org.webrtc.SurfaceViewRenderer;

/* loaded from: classes3.dex */
public class NullVideoController implements VideoControllerInternal {
    public EglBase rootEglBase = DefaultPeerConnectionFactoryProvider.getRootEglBase();

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public void dispose() {
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public int getCaptureDevicePosition() {
        return 0;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public EglBase getEglBase() {
        return this.rootEglBase;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public SurfaceViewRenderer getLocalRenderer() {
        return null;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public LocalVideoFrameListener getLocalVideoFrameListener() {
        return null;
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public View getLocalView() {
        return null;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public SurfaceViewRenderer getRemoteRenderer() {
        return null;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public RemoteVideoFrameListener getRemoteVideoFrameListener() {
        return null;
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public View getRemoteView() {
        return null;
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setCaptureDevicePosition(int i8) {
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setLocalVideoFrameListener(LocalVideoFrameListener localVideoFrameListener) {
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setLocalVideoResizeBehaviour(VideoScalingType videoScalingType) {
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setLocalVideoZOrder(boolean z7) {
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public void setPeerConnectionClient(PeerConnectionClientInterface peerConnectionClientInterface) {
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setRemoteVideoFrameListener(RemoteVideoFrameListener remoteVideoFrameListener) {
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setResizeBehaviour(VideoScalingType videoScalingType) {
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setTorchMode(boolean z7) {
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void toggleCaptureDevicePosition() {
    }
}
