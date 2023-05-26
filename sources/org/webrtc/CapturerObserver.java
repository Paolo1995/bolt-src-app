package org.webrtc;

/* loaded from: classes4.dex */
public interface CapturerObserver {
    void onCapturerStarted(boolean z7);

    void onCapturerStopped();

    void onFrameCaptured(VideoFrame videoFrame);
}
