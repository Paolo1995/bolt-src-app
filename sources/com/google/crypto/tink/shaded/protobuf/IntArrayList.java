package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: i  reason: collision with root package name */
    private static final IntArrayList f15112i;

    /* renamed from: g  reason: collision with root package name */
    private int[] f15113g;

    /* renamed from: h  reason: collision with root package name */
    private int f15114h;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        f15112i = intArrayList;
        intArrayList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntArrayList() {
        this(new int[10], 0);
    }

    private void g(int i8, int i9) {
        int i10;
        b();
        if (i8 >= 0 && i8 <= (i10 = this.f15114h)) {
            int[] iArr = this.f15113g;
            if (i10 < iArr.length) {
                System.arraycopy(iArr, i8, iArr, i8 + 1, i10 - i8);
            } else {
                int[] iArr2 = new int[((i10 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i8);
                System.arraycopy(this.f15113g, i8, iArr2, i8 + 1, this.f15114h - i8);
                this.f15113g = iArr2;
            }
            this.f15113g[i8] = i9;
            this.f15114h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(m(i8));
    }

    private void i(int i8) {
        if (i8 >= 0 && i8 < this.f15114h) {
            return;
        }
        throw new IndexOutOfBoundsException(m(i8));
    }

    private String m(int i8) {
        return "Index:" + i8 + ", Size:" + this.f15114h;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        b();
        Internal.a(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i8 = intArrayList.f15114h;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f15114h;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            int[] iArr = this.f15113g;
            if (i10 > iArr.length) {
                this.f15113g = Arrays.copyOf(iArr, i10);
            }
            System.arraycopy(intArrayList.f15113g, 0, this.f15113g, this.f15114h, intArrayList.f15114h);
            this.f15114h = i10;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: d */
    public void add(int i8, Integer num) {
        g(i8, num.intValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.f15114h != intArrayList.f15114h) {
            return false;
        }
        int[] iArr = intArrayList.f15113g;
        for (int i8 = 0; i8 < this.f15114h; i8++) {
            if (this.f15113g[i8] != iArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f */
    public boolean add(Integer num) {
        s0(num.intValue());
        return true;
    }

    public int getInt(int i8) {
        i(i8);
        return this.f15113g[i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f15114h; i9++) {
            i8 = (i8 * 31) + this.f15113g[i9];
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k */
    public Integer get(int i8) {
        return Integer.valueOf(getInt(i8));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    /* renamed from: n */
    public Internal.IntList a(int i8) {
        if (i8 >= this.f15114h) {
            return new IntArrayList(Arrays.copyOf(this.f15113g, i8), this.f15114h);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: o */
    public Integer remove(int i8) {
        int i9;
        b();
        i(i8);
        int[] iArr = this.f15113g;
        int i10 = iArr[i8];
        if (i8 < this.f15114h - 1) {
            System.arraycopy(iArr, i8 + 1, iArr, i8, (i9 - i8) - 1);
        }
        this.f15114h--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: p */
    public Integer set(int i8, Integer num) {
        return Integer.valueOf(q(i8, num.intValue()));
    }

    public int q(int i8, int i9) {
        b();
        i(i8);
        int[] iArr = this.f15113g;
        int i10 = iArr[i8];
        iArr[i8] = i9;
        return i10;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i8, int i9) {
        b();
        if (i9 >= i8) {
            int[] iArr = this.f15113g;
            System.arraycopy(iArr, i9, iArr, i8, this.f15114h - i9);
            this.f15114h -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public void s0(int i8) {
        b();
        int i9 = this.f15114h;
        int[] iArr = this.f15113g;
        if (i9 == iArr.length) {
            int[] iArr2 = new int[((i9 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i9);
            this.f15113g = iArr2;
        }
        int[] iArr3 = this.f15113g;
        int i10 = this.f15114h;
        this.f15114h = i10 + 1;
        iArr3[i10] = i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15114h;
    }

    private IntArrayList(int[] iArr, int i8) {
        this.f15113g = iArr;
        this.f15114h = i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i8 = 0; i8 < this.f15114h; i8++) {
            if (obj.equals(Integer.valueOf(this.f15113g[i8]))) {
                int[] iArr = this.f15113g;
                System.arraycopy(iArr, i8 + 1, iArr, i8, (this.f15114h - i8) - 1);
                this.f15114h--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
