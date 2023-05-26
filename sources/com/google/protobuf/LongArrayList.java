package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: i  reason: collision with root package name */
    private static final LongArrayList f17497i;

    /* renamed from: g  reason: collision with root package name */
    private long[] f17498g;

    /* renamed from: h  reason: collision with root package name */
    private int f17499h;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        f17497i = longArrayList;
        longArrayList.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongArrayList() {
        this(new long[10], 0);
    }

    private void g(int i8, long j8) {
        int i9;
        b();
        if (i8 >= 0 && i8 <= (i9 = this.f17499h)) {
            long[] jArr = this.f17498g;
            if (i9 < jArr.length) {
                System.arraycopy(jArr, i8, jArr, i8 + 1, i9 - i8);
            } else {
                long[] jArr2 = new long[((i9 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i8);
                System.arraycopy(this.f17498g, i8, jArr2, i8 + 1, this.f17499h - i8);
                this.f17498g = jArr2;
            }
            this.f17498g[i8] = j8;
            this.f17499h++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(n(i8));
    }

    public static LongArrayList i() {
        return f17497i;
    }

    private void k(int i8) {
        if (i8 >= 0 && i8 < this.f17499h) {
            return;
        }
        throw new IndexOutOfBoundsException(n(i8));
    }

    private String n(int i8) {
        return "Index:" + i8 + ", Size:" + this.f17499h;
    }

    @Override // com.google.protobuf.Internal.LongList
    public long S0(int i8, long j8) {
        b();
        k(i8);
        long[] jArr = this.f17498g;
        long j9 = jArr[i8];
        jArr[i8] = j8;
        return j9;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        b();
        Internal.a(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i8 = longArrayList.f17499h;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f17499h;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            long[] jArr = this.f17498g;
            if (i10 > jArr.length) {
                this.f17498g = Arrays.copyOf(jArr, i10);
            }
            System.arraycopy(longArrayList.f17498g, 0, this.f17498g, this.f17499h, longArrayList.f17499h);
            this.f17499h = i10;
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
    public void add(int i8, Long l8) {
        g(i8, l8.longValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.f17499h != longArrayList.f17499h) {
            return false;
        }
        long[] jArr = longArrayList.f17498g;
        for (int i8 = 0; i8 < this.f17499h; i8++) {
            if (this.f17498g[i8] != jArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f */
    public boolean add(Long l8) {
        v0(l8.longValue());
        return true;
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int i8) {
        k(i8);
        return this.f17498g[i8];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f17499h; i9++) {
            i8 = (i8 * 31) + Internal.f(this.f17498g[i9]);
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (this.f17498g[i8] == longValue) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m */
    public Long get(int i8) {
        return Long.valueOf(getLong(i8));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: o */
    public Long remove(int i8) {
        int i9;
        b();
        k(i8);
        long[] jArr = this.f17498g;
        long j8 = jArr[i8];
        if (i8 < this.f17499h - 1) {
            System.arraycopy(jArr, i8 + 1, jArr, i8, (i9 - i8) - 1);
        }
        this.f17499h--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j8);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: p */
    public Long set(int i8, Long l8) {
        return Long.valueOf(S0(i8, l8.longValue()));
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i8, int i9) {
        b();
        if (i9 >= i8) {
            long[] jArr = this.f17498g;
            System.arraycopy(jArr, i9, jArr, i8, this.f17499h - i9);
            this.f17499h -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f17499h;
    }

    @Override // com.google.protobuf.Internal.LongList
    public void v0(long j8) {
        b();
        int i8 = this.f17499h;
        long[] jArr = this.f17498g;
        if (i8 == jArr.length) {
            long[] jArr2 = new long[((i8 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i8);
            this.f17498g = jArr2;
        }
        long[] jArr3 = this.f17498g;
        int i9 = this.f17499h;
        this.f17499h = i9 + 1;
        jArr3[i9] = j8;
    }

    private LongArrayList(long[] jArr, int i8) {
        this.f17498g = jArr;
        this.f17499h = i8;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: a */
    public Internal.ProtobufList<Long> a2(int i8) {
        if (i8 >= this.f17499h) {
            return new LongArrayList(Arrays.copyOf(this.f17498g, i8), this.f17499h);
        }
        throw new IllegalArgumentException();
    }
}
