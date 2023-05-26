package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzgh implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzgw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(zzgw zzgwVar, zzac zzacVar) {
        this.zzb = zzgwVar;
        this.zza = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf zzlfVar;
        zzlf zzlfVar2;
        zzlf zzlfVar3;
        zzlfVar = this.zzb.zza;
        zzlfVar.zzA();
        if (this.zza.zzc.zza() == null) {
            zzlfVar3 = this.zzb.zza;
            zzlfVar3.zzN(this.zza);
            return;
        }
        zzlfVar2 = this.zzb.zza;
        zzlfVar2.zzT(this.zza);
    }
}
