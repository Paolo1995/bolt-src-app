package org.webrtc;

/* loaded from: classes4.dex */
public final class CandidatePairChangeEvent {
    public final int estimatedDisconnectedTimeMs;
    public final int lastDataReceivedMs;
    public final IceCandidate local;
    public final String reason;
    public final IceCandidate remote;

    @CalledByNative
    public CandidatePairChangeEvent(IceCandidate iceCandidate, IceCandidate iceCandidate2, int i8, String str, int i9) {
        this.local = iceCandidate;
        this.remote = iceCandidate2;
        this.lastDataReceivedMs = i8;
        this.reason = str;
        this.estimatedDisconnectedTimeMs = i9;
    }
}
