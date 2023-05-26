package org.webrtc;

/* loaded from: classes4.dex */
public class AudioTrack extends MediaStreamTrack {
    public AudioTrack(long j8) {
        super(j8);
    }

    private static native void nativeSetVolume(long j8, double d8);

    public long getNativeAudioTrack() {
        return getNativeMediaStreamTrack();
    }

    public void setVolume(double d8) {
        nativeSetVolume(getNativeAudioTrack(), d8);
    }
}
