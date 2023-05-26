package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {

    /* renamed from: f  reason: collision with root package name */
    final ArrayList<T> f49821f = new ArrayList<>();

    @Override // java.util.List, java.util.Collection
    public boolean add(T t7) {
        boolean add = this.f49821f.add(t7);
        lazySet(this.f49821f.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.f49821f.addAll(collection);
        lazySet(this.f49821f.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f49821f.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f49821f.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f49821f.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.f49821f.equals(((VolatileSizeArrayList) obj).f49821f);
        }
        return this.f49821f.equals(obj);
    }

    @Override // java.util.List
    public T get(int i8) {
        return this.f49821f.get(i8);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f49821f.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f49821f.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (get() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f49821f.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f49821f.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.f49821f.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = this.f49821f.remove(obj);
        lazySet(this.f49821f.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.f49821f.removeAll(collection);
        lazySet(this.f49821f.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.f49821f.retainAll(collection);
        lazySet(this.f49821f.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i8, T t7) {
        return this.f49821f.set(i8, t7);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i8, int i9) {
        return this.f49821f.subList(i8, i9);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f49821f.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.f49821f.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i8) {
        return this.f49821f.listIterator(i8);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.f49821f.toArray(eArr);
    }

    @Override // java.util.List
    public void add(int i8, T t7) {
        this.f49821f.add(i8, t7);
        lazySet(this.f49821f.size());
    }

    @Override // java.util.List
    public boolean addAll(int i8, Collection<? extends T> collection) {
        boolean addAll = this.f49821f.addAll(i8, collection);
        lazySet(this.f49821f.size());
        return addAll;
    }

    @Override // java.util.List
    public T remove(int i8) {
        T remove = this.f49821f.remove(i8);
        lazySet(this.f49821f.size());
        return remove;
    }
}
