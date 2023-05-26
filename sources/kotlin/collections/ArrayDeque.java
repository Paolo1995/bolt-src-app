package kotlin.collections;

import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: ArrayDeque.kt */
/* loaded from: classes5.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f50869i = new Companion(null);

    /* renamed from: j  reason: collision with root package name */
    private static final Object[] f50870j = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    private int f50871f;

    /* renamed from: g  reason: collision with root package name */
    private Object[] f50872g = f50870j;

    /* renamed from: h  reason: collision with root package name */
    private int f50873h;

    /* compiled from: ArrayDeque.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(int i8, int i9) {
            int i10 = i8 + (i8 >> 1);
            if (i10 - i9 < 0) {
                i10 = i9;
            }
            if (i10 - 2147483639 > 0) {
                if (i9 > 2147483639) {
                    return Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
                return 2147483639;
            }
            return i10;
        }
    }

    private final void g(int i8, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f50872g.length;
        while (i8 < length && it.hasNext()) {
            this.f50872g[i8] = it.next();
            i8++;
        }
        int i9 = this.f50871f;
        for (int i10 = 0; i10 < i9 && it.hasNext(); i10++) {
            this.f50872g[i10] = it.next();
        }
        this.f50873h = size() + collection.size();
    }

    private final void i(int i8) {
        Object[] objArr = new Object[i8];
        Object[] objArr2 = this.f50872g;
        ArraysKt___ArraysJvmKt.g(objArr2, objArr, 0, this.f50871f, objArr2.length);
        Object[] objArr3 = this.f50872g;
        int length = objArr3.length;
        int i9 = this.f50871f;
        ArraysKt___ArraysJvmKt.g(objArr3, objArr, length - i9, 0, i9);
        this.f50871f = 0;
        this.f50872g = objArr;
    }

    private final int k(int i8) {
        int J;
        if (i8 == 0) {
            J = ArraysKt___ArraysKt.J(this.f50872g);
            return J;
        }
        return i8 - 1;
    }

    private final void m(int i8) {
        int d8;
        if (i8 >= 0) {
            Object[] objArr = this.f50872g;
            if (i8 <= objArr.length) {
                return;
            }
            if (objArr == f50870j) {
                d8 = RangesKt___RangesKt.d(i8, 10);
                this.f50872g = new Object[d8];
                return;
            }
            i(f50869i.a(objArr.length, i8));
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    private final int o(int i8) {
        int J;
        J = ArraysKt___ArraysKt.J(this.f50872g);
        if (i8 == J) {
            return 0;
        }
        return i8 + 1;
    }

    private final int p(int i8) {
        if (i8 < 0) {
            return i8 + this.f50872g.length;
        }
        return i8;
    }

    private final int r(int i8) {
        Object[] objArr = this.f50872g;
        if (i8 >= objArr.length) {
            return i8 - objArr.length;
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e8) {
        addLast(e8);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        m(size() + elements.size());
        g(r(this.f50871f + size()), elements);
        return true;
    }

    public final void addFirst(E e8) {
        m(size() + 1);
        int k8 = k(this.f50871f);
        this.f50871f = k8;
        this.f50872g[k8] = e8;
        this.f50873h = size() + 1;
    }

    public final void addLast(E e8) {
        m(size() + 1);
        this.f50872g[r(this.f50871f + size())] = e8;
        this.f50873h = size() + 1;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int b() {
        return this.f50873h;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int r7 = r(this.f50871f + size());
        int i8 = this.f50871f;
        if (i8 < r7) {
            ArraysKt___ArraysJvmKt.m(this.f50872g, null, i8, r7);
        } else if (!isEmpty()) {
            Object[] objArr = this.f50872g;
            ArraysKt___ArraysJvmKt.m(objArr, null, this.f50871f, objArr.length);
            ArraysKt___ArraysJvmKt.m(this.f50872g, null, 0, r7);
        }
        this.f50871f = 0;
        this.f50873h = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E d(int i8) {
        int m8;
        int m9;
        AbstractList.f50860f.b(i8, size());
        m8 = CollectionsKt__CollectionsKt.m(this);
        if (i8 == m8) {
            return removeLast();
        }
        if (i8 == 0) {
            return removeFirst();
        }
        int r7 = r(this.f50871f + i8);
        E e8 = (E) this.f50872g[r7];
        if (i8 < (size() >> 1)) {
            int i9 = this.f50871f;
            if (r7 >= i9) {
                Object[] objArr = this.f50872g;
                ArraysKt___ArraysJvmKt.g(objArr, objArr, i9 + 1, i9, r7);
            } else {
                Object[] objArr2 = this.f50872g;
                ArraysKt___ArraysJvmKt.g(objArr2, objArr2, 1, 0, r7);
                Object[] objArr3 = this.f50872g;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i10 = this.f50871f;
                ArraysKt___ArraysJvmKt.g(objArr3, objArr3, i10 + 1, i10, objArr3.length - 1);
            }
            Object[] objArr4 = this.f50872g;
            int i11 = this.f50871f;
            objArr4[i11] = null;
            this.f50871f = o(i11);
        } else {
            int i12 = this.f50871f;
            m9 = CollectionsKt__CollectionsKt.m(this);
            int r8 = r(i12 + m9);
            if (r7 <= r8) {
                Object[] objArr5 = this.f50872g;
                ArraysKt___ArraysJvmKt.g(objArr5, objArr5, r7, r7 + 1, r8 + 1);
            } else {
                Object[] objArr6 = this.f50872g;
                ArraysKt___ArraysJvmKt.g(objArr6, objArr6, r7, r7 + 1, objArr6.length);
                Object[] objArr7 = this.f50872g;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt___ArraysJvmKt.g(objArr7, objArr7, 0, 1, r8 + 1);
            }
            this.f50872g[r8] = null;
        }
        this.f50873h = size() - 1;
        return e8;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i8) {
        AbstractList.f50860f.b(i8, size());
        return (E) this.f50872g[r(this.f50871f + i8)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i8;
        int r7 = r(this.f50871f + size());
        int i9 = this.f50871f;
        if (i9 < r7) {
            while (i9 < r7) {
                if (Intrinsics.a(obj, this.f50872g[i9])) {
                    i8 = this.f50871f;
                } else {
                    i9++;
                }
            }
            return -1;
        } else if (i9 >= r7) {
            int length = this.f50872g.length;
            while (true) {
                if (i9 < length) {
                    if (Intrinsics.a(obj, this.f50872g[i9])) {
                        i8 = this.f50871f;
                        break;
                    }
                    i9++;
                } else {
                    for (int i10 = 0; i10 < r7; i10++) {
                        if (Intrinsics.a(obj, this.f50872g[i10])) {
                            i9 = i10 + this.f50872g.length;
                            i8 = this.f50871f;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i9 - i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int J;
        int i8;
        int r7 = r(this.f50871f + size());
        int i9 = this.f50871f;
        if (i9 < r7) {
            J = r7 - 1;
            if (i9 <= J) {
                while (!Intrinsics.a(obj, this.f50872g[J])) {
                    if (J != i9) {
                        J--;
                    }
                }
                i8 = this.f50871f;
                return J - i8;
            }
            return -1;
        }
        if (i9 > r7) {
            int i10 = r7 - 1;
            while (true) {
                if (-1 < i10) {
                    if (Intrinsics.a(obj, this.f50872g[i10])) {
                        J = i10 + this.f50872g.length;
                        i8 = this.f50871f;
                        break;
                    }
                    i10--;
                } else {
                    J = ArraysKt___ArraysKt.J(this.f50872g);
                    int i11 = this.f50871f;
                    if (i11 <= J) {
                        while (!Intrinsics.a(obj, this.f50872g[J])) {
                            if (J != i11) {
                                J--;
                            }
                        }
                        i8 = this.f50871f;
                    }
                }
            }
        }
        return -1;
    }

    public final E n() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f50872g[this.f50871f];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        boolean z7;
        int r7;
        Intrinsics.f(elements, "elements");
        boolean z8 = false;
        z8 = false;
        z8 = false;
        if (!isEmpty()) {
            if (this.f50872g.length == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                int r8 = r(this.f50871f + size());
                int i8 = this.f50871f;
                if (i8 < r8) {
                    r7 = i8;
                    while (i8 < r8) {
                        Object obj = this.f50872g[i8];
                        if (!elements.contains(obj)) {
                            this.f50872g[r7] = obj;
                            r7++;
                        } else {
                            z8 = true;
                        }
                        i8++;
                    }
                    ArraysKt___ArraysJvmKt.m(this.f50872g, null, r7, r8);
                } else {
                    int length = this.f50872g.length;
                    int i9 = i8;
                    boolean z9 = false;
                    while (i8 < length) {
                        Object[] objArr = this.f50872g;
                        Object obj2 = objArr[i8];
                        objArr[i8] = null;
                        if (!elements.contains(obj2)) {
                            this.f50872g[i9] = obj2;
                            i9++;
                        } else {
                            z9 = true;
                        }
                        i8++;
                    }
                    r7 = r(i9);
                    for (int i10 = 0; i10 < r8; i10++) {
                        Object[] objArr2 = this.f50872g;
                        Object obj3 = objArr2[i10];
                        objArr2[i10] = null;
                        if (!elements.contains(obj3)) {
                            this.f50872g[r7] = obj3;
                            r7 = o(r7);
                        } else {
                            z9 = true;
                        }
                    }
                    z8 = z9;
                }
                if (z8) {
                    this.f50873h = p(r7 - this.f50871f);
                }
            }
        }
        return z8;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.f50872g;
            int i8 = this.f50871f;
            E e8 = (E) objArr[i8];
            objArr[i8] = null;
            this.f50871f = o(i8);
            this.f50873h = size() - 1;
            return e8;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        int m8;
        if (!isEmpty()) {
            int i8 = this.f50871f;
            m8 = CollectionsKt__CollectionsKt.m(this);
            int r7 = r(i8 + m8);
            Object[] objArr = this.f50872g;
            E e8 = (E) objArr[r7];
            objArr[r7] = null;
            this.f50873h = size() - 1;
            return e8;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        boolean z7;
        int r7;
        Intrinsics.f(elements, "elements");
        boolean z8 = false;
        z8 = false;
        z8 = false;
        if (!isEmpty()) {
            if (this.f50872g.length == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                int r8 = r(this.f50871f + size());
                int i8 = this.f50871f;
                if (i8 < r8) {
                    r7 = i8;
                    while (i8 < r8) {
                        Object obj = this.f50872g[i8];
                        if (elements.contains(obj)) {
                            this.f50872g[r7] = obj;
                            r7++;
                        } else {
                            z8 = true;
                        }
                        i8++;
                    }
                    ArraysKt___ArraysJvmKt.m(this.f50872g, null, r7, r8);
                } else {
                    int length = this.f50872g.length;
                    int i9 = i8;
                    boolean z9 = false;
                    while (i8 < length) {
                        Object[] objArr = this.f50872g;
                        Object obj2 = objArr[i8];
                        objArr[i8] = null;
                        if (elements.contains(obj2)) {
                            this.f50872g[i9] = obj2;
                            i9++;
                        } else {
                            z9 = true;
                        }
                        i8++;
                    }
                    r7 = r(i9);
                    for (int i10 = 0; i10 < r8; i10++) {
                        Object[] objArr2 = this.f50872g;
                        Object obj3 = objArr2[i10];
                        objArr2[i10] = null;
                        if (elements.contains(obj3)) {
                            this.f50872g[r7] = obj3;
                            r7 = o(r7);
                        } else {
                            z9 = true;
                        }
                    }
                    z8 = z9;
                }
                if (z8) {
                    this.f50873h = p(r7 - this.f50871f);
                }
            }
        }
        return z8;
    }

    public final E s() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i8, E e8) {
        AbstractList.f50860f.b(i8, size());
        int r7 = r(this.f50871f + i8);
        Object[] objArr = this.f50872g;
        E e9 = (E) objArr[r7];
        objArr[r7] = e8;
        return e9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.f(array, "array");
        if (array.length < size()) {
            array = (T[]) ArraysKt__ArraysJVMKt.a(array, size());
        }
        int r7 = r(this.f50871f + size());
        int i8 = this.f50871f;
        if (i8 < r7) {
            ArraysKt___ArraysJvmKt.i(this.f50872g, array, 0, i8, r7, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f50872g;
            ArraysKt___ArraysJvmKt.g(objArr, array, 0, this.f50871f, objArr.length);
            Object[] objArr2 = this.f50872g;
            ArraysKt___ArraysJvmKt.g(objArr2, array, objArr2.length - this.f50871f, 0, r7);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public final E u() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, E e8) {
        AbstractList.f50860f.c(i8, size());
        if (i8 == size()) {
            addLast(e8);
        } else if (i8 == 0) {
            addFirst(e8);
        } else {
            m(size() + 1);
            int r7 = r(this.f50871f + i8);
            if (i8 < ((size() + 1) >> 1)) {
                int k8 = k(r7);
                int k9 = k(this.f50871f);
                int i9 = this.f50871f;
                if (k8 >= i9) {
                    Object[] objArr = this.f50872g;
                    objArr[k9] = objArr[i9];
                    ArraysKt___ArraysJvmKt.g(objArr, objArr, i9, i9 + 1, k8 + 1);
                } else {
                    Object[] objArr2 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr2, objArr2, i9 - 1, i9, objArr2.length);
                    Object[] objArr3 = this.f50872g;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt___ArraysJvmKt.g(objArr3, objArr3, 0, 1, k8 + 1);
                }
                this.f50872g[k8] = e8;
                this.f50871f = k9;
            } else {
                int r8 = r(this.f50871f + size());
                if (r7 < r8) {
                    Object[] objArr4 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr4, objArr4, r7 + 1, r7, r8);
                } else {
                    Object[] objArr5 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr5, objArr5, 1, 0, r8);
                    Object[] objArr6 = this.f50872g;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt___ArraysJvmKt.g(objArr6, objArr6, r7 + 1, r7, objArr6.length - 1);
                }
                this.f50872g[r7] = e8;
            }
            this.f50873h = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i8, Collection<? extends E> elements) {
        Intrinsics.f(elements, "elements");
        AbstractList.f50860f.c(i8, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i8 == size()) {
            return addAll(elements);
        }
        m(size() + elements.size());
        int r7 = r(this.f50871f + size());
        int r8 = r(this.f50871f + i8);
        int size = elements.size();
        if (i8 < ((size() + 1) >> 1)) {
            int i9 = this.f50871f;
            int i10 = i9 - size;
            if (r8 < i9) {
                Object[] objArr = this.f50872g;
                ArraysKt___ArraysJvmKt.g(objArr, objArr, i10, i9, objArr.length);
                if (size >= r8) {
                    Object[] objArr2 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr2, objArr2, objArr2.length - size, 0, r8);
                } else {
                    Object[] objArr3 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr4, objArr4, 0, size, r8);
                }
            } else if (i10 >= 0) {
                Object[] objArr5 = this.f50872g;
                ArraysKt___ArraysJvmKt.g(objArr5, objArr5, i10, i9, r8);
            } else {
                Object[] objArr6 = this.f50872g;
                i10 += objArr6.length;
                int i11 = r8 - i9;
                int length = objArr6.length - i10;
                if (length >= i11) {
                    ArraysKt___ArraysJvmKt.g(objArr6, objArr6, i10, i9, r8);
                } else {
                    ArraysKt___ArraysJvmKt.g(objArr6, objArr6, i10, i9, i9 + length);
                    Object[] objArr7 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr7, objArr7, 0, this.f50871f + length, r8);
                }
            }
            this.f50871f = i10;
            g(p(r8 - size), elements);
        } else {
            int i12 = r8 + size;
            if (r8 < r7) {
                int i13 = size + r7;
                Object[] objArr8 = this.f50872g;
                if (i13 <= objArr8.length) {
                    ArraysKt___ArraysJvmKt.g(objArr8, objArr8, i12, r8, r7);
                } else if (i12 >= objArr8.length) {
                    ArraysKt___ArraysJvmKt.g(objArr8, objArr8, i12 - objArr8.length, r8, r7);
                } else {
                    int length2 = r7 - (i13 - objArr8.length);
                    ArraysKt___ArraysJvmKt.g(objArr8, objArr8, 0, length2, r7);
                    Object[] objArr9 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr9, objArr9, i12, r8, length2);
                }
            } else {
                Object[] objArr10 = this.f50872g;
                ArraysKt___ArraysJvmKt.g(objArr10, objArr10, size, 0, r7);
                Object[] objArr11 = this.f50872g;
                if (i12 >= objArr11.length) {
                    ArraysKt___ArraysJvmKt.g(objArr11, objArr11, i12 - objArr11.length, r8, objArr11.length);
                } else {
                    ArraysKt___ArraysJvmKt.g(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f50872g;
                    ArraysKt___ArraysJvmKt.g(objArr12, objArr12, i12, r8, objArr12.length - size);
                }
            }
            g(r8, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
