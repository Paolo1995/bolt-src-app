package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes.dex */
final class zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i8) {
        int[] iArr = {1, 2, 3};
        for (int i9 = 0; i9 < 3; i9++) {
            int i10 = iArr[i9];
            int i11 = i10 - 1;
            if (i10 != 0) {
                if (i11 == i8) {
                    return i10;
                }
            } else {
                throw null;
            }
        }
        return 1;
    }
}
