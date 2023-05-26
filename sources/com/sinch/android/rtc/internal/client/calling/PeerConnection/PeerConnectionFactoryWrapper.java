package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import org.webrtc.PeerConnectionFactory;
import org.webrtc.VideoCodecInfo;

/* loaded from: classes3.dex */
public class PeerConnectionFactoryWrapper {
    private final PeerConnectionFactory mFactory;
    private final boolean mIsHardwareCodecUsed;
    private final VideoCodecInfo[] mVideoDecoders;
    private final VideoCodecInfo[] mVideoEncoders;

    public PeerConnectionFactoryWrapper(PeerConnectionFactory peerConnectionFactory, VideoCodecInfo[] videoCodecInfoArr, VideoCodecInfo[] videoCodecInfoArr2, boolean z7) {
        this.mFactory = peerConnectionFactory;
        this.mVideoEncoders = videoCodecInfoArr;
        this.mVideoDecoders = videoCodecInfoArr2;
        this.mIsHardwareCodecUsed = z7;
    }

    public VideoCodecInfo[] getDecoders() {
        return this.mVideoDecoders;
    }

    public VideoCodecInfo[] getEncoders() {
        return this.mVideoEncoders;
    }

    public PeerConnectionFactory getFactory() {
        return this.mFactory;
    }

    public boolean isHardwareCodecsUsed() {
        return this.mIsHardwareCodecUsed;
    }
}
