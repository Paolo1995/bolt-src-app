package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(@NonNull byte[] bArr, int i8, int i9, int i10) {
        int i11 = (i9 & (-4)) + i8;
        while (i8 < i11) {
            int i12 = ((bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | (bArr[i8 + 3] << 24)) * (-862048943);
            int i13 = i10 ^ (((i12 << 15) | (i12 >>> 17)) * 461845907);
            i10 = (((i13 >>> 19) | (i13 << 13)) * 5) - 430675100;
            i8 += 4;
        }
        int i14 = i9 & 3;
        int i15 = 0;
        if (i14 != 1) {
            if (i14 != 2) {
                if (i14 == 3) {
                    i15 = (bArr[i11 + 2] & 255) << 16;
                }
                int i16 = i10 ^ i9;
                int i17 = (i16 ^ (i16 >>> 16)) * (-2048144789);
                int i18 = (i17 ^ (i17 >>> 13)) * (-1028477387);
                return i18 ^ (i18 >>> 16);
            }
            i15 |= (bArr[i11 + 1] & 255) << 8;
        }
        int i19 = ((bArr[i11] & 255) | i15) * (-862048943);
        i10 ^= ((i19 >>> 17) | (i19 << 15)) * 461845907;
        int i162 = i10 ^ i9;
        int i172 = (i162 ^ (i162 >>> 16)) * (-2048144789);
        int i182 = (i172 ^ (i172 >>> 13)) * (-1028477387);
        return i182 ^ (i182 >>> 16);
    }
}
