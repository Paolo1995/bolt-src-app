package androidx.collection;

/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: j  reason: collision with root package name */
    private static final Object f4281j = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f4282f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f4283g;

    /* renamed from: h  reason: collision with root package name */
    private Object[] f4284h;

    /* renamed from: i  reason: collision with root package name */
    private int f4285i;

    public SparseArrayCompat() {
        this(10);
    }

    private void d() {
        int i8 = this.f4285i;
        int[] iArr = this.f4283g;
        Object[] objArr = this.f4284h;
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            Object obj = objArr[i10];
            if (obj != f4281j) {
                if (i10 != i9) {
                    iArr[i9] = iArr[i10];
                    objArr[i9] = obj;
                    objArr[i10] = null;
                }
                i9++;
            }
        }
        this.f4282f = false;
        this.f4285i = i9;
    }

    public void a(int i8, E e8) {
        int i9 = this.f4285i;
        if (i9 != 0 && i8 <= this.f4283g[i9 - 1]) {
            j(i8, e8);
            return;
        }
        if (this.f4282f && i9 >= this.f4283g.length) {
            d();
        }
        int i10 = this.f4285i;
        if (i10 >= this.f4283g.length) {
            int e9 = ContainerHelpers.e(i10 + 1);
            int[] iArr = new int[e9];
            Object[] objArr = new Object[e9];
            int[] iArr2 = this.f4283g;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f4284h;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f4283g = iArr;
            this.f4284h = objArr;
        }
        this.f4283g[i10] = i8;
        this.f4284h[i10] = e8;
        this.f4285i = i10 + 1;
    }

    public void b() {
        int i8 = this.f4285i;
        Object[] objArr = this.f4284h;
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[i9] = null;
        }
        this.f4285i = 0;
        this.f4282f = false;
    }

    /* renamed from: c */
    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.f4283g = (int[]) this.f4283g.clone();
            sparseArrayCompat.f4284h = (Object[]) this.f4284h.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e8) {
            throw new AssertionError(e8);
        }
    }

    public E e(int i8) {
        return f(i8, null);
    }

    public E f(int i8, E e8) {
        E e9;
        int a8 = ContainerHelpers.a(this.f4283g, this.f4285i, i8);
        if (a8 >= 0 && (e9 = (E) this.f4284h[a8]) != f4281j) {
            return e9;
        }
        return e8;
    }

    public int h(E e8) {
        if (this.f4282f) {
            d();
        }
        for (int i8 = 0; i8 < this.f4285i; i8++) {
            if (this.f4284h[i8] == e8) {
                return i8;
            }
        }
        return -1;
    }

    public int i(int i8) {
        if (this.f4282f) {
            d();
        }
        return this.f4283g[i8];
    }

    public void j(int i8, E e8) {
        int a8 = ContainerHelpers.a(this.f4283g, this.f4285i, i8);
        if (a8 >= 0) {
            this.f4284h[a8] = e8;
            return;
        }
        int i9 = ~a8;
        int i10 = this.f4285i;
        if (i9 < i10) {
            Object[] objArr = this.f4284h;
            if (objArr[i9] == f4281j) {
                this.f4283g[i9] = i8;
                objArr[i9] = e8;
                return;
            }
        }
        if (this.f4282f && i10 >= this.f4283g.length) {
            d();
            i9 = ~ContainerHelpers.a(this.f4283g, this.f4285i, i8);
        }
        int i11 = this.f4285i;
        if (i11 >= this.f4283g.length) {
            int e9 = ContainerHelpers.e(i11 + 1);
            int[] iArr = new int[e9];
            Object[] objArr2 = new Object[e9];
            int[] iArr2 = this.f4283g;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f4284h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f4283g = iArr;
            this.f4284h = objArr2;
        }
        int i12 = this.f4285i;
        if (i12 - i9 != 0) {
            int[] iArr3 = this.f4283g;
            int i13 = i9 + 1;
            System.arraycopy(iArr3, i9, iArr3, i13, i12 - i9);
            Object[] objArr4 = this.f4284h;
            System.arraycopy(objArr4, i9, objArr4, i13, this.f4285i - i9);
        }
        this.f4283g[i9] = i8;
        this.f4284h[i9] = e8;
        this.f4285i++;
    }

    public int k() {
        if (this.f4282f) {
            d();
        }
        return this.f4285i;
    }

    public E l(int i8) {
        if (this.f4282f) {
            d();
        }
        return (E) this.f4284h[i8];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4285i * 28);
        sb.append('{');
        for (int i8 = 0; i8 < this.f4285i; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(i(i8));
            sb.append('=');
            E l8 = l(i8);
            if (l8 != this) {
                sb.append(l8);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public SparseArrayCompat(int i8) {
        this.f4282f = false;
        if (i8 == 0) {
            this.f4283g = ContainerHelpers.f4251a;
            this.f4284h = ContainerHelpers.f4253c;
            return;
        }
        int e8 = ContainerHelpers.e(i8);
        this.f4283g = new int[e8];
        this.f4284h = new Object[e8];
    }
}
