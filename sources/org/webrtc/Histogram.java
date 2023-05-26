package org.webrtc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class Histogram {
    private final long handle;

    private Histogram(long j8) {
        this.handle = j8;
    }

    public static Histogram createCounts(String str, int i8, int i9, int i10) {
        return new Histogram(nativeCreateCounts(str, i8, i9, i10));
    }

    public static Histogram createEnumeration(String str, int i8) {
        return new Histogram(nativeCreateEnumeration(str, i8));
    }

    private static native void nativeAddSample(long j8, int i8);

    private static native long nativeCreateCounts(String str, int i8, int i9, int i10);

    private static native long nativeCreateEnumeration(String str, int i8);

    public void addSample(int i8) {
        nativeAddSample(this.handle, i8);
    }
}
