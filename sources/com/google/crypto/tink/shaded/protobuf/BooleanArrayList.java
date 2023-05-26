package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: i  reason: collision with root package name */
    private static final BooleanArrayList f14986i;

    /* renamed from: g  reason: collision with root package name */
    private boolean[] f14987g;

    /* renamed from: h  reason: collision with root package name */
    private int f14988h;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        f14986i = booleanArrayList;
        booleanArrayList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanArrayList() {
        this(new boolean[10], 0);
    }

    private void g(int i8, boolean z7) {
        int i9;
        b();
        if (i8 >= 0 && i8 <= (i9 = this.f14988h)) {
            boolean[] zArr = this.f14987g;
            if (i9 < zArr.length) {
                System.arraycopy(zArr, i8, zArr, i8 + 1, i9 - i8);
            } else {
                boolean[] zArr2 = new boolean[((i9 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i8);
                System.arraycopy(this.f14987g, i8, zArr2, i8 + 1, this.f14988h - i8);
                this.f14987g = zArr2;
            }
            this.f14987g[i8] = z7;
            this.f14988h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(o(i8));
    }

    private void k(int i8) {
        if (i8 >= 0 && i8 < this.f14988h) {
            return;
        }
        throw new IndexOutOfBoundsException(o(i8));
    }

    private String o(int i8) {
        return "Index:" + i8 + ", Size:" + this.f14988h;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        b();
        Internal.a(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i8 = booleanArrayList.f14988h;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f14988h;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            boolean[] zArr = this.f14987g;
            if (i10 > zArr.length) {
                this.f14987g = Arrays.copyOf(zArr, i10);
            }
            System.arraycopy(booleanArrayList.f14987g, 0, this.f14987g, this.f14988h, booleanArrayList.f14988h);
            this.f14988h = i10;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: d */
    public void add(int i8, Boolean bool) {
        g(i8, bool.booleanValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.f14988h != booleanArrayList.f14988h) {
            return false;
        }
        boolean[] zArr = booleanArrayList.f14987g;
        for (int i8 = 0; i8 < this.f14988h; i8++) {
            if (this.f14987g[i8] != zArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f */
    public boolean add(Boolean bool) {
        i(bool.booleanValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f14988h; i9++) {
            i8 = (i8 * 31) + Internal.c(this.f14987g[i9]);
        }
        return i8;
    }

    public void i(boolean z7) {
        b();
        int i8 = this.f14988h;
        boolean[] zArr = this.f14987g;
        if (i8 == zArr.length) {
            boolean[] zArr2 = new boolean[((i8 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i8);
            this.f14987g = zArr2;
        }
        boolean[] zArr3 = this.f14987g;
        int i9 = this.f14988h;
        this.f14988h = i9 + 1;
        zArr3[i9] = z7;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m */
    public Boolean get(int i8) {
        return Boolean.valueOf(n(i8));
    }

    public boolean n(int i8) {
        k(i8);
        return this.f14987g[i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    /* renamed from: p */
    public Internal.BooleanList a(int i8) {
        if (i8 >= this.f14988h) {
            return new BooleanArrayList(Arrays.copyOf(this.f14987g, i8), this.f14988h);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: r */
    public Boolean remove(int i8) {
        int i9;
        b();
        k(i8);
        boolean[] zArr = this.f14987g;
        boolean z7 = zArr[i8];
        if (i8 < this.f14988h - 1) {
            System.arraycopy(zArr, i8 + 1, zArr, i8, (i9 - i8) - 1);
        }
        this.f14988h--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z7);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i8, int i9) {
        b();
        if (i9 >= i8) {
            boolean[] zArr = this.f14987g;
            System.arraycopy(zArr, i9, zArr, i8, this.f14988h - i9);
            this.f14988h -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: s */
    public Boolean set(int i8, Boolean bool) {
        return Boolean.valueOf(u(i8, bool.booleanValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f14988h;
    }

    public boolean u(int i8, boolean z7) {
        b();
        k(i8);
        boolean[] zArr = this.f14987g;
        boolean z8 = zArr[i8];
        zArr[i8] = z7;
        return z8;
    }

    private BooleanArrayList(boolean[] zArr, int i8) {
        this.f14987g = zArr;
        this.f14988h = i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i8 = 0; i8 < this.f14988h; i8++) {
            if (obj.equals(Boolean.valueOf(this.f14987g[i8]))) {
                boolean[] zArr = this.f14987g;
                System.arraycopy(zArr, i8 + 1, zArr, i8, (this.f14988h - i8) - 1);
                this.f14988h--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
