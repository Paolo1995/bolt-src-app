package org.webrtc;

import org.webrtc.VideoEncoder;

/* loaded from: classes4.dex */
public final /* synthetic */ class n0 {
    @CalledByNative
    public static long a(VideoEncoder videoEncoder) {
        return 0L;
    }

    @CalledByNative
    public static VideoEncoder.EncoderInfo b(VideoEncoder videoEncoder) {
        return new VideoEncoder.EncoderInfo(1, false);
    }

    @CalledByNative
    public static VideoEncoder.ResolutionBitrateLimits[] c(VideoEncoder videoEncoder) {
        return new VideoEncoder.ResolutionBitrateLimits[0];
    }

    @CalledByNative
    public static boolean d(VideoEncoder videoEncoder) {
        return true;
    }

    @CalledByNative
    public static VideoCodecStatus e(VideoEncoder videoEncoder, VideoEncoder.RateControlParameters rateControlParameters) {
        return videoEncoder.setRateAllocation(rateControlParameters.bitrate, (int) Math.ceil(rateControlParameters.framerateFps));
    }
}
