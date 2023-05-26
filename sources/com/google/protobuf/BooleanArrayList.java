package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: i  reason: collision with root package name */
    private static final BooleanArrayList f17174i;

    /* renamed from: g  reason: collision with root package name */
    private boolean[] f17175g;

    /* renamed from: h  reason: collision with root package name */
    private int f17176h;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        f17174i = booleanArrayList;
        booleanArrayList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanArrayList() {
        this(new boolean[10], 0);
    }

    private void g(int i8, boolean z7) {
        int i9;
        b();
        if (i8 >= 0 && i8 <= (i9 = this.f17176h)) {
            boolean[] zArr = this.f17175g;
            if (i9 < zArr.length) {
                System.arraycopy(zArr, i8, zArr, i8 + 1, i9 - i8);
            } else {
                boolean[] zArr2 = new boolean[((i9 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i8);
                System.arraycopy(this.f17175g, i8, zArr2, i8 + 1, this.f17176h - i8);
                this.f17175g = zArr2;
            }
            this.f17175g[i8] = z7;
            this.f17176h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(p(i8));
    }

    public static BooleanArrayList k() {
        return f17174i;
    }

    private void m(int i8) {
        if (i8 >= 0 && i8 < this.f17176h) {
            return;
        }
        throw new IndexOutOfBoundsException(p(i8));
    }

    private String p(int i8) {
        return "Index:" + i8 + ", Size:" + this.f17176h;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        b();
        Internal.a(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i8 = booleanArrayList.f17176h;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f17176h;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            boolean[] zArr = this.f17175g;
            if (i10 > zArr.length) {
                this.f17175g = Arrays.copyOf(zArr, i10);
            }
            System.arraycopy(booleanArrayList.f17175g, 0, this.f17175g, this.f17176h, booleanArrayList.f17176h);
            this.f17176h = i10;
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
    public void add(int i8, Boolean bool) {
        g(i8, bool.booleanValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.f17176h != booleanArrayList.f17176h) {
            return false;
        }
        boolean[] zArr = booleanArrayList.f17175g;
        for (int i8 = 0; i8 < this.f17176h; i8++) {
            if (this.f17175g[i8] != zArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f */
    public boolean add(Boolean bool) {
        i(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f17176h; i9++) {
            i8 = (i8 * 31) + Internal.c(this.f17175g[i9]);
        }
        return i8;
    }

    public void i(boolean z7) {
        b();
        int i8 = this.f17176h;
        boolean[] zArr = this.f17175g;
        if (i8 == zArr.length) {
            boolean[] zArr2 = new boolean[((i8 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i8);
            this.f17175g = zArr2;
        }
        boolean[] zArr3 = this.f17175g;
        int i9 = this.f17176h;
        this.f17176h = i9 + 1;
        zArr3[i9] = z7;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (this.f17175g[i8] == booleanValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n */
    public Boolean get(int i8) {
        return Boolean.valueOf(o(i8));
    }

    public boolean o(int i8) {
        m(i8);
        return this.f17175g[i8];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: r */
    public Boolean remove(int i8) {
        int i9;
        b();
        m(i8);
        boolean[] zArr = this.f17175g;
        boolean z7 = zArr[i8];
        if (i8 < this.f17176h - 1) {
            System.arraycopy(zArr, i8 + 1, zArr, i8, (i9 - i8) - 1);
        }
        this.f17176h--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z7);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i8, int i9) {
        b();
        if (i9 >= i8) {
            boolean[] zArr = this.f17175g;
            System.arraycopy(zArr, i9, zArr, i8, this.f17176h - i9);
            this.f17176h -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: s */
    public Boolean set(int i8, Boolean bool) {
        return Boolean.valueOf(u(i8, bool.booleanValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f17176h;
    }

    public boolean u(int i8, boolean z7) {
        b();
        m(i8);
        boolean[] zArr = this.f17175g;
        boolean z8 = zArr[i8];
        zArr[i8] = z7;
        return z8;
    }

    private BooleanArrayList(boolean[] zArr, int i8) {
        this.f17175g = zArr;
        this.f17176h = i8;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: a */
    public Internal.ProtobufList<Boolean> a2(int i8) {
        if (i8 >= this.f17176h) {
            return new BooleanArrayList(Arrays.copyOf(this.f17175g, i8), this.f17176h);
        }
        throw new IllegalArgumentException();
    }
}
