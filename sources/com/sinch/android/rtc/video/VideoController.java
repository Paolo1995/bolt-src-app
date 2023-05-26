package com.sinch.android.rtc.video;

import android.view.View;

/* loaded from: classes3.dex */
public interface VideoController {
    int getCaptureDevicePosition();

    View getLocalView();

    View getRemoteView();

    void setCaptureDevicePosition(int i8);

    void setLocalVideoFrameListener(LocalVideoFrameListener localVideoFrameListener);

    void setLocalVideoResizeBehaviour(VideoScalingType videoScalingType);

    void setLocalVideoZOrder(boolean z7);

    void setRemoteVideoFrameListener(RemoteVideoFrameListener remoteVideoFrameListener);

    void setResizeBehaviour(VideoScalingType videoScalingType);

    void setTorchMode(boolean z7);

    void toggleCaptureDevicePosition();
}
