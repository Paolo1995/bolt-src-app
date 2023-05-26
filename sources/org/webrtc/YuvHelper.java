package org.webrtc;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class YuvHelper {
    public static void ABGRToI420(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, int i12, int i13) {
        nativeABGRToI420(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, byteBuffer4, i11, i12, i13);
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, int i12) {
        I420Copy(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, byteBuffer4, i11, i12, i11, i12, (i11 + 1) / 2, (i12 + 1) / 2);
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, int i12, int i13, int i14, int i15, int i16) {
        int i17 = (i12 + 1) / 2;
        int i18 = (i13 * i12) + 0;
        int i19 = (i13 * i14) + 0;
        int i20 = (i15 * i17) + i19;
        int i21 = (i15 * i16) + i19;
        int i22 = ((i17 - 1) * i15) + i21 + ((i11 + 1) / 2);
        if (byteBuffer4.capacity() < i22) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i22 + " was " + byteBuffer4.capacity());
        }
        byteBuffer4.limit(i18);
        byteBuffer4.position(0);
        ByteBuffer slice = byteBuffer4.slice();
        byteBuffer4.limit(i20);
        byteBuffer4.position(i19);
        ByteBuffer slice2 = byteBuffer4.slice();
        byteBuffer4.limit(i22);
        byteBuffer4.position(i21);
        I420Copy(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, slice, i13, slice2, i15, byteBuffer4.slice(), i15, i11, i12);
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, ByteBuffer byteBuffer5, int i12, ByteBuffer byteBuffer6, int i13, int i14, int i15) {
        if (byteBuffer == null || byteBuffer2 == null || byteBuffer3 == null || byteBuffer4 == null || byteBuffer5 == null || byteBuffer6 == null || i14 <= 0 || i15 <= 0) {
            throw new IllegalArgumentException("Invalid I420Copy input arguments");
        }
        nativeI420Copy(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, byteBuffer4, i11, byteBuffer5, i12, byteBuffer6, i13, i14, i15);
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, int i12, int i13) {
        int i14 = i13 % 180;
        int i15 = i14 == 0 ? i11 : i12;
        int i16 = i14 == 0 ? i12 : i11;
        int i17 = (i15 + 1) / 2;
        int i18 = i16 * i15;
        int i19 = ((i16 + 1) / 2) * i17;
        int i20 = (i19 * 2) + i18;
        if (byteBuffer4.capacity() < i20) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i20 + " was " + byteBuffer4.capacity());
        }
        byteBuffer4.position(0);
        ByteBuffer slice = byteBuffer4.slice();
        byteBuffer4.position(i18);
        ByteBuffer slice2 = byteBuffer4.slice();
        byteBuffer4.position(i19 + i18);
        nativeI420Rotate(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, slice, i15, slice2, i17, byteBuffer4.slice(), i17, i11, i12, i13);
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, ByteBuffer byteBuffer5, int i12, ByteBuffer byteBuffer6, int i13, int i14, int i15, int i16) {
        nativeI420Rotate(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, byteBuffer4, i11, byteBuffer5, i12, byteBuffer6, i13, i14, i15, i16);
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, int i12) {
        I420ToNV12(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, byteBuffer4, i11, i12, i11, i12);
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, int i12, int i13, int i14) {
        int i15 = (i11 + 1) / 2;
        int i16 = (i13 * i12) + 0;
        int i17 = (i13 * i14) + 0;
        int i18 = (((i12 + 1) / 2) * i15 * 2) + i17;
        if (byteBuffer4.capacity() < i18) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i18 + " was " + byteBuffer4.capacity());
        }
        byteBuffer4.limit(i16);
        byteBuffer4.position(0);
        ByteBuffer slice = byteBuffer4.slice();
        byteBuffer4.limit(i18);
        byteBuffer4.position(i17);
        I420ToNV12(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, slice, i13, byteBuffer4.slice(), i15 * 2, i11, i12);
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, ByteBuffer byteBuffer5, int i12, int i13, int i14) {
        if (byteBuffer == null || byteBuffer2 == null || byteBuffer3 == null || byteBuffer4 == null || byteBuffer5 == null || i13 <= 0 || i14 <= 0) {
            throw new IllegalArgumentException("Invalid I420ToNV12 input arguments");
        }
        nativeI420ToNV12(byteBuffer, i8, byteBuffer2, i9, byteBuffer3, i10, byteBuffer4, i11, byteBuffer5, i12, i13, i14);
    }

    public static void copyPlane(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, int i10, int i11) {
        nativeCopyPlane(byteBuffer, i8, byteBuffer2, i9, i10, i11);
    }

    private static native void nativeABGRToI420(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, int i12, int i13);

    private static native void nativeCopyPlane(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, int i10, int i11);

    private static native void nativeI420Copy(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, ByteBuffer byteBuffer5, int i12, ByteBuffer byteBuffer6, int i13, int i14, int i15);

    private static native void nativeI420Rotate(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, ByteBuffer byteBuffer5, int i12, ByteBuffer byteBuffer6, int i13, int i14, int i15, int i16);

    private static native void nativeI420ToNV12(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, ByteBuffer byteBuffer4, int i11, ByteBuffer byteBuffer5, int i12, int i13, int i14);
}
