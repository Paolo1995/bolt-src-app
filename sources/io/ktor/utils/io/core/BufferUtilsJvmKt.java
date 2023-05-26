package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.MemoryJvmKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferUtilsJvm.kt */
/* loaded from: classes5.dex */
public final class BufferUtilsJvmKt {
    public static final void a(Buffer buffer, ByteBuffer dst, int i8) {
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(dst, "dst");
        ByteBuffer h8 = buffer.h();
        int i9 = buffer.i();
        if (buffer.k() - i9 >= i8) {
            int limit = dst.limit();
            try {
                dst.limit(dst.position() + i8);
                MemoryJvmKt.a(h8, dst, i9);
                dst.limit(limit);
                Unit unit = Unit.f50853a;
                buffer.c(i8);
                return;
            } catch (Throwable th) {
                dst.limit(limit);
                throw th;
            }
        }
        throw new EOFException("Not enough bytes to read a buffer content of size " + i8 + '.');
    }
}
