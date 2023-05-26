package kotlin.collections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: AbstractList.kt */
/* loaded from: classes5.dex */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f50860f = new Companion(null);

    /* compiled from: AbstractList.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i8, int i9, int i10) {
            if (i8 >= 0 && i9 <= i10) {
                if (i8 <= i9) {
                    return;
                }
                throw new IllegalArgumentException("startIndex: " + i8 + " > endIndex: " + i9);
            }
            throw new IndexOutOfBoundsException("startIndex: " + i8 + ", endIndex: " + i9 + ", size: " + i10);
        }

        public final void b(int i8, int i9) {
            if (i8 >= 0 && i8 < i9) {
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i8 + ", size: " + i9);
        }

        public final void c(int i8, int i9) {
            if (i8 >= 0 && i8 <= i9) {
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i8 + ", size: " + i9);
        }

        public final void d(int i8, int i9, int i10) {
            if (i8 >= 0 && i9 <= i10) {
                if (i8 <= i9) {
                    return;
                }
                throw new IllegalArgumentException("fromIndex: " + i8 + " > toIndex: " + i9);
            }
            throw new IndexOutOfBoundsException("fromIndex: " + i8 + ", toIndex: " + i9 + ", size: " + i10);
        }

        public final boolean e(Collection<?> c8, Collection<?> other) {
            Intrinsics.f(c8, "c");
            Intrinsics.f(other, "other");
            if (c8.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c8.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection<?> c8) {
            int i8;
            Intrinsics.f(c8, "c");
            int i9 = 1;
            for (Object obj : c8) {
                int i10 = i9 * 31;
                if (obj != null) {
                    i8 = obj.hashCode();
                } else {
                    i8 = 0;
                }
                i9 = i10 + i8;
            }
            return i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractList.kt */
    /* loaded from: classes5.dex */
    public class IteratorImpl implements Iterator<E>, KMappedMarker, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f50861f;

        public IteratorImpl() {
        }

        protected final int b() {
            return this.f50861f;
        }

        protected final void c(int i8) {
            this.f50861f = i8;
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f50861f < AbstractList.this.size()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public E next() {
            if (hasNext()) {
                AbstractList<E> abstractList = AbstractList.this;
                int i8 = this.f50861f;
                this.f50861f = i8 + 1;
                return abstractList.get(i8);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes5.dex */
    private class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E> {
        public ListIteratorImpl(int i8) {
            super();
            AbstractList.f50860f.c(i8, AbstractList.this.size());
            c(i8);
        }

        @Override // java.util.ListIterator
        public void add(E e8) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (b() > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                AbstractList<E> abstractList = AbstractList.this;
                c(b() - 1);
                return abstractList.get(b());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e8) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes5.dex */
    private static final class SubList<E> extends AbstractList<E> implements RandomAccess {

        /* renamed from: g  reason: collision with root package name */
        private final AbstractList<E> f50864g;

        /* renamed from: h  reason: collision with root package name */
        private final int f50865h;

        /* renamed from: i  reason: collision with root package name */
        private int f50866i;

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(AbstractList<? extends E> list, int i8, int i9) {
            Intrinsics.f(list, "list");
            this.f50864g = list;
            this.f50865h = i8;
            AbstractList.f50860f.d(i8, i9, list.size());
            this.f50866i = i9 - i8;
        }

        @Override // kotlin.collections.AbstractCollection
        public int b() {
            return this.f50866i;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public E get(int i8) {
            AbstractList.f50860f.b(i8, this.f50866i);
            return this.f50864g.get(this.f50865h + i8);
        }
    }

    @Override // java.util.List
    public void add(int i8, E e8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i8, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f50860f.e(this, (Collection) obj);
    }

    @Override // java.util.List
    public abstract E get(int i8);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f50860f.f(this);
    }

    @Override // java.util.List
    public int indexOf(E e8) {
        int i8 = 0;
        for (E e9 : this) {
            if (!Intrinsics.a(e9, e8)) {
                i8++;
            } else {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public java.util.Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override // java.util.List
    public int lastIndexOf(E e8) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.a(listIterator.previous(), e8)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override // java.util.List
    public E remove(int i8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i8, E e8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i8, int i9) {
        return new SubList(this, i8, i9);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i8) {
        return new ListIteratorImpl(i8);
    }
}
