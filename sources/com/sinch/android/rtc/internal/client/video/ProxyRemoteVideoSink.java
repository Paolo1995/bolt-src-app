package com.sinch.android.rtc.internal.client.video;

import com.sinch.android.rtc.video.RemoteVideoFrameListener;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* loaded from: classes3.dex */
public class ProxyRemoteVideoSink extends ProxyVideoSink implements VideoSink {
    private final String mCallId;

    public ProxyRemoteVideoSink(String str) {
        this.mCallId = str;
    }

    @Override // com.sinch.android.rtc.internal.client.video.ProxyVideoSink
    public void dispatchProcessedFrame(VideoFrame videoFrame) {
        ((RemoteVideoFrameListener) this.mListener).onFrame(this.mCallId, ProxyVideoSink.wrapVideoFrame(videoFrame));
        synchronized (this.mVideoSinkLock) {
            VideoSink videoSink = this.mTargetSink;
            if (videoSink != null) {
                videoSink.onFrame(videoFrame);
            }
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        super.processFrame(videoFrame);
    }

    public void setRemoteVideoFrameListener(RemoteVideoFrameListener remoteVideoFrameListener) {
        this.mPendingListener = remoteVideoFrameListener;
    }
}
