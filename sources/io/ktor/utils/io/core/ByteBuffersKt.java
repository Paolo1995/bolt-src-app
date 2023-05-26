package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteBuffers.kt */
/* loaded from: classes5.dex */
public final class ByteBuffersKt {
    private static final int a(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer, int i8) {
        while (byteBuffer.hasRemaining()) {
            ChunkBuffer P0 = byteReadPacket.P0(1);
            if (P0 == null) {
                return i8;
            }
            int remaining = byteBuffer.remaining();
            int k8 = P0.k() - P0.i();
            if (remaining >= k8) {
                BufferUtilsJvmKt.a(P0, byteBuffer, k8);
                byteReadPacket.c1(P0);
                i8 += k8;
            } else {
                BufferUtilsJvmKt.a(P0, byteBuffer, remaining);
                byteReadPacket.f1(P0.i());
                return i8 + remaining;
            }
        }
        return i8;
    }

    public static final int b(ByteReadPacket byteReadPacket, ByteBuffer dst) {
        Intrinsics.f(byteReadPacket, "<this>");
        Intrinsics.f(dst, "dst");
        int a8 = a(byteReadPacket, dst, 0);
        if (!dst.hasRemaining()) {
            return a8;
        }
        throw new EOFException("Not enough data in packet to fill buffer: " + dst.remaining() + " more bytes required");
    }
}
