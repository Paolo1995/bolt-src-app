package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzir {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i8, zziq zziqVar) throws zzko {
        int zzj = zzj(bArr, i8, zziqVar);
        int i9 = zziqVar.zza;
        if (i9 >= 0) {
            if (i9 <= bArr.length - zzj) {
                if (i9 == 0) {
                    zziqVar.zzc = zzjd.zzb;
                    return zzj;
                }
                zziqVar.zzc = zzjd.zzl(bArr, zzj, i9);
                return zzj + i9;
            }
            throw zzko.zzf();
        }
        throw zzko.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i8) {
        return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzlw zzlwVar, byte[] bArr, int i8, int i9, int i10, zziq zziqVar) throws IOException {
        zzlo zzloVar = (zzlo) zzlwVar;
        Object zze = zzloVar.zze();
        int zzc = zzloVar.zzc(zze, bArr, i8, i9, i10, zziqVar);
        zzloVar.zzf(zze);
        zziqVar.zzc = zze;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzlw zzlwVar, byte[] bArr, int i8, int i9, zziq zziqVar) throws IOException {
        int i10 = i8 + 1;
        int i11 = bArr[i8];
        if (i11 < 0) {
            i10 = zzk(i11, bArr, i10, zziqVar);
            i11 = zziqVar.zza;
        }
        int i12 = i10;
        if (i11 >= 0 && i11 <= i9 - i12) {
            Object zze = zzlwVar.zze();
            int i13 = i11 + i12;
            zzlwVar.zzh(zze, bArr, i12, i13, zziqVar);
            zzlwVar.zzf(zze);
            zziqVar.zzc = zze;
            return i13;
        }
        throw zzko.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzlw zzlwVar, int i8, byte[] bArr, int i9, int i10, zzkl zzklVar, zziq zziqVar) throws IOException {
        int zzd = zzd(zzlwVar, bArr, i9, i10, zziqVar);
        zzklVar.add(zziqVar.zzc);
        while (zzd < i10) {
            int zzj = zzj(bArr, zzd, zziqVar);
            if (i8 != zziqVar.zza) {
                break;
            }
            zzd = zzd(zzlwVar, bArr, zzj, i10, zziqVar);
            zzklVar.add(zziqVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i8, zzkl zzklVar, zziq zziqVar) throws IOException {
        zzkf zzkfVar = (zzkf) zzklVar;
        int zzj = zzj(bArr, i8, zziqVar);
        int i9 = zziqVar.zza + zzj;
        while (zzj < i9) {
            zzj = zzj(bArr, zzj, zziqVar);
            zzkfVar.zzh(zziqVar.zza);
        }
        if (zzj == i9) {
            return zzj;
        }
        throw zzko.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i8, zziq zziqVar) throws zzko {
        int zzj = zzj(bArr, i8, zziqVar);
        int i9 = zziqVar.zza;
        if (i9 >= 0) {
            if (i9 == 0) {
                zziqVar.zzc = "";
                return zzj;
            }
            zziqVar.zzc = new String(bArr, zzj, i9, zzkm.zzb);
            return zzj + i9;
        }
        throw zzko.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i8, zziq zziqVar) throws zzko {
        int zzj = zzj(bArr, i8, zziqVar);
        int i9 = zziqVar.zza;
        if (i9 >= 0) {
            if (i9 == 0) {
                zziqVar.zzc = "";
                return zzj;
            }
            zziqVar.zzc = zznc.zzd(bArr, zzj, i9);
            return zzj + i9;
        }
        throw zzko.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i8, byte[] bArr, int i9, int i10, zzmo zzmoVar, zziq zziqVar) throws zzko {
        if ((i8 >>> 3) != 0) {
            int i11 = i8 & 7;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 == 5) {
                                zzmoVar.zzh(i8, Integer.valueOf(zzb(bArr, i9)));
                                return i9 + 4;
                            }
                            throw zzko.zzb();
                        }
                        int i12 = (i8 & (-8)) | 4;
                        zzmo zze = zzmo.zze();
                        int i13 = 0;
                        while (true) {
                            if (i9 >= i10) {
                                break;
                            }
                            int zzj = zzj(bArr, i9, zziqVar);
                            int i14 = zziqVar.zza;
                            if (i14 == i12) {
                                i13 = i14;
                                i9 = zzj;
                                break;
                            }
                            i13 = i14;
                            i9 = zzi(i14, bArr, zzj, i10, zze, zziqVar);
                        }
                        if (i9 <= i10 && i13 == i12) {
                            zzmoVar.zzh(i8, zze);
                            return i9;
                        }
                        throw zzko.zze();
                    }
                    int zzj2 = zzj(bArr, i9, zziqVar);
                    int i15 = zziqVar.zza;
                    if (i15 >= 0) {
                        if (i15 <= bArr.length - zzj2) {
                            if (i15 == 0) {
                                zzmoVar.zzh(i8, zzjd.zzb);
                            } else {
                                zzmoVar.zzh(i8, zzjd.zzl(bArr, zzj2, i15));
                            }
                            return zzj2 + i15;
                        }
                        throw zzko.zzf();
                    }
                    throw zzko.zzd();
                }
                zzmoVar.zzh(i8, Long.valueOf(zzn(bArr, i9)));
                return i9 + 8;
            }
            int zzm = zzm(bArr, i9, zziqVar);
            zzmoVar.zzh(i8, Long.valueOf(zziqVar.zzb));
            return zzm;
        }
        throw zzko.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i8, zziq zziqVar) {
        int i9 = i8 + 1;
        byte b8 = bArr[i8];
        if (b8 >= 0) {
            zziqVar.zza = b8;
            return i9;
        }
        return zzk(b8, bArr, i9, zziqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i8, byte[] bArr, int i9, zziq zziqVar) {
        int i10 = i8 & 127;
        int i11 = i9 + 1;
        byte b8 = bArr[i9];
        if (b8 >= 0) {
            zziqVar.zza = i10 | (b8 << 7);
            return i11;
        }
        int i12 = i10 | ((b8 & Byte.MAX_VALUE) << 7);
        int i13 = i11 + 1;
        byte b9 = bArr[i11];
        if (b9 >= 0) {
            zziqVar.zza = i12 | (b9 << 14);
            return i13;
        }
        int i14 = i12 | ((b9 & Byte.MAX_VALUE) << 14);
        int i15 = i13 + 1;
        byte b10 = bArr[i13];
        if (b10 >= 0) {
            zziqVar.zza = i14 | (b10 << 21);
            return i15;
        }
        int i16 = i14 | ((b10 & Byte.MAX_VALUE) << 21);
        int i17 = i15 + 1;
        byte b11 = bArr[i15];
        if (b11 >= 0) {
            zziqVar.zza = i16 | (b11 << 28);
            return i17;
        }
        int i18 = i16 | ((b11 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (bArr[i17] < 0) {
                i17 = i19;
            } else {
                zziqVar.zza = i18;
                return i19;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i8, byte[] bArr, int i9, int i10, zzkl zzklVar, zziq zziqVar) {
        zzkf zzkfVar = (zzkf) zzklVar;
        int zzj = zzj(bArr, i9, zziqVar);
        zzkfVar.zzh(zziqVar.zza);
        while (zzj < i10) {
            int zzj2 = zzj(bArr, zzj, zziqVar);
            if (i8 != zziqVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zziqVar);
            zzkfVar.zzh(zziqVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i8, zziq zziqVar) {
        byte b8;
        int i9 = i8 + 1;
        long j8 = bArr[i8];
        if (j8 >= 0) {
            zziqVar.zzb = j8;
            return i9;
        }
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
        zziqVar.zzb = j9;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i8) {
        return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
    }
}
