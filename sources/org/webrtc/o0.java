package org.webrtc;

import org.webrtc.VideoEncoderFactory;

/* loaded from: classes4.dex */
public final /* synthetic */ class o0 {
    @CalledByNative
    public static VideoEncoderFactory.VideoEncoderSelector a(VideoEncoderFactory videoEncoderFactory) {
        return null;
    }

    @CalledByNative
    public static VideoCodecInfo[] b(VideoEncoderFactory videoEncoderFactory) {
        return videoEncoderFactory.getSupportedCodecs();
    }
}
