package org.webrtc;

import org.webrtc.Logging;

/* loaded from: classes4.dex */
public class CallSessionFileRotatingLogSink {
    private long nativeSink;

    public CallSessionFileRotatingLogSink(String str, int i8, Logging.Severity severity) {
        if (str == null) {
            throw new IllegalArgumentException("dirPath may not be null.");
        }
        this.nativeSink = nativeAddSink(str, i8, severity.ordinal());
    }

    public static byte[] getLogData(String str) {
        if (str != null) {
            return nativeGetLogData(str);
        }
        throw new IllegalArgumentException("dirPath may not be null.");
    }

    private static native long nativeAddSink(String str, int i8, int i9);

    private static native void nativeDeleteSink(long j8);

    private static native byte[] nativeGetLogData(String str);

    public void dispose() {
        long j8 = this.nativeSink;
        if (j8 != 0) {
            nativeDeleteSink(j8);
            this.nativeSink = 0L;
        }
    }
}
