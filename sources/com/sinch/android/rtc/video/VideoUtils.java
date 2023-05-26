package com.sinch.android.rtc.video;

import com.sinch.android.rtc.internal.client.video.VideoEffectProcessor;

/* loaded from: classes3.dex */
public class VideoUtils {
    public static VideoFrame I420toNV21Frame(VideoFrame videoFrame) {
        if (videoFrame.yuvPlanes().length == 3) {
            if (videoFrame.yuvStrides().length == 3) {
                return VideoEffectProcessor.convertI420toNv21(videoFrame);
            }
            throw new IllegalArgumentException("The frame must have 3 strides to be converted from I420.");
        }
        throw new IllegalArgumentException("The frame must have 3 planes to be converted from I420.");
    }

    public static void convertToBlackAndWhite(VideoFrame videoFrame) {
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < videoFrame.height() / 2; i10++) {
            for (int i11 = 0; i11 < videoFrame.width() / 2; i11++) {
                videoFrame.yuvPlanes()[1].put(i8 + i11, Byte.MIN_VALUE);
                videoFrame.yuvPlanes()[2].put(i9 + i11, Byte.MIN_VALUE);
            }
            i8 += videoFrame.yuvStrides()[1];
            i9 += videoFrame.yuvStrides()[2];
        }
    }
}
