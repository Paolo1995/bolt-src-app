package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputArrays.kt */
/* loaded from: classes5.dex */
public final class InputArraysKt {
    public static final void a(Input input, Buffer dst, int i8) {
        boolean z7;
        Intrinsics.f(input, "<this>");
        Intrinsics.f(dst, "dst");
        boolean z8 = true;
        ChunkBuffer b8 = UnsafeKt.b(input, 1);
        if (b8 != null) {
            while (true) {
                try {
                    int min = Math.min(i8, b8.k() - b8.i());
                    BufferPrimitivesKt.a(b8, dst, min);
                    i8 -= min;
                    if (i8 > 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7) {
                        break;
                    }
                    try {
                        ChunkBuffer c8 = UnsafeKt.c(input, b8);
                        if (c8 == null) {
                            z8 = false;
                            break;
                        }
                        b8 = c8;
                    } catch (Throwable th) {
                        th = th;
                        z8 = false;
                        if (z8) {
                            UnsafeKt.a(input, b8);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z8) {
                UnsafeKt.a(input, b8);
            }
        }
        if (i8 <= 0) {
            return;
        }
        StringsKt.a(i8);
        throw new KotlinNothingValueException();
    }

    public static final void b(Input input, byte[] dst, int i8, int i9) {
        boolean z7;
        Intrinsics.f(input, "<this>");
        Intrinsics.f(dst, "dst");
        boolean z8 = true;
        ChunkBuffer b8 = UnsafeKt.b(input, 1);
        if (b8 != null) {
            while (true) {
                try {
                    int min = Math.min(i9, b8.k() - b8.i());
                    BufferPrimitivesKt.b(b8, dst, i8, min);
                    i9 -= min;
                    i8 += min;
                    if (i9 > 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7) {
                        break;
                    }
                    try {
                        ChunkBuffer c8 = UnsafeKt.c(input, b8);
                        if (c8 == null) {
                            z8 = false;
                            break;
                        }
                        b8 = c8;
                    } catch (Throwable th) {
                        th = th;
                        z8 = false;
                        if (z8) {
                            UnsafeKt.a(input, b8);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z8) {
                UnsafeKt.a(input, b8);
            }
        }
        if (i9 <= 0) {
            return;
        }
        StringsKt.a(i9);
        throw new KotlinNothingValueException();
    }
}
