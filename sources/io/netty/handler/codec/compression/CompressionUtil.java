package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
final class CompressionUtil {
    private CompressionUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer safeNioBuffer(ByteBuf byteBuf, int i8, int i9) {
        if (byteBuf.nioBufferCount() == 1) {
            return byteBuf.internalNioBuffer(i8, i9);
        }
        return byteBuf.nioBuffer(i8, i9);
    }
}
