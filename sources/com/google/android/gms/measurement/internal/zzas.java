package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
final class zzas {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final Long zzh;
    final Long zzi;
    final Long zzj;
    final Boolean zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(String str, String str2, long j8, long j9, long j10, long j11, long j12, Long l8, Long l9, Long l10, Boolean bool) {
        boolean z7;
        boolean z8;
        boolean z9;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7);
        if (j9 >= 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        Preconditions.checkArgument(z8);
        if (j10 >= 0) {
            z9 = true;
        } else {
            z9 = false;
        }
        Preconditions.checkArgument(z9);
        Preconditions.checkArgument(j12 >= 0);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j8;
        this.zzd = j9;
        this.zze = j10;
        this.zzf = j11;
        this.zzg = j12;
        this.zzh = l8;
        this.zzi = l9;
        this.zzj = l10;
        this.zzk = bool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzas zza(Long l8, Long l9, Boolean bool) {
        Boolean bool2;
        if (bool != null && !bool.booleanValue()) {
            bool2 = null;
        } else {
            bool2 = bool;
        }
        return new zzas(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l8, l9, bool2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzas zzb(long j8, long j9) {
        return new zzas(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j8, Long.valueOf(j9), this.zzi, this.zzj, this.zzk);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzas zzc(long j8) {
        return new zzas(this.zza, this.zzb, this.zzc, this.zzd, this.zze, j8, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }
}
