package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@NullMarked
/* loaded from: classes.dex */
public final class zzs {
    public static int zza(int i8, int i9, String str) {
        String zza;
        if (i8 >= 0 && i8 < i9) {
            return i8;
        }
        if (i8 >= 0) {
            if (i9 < 0) {
                throw new IllegalArgumentException("negative size: " + i9);
            }
            zza = zzy.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i8), Integer.valueOf(i9));
        } else {
            zza = zzy.zza("%s (%s) must not be negative", "index", Integer.valueOf(i8));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i8, int i9, String str) {
        if (i8 >= 0 && i8 <= i9) {
            return i8;
        }
        throw new IndexOutOfBoundsException(zzd(i8, i9, "index"));
    }

    public static void zzc(int i8, int i9, int i10) {
        String zzd;
        if (i8 >= 0 && i9 >= i8 && i9 <= i10) {
            return;
        }
        if (i8 >= 0 && i8 <= i10) {
            if (i9 >= 0 && i9 <= i10) {
                zzd = zzy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i9), Integer.valueOf(i8));
            } else {
                zzd = zzd(i9, i10, "end index");
            }
        } else {
            zzd = zzd(i8, i10, "start index");
        }
        throw new IndexOutOfBoundsException(zzd);
    }

    private static String zzd(int i8, int i9, String str) {
        if (i8 < 0) {
            return zzy.zza("%s (%s) must not be negative", str, Integer.valueOf(i8));
        }
        if (i9 >= 0) {
            return zzy.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i8), Integer.valueOf(i9));
        }
        throw new IllegalArgumentException("negative size: " + i9);
    }
}
