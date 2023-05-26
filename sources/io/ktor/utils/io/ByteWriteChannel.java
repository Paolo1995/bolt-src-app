package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: ByteWriteChannel.kt */
/* loaded from: classes5.dex */
public interface ByteWriteChannel {

    /* compiled from: ByteWriteChannel.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(ByteWriteChannel byteWriteChannel, int i8, Function1 function1, Continuation continuation, int i9, Object obj) {
            if (obj == null) {
                if ((i9 & 1) != 0) {
                    i8 = 1;
                }
                return byteWriteChannel.n(i8, function1, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
    }

    boolean b(Throwable th);

    boolean e();

    void flush();

    Object i(byte[] bArr, int i8, int i9, Continuation<? super Unit> continuation);

    Object k(Buffer buffer, Continuation<? super Unit> continuation);

    Object m(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation);

    Object n(int i8, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation);

    boolean p();
}
