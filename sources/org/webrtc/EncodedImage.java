package org.webrtc;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class EncodedImage implements RefCounted {
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;
    public final Integer qp;
    private final RefCountDelegate refCountDelegate;
    public final int rotation;

    /* loaded from: classes4.dex */
    public static class Builder {
        private ByteBuffer buffer;
        private long captureTimeNs;
        private int encodedHeight;
        private int encodedWidth;
        private FrameType frameType;
        private Integer qp;
        private Runnable releaseCallback;
        private int rotation;

        private Builder() {
        }

        public EncodedImage createEncodedImage() {
            return new EncodedImage(this.buffer, this.releaseCallback, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.qp);
        }

        public Builder setBuffer(ByteBuffer byteBuffer, Runnable runnable) {
            this.buffer = byteBuffer;
            this.releaseCallback = runnable;
            return this;
        }

        @Deprecated
        public Builder setCaptureTimeMs(long j8) {
            this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(j8);
            return this;
        }

        public Builder setCaptureTimeNs(long j8) {
            this.captureTimeNs = j8;
            return this;
        }

        public Builder setEncodedHeight(int i8) {
            this.encodedHeight = i8;
            return this;
        }

        public Builder setEncodedWidth(int i8) {
            this.encodedWidth = i8;
            return this;
        }

        public Builder setFrameType(FrameType frameType) {
            this.frameType = frameType;
            return this;
        }

        public Builder setQp(Integer num) {
            this.qp = num;
            return this;
        }

        public Builder setRotation(int i8) {
            this.rotation = i8;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public enum FrameType {
        EmptyFrame(0),
        VideoFrameKey(3),
        VideoFrameDelta(4);
        
        private final int nativeIndex;

        FrameType(int i8) {
            this.nativeIndex = i8;
        }

        @CalledByNative("FrameType")
        public static FrameType fromNativeIndex(int i8) {
            FrameType[] values;
            for (FrameType frameType : values()) {
                if (frameType.getNative() == i8) {
                    return frameType;
                }
            }
            throw new IllegalArgumentException("Unknown native frame type: " + i8);
        }

        public int getNative() {
            return this.nativeIndex;
        }
    }

    @CalledByNative
    private EncodedImage(ByteBuffer byteBuffer, Runnable runnable, int i8, int i9, long j8, FrameType frameType, int i10, Integer num) {
        this.buffer = byteBuffer;
        this.encodedWidth = i8;
        this.encodedHeight = i9;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(j8);
        this.captureTimeNs = j8;
        this.frameType = frameType;
        this.rotation = i10;
        this.qp = num;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static Builder builder() {
        return new Builder();
    }

    @CalledByNative
    private ByteBuffer getBuffer() {
        return this.buffer;
    }

    @CalledByNative
    private long getCaptureTimeNs() {
        return this.captureTimeNs;
    }

    @CalledByNative
    private int getEncodedHeight() {
        return this.encodedHeight;
    }

    @CalledByNative
    private int getEncodedWidth() {
        return this.encodedWidth;
    }

    @CalledByNative
    private int getFrameType() {
        return this.frameType.getNative();
    }

    @CalledByNative
    private Integer getQp() {
        return this.qp;
    }

    @CalledByNative
    private int getRotation() {
        return this.rotation;
    }

    @Override // org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }
}
