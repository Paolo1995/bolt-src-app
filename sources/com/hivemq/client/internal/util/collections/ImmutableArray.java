package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.internal.util.collections.ImmutableList;
import j$.util.Collection$CC;
import j$.util.Iterator;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ImmutableArray<E> implements ImmutableList<E>, List {

    /* renamed from: f  reason: collision with root package name */
    private final Object[] f18685f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class ArrayIterator implements ImmutableList.ImmutableListIterator<E>, Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f18686f;

        ArrayIterator(int i8) {
            this.f18686f = i8;
        }

        @Override // java.util.ListIterator
        public /* synthetic */ void add(Object obj) {
            o0.a.a(this, obj);
        }

        @Override // j$.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Checks.j(consumer, "Consumer");
            while (hasNext()) {
                consumer.accept((Object) next());
            }
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f18686f < ImmutableArray.this.f()) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.f18686f > ImmutableArray.this.d()) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public E next() {
            if (hasNext()) {
                Object[] objArr = ImmutableArray.this.f18685f;
                int i8 = this.f18686f;
                this.f18686f = i8 + 1;
                return (E) objArr[i8];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f18686f - ImmutableArray.this.d();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                Object[] objArr = ImmutableArray.this.f18685f;
                int i8 = this.f18686f - 1;
                this.f18686f = i8;
                return (E) objArr[i8];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.f18686f - 1) - ImmutableArray.this.d();
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            o0.a.b(this);
        }

        @Override // java.util.ListIterator
        public /* synthetic */ void set(Object obj) {
            o0.a.c(this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class SubArray<E> extends ImmutableArray<E> {

        /* renamed from: g  reason: collision with root package name */
        private final int f18688g;

        /* renamed from: h  reason: collision with root package name */
        private final int f18689h;

        SubArray(Object[] objArr, int i8, int i9) {
            super(objArr);
            this.f18688g = i8;
            this.f18689h = i9;
        }

        @Override // com.hivemq.client.internal.util.collections.ImmutableArray, com.hivemq.client.internal.util.collections.ImmutableList
        public ImmutableList<E> P0() {
            return new ImmutableArray(toArray());
        }

        @Override // com.hivemq.client.internal.util.collections.ImmutableArray
        public int d() {
            return this.f18688g;
        }

        @Override // com.hivemq.client.internal.util.collections.ImmutableArray
        public int f() {
            return this.f18689h;
        }

        @Override // com.hivemq.client.internal.util.collections.ImmutableArray, java.util.List, j$.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i8) {
            return super.listIterator(i8);
        }

        @Override // com.hivemq.client.internal.util.collections.ImmutableArray, java.util.List, j$.util.List
        public /* bridge */ /* synthetic */ java.util.List subList(int i8, int i9) {
            return super.subList(i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableArray(Object[] objArr) {
        this.f18685f = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> g(Object[] objArr, String str) {
        return new ImmutableArray(Checks.c(objArr, str));
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList
    public /* synthetic */ ImmutableList P0() {
        return b.u(this);
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void add(int i8, Object obj) {
        b.a(this, i8, obj);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean add(Object obj) {
        return b.b(this, obj);
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ boolean addAll(int i8, Collection collection) {
        return b.c(this, i8, collection);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean addAll(Collection collection) {
        return b.d(this, collection);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ void clear() {
        b.e(this);
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList, java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean contains(Object obj) {
        return b.f(this, obj);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean containsAll(Collection collection) {
        return b.g(this, collection);
    }

    int d() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java.util.List)) {
            return false;
        }
        java.util.List<E> list = (java.util.List) obj;
        int d8 = d();
        int f8 = f();
        if (f8 - d8 != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            while (d8 < f8) {
                if (!this.f18685f[d8].equals(list.get(d8))) {
                    return false;
                }
                d8++;
            }
        } else {
            for (E e8 : list) {
                int i8 = d8 + 1;
                if (!this.f18685f[d8].equals(e8)) {
                    return false;
                }
                d8 = i8;
            }
        }
        return true;
    }

    int f() {
        return this.f18685f.length;
    }

    @Override // j$.util.List, j$.util.InterfaceC0106a
    public void forEach(Consumer<? super E> consumer) {
        Checks.j(consumer, "Consumer");
        int f8 = f();
        for (int d8 = d(); d8 < f8; d8++) {
            consumer.accept(this.f18685f[d8]);
        }
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList, java.util.List, j$.util.List
    public E get(int i8) {
        return (E) this.f18685f[d() + Checks.d(i8, size())];
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public int hashCode() {
        int f8 = f();
        int i8 = 1;
        for (int d8 = d(); d8 < f8; d8++) {
            i8 = (i8 * 31) + this.f18685f[d8].hashCode();
        }
        return i8;
    }

    @Override // java.util.List, j$.util.List
    /* renamed from: i */
    public ImmutableList<E> subList(int i8, int i9) {
        int size = size();
        Checks.e(i8, i9, size);
        int d8 = d();
        int i10 = i9 - i8;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == size) {
                    return this;
                }
                return new SubArray(this.f18685f, i8 + d8, d8 + i9);
            }
            return new ImmutableElement(this.f18685f[d8 + i8]);
        }
        return ImmutableEmptyList.b();
    }

    @Override // java.util.List, j$.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int d8 = d();
        int f8 = f();
        for (int i8 = d8; i8 < f8; i8++) {
            if (obj.equals(this.f18685f[i8])) {
                return i8 - d8;
            }
        }
        return -1;
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList, java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean isEmpty() {
        return b.h(this);
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList, java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List
    public /* synthetic */ ImmutableList.ImmutableListIterator iterator() {
        return b.i(this);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List
    public /* bridge */ /* synthetic */ java.util.Iterator iterator() {
        return b.j(this);
    }

    @Override // java.util.List, j$.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int d8 = d();
        for (int f8 = f() - 1; f8 >= d8; f8--) {
            if (obj.equals(this.f18685f[f8])) {
                return f8 - d8;
            }
        }
        return -1;
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList, java.util.List, j$.util.List
    public /* synthetic */ ImmutableList.ImmutableListIterator listIterator() {
        return b.k(this);
    }

    @Override // java.util.List, j$.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return b.l(this);
    }

    @Override // java.util.Collection, j$.util.List
    public /* synthetic */ Stream parallelStream() {
        return Collection$CC.$default$parallelStream(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream parallelStream() {
        return Stream.Wrapper.convert(parallelStream());
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ Object remove(int i8) {
        return b.m(this, i8);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean remove(Object obj) {
        return b.n(this, obj);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean removeAll(Collection collection) {
        return b.o(this, collection);
    }

    @Override // j$.util.List, j$.util.InterfaceC0106a
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return b.p(this, predicate);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
        return removeIf(Predicate.VivifiedWrapper.convert(predicate));
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        b.q(this, unaryOperator);
    }

    @Override // java.util.List
    public /* synthetic */ void replaceAll(java.util.function.UnaryOperator unaryOperator) {
        replaceAll(UnaryOperator.VivifiedWrapper.convert(unaryOperator));
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public /* synthetic */ boolean retainAll(Collection collection) {
        return b.r(this, collection);
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ Object set(int i8, Object obj) {
        return b.s(this, i8, obj);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public int size() {
        return f() - d();
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        b.t(this, comparator);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.InterfaceC0106a
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.f18685f, d(), f(), 1296);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection, j$.util.List, j$.util.InterfaceC0106a
    public /* synthetic */ Stream stream() {
        return Collection$CC.$default$stream(this);
    }

    @Override // java.util.Collection
    public /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(stream());
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public Object[] toArray() {
        return Arrays.copyOfRange(this.f18685f, d(), f());
    }

    @Override // j$.util.List
    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection$CC.$default$toArray(this, intFunction);
    }

    public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
    }

    public String toString() {
        int d8 = d();
        int f8 = f();
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            int i8 = d8 + 1;
            sb.append(this.f18685f[d8]);
            if (i8 == f8) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            d8 = i8;
        }
    }

    @Override // java.util.List, j$.util.List
    public ImmutableList.ImmutableListIterator<E> listIterator(int i8) {
        return new ArrayIterator(d() + Checks.a(i8, size()));
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public <T> T[] toArray(T[] tArr) {
        Checks.j(tArr, "Array");
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        System.arraycopy(this.f18685f, d(), tArr, 0, size);
        return tArr;
    }
}
