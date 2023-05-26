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
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ImmutableElement<E> implements ImmutableList<E>, List {

    /* renamed from: f  reason: collision with root package name */
    private final E f18690f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class ElementIterator implements ImmutableList.ImmutableListIterator<E>, Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f18691f;

        ElementIterator(int i8) {
            this.f18691f = i8;
        }

        @Override // java.util.ListIterator
        public /* synthetic */ void add(Object obj) {
            o0.a.a(this, obj);
        }

        @Override // j$.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Checks.j(consumer, "Consumer");
            if (hasNext()) {
                consumer.accept((Object) next());
            }
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f18691f == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.f18691f == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public E next() {
            if (hasNext()) {
                this.f18691f = 1;
                return (E) ImmutableElement.this.f18690f;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f18691f;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                this.f18691f = 0;
                return (E) ImmutableElement.this.f18690f;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f18691f - 1;
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
    public class ElementSpliterator implements Spliterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private int f18693a;

        private ElementSpliterator() {
            this.f18693a = 1;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17745;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.f18693a;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Checks.j(consumer, "Consumer");
            tryAdvance(consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public long getExactSizeIfKnown() {
            return this.f18693a;
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i8) {
            return Spliterator.CC.$default$hasCharacteristics(this, i8);
        }

        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            Checks.j(consumer, "Consumer");
            if (this.f18693a != 1) {
                return false;
            }
            consumer.accept((Object) ImmutableElement.this.f18690f);
            this.f18693a = 0;
            return true;
        }

        @Override // j$.util.Spliterator
        public Spliterator<E> trySplit() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableElement(E e8) {
        this.f18690f = e8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> d(E e8) {
        return f(e8, "Immutable list");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> f(E e8, String str) {
        return new ImmutableElement(Checks.b(e8, str, 0));
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

    @Override // java.util.List, java.util.Collection, j$.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java.util.List)) {
            return false;
        }
        java.util.List list = (java.util.List) obj;
        if (list.size() == 1 && this.f18690f.equals(list.get(0))) {
            return true;
        }
        return false;
    }

    @Override // j$.util.List, j$.util.InterfaceC0106a
    public void forEach(Consumer<? super E> consumer) {
        Checks.j(consumer, "Consumer");
        consumer.accept((E) this.f18690f);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.List, j$.util.List
    /* renamed from: g */
    public ImmutableList<E> subList(int i8, int i9) {
        Checks.e(i8, i9, 1);
        if (i9 == i8) {
            return b.z();
        }
        return this;
    }

    @Override // com.hivemq.client.internal.util.collections.ImmutableList, java.util.List, j$.util.List
    public E get(int i8) {
        Checks.d(i8, 1);
        return this.f18690f;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List
    public int hashCode() {
        return this.f18690f.hashCode() + 31;
    }

    @Override // java.util.List, j$.util.List
    public int indexOf(Object obj) {
        if (this.f18690f.equals(obj)) {
            return 0;
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
        return indexOf(obj);
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
        return 1;
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        b.t(this, comparator);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.InterfaceC0106a
    public Spliterator<E> spliterator() {
        return new ElementSpliterator();
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
        return new Object[]{this.f18690f};
    }

    @Override // j$.util.List
    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection$CC.$default$toArray(this, intFunction);
    }

    public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
        return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
    }

    public String toString() {
        return "[" + this.f18690f + "]";
    }

    @Override // java.util.List, j$.util.List
    public ImmutableList.ImmutableListIterator<E> listIterator(int i8) {
        return new ElementIterator(Checks.a(i8, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection, j$.util.List
    public <T> T[] toArray(T[] tArr) {
        Checks.j(tArr, "Array");
        if (tArr.length < 1) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
        } else if (tArr.length > 1) {
            tArr[1] = null;
        }
        tArr[0] = this.f18690f;
        return tArr;
    }
}
