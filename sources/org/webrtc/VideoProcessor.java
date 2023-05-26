package org.webrtc;

/* loaded from: classes4.dex */
public interface VideoProcessor extends CapturerObserver {

    /* loaded from: classes4.dex */
    public static class FrameAdaptationParameters {
        public final int cropHeight;
        public final int cropWidth;
        public final int cropX;
        public final int cropY;
        public final boolean drop;
        public final int scaleHeight;
        public final int scaleWidth;
        public final long timestampNs;

        public FrameAdaptationParameters(int i8, int i9, int i10, int i11, int i12, int i13, long j8, boolean z7) {
            this.cropX = i8;
            this.cropY = i9;
            this.cropWidth = i10;
            this.cropHeight = i11;
            this.scaleWidth = i12;
            this.scaleHeight = i13;
            this.timestampNs = j8;
            this.drop = z7;
        }
    }

    void onFrameCaptured(VideoFrame videoFrame, FrameAdaptationParameters frameAdaptationParameters);

    void setSink(VideoSink videoSink);
}
