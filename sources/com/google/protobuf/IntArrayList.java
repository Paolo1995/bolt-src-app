package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: i  reason: collision with root package name */
    private static final IntArrayList f17446i;

    /* renamed from: g  reason: collision with root package name */
    private int[] f17447g;

    /* renamed from: h  reason: collision with root package name */
    private int f17448h;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        f17446i = intArrayList;
        intArrayList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntArrayList() {
        this(new int[10], 0);
    }

    private void g(int i8, int i9) {
        int i10;
        b();
        if (i8 >= 0 && i8 <= (i10 = this.f17448h)) {
            int[] iArr = this.f17447g;
            if (i10 < iArr.length) {
                System.arraycopy(iArr, i8, iArr, i8 + 1, i10 - i8);
            } else {
                int[] iArr2 = new int[((i10 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i8);
                System.arraycopy(this.f17447g, i8, iArr2, i8 + 1, this.f17448h - i8);
                this.f17447g = iArr2;
            }
            this.f17447g[i8] = i9;
            this.f17448h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(n(i8));
    }

    public static IntArrayList i() {
        return f17446i;
    }

    private void k(int i8) {
        if (i8 >= 0 && i8 < this.f17448h) {
            return;
        }
        throw new IndexOutOfBoundsException(n(i8));
    }

    private String n(int i8) {
        return "Index:" + i8 + ", Size:" + this.f17448h;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        b();
        Internal.a(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i8 = intArrayList.f17448h;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f17448h;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            int[] iArr = this.f17447g;
            if (i10 > iArr.length) {
                this.f17447g = Arrays.copyOf(iArr, i10);
            }
            System.arraycopy(intArrayList.f17447g, 0, this.f17447g, this.f17448h, intArrayList.f17448h);
            this.f17448h = i10;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: d */
    public void add(int i8, Integer num) {
        g(i8, num.intValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.f17448h != intArrayList.f17448h) {
            return false;
        }
        int[] iArr = intArrayList.f17447g;
        for (int i8 = 0; i8 < this.f17448h; i8++) {
            if (this.f17447g[i8] != iArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f */
    public boolean add(Integer num) {
        s0(num.intValue());
        return true;
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int i8) {
        k(i8);
        return this.f17447g[i8];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f17448h; i9++) {
            i8 = (i8 * 31) + this.f17447g[i9];
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (this.f17447g[i8] == intValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m */
    public Integer get(int i8) {
        return Integer.valueOf(getInt(i8));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: o */
    public Integer remove(int i8) {
        int i9;
        b();
        k(i8);
        int[] iArr = this.f17447g;
        int i10 = iArr[i8];
        if (i8 < this.f17448h - 1) {
            System.arraycopy(iArr, i8 + 1, iArr, i8, (i9 - i8) - 1);
        }
        this.f17448h--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: p */
    public Integer set(int i8, Integer num) {
        return Integer.valueOf(q(i8, num.intValue()));
    }

    @Override // com.google.protobuf.Internal.IntList
    public int q(int i8, int i9) {
        b();
        k(i8);
        int[] iArr = this.f17447g;
        int i10 = iArr[i8];
        iArr[i8] = i9;
        return i10;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i8, int i9) {
        b();
        if (i9 >= i8) {
            int[] iArr = this.f17447g;
            System.arraycopy(iArr, i9, iArr, i8, this.f17448h - i9);
            this.f17448h -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.IntList
    public void s0(int i8) {
        b();
        int i9 = this.f17448h;
        int[] iArr = this.f17447g;
        if (i9 == iArr.length) {
            int[] iArr2 = new int[((i9 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i9);
            this.f17447g = iArr2;
        }
        int[] iArr3 = this.f17447g;
        int i10 = this.f17448h;
        this.f17448h = i10 + 1;
        iArr3[i10] = i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f17448h;
    }

    private IntArrayList(int[] iArr, int i8) {
        this.f17447g = iArr;
        this.f17448h = i8;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: a */
    public Internal.ProtobufList<Integer> a2(int i8) {
        if (i8 >= this.f17448h) {
            return new IntArrayList(Arrays.copyOf(this.f17447g, i8), this.f17448h);
        }
        throw new IllegalArgumentException();
    }
}
