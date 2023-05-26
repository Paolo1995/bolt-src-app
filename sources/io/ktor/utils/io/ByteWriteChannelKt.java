package io.ktor.utils.io;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteWriteChannel.kt */
/* loaded from: classes5.dex */
public final class ByteWriteChannelKt {
    public static final boolean a(ByteWriteChannel byteWriteChannel) {
        Intrinsics.f(byteWriteChannel, "<this>");
        return byteWriteChannel.b(null);
    }

    public static final Object b(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Object d8;
        Object i8 = byteWriteChannel.i(bArr, 0, bArr.length, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (i8 == d8) {
            return i8;
        }
        return Unit.f50853a;
    }
}
