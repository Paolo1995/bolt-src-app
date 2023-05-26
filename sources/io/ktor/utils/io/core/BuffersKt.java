package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffers.kt */
/* loaded from: classes5.dex */
public final class BuffersKt {
    public static final ChunkBuffer a(ChunkBuffer chunkBuffer) {
        Intrinsics.f(chunkBuffer, "<this>");
        ChunkBuffer A = chunkBuffer.A();
        ChunkBuffer B = chunkBuffer.B();
        if (B == null) {
            return A;
        }
        return b(B, A, A);
    }

    private static final ChunkBuffer b(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, ChunkBuffer chunkBuffer3) {
        while (true) {
            ChunkBuffer A = chunkBuffer.A();
            chunkBuffer3.G(A);
            chunkBuffer = chunkBuffer.B();
            if (chunkBuffer == null) {
                return chunkBuffer2;
            }
            chunkBuffer3 = A;
        }
    }

    public static final ChunkBuffer c(ChunkBuffer chunkBuffer) {
        Intrinsics.f(chunkBuffer, "<this>");
        while (true) {
            ChunkBuffer B = chunkBuffer.B();
            if (B == null) {
                return chunkBuffer;
            }
            chunkBuffer = B;
        }
    }

    public static final void d(ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.f(pool, "pool");
        while (chunkBuffer != null) {
            ChunkBuffer z7 = chunkBuffer.z();
            chunkBuffer.E(pool);
            chunkBuffer = z7;
        }
    }

    public static final long e(ChunkBuffer chunkBuffer) {
        Intrinsics.f(chunkBuffer, "<this>");
        return f(chunkBuffer, 0L);
    }

    private static final long f(ChunkBuffer chunkBuffer, long j8) {
        do {
            j8 += chunkBuffer.k() - chunkBuffer.i();
            chunkBuffer = chunkBuffer.B();
        } while (chunkBuffer != null);
        return j8;
    }
}
