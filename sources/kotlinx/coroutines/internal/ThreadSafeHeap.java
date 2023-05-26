package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes5.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    private T[] f51844a;

    private final T[] f() {
        T[] tArr = this.f51844a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.f51844a = tArr2;
            return tArr2;
        } else if (c() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
            Intrinsics.e(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.f51844a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void j(int i8) {
        this._size = i8;
    }

    private final void k(int i8) {
        while (true) {
            int i9 = (i8 * 2) + 1;
            if (i9 >= c()) {
                return;
            }
            T[] tArr = this.f51844a;
            Intrinsics.c(tArr);
            int i10 = i9 + 1;
            if (i10 < c()) {
                T t7 = tArr[i10];
                Intrinsics.c(t7);
                T t8 = tArr[i9];
                Intrinsics.c(t8);
                if (((Comparable) t7).compareTo(t8) < 0) {
                    i9 = i10;
                }
            }
            T t9 = tArr[i8];
            Intrinsics.c(t9);
            T t10 = tArr[i9];
            Intrinsics.c(t10);
            if (((Comparable) t9).compareTo(t10) <= 0) {
                return;
            }
            m(i8, i9);
            i8 = i9;
        }
    }

    private final void l(int i8) {
        while (i8 > 0) {
            T[] tArr = this.f51844a;
            Intrinsics.c(tArr);
            int i9 = (i8 - 1) / 2;
            T t7 = tArr[i9];
            Intrinsics.c(t7);
            T t8 = tArr[i8];
            Intrinsics.c(t8);
            if (((Comparable) t7).compareTo(t8) <= 0) {
                return;
            }
            m(i8, i9);
            i8 = i9;
        }
    }

    private final void m(int i8, int i9) {
        T[] tArr = this.f51844a;
        Intrinsics.c(tArr);
        T t7 = tArr[i9];
        Intrinsics.c(t7);
        T t8 = tArr[i8];
        Intrinsics.c(t8);
        tArr[i8] = t7;
        tArr[i9] = t8;
        t7.setIndex(i8);
        t8.setIndex(i9);
    }

    public final void a(T t7) {
        t7.a(this);
        T[] f8 = f();
        int c8 = c();
        j(c8 + 1);
        f8[c8] = t7;
        t7.setIndex(c8);
        l(c8);
    }

    public final T b() {
        T[] tArr = this.f51844a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        if (c() == 0) {
            return true;
        }
        return false;
    }

    public final T e() {
        T b8;
        synchronized (this) {
            b8 = b();
        }
        return b8;
    }

    public final boolean g(T t7) {
        boolean z7;
        synchronized (this) {
            if (t7.c() == null) {
                z7 = false;
            } else {
                h(t7.getIndex());
                z7 = true;
            }
        }
        return z7;
    }

    public final T h(int i8) {
        T[] tArr = this.f51844a;
        Intrinsics.c(tArr);
        j(c() - 1);
        if (i8 < c()) {
            m(i8, c());
            int i9 = (i8 - 1) / 2;
            if (i8 > 0) {
                T t7 = tArr[i8];
                Intrinsics.c(t7);
                T t8 = tArr[i9];
                Intrinsics.c(t8);
                if (((Comparable) t7).compareTo(t8) < 0) {
                    m(i8, i9);
                    l(i9);
                }
            }
            k(i8);
        }
        T t9 = tArr[c()];
        Intrinsics.c(t9);
        t9.a(null);
        t9.setIndex(-1);
        tArr[c()] = null;
        return t9;
    }

    public final T i() {
        T t7;
        synchronized (this) {
            if (c() > 0) {
                t7 = h(0);
            } else {
                t7 = null;
            }
        }
        return t7;
    }
}
