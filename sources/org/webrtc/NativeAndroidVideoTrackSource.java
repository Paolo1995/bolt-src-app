package org.webrtc;

import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;
import org.webrtc.VideoSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class NativeAndroidVideoTrackSource {
    private final long nativeAndroidVideoTrackSource;

    public NativeAndroidVideoTrackSource(long j8) {
        this.nativeAndroidVideoTrackSource = j8;
    }

    @CalledByNative
    public static VideoProcessor.FrameAdaptationParameters createFrameAdaptationParameters(int i8, int i9, int i10, int i11, int i12, int i13, long j8, boolean z7) {
        return new VideoProcessor.FrameAdaptationParameters(i8, i9, i10, i11, i12, i13, j8, z7);
    }

    private static native VideoProcessor.FrameAdaptationParameters nativeAdaptFrame(long j8, int i8, int i9, int i10, long j9);

    private static native void nativeAdaptOutputFormat(long j8, int i8, int i9, Integer num, int i10, int i11, Integer num2, Integer num3);

    private static native void nativeOnFrameCaptured(long j8, int i8, long j9, VideoFrame.Buffer buffer);

    private static native void nativeSetIsScreencast(long j8, boolean z7);

    private static native void nativeSetState(long j8, boolean z7);

    public VideoProcessor.FrameAdaptationParameters adaptFrame(VideoFrame videoFrame) {
        return nativeAdaptFrame(this.nativeAndroidVideoTrackSource, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation(), videoFrame.getTimestampNs());
    }

    public void adaptOutputFormat(VideoSource.AspectRatio aspectRatio, Integer num, VideoSource.AspectRatio aspectRatio2, Integer num2, Integer num3) {
        nativeAdaptOutputFormat(this.nativeAndroidVideoTrackSource, aspectRatio.width, aspectRatio.height, num, aspectRatio2.width, aspectRatio2.height, num2, num3);
    }

    public void onFrameCaptured(VideoFrame videoFrame) {
        nativeOnFrameCaptured(this.nativeAndroidVideoTrackSource, videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getBuffer());
    }

    public void setIsScreencast(boolean z7) {
        nativeSetIsScreencast(this.nativeAndroidVideoTrackSource, z7);
    }

    public void setState(boolean z7) {
        nativeSetState(this.nativeAndroidVideoTrackSource, z7);
    }
}
