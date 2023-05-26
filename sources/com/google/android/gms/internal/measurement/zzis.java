package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzis extends zzio implements RandomAccess, zzls {
    private static final zzis zza;
    private boolean[] zzb;
    private int zzc;

    static {
        zzis zzisVar = new zzis(new boolean[0], 0);
        zza = zzisVar;
        zzisVar.zzb();
    }

    zzis() {
        this(new boolean[10], 0);
    }

    private final String zzf(int i8) {
        int i9 = this.zzc;
        return "Index:" + i8 + ", Size:" + i9;
    }

    private final void zzg(int i8) {
        if (i8 >= 0 && i8 < this.zzc) {
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i8));
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i8, Object obj) {
        int i9;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbP();
        if (i8 >= 0 && i8 <= (i9 = this.zzc)) {
            boolean[] zArr = this.zzb;
            if (i9 < zArr.length) {
                System.arraycopy(zArr, i8, zArr, i8 + 1, i9 - i8);
            } else {
                boolean[] zArr2 = new boolean[((i9 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i8);
                System.arraycopy(this.zzb, i8, zArr2, i8 + 1, this.zzc - i8);
                this.zzb = zArr2;
            }
            this.zzb[i8] = booleanValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i8));
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzbP();
        zzkm.zze(collection);
        if (!(collection instanceof zzis)) {
            return super.addAll(collection);
        }
        zzis zzisVar = (zzis) collection;
        int i8 = zzisVar.zzc;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            boolean[] zArr = this.zzb;
            if (i10 > zArr.length) {
                this.zzb = Arrays.copyOf(zArr, i10);
            }
            System.arraycopy(zzisVar.zzb, 0, this.zzb, this.zzc, zzisVar.zzc);
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
        if (!(obj instanceof zzis)) {
            return super.equals(obj);
        }
        zzis zzisVar = (zzis) obj;
        if (this.zzc != zzisVar.zzc) {
            return false;
        }
        boolean[] zArr = zzisVar.zzb;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            if (this.zzb[i8] != zArr[i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzg(i8);
        return Boolean.valueOf(this.zzb[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzc; i9++) {
            i8 = (i8 * 31) + zzkm.zza(this.zzb[i9]);
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i8 = this.zzc;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzb[i9] == booleanValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        int i9;
        zzbP();
        zzg(i8);
        boolean[] zArr = this.zzb;
        boolean z7 = zArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(zArr, i8 + 1, zArr, i8, (i9 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z7);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i8, int i9) {
        zzbP();
        if (i9 >= i8) {
            boolean[] zArr = this.zzb;
            System.arraycopy(zArr, i9, zArr, i8, this.zzc - i9);
            this.zzc -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbP();
        zzg(i8);
        boolean[] zArr = this.zzb;
        boolean z7 = zArr[i8];
        zArr[i8] = booleanValue;
        return Boolean.valueOf(z7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* bridge */ /* synthetic */ zzkl zzd(int i8) {
        if (i8 >= this.zzc) {
            return new zzis(Arrays.copyOf(this.zzb, i8), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z7) {
        zzbP();
        int i8 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i8 == zArr.length) {
            boolean[] zArr2 = new boolean[((i8 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i8);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        zArr3[i9] = z7;
    }

    private zzis(boolean[] zArr, int i8) {
        this.zzb = zArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
