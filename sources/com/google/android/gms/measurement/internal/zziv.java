package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zziv implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zziy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziv(zziy zziyVar, long j8) {
        this.zzb = zziyVar;
        this.zza = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
