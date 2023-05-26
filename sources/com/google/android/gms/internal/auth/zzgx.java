package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzgx extends zzgy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgx(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final double zza(Object obj, long j8) {
        return Double.longBitsToDouble(zzj(obj, j8));
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final float zzb(Object obj, long j8) {
        return Float.intBitsToFloat(zzi(obj, j8));
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final void zzc(Object obj, long j8, boolean z7) {
        if (zzgz.zza) {
            zzgz.zzi(obj, j8, z7);
        } else {
            zzgz.zzj(obj, j8, z7);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final void zzd(Object obj, long j8, double d8) {
        zzn(obj, j8, Double.doubleToLongBits(d8));
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final void zze(Object obj, long j8, float f8) {
        zzm(obj, j8, Float.floatToIntBits(f8));
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final boolean zzf(Object obj, long j8) {
        if (zzgz.zza) {
            return zzgz.zzq(obj, j8);
        }
        return zzgz.zzr(obj, j8);
    }
}
