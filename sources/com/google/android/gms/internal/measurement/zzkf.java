package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzkf extends zzio implements RandomAccess, zzkj, zzls {
    private static final zzkf zza;
    private int[] zzb;
    private int zzc;

    static {
        zzkf zzkfVar = new zzkf(new int[0], 0);
        zza = zzkfVar;
        zzkfVar.zzb();
    }

    zzkf() {
        this(new int[10], 0);
    }

    public static zzkf zzf() {
        return zza;
    }

    private final String zzi(int i8) {
        int i9 = this.zzc;
        return "Index:" + i8 + ", Size:" + i9;
    }

    private final void zzj(int i8) {
        if (i8 >= 0 && i8 < this.zzc) {
            return;
        }
        throw new IndexOutOfBoundsException(zzi(i8));
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i8, Object obj) {
        int i9;
        int intValue = ((Integer) obj).intValue();
        zzbP();
        if (i8 >= 0 && i8 <= (i9 = this.zzc)) {
            int[] iArr = this.zzb;
            if (i9 < iArr.length) {
                System.arraycopy(iArr, i8, iArr, i8 + 1, i9 - i8);
            } else {
                int[] iArr2 = new int[((i9 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i8);
                System.arraycopy(this.zzb, i8, iArr2, i8 + 1, this.zzc - i8);
                this.zzb = iArr2;
            }
            this.zzb[i8] = intValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzi(i8));
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzbP();
        zzkm.zze(collection);
        if (!(collection instanceof zzkf)) {
            return super.addAll(collection);
        }
        zzkf zzkfVar = (zzkf) collection;
        int i8 = zzkfVar.zzc;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            int[] iArr = this.zzb;
            if (i10 > iArr.length) {
                this.zzb = Arrays.copyOf(iArr, i10);
            }
            System.arraycopy(zzkfVar.zzb, 0, this.zzb, this.zzc, zzkfVar.zzc);
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
        if (!(obj instanceof zzkf)) {
            return super.equals(obj);
        }
        zzkf zzkfVar = (zzkf) obj;
        if (this.zzc != zzkfVar.zzc) {
            return false;
        }
        int[] iArr = zzkfVar.zzb;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            if (this.zzb[i8] != iArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzj(i8);
        return Integer.valueOf(this.zzb[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzc; i9++) {
            i8 = (i8 * 31) + this.zzb[i9];
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i8 = this.zzc;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzb[i9] == intValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        int i9;
        zzbP();
        zzj(i8);
        int[] iArr = this.zzb;
        int i10 = iArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(iArr, i8 + 1, iArr, i8, (i9 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i8, int i9) {
        zzbP();
        if (i9 >= i8) {
            int[] iArr = this.zzb;
            System.arraycopy(iArr, i9, iArr, i8, this.zzc - i9);
            this.zzc -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbP();
        zzj(i8);
        int[] iArr = this.zzb;
        int i9 = iArr[i8];
        iArr[i8] = intValue;
        return Integer.valueOf(i9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    public final int zze(int i8) {
        zzj(i8);
        return this.zzb[i8];
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    /* renamed from: zzg */
    public final zzkj zzd(int i8) {
        if (i8 >= this.zzc) {
            return new zzkf(Arrays.copyOf(this.zzb, i8), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int i8) {
        zzbP();
        int i9 = this.zzc;
        int[] iArr = this.zzb;
        if (i9 == iArr.length) {
            int[] iArr2 = new int[((i9 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i9);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i10 = this.zzc;
        this.zzc = i10 + 1;
        iArr3[i10] = i8;
    }

    private zzkf(int[] iArr, int i8) {
        this.zzb = iArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
