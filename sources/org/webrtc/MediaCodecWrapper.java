package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
interface MediaCodecWrapper {
    void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i8);

    Surface createInputSurface();

    int dequeueInputBuffer(long j8);

    int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j8);

    void flush();

    ByteBuffer getInputBuffer(int i8);

    MediaFormat getInputFormat();

    ByteBuffer getOutputBuffer(int i8);

    MediaFormat getOutputFormat();

    void queueInputBuffer(int i8, int i9, int i10, long j8, int i11);

    void release();

    void releaseOutputBuffer(int i8, boolean z7);

    void setParameters(Bundle bundle);

    void start();

    void stop();
}
