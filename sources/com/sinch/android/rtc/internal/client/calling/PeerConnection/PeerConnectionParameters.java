package com.sinch.android.rtc.internal.client.calling.PeerConnection;

/* loaded from: classes3.dex */
public class PeerConnectionParameters {
    private static final String TAG = "PeerConnectionParameters";
    private static boolean configReadSuccess = false;
    private static String preferredCodecName;
    private static int preferredStartBitrate;
    public final boolean aecDump;
    public final String audioCodec;
    public final int audioStartBitrate;
    public final boolean captureToTexture;
    public final DataChannelParameters dataChannelParameters;
    public final boolean disableBuiltInAEC;
    public final boolean disableBuiltInAGC;
    public final boolean disableBuiltInNS;
    public final boolean disableWebRtcAGCAndHPF;
    public final boolean enableLevelControl;
    public final boolean noAudioProcessing;
    public final boolean tracing;
    public final boolean useOpenSLES;
    public final boolean videoCallEnabled;
    public final String videoCodec;
    public final boolean videoCodecHwAcceleration;
    public final boolean videoFlexfecEnabled;
    public final int videoFps;
    public final int videoHeight;
    public final int videoMaxBitrate;
    public final int videoWidth;

    /* loaded from: classes3.dex */
    public static class DataChannelParameters {
        public final int id;
        public final int maxRetransmitTimeMs;
        public final int maxRetransmits;
        public final boolean negotiated;
        public final boolean ordered;
        public final String protocol;

        public DataChannelParameters(boolean z7, int i8, int i9, String str, boolean z8, int i10) {
            this.ordered = z7;
            this.maxRetransmitTimeMs = i8;
            this.maxRetransmits = i9;
            this.protocol = str;
            this.negotiated = z8;
            this.id = i10;
        }
    }

    public PeerConnectionParameters(boolean z7, boolean z8, int i8, int i9, int i10, int i11, String str, boolean z9, boolean z10, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, DataChannelParameters dataChannelParameters, boolean z19) {
        this.videoCallEnabled = z7;
        this.tracing = z8;
        this.videoWidth = i8;
        this.videoHeight = i9;
        this.videoFps = i10;
        this.videoMaxBitrate = i11;
        this.videoCodec = str;
        this.videoFlexfecEnabled = z10;
        this.videoCodecHwAcceleration = z9;
        this.audioStartBitrate = i12;
        this.audioCodec = str2;
        this.noAudioProcessing = z11;
        this.aecDump = z12;
        this.useOpenSLES = z13;
        this.disableBuiltInAEC = z14;
        this.disableBuiltInAGC = z15;
        this.disableBuiltInNS = z16;
        this.enableLevelControl = z17;
        this.disableWebRtcAGCAndHPF = z18;
        this.dataChannelParameters = dataChannelParameters;
        this.captureToTexture = z19;
    }

    public PeerConnectionParameters(boolean z7, boolean z8, int i8, int i9, int i10, int i11, String str, boolean z9, boolean z10, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19) {
        this(z7, z8, i8, i9, i10, i11, str, z9, z10, i12, str2, z11, z12, z13, z14, z15, z16, z17, z18, null, z19);
    }

    public static PeerConnectionParameters getDefaultAudioPeerConnectionParameters() {
        String str;
        int i8;
        if (configReadSuccess) {
            str = preferredCodecName;
            i8 = preferredStartBitrate / 1000;
        } else {
            str = "OPUS";
            i8 = 32;
        }
        return new PeerConnectionParameters(false, false, 0, 0, 0, 0, "", false, false, i8, str, false, false, true, false, false, false, false, false, getDefaultDataChannelParameters(), false);
    }

    public static DataChannelParameters getDefaultDataChannelParameters() {
        return new DataChannelParameters(true, -1, -1, "", false, -1);
    }

    public static PeerConnectionParameters getDefaultPeerConnectionParameters() {
        return new PeerConnectionParameters(true, false, 640, 480, 30, 1500, PeerConnectionUtils.VIDEO_CODEC_H264, true, false, 32, "OPUS", false, false, false, false, false, false, false, false, getDefaultDataChannelParameters(), true);
    }
}
