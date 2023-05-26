package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzid implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzai zzf;
    final /* synthetic */ zzij zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzid(zzij zzijVar, zzai zzaiVar, long j8, int i8, long j9, boolean z7, zzai zzaiVar2) {
        this.zzg = zzijVar;
        this.zza = zzaiVar;
        this.zzb = j8;
        this.zzc = i8;
        this.zzd = j9;
        this.zze = z7;
        this.zzf = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzg.zzV(this.zza);
        this.zzg.zzL(this.zzb, false);
        zzij.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzpi.zzc();
        if (this.zzg.zzs.zzf().zzs(null, zzeh.zzaz)) {
            zzij.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
