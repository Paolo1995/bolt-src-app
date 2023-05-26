package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
/* loaded from: classes5.dex */
public final class SemaphoreImpl implements Semaphore {

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f52015c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f52016d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f52017e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f52018f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f52019g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    volatile /* synthetic */ int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    private final int f52020a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Throwable, Unit> f52021b;
    private volatile /* synthetic */ long deqIdx = 0;
    private volatile /* synthetic */ long enqIdx = 0;
    private volatile /* synthetic */ Object head;
    private volatile /* synthetic */ Object tail;

    public SemaphoreImpl(int i8, int i9) {
        boolean z7;
        this.f52020a = i8;
        boolean z8 = true;
        if (i8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if ((i9 < 0 || i9 > i8) ? false : false) {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = i8 - i9;
                this.f52021b = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
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
                        SemaphoreImpl.this.release();
                    }
                };
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i8).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i8).toString());
    }

    private final Object d(Continuation<? super Unit> continuation) {
        Continuation c8;
        Object d8;
        Object d9;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl b8 = CancellableContinuationKt.b(c8);
        while (true) {
            if (!e(b8)) {
                if (f52019g.getAndDecrement(this) > 0) {
                    b8.r(Unit.f50853a, this.f52021b);
                    break;
                }
            } else {
                break;
            }
        }
        Object v7 = b8.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d9) {
            return v7;
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0074, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.Object r2 = r0.tail
            kotlinx.coroutines.sync.SemaphoreSegment r2 = (kotlinx.coroutines.sync.SemaphoreSegment) r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.sync.SemaphoreImpl.f52018f
            long r3 = r3.getAndIncrement(r0)
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.h()
            long r5 = (long) r5
            long r5 = r3 / r5
        L15:
            r7 = r2
        L16:
            long r8 = r7.m()
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 < 0) goto L2a
            boolean r8 = r7.g()
            if (r8 == 0) goto L25
            goto L2a
        L25:
            java.lang.Object r7 = kotlinx.coroutines.internal.SegmentOrClosed.a(r7)
            goto L3c
        L2a:
            java.lang.Object r8 = kotlinx.coroutines.internal.ConcurrentLinkedListNode.a(r7)
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.a()
            if (r8 != r9) goto Lb9
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.a()
            java.lang.Object r7 = kotlinx.coroutines.internal.SegmentOrClosed.a(r7)
        L3c:
            boolean r8 = kotlinx.coroutines.internal.SegmentOrClosed.c(r7)
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L81
            kotlinx.coroutines.internal.Segment r8 = kotlinx.coroutines.internal.SegmentOrClosed.b(r7)
        L48:
            java.lang.Object r11 = r0.tail
            kotlinx.coroutines.internal.Segment r11 = (kotlinx.coroutines.internal.Segment) r11
            long r12 = r11.m()
            long r14 = r8.m()
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 < 0) goto L5a
        L58:
            r8 = 1
            goto L74
        L5a:
            boolean r12 = r8.p()
            if (r12 != 0) goto L62
            r8 = 0
            goto L74
        L62:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = kotlinx.coroutines.sync.SemaphoreImpl.f52017e
            boolean r12 = androidx.concurrent.futures.a.a(r12, r0, r11, r8)
            if (r12 == 0) goto L77
            boolean r8 = r11.l()
            if (r8 == 0) goto L58
            r11.j()
            goto L58
        L74:
            if (r8 == 0) goto L15
            goto L81
        L77:
            boolean r11 = r8.l()
            if (r11 == 0) goto L48
            r8.j()
            goto L48
        L81:
            kotlinx.coroutines.internal.Segment r2 = kotlinx.coroutines.internal.SegmentOrClosed.b(r7)
            kotlinx.coroutines.sync.SemaphoreSegment r2 = (kotlinx.coroutines.sync.SemaphoreSegment) r2
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.h()
            long r5 = (long) r5
            long r3 = r3 % r5
            int r4 = (int) r3
            r3 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.f52029e
            boolean r3 = io.ktor.utils.io.pool.a.a(r5, r4, r3, r1)
            if (r3 == 0) goto La0
            kotlinx.coroutines.sync.CancelSemaphoreAcquisitionHandler r3 = new kotlinx.coroutines.sync.CancelSemaphoreAcquisitionHandler
            r3.<init>(r2, r4)
            r1.o(r3)
            return r10
        La0:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.sync.SemaphoreKt.g()
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.sync.SemaphoreKt.i()
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r2.f52029e
            boolean r2 = io.ktor.utils.io.pool.a.a(r2, r4, r3, r5)
            if (r2 == 0) goto Lb8
            kotlin.Unit r2 = kotlin.Unit.f50853a
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r3 = r0.f52021b
            r1.r(r2, r3)
            return r10
        Lb8:
            return r9
        Lb9:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r8 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r8
            kotlinx.coroutines.internal.Segment r8 = (kotlinx.coroutines.internal.Segment) r8
            if (r8 == 0) goto Lc2
        Lbf:
            r7 = r8
            goto L16
        Lc2:
            long r8 = r7.m()
            r10 = 1
            long r8 = r8 + r10
            r10 = r7
            kotlinx.coroutines.sync.SemaphoreSegment r10 = (kotlinx.coroutines.sync.SemaphoreSegment) r10
            kotlinx.coroutines.sync.SemaphoreSegment r8 = kotlinx.coroutines.sync.SemaphoreKt.c(r8, r10)
            boolean r9 = r7.k(r8)
            if (r9 == 0) goto L16
            boolean r9 = r7.g()
            if (r9 == 0) goto Lbf
            r7.j()
            goto Lbf
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.e(kotlinx.coroutines.CancellableContinuation):boolean");
    }

    private final boolean f(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object B = cancellableContinuation.B(Unit.f50853a, null, this.f52021b);
        if (B == null) {
            return false;
        }
        cancellableContinuation.G(B);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0070, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean g() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.g():boolean");
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object a(Continuation<? super Unit> continuation) {
        Object d8;
        if (f52019g.getAndDecrement(this) > 0) {
            return Unit.f50853a;
        }
        Object d9 = d(continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (d9 == d8) {
            return d9;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        boolean z7;
        while (true) {
            int i8 = this._availablePermits;
            if (i8 < this.f52020a) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                if (f52019g.compareAndSet(this, i8, i8 + 1) && (i8 >= 0 || g())) {
                    return;
                }
            } else {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f52020a).toString());
            }
        }
    }
}
