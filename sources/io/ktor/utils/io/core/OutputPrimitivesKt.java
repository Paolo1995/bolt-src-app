package io.ktor.utils.io.core;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutputPrimitives.kt */
/* loaded from: classes5.dex */
public final class OutputPrimitivesKt {
    public static final void a(Output output, short s7) {
        boolean z7;
        Intrinsics.f(output, "<this>");
        int X = output.X();
        if (output.N() - X > 2) {
            output.c0(X + 2);
            output.O().putShort(X, s7);
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            b(output, s7);
        }
    }

    private static final void b(Output output, short s7) {
        BufferPrimitivesKt.f(output.Z(2), s7);
        output.c();
    }
}
