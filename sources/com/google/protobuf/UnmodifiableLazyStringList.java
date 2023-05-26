package com.google.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {

    /* renamed from: f  reason: collision with root package name */
    private final LazyStringList f17626f;

    /* renamed from: com.google.protobuf.UnmodifiableLazyStringList$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements ListIterator<String>, Iterator {

        /* renamed from: f  reason: collision with root package name */
        ListIterator<String> f17627f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f17628g;

        AnonymousClass1(int i8) {
            this.f17628g = i8;
            this.f17627f = UnmodifiableLazyStringList.this.f17626f.listIterator(i8);
        }

        @Override // java.util.ListIterator
        /* renamed from: b */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        /* renamed from: c */
        public String next() {
            return this.f17627f.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: d */
        public String previous() {
            return this.f17627f.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: e */
        public void set(String str) {
            throw new UnsupportedOperationException();
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
            return this.f17627f.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f17627f.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f17627f.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f17627f.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.protobuf.UnmodifiableLazyStringList$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements java.util.Iterator<String>, Iterator {

        /* renamed from: f  reason: collision with root package name */
        java.util.Iterator<String> f17630f;

        AnonymousClass2() {
            this.f17630f = UnmodifiableLazyStringList.this.f17626f.iterator();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: b */
        public String next() {
            return this.f17630f.next();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super String> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.f17630f.hasNext();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f17626f = lazyStringList;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d */
    public String get(int i8) {
        return (String) this.f17626f.get(i8);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> e() {
        return this.f17626f.e();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public java.util.Iterator<String> iterator() {
        return new AnonymousClass2();
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList j() {
        return this;
    }

    @Override // com.google.protobuf.LazyStringList
    public Object l(int i8) {
        return this.f17626f.l(i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i8) {
        return new AnonymousClass1(i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f17626f.size();
    }

    @Override // com.google.protobuf.LazyStringList
    public void t(ByteString byteString) {
        throw new UnsupportedOperationException();
    }
}
