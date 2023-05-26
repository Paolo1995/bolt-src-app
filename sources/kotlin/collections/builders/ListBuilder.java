package kotlin.collections.builders;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ListBuilder.kt */
/* loaded from: classes5.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {

    /* renamed from: f  reason: collision with root package name */
    private E[] f50892f;

    /* renamed from: g  reason: collision with root package name */
    private int f50893g;

    /* renamed from: h  reason: collision with root package name */
    private int f50894h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f50895i;

    /* renamed from: j  reason: collision with root package name */
    private final ListBuilder<E> f50896j;

    /* renamed from: k  reason: collision with root package name */
    private final ListBuilder<E> f50897k;

    /* compiled from: ListBuilder.kt */
    /* loaded from: classes5.dex */
    private static final class Itr<E> implements ListIterator<E>, KMappedMarker, Iterator {

        /* renamed from: f  reason: collision with root package name */
        private final ListBuilder<E> f50898f;

        /* renamed from: g  reason: collision with root package name */
        private int f50899g;

        /* renamed from: h  reason: collision with root package name */
        private int f50900h;

        public Itr(ListBuilder<E> list, int i8) {
            Intrinsics.f(list, "list");
            this.f50898f = list;
            this.f50899g = i8;
            this.f50900h = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e8) {
            ListBuilder<E> listBuilder = this.f50898f;
            int i8 = this.f50899g;
            this.f50899g = i8 + 1;
            listBuilder.add(i8, e8);
            this.f50900h = -1;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f50899g < ((ListBuilder) this.f50898f).f50894h) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.f50899g > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public E next() {
            if (this.f50899g < ((ListBuilder) this.f50898f).f50894h) {
                int i8 = this.f50899g;
                this.f50899g = i8 + 1;
                this.f50900h = i8;
                return (E) ((ListBuilder) this.f50898f).f50892f[((ListBuilder) this.f50898f).f50893g + this.f50900h];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f50899g;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i8 = this.f50899g;
            if (i8 > 0) {
                int i9 = i8 - 1;
                this.f50899g = i9;
                this.f50900h = i9;
                return (E) ((ListBuilder) this.f50898f).f50892f[((ListBuilder) this.f50898f).f50893g + this.f50900h];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f50899g - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public void remove() {
            boolean z7;
            int i8 = this.f50900h;
            if (i8 != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.f50898f.remove(i8);
                this.f50899g = this.f50900h;
                this.f50900h = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e8) {
            boolean z7;
            int i8 = this.f50900h;
            if (i8 != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.f50898f.set(i8, e8);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i8, int i9, boolean z7, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.f50892f = eArr;
        this.f50893g = i8;
        this.f50894h = i9;
        this.f50895i = z7;
        this.f50896j = listBuilder;
        this.f50897k = listBuilder2;
    }

    private final void m(int i8, Collection<? extends E> collection, int i9) {
        ListBuilder<E> listBuilder = this.f50896j;
        if (listBuilder != null) {
            listBuilder.m(i8, collection, i9);
            this.f50892f = this.f50896j.f50892f;
            this.f50894h += i9;
            return;
        }
        v(i8, i9);
        java.util.Iterator<? extends E> it = collection.iterator();
        for (int i10 = 0; i10 < i9; i10++) {
            this.f50892f[i8 + i10] = it.next();
        }
    }

    private final void n(int i8, E e8) {
        ListBuilder<E> listBuilder = this.f50896j;
        if (listBuilder != null) {
            listBuilder.n(i8, e8);
            this.f50892f = this.f50896j.f50892f;
            this.f50894h++;
            return;
        }
        v(i8, 1);
        this.f50892f[i8] = e8;
    }

    private final void p() {
        if (!w()) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    private final boolean r(List<?> list) {
        boolean h8;
        h8 = ListBuilderKt.h(this.f50892f, this.f50893g, this.f50894h, list);
        return h8;
    }

    private final void s(int i8) {
        if (this.f50896j == null) {
            if (i8 >= 0) {
                E[] eArr = this.f50892f;
                if (i8 > eArr.length) {
                    this.f50892f = (E[]) ListBuilderKt.e(this.f50892f, ArrayDeque.f50869i.a(eArr.length, i8));
                    return;
                }
                return;
            }
            throw new OutOfMemoryError();
        }
        throw new IllegalStateException();
    }

    private final void u(int i8) {
        s(this.f50894h + i8);
    }

    private final void v(int i8, int i9) {
        u(i9);
        E[] eArr = this.f50892f;
        ArraysKt___ArraysJvmKt.g(eArr, eArr, i8 + i9, i8, this.f50893g + this.f50894h);
        this.f50894h += i9;
    }

    private final boolean w() {
        ListBuilder<E> listBuilder;
        if (!this.f50895i && ((listBuilder = this.f50897k) == null || !listBuilder.f50895i)) {
            return false;
        }
        return true;
    }

    private final E x(int i8) {
        ListBuilder<E> listBuilder = this.f50896j;
        if (listBuilder != null) {
            this.f50894h--;
            return listBuilder.x(i8);
        }
        E[] eArr = this.f50892f;
        E e8 = eArr[i8];
        ArraysKt___ArraysJvmKt.g(eArr, eArr, i8, i8 + 1, this.f50893g + this.f50894h);
        ListBuilderKt.f(this.f50892f, (this.f50893g + this.f50894h) - 1);
        this.f50894h--;
        return e8;
    }

    private final void y(int i8, int i9) {
        ListBuilder<E> listBuilder = this.f50896j;
        if (listBuilder != null) {
            listBuilder.y(i8, i9);
        } else {
            E[] eArr = this.f50892f;
            ArraysKt___ArraysJvmKt.g(eArr, eArr, i8, i8 + i9, this.f50894h);
            E[] eArr2 = this.f50892f;
            int i10 = this.f50894h;
            ListBuilderKt.g(eArr2, i10 - i9, i10);
        }
        this.f50894h -= i9;
    }

    private final int z(int i8, int i9, Collection<? extends E> collection, boolean z7) {
        ListBuilder<E> listBuilder = this.f50896j;
        if (listBuilder != null) {
            int z8 = listBuilder.z(i8, i9, collection, z7);
            this.f50894h -= z8;
            return z8;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i8 + i10;
            if (collection.contains(this.f50892f[i12]) == z7) {
                E[] eArr = this.f50892f;
                i10++;
                eArr[i11 + i8] = eArr[i12];
                i11++;
            } else {
                i10++;
            }
        }
        int i13 = i9 - i11;
        E[] eArr2 = this.f50892f;
        ArraysKt___ArraysJvmKt.g(eArr2, eArr2, i8 + i11, i9 + i8, this.f50894h);
        E[] eArr3 = this.f50892f;
        int i14 = this.f50894h;
        ListBuilderKt.g(eArr3, i14 - i13, i14);
        this.f50894h -= i13;
        return i13;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e8) {
        p();
        n(this.f50893g + this.f50894h, e8);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.f(elements, "elements");
        p();
        int size = elements.size();
        m(this.f50893g + this.f50894h, elements, size);
        return size > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int b() {
        return this.f50894h;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        p();
        y(this.f50893g, this.f50894h);
    }

    @Override // kotlin.collections.AbstractMutableList
    public E d(int i8) {
        p();
        AbstractList.f50860f.b(i8, this.f50894h);
        return x(this.f50893g + i8);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof List) || !r((List) obj))) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i8) {
        AbstractList.f50860f.b(i8, this.f50894h);
        return this.f50892f[this.f50893g + i8];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i8;
        i8 = ListBuilderKt.i(this.f50892f, this.f50893g, this.f50894h);
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i8 = 0; i8 < this.f50894h; i8++) {
            if (Intrinsics.a(this.f50892f[this.f50893g + i8], obj)) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.f50894h == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public java.util.Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i8 = this.f50894h - 1; i8 >= 0; i8--) {
            if (Intrinsics.a(this.f50892f[this.f50893g + i8], obj)) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    public final List<E> o() {
        if (this.f50896j == null) {
            p();
            this.f50895i = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        p();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        p();
        if (z(this.f50893g, this.f50894h, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.f(elements, "elements");
        p();
        if (z(this.f50893g, this.f50894h, elements, true) > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i8, E e8) {
        p();
        AbstractList.f50860f.b(i8, this.f50894h);
        E[] eArr = this.f50892f;
        int i9 = this.f50893g;
        E e9 = eArr[i9 + i8];
        eArr[i9 + i8] = e8;
        return e9;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i8, int i9) {
        ListBuilder<E> listBuilder;
        AbstractList.f50860f.d(i8, i9, this.f50894h);
        E[] eArr = this.f50892f;
        int i10 = this.f50893g + i8;
        int i11 = i9 - i8;
        boolean z7 = this.f50895i;
        ListBuilder<E> listBuilder2 = this.f50897k;
        if (listBuilder2 == null) {
            listBuilder = this;
        } else {
            listBuilder = listBuilder2;
        }
        return new ListBuilder(eArr, i10, i11, z7, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] destination) {
        Intrinsics.f(destination, "destination");
        int length = destination.length;
        int i8 = this.f50894h;
        if (length < i8) {
            E[] eArr = this.f50892f;
            int i9 = this.f50893g;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i9, i8 + i9, destination.getClass());
            Intrinsics.e(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.f50892f;
        int i10 = this.f50893g;
        ArraysKt___ArraysJvmKt.g(eArr2, destination, 0, i10, i8 + i10);
        int length2 = destination.length;
        int i11 = this.f50894h;
        if (length2 > i11) {
            destination[i11] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String j8;
        j8 = ListBuilderKt.j(this.f50892f, this.f50893g, this.f50894h);
        return j8;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i8) {
        AbstractList.f50860f.c(i8, this.f50894h);
        return new Itr(this, i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, E e8) {
        p();
        AbstractList.f50860f.c(i8, this.f50894h);
        n(this.f50893g + i8, e8);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i8, Collection<? extends E> elements) {
        Intrinsics.f(elements, "elements");
        p();
        AbstractList.f50860f.c(i8, this.f50894h);
        int size = elements.size();
        m(this.f50893g + i8, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] k8;
        E[] eArr = this.f50892f;
        int i8 = this.f50893g;
        k8 = ArraysKt___ArraysJvmKt.k(eArr, i8, this.f50894h + i8);
        return k8;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i8) {
        this(ListBuilderKt.d(i8), 0, 0, false, null, null);
    }
}
