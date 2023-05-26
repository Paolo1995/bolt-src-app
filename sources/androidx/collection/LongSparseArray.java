package androidx.collection;

/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {

    /* renamed from: j  reason: collision with root package name */
    private static final Object f4254j = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f4255f;

    /* renamed from: g  reason: collision with root package name */
    private long[] f4256g;

    /* renamed from: h  reason: collision with root package name */
    private Object[] f4257h;

    /* renamed from: i  reason: collision with root package name */
    private int f4258i;

    public LongSparseArray() {
        this(10);
    }

    private void e() {
        int i8 = this.f4258i;
        long[] jArr = this.f4256g;
        Object[] objArr = this.f4257h;
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            Object obj = objArr[i10];
            if (obj != f4254j) {
                if (i10 != i9) {
                    jArr[i9] = jArr[i10];
                    objArr[i9] = obj;
                    objArr[i10] = null;
                }
                i9++;
            }
        }
        this.f4255f = false;
        this.f4258i = i9;
    }

    public void a(long j8, E e8) {
        int i8 = this.f4258i;
        if (i8 != 0 && j8 <= this.f4256g[i8 - 1]) {
            l(j8, e8);
            return;
        }
        if (this.f4255f && i8 >= this.f4256g.length) {
            e();
        }
        int i9 = this.f4258i;
        if (i9 >= this.f4256g.length) {
            int f8 = ContainerHelpers.f(i9 + 1);
            long[] jArr = new long[f8];
            Object[] objArr = new Object[f8];
            long[] jArr2 = this.f4256g;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f4257h;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f4256g = jArr;
            this.f4257h = objArr;
        }
        this.f4256g[i9] = j8;
        this.f4257h[i9] = e8;
        this.f4258i = i9 + 1;
    }

    public void b() {
        int i8 = this.f4258i;
        Object[] objArr = this.f4257h;
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[i9] = null;
        }
        this.f4258i = 0;
        this.f4255f = false;
    }

    /* renamed from: c */
    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.f4256g = (long[]) this.f4256g.clone();
            longSparseArray.f4257h = (Object[]) this.f4257h.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e8) {
            throw new AssertionError(e8);
        }
    }

    public boolean d(long j8) {
        if (i(j8) >= 0) {
            return true;
        }
        return false;
    }

    public E f(long j8) {
        return h(j8, null);
    }

    public E h(long j8, E e8) {
        E e9;
        int b8 = ContainerHelpers.b(this.f4256g, this.f4258i, j8);
        if (b8 >= 0 && (e9 = (E) this.f4257h[b8]) != f4254j) {
            return e9;
        }
        return e8;
    }

    public int i(long j8) {
        if (this.f4255f) {
            e();
        }
        return ContainerHelpers.b(this.f4256g, this.f4258i, j8);
    }

    public boolean j() {
        if (o() == 0) {
            return true;
        }
        return false;
    }

    public long k(int i8) {
        if (this.f4255f) {
            e();
        }
        return this.f4256g[i8];
    }

    public void l(long j8, E e8) {
        int b8 = ContainerHelpers.b(this.f4256g, this.f4258i, j8);
        if (b8 >= 0) {
            this.f4257h[b8] = e8;
            return;
        }
        int i8 = ~b8;
        int i9 = this.f4258i;
        if (i8 < i9) {
            Object[] objArr = this.f4257h;
            if (objArr[i8] == f4254j) {
                this.f4256g[i8] = j8;
                objArr[i8] = e8;
                return;
            }
        }
        if (this.f4255f && i9 >= this.f4256g.length) {
            e();
            i8 = ~ContainerHelpers.b(this.f4256g, this.f4258i, j8);
        }
        int i10 = this.f4258i;
        if (i10 >= this.f4256g.length) {
            int f8 = ContainerHelpers.f(i10 + 1);
            long[] jArr = new long[f8];
            Object[] objArr2 = new Object[f8];
            long[] jArr2 = this.f4256g;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f4257h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f4256g = jArr;
            this.f4257h = objArr2;
        }
        int i11 = this.f4258i;
        if (i11 - i8 != 0) {
            long[] jArr3 = this.f4256g;
            int i12 = i8 + 1;
            System.arraycopy(jArr3, i8, jArr3, i12, i11 - i8);
            Object[] objArr4 = this.f4257h;
            System.arraycopy(objArr4, i8, objArr4, i12, this.f4258i - i8);
        }
        this.f4256g[i8] = j8;
        this.f4257h[i8] = e8;
        this.f4258i++;
    }

    public void m(long j8) {
        int b8 = ContainerHelpers.b(this.f4256g, this.f4258i, j8);
        if (b8 >= 0) {
            Object[] objArr = this.f4257h;
            Object obj = objArr[b8];
            Object obj2 = f4254j;
            if (obj != obj2) {
                objArr[b8] = obj2;
                this.f4255f = true;
            }
        }
    }

    public void n(int i8) {
        Object[] objArr = this.f4257h;
        Object obj = objArr[i8];
        Object obj2 = f4254j;
        if (obj != obj2) {
            objArr[i8] = obj2;
            this.f4255f = true;
        }
    }

    public int o() {
        if (this.f4255f) {
            e();
        }
        return this.f4258i;
    }

    public E p(int i8) {
        if (this.f4255f) {
            e();
        }
        return (E) this.f4257h[i8];
    }

    public String toString() {
        if (o() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4258i * 28);
        sb.append('{');
        for (int i8 = 0; i8 < this.f4258i; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(k(i8));
            sb.append('=');
            E p8 = p(i8);
            if (p8 != this) {
                sb.append(p8);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public LongSparseArray(int i8) {
        this.f4255f = false;
        if (i8 == 0) {
            this.f4256g = ContainerHelpers.f4252b;
            this.f4257h = ContainerHelpers.f4253c;
            return;
        }
        int f8 = ContainerHelpers.f(i8);
        this.f4256g = new long[f8];
        this.f4257h = new Object[f8];
    }
}
