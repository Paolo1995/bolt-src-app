package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzmv extends zzmw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmv(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final double zza(Object obj, long j8) {
        return Double.longBitsToDouble(zzk(obj, j8));
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final float zzb(Object obj, long j8) {
        return Float.intBitsToFloat(zzj(obj, j8));
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final void zzc(Object obj, long j8, boolean z7) {
        if (zzmx.zzb) {
            zzmx.zzD(obj, j8, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzmx.zzE(obj, j8, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final void zzd(Object obj, long j8, byte b8) {
        if (zzmx.zzb) {
            zzmx.zzD(obj, j8, b8);
        } else {
            zzmx.zzE(obj, j8, b8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final void zze(Object obj, long j8, double d8) {
        zzo(obj, j8, Double.doubleToLongBits(d8));
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final void zzf(Object obj, long j8, float f8) {
        zzn(obj, j8, Float.floatToIntBits(f8));
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zzg(Object obj, long j8) {
        if (zzmx.zzb) {
            return zzmx.zzt(obj, j8);
        }
        return zzmx.zzu(obj, j8);
    }
}
