package com.hivemq.client.internal.util.collections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class ChunkedArrayQueue<E> implements Iterable<E> {

    /* renamed from: f  reason: collision with root package name */
    private final int f18673f;

    /* renamed from: g  reason: collision with root package name */
    private E f18674g;

    /* renamed from: h  reason: collision with root package name */
    private Object[] f18675h;

    /* renamed from: i  reason: collision with root package name */
    private Object[] f18676i;

    /* renamed from: j  reason: collision with root package name */
    private int f18677j;

    /* renamed from: k  reason: collision with root package name */
    private int f18678k;

    /* renamed from: l  reason: collision with root package name */
    private int f18679l;

    /* loaded from: classes3.dex */
    public class Iterator implements java.util.Iterator<E>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private Object[] f18680f;

        /* renamed from: g  reason: collision with root package name */
        private int f18681g;

        /* renamed from: h  reason: collision with root package name */
        private int f18682h;

        Iterator() {
            c();
        }

        public int b() {
            return this.f18682h;
        }

        public void c() {
            this.f18680f = ChunkedArrayQueue.this.f18676i;
            this.f18681g = ChunkedArrayQueue.this.f18678k;
            this.f18682h = 0;
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
            if (this.f18682h < ChunkedArrayQueue.this.f18679l) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public E next() {
            E e8 = (E) ChunkedArrayQueue.this.f18674g;
            if (e8 != null) {
                if (this.f18682h <= 0) {
                    this.f18682h = 1;
                    return e8;
                }
                throw new NoSuchElementException();
            }
            Object[] objArr = this.f18680f;
            if (objArr != null) {
                E e9 = (E) objArr[this.f18681g];
                if (e9 != null) {
                    if (e9.getClass() == Object[].class) {
                        Object[] objArr2 = (Object[]) e9;
                        this.f18680f = objArr2;
                        this.f18681g = 1;
                        e9 = (E) objArr2[0];
                    } else {
                        int i8 = this.f18681g + 1;
                        this.f18681g = i8;
                        if (i8 == ChunkedArrayQueue.this.f18673f) {
                            this.f18681g = 0;
                        }
                    }
                    this.f18682h++;
                    return e9;
                }
                throw new NoSuchElementException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            for (int i8 = 0; i8 < this.f18682h; i8++) {
                ChunkedArrayQueue.this.poll();
            }
            this.f18682h = 0;
        }
    }

    public ChunkedArrayQueue(int i8) {
        this.f18673f = i8;
    }

    private void n(E e8) {
        Object[] objArr = this.f18675h;
        int i8 = this.f18677j;
        int i9 = this.f18673f;
        if (i8 == i9 || (objArr == this.f18676i && objArr[i8] != null)) {
            if (this.f18679l >= i9) {
                Object[] objArr2 = new Object[i9];
                int i10 = i8 - 1;
                Object obj = objArr[i10];
                objArr[i10] = objArr2;
                objArr2[0] = obj;
                this.f18675h = objArr2;
                objArr = objArr2;
                i8 = 1;
            } else {
                i8 = 0;
            }
        }
        objArr[i8] = e8;
        this.f18677j = i8 + 1;
        this.f18679l++;
    }

    public boolean isEmpty() {
        if (this.f18679l == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    /* renamed from: k */
    public ChunkedArrayQueue<E>.Iterator iterator() {
        return new Iterator();
    }

    public void m(E e8) {
        int i8 = this.f18679l;
        if (i8 == 0) {
            this.f18679l = 1;
            this.f18674g = e8;
            return;
        }
        if (i8 == 1) {
            if (this.f18675h == null) {
                Object[] objArr = new Object[this.f18673f];
                this.f18676i = objArr;
                this.f18675h = objArr;
            }
            E e9 = this.f18674g;
            if (e9 != null) {
                this.f18679l = 0;
                this.f18674g = null;
                n(e9);
            }
        }
        n(e8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object[]] */
    public E poll() {
        E e8 = this.f18674g;
        int i8 = 0;
        if (e8 != null) {
            this.f18679l = 0;
            this.f18674g = null;
            return e8;
        }
        Object[] objArr = this.f18676i;
        if (objArr == null) {
            return null;
        }
        int i9 = this.f18678k;
        E e9 = (E) objArr[i9];
        if (e9 == null) {
            return null;
        }
        objArr[i9] = null;
        if (e9.getClass() == Object[].class) {
            ?? r42 = (Object[]) e9;
            this.f18676i = r42;
            ?? r02 = r42[0];
            r42[0] = null;
            e9 = r02;
            i8 = 1;
        } else {
            int i10 = i9 + 1;
            if (i10 != this.f18673f) {
                i8 = i10;
            }
        }
        this.f18679l--;
        this.f18678k = i8;
        return e9;
    }

    public int size() {
        return this.f18679l;
    }
}
