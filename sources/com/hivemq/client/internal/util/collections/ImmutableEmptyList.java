package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.internal.util.collections.ImmutableList;
import j$.util.Collection$CC;
import j$.util.Iterator;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ImmutableEmptyList implements ImmutableList<Object>, List {

    /* renamed from: f  reason: collision with root package name */
    private static final ImmutableEmptyList f18696f = new ImmutableEmptyList();

    /* renamed from: g  reason: collision with root package name */
    private static final Object[] f18697g = new Object[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class EmptyIterator implements ImmutableList.ImmutableListIterator<Object>, Iterator {

        /* renamed from: f  reason: collision with root package name */
        private static final EmptyIterator f18698f = new EmptyIterator();

        private EmptyIterator() {
        }

        static <E> ImmutableList.ImmutableListIterator<E> b() {
            return f18698f;
        }

        @Override // java.util.ListIterator
        public /* synthetic */ void add(Object obj) {
            o0.a.a(this, obj);
        }

        @Override // j$.util.Iterator
        public void forEachRemaining(Consumer<? super Object> consumer) {
            Checks.j(consumer, "Consumer");
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return 0;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return -1;
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
    public static class EmptySpliterator implements Spliterator<Object> {

        /* renamed from: a  reason: collision with root package name */
        private static final EmptySpliterator f18699a = new EmptySpliterator();

        private EmptySpliterator() {
        }

        static <E> Spliterator<E> a() {
            return f18699a;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17745;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return 0L;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super Object> consumer) {
            Checks.j(consumer, "Consumer");
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator<? super Object> getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public long getExactSizeIfKnown() {
            return 0L;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i8) {
            return Spliterator.CC.$default$hasCharacteristics(this, i8);
        }

        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super Object> consumer) {
            Checks.j(consumer, "Consumer");
            return false;
        }

        @Override // j$.util.Spliterator
        public Spliterator<Object> trySplit() {
            return null;
        }
    }

    private ImmutableEmptyList() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> b() {
        return f18696f;
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList
    public /* synthetic */ ImmutableList<Object> P0() {
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

    @Override // java.util.List, j$.util.List
    /* renamed from: d */
    public ImmutableList<Object> subList(int i8, int i9) {
        Checks.e(i8, i9, 0);
        return this;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof java.util.List) && ((java.util.List) obj).size() == 0) {
            return true;
        }
        return false;
    }

    @Override // j$.util.List, j$.util.InterfaceC0106a
    public void forEach(Consumer<? super Object> consumer) {
        Checks.j(consumer, "Consumer");
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList, java.util.List, j$.util.List
    public Object get(int i8) {
        throw new IndexOutOfBoundsException("Empty list");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List, j$.util.List
    public int indexOf(Object obj) {
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
        return 0;
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        b.t(this, comparator);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.InterfaceC0106a
    public Spliterator<Object> spliterator() {
        return EmptySpliterator.a();
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
        return f18697g;
    }

    @Override // j$.util.List
    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection$CC.$default$toArray(this, intFunction);
    }

    public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
    }

    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // java.util.List, j$.util.List
    public ImmutableList.ImmutableListIterator<Object> listIterator(int i8) {
        Checks.a(i8, 0);
        return EmptyIterator.b();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public <T> T[] toArray(T[] tArr) {
        Checks.j(tArr, "Array");
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
