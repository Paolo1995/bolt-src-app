package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzla extends zzio implements RandomAccess, zzkk, zzls {
    private static final zzla zza;
    private long[] zzb;
    private int zzc;

    static {
        zzla zzlaVar = new zzla(new long[0], 0);
        zza = zzlaVar;
        zzlaVar.zzb();
    }

    zzla() {
        this(new long[10], 0);
    }

    public static zzla zzf() {
        return zza;
    }

    private final String zzh(int i8) {
        int i9 = this.zzc;
        return "Index:" + i8 + ", Size:" + i9;
    }

    private final void zzi(int i8) {
        if (i8 >= 0 && i8 < this.zzc) {
            return;
        }
        throw new IndexOutOfBoundsException(zzh(i8));
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i8, Object obj) {
        int i9;
        long longValue = ((Long) obj).longValue();
        zzbP();
        if (i8 >= 0 && i8 <= (i9 = this.zzc)) {
            long[] jArr = this.zzb;
            if (i9 < jArr.length) {
                System.arraycopy(jArr, i8, jArr, i8 + 1, i9 - i8);
            } else {
                long[] jArr2 = new long[((i9 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i8);
                System.arraycopy(this.zzb, i8, jArr2, i8 + 1, this.zzc - i8);
                this.zzb = jArr2;
            }
            this.zzb[i8] = longValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzh(i8));
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzbP();
        zzkm.zze(collection);
        if (!(collection instanceof zzla)) {
            return super.addAll(collection);
        }
        zzla zzlaVar = (zzla) collection;
        int i8 = zzlaVar.zzc;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            long[] jArr = this.zzb;
            if (i10 > jArr.length) {
                this.zzb = Arrays.copyOf(jArr, i10);
            }
            System.arraycopy(zzlaVar.zzb, 0, this.zzb, this.zzc, zzlaVar.zzc);
            this.zzc = i10;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzla)) {
            return super.equals(obj);
        }
        zzla zzlaVar = (zzla) obj;
        if (this.zzc != zzlaVar.zzc) {
            return false;
        }
        long[] jArr = zzlaVar.zzb;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            if (this.zzb[i8] != jArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzi(i8);
        return Long.valueOf(this.zzb[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzc; i9++) {
            i8 = (i8 * 31) + zzkm.zzc(this.zzb[i9]);
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i8 = this.zzc;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzb[i9] == longValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        int i9;
        zzbP();
        zzi(i8);
        long[] jArr = this.zzb;
        long j8 = jArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(jArr, i8 + 1, jArr, i8, (i9 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j8);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i8, int i9) {
        zzbP();
        if (i9 >= i8) {
            long[] jArr = this.zzb;
            System.arraycopy(jArr, i9, jArr, i8, this.zzc - i9);
            this.zzc -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbP();
        zzi(i8);
        long[] jArr = this.zzb;
        long j8 = jArr[i8];
        jArr[i8] = longValue;
        return Long.valueOf(j8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkk
    public final long zza(int i8) {
        zzi(i8);
        return this.zzb[i8];
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    /* renamed from: zze */
    public final zzkk zzd(int i8) {
        if (i8 >= this.zzc) {
            return new zzla(Arrays.copyOf(this.zzb, i8), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzg(long j8) {
        zzbP();
        int i8 = this.zzc;
        long[] jArr = this.zzb;
        if (i8 == jArr.length) {
            long[] jArr2 = new long[((i8 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i8);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        jArr3[i9] = j8;
    }

    private zzla(long[] jArr, int i8) {
        this.zzb = jArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }
}
