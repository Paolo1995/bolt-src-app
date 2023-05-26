package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes5.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {

    /* renamed from: k  reason: collision with root package name */
    private static final Integer f49641k = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: f  reason: collision with root package name */
    final int f49642f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicLong f49643g;

    /* renamed from: h  reason: collision with root package name */
    long f49644h;

    /* renamed from: i  reason: collision with root package name */
    final AtomicLong f49645i;

    /* renamed from: j  reason: collision with root package name */
    final int f49646j;

    public SpscArrayQueue(int i8) {
        super(Pow2.a(i8));
        this.f49642f = length() - 1;
        this.f49643g = new AtomicLong();
        this.f49645i = new AtomicLong();
        this.f49646j = Math.min(i8 / 4, f49641k.intValue());
    }

    int b(long j8) {
        return this.f49642f & ((int) j8);
    }

    int c(long j8, int i8) {
        return ((int) j8) & i8;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    E d(int i8) {
        return get(i8);
    }

    void e(long j8) {
        this.f49645i.lazySet(j8);
    }

    void f(int i8, E e8) {
        lazySet(i8, e8);
    }

    void g(long j8) {
        this.f49643g.lazySet(j8);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (this.f49643g.get() == this.f49645i.get()) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e8) {
        if (e8 != null) {
            int i8 = this.f49642f;
            long j8 = this.f49643g.get();
            int c8 = c(j8, i8);
            if (j8 >= this.f49644h) {
                long j9 = this.f49646j + j8;
                if (d(c(j9, i8)) == null) {
                    this.f49644h = j9;
                } else if (d(c8) != null) {
                    return false;
                }
            }
            f(c8, e8);
            g(j8 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public E poll() {
        long j8 = this.f49645i.get();
        int b8 = b(j8);
        E d8 = d(b8);
        if (d8 == null) {
            return null;
        }
        e(j8 + 1);
        f(b8, null);
        return d8;
    }
}
