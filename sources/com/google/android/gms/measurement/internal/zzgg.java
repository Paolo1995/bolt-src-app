package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzgg implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgw zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgg(zzgw zzgwVar, zzac zzacVar, zzq zzqVar) {
        this.zzc = zzgwVar;
        this.zza = zzacVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf zzlfVar;
        zzlf zzlfVar2;
        zzlf zzlfVar3;
        zzlfVar = this.zzc.zza;
        zzlfVar.zzA();
        if (this.zza.zzc.zza() == null) {
            zzlfVar3 = this.zzc.zza;
            zzlfVar3.zzO(this.zza, this.zzb);
            return;
        }
        zzlfVar2 = this.zzc.zza;
        zzlfVar2.zzU(this.zza, this.zzb);
    }
}
