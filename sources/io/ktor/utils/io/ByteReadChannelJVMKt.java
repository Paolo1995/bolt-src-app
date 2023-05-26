package io.ktor.utils.io;

import io.ktor.utils.io.internal.SequentialCopyToKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: ByteReadChannelJVM.kt */
/* loaded from: classes5.dex */
public final class ByteReadChannelJVMKt {
    public static final Object b(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j8, Continuation<? super Long> continuation) {
        boolean z7;
        if (byteReadChannel != byteWriteChannel) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (j8 == 0) {
                return Boxing.c(0L);
            }
            if ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) {
                return ((ByteBufferChannel) byteWriteChannel).P((ByteBufferChannel) byteReadChannel, j8, null, continuation);
            }
            if ((byteReadChannel instanceof ByteChannelSequentialBase) && (byteWriteChannel instanceof ByteChannelSequentialBase)) {
                return SequentialCopyToKt.b((ByteChannelSequentialBase) byteReadChannel, (ByteChannelSequentialBase) byteWriteChannel, Long.MAX_VALUE, continuation);
            }
            return c(byteReadChannel, byteWriteChannel, j8, continuation);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097 A[Catch: all -> 0x00ff, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00ff, blocks: (B:37:0x00f5, B:39:0x00fb, B:25:0x0097), top: B:56:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #2 {all -> 0x006f, blocks: (B:13:0x0040, B:29:0x00c7, B:31:0x00d0, B:46:0x010f, B:18:0x006b), top: B:58:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e7 -> B:35:0x00f1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(io.ktor.utils.io.ByteReadChannel r21, io.ktor.utils.io.ByteWriteChannel r22, long r23, kotlin.coroutines.Continuation<? super java.lang.Long> r25) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelJVMKt.c(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
