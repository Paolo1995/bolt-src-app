package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class ImmutableList<E> implements List<E>, RandomAccess {

    /* renamed from: f  reason: collision with root package name */
    private final List<E> f16111f;

    private ImmutableList(List<E> list) {
        this.f16111f = Collections.unmodifiableList(list);
    }

    @NonNull
    public static <E> ImmutableList<E> b(@NonNull List<E> list) {
        return new ImmutableList<>(list);
    }

    @NonNull
    public static <E> ImmutableList<E> d(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(@NonNull E e8) {
        return this.f16111f.add(e8);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.f16111f.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f16111f.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f16111f.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f16111f.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.f16111f.equals(obj);
    }

    @Override // java.util.List
    @NonNull
    public E get(int i8) {
        return this.f16111f.get(i8);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f16111f.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f16111f.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f16111f.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.f16111f.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f16111f.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        return this.f16111f.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f16111f.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f16111f.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f16111f.retainAll(collection);
    }

    @Override // java.util.List
    @NonNull
    public E set(int i8, @NonNull E e8) {
        return this.f16111f.set(i8, e8);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f16111f.size();
    }

    @Override // java.util.List
    @NonNull
    public List<E> subList(int i8, int i9) {
        return this.f16111f.subList(i8, i9);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f16111f.toArray();
    }

    @Override // java.util.List
    public void add(int i8, @NonNull E e8) {
        this.f16111f.add(i8, e8);
    }

    @Override // java.util.List
    public boolean addAll(int i8, @NonNull Collection<? extends E> collection) {
        return this.f16111f.addAll(i8, collection);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i8) {
        return this.f16111f.listIterator(i8);
    }

    @Override // java.util.List
    public E remove(int i8) {
        return this.f16111f.remove(i8);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f16111f.toArray(tArr);
    }
}
