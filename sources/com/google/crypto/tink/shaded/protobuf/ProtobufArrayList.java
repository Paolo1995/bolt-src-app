package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {

    /* renamed from: i  reason: collision with root package name */
    private static final ProtobufArrayList<Object> f15190i;

    /* renamed from: g  reason: collision with root package name */
    private E[] f15191g;

    /* renamed from: h  reason: collision with root package name */
    private int f15192h;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        f15190i = protobufArrayList;
        protobufArrayList.c();
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private static <E> E[] d(int i8) {
        return (E[]) new Object[i8];
    }

    public static <E> ProtobufArrayList<E> f() {
        return (ProtobufArrayList<E>) f15190i;
    }

    private void g(int i8) {
        if (i8 >= 0 && i8 < this.f15192h) {
            return;
        }
        throw new IndexOutOfBoundsException(i(i8));
    }

    private String i(int i8) {
        return "Index:" + i8 + ", Size:" + this.f15192h;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e8) {
        b();
        int i8 = this.f15192h;
        E[] eArr = this.f15191g;
        if (i8 == eArr.length) {
            this.f15191g = (E[]) Arrays.copyOf(eArr, ((i8 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f15191g;
        int i9 = this.f15192h;
        this.f15192h = i9 + 1;
        eArr2[i9] = e8;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i8) {
        g(i8);
        return this.f15191g[i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    /* renamed from: k */
    public ProtobufArrayList<E> a(int i8) {
        if (i8 >= this.f15192h) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.f15191g, i8), this.f15192h);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i8) {
        int i9;
        b();
        g(i8);
        E[] eArr = this.f15191g;
        E e8 = eArr[i8];
        if (i8 < this.f15192h - 1) {
            System.arraycopy(eArr, i8 + 1, eArr, i8, (i9 - i8) - 1);
        }
        this.f15192h--;
        ((AbstractList) this).modCount++;
        return e8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i8, E e8) {
        b();
        g(i8);
        E[] eArr = this.f15191g;
        E e9 = eArr[i8];
        eArr[i8] = e8;
        ((AbstractList) this).modCount++;
        return e9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15192h;
    }

    private ProtobufArrayList(E[] eArr, int i8) {
        this.f15191g = eArr;
        this.f15192h = i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i8, E e8) {
        int i9;
        b();
        if (i8 >= 0 && i8 <= (i9 = this.f15192h)) {
            E[] eArr = this.f15191g;
            if (i9 < eArr.length) {
                System.arraycopy(eArr, i8, eArr, i8 + 1, i9 - i8);
            } else {
                E[] eArr2 = (E[]) d(((i9 * 3) / 2) + 1);
                System.arraycopy(this.f15191g, 0, eArr2, 0, i8);
                System.arraycopy(this.f15191g, i8, eArr2, i8 + 1, this.f15192h - i8);
                this.f15191g = eArr2;
            }
            this.f15191g[i8] = e8;
            this.f15192h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(i(i8));
    }
}
