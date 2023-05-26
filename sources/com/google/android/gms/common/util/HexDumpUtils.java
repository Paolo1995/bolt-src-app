package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes.dex */
public final class HexDumpUtils {
    @KeepForSdk
    public static String dump(@NonNull byte[] bArr, int i8, int i9, boolean z7) {
        int length;
        int i10;
        if (bArr != null && (length = bArr.length) != 0 && i8 >= 0 && i9 > 0 && i8 + i9 <= length) {
            if (z7) {
                i10 = 75;
            } else {
                i10 = 57;
            }
            StringBuilder sb = new StringBuilder(i10 * ((i9 + 15) / 16));
            int i11 = i9;
            int i12 = 0;
            int i13 = 0;
            while (i11 > 0) {
                if (i12 == 0) {
                    if (i9 < 65536) {
                        sb.append(String.format("%04X:", Integer.valueOf(i8)));
                    } else {
                        sb.append(String.format("%08X:", Integer.valueOf(i8)));
                    }
                    i13 = i8;
                } else if (i12 == 8) {
                    sb.append(" -");
                }
                sb.append(String.format(" %02X", Integer.valueOf(bArr[i8] & 255)));
                i11--;
                i12++;
                if (z7 && (i12 == 16 || i11 == 0)) {
                    int i14 = 16 - i12;
                    if (i14 > 0) {
                        for (int i15 = 0; i15 < i14; i15++) {
                            sb.append("   ");
                        }
                    }
                    if (i14 >= 8) {
                        sb.append("  ");
                    }
                    sb.append("  ");
                    for (int i16 = 0; i16 < i12; i16++) {
                        char c8 = (char) bArr[i13 + i16];
                        if (c8 < ' ' || c8 > '~') {
                            c8 = '.';
                        }
                        sb.append(c8);
                    }
                }
                if (i12 == 16 || i11 == 0) {
                    sb.append('\n');
                    i12 = 0;
                }
                i8++;
            }
            return sb.toString();
        }
        return null;
    }
}
