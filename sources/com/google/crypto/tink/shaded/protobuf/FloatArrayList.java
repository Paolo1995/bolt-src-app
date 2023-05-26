package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: i  reason: collision with root package name */
    private static final FloatArrayList f15089i;

    /* renamed from: g  reason: collision with root package name */
    private float[] f15090g;

    /* renamed from: h  reason: collision with root package name */
    private int f15091h;

    static {
        FloatArrayList floatArrayList = new FloatArrayList(new float[0], 0);
        f15089i = floatArrayList;
        floatArrayList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatArrayList() {
        this(new float[10], 0);
    }

    private void i(int i8, float f8) {
        int i9;
        b();
        if (i8 >= 0 && i8 <= (i9 = this.f15091h)) {
            float[] fArr = this.f15090g;
            if (i9 < fArr.length) {
                System.arraycopy(fArr, i8, fArr, i8 + 1, i9 - i8);
            } else {
                float[] fArr2 = new float[((i9 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i8);
                System.arraycopy(this.f15090g, i8, fArr2, i8 + 1, this.f15091h - i8);
                this.f15090g = fArr2;
            }
            this.f15090g[i8] = f8;
            this.f15091h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(o(i8));
    }

    private void k(int i8) {
        if (i8 >= 0 && i8 < this.f15091h) {
            return;
        }
        throw new IndexOutOfBoundsException(o(i8));
    }

    private String o(int i8) {
        return "Index:" + i8 + ", Size:" + this.f15091h;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        b();
        Internal.a(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i8 = floatArrayList.f15091h;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f15091h;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            float[] fArr = this.f15090g;
            if (i10 > fArr.length) {
                this.f15090g = Arrays.copyOf(fArr, i10);
            }
            System.arraycopy(floatArrayList.f15090g, 0, this.f15090g, this.f15091h, floatArrayList.f15091h);
            this.f15091h = i10;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: d */
    public void add(int i8, Float f8) {
        i(i8, f8.floatValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.f15091h != floatArrayList.f15091h) {
            return false;
        }
        float[] fArr = floatArrayList.f15090g;
        for (int i8 = 0; i8 < this.f15091h; i8++) {
            if (Float.floatToIntBits(this.f15090g[i8]) != Float.floatToIntBits(fArr[i8])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f */
    public boolean add(Float f8) {
        g(f8.floatValue());
        return true;
    }

    public void g(float f8) {
        b();
        int i8 = this.f15091h;
        float[] fArr = this.f15090g;
        if (i8 == fArr.length) {
            float[] fArr2 = new float[((i8 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i8);
            this.f15090g = fArr2;
        }
        float[] fArr3 = this.f15090g;
        int i9 = this.f15091h;
        this.f15091h = i9 + 1;
        fArr3[i9] = f8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f15091h; i9++) {
            i8 = (i8 * 31) + Float.floatToIntBits(this.f15090g[i9]);
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m */
    public Float get(int i8) {
        return Float.valueOf(n(i8));
    }

    public float n(int i8) {
        k(i8);
        return this.f15090g[i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    /* renamed from: p */
    public Internal.FloatList a(int i8) {
        if (i8 >= this.f15091h) {
            return new FloatArrayList(Arrays.copyOf(this.f15090g, i8), this.f15091h);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: r */
    public Float remove(int i8) {
        int i9;
        b();
        k(i8);
        float[] fArr = this.f15090g;
        float f8 = fArr[i8];
        if (i8 < this.f15091h - 1) {
            System.arraycopy(fArr, i8 + 1, fArr, i8, (i9 - i8) - 1);
        }
        this.f15091h--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f8);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i8, int i9) {
        b();
        if (i9 >= i8) {
            float[] fArr = this.f15090g;
            System.arraycopy(fArr, i9, fArr, i8, this.f15091h - i9);
            this.f15091h -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: s */
    public Float set(int i8, Float f8) {
        return Float.valueOf(u(i8, f8.floatValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15091h;
    }

    public float u(int i8, float f8) {
        b();
        k(i8);
        float[] fArr = this.f15090g;
        float f9 = fArr[i8];
        fArr[i8] = f8;
        return f9;
    }

    private FloatArrayList(float[] fArr, int i8) {
        this.f15090g = fArr;
        this.f15091h = i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i8 = 0; i8 < this.f15091h; i8++) {
            if (obj.equals(Float.valueOf(this.f15090g[i8]))) {
                float[] fArr = this.f15090g;
                System.arraycopy(fArr, i8 + 1, fArr, i8, (this.f15091h - i8) - 1);
                this.f15091h--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
