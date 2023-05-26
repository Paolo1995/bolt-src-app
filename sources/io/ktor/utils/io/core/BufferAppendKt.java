package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferAppend.kt */
/* loaded from: classes5.dex */
public final class BufferAppendKt {
    public static final int a(Buffer buffer, Buffer other, int i8) {
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(other, "other");
        int min = Math.min(other.k() - other.i(), i8);
        if (buffer.g() - buffer.k() <= min) {
            b(buffer, min);
        }
        ByteBuffer h8 = buffer.h();
        int k8 = buffer.k();
        buffer.g();
        ByteBuffer h9 = other.h();
        int i9 = other.i();
        other.k();
        Memory.c(h9, h8, i9, min, k8);
        other.c(min);
        buffer.a(min);
        return min;
    }

    private static final void b(Buffer buffer, int i8) {
        if ((buffer.g() - buffer.k()) + (buffer.f() - buffer.g()) >= i8) {
            if ((buffer.k() + i8) - buffer.g() > 0) {
                buffer.m();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
    }

    public static final int c(Buffer buffer, Buffer other) {
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(other, "other");
        int k8 = other.k() - other.i();
        int i8 = buffer.i();
        if (i8 >= k8) {
            int i9 = i8 - k8;
            Memory.c(other.h(), buffer.h(), other.i(), k8, i9);
            other.c(k8);
            buffer.o(i9);
            return k8;
        }
        throw new IllegalArgumentException("Not enough space in the beginning to prepend bytes");
    }
}
