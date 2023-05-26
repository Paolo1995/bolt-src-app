package io.ktor.utils.io.pool;

import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* compiled from: DefaultPool.kt */
/* loaded from: classes5.dex */
public abstract class DefaultPool<T> implements ObjectPool<T> {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f47510k = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicLongFieldUpdater<DefaultPool<?>> f47511l;

    /* renamed from: f  reason: collision with root package name */
    private final int f47512f;

    /* renamed from: g  reason: collision with root package name */
    private final int f47513g;

    /* renamed from: h  reason: collision with root package name */
    private final int f47514h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicReferenceArray<T> f47515i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f47516j;
    private volatile long top;

    /* compiled from: DefaultPool.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        AtomicLongFieldUpdater<DefaultPool<?>> newUpdater = AtomicLongFieldUpdater.newUpdater(DefaultPool.class, new MutablePropertyReference1Impl() { // from class: io.ktor.utils.io.pool.DefaultPool$Companion$Top$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                long j8;
                j8 = ((DefaultPool) obj).top;
                return Long.valueOf(j8);
            }
        }.getName());
        Intrinsics.e(newUpdater, "newUpdater(Owner::class.java, p.name)");
        f47511l = newUpdater;
    }

    public DefaultPool(int i8) {
        boolean z7;
        this.f47512f = i8;
        if (i8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 <= 536870911) {
                int highestOneBit = Integer.highestOneBit((i8 * 4) - 1) * 2;
                this.f47513g = highestOneBit;
                this.f47514h = Integer.numberOfLeadingZeros(highestOneBit) + 1;
                this.f47515i = new AtomicReferenceArray<>(highestOneBit + 1);
                this.f47516j = new int[highestOneBit + 1];
                return;
            }
            throw new IllegalArgumentException(("capacity should be less or equal to 536870911 but it is " + i8).toString());
        }
        throw new IllegalArgumentException(("capacity should be positive but it is " + i8).toString());
    }

    private final int g() {
        long j8;
        long j9;
        int i8;
        do {
            j8 = this.top;
            if (j8 == 0) {
                return 0;
            }
            j9 = ((j8 >> 32) & 4294967295L) + 1;
            i8 = (int) (4294967295L & j8);
            if (i8 == 0) {
                return 0;
            }
        } while (!f47511l.compareAndSet(this, j8, (j9 << 32) | this.f47516j[i8]));
        return i8;
    }

    private final void j(int i8) {
        boolean z7;
        long j8;
        long j9;
        if (i8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            do {
                j8 = this.top;
                j9 = i8 | ((((j8 >> 32) & 4294967295L) + 1) << 32);
                this.f47516j[i8] = (int) (4294967295L & j8);
            } while (!f47511l.compareAndSet(this, j8, j9));
            return;
        }
        throw new IllegalArgumentException("index should be positive".toString());
    }

    private final T k() {
        int g8 = g();
        if (g8 == 0) {
            return null;
        }
        return this.f47515i.getAndSet(g8, null);
    }

    private final boolean l(T t7) {
        int identityHashCode = ((System.identityHashCode(t7) * (-1640531527)) >>> this.f47514h) + 1;
        for (int i8 = 0; i8 < 8; i8++) {
            if (a.a(this.f47515i, identityHashCode, null, t7)) {
                j(identityHashCode);
                return true;
            }
            identityHashCode--;
            if (identityHashCode == 0) {
                identityHashCode = this.f47513g;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T c(T instance) {
        Intrinsics.f(instance, "instance");
        return instance;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
        while (true) {
            T k8 = k();
            if (k8 == null) {
                return;
            }
            e(k8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(T instance) {
        Intrinsics.f(instance, "instance");
    }

    protected abstract T h();

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(T instance) {
        Intrinsics.f(instance, "instance");
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(T instance) {
        Intrinsics.f(instance, "instance");
        m(instance);
        if (!l(instance)) {
            e(instance);
        }
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final T u0() {
        T c8;
        T k8 = k();
        if (k8 == null || (c8 = c(k8)) == null) {
            return h();
        }
        return c8;
    }
}
