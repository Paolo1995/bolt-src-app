package com.google.android.gms.internal.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzhd {
    private static final zzhb zza;

    static {
        if (zzgz.zzu() && zzgz.zzv()) {
            int i8 = zzdo.zza;
        }
        zza = new zzhc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(byte[] bArr, int i8, int i9) {
        byte b8 = bArr[i8 - 1];
        int i10 = i9 - i8;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    byte b9 = bArr[i8];
                    byte b10 = bArr[i8 + 1];
                    if (b8 <= -12 && b9 <= -65 && b10 <= -65) {
                        return ((b9 << 8) ^ b8) ^ (b10 << 16);
                    }
                } else {
                    throw new AssertionError();
                }
            } else {
                byte b11 = bArr[i8];
                if (b8 <= -12 && b11 <= -65) {
                    return b8 ^ (b11 << 8);
                }
            }
        } else if (b8 <= -12) {
            return b8;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(byte[] bArr, int i8, int i9) throws zzew {
        int length = bArr.length;
        if ((i8 | i9 | ((length - i8) - i9)) >= 0) {
            int i10 = i8 + i9;
            char[] cArr = new char[i9];
            int i11 = 0;
            while (i8 < i10) {
                byte b8 = bArr[i8];
                if (!zzha.zzd(b8)) {
                    break;
                }
                i8++;
                cArr[i11] = (char) b8;
                i11++;
            }
            while (i8 < i10) {
                int i12 = i8 + 1;
                byte b9 = bArr[i8];
                if (zzha.zzd(b9)) {
                    int i13 = i11 + 1;
                    cArr[i11] = (char) b9;
                    i8 = i12;
                    while (true) {
                        i11 = i13;
                        if (i8 < i10) {
                            byte b10 = bArr[i8];
                            if (!zzha.zzd(b10)) {
                                break;
                            }
                            i8++;
                            i13 = i11 + 1;
                            cArr[i11] = (char) b10;
                        }
                    }
                } else if (b9 < -32) {
                    if (i12 < i10) {
                        zzha.zzb(b9, bArr[i12], cArr, i11);
                        i8 = i12 + 1;
                        i11++;
                    } else {
                        throw zzew.zzb();
                    }
                } else if (b9 < -16) {
                    if (i12 < i10 - 1) {
                        int i14 = i12 + 1;
                        zzha.zzc(b9, bArr[i12], bArr[i14], cArr, i11);
                        i8 = i14 + 1;
                        i11++;
                    } else {
                        throw zzew.zzb();
                    }
                } else if (i12 < i10 - 2) {
                    int i15 = i12 + 1;
                    int i16 = i15 + 1;
                    zzha.zza(b9, bArr[i12], bArr[i15], bArr[i16], cArr, i11);
                    i11 += 2;
                    i8 = i16 + 1;
                } else {
                    throw zzew.zzb();
                }
            }
            return new String(cArr, 0, i11);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    public static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzd(byte[] bArr, int i8, int i9) {
        return zza.zzb(bArr, i8, i9);
    }
}
