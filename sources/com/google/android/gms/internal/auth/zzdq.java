package com.google.android.gms.internal.auth;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzdq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i8, zzdp zzdpVar) throws zzew {
        int zzj = zzj(bArr, i8, zzdpVar);
        int i9 = zzdpVar.zza;
        if (i9 >= 0) {
            if (i9 <= bArr.length - zzj) {
                if (i9 == 0) {
                    zzdpVar.zzc = zzeb.zzb;
                    return zzj;
                }
                zzdpVar.zzc = zzeb.zzk(bArr, zzj, i9);
                return zzj + i9;
            }
            throw zzew.zzf();
        }
        throw zzew.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i8) {
        return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzgb zzgbVar, byte[] bArr, int i8, int i9, int i10, zzdp zzdpVar) throws IOException {
        zzft zzftVar = (zzft) zzgbVar;
        Object zzd = zzftVar.zzd();
        int zzb = zzftVar.zzb(zzd, bArr, i8, i9, i10, zzdpVar);
        zzftVar.zze(zzd);
        zzdpVar.zzc = zzd;
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzgb zzgbVar, byte[] bArr, int i8, int i9, zzdp zzdpVar) throws IOException {
        int i10 = i8 + 1;
        int i11 = bArr[i8];
        if (i11 < 0) {
            i10 = zzk(i11, bArr, i10, zzdpVar);
            i11 = zzdpVar.zza;
        }
        int i12 = i10;
        if (i11 >= 0 && i11 <= i9 - i12) {
            Object zzd = zzgbVar.zzd();
            int i13 = i11 + i12;
            zzgbVar.zzg(zzd, bArr, i12, i13, zzdpVar);
            zzgbVar.zze(zzd);
            zzdpVar.zzc = zzd;
            return i13;
        }
        throw zzew.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzgb<?> zzgbVar, int i8, byte[] bArr, int i9, int i10, zzeu<?> zzeuVar, zzdp zzdpVar) throws IOException {
        int zzd = zzd(zzgbVar, bArr, i9, i10, zzdpVar);
        zzeuVar.add(zzdpVar.zzc);
        while (zzd < i10) {
            int zzj = zzj(bArr, zzd, zzdpVar);
            if (i8 != zzdpVar.zza) {
                break;
            }
            zzd = zzd(zzgbVar, bArr, zzj, i10, zzdpVar);
            zzeuVar.add(zzdpVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i8, zzeu<?> zzeuVar, zzdp zzdpVar) throws IOException {
        zzer zzerVar = (zzer) zzeuVar;
        int zzj = zzj(bArr, i8, zzdpVar);
        int i9 = zzdpVar.zza + zzj;
        while (zzj < i9) {
            zzj = zzj(bArr, zzj, zzdpVar);
            zzerVar.zze(zzdpVar.zza);
        }
        if (zzj == i9) {
            return zzj;
        }
        throw zzew.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i8, zzdp zzdpVar) throws zzew {
        int zzj = zzj(bArr, i8, zzdpVar);
        int i9 = zzdpVar.zza;
        if (i9 >= 0) {
            if (i9 == 0) {
                zzdpVar.zzc = "";
                return zzj;
            }
            zzdpVar.zzc = new String(bArr, zzj, i9, zzev.zza);
            return zzj + i9;
        }
        throw zzew.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i8, zzdp zzdpVar) throws zzew {
        int zzj = zzj(bArr, i8, zzdpVar);
        int i9 = zzdpVar.zza;
        if (i9 >= 0) {
            if (i9 == 0) {
                zzdpVar.zzc = "";
                return zzj;
            }
            zzdpVar.zzc = zzhd.zzb(bArr, zzj, i9);
            return zzj + i9;
        }
        throw zzew.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i8, byte[] bArr, int i9, int i10, zzgq zzgqVar, zzdp zzdpVar) throws zzew {
        if ((i8 >>> 3) != 0) {
            int i11 = i8 & 7;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 == 5) {
                                zzgqVar.zzf(i8, Integer.valueOf(zzb(bArr, i9)));
                                return i9 + 4;
                            }
                            throw zzew.zza();
                        }
                        int i12 = (i8 & (-8)) | 4;
                        zzgq zzc = zzgq.zzc();
                        int i13 = 0;
                        while (true) {
                            if (i9 >= i10) {
                                break;
                            }
                            int zzj = zzj(bArr, i9, zzdpVar);
                            int i14 = zzdpVar.zza;
                            if (i14 == i12) {
                                i13 = i14;
                                i9 = zzj;
                                break;
                            }
                            i13 = i14;
                            i9 = zzi(i14, bArr, zzj, i10, zzc, zzdpVar);
                        }
                        if (i9 <= i10 && i13 == i12) {
                            zzgqVar.zzf(i8, zzc);
                            return i9;
                        }
                        throw zzew.zzd();
                    }
                    int zzj2 = zzj(bArr, i9, zzdpVar);
                    int i15 = zzdpVar.zza;
                    if (i15 >= 0) {
                        if (i15 <= bArr.length - zzj2) {
                            if (i15 == 0) {
                                zzgqVar.zzf(i8, zzeb.zzb);
                            } else {
                                zzgqVar.zzf(i8, zzeb.zzk(bArr, zzj2, i15));
                            }
                            return zzj2 + i15;
                        }
                        throw zzew.zzf();
                    }
                    throw zzew.zzc();
                }
                zzgqVar.zzf(i8, Long.valueOf(zzn(bArr, i9)));
                return i9 + 8;
            }
            int zzm = zzm(bArr, i9, zzdpVar);
            zzgqVar.zzf(i8, Long.valueOf(zzdpVar.zzb));
            return zzm;
        }
        throw zzew.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i8, zzdp zzdpVar) {
        int i9 = i8 + 1;
        byte b8 = bArr[i8];
        if (b8 >= 0) {
            zzdpVar.zza = b8;
            return i9;
        }
        return zzk(b8, bArr, i9, zzdpVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i8, byte[] bArr, int i9, zzdp zzdpVar) {
        int i10 = i8 & 127;
        int i11 = i9 + 1;
        byte b8 = bArr[i9];
        if (b8 >= 0) {
            zzdpVar.zza = i10 | (b8 << 7);
            return i11;
        }
        int i12 = i10 | ((b8 & Byte.MAX_VALUE) << 7);
        int i13 = i11 + 1;
        byte b9 = bArr[i11];
        if (b9 >= 0) {
            zzdpVar.zza = i12 | (b9 << 14);
            return i13;
        }
        int i14 = i12 | ((b9 & Byte.MAX_VALUE) << 14);
        int i15 = i13 + 1;
        byte b10 = bArr[i13];
        if (b10 >= 0) {
            zzdpVar.zza = i14 | (b10 << 21);
            return i15;
        }
        int i16 = i14 | ((b10 & Byte.MAX_VALUE) << 21);
        int i17 = i15 + 1;
        byte b11 = bArr[i15];
        if (b11 >= 0) {
            zzdpVar.zza = i16 | (b11 << 28);
            return i17;
        }
        int i18 = i16 | ((b11 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (bArr[i17] < 0) {
                i17 = i19;
            } else {
                zzdpVar.zza = i18;
                return i19;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i8, byte[] bArr, int i9, int i10, zzeu<?> zzeuVar, zzdp zzdpVar) {
        zzer zzerVar = (zzer) zzeuVar;
        int zzj = zzj(bArr, i9, zzdpVar);
        zzerVar.zze(zzdpVar.zza);
        while (zzj < i10) {
            int zzj2 = zzj(bArr, zzj, zzdpVar);
            if (i8 != zzdpVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzdpVar);
            zzerVar.zze(zzdpVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i8, zzdp zzdpVar) {
        byte b8;
        int i9 = i8 + 1;
        long j8 = bArr[i8];
        if (j8 < 0) {
            int i10 = i9 + 1;
            byte b9 = bArr[i9];
            long j9 = (j8 & 127) | ((b9 & Byte.MAX_VALUE) << 7);
            int i11 = 7;
            while (b9 < 0) {
                int i12 = i10 + 1;
                i11 += 7;
                j9 |= (b8 & Byte.MAX_VALUE) << i11;
                b9 = bArr[i10];
                i10 = i12;
            }
            zzdpVar.zzb = j9;
            return i10;
        }
        zzdpVar.zzb = j8;
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i8) {
        return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
    }
}
