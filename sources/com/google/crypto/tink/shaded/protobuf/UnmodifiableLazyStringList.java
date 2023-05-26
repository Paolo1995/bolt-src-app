package com.google.crypto.tink.shaded.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {

    /* renamed from: f  reason: collision with root package name */
    private final LazyStringList f15235f;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ListIterator<String>, Iterator {

        /* renamed from: f  reason: collision with root package name */
        ListIterator<String> f15236f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f15237g;

        AnonymousClass1(int i8) {
            this.f15237g = i8;
            this.f15236f = UnmodifiableLazyStringList.this.f15235f.listIterator(i8);
        }

        @Override // java.util.ListIterator
        /* renamed from: b */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        /* renamed from: c */
        public String next() {
            return this.f15236f.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: d */
        public String previous() {
            return this.f15236f.previous();
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
            return this.f15236f.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f15236f.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f15236f.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f15236f.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements java.util.Iterator<String>, Iterator {

        /* renamed from: f  reason: collision with root package name */
        java.util.Iterator<String> f15239f;

        AnonymousClass2() {
            this.f15239f = UnmodifiableLazyStringList.this.f15235f.iterator();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: b */
        public String next() {
            return this.f15239f.next();
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
            return this.f15239f.hasNext();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f15235f = lazyStringList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void U0(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d */
    public String get(int i8) {
        return (String) this.f15235f.get(i8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public List<?> e() {
        return this.f15235f.e();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public java.util.Iterator<String> iterator() {
        return new AnonymousClass2();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public LazyStringList j() {
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public Object l(int i8) {
        return this.f15235f.l(i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i8) {
        return new AnonymousClass1(i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15235f.size();
    }
}
