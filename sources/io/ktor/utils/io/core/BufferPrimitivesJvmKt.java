package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.MemoryJvmKt;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferPrimitivesJvm.kt */
/* loaded from: classes5.dex */
public final class BufferPrimitivesJvmKt {
    public static final void a(Buffer buffer, ByteBuffer source) {
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(source, "source");
        int remaining = source.remaining();
        ByteBuffer h8 = buffer.h();
        int k8 = buffer.k();
        int g8 = buffer.g() - k8;
        if (g8 >= remaining) {
            MemoryJvmKt.c(source, h8, k8);
            buffer.a(remaining);
            return;
        }
        throw new InsufficientSpaceException("buffer content", remaining, g8);
    }
}
