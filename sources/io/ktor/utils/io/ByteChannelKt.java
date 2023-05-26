package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteChannel.kt */
/* loaded from: classes5.dex */
public final class ByteChannelKt {
    public static final ByteChannel a(boolean z7) {
        return new ByteBufferChannel(z7, null, 0, 6, null);
    }

    public static /* synthetic */ ByteChannel b(boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return a(z7);
    }

    public static final ByteReadChannel c(byte[] content, int i8, int i9) {
        Intrinsics.f(content, "content");
        ByteBuffer wrap = ByteBuffer.wrap(content, i8, i9);
        Intrinsics.e(wrap, "wrap(content, offset, length)");
        return new ByteBufferChannel(wrap);
    }
}
