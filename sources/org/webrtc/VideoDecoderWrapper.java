package org.webrtc;

import org.webrtc.VideoDecoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class VideoDecoderWrapper {
    @CalledByNative
    public static VideoDecoder.Callback createDecoderCallback(final long j8) {
        return new VideoDecoder.Callback() { // from class: org.webrtc.m0
            @Override // org.webrtc.VideoDecoder.Callback
            public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
                VideoDecoderWrapper.nativeOnDecodedFrame(j8, videoFrame, num, num2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnDecodedFrame(long j8, VideoFrame videoFrame, Integer num, Integer num2);
}
