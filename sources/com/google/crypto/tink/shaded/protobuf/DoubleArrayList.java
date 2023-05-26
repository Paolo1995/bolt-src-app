package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: i  reason: collision with root package name */
    private static final DoubleArrayList f15029i;

    /* renamed from: g  reason: collision with root package name */
    private double[] f15030g;

    /* renamed from: h  reason: collision with root package name */
    private int f15031h;

    static {
        DoubleArrayList doubleArrayList = new DoubleArrayList(new double[0], 0);
        f15029i = doubleArrayList;
        doubleArrayList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleArrayList() {
        this(new double[10], 0);
    }

    private void g(int i8, double d8) {
        int i9;
        b();
        if (i8 >= 0 && i8 <= (i9 = this.f15031h)) {
            double[] dArr = this.f15030g;
            if (i9 < dArr.length) {
                System.arraycopy(dArr, i8, dArr, i8 + 1, i9 - i8);
            } else {
                double[] dArr2 = new double[((i9 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i8);
                System.arraycopy(this.f15030g, i8, dArr2, i8 + 1, this.f15031h - i8);
                this.f15030g = dArr2;
            }
            this.f15030g[i8] = d8;
            this.f15031h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(m(i8));
    }

    private void i(int i8) {
        if (i8 >= 0 && i8 < this.f15031h) {
            return;
        }
        throw new IndexOutOfBoundsException(m(i8));
    }

    private String m(int i8) {
        return "Index:" + i8 + ", Size:" + this.f15031h;
    }

    public void K0(double d8) {
        b();
        int i8 = this.f15031h;
        double[] dArr = this.f15030g;
        if (i8 == dArr.length) {
            double[] dArr2 = new double[((i8 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i8);
            this.f15030g = dArr2;
        }
        double[] dArr3 = this.f15030g;
        int i9 = this.f15031h;
        this.f15031h = i9 + 1;
        dArr3[i9] = d8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        b();
        Internal.a(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i8 = doubleArrayList.f15031h;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f15031h;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            double[] dArr = this.f15030g;
            if (i10 > dArr.length) {
                this.f15030g = Arrays.copyOf(dArr, i10);
            }
            System.arraycopy(doubleArrayList.f15030g, 0, this.f15030g, this.f15031h, doubleArrayList.f15031h);
            this.f15031h = i10;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: d */
    public void add(int i8, Double d8) {
        g(i8, d8.doubleValue());
    }

    public double d0(int i8, double d8) {
        b();
        i(i8);
        double[] dArr = this.f15030g;
        double d9 = dArr[i8];
        dArr[i8] = d8;
        return d9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.f15031h != doubleArrayList.f15031h) {
            return false;
        }
        double[] dArr = doubleArrayList.f15030g;
        for (int i8 = 0; i8 < this.f15031h; i8++) {
            if (Double.doubleToLongBits(this.f15030g[i8]) != Double.doubleToLongBits(dArr[i8])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f */
    public boolean add(Double d8) {
        K0(d8.doubleValue());
        return true;
    }

    public double getDouble(int i8) {
        i(i8);
        return this.f15030g[i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f15031h; i9++) {
            i8 = (i8 * 31) + Internal.f(Double.doubleToLongBits(this.f15030g[i9]));
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k */
    public Double get(int i8) {
        return Double.valueOf(getDouble(i8));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    /* renamed from: n */
    public Internal.DoubleList a(int i8) {
        if (i8 >= this.f15031h) {
            return new DoubleArrayList(Arrays.copyOf(this.f15030g, i8), this.f15031h);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: o */
    public Double remove(int i8) {
        int i9;
        b();
        i(i8);
        double[] dArr = this.f15030g;
        double d8 = dArr[i8];
        if (i8 < this.f15031h - 1) {
            System.arraycopy(dArr, i8 + 1, dArr, i8, (i9 - i8) - 1);
        }
        this.f15031h--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: p */
    public Double set(int i8, Double d8) {
        return Double.valueOf(d0(i8, d8.doubleValue()));
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i8, int i9) {
        b();
        if (i9 >= i8) {
            double[] dArr = this.f15030g;
            System.arraycopy(dArr, i9, dArr, i8, this.f15031h - i9);
            this.f15031h -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15031h;
    }

    private DoubleArrayList(double[] dArr, int i8) {
        this.f15030g = dArr;
        this.f15031h = i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i8 = 0; i8 < this.f15031h; i8++) {
            if (obj.equals(Double.valueOf(this.f15030g[i8]))) {
                double[] dArr = this.f15030g;
                System.arraycopy(dArr, i8 + 1, dArr, i8, (this.f15031h - i8) - 1);
                this.f15031h--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
