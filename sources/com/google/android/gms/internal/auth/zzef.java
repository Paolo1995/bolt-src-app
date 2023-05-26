package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzef extends zzdn<Double> implements RandomAccess, zzfx {
    private static final zzef zza;
    private double[] zzb;
    private int zzc;

    static {
        zzef zzefVar = new zzef(new double[0], 0);
        zza = zzefVar;
        zzefVar.zzb();
    }

    zzef() {
        this(new double[10], 0);
    }

    private final String zzf(int i8) {
        int i9 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i8);
        sb.append(", Size:");
        sb.append(i9);
        return sb.toString();
    }

    private final void zzg(int i8) {
        if (i8 >= 0 && i8 < this.zzc) {
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i8));
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i8, Object obj) {
        int i9;
        double doubleValue = ((Double) obj).doubleValue();
        zza();
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

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zza();
        zzev.zze(collection);
        if (!(collection instanceof zzef)) {
            return super.addAll(collection);
        }
        zzef zzefVar = (zzef) collection;
        int i8 = zzefVar.zzc;
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
            System.arraycopy(zzefVar.zzb, 0, this.zzb, this.zzc, zzefVar.zzc);
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

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzef)) {
            return super.equals(obj);
        }
        zzef zzefVar = (zzef) obj;
        if (this.zzc != zzefVar.zzc) {
            return false;
        }
        double[] dArr = zzefVar.zzb;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            if (Double.doubleToLongBits(this.zzb[i8]) != Double.doubleToLongBits(dArr[i8])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i8) {
        zzg(i8);
        return Double.valueOf(this.zzb[i8]);
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzc; i9++) {
            i8 = (i8 * 31) + zzev.zzc(Double.doubleToLongBits(this.zzb[i9]));
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

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        int i9;
        zza();
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
        zza();
        if (i9 >= i8) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, i9, dArr, i8, this.zzc - i9);
            this.zzc -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zza();
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

    @Override // com.google.android.gms.internal.auth.zzeu
    public final /* bridge */ /* synthetic */ zzeu zzd(int i8) {
        if (i8 >= this.zzc) {
            return new zzef(Arrays.copyOf(this.zzb, i8), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(double d8) {
        zza();
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

    private zzef(double[] dArr, int i8) {
        this.zzb = dArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
