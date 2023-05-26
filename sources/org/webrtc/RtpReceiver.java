package org.webrtc;

import org.webrtc.MediaStreamTrack;

/* loaded from: classes4.dex */
public class RtpReceiver {
    private MediaStreamTrack cachedTrack;
    private long nativeObserver;
    private long nativeRtpReceiver;

    /* loaded from: classes4.dex */
    public interface Observer {
        @CalledByNative("Observer")
        void onFirstPacketReceived(MediaStreamTrack.MediaType mediaType);
    }

    @CalledByNative
    public RtpReceiver(long j8) {
        this.nativeRtpReceiver = j8;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j8));
    }

    private void checkRtpReceiverExists() {
        if (this.nativeRtpReceiver == 0) {
            throw new IllegalStateException("RtpReceiver has been disposed.");
        }
    }

    private static native String nativeGetId(long j8);

    private static native RtpParameters nativeGetParameters(long j8);

    private static native long nativeGetTrack(long j8);

    private static native void nativeSetFrameDecryptor(long j8, long j9);

    private static native long nativeSetObserver(long j8, Observer observer);

    private static native void nativeUnsetObserver(long j8, long j9);

    public void SetObserver(Observer observer) {
        checkRtpReceiverExists();
        long j8 = this.nativeObserver;
        if (j8 != 0) {
            nativeUnsetObserver(this.nativeRtpReceiver, j8);
        }
        this.nativeObserver = nativeSetObserver(this.nativeRtpReceiver, observer);
    }

    @CalledByNative
    public void dispose() {
        checkRtpReceiverExists();
        this.cachedTrack.dispose();
        long j8 = this.nativeObserver;
        if (j8 != 0) {
            nativeUnsetObserver(this.nativeRtpReceiver, j8);
            this.nativeObserver = 0L;
        }
        JniCommon.nativeReleaseRef(this.nativeRtpReceiver);
        this.nativeRtpReceiver = 0L;
    }

    public RtpParameters getParameters() {
        checkRtpReceiverExists();
        return nativeGetParameters(this.nativeRtpReceiver);
    }

    public String id() {
        checkRtpReceiverExists();
        return nativeGetId(this.nativeRtpReceiver);
    }

    public void setFrameDecryptor(FrameDecryptor frameDecryptor) {
        checkRtpReceiverExists();
        nativeSetFrameDecryptor(this.nativeRtpReceiver, frameDecryptor.getNativeFrameDecryptor());
    }

    public MediaStreamTrack track() {
        return this.cachedTrack;
    }
}
