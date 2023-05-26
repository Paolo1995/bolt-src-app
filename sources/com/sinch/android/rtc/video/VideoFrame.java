package com.sinch.android.rtc.video;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface VideoFrame {

    /* loaded from: classes3.dex */
    public static class DefaultVideoFrame implements VideoFrame {
        private int colorFormat;
        private int height;
        private int rotationDegreesCw;
        private int width;
        private ByteBuffer[] yuvPlanes;
        private int[] yuvStrides;

        public DefaultVideoFrame(ByteBuffer[] byteBufferArr, int[] iArr, int i8, int i9, int i10, int i11) {
            int length = byteBufferArr.length;
            this.yuvPlanes = new ByteBuffer[length];
            for (int i12 = 0; i12 < length; i12++) {
                this.yuvPlanes[i12] = byteBufferArr[i12].duplicate();
            }
            this.yuvStrides = iArr;
            this.width = i8;
            this.height = i9;
            this.rotationDegreesCw = i10;
            this.colorFormat = i11;
        }

        @Override // com.sinch.android.rtc.video.VideoFrame
        public int getColorFormat() {
            return this.colorFormat;
        }

        @Override // com.sinch.android.rtc.video.VideoFrame
        public int getRotation() {
            return this.rotationDegreesCw;
        }

        @Override // com.sinch.android.rtc.video.VideoFrame
        public int height() {
            return this.height;
        }

        @Override // com.sinch.android.rtc.video.VideoFrame
        public int width() {
            return this.width;
        }

        @Override // com.sinch.android.rtc.video.VideoFrame
        public ByteBuffer[] yuvPlanes() {
            return this.yuvPlanes;
        }

        @Override // com.sinch.android.rtc.video.VideoFrame
        public int[] yuvStrides() {
            return this.yuvStrides;
        }
    }

    int getColorFormat();

    int getRotation();

    int height();

    int width();

    ByteBuffer[] yuvPlanes();

    int[] yuvStrides();
}
