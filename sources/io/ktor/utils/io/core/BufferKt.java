package io.ktor.utils.io.core;

import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffer.kt */
/* loaded from: classes5.dex */
public final class BufferKt {
    public static final Void a(int i8, int i9) {
        throw new EOFException("Unable to discard " + i8 + " bytes: only " + i9 + " available for writing");
    }

    public static final Void b(int i8, int i9) {
        throw new EOFException("Unable to discard " + i8 + " bytes: only " + i9 + " available for reading");
    }

    public static final void c(Buffer buffer, int i8) {
        Intrinsics.f(buffer, "<this>");
        throw new IllegalArgumentException("End gap " + i8 + " is too big: capacity is " + buffer.f());
    }

    public static final void d(Buffer buffer, int i8) {
        Intrinsics.f(buffer, "<this>");
        throw new IllegalArgumentException("Unable to reserve end gap " + i8 + ": there are already " + (buffer.k() - buffer.i()) + " content bytes at offset " + buffer.i());
    }

    public static final void e(Buffer buffer, int i8) {
        Intrinsics.f(buffer, "<this>");
        throw new IllegalArgumentException("End gap " + i8 + " is too big: there are already " + buffer.j() + " bytes reserved in the beginning");
    }

    public static final void f(Buffer buffer, int i8) {
        Intrinsics.f(buffer, "<this>");
        buffer.o(buffer.i() - i8);
    }

    public static final Void g(Buffer buffer, int i8) {
        Intrinsics.f(buffer, "<this>");
        throw new IllegalStateException("Unable to reserve " + i8 + " start gap: there are already " + (buffer.k() - buffer.i()) + " content bytes starting at offset " + buffer.i());
    }

    public static final Void h(Buffer buffer, int i8) {
        Intrinsics.f(buffer, "<this>");
        if (i8 > buffer.f()) {
            throw new IllegalArgumentException("Start gap " + i8 + " is bigger than the capacity " + buffer.f());
        }
        throw new IllegalStateException("Unable to reserve " + i8 + " start gap: there are already " + (buffer.f() - buffer.g()) + " bytes reserved in the end");
    }
}
