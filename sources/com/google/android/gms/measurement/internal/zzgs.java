package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzgs implements Runnable {
    final /* synthetic */ zzli zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgw zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgs(zzgw zzgwVar, zzli zzliVar, zzq zzqVar) {
        this.zzc = zzgwVar;
        this.zza = zzliVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf zzlfVar;
        zzlf zzlfVar2;
        zzlf zzlfVar3;
        zzlfVar = this.zzc.zza;
        zzlfVar.zzA();
        if (this.zza.zza() == null) {
            zzlfVar3 = this.zzc.zza;
            zzlfVar3.zzP(this.zza, this.zzb);
            return;
        }
        zzlfVar2 = this.zzc.zza;
        zzlfVar2.zzW(this.zza, this.zzb);
    }
}
