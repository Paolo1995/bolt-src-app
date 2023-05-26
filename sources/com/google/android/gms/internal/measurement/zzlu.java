package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzlu extends zzio implements RandomAccess {
    private static final zzlu zza;
    private Object[] zzb;
    private int zzc;

    static {
        zzlu zzluVar = new zzlu(new Object[0], 0);
        zza = zzluVar;
        zzluVar.zzb();
    }

    zzlu() {
        this(new Object[10], 0);
    }

    public static zzlu zze() {
        return zza;
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
    public final void add(int i8, Object obj) {
        int i9;
        zzbP();
        if (i8 >= 0 && i8 <= (i9 = this.zzc)) {
            Object[] objArr = this.zzb;
            if (i9 < objArr.length) {
                System.arraycopy(objArr, i8, objArr, i8 + 1, i9 - i8);
            } else {
                Object[] objArr2 = new Object[((i9 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i8);
                System.arraycopy(this.zzb, i8, objArr2, i8 + 1, this.zzc - i8);
                this.zzb = objArr2;
            }
            this.zzb[i8] = obj;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i8));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        zzg(i8);
        return this.zzb[i8];
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final Object remove(int i8) {
        int i9;
        zzbP();
        zzg(i8);
        Object[] objArr = this.zzb;
        Object obj = objArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, (i9 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        zzbP();
        zzg(i8);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* bridge */ /* synthetic */ zzkl zzd(int i8) {
        if (i8 >= this.zzc) {
            return new zzlu(Arrays.copyOf(this.zzb, i8), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzlu(Object[] objArr, int i8) {
        this.zzb = objArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzbP();
        int i8 = this.zzc;
        Object[] objArr = this.zzb;
        if (i8 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i8 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        objArr2[i9] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
