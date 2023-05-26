package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzhc extends zzhb {
    @Override // com.google.android.gms.internal.auth.zzhb
    final int zza(int i8, byte[] bArr, int i9, int i10) {
        while (i9 < i10 && bArr[i9] >= 0) {
            i9++;
        }
        if (i9 >= i10) {
            return 0;
        }
        while (i9 < i10) {
            int i11 = i9 + 1;
            byte b8 = bArr[i9];
            if (b8 < 0) {
                if (b8 < -32) {
                    if (i11 < i10) {
                        if (b8 >= -62) {
                            i9 = i11 + 1;
                            if (bArr[i11] > -65) {
                            }
                        }
                        return -1;
                    }
                    return b8;
                }
                if (b8 < -16) {
                    if (i11 >= i10 - 1) {
                        return zzhd.zza(bArr, i11, i10);
                    }
                    int i12 = i11 + 1;
                    byte b9 = bArr[i11];
                    if (b9 <= -65 && ((b8 != -32 || b9 >= -96) && (b8 != -19 || b9 < -96))) {
                        i9 = i12 + 1;
                        if (bArr[i12] > -65) {
                        }
                    }
                } else if (i11 >= i10 - 2) {
                    return zzhd.zza(bArr, i11, i10);
                } else {
                    int i13 = i11 + 1;
                    byte b10 = bArr[i11];
                    if (b10 <= -65 && (((b8 << 28) + (b10 + 112)) >> 30) == 0) {
                        int i14 = i13 + 1;
                        if (bArr[i13] <= -65) {
                            i11 = i14 + 1;
                            if (bArr[i14] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i9 = i11;
        }
        return 0;
    }
}
