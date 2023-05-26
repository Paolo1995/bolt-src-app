package com.sinch.android.rtc.internal.client.video;

import android.util.Log;
import androidx.annotation.NonNull;
import com.sinch.android.rtc.video.VideoFrame;
import java.nio.ByteBuffer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* loaded from: classes3.dex */
public abstract class ProxyVideoSink {
    private static final String TAG = "ProxyVideoSink";
    public Object mListener;
    public Object mPendingListener;
    public VideoSink mTargetSink;
    public final Object mVideoSinkLock = new Object();

    @NonNull
    public static VideoFrame wrapVideoFrame(org.webrtc.VideoFrame videoFrame) {
        VideoFrame.I420Buffer i420Buffer = (VideoFrame.I420Buffer) videoFrame.getBuffer();
        return new VideoFrame.DefaultVideoFrame(new ByteBuffer[]{i420Buffer.getDataY(), i420Buffer.getDataU(), i420Buffer.getDataV()}, new int[]{i420Buffer.getStrideY(), i420Buffer.getStrideU(), i420Buffer.getStrideV()}, i420Buffer.getWidth(), i420Buffer.getHeight(), videoFrame.getRotation(), 35);
    }

    public abstract void dispatchProcessedFrame(org.webrtc.VideoFrame videoFrame);

    public void processFrame(org.webrtc.VideoFrame videoFrame) {
        Object obj = this.mListener;
        Object obj2 = this.mPendingListener;
        if (obj != obj2) {
            this.mListener = obj2;
        }
        if (this.mListener != null) {
            if (videoFrame.getBuffer() instanceof VideoFrame.I420Buffer) {
                videoFrame.retain();
            } else {
                videoFrame = new org.webrtc.VideoFrame(videoFrame.getBuffer().toI420(), videoFrame.getRotation(), videoFrame.getTimestampNs());
            }
            dispatchProcessedFrame(videoFrame);
            videoFrame.release();
            return;
        }
        synchronized (this.mVideoSinkLock) {
            VideoSink videoSink = this.mTargetSink;
            if (videoSink == null) {
                Log.d(TAG, "Dropping frame in proxy because target sink == null");
            } else {
                videoSink.onFrame(videoFrame);
            }
        }
    }

    public void setSink(VideoSink videoSink) {
        synchronized (this.mVideoSinkLock) {
            this.mTargetSink = videoSink;
        }
    }
}
