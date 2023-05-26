package com.sinch.android.rtc.internal.client.video;

import com.sinch.android.rtc.video.LocalVideoFrameListener;
import com.sinch.android.rtc.video.ProcessedVideoFrameListener;
import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;
import org.webrtc.VideoSink;
import org.webrtc.y0;

/* loaded from: classes3.dex */
public class ProxyLocalVideoSink extends ProxyVideoSink implements VideoProcessor {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchProcessedFrame$0(VideoFrame videoFrame) {
        synchronized (this.mVideoSinkLock) {
            VideoSink videoSink = this.mTargetSink;
            if (videoSink != null) {
                videoSink.onFrame(videoFrame);
            }
        }
    }

    @Override // com.sinch.android.rtc.internal.client.video.ProxyVideoSink
    public void dispatchProcessedFrame(final VideoFrame videoFrame) {
        ((LocalVideoFrameListener) this.mListener).onFrame(ProxyVideoSink.wrapVideoFrame(videoFrame), new ProcessedVideoFrameListener() { // from class: com.sinch.android.rtc.internal.client.video.a
            @Override // com.sinch.android.rtc.video.ProcessedVideoFrameListener
            public final void onFrameProcessed() {
                ProxyLocalVideoSink.this.lambda$dispatchProcessedFrame$0(videoFrame);
            }
        });
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z7) {
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStopped() {
    }

    @Override // org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        super.processFrame(videoFrame);
    }

    @Override // org.webrtc.VideoProcessor
    public /* synthetic */ void onFrameCaptured(VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        y0.a(this, videoFrame, frameAdaptationParameters);
    }

    public void setLocalVideoFrameListener(LocalVideoFrameListener localVideoFrameListener) {
        this.mPendingListener = localVideoFrameListener;
    }
}
