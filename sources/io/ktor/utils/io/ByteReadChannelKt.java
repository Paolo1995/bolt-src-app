package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteReadChannel.kt */
/* loaded from: classes5.dex */
public final class ByteReadChannelKt {
    public static final boolean a(ByteReadChannel byteReadChannel) {
        Intrinsics.f(byteReadChannel, "<this>");
        return byteReadChannel.h(null);
    }

    public static final Object b(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        return byteReadChannel.f(Long.MAX_VALUE, continuation);
    }

    public static final Object c(ByteReadChannel byteReadChannel, byte[] bArr, Continuation<? super Integer> continuation) {
        return byteReadChannel.g(bArr, 0, bArr.length, continuation);
    }
}
