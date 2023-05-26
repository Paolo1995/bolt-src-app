package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Output.kt */
/* loaded from: classes5.dex */
public final class OutputKt {
    public static final void a(Output output, Buffer src, int i8) {
        boolean z7;
        Intrinsics.f(output, "<this>");
        Intrinsics.f(src, "src");
        ChunkBuffer d8 = UnsafeKt.d(output, 1, null);
        while (true) {
            try {
                int min = Math.min(i8, d8.g() - d8.k());
                BufferPrimitivesKt.d(d8, src, min);
                i8 -= min;
                if (i8 > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    d8 = UnsafeKt.d(output, 1, d8);
                } else {
                    return;
                }
            } finally {
                output.c();
            }
        }
    }

    public static final void b(Output output, byte[] src, int i8, int i9) {
        boolean z7;
        Intrinsics.f(output, "<this>");
        Intrinsics.f(src, "src");
        ChunkBuffer d8 = UnsafeKt.d(output, 1, null);
        while (true) {
            try {
                int min = Math.min(i9, d8.g() - d8.k());
                BufferPrimitivesKt.e(d8, src, i8, min);
                i8 += min;
                i9 -= min;
                if (i9 > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    d8 = UnsafeKt.d(output, 1, d8);
                } else {
                    return;
                }
            } finally {
                output.c();
            }
        }
    }

    public static /* synthetic */ void c(Output output, Buffer buffer, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = buffer.k() - buffer.i();
        }
        a(output, buffer, i8);
    }

    public static /* synthetic */ void d(Output output, byte[] bArr, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = bArr.length - i8;
        }
        b(output, bArr, i8, i9);
    }
}
