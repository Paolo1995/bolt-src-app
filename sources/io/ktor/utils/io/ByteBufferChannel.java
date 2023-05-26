package io.ktor.utils.io;

import androidx.concurrent.futures.a;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.CancellableReusableContinuation;
import io.ktor.utils.io.internal.ClosedElement;
import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.ObjectPoolKt;
import io.ktor.utils.io.internal.ReadSessionImpl;
import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.internal.RingBufferCapacity;
import io.ktor.utils.io.internal.WriteSessionImpl;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.Job;

/* compiled from: ByteBufferChannel.kt */
/* loaded from: classes5.dex */
public class ByteBufferChannel implements ByteChannel, ByteReadChannel, ByteWriteChannel {

    /* renamed from: l  reason: collision with root package name */
    public static final Companion f47147l = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47148m = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_state");

    /* renamed from: n  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47149n = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_closed");

    /* renamed from: o  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f47150o = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_readOp");

    /* renamed from: p  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f47151p = AtomicReferenceFieldUpdater.newUpdater(ByteBufferChannel.class, Object.class, "_writeOp");
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _readOp;
    private volatile /* synthetic */ Object _state;
    volatile /* synthetic */ Object _writeOp;
    private volatile Job attachedJob;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f47152b;

    /* renamed from: c  reason: collision with root package name */
    private final ObjectPool<ReadWriteBufferState.Initial> f47153c;

    /* renamed from: d  reason: collision with root package name */
    private final int f47154d;

    /* renamed from: e  reason: collision with root package name */
    private int f47155e;

    /* renamed from: f  reason: collision with root package name */
    private int f47156f;

    /* renamed from: g  reason: collision with root package name */
    private final ReadSessionImpl f47157g;

    /* renamed from: h  reason: collision with root package name */
    private final WriteSessionImpl f47158h;

    /* renamed from: i  reason: collision with root package name */
    private final CancellableReusableContinuation<Boolean> f47159i;

    /* renamed from: j  reason: collision with root package name */
    private final CancellableReusableContinuation<Unit> f47160j;
    private volatile JoiningState joining;

    /* renamed from: k  reason: collision with root package name */
    private final Function1<Continuation<? super Unit>, Object> f47161k;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private volatile int writeSuspensionSize;

