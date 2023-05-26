package io.ktor.utils.io;

import androidx.concurrent.futures.a;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.AwaitingSlot;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteChannelSequential.kt */
/* loaded from: classes5.dex */
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel {

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f47257h = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesRead");

    /* renamed from: i  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f47258i = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesWritten");

    /* renamed from: j  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f47259j = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_availableForRead");

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f47260k = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "channelSize");

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47261l = AtomicReferenceFieldUpdater.newUpdater(ByteChannelSequentialBase.class, Object.class, "_closed");
    private volatile /* synthetic */ int _availableForRead;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _lastReadView;
    private volatile /* synthetic */ long _totalBytesRead;
    private volatile /* synthetic */ long _totalBytesWritten;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f47262b;

    /* renamed from: c  reason: collision with root package name */
    private final BytePacketBuilder f47263c;
    private volatile /* synthetic */ int channelSize;

    /* renamed from: d  reason: collision with root package name */
    private final ByteReadPacket f47264d;

    /* renamed from: e  reason: collision with root package name */
    private final AwaitingSlot f47265e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f47266f;

    /* renamed from: g  reason: collision with root package name */
    private final BytePacketBuilder f47267g;
    private volatile /* synthetic */ int lastReadAvailable$delegate;
    private volatile /* synthetic */ Object lastReadView$delegate;

    private final void C() {
        ChunkBuffer N = N();
        int M = M() - (N.k() - N.i());
        if (N() != Buffer.f47369g.a()) {
            UnsafeKt.a(this.f47264d, N());
        }
        if (M > 0) {
            u(M);
        }
        V(0);
        W(ChunkBuffer.f47400j.a());
    }

    static /* synthetic */ Object D(ByteChannelSequentialBase byteChannelSequentialBase, long j8, Continuation continuation) {
        long l8 = byteChannelSequentialBase.f47264d.l(j8);
        byteChannelSequentialBase.u((int) l8);
        if (l8 != j8 && !byteChannelSequentialBase.o()) {
            return byteChannelSequentialBase.E(j8, l8, continuation);
        }
        byteChannelSequentialBase.G();
        return Boxing.c(l8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r2.o() == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004c -> B:18:0x004f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E(long r9, long r11, kotlin.coroutines.Continuation<? super java.lang.Long> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1) r0
            int r1 = r0.f47292k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47292k = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            r0.<init>(r8, r13)
        L18:
            java.lang.Object r13 = r0.f47290i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47292k
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            long r9 = r0.f47289h
            long r11 = r0.f47288g
            java.lang.Object r2 = r0.f47287f
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.b(r13)
            r6 = r9
            r9 = r11
            r11 = r6
            goto L4f
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            kotlin.ResultKt.b(r13)
            r2 = r8
        L40:
            r0.f47287f = r2
            r0.f47288g = r9
            r0.f47289h = r11
            r0.f47292k = r3
            java.lang.Object r13 = r2.w(r3, r0)
            if (r13 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L6e
            io.ktor.utils.io.core.ByteReadPacket r13 = r2.f47264d
            long r4 = r9 - r11
            long r4 = r13.l(r4)
            int r13 = (int) r4
            r2.u(r13)
            long r11 = r11 + r4
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 >= 0) goto L6e
            boolean r13 = r2.o()
            if (r13 == 0) goto L40
        L6e:
            r2.G()
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.c(r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.E(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void F() {
        if (L()) {
            Throwable c8 = c();
            if (c8 == null) {
                throw new ClosedWriteChannelException("Channel " + this + " is already closed");
            }
        }
    }

    private final void G() {
        Throwable c8 = c();
        if (c8 == null) {
            return;
        }
        throw c8;
    }

    private final void H(BytePacketBuilder bytePacketBuilder) {
        Throwable c8 = c();
        if (c8 == null) {
            return;
        }
        bytePacketBuilder.release();
        throw c8;
    }

    private final boolean I() {
        if (this.f47263c.R0()) {
            this.f47265e.c();
            return false;
        }
        J();
        this.f47265e.c();
        return true;
    }

    private final void J() {
        synchronized (this.f47266f) {
            int P0 = this.f47263c.P0();
            ChunkBuffer d02 = this.f47263c.d0();
            Intrinsics.c(d02);
            this.f47267g.f0(d02);
            f47259j.addAndGet(this, P0);
        }
    }

    private final int M() {
        return this.lastReadAvailable$delegate;
    }

    private final ChunkBuffer N() {
        return (ChunkBuffer) this.lastReadView$delegate;
    }

    private final boolean O() {
        Throwable th;
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            th = closeElement.a();
        } else {
            th = null;
        }
        if (th != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object S(io.ktor.utils.io.ByteChannelSequentialBase r6, byte[] r7, int r8, int r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4) r0
            int r1 = r0.f47304l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47304l = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.f47302j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47304l
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r6 = r0.f47301i
            int r7 = r0.f47300h
            java.lang.Object r8 = r0.f47299g
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r0.f47298f
            io.ktor.utils.io.ByteChannelSequentialBase r9 = (io.ktor.utils.io.ByteChannelSequentialBase) r9
            kotlin.ResultKt.b(r10)
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L7d
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            kotlin.ResultKt.b(r10)
            java.lang.Throwable r10 = r6.c()
            if (r10 != 0) goto La1
            boolean r10 = r6.L()
            if (r10 == 0) goto L5e
            int r10 = r6.d()
            if (r10 != 0) goto L5e
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r6)
            return r6
        L5e:
            if (r9 != 0) goto L66
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r6)
            return r6
        L66:
            int r10 = r6.d()
            if (r10 != 0) goto L7d
            r0.f47298f = r6
            r0.f47299g = r7
            r0.f47300h = r8
            r0.f47301i = r9
            r0.f47304l = r3
            java.lang.Object r10 = r6.B(r3, r0)
            if (r10 != r1) goto L7d
            return r1
        L7d:
            io.ktor.utils.io.core.ByteReadPacket r10 = r6.f47264d
            boolean r10 = r10.h()
            if (r10 != 0) goto L88
            r6.P()
        L88:
            long r9 = (long) r9
            io.ktor.utils.io.core.ByteReadPacket r0 = r6.f47264d
            long r0 = r0.C0()
            long r9 = java.lang.Math.min(r9, r0)
            int r10 = (int) r9
            io.ktor.utils.io.core.ByteReadPacket r9 = r6.f47264d
            io.ktor.utils.io.core.InputArraysKt.b(r9, r7, r8, r10)
            r6.u(r10)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r10)
            return r6
        La1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.S(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object T(ByteChannelSequentialBase byteChannelSequentialBase, long j8, Continuation continuation) {
        byteChannelSequentialBase.G();
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        long min = Math.min(j8, byteChannelSequentialBase.f47264d.C0());
        bytePacketBuilder.s0(byteChannelSequentialBase.f47264d, min);
        byteChannelSequentialBase.u((int) min);
        if (j8 - bytePacketBuilder.P0() != 0 && !byteChannelSequentialBase.o()) {
            return byteChannelSequentialBase.U(bytePacketBuilder, j8, continuation);
        }
        byteChannelSequentialBase.H(bytePacketBuilder);
        return bytePacketBuilder.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object U(io.ktor.utils.io.core.BytePacketBuilder r11, long r12, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1) r0
            int r1 = r0.f47310k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47310k = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.f47308i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47310k
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            long r11 = r0.f47307h
            java.lang.Object r13 = r0.f47306g
            io.ktor.utils.io.core.BytePacketBuilder r13 = (io.ktor.utils.io.core.BytePacketBuilder) r13
            java.lang.Object r2 = r0.f47305f
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.b(r14)
            r8 = r11
            r11 = r13
            r12 = r8
            goto L42
        L36:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3e:
            kotlin.ResultKt.b(r14)
            r2 = r10
        L42:
            int r14 = r11.P0()
            long r4 = (long) r14
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 >= 0) goto L85
            int r14 = r11.P0()
            long r4 = (long) r14
            long r4 = r12 - r4
            io.ktor.utils.io.core.ByteReadPacket r14 = r2.f47264d
            long r6 = r14.C0()
            long r4 = java.lang.Math.min(r4, r6)
            io.ktor.utils.io.core.ByteReadPacket r14 = r2.f47264d
            r11.s0(r14, r4)
            int r14 = (int) r4
            r2.u(r14)
            r2.H(r11)
            boolean r14 = r2.o()
            if (r14 != 0) goto L85
            int r14 = r11.P0()
            int r4 = (int) r12
            if (r14 != r4) goto L76
            goto L85
        L76:
            r0.f47305f = r2
            r0.f47306g = r11
            r0.f47307h = r12
            r0.f47310k = r3
            java.lang.Object r14 = r2.B(r3, r0)
            if (r14 != r1) goto L42
            return r1
        L85:
            r2.H(r11)
            io.ktor.utils.io.core.ByteReadPacket r11 = r11.K0()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.U(io.ktor.utils.io.core.BytePacketBuilder, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void V(int i8) {
        this.lastReadAvailable$delegate = i8;
    }

    private final void W(ChunkBuffer chunkBuffer) {
        this.lastReadView$delegate = chunkBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object Y(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1) r0
            int r1 = r0.f47315j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47315j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f47313h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47315j
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.f47312g
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
            java.lang.Object r4 = r0.f47311f
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.b(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.b(r6)
            r0.f47311f = r4
            r0.f47312g = r5
            r0.f47315j = r3
            java.lang.Object r6 = r4.z(r3, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            int r6 = r5.k()
            int r0 = r5.i()
            int r6 = r6 - r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.f47263c
            r1 = 0
            r2 = 2
            r3 = 0
            io.ktor.utils.io.core.OutputKt.c(r0, r5, r1, r2, r3)
            r4.v(r6)
            kotlin.Unit r4 = kotlin.Unit.f50853a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.Y(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:19:0x005c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object Z(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2) r0
            int r1 = r0.f47322l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47322l = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f47320j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47322l
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            int r5 = r0.f47319i
            int r6 = r0.f47318h
            java.lang.Object r7 = r0.f47317g
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.f47316f
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.b(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L5c
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.b(r9)
            int r8 = r8 + r7
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r4
        L49:
            if (r8 >= r5) goto L70
            r0.f47316f = r6
            r0.f47317g = r7
            r0.f47318h = r8
            r0.f47319i = r5
            r0.f47322l = r3
            java.lang.Object r9 = r6.z(r3, r0)
            if (r9 != r1) goto L5c
            return r1
        L5c:
            int r9 = r6.K()
            int r2 = r5 - r8
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r6.f47263c
            io.ktor.utils.io.core.OutputKt.b(r2, r7, r8, r9)
            int r8 = r8 + r9
            r6.v(r9)
            goto L49
        L70:
            kotlin.Unit r5 = kotlin.Unit.f50853a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.Z(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object a0(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.ByteReadPacket r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1) r0
            int r1 = r0.f47327j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47327j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f47325h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47327j
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.f47324g
            r5 = r4
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            java.lang.Object r4 = r0.f47323f
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.b(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.b(r6)
            r0.f47323f = r4
            r0.f47324g = r5
            r0.f47327j = r3
            java.lang.Object r6 = r4.z(r3, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            long r0 = r5.C0()
            int r6 = (int) r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.f47263c
            r0.k0(r5)
            r4.v(r6)
            kotlin.Unit r4 = kotlin.Unit.f50853a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.a0(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void s(int i8) {
        boolean z7;
        boolean z8;
        boolean z9 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i9 = -i8;
            f47260k.getAndAdd(this, i9);
            f47257h.addAndGet(this, i8);
            f47259j.getAndAdd(this, i9);
            if (this.channelSize >= 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (d() < 0) {
                    z9 = false;
                }
                if (z9) {
                    return;
                }
                throw new IllegalStateException(("Readable bytes count is negative: " + d() + ", " + i8 + " in " + this).toString());
            }
            throw new IllegalStateException(("Readable bytes count is negative: " + d() + ", " + i8 + " in " + this).toString());
        }
        throw new IllegalArgumentException(("Can't read negative amount of bytes: " + i8).toString());
    }

    private final void t(int i8) {
        boolean z7;
        boolean z8 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            f47260k.getAndAdd(this, i8);
            f47258i.addAndGet(this, i8);
            if (this.channelSize < 0) {
                z8 = false;
            }
            if (z8) {
                return;
            }
            throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", " + i8 + " in " + this).toString());
        }
        throw new IllegalArgumentException(("Can't write negative amount of bytes: " + i8).toString());
    }

    static /* synthetic */ Object x(ByteChannelSequentialBase byteChannelSequentialBase, int i8, Continuation continuation) {
        boolean z7;
        boolean z8 = false;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            long j8 = i8;
            if (j8 <= 4088) {
                z8 = true;
            }
            if (z8) {
                byteChannelSequentialBase.C();
                if (i8 == 0) {
                    return Boxing.a(!byteChannelSequentialBase.o());
                }
                if (byteChannelSequentialBase.f47264d.C0() >= j8) {
                    return Boxing.a(true);
                }
                return byteChannelSequentialBase.B(i8, continuation);
            }
            throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i8).toString());
        }
        throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i8).toString());
    }

    public final Object A(Continuation<? super Boolean> continuation) {
        if (!this.f47264d.c0()) {
            return Boxing.a(true);
        }
        return B(1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object B(int r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1) r0
            int r1 = r0.f47286j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47286j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f47284h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47286j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            int r6 = r0.f47283g
            java.lang.Object r0 = r0.f47282f
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.b(r7)
            goto L50
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.b(r7)
            if (r6 < 0) goto L3f
            r7 = 1
            goto L40
        L3f:
            r7 = 0
        L40:
            if (r7 == 0) goto L6c
            r0.f47282f = r5
            r0.f47283g = r6
            r0.f47286j = r4
            java.lang.Object r7 = r5.y(r6, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            r0 = r5
        L50:
            r0.P()
            java.lang.Throwable r7 = r0.c()
            if (r7 != 0) goto L6b
            boolean r7 = r0.o()
            if (r7 != 0) goto L66
            int r7 = r0.d()
            if (r7 < r6) goto L66
            r3 = 1
        L66:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r6
        L6b:
            throw r7
        L6c:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Failed requirement."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.B(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public int K() {
        return Math.max(0, 4088 - this.channelSize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean L() {
        if (this._closed != null) {
            return true;
        }
        return false;
    }

    protected final void P() {
        synchronized (this.f47266f) {
            UnsafeKt.e(this.f47264d, this.f47267g);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Q(io.ktor.utils.io.core.Buffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2) r0
            int r1 = r0.f47297j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47297j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f47295h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47297j
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.f47294g
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6
            java.lang.Object r0 = r0.f47293f
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.b(r7)
            goto L79
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.b(r7)
            java.lang.Throwable r7 = r5.c()
            if (r7 != 0) goto La6
            boolean r7 = r5.L()
            if (r7 == 0) goto L54
            int r7 = r5.d()
            if (r7 != 0) goto L54
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r6)
            return r6
        L54:
            int r7 = r6.g()
            int r2 = r6.k()
            int r7 = r7 - r2
            if (r7 != 0) goto L65
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r6)
            return r6
        L65:
            int r7 = r5.d()
            if (r7 != 0) goto L78
            r0.f47293f = r5
            r0.f47294g = r6
            r0.f47297j = r3
            java.lang.Object r7 = r5.B(r3, r0)
            if (r7 != r1) goto L78
            return r1
        L78:
            r0 = r5
        L79:
            io.ktor.utils.io.core.ByteReadPacket r7 = r0.f47264d
            boolean r7 = r7.h()
            if (r7 != 0) goto L84
            r0.P()
        L84:
            int r7 = r6.g()
            int r1 = r6.k()
            int r7 = r7 - r1
            long r1 = (long) r7
            io.ktor.utils.io.core.ByteReadPacket r7 = r0.f47264d
            long r3 = r7.C0()
            long r1 = java.lang.Math.min(r1, r3)
            int r7 = (int) r1
            io.ktor.utils.io.core.ByteReadPacket r1 = r0.f47264d
            io.ktor.utils.io.core.InputArraysKt.a(r1, r6, r7)
            r0.u(r7)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r7)
            return r6
        La6:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.Q(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long X(ByteChannelSequentialBase dst, long j8) {
        Intrinsics.f(dst, "dst");
        long C0 = this.f47264d.C0();
        if (C0 <= j8) {
            dst.f47263c.k0(this.f47264d);
            int i8 = (int) C0;
            dst.v(i8);
            u(i8);
            return C0;
        }
        return 0L;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object a(long j8, Continuation<? super ByteReadPacket> continuation) {
        return T(this, j8, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean b(Throwable th) {
        CloseElement closeElement;
        if (th == null) {
            closeElement = CloseElementKt.a();
        } else {
            closeElement = new CloseElement(th);
        }
        if (!a.a(f47261l, this, null, closeElement)) {
            return false;
        }
        if (th != null) {
            this.f47264d.release();
            this.f47263c.release();
            this.f47267g.release();
        } else {
            flush();
        }
        this.f47265e.b(th);
        return true;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public final Throwable c() {
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            return closeElement.a();
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public int d() {
        return this._availableForRead;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean e() {
        return L();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object f(long j8, Continuation<? super Long> continuation) {
        return D(this, j8, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void flush() {
        I();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object g(byte[] bArr, int i8, int i9, Continuation<? super Integer> continuation) {
        return S(this, bArr, i8, i9, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean h(Throwable th) {
        if (c() == null && !L()) {
            if (th == null) {
                th = new CancellationException("Channel cancelled");
            }
            return b(th);
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object i(byte[] bArr, int i8, int i9, Continuation<? super Unit> continuation) {
        return Z(this, bArr, i8, i9, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object k(Buffer buffer, Continuation<? super Unit> continuation) {
        return Y(this, buffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object l(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return Q(chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object m(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        return a0(this, byteReadPacket, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean o() {
        if (!O() && (!L() || this.channelSize != 0)) {
            return false;
        }
        return true;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean p() {
        return this.f47262b;
    }

    protected final void u(int i8) {
        s(i8);
        this.f47265e.c();
    }

    protected final void v(int i8) {
        t(i8);
        if (L()) {
            this.f47263c.release();
            F();
        }
        if (p() || K() == 0) {
            flush();
        }
    }

    public Object w(int i8, Continuation<? super Boolean> continuation) {
        return x(this, i8, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(final int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) r0
            int r1 = r0.f47272j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47272j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f47270h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47272j
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r6 = r0.f47269g
            java.lang.Object r2 = r0.f47268f
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.b(r7)
            goto L3b
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.b(r7)
            r2 = r5
        L3b:
            int r7 = r2.d()
            if (r7 >= r6) goto L5b
            boolean r7 = r2.o()
            if (r7 != 0) goto L5b
            io.ktor.utils.io.internal.AwaitingSlot r7 = r2.f47265e
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2
            r4.<init>()
            r0.f47268f = r2
            r0.f47269g = r6
            r0.f47272j = r3
            java.lang.Object r7 = r7.d(r4, r0)
            if (r7 != r1) goto L3b
            return r1
        L5b:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.y(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object z(final int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) r0
            int r1 = r0.f47279j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47279j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f47277h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47279j
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r6 = r0.f47276g
            java.lang.Object r2 = r0.f47275f
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.b(r7)
            goto L3b
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.b(r7)
            r2 = r5
        L3b:
            int r7 = r2.K()
            if (r7 >= r6) goto L61
            boolean r7 = r2.L()
            if (r7 != 0) goto L61
            boolean r7 = r2.I()
            if (r7 != 0) goto L3b
            io.ktor.utils.io.internal.AwaitingSlot r7 = r2.f47265e
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2
            r4.<init>()
            r0.f47275f = r2
            r0.f47276g = r6
            r0.f47279j = r3
            java.lang.Object r7 = r7.d(r4, r0)
            if (r7 != r1) goto L3b
            return r1
        L61:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.z(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
