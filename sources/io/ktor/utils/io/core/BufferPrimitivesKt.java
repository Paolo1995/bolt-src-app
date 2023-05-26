package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferPrimitives.kt */
/* loaded from: classes5.dex */
public final class BufferPrimitivesKt {
    public static final int a(Buffer buffer, Buffer dst, int i8) {
        boolean z7;
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(dst, "dst");
        boolean z8 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 > dst.g() - dst.k()) {
                z8 = false;
            }
            if (z8) {
                ByteBuffer h8 = buffer.h();
                int i9 = buffer.i();
                if (buffer.k() - i9 >= i8) {
                    Memory.c(h8, dst.h(), i9, i8, dst.k());
                    dst.a(i8);
                    Unit unit = Unit.f50853a;
                    buffer.c(i8);
                    return i8;
                }
                throw new EOFException("Not enough bytes to read a buffer content of size " + i8 + '.');
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final void b(Buffer buffer, byte[] destination, int i8, int i9) {
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(destination, "destination");
        ByteBuffer h8 = buffer.h();
        int i10 = buffer.i();
        if (buffer.k() - i10 >= i9) {
            MemoryJvmKt.b(h8, destination, i10, i9, i8);
            Unit unit = Unit.f50853a;
            buffer.c(i9);
            return;
        }
        throw new EOFException("Not enough bytes to read a byte array of size " + i9 + '.');
    }

    public static final short c(Buffer buffer) {
        Intrinsics.f(buffer, "<this>");
        ByteBuffer h8 = buffer.h();
        int i8 = buffer.i();
        if (buffer.k() - i8 >= 2) {
            Short valueOf = Short.valueOf(h8.getShort(i8));
            buffer.c(2);
            return valueOf.shortValue();
        }
        throw new EOFException("Not enough bytes to read a short integer of size 2.");
    }

    public static final void d(Buffer buffer, Buffer src, int i8) {
        boolean z7;
        boolean z8;
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(src, "src");
        boolean z9 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 <= src.k() - src.i()) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (i8 > buffer.g() - buffer.k()) {
                    z9 = false;
                }
                if (z9) {
                    ByteBuffer h8 = buffer.h();
                    int k8 = buffer.k();
                    int g8 = buffer.g() - k8;
                    if (g8 >= i8) {
                        Memory.c(src.h(), h8, src.i(), i8, k8);
                        src.c(i8);
                        buffer.a(i8);
                        return;
                    }
                    throw new InsufficientSpaceException("buffer readable content", i8, g8);
                }
                throw new IllegalArgumentException(("length shouldn't be greater than the destination write remaining space: " + i8 + " > " + (buffer.g() - buffer.k())).toString());
            }
            throw new IllegalArgumentException(("length shouldn't be greater than the source read remaining: " + i8 + " > " + (src.k() - src.i())).toString());
        }
        throw new IllegalArgumentException(("length shouldn't be negative: " + i8).toString());
    }

    public static final void e(Buffer buffer, byte[] source, int i8, int i9) {
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(source, "source");
        ByteBuffer h8 = buffer.h();
        int k8 = buffer.k();
        int g8 = buffer.g() - k8;
        if (g8 >= i9) {
            ByteBuffer order = ByteBuffer.wrap(source, i8, i9).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.e(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.c(Memory.b(order), h8, 0, i9, k8);
            buffer.a(i9);
            return;
        }
        throw new InsufficientSpaceException("byte array", i9, g8);
    }

    public static final void f(Buffer buffer, short s7) {
        Intrinsics.f(buffer, "<this>");
        ByteBuffer h8 = buffer.h();
        int k8 = buffer.k();
        int g8 = buffer.g() - k8;
        if (g8 >= 2) {
            h8.putShort(k8, s7);
            buffer.a(2);
            return;
        }
        throw new InsufficientSpaceException("short integer", 2, g8);
    }
}
