package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* compiled from: ByteReadChannelJVM.kt */
/* loaded from: classes5.dex */
public interface ByteReadChannel {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f47328a = Companion.f47329a;

    /* compiled from: ByteReadChannelJVM.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f47329a = new Companion();

        /* renamed from: b  reason: collision with root package name */
        private static final Lazy<ByteChannel> f47330b = LazyKt.b(new Function0<ByteChannel>() { // from class: io.ktor.utils.io.ByteReadChannel$Companion$Empty$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ByteChannel invoke() {
                ByteChannel b8 = ByteChannelKt.b(false, 1, null);
                ByteWriteChannelKt.a(b8);
                return b8;
            }
        });

        private Companion() {
        }

        public final ByteReadChannel a() {
            return f47330b.getValue();
        }
    }

    /* compiled from: ByteReadChannelJVM.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(ByteReadChannel byteReadChannel, long j8, Continuation continuation, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    j8 = Long.MAX_VALUE;
                }
                return byteReadChannel.a(j8, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readRemaining");
        }
    }

    Object a(long j8, Continuation<? super ByteReadPacket> continuation);

    Throwable c();

    int d();

    Object f(long j8, Continuation<? super Long> continuation);

    Object g(byte[] bArr, int i8, int i9, Continuation<? super Integer> continuation);

    boolean h(Throwable th);

    Object l(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation);

    boolean o();
}
