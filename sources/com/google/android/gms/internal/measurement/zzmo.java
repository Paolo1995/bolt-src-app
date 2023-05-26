package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzmo {
    private static final zzmo zza = new zzmo(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmo() {
        this(0, new int[8], new Object[8], true);
    }

    private zzmo(int i8, int[] iArr, Object[] objArr, boolean z7) {
        this.zze = -1;
        this.zzb = i8;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z7;
    }

    public static zzmo zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmo zzd(zzmo zzmoVar, zzmo zzmoVar2) {
        int i8 = zzmoVar.zzb + zzmoVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzmoVar.zzc, i8);
        System.arraycopy(zzmoVar2.zzc, 0, copyOf, zzmoVar.zzb, zzmoVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmoVar.zzd, i8);
        System.arraycopy(zzmoVar2.zzd, 0, copyOf2, zzmoVar.zzb, zzmoVar2.zzb);
        return new zzmo(i8, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmo zze() {
        return new zzmo(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmo)) {
            return false;
        }
        zzmo zzmoVar = (zzmo) obj;
        int i8 = this.zzb;
        if (i8 == zzmoVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmoVar.zzc;
            int i9 = 0;
            while (true) {
                if (i9 < i8) {
                    if (iArr[i9] != iArr2[i9]) {
                        break;
                    }
                    i9++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmoVar.zzd;
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

    public final int zza() {
        int zzA;
        int zzB;
        int i8;
        int i9 = this.zze;
        if (i9 == -1) {
            int i10 = 0;
            for (int i11 = 0; i11 < this.zzb; i11++) {
                int i12 = this.zzc[i11];
                int i13 = i12 >>> 3;
                int i14 = i12 & 7;
                if (i14 != 0) {
                    if (i14 != 1) {
                        if (i14 != 2) {
                            if (i14 != 3) {
                                if (i14 == 5) {
                                    ((Integer) this.zzd[i11]).intValue();
                                    i8 = zzjl.zzA(i13 << 3) + 4;
                                } else {
                                    throw new IllegalStateException(zzko.zza());
                                }
                            } else {
                                int zzz = zzjl.zzz(i13);
                                zzA = zzz + zzz;
                                zzB = ((zzmo) this.zzd[i11]).zza();
                            }
                        } else {
                            int zzA2 = zzjl.zzA(i13 << 3);
                            int zzd = ((zzjd) this.zzd[i11]).zzd();
                            i10 += zzA2 + zzjl.zzA(zzd) + zzd;
                        }
                    } else {
                        ((Long) this.zzd[i11]).longValue();
                        i8 = zzjl.zzA(i13 << 3) + 8;
                    }
                    i10 += i8;
                } else {
                    long longValue = ((Long) this.zzd[i11]).longValue();
                    zzA = zzjl.zzA(i13 << 3);
                    zzB = zzjl.zzB(longValue);
                }
                i8 = zzA + zzB;
                i10 += i8;
            }
            this.zze = i10;
            return i10;
        }
        return i9;
    }

    public final int zzb() {
        int i8 = this.zze;
        if (i8 == -1) {
            int i9 = 0;
            for (int i10 = 0; i10 < this.zzb; i10++) {
                int i11 = this.zzc[i10];
                int zzA = zzjl.zzA(8);
                int zzd = ((zzjd) this.zzd[i10]).zzd();
                i9 += zzA + zzA + zzjl.zzA(16) + zzjl.zzA(i11 >>> 3) + zzjl.zzA(24) + zzjl.zzA(zzd) + zzd;
            }
            this.zze = i9;
            return i9;
        }
        return i8;
    }

    public final void zzf() {
        this.zzf = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < this.zzb; i9++) {
            zzln.zzb(sb, i8, String.valueOf(this.zzc[i9] >>> 3), this.zzd[i9]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(int i8, Object obj) {
        int i9;
        if (this.zzf) {
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

    public final void zzi(zznf zznfVar) throws IOException {
        if (this.zzb != 0) {
            for (int i8 = 0; i8 < this.zzb; i8++) {
                int i9 = this.zzc[i8];
                Object obj = this.zzd[i8];
                int i10 = i9 >>> 3;
                int i11 = i9 & 7;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 != 3) {
                                if (i11 == 5) {
                                    zznfVar.zzk(i10, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(zzko.zza());
                                }
                            } else {
                                zznfVar.zzE(i10);
                                ((zzmo) obj).zzi(zznfVar);
                                zznfVar.zzh(i10);
                            }
                        } else {
                            zznfVar.zzd(i10, (zzjd) obj);
                        }
                    } else {
                        zznfVar.zzm(i10, ((Long) obj).longValue());
                    }
                } else {
                    zznfVar.zzt(i10, ((Long) obj).longValue());
                }
            }
        }
    }
}
