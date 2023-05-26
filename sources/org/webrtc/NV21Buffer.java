package org.webrtc;

import java.nio.ByteBuffer;
import org.webrtc.VideoFrame;

/* loaded from: classes4.dex */
public class NV21Buffer implements VideoFrame.Buffer {
    private final byte[] data;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int width;

    public NV21Buffer(byte[] bArr, int i8, int i9, Runnable runnable) {
        this.data = bArr;
        this.width = i8;
        this.height = i9;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    private static native void nativeCropAndScale(int i8, int i9, int i10, int i11, int i12, int i13, byte[] bArr, int i14, int i15, ByteBuffer byteBuffer, int i16, ByteBuffer byteBuffer2, int i17, ByteBuffer byteBuffer3, int i18);

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i8, int i9, int i10, int i11, int i12, int i13) {
        JavaI420Buffer allocate = JavaI420Buffer.allocate(i12, i13);
        nativeCropAndScale(i8, i9, i10, i11, i12, i13, this.data, this.width, this.height, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV());
        return allocate;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public /* synthetic */ int getBufferType() {
        return v0.a(this);
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
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
        int i8 = this.width;
        int i9 = this.height;
        return (VideoFrame.I420Buffer) cropAndScale(0, 0, i8, i9, i8, i9);
    }
}
