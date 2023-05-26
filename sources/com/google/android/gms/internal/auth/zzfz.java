package com.google.android.gms.internal.auth;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzfz<E> extends zzdn<E> implements RandomAccess {
    private static final zzfz<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzfz<Object> zzfzVar = new zzfz<>(new Object[0], 0);
        zza = zzfzVar;
        zzfzVar.zzb();
    }

    zzfz() {
        this(new Object[10], 0);
    }

    public static <E> zzfz<E> zze() {
        return (zzfz<E>) zza;
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
    public final void add(int i8, E e8) {
        int i9;
        zza();
        if (i8 >= 0 && i8 <= (i9 = this.zzc)) {
            E[] eArr = this.zzb;
            if (i9 < eArr.length) {
                System.arraycopy(eArr, i8, eArr, i8 + 1, i9 - i8);
            } else {
                E[] eArr2 = (E[]) new Object[((i9 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i8);
                System.arraycopy(this.zzb, i8, eArr2, i8 + 1, this.zzc - i8);
                this.zzb = eArr2;
            }
            this.zzb[i8] = e8;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i8));
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i8) {
        zzg(i8);
        return this.zzb[i8];
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final E remove(int i8) {
        int i9;
        zza();
        zzg(i8);
        E[] eArr = this.zzb;
        E e8 = eArr[i8];
        if (i8 < this.zzc - 1) {
            System.arraycopy(eArr, i8 + 1, eArr, i8, (i9 - i8) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return e8;
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final E set(int i8, E e8) {
        zza();
        zzg(i8);
        E[] eArr = this.zzb;
        E e9 = eArr[i8];
        eArr[i8] = e8;
        ((AbstractList) this).modCount++;
        return e9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzeu
    public final /* bridge */ /* synthetic */ zzeu zzd(int i8) {
        if (i8 >= this.zzc) {
            return new zzfz(Arrays.copyOf(this.zzb, i8), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzfz(E[] eArr, int i8) {
        this.zzb = eArr;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e8) {
        zza();
        int i8 = this.zzc;
        E[] eArr = this.zzb;
        if (i8 == eArr.length) {
            this.zzb = (E[]) Arrays.copyOf(eArr, ((i8 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i9 = this.zzc;
        this.zzc = i9 + 1;
        eArr2[i9] = e8;
        ((AbstractList) this).modCount++;
        return true;
    }
}
