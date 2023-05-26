package j$.util.stream;

import j$.util.Spliterator;
import java.util.Arrays;

/* loaded from: classes2.dex */
abstract class P2 extends AbstractC0181e implements Iterable {

    /* renamed from: e  reason: collision with root package name */
    Object f50463e;

    /* renamed from: f  reason: collision with root package name */
    Object[] f50464f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P2() {
        this.f50463e = newArray(16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public P2(int i8) {
        super(i8);
        this.f50463e = newArray(1 << this.f50566a);
    }

    public Object b() {
        long count = count();
        if (count < 2147483639) {
            Object newArray = newArray((int) count);
            c(0, newArray);
            return newArray;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void c(int i8, Object obj) {
        long j8 = i8;
        long count = count() + j8;
        if (count > s(obj) || count < j8) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.f50568c == 0) {
            System.arraycopy(this.f50463e, 0, obj, i8, this.f50567b);
            return;
        }
        for (int i9 = 0; i9 < this.f50568c; i9++) {
            Object obj2 = this.f50464f[i9];
            System.arraycopy(obj2, 0, obj, i8, s(obj2));
            i8 += s(this.f50464f[i9]);
        }
        int i10 = this.f50567b;
        if (i10 > 0) {
            System.arraycopy(this.f50463e, 0, obj, i8, i10);
        }
    }

    @Override // j$.util.stream.AbstractC0181e
    public final void clear() {
        Object[] objArr = this.f50464f;
        if (objArr != null) {
            this.f50463e = objArr[0];
            this.f50464f = null;
            this.f50569d = null;
        }
        this.f50567b = 0;
        this.f50568c = 0;
    }

    public void d(Object obj) {
        for (int i8 = 0; i8 < this.f50568c; i8++) {
            Object obj2 = this.f50464f[i8];
            r(obj2, 0, s(obj2), obj);
        }
        r(this.f50463e, 0, this.f50567b, obj);
    }

    public abstract Object newArray(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void r(Object obj, int i8, int i9, Object obj2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int s(Object obj);

    public abstract Spliterator spliterator();

    @Override // java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int t(long j8) {
        if (this.f50568c == 0) {
            if (j8 < this.f50567b) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j8));
        } else if (j8 < count()) {
            for (int i8 = 0; i8 <= this.f50568c; i8++) {
                if (j8 < this.f50569d[i8] + s(this.f50464f[i8])) {
                    return i8;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j8));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j8));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(long j8) {
        int i8;
        int i9 = this.f50568c;
        long s7 = i9 == 0 ? s(this.f50463e) : s(this.f50464f[i9]) + this.f50569d[i9];
        if (j8 <= s7) {
            return;
        }
        if (this.f50464f == null) {
            Object[] v7 = v();
            this.f50464f = v7;
            this.f50569d = new long[8];
            v7[0] = this.f50463e;
        }
        int i10 = this.f50568c;
        while (true) {
            i10++;
            if (j8 <= s7) {
                return;
            }
            Object[] objArr = this.f50464f;
            if (i10 >= objArr.length) {
                int length = objArr.length * 2;
                this.f50464f = Arrays.copyOf(objArr, length);
                this.f50569d = Arrays.copyOf(this.f50569d, length);
            }
            int min = 1 << ((i10 == 0 || i10 == 1) ? this.f50566a : Math.min((this.f50566a + i10) - 1, 30));
            this.f50464f[i10] = newArray(min);
            long[] jArr = this.f50569d;
            jArr[i10] = jArr[i10 - 1] + s(this.f50464f[i8]);
            s7 += min;
        }
    }

    protected abstract Object[] v();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w() {
        long s7;
        if (this.f50567b == s(this.f50463e)) {
            if (this.f50464f == null) {
                Object[] v7 = v();
                this.f50464f = v7;
                this.f50569d = new long[8];
                v7[0] = this.f50463e;
            }
            int i8 = this.f50568c;
            int i9 = i8 + 1;
            Object[] objArr = this.f50464f;
            if (i9 >= objArr.length || objArr[i9] == null) {
                if (i8 == 0) {
                    s7 = s(this.f50463e);
                } else {
                    s7 = s(objArr[i8]) + this.f50569d[i8];
                }
                u(s7 + 1);
            }
            this.f50567b = 0;
            int i10 = this.f50568c + 1;
            this.f50568c = i10;
            this.f50463e = this.f50464f[i10];
        }
    }
}
