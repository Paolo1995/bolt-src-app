package org.webrtc;

import java.nio.ByteBuffer;
import org.webrtc.VideoFrame;

/* loaded from: classes4.dex */
public class JavaI420Buffer implements VideoFrame.I420Buffer {
    private final ByteBuffer dataU;
    private final ByteBuffer dataV;
    private final ByteBuffer dataY;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    private JavaI420Buffer(int i8, int i9, ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, ByteBuffer byteBuffer3, int i12, Runnable runnable) {
        this.width = i8;
        this.height = i9;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i10;
        this.strideU = i11;
        this.strideV = i12;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static JavaI420Buffer allocate(int i8, int i9) {
        int i10 = (i9 + 1) / 2;
        int i11 = (i8 + 1) / 2;
        int i12 = i8 * i9;
        int i13 = i12 + 0;
        int i14 = i11 * i10;
        int i15 = i13 + i14;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i12 + (i11 * 2 * i10));
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i13);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i13);
        nativeAllocateByteBuffer.limit(i15);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i15);
        nativeAllocateByteBuffer.limit(i15 + i14);
        return new JavaI420Buffer(i8, i9, slice, i8, slice2, i11, nativeAllocateByteBuffer.slice(), i11, new Runnable() { // from class: org.webrtc.s
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    private static void checkCapacity(ByteBuffer byteBuffer, int i8, int i9, int i10) {
        int i11 = (i10 * (i9 - 1)) + i8;
        if (byteBuffer.capacity() >= i11) {
            return;
        }
        throw new IllegalArgumentException("Buffer must be at least " + i11 + " bytes, but was " + byteBuffer.capacity());
    }

    public static VideoFrame.Buffer cropAndScaleI420(final VideoFrame.I420Buffer i420Buffer, int i8, int i9, int i10, int i11, int i12, int i13) {
        if (i10 == i12 && i11 == i13) {
            ByteBuffer dataY = i420Buffer.getDataY();
            ByteBuffer dataU = i420Buffer.getDataU();
            ByteBuffer dataV = i420Buffer.getDataV();
            dataY.position(i8 + (i420Buffer.getStrideY() * i9));
            int i14 = i8 / 2;
            int i15 = i9 / 2;
            dataU.position((i420Buffer.getStrideU() * i15) + i14);
            dataV.position(i14 + (i15 * i420Buffer.getStrideV()));
            i420Buffer.retain();
            return wrap(i12, i13, dataY.slice(), i420Buffer.getStrideY(), dataU.slice(), i420Buffer.getStrideU(), dataV.slice(), i420Buffer.getStrideV(), new Runnable() { // from class: org.webrtc.r
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFrame.I420Buffer.this.release();
                }
            });
        }
        JavaI420Buffer allocate = allocate(i12, i13);
        nativeCropAndScaleI420(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), i8, i9, i10, i11, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV(), i12, i13);
        return allocate;
    }

    private static native void nativeCropAndScaleI420(ByteBuffer byteBuffer, int i8, ByteBuffer byteBuffer2, int i9, ByteBuffer byteBuffer3, int i10, int i11, int i12, int i13, int i14, ByteBuffer byteBuffer4, int i15, ByteBuffer byteBuffer5, int i16, ByteBuffer byteBuffer6, int i17, int i18, int i19);

    public static JavaI420Buffer wrap(int i8, int i9, ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, ByteBuffer byteBuffer3, int i12, Runnable runnable) {
        if (byteBuffer == null || byteBuffer2 == null || byteBuffer3 == null) {
            throw new IllegalArgumentException("Data buffers cannot be null.");
        }
        if (byteBuffer.isDirect() && byteBuffer2.isDirect() && byteBuffer3.isDirect()) {
            ByteBuffer slice = byteBuffer.slice();
            ByteBuffer slice2 = byteBuffer2.slice();
            ByteBuffer slice3 = byteBuffer3.slice();
            int i13 = (i8 + 1) / 2;
            int i14 = (i9 + 1) / 2;
            checkCapacity(slice, i8, i9, i10);
            checkCapacity(slice2, i13, i14, i11);
            checkCapacity(slice3, i13, i14, i12);
            return new JavaI420Buffer(i8, i9, slice, i10, slice2, i11, slice3, i12, runnable);
        }
        throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i8, int i9, int i10, int i11, int i12, int i13) {
        return cropAndScaleI420(this, i8, i9, i10, i11, i12, i13);
    }

    @Override // org.webrtc.VideoFrame.I420Buffer, org.webrtc.VideoFrame.Buffer
    public /* synthetic */ int getBufferType() {
        return w0.a(this);
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
    }
}
