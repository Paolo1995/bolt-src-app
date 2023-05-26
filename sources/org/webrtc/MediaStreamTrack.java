package org.webrtc;

/* loaded from: classes4.dex */
public class MediaStreamTrack {
    public static final String AUDIO_TRACK_KIND = "audio";
    public static final String VIDEO_TRACK_KIND = "video";
    private long nativeTrack;

    /* loaded from: classes4.dex */
    public enum MediaType {
        MEDIA_TYPE_AUDIO(0),
        MEDIA_TYPE_VIDEO(1);
        
        private final int nativeIndex;

        MediaType(int i8) {
            this.nativeIndex = i8;
        }

        @CalledByNative("MediaType")
        public static MediaType fromNativeIndex(int i8) {
            MediaType[] values;
            for (MediaType mediaType : values()) {
                if (mediaType.getNative() == i8) {
                    return mediaType;
                }
            }
            throw new IllegalArgumentException("Unknown native media type: " + i8);
        }

        @CalledByNative("MediaType")
        public int getNative() {
            return this.nativeIndex;
        }
    }

    /* loaded from: classes4.dex */
    public enum State {
        LIVE,
        ENDED;

        @CalledByNative("State")
        public static State fromNativeIndex(int i8) {
            return values()[i8];
        }
    }

    public MediaStreamTrack(long j8) {
        if (j8 == 0) {
            throw new IllegalArgumentException("nativeTrack may not be null");
        }
        this.nativeTrack = j8;
    }

    private void checkMediaStreamTrackExists() {
        if (this.nativeTrack == 0) {
            throw new IllegalStateException("MediaStreamTrack has been disposed.");
        }
    }

    public static MediaStreamTrack createMediaStreamTrack(long j8) {
        if (j8 == 0) {
            return null;
        }
        String nativeGetKind = nativeGetKind(j8);
        if (nativeGetKind.equals(AUDIO_TRACK_KIND)) {
            return new AudioTrack(j8);
        }
        if (nativeGetKind.equals(VIDEO_TRACK_KIND)) {
            return new VideoTrack(j8);
        }
        return null;
    }

    private static native boolean nativeGetEnabled(long j8);

    private static native String nativeGetId(long j8);

    private static native String nativeGetKind(long j8);

    private static native State nativeGetState(long j8);

    private static native boolean nativeSetEnabled(long j8, boolean z7);

    public void dispose() {
        checkMediaStreamTrackExists();
        JniCommon.nativeReleaseRef(this.nativeTrack);
        this.nativeTrack = 0L;
    }

    public boolean enabled() {
        checkMediaStreamTrackExists();
        return nativeGetEnabled(this.nativeTrack);
    }

    public long getNativeMediaStreamTrack() {
        checkMediaStreamTrackExists();
        return this.nativeTrack;
    }

    public String id() {
        checkMediaStreamTrackExists();
        return nativeGetId(this.nativeTrack);
    }

    public String kind() {
        checkMediaStreamTrackExists();
        return nativeGetKind(this.nativeTrack);
    }

    public boolean setEnabled(boolean z7) {
        checkMediaStreamTrackExists();
        return nativeSetEnabled(this.nativeTrack, z7);
    }

    public State state() {
        checkMediaStreamTrackExists();
        return nativeGetState(this.nativeTrack);
    }
}
