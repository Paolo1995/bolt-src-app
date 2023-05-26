package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zziw implements Runnable {
    final /* synthetic */ zziq zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zziy zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziw(zziy zziyVar, zziq zziqVar, long j8) {
        this.zzc = zziyVar;
        this.zza = zziqVar;
        this.zzb = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzC(this.zza, false, this.zzb);
        zziy zziyVar = this.zzc;
        zziyVar.zza = null;
        zziyVar.zzs.zzt().zzG(null);
    }
}
