package org.webrtc;

import org.webrtc.EncodedImage;

/* loaded from: classes4.dex */
public interface VideoEncoder {

    /* loaded from: classes4.dex */
    public static class BitrateAllocation {
        public final int[][] bitratesBbs;

        @CalledByNative("BitrateAllocation")
        public BitrateAllocation(int[][] iArr) {
            this.bitratesBbs = iArr;
        }

        public int getSum() {
            int[][] iArr;
            int i8 = 0;
            for (int[] iArr2 : this.bitratesBbs) {
                for (int i9 : iArr2) {
                    i8 += i9;
                }
            }
            return i8;
        }
    }

    /* loaded from: classes4.dex */
    public interface Callback {
        void onEncodedFrame(EncodedImage encodedImage, CodecSpecificInfo codecSpecificInfo);
    }

    /* loaded from: classes4.dex */
    public static class Capabilities {
        public final boolean lossNotification;

        @CalledByNative("Capabilities")
        public Capabilities(boolean z7) {
            this.lossNotification = z7;
        }
    }

    /* loaded from: classes4.dex */
    public static class CodecSpecificInfo {
    }

    /* loaded from: classes4.dex */
    public static class CodecSpecificInfoAV1 extends CodecSpecificInfo {
    }

    /* loaded from: classes4.dex */
    public static class CodecSpecificInfoH264 extends CodecSpecificInfo {
    }

    /* loaded from: classes4.dex */
    public static class CodecSpecificInfoVP8 extends CodecSpecificInfo {
    }

    /* loaded from: classes4.dex */
    public static class CodecSpecificInfoVP9 extends CodecSpecificInfo {
    }

    /* loaded from: classes4.dex */
    public static class EncodeInfo {
        public final EncodedImage.FrameType[] frameTypes;

        @CalledByNative("EncodeInfo")
        public EncodeInfo(EncodedImage.FrameType[] frameTypeArr) {
            this.frameTypes = frameTypeArr;
        }
    }

    /* loaded from: classes4.dex */
    public static class EncoderInfo {
        public final boolean applyAlignmentToAllSimulcastLayers;
        public final int requestedResolutionAlignment;

        public EncoderInfo(int i8, boolean z7) {
            this.requestedResolutionAlignment = i8;
            this.applyAlignmentToAllSimulcastLayers = z7;
        }

        @CalledByNative("EncoderInfo")
        public boolean getApplyAlignmentToAllSimulcastLayers() {
            return this.applyAlignmentToAllSimulcastLayers;
        }

        @CalledByNative("EncoderInfo")
        public int getRequestedResolutionAlignment() {
            return this.requestedResolutionAlignment;
        }
    }

    /* loaded from: classes4.dex */
    public static class RateControlParameters {
        public final BitrateAllocation bitrate;
        public final double framerateFps;

        @CalledByNative("RateControlParameters")
        public RateControlParameters(BitrateAllocation bitrateAllocation, double d8) {
            this.bitrate = bitrateAllocation;
            this.framerateFps = d8;
        }
    }

    /* loaded from: classes4.dex */
    public static class ResolutionBitrateLimits {
        public final int frameSizePixels;
        public final int maxBitrateBps;
        public final int minBitrateBps;
        public final int minStartBitrateBps;

        public ResolutionBitrateLimits(int i8, int i9, int i10, int i11) {
            this.frameSizePixels = i8;
            this.minStartBitrateBps = i9;
            this.minBitrateBps = i10;
            this.maxBitrateBps = i11;
        }

        @CalledByNative("ResolutionBitrateLimits")
        public int getFrameSizePixels() {
            return this.frameSizePixels;
        }

        @CalledByNative("ResolutionBitrateLimits")
        public int getMaxBitrateBps() {
            return this.maxBitrateBps;
        }

        @CalledByNative("ResolutionBitrateLimits")
        public int getMinBitrateBps() {
            return this.minBitrateBps;
        }

        @CalledByNative("ResolutionBitrateLimits")
        public int getMinStartBitrateBps() {
            return this.minStartBitrateBps;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();
        public final Integer high;
        public final Integer low;
        public final boolean on;

        private ScalingSettings() {
            this.on = false;
            this.low = null;
            this.high = null;
        }

        public ScalingSettings(int i8, int i9) {
            this.on = true;
            this.low = Integer.valueOf(i8);
            this.high = Integer.valueOf(i9);
        }

        @Deprecated
        public ScalingSettings(boolean z7) {
            this.on = z7;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z7, int i8, int i9) {
            this.on = z7;
            this.low = Integer.valueOf(i8);
            this.high = Integer.valueOf(i9);
        }

        public String toString() {
            if (this.on) {
                return "[ " + this.low + ", " + this.high + " ]";
            }
            return "OFF";
        }
    }

    /* loaded from: classes4.dex */
    public static class Settings {
        public final boolean automaticResizeOn;
        public final Capabilities capabilities;
        public final int height;
        public final int maxFramerate;
        public final int numberOfCores;
        public final int numberOfSimulcastStreams;
        public final int startBitrate;
        public final int width;

        @Deprecated
        public Settings(int i8, int i9, int i10, int i11, int i12, int i13, boolean z7) {
            this(i8, i9, i10, i11, i12, i13, z7, new Capabilities(false));
        }

        @CalledByNative("Settings")
        public Settings(int i8, int i9, int i10, int i11, int i12, int i13, boolean z7, Capabilities capabilities) {
            this.numberOfCores = i8;
            this.width = i9;
            this.height = i10;
            this.startBitrate = i11;
            this.maxFramerate = i12;
            this.numberOfSimulcastStreams = i13;
            this.automaticResizeOn = z7;
            this.capabilities = capabilities;
        }
    }

    @CalledByNative
    long createNativeVideoEncoder();

    @CalledByNative
    VideoCodecStatus encode(VideoFrame videoFrame, EncodeInfo encodeInfo);

    @CalledByNative
    EncoderInfo getEncoderInfo();

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    ResolutionBitrateLimits[] getResolutionBitrateLimits();

    @CalledByNative
    ScalingSettings getScalingSettings();

    @CalledByNative
    VideoCodecStatus initEncode(Settings settings, Callback callback);

    @CalledByNative
    boolean isHardwareEncoder();

    @CalledByNative
    VideoCodecStatus release();

    VideoCodecStatus setRateAllocation(BitrateAllocation bitrateAllocation, int i8);

    @CalledByNative
    VideoCodecStatus setRates(RateControlParameters rateControlParameters);
}