    /* compiled from: ByteBufferChannel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ByteBufferChannel(boolean z7, ObjectPool<ReadWriteBufferState.Initial> pool, int i8) {
        Intrinsics.f(pool, "pool");
        this.f47152b = z7;
        this.f47153c = pool;
        this.f47154d = i8;
        this._state = ReadWriteBufferState.IdleEmpty.f47441c;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.f47157g = new ReadSessionImpl(this);
        this.f47158h = new WriteSessionImpl(this);
        this.f47159i = new CancellableReusableContinuation<>();
        this.f47160j = new CancellableReusableContinuation<>();
        this.f47161k = new Function1<Continuation<? super Unit>, Object>() { // from class: io.ktor.utils.io.ByteBufferChannel$writeSuspension$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
                r5 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x0069, code lost:
                continue;
             */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
                /*
                    r9 = this;
                    java.lang.String r0 = "ucont"
                    kotlin.jvm.internal.Intrinsics.f(r10, r0)
                    io.ktor.utils.io.ByteBufferChannel r0 = io.ktor.utils.io.ByteBufferChannel.this
                    int r0 = io.ktor.utils.io.ByteBufferChannel.v(r0)
                Lb:
                    io.ktor.utils.io.ByteBufferChannel r1 = io.ktor.utils.io.ByteBufferChannel.this
                    io.ktor.utils.io.internal.ClosedElement r1 = io.ktor.utils.io.ByteBufferChannel.t(r1)
                    if (r1 == 0) goto L23
                    java.lang.Throwable r1 = r1.c()
                    if (r1 != 0) goto L1a
                    goto L23
                L1a:
                    io.ktor.utils.io.ByteBufferChannelKt.a(r1)
                    kotlin.KotlinNothingValueException r10 = new kotlin.KotlinNothingValueException
                    r10.<init>()
                    throw r10
                L23:
                    io.ktor.utils.io.ByteBufferChannel r1 = io.ktor.utils.io.ByteBufferChannel.this
                    boolean r1 = io.ktor.utils.io.ByteBufferChannel.K(r1, r0)
                    if (r1 != 0) goto L37
                    kotlin.Result$Companion r1 = kotlin.Result.f50818g
                    kotlin.Unit r1 = kotlin.Unit.f50853a
                    java.lang.Object r1 = kotlin.Result.b(r1)
                    r10.resumeWith(r1)
                    goto L6b
                L37:
                    io.ktor.utils.io.ByteBufferChannel r1 = io.ktor.utils.io.ByteBufferChannel.this
                    kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r10)
                    io.ktor.utils.io.ByteBufferChannel r3 = io.ktor.utils.io.ByteBufferChannel.this
                L3f:
                    kotlin.coroutines.Continuation r4 = io.ktor.utils.io.ByteBufferChannel.u(r1)
                    r5 = 1
                    r6 = 0
                    if (r4 != 0) goto L49
                    r4 = 1
                    goto L4a
                L49:
                    r4 = 0
                L4a:
                    if (r4 == 0) goto L82
                    boolean r4 = io.ktor.utils.io.ByteBufferChannel.K(r3, r0)
                    if (r4 != 0) goto L54
                L52:
                    r5 = 0
                    goto L69
                L54:
                    java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = io.ktor.utils.io.ByteBufferChannel.f47151p
                    r7 = 0
                    boolean r8 = androidx.concurrent.futures.a.a(r4, r1, r7, r2)
                    if (r8 == 0) goto L3f
                    boolean r3 = io.ktor.utils.io.ByteBufferChannel.K(r3, r0)
                    if (r3 != 0) goto L69
                    boolean r1 = androidx.concurrent.futures.a.a(r4, r1, r2, r7)
                    if (r1 != 0) goto L52
                L69:
                    if (r5 == 0) goto Lb
                L6b:
                    io.ktor.utils.io.ByteBufferChannel r10 = io.ktor.utils.io.ByteBufferChannel.this
                    io.ktor.utils.io.ByteBufferChannel.s(r10, r0)
                    io.ktor.utils.io.ByteBufferChannel r10 = io.ktor.utils.io.ByteBufferChannel.this
                    boolean r10 = io.ktor.utils.io.ByteBufferChannel.D(r10)
                    if (r10 == 0) goto L7d
                    io.ktor.utils.io.ByteBufferChannel r10 = io.ktor.utils.io.ByteBufferChannel.this
                    io.ktor.utils.io.ByteBufferChannel.B(r10)
                L7d:
                    java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    return r10
                L82:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "Operation is already in progress"
                    java.lang.String r0 = r0.toString()
                    r10.<init>(r0)
                    throw r10
                */
                throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel$writeSuspension$1.invoke(kotlin.coroutines.Continuation):java.lang.Object");
            }
        };
    }

    private final ByteBuffer B0() {
        Object obj;
        boolean a8;
        Throwable b8;
        ReadWriteBufferState c8;
        Throwable b9;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            if (Intrinsics.a(readWriteBufferState, ReadWriteBufferState.Terminated.f47451c)) {
                a8 = true;
            } else {
                a8 = Intrinsics.a(readWriteBufferState, ReadWriteBufferState.IdleEmpty.f47441c);
            }
            if (a8) {
                ClosedElement V = V();
                if (V != null && (b8 = V.b()) != null) {
                    ByteBufferChannelKt.b(b8);
                    throw new KotlinNothingValueException();
                }
                return null;
            }
            ClosedElement V2 = V();
            if (V2 != null && (b9 = V2.b()) != null) {
                ByteBufferChannelKt.b(b9);
                throw new KotlinNothingValueException();
            } else if (readWriteBufferState.f47440b._availableForRead$internal == 0) {
                return null;
            } else {
                c8 = readWriteBufferState.c();
            }
        } while (!a.a(f47148m, this, obj, c8));
        ByteBuffer a9 = c8.a();
        c0(a9, this.f47155e, c8.f47440b._availableForRead$internal);
        return a9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D0() {
        if (this.joining != null && (X() == ReadWriteBufferState.IdleEmpty.f47441c || (X() instanceof ReadWriteBufferState.IdleNonEmpty))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00b8 A[EDGE_INSN: B:92:0x00b8->B:56:0x00b8 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object E0(int r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.E0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean F0(JoiningState joiningState) {
        if (!G0(true)) {
            return false;
        }
        T(joiningState);
        Continuation continuation = (Continuation) f47150o.getAndSet(this, null);
        if (continuation != null) {
            Result.Companion companion = Result.f50818g;
            continuation.resumeWith(Result.b(ResultKt.a(new IllegalStateException("Joining is in progress"))));
        }
        x0();
        return true;
    }

    private final boolean G0(boolean z7) {
        Object obj;
        ReadWriteBufferState.Terminated terminated;
        Throwable th;
        ReadWriteBufferState.Initial initial = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            ClosedElement V = V();
            if (initial != null) {
                if (V != null) {
                    th = V.b();
                } else {
                    th = null;
                }
                if (th == null) {
                    initial.f47440b.j();
                }
                x0();
                initial = null;
            }
            terminated = ReadWriteBufferState.Terminated.f47451c;
            if (readWriteBufferState == terminated) {
                return true;
            }
            if (readWriteBufferState != ReadWriteBufferState.IdleEmpty.f47441c) {
                if (V != null && (readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) && (readWriteBufferState.f47440b.k() || V.b() != null)) {
                    if (V.b() != null) {
                        readWriteBufferState.f47440b.f();
                    }
                    initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).g();
                } else if (z7 && (readWriteBufferState instanceof ReadWriteBufferState.IdleNonEmpty) && readWriteBufferState.f47440b.k()) {
                    initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState).g();
                } else {
                    return false;
                }
            }
        } while (!a.a(f47148m, this, obj, terminated));
        if (initial != null && X() == terminated) {
            p0(initial);
        }
        return true;
    }

    private final int I0(ByteReadPacket byteReadPacket) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = s0(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer C0 = byteBufferChannel.C0();
        if (C0 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.X().f47440b;
        long Z = byteBufferChannel.Z();
        try {
            ClosedElement V = byteBufferChannel.V();
            if (V != null) {
                ByteBufferChannelKt.b(V.c());
                throw new KotlinNothingValueException();
            }
            int o8 = ringBufferCapacity.o((int) Math.min(byteReadPacket.C0(), C0.remaining()));
            if (o8 > 0) {
                C0.limit(C0.position() + o8);
                ByteBuffersKt.b(byteReadPacket, C0);
                byteBufferChannel.N(C0, ringBufferCapacity, o8);
            }
            return o8;
        } finally {
            if (ringBufferCapacity.h() || byteBufferChannel.p()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                A0(Z() + (byteBufferChannel.Z() - Z));
            }
            byteBufferChannel.u0();
            byteBufferChannel.H0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object K0(io.ktor.utils.io.ByteBufferChannel r5, int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$write$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$write$1 r0 = (io.ktor.utils.io.ByteBufferChannel$write$1) r0
            int r1 = r0.f47226k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47226k = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$write$1 r0 = new io.ktor.utils.io.ByteBufferChannel$write$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f47224i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47226k
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r5 = r0.f47223h
            java.lang.Object r6 = r0.f47222g
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r7 = r0.f47221f
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            kotlin.ResultKt.b(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L51
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.ResultKt.b(r8)
            r8 = 0
            if (r6 <= 0) goto L47
            r2 = 1
            goto L48
        L47:
            r2 = 0
        L48:
            if (r2 == 0) goto L89
            r2 = 4088(0xff8, float:5.729E-42)
            if (r6 > r2) goto L4f
            r8 = 1
        L4f:
            if (r8 == 0) goto L69
        L51:
            int r8 = r5.N0(r6, r7)
            if (r8 < 0) goto L5a
            kotlin.Unit r5 = kotlin.Unit.f50853a
            return r5
        L5a:
            r0.f47221f = r5
            r0.f47222g = r7
            r0.f47223h = r6
            r0.f47226k = r3
            java.lang.Object r8 = r5.L(r6, r7, r0)
            if (r8 != r1) goto L51
            return r1
        L69:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Min("
            r5.append(r7)
            r5.append(r6)
            java.lang.String r6 = ") should'nt be greater than (4088)"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        L89:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "min should be positive"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.K0(io.ktor.utils.io.ByteBufferChannel, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L(int r6, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = (io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1) r0
            int r1 = r0.f47168k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47168k = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f47166i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47168k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L6d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            int r6 = r0.f47165h
            java.lang.Object r7 = r0.f47164g
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r2 = r0.f47163f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.b(r8)
            goto L55
        L42:
            kotlin.ResultKt.b(r8)
            r0.f47163f = r5
            r0.f47164g = r7
            r0.f47165h = r6
            r0.f47168k = r4
            java.lang.Object r8 = r5.W0(r6, r0)
            if (r8 != r1) goto L54
            return r1
        L54:
            r2 = r5
        L55:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            if (r8 == 0) goto L70
            io.ktor.utils.io.ByteBufferChannel r8 = r2.s0(r2, r8)
            if (r8 == 0) goto L70
            r2 = 0
            r0.f47163f = r2
            r0.f47164g = r2
            r0.f47168k = r3
            java.lang.Object r6 = r8.n(r6, r7, r0)
            if (r6 != r1) goto L6d
            return r1
        L6d:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L70:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.L(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int L0(Buffer buffer) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = s0(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer C0 = byteBufferChannel.C0();
        int i8 = 0;
        if (C0 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.X().f47440b;
        long Z = byteBufferChannel.Z();
        try {
            ClosedElement V = byteBufferChannel.V();
            if (V != null) {
                ByteBufferChannelKt.b(V.c());
                throw new KotlinNothingValueException();
            }
            while (true) {
                int o8 = ringBufferCapacity.o(Math.min(buffer.k() - buffer.i(), C0.remaining()));
                if (o8 == 0) {
                    break;
                }
                BufferUtilsJvmKt.a(buffer, C0, o8);
                i8 += o8;
                byteBufferChannel.c0(C0, byteBufferChannel.O(C0, byteBufferChannel.f47156f + i8), ringBufferCapacity._availableForWrite$internal);
            }
            byteBufferChannel.N(C0, ringBufferCapacity, i8);
            return i8;
        } finally {
            if (ringBufferCapacity.h() || byteBufferChannel.p()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                A0(Z() + (byteBufferChannel.Z() - Z));
            }
            byteBufferChannel.u0();
            byteBufferChannel.H0();
        }
    }

    private final void M(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f47155e = O(byteBuffer, this.f47155e + i8);
            ringBufferCapacity.a(i8);
            z0(Y() + i8);
            x0();
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final int M0(byte[] bArr, int i8, int i9) {
        ByteBufferChannel byteBufferChannel;
        boolean z7;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = s0(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer C0 = byteBufferChannel.C0();
        if (C0 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.X().f47440b;
        long Z = byteBufferChannel.Z();
        try {
            ClosedElement V = byteBufferChannel.V();
            if (V != null) {
                ByteBufferChannelKt.b(V.c());
                throw new KotlinNothingValueException();
            }
            int i10 = 0;
            while (true) {
                int o8 = ringBufferCapacity.o(Math.min(i9 - i10, C0.remaining()));
                if (o8 != 0) {
                    if (o8 > 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        C0.put(bArr, i8 + i10, o8);
                        i10 += o8;
                        byteBufferChannel.c0(C0, byteBufferChannel.O(C0, byteBufferChannel.f47156f + i10), ringBufferCapacity._availableForWrite$internal);
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    byteBufferChannel.N(C0, ringBufferCapacity, i10);
                    return i10;
                }
            }
        } finally {
            if (ringBufferCapacity.h() || byteBufferChannel.p()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                A0(Z() + (byteBufferChannel.Z() - Z));
            }
            byteBufferChannel.u0();
            byteBufferChannel.H0();
        }
    }

    private final void N(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f47156f = O(byteBuffer, this.f47156f + i8);
            ringBufferCapacity.c(i8);
            A0(Z() + i8);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final int O(ByteBuffer byteBuffer, int i8) {
        if (i8 >= byteBuffer.capacity() - this.f47154d) {
            return i8 - (byteBuffer.capacity() - this.f47154d);
        }
        return i8;
    }

    static /* synthetic */ Object P0(ByteBufferChannel byteBufferChannel, byte[] bArr, int i8, int i9, Continuation continuation) {
        ByteBufferChannel s02;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (s02 = byteBufferChannel.s0(byteBufferChannel, joiningState)) != null) {
            return s02.O0(bArr, i8, i9, continuation);
        }
        int M0 = byteBufferChannel.M0(bArr, i8, i9);
        if (M0 > 0) {
            return Boxing.b(M0);
        }
        return byteBufferChannel.X0(bArr, i8, i9, continuation);
    }

    static /* synthetic */ Object Q0(ByteBufferChannel byteBufferChannel, Buffer buffer, Continuation continuation) {
        boolean z7;
        Object d8;
        byteBufferChannel.L0(buffer);
        if (buffer.k() > buffer.i()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return Unit.f50853a;
        }
        Object S0 = byteBufferChannel.S0(buffer, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (S0 == d8) {
            return S0;
        }
        return Unit.f50853a;
    }

    static /* synthetic */ Object R(ByteBufferChannel byteBufferChannel, long j8, Continuation continuation) {
        boolean z7;
        long j9 = 0;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            ByteBuffer B0 = byteBufferChannel.B0();
            if (B0 != null) {
                RingBufferCapacity ringBufferCapacity = byteBufferChannel.X().f47440b;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        int l8 = ringBufferCapacity.l((int) Math.min(2147483647L, j8));
                        byteBufferChannel.M(B0, ringBufferCapacity, l8);
                        j9 = 0 + l8;
                    }
                } finally {
                    byteBufferChannel.t0();
                    byteBufferChannel.H0();
                }
            }
            long j10 = j9;
            if (j10 != j8 && !byteBufferChannel.o()) {
                return byteBufferChannel.S(j10, j8, continuation);
            }
            return Boxing.c(j10);
        }
        throw new IllegalArgumentException(("max shouldn't be negative: " + j8).toString());
    }

    static /* synthetic */ Object R0(ByteBufferChannel byteBufferChannel, byte[] bArr, int i8, int i9, Continuation continuation) {
        Object d8;
        ByteBufferChannel s02;
        Object d9;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (s02 = byteBufferChannel.s0(byteBufferChannel, joiningState)) != null) {
            Object i10 = s02.i(bArr, i8, i9, continuation);
            d9 = IntrinsicsKt__IntrinsicsKt.d();
            if (i10 == d9) {
                return i10;
            }
            return Unit.f50853a;
        }
        while (i9 > 0) {
            int M0 = byteBufferChannel.M0(bArr, i8, i9);
            if (M0 == 0) {
                break;
            }
            i8 += M0;
            i9 -= M0;
        }
        if (i9 == 0) {
            return Unit.f50853a;
        }
        Object T0 = byteBufferChannel.T0(bArr, i8, i9, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (T0 == d8) {
            return T0;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008d, code lost:
        if (r13.o() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008f, code lost:
        r0.f47185f = r13;
        r0.f47186g = r12;
        r0.f47187h = r10;
        r0.f47190k = 1;
        r14 = r13.m0(1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
        if (r14 != r1) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a4, code lost:
        if (((java.lang.Boolean) r14).booleanValue() == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009b -> B:33:0x009e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S(long r10, long r12, kotlin.coroutines.Continuation<? super java.lang.Long> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$discardSuspend$1) r0
            int r1 = r0.f47190k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47190k = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            r0.<init>(r9, r14)
        L18:
            java.lang.Object r14 = r0.f47188i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47190k
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            long r10 = r0.f47187h
            java.lang.Object r12 = r0.f47186g
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref$LongRef) r12
            java.lang.Object r13 = r0.f47185f
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            kotlin.ResultKt.b(r14)
            goto L9e
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            kotlin.ResultKt.b(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.f51015f = r10
            r10 = r12
            r12 = r14
            r13 = r9
        L48:
            long r4 = r12.f51015f
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 >= 0) goto Laf
            java.nio.ByteBuffer r14 = r13.B0()
            r2 = 0
            if (r14 != 0) goto L56
            goto L87
        L56:
            io.ktor.utils.io.internal.ReadWriteBufferState r4 = r13.X()
            io.ktor.utils.io.internal.RingBufferCapacity r4 = r4.f47440b
            int r5 = r4._availableForRead$internal     // Catch: java.lang.Throwable -> La7
            if (r5 != 0) goto L67
            r13.t0()
            r13.H0()
            goto L87
        L67:
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r7 = r12.f51015f     // Catch: java.lang.Throwable -> La7
            long r7 = r10 - r7
            long r5 = java.lang.Math.min(r5, r7)     // Catch: java.lang.Throwable -> La7
            int r2 = (int) r5     // Catch: java.lang.Throwable -> La7
            int r2 = r4.l(r2)     // Catch: java.lang.Throwable -> La7
            r13.M(r14, r4, r2)     // Catch: java.lang.Throwable -> La7
            long r4 = r12.f51015f     // Catch: java.lang.Throwable -> La7
            long r6 = (long) r2     // Catch: java.lang.Throwable -> La7
            long r4 = r4 + r6
            r12.f51015f = r4     // Catch: java.lang.Throwable -> La7
            r13.t0()
            r13.H0()
            r2 = 1
        L87:
            if (r2 != 0) goto L48
            boolean r14 = r13.o()
            if (r14 != 0) goto Laf
            r0.f47185f = r13
            r0.f47186g = r12
            r0.f47187h = r10
            r0.f47190k = r3
            java.lang.Object r14 = r13.m0(r3, r0)
            if (r14 != r1) goto L9e
            return r1
        L9e:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L48
            goto Laf
        La7:
            r10 = move-exception
            r13.t0()
            r13.H0()
            throw r10
        Laf:
            long r10 = r12.f51015f
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.c(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.S(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:25:0x0060). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S0(io.ktor.utils.io.core.Buffer r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3) r0
            int r1 = r0.f47231j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47231j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f47229h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47231j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L78
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.f47228g
            io.ktor.utils.io.core.Buffer r7 = (io.ktor.utils.io.core.Buffer) r7
            java.lang.Object r2 = r0.f47227f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.b(r8)
            goto L60
        L40:
            kotlin.ResultKt.b(r8)
            r2 = r6
        L44:
            int r8 = r7.k()
            int r5 = r7.i()
            if (r8 <= r5) goto L50
            r8 = 1
            goto L51
        L50:
            r8 = 0
        L51:
            if (r8 == 0) goto L7f
            r0.f47227f = r2
            r0.f47228g = r7
            r0.f47231j = r4
            java.lang.Object r8 = r2.J0(r4, r0)
            if (r8 != r1) goto L60
            return r1
        L60:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            if (r8 == 0) goto L7b
            io.ktor.utils.io.ByteBufferChannel r8 = r2.s0(r2, r8)
            if (r8 == 0) goto L7b
            r2 = 0
            r0.f47227f = r2
            r0.f47228g = r2
            r0.f47231j = r3
            java.lang.Object r7 = r8.k(r7, r0)
            if (r7 != r1) goto L78
            return r1
        L78:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        L7b:
            r2.L0(r7)
            goto L44
        L7f:
            kotlin.Unit r7 = kotlin.Unit.f50853a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.S0(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void T(JoiningState joiningState) {
        boolean z7;
        ClosedElement V = V();
        if (V == null) {
            return;
        }
        this.joining = null;
        if (!joiningState.b()) {
            joiningState.c().flush();
            joiningState.a();
            return;
        }
        ReadWriteBufferState X = joiningState.c().X();
        if (!(X instanceof ReadWriteBufferState.Writing) && !(X instanceof ReadWriteBufferState.ReadingWriting)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (V.b() == null && z7) {
            joiningState.c().flush();
        } else {
            joiningState.c().b(V.b());
        }
        joiningState.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0054 -> B:20:0x0057). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object T0(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5) r0
            int r1 = r0.f47238l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47238l = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f47236j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47238l
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r6 = r0.f47235i
            int r7 = r0.f47234h
            java.lang.Object r8 = r0.f47233g
            byte[] r8 = (byte[]) r8
            java.lang.Object r2 = r0.f47232f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.b(r9)
            goto L57
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.ResultKt.b(r9)
            r2 = r5
        L41:
            if (r8 <= 0) goto L63
            r0.f47232f = r2
            r0.f47233g = r6
            r0.f47234h = r7
            r0.f47235i = r8
            r0.f47238l = r3
            java.lang.Object r9 = r2.O0(r6, r7, r8, r0)
            if (r9 != r1) goto L54
            return r1
        L54:
            r4 = r8
            r8 = r6
            r6 = r4
        L57:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            int r7 = r7 + r9
            int r6 = r6 - r9
            r4 = r8
            r8 = r6
            r6 = r4
            goto L41
        L63:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.T0(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(int i8) {
        ReadWriteBufferState X;
        ReadWriteBufferState.Terminated terminated;
        ByteBufferChannel c8;
        JoiningState joiningState = this.joining;
        if (joiningState != null && (c8 = joiningState.c()) != null) {
            c8.flush();
        }
        do {
            X = X();
            terminated = ReadWriteBufferState.Terminated.f47451c;
            if (X == terminated) {
                return;
            }
            X.f47440b.e();
        } while (X != X());
        int i9 = X.f47440b._availableForWrite$internal;
        if (X.f47440b._availableForRead$internal >= 1) {
            w0();
        }
        JoiningState joiningState2 = this.joining;
        if (i9 >= i8) {
            if (joiningState2 == null || X() == terminated) {
                x0();
            }
        }
    }

    static /* synthetic */ Object U0(ByteBufferChannel byteBufferChannel, ByteReadPacket byteReadPacket, Continuation continuation) {
        Object d8;
        ByteBufferChannel s02;
        Object d9;
        ByteBufferChannel s03;
        Object d10;
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null && (s03 = byteBufferChannel.s0(byteBufferChannel, joiningState)) != null) {
            Object m8 = s03.m(byteReadPacket, continuation);
            d10 = IntrinsicsKt__IntrinsicsKt.d();
            if (m8 == d10) {
                return m8;
            }
            return Unit.f50853a;
        }
        do {
            try {
                if (!(!byteReadPacket.c0())) {
                    break;
                }
            } catch (Throwable th) {
                byteReadPacket.release();
                throw th;
            }
        } while (byteBufferChannel.I0(byteReadPacket) != 0);
        if (byteReadPacket.C0() > 0) {
            JoiningState joiningState2 = byteBufferChannel.joining;
            if (joiningState2 != null && (s02 = byteBufferChannel.s0(byteBufferChannel, joiningState2)) != null) {
                Object m9 = s02.m(byteReadPacket, continuation);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (m9 == d9) {
                    return m9;
                }
                return Unit.f50853a;
            }
            Object V0 = byteBufferChannel.V0(byteReadPacket, continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (V0 == d8) {
                return V0;
            }
            return Unit.f50853a;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClosedElement V() {
        return (ClosedElement) this._closed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:13:0x002c, B:35:0x0076, B:18:0x0040, B:28:0x005e, B:30:0x0062, B:32:0x0068, B:38:0x007c, B:23:0x004a, B:25:0x0051), top: B:44:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005b -> B:28:0x005e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object V0(io.ktor.utils.io.core.ByteReadPacket r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1) r0
            int r1 = r0.f47243j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47243j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f47241h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47243j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f47239f
            io.ktor.utils.io.core.ByteReadPacket r6 = (io.ktor.utils.io.core.ByteReadPacket) r6
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L44
            goto L76
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f47240g
            io.ktor.utils.io.core.ByteReadPacket r6 = (io.ktor.utils.io.core.ByteReadPacket) r6
            java.lang.Object r2 = r0.f47239f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L44
            goto L5e
        L44:
            r7 = move-exception
            goto L86
        L46:
            kotlin.ResultKt.b(r7)
            r2 = r5
        L4a:
            boolean r7 = r6.c0()     // Catch: java.lang.Throwable -> L44
            r7 = r7 ^ r4
            if (r7 == 0) goto L80
            r0.f47239f = r2     // Catch: java.lang.Throwable -> L44
            r0.f47240g = r6     // Catch: java.lang.Throwable -> L44
            r0.f47243j = r4     // Catch: java.lang.Throwable -> L44
            java.lang.Object r7 = r2.W0(r4, r0)     // Catch: java.lang.Throwable -> L44
            if (r7 != r1) goto L5e
            return r1
        L5e:
            io.ktor.utils.io.internal.JoiningState r7 = r2.joining     // Catch: java.lang.Throwable -> L44
            if (r7 == 0) goto L7c
            io.ktor.utils.io.ByteBufferChannel r7 = r2.s0(r2, r7)     // Catch: java.lang.Throwable -> L44
            if (r7 == 0) goto L7c
            r0.f47239f = r6     // Catch: java.lang.Throwable -> L44
            r2 = 0
            r0.f47240g = r2     // Catch: java.lang.Throwable -> L44
            r0.f47243j = r3     // Catch: java.lang.Throwable -> L44
            java.lang.Object r7 = r7.m(r6, r0)     // Catch: java.lang.Throwable -> L44
            if (r7 != r1) goto L76
            return r1
        L76:
            kotlin.Unit r7 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L44
            r6.release()
            return r7
        L7c:
            r2.I0(r6)     // Catch: java.lang.Throwable -> L44
            goto L4a
        L80:
            r6.release()
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L86:
            r6.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.V0(io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Continuation<Boolean> W() {
        return (Continuation) this._readOp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object W0(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$3
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$3) r0
            int r1 = r0.f47255j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47255j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$3
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f47253h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47255j
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r6 = r0.f47252g
            java.lang.Object r2 = r0.f47251f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
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
            boolean r7 = r2.Z0(r6)
            if (r7 == 0) goto L66
            r0.f47251f = r2
            r0.f47252g = r6
            r0.f47255j = r3
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r7.<init>(r4, r3)
            r7.y()
            J(r2, r6, r7)
            java.lang.Object r7 = r7.v()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            if (r7 != r4) goto L63
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L63:
            if (r7 != r1) goto L3b
            return r1
        L66:
            io.ktor.utils.io.internal.ClosedElement r6 = r2.V()
            if (r6 == 0) goto L7c
            java.lang.Throwable r6 = r6.c()
            if (r6 != 0) goto L73
            goto L7c
        L73:
            io.ktor.utils.io.ByteBufferChannelKt.a(r6)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L7c:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.W0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ReadWriteBufferState X() {
        return (ReadWriteBufferState) this._state;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:20:0x005c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object X0(byte[] r7, int r8, int r9, kotlin.coroutines.Continuation<? super java.lang.Integer> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$1) r0
            int r1 = r0.f47250l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47250l = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.f47248j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47250l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r10)
            goto L74
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            int r7 = r0.f47247i
            int r8 = r0.f47246h
            java.lang.Object r9 = r0.f47245g
            byte[] r9 = (byte[]) r9
            java.lang.Object r2 = r0.f47244f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.b(r10)
            r5 = r9
            r9 = r7
            r7 = r5
            goto L5c
        L47:
            kotlin.ResultKt.b(r10)
            r2 = r6
        L4b:
            r0.f47244f = r2
            r0.f47245g = r7
            r0.f47246h = r8
            r0.f47247i = r9
            r0.f47250l = r4
            java.lang.Object r10 = r2.J0(r4, r0)
            if (r10 != r1) goto L5c
            return r1
        L5c:
            io.ktor.utils.io.internal.JoiningState r10 = r2.joining
            if (r10 == 0) goto L75
            io.ktor.utils.io.ByteBufferChannel r10 = r2.s0(r2, r10)
            if (r10 == 0) goto L75
            r2 = 0
            r0.f47244f = r2
            r0.f47245g = r2
            r0.f47250l = r3
            java.lang.Object r10 = r10.X0(r7, r8, r9, r0)
            if (r10 != r1) goto L74
            return r1
        L74:
            return r10
        L75:
            int r10 = r2.M0(r7, r8, r9)
            if (r10 <= 0) goto L4b
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.b(r10)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.X0(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
        U(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        if (D0() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
        w0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Y0(int r6, kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
        L0:
            io.ktor.utils.io.internal.ClosedElement r0 = r5.V()
            if (r0 == 0) goto L16
            java.lang.Throwable r0 = r0.c()
            if (r0 != 0) goto Ld
            goto L16
        Ld:
            io.ktor.utils.io.ByteBufferChannelKt.a(r0)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L16:
            boolean r0 = r5.Z0(r6)
            if (r0 != 0) goto L28
            kotlin.Result$Companion r0 = kotlin.Result.f50818g
            kotlin.Unit r0 = kotlin.Unit.f50853a
            java.lang.Object r0 = kotlin.Result.b(r0)
            r7.resumeWith(r0)
            goto L54
        L28:
            kotlin.coroutines.Continuation r0 = r5.a0()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L32
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            if (r0 == 0) goto L61
            boolean r0 = r5.Z0(r6)
            if (r0 != 0) goto L3d
        L3b:
            r1 = 0
            goto L52
        L3d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = io.ktor.utils.io.ByteBufferChannel.f47151p
            r3 = 0
            boolean r4 = androidx.concurrent.futures.a.a(r0, r5, r3, r7)
            if (r4 == 0) goto L28
            boolean r4 = r5.Z0(r6)
            if (r4 != 0) goto L52
            boolean r0 = androidx.concurrent.futures.a.a(r0, r5, r7, r3)
            if (r0 != 0) goto L3b
        L52:
            if (r1 == 0) goto L0
        L54:
            r5.U(r6)
            boolean r6 = r5.D0()
            if (r6 == 0) goto L60
            r5.w0()
        L60:
            return
        L61:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Operation is already in progress"
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.Y0(int, kotlinx.coroutines.CancellableContinuation):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Z0(int i8) {
        JoiningState joiningState = this.joining;
        ReadWriteBufferState X = X();
        if (V() == null) {
            if (joiningState == null) {
                if (X.f47440b._availableForWrite$internal < i8 && X != ReadWriteBufferState.IdleEmpty.f47441c) {
                    return true;
                }
            } else if (X != ReadWriteBufferState.Terminated.f47451c && !(X instanceof ReadWriteBufferState.Writing) && !(X instanceof ReadWriteBufferState.ReadingWriting)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Continuation<Unit> a0() {
        return (Continuation) this._writeOp;
    }

    private final ReadWriteBufferState.Initial b0() {
        ReadWriteBufferState.Initial u02 = this.f47153c.u0();
        u02.f47440b.j();
        return u02;
    }

    private final void c0(ByteBuffer byteBuffer, int i8, int i9) {
        boolean z7;
        int g8;
        boolean z8 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i9 < 0) {
                z8 = false;
            }
            if (z8) {
                g8 = RangesKt___RangesKt.g(i9 + i8, byteBuffer.capacity() - this.f47154d);
                byteBuffer.limit(g8);
                byteBuffer.position(i8);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070 A[EDGE_INSN: B:33:0x0070->B:27:0x0070 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int d0(io.ktor.utils.io.core.Buffer r8, int r9, int r10) {
        /*
            r7 = this;
        L0:
            java.nio.ByteBuffer r0 = r7.B0()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lb
        L8:
            r0 = 0
            r5 = 0
            goto L54
        Lb:
            io.ktor.utils.io.internal.ReadWriteBufferState r3 = r7.X()
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r3.f47440b
            int r4 = r3._availableForRead$internal     // Catch: java.lang.Throwable -> L71
            if (r4 != 0) goto L1c
            r7.t0()
            r7.H0()
            goto L8
        L1c:
            int r4 = r8.g()     // Catch: java.lang.Throwable -> L71
            int r5 = r8.k()     // Catch: java.lang.Throwable -> L71
            int r4 = r4 - r5
            int r5 = r0.remaining()     // Catch: java.lang.Throwable -> L71
            int r6 = java.lang.Math.min(r4, r10)     // Catch: java.lang.Throwable -> L71
            int r5 = java.lang.Math.min(r5, r6)     // Catch: java.lang.Throwable -> L71
            int r5 = r3.l(r5)     // Catch: java.lang.Throwable -> L71
            if (r5 > 0) goto L39
            r0 = 0
            goto L4e
        L39:
            int r6 = r0.remaining()     // Catch: java.lang.Throwable -> L71
            if (r4 >= r6) goto L47
            int r6 = r0.position()     // Catch: java.lang.Throwable -> L71
            int r6 = r6 + r4
            r0.limit(r6)     // Catch: java.lang.Throwable -> L71
        L47:
            io.ktor.utils.io.core.BufferPrimitivesJvmKt.a(r8, r0)     // Catch: java.lang.Throwable -> L71
            r7.M(r0, r3, r5)     // Catch: java.lang.Throwable -> L71
            r0 = 1
        L4e:
            r7.t0()
            r7.H0()
        L54:
            int r9 = r9 + r5
            int r10 = r10 - r5
            if (r0 == 0) goto L70
            int r0 = r8.g()
            int r3 = r8.k()
            if (r0 <= r3) goto L63
            goto L64
        L63:
            r1 = 0
        L64:
            if (r1 == 0) goto L70
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r7.X()
            io.ktor.utils.io.internal.RingBufferCapacity r0 = r0.f47440b
            int r0 = r0._availableForRead$internal
            if (r0 > 0) goto L0
        L70:
            return r9
        L71:
            r8 = move-exception
            r7.t0()
            r7.H0()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.d0(io.ktor.utils.io.core.Buffer, int, int):int");
    }

    private final int e0(byte[] bArr, int i8, int i9) {
        ByteBuffer B0 = B0();
        int i10 = 0;
        if (B0 != null) {
            RingBufferCapacity ringBufferCapacity = X().f47440b;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int capacity = B0.capacity() - this.f47154d;
                    while (true) {
                        int i11 = i9 - i10;
                        if (i11 == 0) {
                            break;
                        }
                        int i12 = this.f47155e;
                        int l8 = ringBufferCapacity.l(Math.min(capacity - i12, i11));
                        if (l8 == 0) {
                            break;
                        }
                        B0.limit(i12 + l8);
                        B0.position(i12);
                        B0.get(bArr, i8 + i10, l8);
                        M(B0, ringBufferCapacity, l8);
                        i10 += l8;
                    }
                }
            } finally {
                t0();
                H0();
            }
        }
        return i10;
    }

    static /* synthetic */ int f0(ByteBufferChannel byteBufferChannel, Buffer buffer, int i8, int i9, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                i8 = 0;
            }
            if ((i10 & 4) != 0) {
                i9 = buffer.g() - buffer.k();
            }
            return byteBufferChannel.d0(buffer, i8, i9);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAsMuchAsPossible");
    }

    static /* synthetic */ Object g0(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, Continuation continuation) {
        boolean z7;
        int f02 = f0(byteBufferChannel, chunkBuffer, 0, 0, 6, null);
        if (f02 == 0 && byteBufferChannel.V() != null) {
            f02 = byteBufferChannel.X().f47440b.e() ? f0(byteBufferChannel, chunkBuffer, 0, 0, 6, null) : -1;
        } else if (f02 <= 0) {
            if (chunkBuffer.g() > chunkBuffer.k()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                return byteBufferChannel.i0(chunkBuffer, continuation);
            }
        }
        return Boxing.b(f02);
    }

    static /* synthetic */ Object h0(ByteBufferChannel byteBufferChannel, byte[] bArr, int i8, int i9, Continuation continuation) {
        int e02 = byteBufferChannel.e0(bArr, i8, i9);
        if (e02 == 0 && byteBufferChannel.V() != null) {
            e02 = byteBufferChannel.X().f47440b.e() ? byteBufferChannel.e0(bArr, i8, i9) : -1;
        } else if (e02 <= 0 && i9 != 0) {
            return byteBufferChannel.j0(bArr, i8, i9, continuation);
        }
        return Boxing.b(e02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i0(io.ktor.utils.io.core.internal.ChunkBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3) r0
            int r1 = r0.f47202j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47202j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f47200h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47202j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L6d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f47199g
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = (io.ktor.utils.io.core.internal.ChunkBuffer) r6
            java.lang.Object r2 = r0.f47198f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.b(r7)
            goto L51
        L40:
            kotlin.ResultKt.b(r7)
            r0.f47198f = r5
            r0.f47199g = r6
            r0.f47202j = r4
            java.lang.Object r7 = r5.m0(r4, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r2 = r5
        L51:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5f
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r6)
            return r6
        L5f:
            r7 = 0
            r0.f47198f = r7
            r0.f47199g = r7
            r0.f47202j = r3
            java.lang.Object r7 = r2.l(r6, r0)
            if (r7 != r1) goto L6d
            return r1
        L6d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.i0(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j0(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1) r0
            int r1 = r0.f47197l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47197l = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f47195j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47197l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r9)
            goto L75
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            int r8 = r0.f47194i
            int r7 = r0.f47193h
            java.lang.Object r6 = r0.f47192g
            byte[] r6 = (byte[]) r6
            java.lang.Object r2 = r0.f47191f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.b(r9)
            goto L59
        L44:
            kotlin.ResultKt.b(r9)
            r0.f47191f = r5
            r0.f47192g = r6
            r0.f47193h = r7
            r0.f47194i = r8
            r0.f47197l = r4
            java.lang.Object r9 = r5.m0(r4, r0)
            if (r9 != r1) goto L58
            return r1
        L58:
            r2 = r5
        L59:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L67
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.b(r6)
            return r6
        L67:
            r9 = 0
            r0.f47191f = r9
            r0.f47192g = r9
            r0.f47197l = r3
            java.lang.Object r9 = r2.g(r6, r7, r8, r0)
            if (r9 != r1) goto L75
            return r1
        L75:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.j0(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object k0(ByteBufferChannel byteBufferChannel, long j8, Continuation continuation) {
        if (byteBufferChannel.e()) {
            Throwable c8 = byteBufferChannel.c();
            if (c8 != null) {
                ByteBufferChannelKt.b(c8);
                throw new KotlinNothingValueException();
            }
            return byteBufferChannel.q0(j8);
        }
        return byteBufferChannel.l0(j8, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x00ce, blocks: (B:40:0x00bb, B:42:0x00c4, B:44:0x00c9, B:12:0x0039, B:32:0x00a7, B:38:0x00b6, B:21:0x0061, B:23:0x0071, B:24:0x0075, B:26:0x008b, B:28:0x0091), top: B:52:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x00ce, blocks: (B:40:0x00bb, B:42:0x00c4, B:44:0x00c9, B:12:0x0039, B:32:0x00a7, B:38:0x00b6, B:21:0x0061, B:23:0x0071, B:24:0x0075, B:26:0x008b, B:28:0x0091), top: B:52:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #1 {all -> 0x00ce, blocks: (B:40:0x00bb, B:42:0x00c4, B:44:0x00c9, B:12:0x0039, B:32:0x00a7, B:38:0x00b6, B:21:0x0061, B:23:0x0071, B:24:0x0075, B:26:0x008b, B:28:0x0091), top: B:52:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb A[Catch: all -> 0x00ce, TRY_ENTER, TryCatch #1 {all -> 0x00ce, blocks: (B:40:0x00bb, B:42:0x00c4, B:44:0x00c9, B:12:0x0039, B:32:0x00a7, B:38:0x00b6, B:21:0x0061, B:23:0x0071, B:24:0x0075, B:26:0x008b, B:28:0x0091), top: B:52:0x0039 }] */
    /* JADX WARN: Type inference failed for: r14v7, types: [io.ktor.utils.io.core.Output] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a4 -> B:32:0x00a7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b3 -> B:37:0x00b4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l0(long r13, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r15) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.l0(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object m0(int i8, Continuation<? super Boolean> continuation) {
        boolean z7 = true;
        if (X().f47440b._availableForRead$internal >= i8) {
            return Boxing.a(true);
        }
        ClosedElement V = V();
        if (V != null) {
            Throwable b8 = V.b();
            if (b8 != null) {
                ByteBufferChannelKt.b(b8);
                throw new KotlinNothingValueException();
            }
            RingBufferCapacity ringBufferCapacity = X().f47440b;
            z7 = (!ringBufferCapacity.e() || ringBufferCapacity._availableForRead$internal < i8) ? false : false;
            if (W() == null) {
                return Boxing.a(z7);
            }
            throw new IllegalStateException("Read operation is already in progress");
        } else if (i8 == 1) {
            return n0(1, continuation);
        } else {
            return o0(i8, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n0(int r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1) r0
            int r1 = r0.f47215j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47215j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f47213h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47215j
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.f47211f
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L7f
        L2d:
            r6 = move-exception
            goto L82
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r4.X()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r6.f47440b
            int r2 = r2._availableForRead$internal
            if (r2 >= r5) goto L58
            io.ktor.utils.io.internal.JoiningState r2 = r4.joining
            if (r2 == 0) goto L56
            kotlin.coroutines.Continuation r2 = r4.a0()
            if (r2 == 0) goto L56
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r2 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.f47441c
            if (r6 == r2) goto L58
            boolean r6 = r6 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r6 != 0) goto L58
        L56:
            r6 = 1
            goto L59
        L58:
            r6 = 0
        L59:
            if (r6 != 0) goto L60
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        L60:
            r0.f47211f = r4     // Catch: java.lang.Throwable -> L80
            r0.f47212g = r5     // Catch: java.lang.Throwable -> L80
            r0.f47215j = r3     // Catch: java.lang.Throwable -> L80
            io.ktor.utils.io.internal.CancellableReusableContinuation<java.lang.Boolean> r6 = r4.f47159i     // Catch: java.lang.Throwable -> L80
            r4.E0(r5, r6)     // Catch: java.lang.Throwable -> L80
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.Object r6 = r6.f(r5)     // Catch: java.lang.Throwable -> L80
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()     // Catch: java.lang.Throwable -> L80
            if (r6 != r5) goto L7c
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)     // Catch: java.lang.Throwable -> L80
        L7c:
            if (r6 != r1) goto L7f
            return r1
        L7f:
            return r6
        L80:
            r6 = move-exception
            r5 = r4
        L82:
            r0 = 0
            r5.y0(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.n0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0092 -> B:39:0x0095). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o0(int r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1) r0
            int r1 = r0.f47220j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47220j = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f47218h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47220j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            int r6 = r0.f47217g
            java.lang.Object r2 = r0.f47216f
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.b(r7)
            goto L95
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.b(r7)
            r2 = r5
        L3c:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r2.X()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.f47440b
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L4b
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r6
        L4b:
            io.ktor.utils.io.internal.ClosedElement r7 = r2.V()
            if (r7 == 0) goto L88
            java.lang.Throwable r0 = r7.b()
            if (r0 != 0) goto L7b
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r2.X()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.f47440b
            boolean r0 = r7.e()
            if (r0 == 0) goto L68
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L68
            r3 = 1
        L68:
            kotlin.coroutines.Continuation r6 = r2.W()
            if (r6 != 0) goto L73
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r6
        L73:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Read operation is already in progress"
            r6.<init>(r7)
            throw r6
        L7b:
            java.lang.Throwable r6 = r7.b()
            io.ktor.utils.io.ByteBufferChannelKt.a(r6)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L88:
            r0.f47216f = r2
            r0.f47217g = r6
            r0.f47220j = r4
            java.lang.Object r7 = r2.n0(r6, r0)
            if (r7 != r1) goto L95
            return r1
        L95:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L3c
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.o0(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void p0(ReadWriteBufferState.Initial initial) {
        this.f47153c.recycle(initial);
    }

    private final ByteReadPacket q0(long j8) {
        boolean z7;
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            ChunkBuffer d8 = UnsafeKt.d(bytePacketBuilder, 1, null);
            while (true) {
                if (d8.g() - d8.k() > j8) {
                    d8.t((int) j8);
                }
                j8 -= f0(this, d8, 0, 0, 6, null);
                if (j8 > 0 && !o()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    d8 = UnsafeKt.d(bytePacketBuilder, 1, d8);
                } else {
                    bytePacketBuilder.c();
                    return bytePacketBuilder.K0();
                }
            }
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    private final ByteBufferChannel s0(ByteBufferChannel byteBufferChannel, JoiningState joiningState) {
        while (byteBufferChannel.X() == ReadWriteBufferState.Terminated.f47451c) {
            byteBufferChannel = joiningState.c();
            joiningState = byteBufferChannel.joining;
            if (joiningState == null) {
                return byteBufferChannel;
            }
        }
        return null;
    }

    private final void t0() {
        Object obj;
        ReadWriteBufferState e8;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ReadWriteBufferState.IdleNonEmpty idleNonEmpty = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty2 = idleNonEmpty;
            if (idleNonEmpty2 != null) {
                idleNonEmpty2.f47440b.j();
                x0();
                idleNonEmpty = null;
            }
            e8 = readWriteBufferState.e();
            if ((e8 instanceof ReadWriteBufferState.IdleNonEmpty) && X() == readWriteBufferState && e8.f47440b.k()) {
                e8 = ReadWriteBufferState.IdleEmpty.f47441c;
                idleNonEmpty = e8;
            }
            atomicReferenceFieldUpdater = f47148m;
        } while (!a.a(atomicReferenceFieldUpdater, this, obj, e8));
        ReadWriteBufferState.IdleEmpty idleEmpty = ReadWriteBufferState.IdleEmpty.f47441c;
        if (e8 == idleEmpty) {
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty3 = idleNonEmpty;
            if (idleNonEmpty3 != null) {
                p0(idleNonEmpty3.g());
            }
            x0();
        } else if ((e8 instanceof ReadWriteBufferState.IdleNonEmpty) && e8.f47440b.g() && e8.f47440b.k() && a.a(atomicReferenceFieldUpdater, this, e8, idleEmpty)) {
            e8.f47440b.j();
            p0(((ReadWriteBufferState.IdleNonEmpty) e8).g());
            x0();
        }
    }

    private final void v0(Throwable th) {
        boolean z7;
        Continuation continuation = (Continuation) f47150o.getAndSet(this, null);
        if (continuation != null) {
            if (th != null) {
                Result.Companion companion = Result.f50818g;
                continuation.resumeWith(Result.b(ResultKt.a(th)));
            } else {
                if (X().f47440b._availableForRead$internal > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                continuation.resumeWith(Result.b(Boolean.valueOf(z7)));
            }
        }
        Continuation continuation2 = (Continuation) f47151p.getAndSet(this, null);
        if (continuation2 != null) {
            Result.Companion companion2 = Result.f50818g;
            if (th == null) {
                th = new ClosedWriteChannelException("Byte channel was closed");
            }
            continuation2.resumeWith(Result.b(ResultKt.a(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0() {
        Throwable th = null;
        Continuation continuation = (Continuation) f47150o.getAndSet(this, null);
        if (continuation != null) {
            ClosedElement V = V();
            if (V != null) {
                th = V.b();
            }
            if (th != null) {
                Result.Companion companion = Result.f50818g;
                continuation.resumeWith(Result.b(ResultKt.a(th)));
                return;
            }
            Result.Companion companion2 = Result.f50818g;
            continuation.resumeWith(Result.b(Boolean.TRUE));
        }
    }

    private final void x0() {
        Continuation<Unit> a02;
        ClosedElement V;
        Object a8;
        do {
            a02 = a0();
            if (a02 == null) {
                return;
            }
            V = V();
            if (V == null && this.joining != null) {
                ReadWriteBufferState X = X();
                if (!(X instanceof ReadWriteBufferState.Writing) && !(X instanceof ReadWriteBufferState.ReadingWriting) && X != ReadWriteBufferState.Terminated.f47451c) {
                    return;
                }
            }
        } while (!a.a(f47151p, this, a02, null));
        if (V == null) {
            Result.Companion companion = Result.f50818g;
            a8 = Unit.f50853a;
        } else {
            Result.Companion companion2 = Result.f50818g;
            a8 = ResultKt.a(V.c());
        }
        a02.resumeWith(Result.b(a8));
    }

    private final void y0(Continuation<? super Boolean> continuation) {
        this._readOp = continuation;
    }

    public void A0(long j8) {
        this.totalBytesWritten = j8;
    }

    public final ByteBuffer C0() {
        Object obj;
        ReadWriteBufferState readWriteBufferState;
        ReadWriteBufferState.IdleEmpty idleEmpty;
        ReadWriteBufferState d8;
        Continuation<Unit> a02 = a0();
        if (a02 == null) {
            ReadWriteBufferState readWriteBufferState2 = null;
            ReadWriteBufferState.Initial initial = null;
            do {
                obj = this._state;
                readWriteBufferState = (ReadWriteBufferState) obj;
                if (this.joining != null) {
                    if (initial != null) {
                        p0(initial);
                    }
                    return null;
                } else if (V() != null) {
                    if (initial != null) {
                        p0(initial);
                    }
                    ClosedElement V = V();
                    Intrinsics.c(V);
                    ByteBufferChannelKt.b(V.c());
                    throw new KotlinNothingValueException();
                } else {
                    idleEmpty = ReadWriteBufferState.IdleEmpty.f47441c;
                    if (readWriteBufferState == idleEmpty) {
                        if (initial == null) {
                            initial = b0();
                        }
                        d8 = initial.d();
                    } else if (readWriteBufferState == ReadWriteBufferState.Terminated.f47451c) {
                        if (initial != null) {
                            p0(initial);
                        }
                        if (this.joining != null) {
                            return null;
                        }
                        ClosedElement V2 = V();
                        Intrinsics.c(V2);
                        ByteBufferChannelKt.b(V2.c());
                        throw new KotlinNothingValueException();
                    } else {
                        d8 = readWriteBufferState.d();
                    }
                }
            } while (!a.a(f47148m, this, obj, d8));
            if (V() == null) {
                ByteBuffer b8 = d8.b();
                if (initial != null) {
                    if (readWriteBufferState == null) {
                        Intrinsics.w("old");
                    } else {
                        readWriteBufferState2 = readWriteBufferState;
                    }
                    if (readWriteBufferState2 != idleEmpty) {
                        p0(initial);
                    }
                }
                c0(b8, this.f47156f, d8.f47440b._availableForWrite$internal);
                return b8;
            }
            u0();
            H0();
            ClosedElement V3 = V();
            Intrinsics.c(V3);
            ByteBufferChannelKt.b(V3.c());
            throw new KotlinNothingValueException();
        }
        throw new IllegalStateException("Write operation is already in progress: " + a02);
    }

    public final boolean H0() {
        if (V() == null || !G0(false)) {
            return false;
        }
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            T(joiningState);
        }
        w0();
        x0();
        return true;
    }

    public final Object J0(int i8, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> c8;
        Object d8;
        Object d9;
        Object d10;
        Object d11;
        Object d12;
        Throwable c9;
        if (!Z0(i8)) {
            ClosedElement V = V();
            if (V != null && (c9 = V.c()) != null) {
                ByteBufferChannelKt.b(c9);
                throw new KotlinNothingValueException();
            }
            d12 = IntrinsicsKt__IntrinsicsKt.d();
            if (d12 == null) {
                return null;
            }
            return Unit.f50853a;
        }
        this.writeSuspensionSize = i8;
        if (this.attachedJob != null) {
            Object invoke = this.f47161k.invoke(continuation);
            d10 = IntrinsicsKt__IntrinsicsKt.d();
            if (invoke == d10) {
                DebugProbesKt.c(continuation);
            }
            d11 = IntrinsicsKt__IntrinsicsKt.d();
            if (invoke == d11) {
                return invoke;
            }
            return Unit.f50853a;
        }
        CancellableReusableContinuation<Unit> cancellableReusableContinuation = this.f47160j;
        this.f47161k.invoke(cancellableReusableContinuation);
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        Object f8 = cancellableReusableContinuation.f(c8);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (f8 == d8) {
            DebugProbesKt.c(continuation);
        }
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (f8 == d9) {
            return f8;
        }
        return Unit.f50853a;
    }

    /* JADX WARN: Finally extract failed */
    public int N0(int i8, Function1<? super ByteBuffer, Unit> block) {
        boolean z7;
        boolean z8;
        ByteBufferChannel byteBufferChannel;
        boolean z9;
        int i9;
        Intrinsics.f(block, "block");
        int i10 = 1;
        int i11 = 0;
        if (i8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 <= 4088) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                JoiningState joiningState = this.joining;
                if (joiningState == null || (byteBufferChannel = s0(this, joiningState)) == null) {
                    byteBufferChannel = this;
                }
                ByteBuffer C0 = byteBufferChannel.C0();
                if (C0 == null) {
                    i9 = 0;
                } else {
                    RingBufferCapacity ringBufferCapacity = byteBufferChannel.X().f47440b;
                    long Z = byteBufferChannel.Z();
                    try {
                        ClosedElement V = byteBufferChannel.V();
                        if (V != null) {
                            ByteBufferChannelKt.b(V.c());
                            throw new KotlinNothingValueException();
                        }
                        int n8 = ringBufferCapacity.n(i8);
                        if (n8 <= 0) {
                            i10 = 0;
                        } else {
                            byteBufferChannel.c0(C0, byteBufferChannel.f47156f, n8);
                            int position = C0.position();
                            int limit = C0.limit();
                            block.invoke(C0);
                            if (limit == C0.limit()) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            if (z9) {
                                int position2 = C0.position() - position;
                                if (position2 >= 0) {
                                    i11 = 1;
                                }
                                if (i11 != 0) {
                                    if (position2 >= 0) {
                                        byteBufferChannel.N(C0, ringBufferCapacity, position2);
                                        if (position2 < n8) {
                                            ringBufferCapacity.a(n8 - position2);
                                        }
                                        i11 = position2;
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                } else {
                                    throw new IllegalStateException("Position has been moved backward: pushback is not supported".toString());
                                }
                            } else {
                                throw new IllegalStateException("Buffer limit modified".toString());
                            }
                        }
                        if (ringBufferCapacity.h() || byteBufferChannel.p()) {
                            byteBufferChannel.flush();
                        }
                        if (byteBufferChannel != this) {
                            A0(Z() + (byteBufferChannel.Z() - Z));
                        }
                        byteBufferChannel.u0();
                        byteBufferChannel.H0();
                        i9 = i11;
                        i11 = i10;
                    } catch (Throwable th) {
                        if (ringBufferCapacity.h() || byteBufferChannel.p()) {
                            byteBufferChannel.flush();
                        }
                        if (byteBufferChannel != this) {
                            A0(Z() + (byteBufferChannel.Z() - Z));
                        }
                        byteBufferChannel.u0();
                        byteBufferChannel.H0();
                        throw th;
                    }
                }
                if (i11 == 0) {
                    return -1;
                }
                return i9;
            }
            throw new IllegalArgumentException(("Min(" + i8 + ") shouldn't be greater than 4088").toString());
        }
        throw new IllegalArgumentException("min should be positive".toString());
    }

    public Object O0(byte[] bArr, int i8, int i9, Continuation<? super Integer> continuation) {
        return P0(this, bArr, i8, i9, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02db A[Catch: all -> 0x03ae, TryCatch #10 {all -> 0x03ae, blocks: (B:129:0x02d5, B:131:0x02db, B:135:0x02e6, B:136:0x02f5, B:133:0x02e1), top: B:217:0x02d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02e6 A[Catch: all -> 0x03ae, TryCatch #10 {all -> 0x03ae, blocks: (B:129:0x02d5, B:131:0x02db, B:135:0x02e6, B:136:0x02f5, B:133:0x02e1), top: B:217:0x02d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0301 A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #7 {all -> 0x007c, blocks: (B:14:0x0047, B:50:0x0121, B:52:0x0127, B:54:0x012b, B:57:0x0132, B:139:0x0301, B:142:0x0309, B:144:0x0315, B:145:0x031a, B:147:0x0320, B:149:0x0329, B:153:0x0358, B:156:0x0362, B:166:0x0382, B:168:0x0386, B:160:0x036b, B:60:0x013a, B:181:0x03cf, B:183:0x03d5, B:187:0x03e0, B:188:0x03ed, B:189:0x03f3, B:185:0x03db, B:191:0x03f6, B:192:0x03f9, B:19:0x0076), top: B:212:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0320 A[Catch: all -> 0x007c, TryCatch #7 {all -> 0x007c, blocks: (B:14:0x0047, B:50:0x0121, B:52:0x0127, B:54:0x012b, B:57:0x0132, B:139:0x0301, B:142:0x0309, B:144:0x0315, B:145:0x031a, B:147:0x0320, B:149:0x0329, B:153:0x0358, B:156:0x0362, B:166:0x0382, B:168:0x0386, B:160:0x036b, B:60:0x013a, B:181:0x03cf, B:183:0x03d5, B:187:0x03e0, B:188:0x03ed, B:189:0x03f3, B:185:0x03db, B:191:0x03f6, B:192:0x03f9, B:19:0x0076), top: B:212:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0386 A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #7 {all -> 0x007c, blocks: (B:14:0x0047, B:50:0x0121, B:52:0x0127, B:54:0x012b, B:57:0x0132, B:139:0x0301, B:142:0x0309, B:144:0x0315, B:145:0x031a, B:147:0x0320, B:149:0x0329, B:153:0x0358, B:156:0x0362, B:166:0x0382, B:168:0x0386, B:160:0x036b, B:60:0x013a, B:181:0x03cf, B:183:0x03d5, B:187:0x03e0, B:188:0x03ed, B:189:0x03f3, B:185:0x03db, B:191:0x03f6, B:192:0x03f9, B:19:0x0076), top: B:212:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03d5 A[Catch: all -> 0x007c, TryCatch #7 {all -> 0x007c, blocks: (B:14:0x0047, B:50:0x0121, B:52:0x0127, B:54:0x012b, B:57:0x0132, B:139:0x0301, B:142:0x0309, B:144:0x0315, B:145:0x031a, B:147:0x0320, B:149:0x0329, B:153:0x0358, B:156:0x0362, B:166:0x0382, B:168:0x0386, B:160:0x036b, B:60:0x013a, B:181:0x03cf, B:183:0x03d5, B:187:0x03e0, B:188:0x03ed, B:189:0x03f3, B:185:0x03db, B:191:0x03f6, B:192:0x03f9, B:19:0x0076), top: B:212:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03e0 A[Catch: all -> 0x007c, TryCatch #7 {all -> 0x007c, blocks: (B:14:0x0047, B:50:0x0121, B:52:0x0127, B:54:0x012b, B:57:0x0132, B:139:0x0301, B:142:0x0309, B:144:0x0315, B:145:0x031a, B:147:0x0320, B:149:0x0329, B:153:0x0358, B:156:0x0362, B:166:0x0382, B:168:0x0386, B:160:0x036b, B:60:0x013a, B:181:0x03cf, B:183:0x03d5, B:187:0x03e0, B:188:0x03ed, B:189:0x03f3, B:185:0x03db, B:191:0x03f6, B:192:0x03f9, B:19:0x0076), top: B:212:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03f6 A[Catch: all -> 0x007c, TryCatch #7 {all -> 0x007c, blocks: (B:14:0x0047, B:50:0x0121, B:52:0x0127, B:54:0x012b, B:57:0x0132, B:139:0x0301, B:142:0x0309, B:144:0x0315, B:145:0x031a, B:147:0x0320, B:149:0x0329, B:153:0x0358, B:156:0x0362, B:166:0x0382, B:168:0x0386, B:160:0x036b, B:60:0x013a, B:181:0x03cf, B:183:0x03d5, B:187:0x03e0, B:188:0x03ed, B:189:0x03f3, B:185:0x03db, B:191:0x03f6, B:192:0x03f9, B:19:0x0076), top: B:212:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0272 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0127 A[Catch: all -> 0x007c, TryCatch #7 {all -> 0x007c, blocks: (B:14:0x0047, B:50:0x0121, B:52:0x0127, B:54:0x012b, B:57:0x0132, B:139:0x0301, B:142:0x0309, B:144:0x0315, B:145:0x031a, B:147:0x0320, B:149:0x0329, B:153:0x0358, B:156:0x0362, B:166:0x0382, B:168:0x0386, B:160:0x036b, B:60:0x013a, B:181:0x03cf, B:183:0x03d5, B:187:0x03e0, B:188:0x03ed, B:189:0x03f3, B:185:0x03db, B:191:0x03f6, B:192:0x03f9, B:19:0x0076), top: B:212:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015a A[Catch: all -> 0x03b2, TryCatch #1 {all -> 0x03b2, blocks: (B:64:0x0154, B:66:0x015a, B:68:0x015e), top: B:200:0x0154 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019b A[Catch: all -> 0x01ae, TRY_LEAVE, TryCatch #11 {all -> 0x01ae, blocks: (B:74:0x0197, B:76:0x019b), top: B:219:0x0197 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f0 A[Catch: all -> 0x02b9, TRY_LEAVE, TryCatch #4 {all -> 0x02b9, blocks: (B:86:0x01cf, B:90:0x01f0), top: B:206:0x01cf }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x0288 -> B:200:0x0154). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x0315 -> B:171:0x03aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:167:0x0384 -> B:171:0x03aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x03a7 -> B:171:0x03aa). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object P(io.ktor.utils.io.ByteBufferChannel r26, long r27, io.ktor.utils.io.internal.JoiningState r29, kotlin.coroutines.Continuation<? super java.lang.Long> r30) {
        /*
            Method dump skipped, instructions count: 1031
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.P(io.ktor.utils.io.ByteBufferChannel, long, io.ktor.utils.io.internal.JoiningState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ReadWriteBufferState Q() {
        return X();
    }

    public long Y() {
        return this.totalBytesRead;
    }

    public long Z() {
        return this.totalBytesWritten;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object a(long j8, Continuation<? super ByteReadPacket> continuation) {
        return k0(this, j8, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean b(Throwable th) {
        ClosedElement closedElement;
        JoiningState joiningState;
        if (V() != null) {
            return false;
        }
        if (th == null) {
            closedElement = ClosedElement.f47425b.a();
        } else {
            closedElement = new ClosedElement(th);
        }
        X().f47440b.e();
        if (!a.a(f47149n, this, null, closedElement)) {
            return false;
        }
        X().f47440b.e();
        if (X().f47440b.g() || th != null) {
            H0();
        }
        v0(th);
        if (X() == ReadWriteBufferState.Terminated.f47451c && (joiningState = this.joining) != null) {
            T(joiningState);
        }
        if (th != null) {
            Job job = this.attachedJob;
            if (job != null) {
                Job.DefaultImpls.a(job, null, 1, null);
            }
            this.f47159i.e(th);
            this.f47160j.e(th);
            return true;
        }
        this.f47160j.e(new ClosedWriteChannelException("Byte channel was closed"));
        this.f47159i.d(Boolean.valueOf(X().f47440b.e()));
        return true;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Throwable c() {
        ClosedElement V = V();
        if (V != null) {
            return V.b();
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public int d() {
        return X().f47440b._availableForRead$internal;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean e() {
        if (V() != null) {
            return true;
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object f(long j8, Continuation<? super Long> continuation) {
        return R(this, j8, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void flush() {
        U(1);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object g(byte[] bArr, int i8, int i9, Continuation<? super Integer> continuation) {
        return h0(this, bArr, i8, i9, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean h(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel has been cancelled");
        }
        return b(th);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object i(byte[] bArr, int i8, int i9, Continuation<? super Unit> continuation) {
        return R0(this, bArr, i8, i9, continuation);
    }

    @Override // io.ktor.utils.io.ByteChannel
    public void j(Job job) {
        Intrinsics.f(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.a(job2, null, 1, null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.d(job, true, false, new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.ByteBufferChannel$attachJob$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ByteBufferChannel.this.attachedJob = null;
                if (th == null) {
                    return;
                }
                ByteBufferChannel.this.h(ExceptionUtilsKt.a(th));
            }
        }, 2, null);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object k(Buffer buffer, Continuation<? super Unit> continuation) {
        return Q0(this, buffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object l(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return g0(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object m(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        return U0(this, byteReadPacket, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object n(int i8, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        return K0(this, i8, function1, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean o() {
        if (X() == ReadWriteBufferState.Terminated.f47451c && V() != null) {
            return true;
        }
        return false;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean p() {
        return this.f47152b;
    }

    public final ByteBufferChannel r0() {
        ByteBufferChannel s02;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (s02 = s0(this, joiningState)) == null) {
            return this;
        }
        return s02;
    }

    public String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + X() + ')';
    }

    public final void u0() {
        Object obj;
        ReadWriteBufferState f8;
        ReadWriteBufferState.IdleNonEmpty idleNonEmpty;
        ReadWriteBufferState.IdleNonEmpty idleNonEmpty2 = null;
        do {
            obj = this._state;
            f8 = ((ReadWriteBufferState) obj).f();
            if ((f8 instanceof ReadWriteBufferState.IdleNonEmpty) && f8.f47440b.g()) {
                f8 = ReadWriteBufferState.IdleEmpty.f47441c;
                idleNonEmpty2 = f8;
            }
        } while (!a.a(f47148m, this, obj, f8));
        if (f8 == ReadWriteBufferState.IdleEmpty.f47441c && (idleNonEmpty = idleNonEmpty2) != null) {
            p0(idleNonEmpty.g());
        }
    }

    public void z0(long j8) {
        this.totalBytesRead = j8;
    }

    public /* synthetic */ ByteBufferChannel(boolean z7, ObjectPool objectPool, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(z7, (i9 & 2) != 0 ? ObjectPoolKt.c() : objectPool, (i9 & 4) != 0 ? 8 : i8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel(ByteBuffer content) {
        this(false, ObjectPoolKt.b(), 0);
        Intrinsics.f(content, "content");
        ByteBuffer slice = content.slice();
        Intrinsics.e(slice, "content.slice()");
        ReadWriteBufferState.Initial initial = new ReadWriteBufferState.Initial(slice, 0);
        initial.f47440b.i();
        this._state = initial.d();
        u0();
        ByteWriteChannelKt.a(this);
        H0();
    }
}
