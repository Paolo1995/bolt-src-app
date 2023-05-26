package io.reactivex.internal.util;

/* loaded from: classes5.dex */
public final class OpenHashSet<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f49816a;

    /* renamed from: b  reason: collision with root package name */
    int f49817b;

    /* renamed from: c  reason: collision with root package name */
    int f49818c;

    /* renamed from: d  reason: collision with root package name */
    int f49819d;

    /* renamed from: e  reason: collision with root package name */
    T[] f49820e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    static int c(int i8) {
        int i9 = i8 * (-1640531527);
        return i9 ^ (i9 >>> 16);
    }

    public boolean a(T t7) {
        T t8;
        T[] tArr = this.f49820e;
        int i8 = this.f49817b;
        int c8 = c(t7.hashCode()) & i8;
        T t9 = tArr[c8];
        if (t9 != null) {
            if (t9.equals(t7)) {
                return false;
            }
            do {
                c8 = (c8 + 1) & i8;
                t8 = tArr[c8];
                if (t8 == null) {
                }
            } while (!t8.equals(t7));
            return false;
        }
        tArr[c8] = t7;
        int i9 = this.f49818c + 1;
        this.f49818c = i9;
        if (i9 >= this.f49819d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f49820e;
    }

    void d() {
        T t7;
        T[] tArr = this.f49820e;
        int length = tArr.length;
        int i8 = length << 1;
        int i9 = i8 - 1;
        T[] tArr2 = (T[]) new Object[i8];
        int i10 = this.f49818c;
        while (true) {
            int i11 = i10 - 1;
            if (i10 != 0) {
                do {
                    length--;
                    t7 = tArr[length];
                } while (t7 == null);
                int c8 = c(t7.hashCode()) & i9;
                if (tArr2[c8] != null) {
                    do {
                        c8 = (c8 + 1) & i9;
                    } while (tArr2[c8] != null);
                }
                tArr2[c8] = tArr[length];
                i10 = i11;
            } else {
                this.f49817b = i9;
                this.f49819d = (int) (i8 * this.f49816a);
                this.f49820e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t7) {
        T t8;
        T[] tArr = this.f49820e;
        int i8 = this.f49817b;
        int c8 = c(t7.hashCode()) & i8;
        T t9 = tArr[c8];
        if (t9 == null) {
            return false;
        }
        if (t9.equals(t7)) {
            return f(c8, tArr, i8);
        }
        do {
            c8 = (c8 + 1) & i8;
            t8 = tArr[c8];
            if (t8 == null) {
                return false;
            }
        } while (!t8.equals(t7));
        return f(c8, tArr, i8);
    }

    boolean f(int i8, T[] tArr, int i9) {
        int i10;
        T t7;
        this.f49818c--;
        while (true) {
            int i11 = i8 + 1;
            while (true) {
                i10 = i11 & i9;
                t7 = tArr[i10];
                if (t7 == null) {
                    tArr[i8] = null;
                    return true;
                }
                int c8 = c(t7.hashCode()) & i9;
                if (i8 <= i10) {
                    if (i8 < c8 && c8 <= i10) {
                        i11 = i10 + 1;
                    }
                } else {
                    if (i8 >= c8 && c8 > i10) {
                        break;
                    }
                    i11 = i10 + 1;
                }
            }
            tArr[i8] = t7;
            i8 = i10;
        }
    }

    public int g() {
        return this.f49818c;
    }

    public OpenHashSet(int i8) {
        this(i8, 0.75f);
    }

    public OpenHashSet(int i8, float f8) {
        this.f49816a = f8;
        int a8 = Pow2.a(i8);
        this.f49817b = a8 - 1;
        this.f49819d = (int) (f8 * a8);
        this.f49820e = (T[]) new Object[a8];
    }
}
