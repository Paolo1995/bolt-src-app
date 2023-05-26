package io.ktor.utils.io.core.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChunkBuffer.kt */
/* loaded from: classes5.dex */
public final class ChunkBufferKt {
    public static final boolean a(ChunkBuffer chunkBuffer) {
        Intrinsics.f(chunkBuffer, "<this>");
        if (chunkBuffer.D() == 1) {
            return true;
        }
        return false;
    }
}
