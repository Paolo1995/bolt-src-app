package org.webrtc;

/* loaded from: classes4.dex */
public class AudioSource extends MediaSource {
    public AudioSource(long j8) {
        super(j8);
    }

    public long getNativeAudioSource() {
        return getNativeMediaSource();
    }
}
