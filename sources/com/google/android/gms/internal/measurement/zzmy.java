package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzmy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zza(byte b8, byte b9, byte b10, byte b11, char[] cArr, int i8) {
        if (!zze(b9) && (((b8 << 28) + (b9 + 112)) >> 30) == 0 && !zze(b10) && !zze(b11)) {
            int i9 = ((b8 & 7) << 18) | ((b9 & 63) << 12) | ((b10 & 63) << 6) | (b11 & 63);
            cArr[i8] = (char) ((i9 >>> 10) + 55232);
            cArr[i8 + 1] = (char) ((i9 & 1023) + 56320);
            return;
        }
        throw zzko.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzb(byte b8, byte b9, byte b10, char[] cArr, int i8) {
        if (!zze(b9)) {
            if (b8 == -32) {
                if (b9 >= -96) {
                    b8 = -32;
                }
            }
            if (b8 == -19) {
                if (b9 < -96) {
                    b8 = -19;
                }
            }
            if (!zze(b10)) {
                cArr[i8] = (char) (((b8 & 15) << 12) | ((b9 & 63) << 6) | (b10 & 63));
                return;
            }
        }
        throw zzko.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(byte b8, byte b9, char[] cArr, int i8) {
        if (b8 >= -62 && !zze(b9)) {
            cArr[i8] = (char) (((b8 & 31) << 6) | (b9 & 63));
            return;
        }
        throw zzko.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzd(byte b8) {
        return b8 >= 0;
    }

    private static boolean zze(byte b8) {
        return b8 > -65;
    }
}
