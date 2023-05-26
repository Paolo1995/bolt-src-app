package androidx.collection;

import androidx.annotation.NonNull;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f4240j = new int[0];

    /* renamed from: k  reason: collision with root package name */
    private static final Object[] f4241k = new Object[0];

    /* renamed from: l  reason: collision with root package name */
    private static Object[] f4242l;

    /* renamed from: m  reason: collision with root package name */
    private static int f4243m;

    /* renamed from: n  reason: collision with root package name */
    private static Object[] f4244n;

    /* renamed from: o  reason: collision with root package name */
    private static int f4245o;

    /* renamed from: f  reason: collision with root package name */
    private int[] f4246f;

    /* renamed from: g  reason: collision with root package name */
    Object[] f4247g;

    /* renamed from: h  reason: collision with root package name */
    int f4248h;

    /* renamed from: i  reason: collision with root package name */
    private MapCollections<E, E> f4249i;

    public ArraySet() {
        this(0);
    }

    private void b(int i8) {
        if (i8 == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = f4244n;
                if (objArr != null) {
                    this.f4247g = objArr;
                    f4244n = (Object[]) objArr[0];
                    this.f4246f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4245o--;
                    return;
                }
            }
        } else if (i8 == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = f4242l;
                if (objArr2 != null) {
                    this.f4247g = objArr2;
                    f4242l = (Object[]) objArr2[0];
                    this.f4246f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4243m--;
                    return;
                }
            }
        }
        this.f4246f = new int[i8];
        this.f4247g = new Object[i8];
    }

    private static void f(int[] iArr, Object[] objArr, int i8) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f4245o < 10) {
                    objArr[0] = f4244n;
                    objArr[1] = iArr;
                    for (int i9 = i8 - 1; i9 >= 2; i9--) {
                        objArr[i9] = null;
                    }
                    f4244n = objArr;
                    f4245o++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f4243m < 10) {
                    objArr[0] = f4242l;
                    objArr[1] = iArr;
                    for (int i10 = i8 - 1; i10 >= 2; i10--) {
                        objArr[i10] = null;
                    }
                    f4242l = objArr;
                    f4243m++;
                }
            }
        }
    }

    private MapCollections<E, E> g() {
        if (this.f4249i == null) {
            this.f4249i = new MapCollections<E, E>() { // from class: androidx.collection.ArraySet.1
                @Override // androidx.collection.MapCollections
                protected void a() {
                    ArraySet.this.clear();
                }

                @Override // androidx.collection.MapCollections
                protected Object b(int i8, int i9) {
                    return ArraySet.this.f4247g[i8];
                }

                @Override // androidx.collection.MapCollections
                protected Map<E, E> c() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                protected int d() {
                    return ArraySet.this.f4248h;
                }

                @Override // androidx.collection.MapCollections
                protected int e(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int f(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected void g(E e8, E e9) {
                    ArraySet.this.add(e8);
                }

                @Override // androidx.collection.MapCollections
                protected void h(int i8) {
                    ArraySet.this.m(i8);
                }

                @Override // androidx.collection.MapCollections
                protected E i(int i8, E e8) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.f4249i;
    }

    private int i(Object obj, int i8) {
        int i9 = this.f4248h;
        if (i9 == 0) {
            return -1;
        }
        int a8 = ContainerHelpers.a(this.f4246f, i9, i8);
        if (a8 < 0) {
            return a8;
        }
        if (obj.equals(this.f4247g[a8])) {
            return a8;
        }
        int i10 = a8 + 1;
        while (i10 < i9 && this.f4246f[i10] == i8) {
            if (obj.equals(this.f4247g[i10])) {
                return i10;
            }
            i10++;
        }
        for (int i11 = a8 - 1; i11 >= 0 && this.f4246f[i11] == i8; i11--) {
            if (obj.equals(this.f4247g[i11])) {
                return i11;
            }
        }
        return ~i10;
    }

    private int k() {
        int i8 = this.f4248h;
        if (i8 == 0) {
            return -1;
        }
        int a8 = ContainerHelpers.a(this.f4246f, i8, 0);
        if (a8 < 0) {
            return a8;
        }
        if (this.f4247g[a8] == null) {
            return a8;
        }
        int i9 = a8 + 1;
        while (i9 < i8 && this.f4246f[i9] == 0) {
            if (this.f4247g[i9] == null) {
                return i9;
            }
            i9++;
        }
        for (int i10 = a8 - 1; i10 >= 0 && this.f4246f[i10] == 0; i10--) {
            if (this.f4247g[i10] == null) {
                return i10;
            }
        }
        return ~i9;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e8) {
        int i8;
        int i9;
        if (e8 == null) {
            i9 = k();
            i8 = 0;
        } else {
            int hashCode = e8.hashCode();
            i8 = hashCode;
            i9 = i(e8, hashCode);
        }
        if (i9 >= 0) {
            return false;
        }
        int i10 = ~i9;
        int i11 = this.f4248h;
        int[] iArr = this.f4246f;
        if (i11 >= iArr.length) {
            int i12 = 4;
            if (i11 >= 8) {
                i12 = (i11 >> 1) + i11;
            } else if (i11 >= 4) {
                i12 = 8;
            }
            Object[] objArr = this.f4247g;
            b(i12);
            int[] iArr2 = this.f4246f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f4247g, 0, objArr.length);
            }
            f(iArr, objArr, this.f4248h);
        }
        int i13 = this.f4248h;
        if (i10 < i13) {
            int[] iArr3 = this.f4246f;
            int i14 = i10 + 1;
            System.arraycopy(iArr3, i10, iArr3, i14, i13 - i10);
            Object[] objArr2 = this.f4247g;
            System.arraycopy(objArr2, i10, objArr2, i14, this.f4248h - i10);
        }
        this.f4246f[i10] = i8;
        this.f4247g[i10] = e8;
        this.f4248h++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        d(this.f4248h + collection.size());
        boolean z7 = false;
        for (E e8 : collection) {
            z7 |= add(e8);
        }
        return z7;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i8 = this.f4248h;
        if (i8 != 0) {
            f(this.f4246f, this.f4247g, i8);
            this.f4246f = f4240j;
            this.f4247g = f4241k;
            this.f4248h = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void d(int i8) {
        int[] iArr = this.f4246f;
        if (iArr.length < i8) {
            Object[] objArr = this.f4247g;
            b(i8);
            int i9 = this.f4248h;
            if (i9 > 0) {
                System.arraycopy(iArr, 0, this.f4246f, 0, i9);
                System.arraycopy(objArr, 0, this.f4247g, 0, this.f4248h);
            }
            f(iArr, objArr, this.f4248h);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i8 = 0; i8 < this.f4248h; i8++) {
                try {
                    if (!set.contains(n(i8))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f4246f;
        int i8 = this.f4248h;
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            i9 += iArr[i10];
        }
        return i9;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return k();
        }
        return i(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.f4248h <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return g().m().iterator();
    }

    public E m(int i8) {
        Object[] objArr = this.f4247g;
        E e8 = (E) objArr[i8];
        int i9 = this.f4248h;
        if (i9 <= 1) {
            f(this.f4246f, objArr, i9);
            this.f4246f = f4240j;
            this.f4247g = f4241k;
            this.f4248h = 0;
        } else {
            int[] iArr = this.f4246f;
            int i10 = 8;
            if (iArr.length > 8 && i9 < iArr.length / 3) {
                if (i9 > 8) {
                    i10 = i9 + (i9 >> 1);
                }
                b(i10);
                this.f4248h--;
                if (i8 > 0) {
                    System.arraycopy(iArr, 0, this.f4246f, 0, i8);
                    System.arraycopy(objArr, 0, this.f4247g, 0, i8);
                }
                int i11 = this.f4248h;
                if (i8 < i11) {
                    int i12 = i8 + 1;
                    System.arraycopy(iArr, i12, this.f4246f, i8, i11 - i8);
                    System.arraycopy(objArr, i12, this.f4247g, i8, this.f4248h - i8);
                }
            } else {
                int i13 = i9 - 1;
                this.f4248h = i13;
                if (i8 < i13) {
                    int i14 = i8 + 1;
                    System.arraycopy(iArr, i14, iArr, i8, i13 - i8);
                    Object[] objArr2 = this.f4247g;
                    System.arraycopy(objArr2, i14, objArr2, i8, this.f4248h - i8);
                }
                this.f4247g[this.f4248h] = null;
            }
        }
        return e8;
    }

    public E n(int i8) {
        return (E) this.f4247g[i8];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            m(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            z7 |= remove(it.next());
        }
        return z7;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z7 = false;
        for (int i8 = this.f4248h - 1; i8 >= 0; i8--) {
            if (!collection.contains(this.f4247g[i8])) {
                m(i8);
                z7 = true;
            }
        }
        return z7;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f4248h;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int i8 = this.f4248h;
        Object[] objArr = new Object[i8];
        System.arraycopy(this.f4247g, 0, objArr, 0, i8);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4248h * 14);
        sb.append('{');
        for (int i8 = 0; i8 < this.f4248h; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            E n8 = n(i8);
            if (n8 != this) {
                sb.append(n8);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public ArraySet(int i8) {
        if (i8 == 0) {
            this.f4246f = f4240j;
            this.f4247g = f4241k;
        } else {
            b(i8);
        }
        this.f4248h = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.f4248h) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f4248h));
        }
        System.arraycopy(this.f4247g, 0, tArr, 0, this.f4248h);
        int length = tArr.length;
        int i8 = this.f4248h;
        if (length > i8) {
            tArr[i8] = null;
        }
        return tArr;
    }
}
