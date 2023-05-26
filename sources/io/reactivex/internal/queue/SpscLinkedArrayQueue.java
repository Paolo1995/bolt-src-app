package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes5.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: n  reason: collision with root package name */
    static final int f49647n = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: o  reason: collision with root package name */
    private static final Object f49648o = new Object();

    /* renamed from: g  reason: collision with root package name */
    int f49650g;

    /* renamed from: h  reason: collision with root package name */
    long f49651h;

    /* renamed from: i  reason: collision with root package name */
    final int f49652i;

    /* renamed from: j  reason: collision with root package name */
    AtomicReferenceArray<Object> f49653j;

    /* renamed from: k  reason: collision with root package name */
    final int f49654k;

    /* renamed from: l  reason: collision with root package name */
    AtomicReferenceArray<Object> f49655l;

    /* renamed from: f  reason: collision with root package name */
    final AtomicLong f49649f = new AtomicLong();

    /* renamed from: m  reason: collision with root package name */
    final AtomicLong f49656m = new AtomicLong();

    public SpscLinkedArrayQueue(int i8) {
        int a8 = Pow2.a(Math.max(8, i8));
        int i9 = a8 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a8 + 1);
        this.f49653j = atomicReferenceArray;
        this.f49652i = i9;
        b(a8);
        this.f49655l = atomicReferenceArray;
        this.f49654k = i9;
        this.f49651h = i9 - 1;
        t(0L);
    }

    private void b(int i8) {
        this.f49650g = Math.min(i8 / 4, f49647n);
    }

    private static int c(int i8) {
        return i8;
    }

    private static int d(long j8, int i8) {
        return c(((int) j8) & i8);
    }

    private long e() {
        return this.f49656m.get();
    }

    private long f() {
        return this.f49649f.get();
    }

    private long g() {
        return this.f49656m.get();
    }

    private static <E> Object h(AtomicReferenceArray<Object> atomicReferenceArray, int i8) {
        return atomicReferenceArray.get(i8);
    }

    private AtomicReferenceArray<Object> i(AtomicReferenceArray<Object> atomicReferenceArray, int i8) {
        int c8 = c(i8);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) h(atomicReferenceArray, c8);
        r(atomicReferenceArray, c8, null);
        return atomicReferenceArray2;
    }

    private long j() {
        return this.f49649f.get();
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j8, int i8) {
        this.f49655l = atomicReferenceArray;
        return (T) h(atomicReferenceArray, d(j8, i8));
    }

    private T l(AtomicReferenceArray<Object> atomicReferenceArray, long j8, int i8) {
        this.f49655l = atomicReferenceArray;
        int d8 = d(j8, i8);
        T t7 = (T) h(atomicReferenceArray, d8);
        if (t7 != null) {
            r(atomicReferenceArray, d8, null);
            q(j8 + 1);
        }
        return t7;
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, long j8, int i8, T t7, long j9) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f49653j = atomicReferenceArray2;
        this.f49651h = (j9 + j8) - 1;
        r(atomicReferenceArray2, i8, t7);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, i8, f49648o);
        t(j8 + 1);
    }

    private void q(long j8) {
        this.f49656m.lazySet(j8);
    }

    private static void r(AtomicReferenceArray<Object> atomicReferenceArray, int i8, Object obj) {
        atomicReferenceArray.lazySet(i8, obj);
    }

    private void s(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        r(atomicReferenceArray, c(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void t(long j8) {
        this.f49649f.lazySet(j8);
    }

    private boolean u(AtomicReferenceArray<Object> atomicReferenceArray, T t7, long j8, int i8) {
        r(atomicReferenceArray, i8, t7);
        t(j8 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (j() == g()) {
            return true;
        }
        return false;
    }

    public boolean m(T t7, T t8) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f49653j;
        long j8 = j();
        int i8 = this.f49652i;
        long j9 = 2 + j8;
        if (h(atomicReferenceArray, d(j9, i8)) == null) {
            int d8 = d(j8, i8);
            r(atomicReferenceArray, d8 + 1, t8);
            r(atomicReferenceArray, d8, t7);
            t(j9);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f49653j = atomicReferenceArray2;
        int d9 = d(j8, i8);
        r(atomicReferenceArray2, d9 + 1, t8);
        r(atomicReferenceArray2, d9, t7);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, d9, f49648o);
        t(j9);
        return true;
    }

    public T n() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f49655l;
        long e8 = e();
        int i8 = this.f49654k;
        T t7 = (T) h(atomicReferenceArray, d(e8, i8));
        if (t7 == f49648o) {
            return k(i(atomicReferenceArray, i8 + 1), e8, i8);
        }
        return t7;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t7) {
        if (t7 != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f49653j;
            long f8 = f();
            int i8 = this.f49652i;
            int d8 = d(f8, i8);
            if (f8 < this.f49651h) {
                return u(atomicReferenceArray, t7, f8, d8);
            }
            long j8 = this.f49650g + f8;
            if (h(atomicReferenceArray, d(j8, i8)) == null) {
                this.f49651h = j8 - 1;
                return u(atomicReferenceArray, t7, f8, d8);
            } else if (h(atomicReferenceArray, d(1 + f8, i8)) == null) {
                return u(atomicReferenceArray, t7, f8, d8);
            } else {
                o(atomicReferenceArray, f8, d8, t7, i8);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public int p() {
        long g8 = g();
        while (true) {
            long j8 = j();
            long g9 = g();
            if (g8 == g9) {
                return (int) (j8 - g9);
            }
            g8 = g9;
        }
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        boolean z7;
        AtomicReferenceArray<Object> atomicReferenceArray = this.f49655l;
        long e8 = e();
        int i8 = this.f49654k;
        int d8 = d(e8, i8);
        T t7 = (T) h(atomicReferenceArray, d8);
        if (t7 == f49648o) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (t7 != null && !z7) {
            r(atomicReferenceArray, d8, null);
            q(e8 + 1);
            return t7;
        } else if (!z7) {
            return null;
        } else {
            return l(i(atomicReferenceArray, i8 + 1), e8, i8);
        }
    }
}
