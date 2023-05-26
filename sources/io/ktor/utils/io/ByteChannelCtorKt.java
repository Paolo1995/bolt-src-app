package io.ktor.utils.io;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteChannelCtor.kt */
/* loaded from: classes5.dex */
public final class ByteChannelCtorKt {
    public static final ByteReadChannel a(byte[] content) {
        Intrinsics.f(content, "content");
        return ByteChannelKt.c(content, 0, content.length);
    }
}
