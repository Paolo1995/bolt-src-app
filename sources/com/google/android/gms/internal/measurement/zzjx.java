package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzjx extends zzio implements RandomAccess, zzls {
    private static final zzjx zza;
    private float[] zzb;
    private int zzc;

    static {
        zzjx zzjxVar = new zzjx(new float[0], 0);
        zza = zzjxVar;
        zzjxVar.zzb();
    }

    zzjx() {
        this(new float[10], 0);
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
        float floatValue = ((Float) obj).floatValue();
        zzbP();
        if (i8 >= 0 && i8 <= (i9 = this.zzc)) {
            float[] fArr = this.zzb;
            if (i9 < fArr.length) {
                System.arraycopy(fArr, i8, fArr, i8 + 1, i9 - i8);
            } else {
                float[] fArr2 = new float[((i9 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i8);
                System.arraycopy(this.zzb, i8, fArr2, i8 + 1, this.zzc - i8);
                this.zzb = fArr2;
            }
            this.zzb[i8] = floatValue;
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
        if (!(collection instanceof zzjx)) {
            return super.addAll(collection);
        }
        zzjx zzjxVar = (zzjx) collection;
        int i8 = zzjxVar.zzc;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i9 >= i8) {
            int i10 = i9 + i8;
            float[] fArr = this.zzb;
            if (i10 > fArr.length) {
                this.zzb = Arrays.copyOf(fArr, i10);
            }
            System.arraycopy(zzjxVar.zzb, 0, this.zzb, this.zzc, zzjxVar.zzc);
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
        if (!(obj instanceof zzjx)) {
            return super.equals(obj);
        }
        zzjx zzjxVar = (zzjx) obj;
        if (this.zzc != zzjxVar.zzc) {
            return false;
        }
        float[] fArr = zzjxVar.zzb;
        for (int i8 = 0; i8 < this.zzc; i8++) {
            if (Float.floatToIntBits(this.zzb[i8]) != Float.floatToIntBits(fArr[i8])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        zzg(i8);
        return Float.valueOf(this.zzb[i8]);
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.zzc; i9++) {
            i8 = (i8 * 31) + Float.floatToIntBits(this.zzb[i9]);
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i8 = this.zzc;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.zzb[i9] == floatValue) {
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
        float[] fArr = this.zzb;
        float f8 = fArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(fArr, i8 + 1, fArr, i8, (i9 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f8);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i8, int i9) {
        zzbP();
        if (i9 >= i8) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, i9, fArr, i8, this.zzc - i9);
            this.zzc -= i9 - i8;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbP();
        zzg(i8);
        float[] fArr = this.zzb;
        float f8 = fArr[i8];
        fArr[i8] = floatValue;
        return Float.valueOf(f8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* bridge */ /* synthetic */ zzkl zzd(int i8) {
        if (i8 >= this.zzc) {
            return new zzjx(Arrays.copyOf(this.zzb, i8), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(float f8) {
        zzbP();
        int i8 = this.zzc;
        float[] fArr = this.zzb;
        if (i8 == fArr.length) {
            float[] fArr2 = new float[((i8 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i8);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        fArr3[i9] = f8;
    }

    private zzjx(float[] fArr, int i8) {
        this.zzb = fArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }
}
