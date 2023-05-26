package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzit implements Runnable {
    final /* synthetic */ zziq zza;
    final /* synthetic */ zziq zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zziy zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzit(zziy zziyVar, zziq zziqVar, zziq zziqVar2, long j8, boolean z7) {
        this.zze = zziyVar;
        this.zza = zziqVar;
        this.zzb = zziqVar2;
        this.zzc = j8;
        this.zzd = z7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzB(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
