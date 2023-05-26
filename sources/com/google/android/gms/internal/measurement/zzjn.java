package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzjn extends zzio implements RandomAccess, zzls {
    private static final zzjn zza;
    private double[] zzb;
    private int zzc;

    static {
        zzjn zzjnVar = new zzjn(new double[0], 0);
        zza = zzjnVar;
        zzjnVar.zzb();
    }

    zzjn() {
        this(new double[10], 0);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzbP();
        if (i8 >= 0 && i8 <= (i9 = this.zzc)) {
            double[] dArr = this.zzb;
            if (i9 < dArr.length) {
                System.arraycopy(dArr, i8, dArr, i8 + 1, i9 - i8);
            } else {
                double[] dArr2 = new double[((i9 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i8);
                System.arraycopy(this.zzb, i8, dArr2, i8 + 1, this.zzc - i8);
                this.zzb = dArr2;
            }
            this.zzb[i8] = doubleValue;
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
        if (!(collection instanceof zzjn)) {
            return super.addAll(collection);
        }
        zzjn zzjnVar = (zzjn) collection;
        int i8 = zzjnVar.zzc;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            double[] dArr = this.zzb;
            if (i10 > dArr.length) {
                this.zzb = Arrays.copyOf(dArr, i10);
            }
            System.arraycopy(zzjnVar.zzb, 0, this.zzb, this.zzc, zzjnVar.zzc);
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
        if (!(obj instanceof zzjn)) {
            return super.equals(obj);
        }
        zzjn zzjnVar = (zzjn) obj;
        if (this.zzc != zzjnVar.zzc) {
            return false;
        }
        double[] dArr = zzjnVar.zzb;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            if (Double.doubleToLongBits(this.zzb[i8]) != Double.doubleToLongBits(dArr[i8])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzg(i8);
        return Double.valueOf(this.zzb[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzc; i9++) {
            i8 = (i8 * 31) + zzkm.zzc(Double.doubleToLongBits(this.zzb[i9]));
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i8 = this.zzc;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzb[i9] == doubleValue) {
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
        double[] dArr = this.zzb;
        double d8 = dArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(dArr, i8 + 1, dArr, i8, (i9 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d8);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i8, int i9) {
        zzbP();
        if (i9 >= i8) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, i9, dArr, i8, this.zzc - i9);
            this.zzc -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbP();
        zzg(i8);
        double[] dArr = this.zzb;
        double d8 = dArr[i8];
        dArr[i8] = doubleValue;
        return Double.valueOf(d8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* bridge */ /* synthetic */ zzkl zzd(int i8) {
        if (i8 >= this.zzc) {
            return new zzjn(Arrays.copyOf(this.zzb, i8), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(double d8) {
        zzbP();
        int i8 = this.zzc;
        double[] dArr = this.zzb;
        if (i8 == dArr.length) {
            double[] dArr2 = new double[((i8 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i8);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        dArr3[i9] = d8;
    }

    private zzjn(double[] dArr, int i8) {
        this.zzb = dArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
