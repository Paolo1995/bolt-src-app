package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzgd implements Runnable {
    final /* synthetic */ zzhh zza;
    final /* synthetic */ zzge zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgd(zzge zzgeVar, zzhh zzhhVar) {
        this.zzb = zzgeVar;
        this.zza = zzhhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzge.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
