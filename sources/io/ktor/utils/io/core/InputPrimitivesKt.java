package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputPrimitives.kt */
/* loaded from: classes5.dex */
public final class InputPrimitivesKt {
    public static final short a(Input input) {
        Intrinsics.f(input, "<this>");
        if (input.f0() - input.s0() > 2) {
            int s02 = input.s0();
            input.f1(s02 + 2);
            return input.k0().getShort(s02);
        }
        return b(input);
    }

    private static final short b(Input input) {
        ChunkBuffer b8 = UnsafeKt.b(input, 2);
        if (b8 != null) {
            short c8 = BufferPrimitivesKt.c(b8);
            UnsafeKt.a(input, b8);
            return c8;
        }
        StringsKt.a(2);
        throw new KotlinNothingValueException();
    }
}
