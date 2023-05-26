package org.webrtc;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class JniCommon {
    public static native void nativeAddRef(long j8);

    public static native ByteBuffer nativeAllocateByteBuffer(int i8);

    public static native void nativeFreeByteBuffer(ByteBuffer byteBuffer);

    public static native void nativeReleaseRef(long j8);
}
