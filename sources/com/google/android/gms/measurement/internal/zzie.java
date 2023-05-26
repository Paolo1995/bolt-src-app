package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzie implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzai zze;
    final /* synthetic */ zzij zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzie(zzij zzijVar, zzai zzaiVar, int i8, long j8, boolean z7, zzai zzaiVar2) {
        this.zzf = zzijVar;
        this.zza = zzaiVar;
        this.zzb = i8;
        this.zzc = j8;
        this.zzd = z7;
        this.zze = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zzV(this.zza);
        zzij.zzw(this.zzf, this.zza, this.zzb, this.zzc, false, this.zzd);
        zzpi.zzc();
        if (this.zzf.zzs.zzf().zzs(null, zzeh.zzaz)) {
            zzij.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
