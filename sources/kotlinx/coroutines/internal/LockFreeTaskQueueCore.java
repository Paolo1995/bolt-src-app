package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes5.dex */
public final class LockFreeTaskQueueCore<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f51815a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f51816b;

    /* renamed from: c  reason: collision with root package name */
    private final int f51817c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f51818d;

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f51811e = new Companion(null);

    /* renamed from: h  reason: collision with root package name */
    public static final Symbol f51814h = new Symbol("REMOVE_FROZEN");

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f51812f = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f51813g = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j8) {
            return (j8 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j8, int i8) {
            return d(j8, 1073741823L) | (i8 << 0);
        }

        public final long c(long j8, int i8) {
            return d(j8, 1152921503533105152L) | (i8 << 30);
        }

        public final long d(long j8, long j9) {
            return j8 & (~j9);
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes5.dex */
    public static final class Placeholder {

        /* renamed from: a  reason: collision with root package name */
        public final int f51819a;

        public Placeholder(int i8) {
            this.f51819a = i8;
        }
    }

    public LockFreeTaskQueueCore(int i8, boolean z7) {
        boolean z8;
        this.f51815a = i8;
        this.f51816b = z7;
        int i9 = i8 - 1;
        this.f51817c = i9;
        this.f51818d = new AtomicReferenceArray(i8);
        if (i9 <= 1073741823) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            if ((i8 & i9) == 0) {
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> b(long j8) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.f51815a * 2, this.f51816b);
        int i8 = (int) ((1073741823 & j8) >> 0);
        int i9 = (int) ((1152921503533105152L & j8) >> 30);
        while (true) {
            int i10 = this.f51817c;
            if ((i8 & i10) != (i9 & i10)) {
                Object obj = this.f51818d.get(i10 & i8);
                if (obj == null) {
                    obj = new Placeholder(i8);
                }
                lockFreeTaskQueueCore.f51818d.set(lockFreeTaskQueueCore.f51817c & i8, obj);
                i8++;
            } else {
                lockFreeTaskQueueCore._state = f51811e.d(j8, 1152921504606846976L);
                return lockFreeTaskQueueCore;
            }
        }
    }

    private final LockFreeTaskQueueCore<E> c(long j8) {
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            a.a(f51812f, this, null, b(j8));
        }
    }

    private final LockFreeTaskQueueCore<E> e(int i8, E e8) {
        Object obj = this.f51818d.get(this.f51817c & i8);
        if ((obj instanceof Placeholder) && ((Placeholder) obj).f51819a == i8) {
            this.f51818d.set(i8 & this.f51817c, e8);
            return this;
        }
        return null;
    }

    private final long h() {
        long j8;
        long j9;
        do {
            j8 = this._state;
            if ((j8 & 1152921504606846976L) != 0) {
                return j8;
            }
            j9 = j8 | 1152921504606846976L;
        } while (!f51813g.compareAndSet(this, j8, j9));
        return j9;
    }

    private final LockFreeTaskQueueCore<E> k(int i8, int i9) {
        long j8;
        int i10;
        do {
            j8 = this._state;
            i10 = (int) ((1073741823 & j8) >> 0);
            if ((1152921504606846976L & j8) != 0) {
                return i();
            }
        } while (!f51813g.compareAndSet(this, j8, f51811e.b(j8, i9)));
        this.f51818d.set(i10 & this.f51817c, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(E r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r13 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f51811e
            int r13 = r13.a(r2)
            return r13
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r9 = (int) r4
            int r10 = r12.f51817c
            int r0 = r9 + 2
            r0 = r0 & r10
            r4 = r1 & r10
            r5 = 1
            if (r0 != r4) goto L2e
            return r5
        L2e:
            boolean r0 = r12.f51816b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f51818d
            r11 = r9 & r10
            java.lang.Object r0 = r0.get(r11)
            if (r0 == 0) goto L4d
            int r0 = r12.f51815a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4c
            int r9 = r9 - r1
            r1 = r9 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4c:
            return r5
        L4d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f51813g
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r4 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f51811e
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f51818d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L68:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L7b
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.i()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.e(r9, r13)
            if (r0 != 0) goto L68
        L7b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j8;
        do {
            j8 = this._state;
            if ((j8 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j8) != 0) {
                return false;
            }
        } while (!f51813g.compareAndSet(this, j8, j8 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j8 = this._state;
        return 1073741823 & (((int) ((j8 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j8) >> 0)));
    }

    public final boolean g() {
        long j8 = this._state;
        if (((int) ((1073741823 & j8) >> 0)) != ((int) ((j8 & 1152921503533105152L) >> 30))) {
            return false;
        }
        return true;
    }

    public final LockFreeTaskQueueCore<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j8 = this._state;
            if ((1152921504606846976L & j8) != 0) {
                return f51814h;
            }
            int i8 = (int) ((1073741823 & j8) >> 0);
            int i9 = (int) ((1152921503533105152L & j8) >> 30);
            int i10 = this.f51817c;
            if ((i9 & i10) == (i8 & i10)) {
                return null;
            }
            Object obj = this.f51818d.get(i10 & i8);
            if (obj == null) {
                if (this.f51816b) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                int i11 = (i8 + 1) & 1073741823;
                if (f51813g.compareAndSet(this, j8, f51811e.b(j8, i11))) {
                    this.f51818d.set(this.f51817c & i8, null);
                    return obj;
                } else if (this.f51816b) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    do {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.k(i8, i11);
                    } while (lockFreeTaskQueueCore != null);
                    return obj;
                }
            }
        }
    }
}
