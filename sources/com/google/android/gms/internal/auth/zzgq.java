package com.google.android.gms.internal.auth;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzgq {
    private static final zzgq zza = new zzgq(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    private zzgq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgq(int i8, int[] iArr, Object[] objArr, boolean z7) {
        this.zzb = i8;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z7;
    }

    public static zzgq zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgq zzb(zzgq zzgqVar, zzgq zzgqVar2) {
        int i8 = zzgqVar.zzb + zzgqVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzgqVar.zzc, i8);
        System.arraycopy(zzgqVar2.zzc, 0, copyOf, zzgqVar.zzb, zzgqVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgqVar.zzd, i8);
        System.arraycopy(zzgqVar2.zzd, 0, copyOf2, zzgqVar.zzb, zzgqVar2.zzb);
        return new zzgq(i8, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgq zzc() {
        return new zzgq(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgq)) {
            return false;
        }
        zzgq zzgqVar = (zzgq) obj;
        int i8 = this.zzb;
        if (i8 == zzgqVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgqVar.zzc;
            int i9 = 0;
            while (true) {
                if (i9 < i8) {
                    if (iArr[i9] != iArr2[i9]) {
                        break;
                    }
                    i9++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgqVar.zzd;
                    int i10 = this.zzb;
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (objArr[i11].equals(objArr2[i11])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i8 = this.zzb;
        int i9 = (i8 + 527) * 31;
        int[] iArr = this.zzc;
        int i10 = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i8; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i9 + i11) * 31;
        Object[] objArr = this.zzd;
        int i14 = this.zzb;
        for (int i15 = 0; i15 < i14; i15++) {
            i10 = (i10 * 31) + objArr[i15].hashCode();
        }
        return i13 + i10;
    }

    public final void zzd() {
        this.zze = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < this.zzb; i9++) {
            zzfs.zzb(sb, i8, String.valueOf(this.zzc[i9] >>> 3), this.zzd[i9]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(int i8, Object obj) {
        int i9;
        if (this.zze) {
            int i10 = this.zzb;
            int[] iArr = this.zzc;
            if (i10 == iArr.length) {
                if (i10 < 4) {
                    i9 = 8;
                } else {
                    i9 = i10 >> 1;
                }
                int i11 = i10 + i9;
                this.zzc = Arrays.copyOf(iArr, i11);
                this.zzd = Arrays.copyOf(this.zzd, i11);
            }
            int[] iArr2 = this.zzc;
            int i12 = this.zzb;
            iArr2[i12] = i8;
            this.zzd[i12] = obj;
            this.zzb = i12 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
