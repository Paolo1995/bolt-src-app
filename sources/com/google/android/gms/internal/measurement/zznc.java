package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zznc {
    private static final zzmz zza;

    static {
        if (zzmx.zzx() && zzmx.zzy()) {
            int i8 = zzip.zza;
        }
        zza = new zzna();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i8, int i9) {
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
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fe, code lost:
        return r9 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzb(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zznc.zzb(java.lang.CharSequence, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i8 = 0;
        int i9 = 0;
        while (i9 < length && charSequence.charAt(i9) < 128) {
            i9++;
        }
        int i10 = length;
        while (true) {
            if (i9 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i9);
            if (charAt < 2048) {
                i10 += (127 - charAt) >>> 31;
                i9++;
            } else {
                int length2 = charSequence.length();
                while (i9 < length2) {
                    char charAt2 = charSequence.charAt(i9);
                    if (charAt2 < 2048) {
                        i8 += (127 - charAt2) >>> 31;
                    } else {
                        i8 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i9) >= 65536) {
                                i9++;
                            } else {
                                throw new zznb(i9, length2);
                            }
                        }
                    }
                    i9++;
                }
                i10 += i8;
            }
        }
        if (i10 >= length) {
            return i10;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i10 + 4294967296L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(byte[] bArr, int i8, int i9) throws zzko {
        int length = bArr.length;
        if ((i8 | i9 | ((length - i8) - i9)) >= 0) {
            int i10 = i8 + i9;
            char[] cArr = new char[i9];
            int i11 = 0;
            while (i8 < i10) {
                byte b8 = bArr[i8];
                if (!zzmy.zzd(b8)) {
                    break;
                }
                i8++;
                cArr[i11] = (char) b8;
                i11++;
            }
            while (i8 < i10) {
                int i12 = i8 + 1;
                byte b9 = bArr[i8];
                if (zzmy.zzd(b9)) {
                    int i13 = i11 + 1;
                    cArr[i11] = (char) b9;
                    i8 = i12;
                    while (true) {
                        i11 = i13;
                        if (i8 < i10) {
                            byte b10 = bArr[i8];
                            if (!zzmy.zzd(b10)) {
                                break;
                            }
                            i8++;
                            i13 = i11 + 1;
                            cArr[i11] = (char) b10;
                        }
                    }
                } else if (b9 < -32) {
                    if (i12 < i10) {
                        zzmy.zzc(b9, bArr[i12], cArr, i11);
                        i8 = i12 + 1;
                        i11++;
                    } else {
                        throw zzko.zzc();
                    }
                } else if (b9 < -16) {
                    if (i12 < i10 - 1) {
                        int i14 = i12 + 1;
                        zzmy.zzb(b9, bArr[i12], bArr[i14], cArr, i11);
                        i8 = i14 + 1;
                        i11++;
                    } else {
                        throw zzko.zzc();
                    }
                } else if (i12 < i10 - 2) {
                    int i15 = i12 + 1;
                    int i16 = i15 + 1;
                    zzmy.zza(b9, bArr[i12], bArr[i15], bArr[i16], cArr, i11);
                    i11 += 2;
                    i8 = i16 + 1;
                } else {
                    throw zzko.zzc();
                }
            }
            return new String(cArr, 0, i11);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zze(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzf(byte[] bArr, int i8, int i9) {
        return zza.zzb(bArr, i8, i9);
    }
}
