package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpf;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzgv implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzgw zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgv(zzgw zzgwVar, String str, String str2, String str3, long j8) {
        this.zze = zzgwVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf zzlfVar;
        zzlf zzlfVar2;
        zzlf zzlfVar3;
        zzlf zzlfVar4;
        zzlf zzlfVar5;
        zzpf.zzc();
        zzlfVar = this.zze.zza;
        if (zzlfVar.zzg().zzs(null, zzeh.zzak)) {
            String str = this.zza;
            if (str == null) {
                zzlfVar5 = this.zze.zza;
                zzlfVar5.zzR(this.zzb, null);
                return;
            }
            zziq zziqVar = new zziq(this.zzc, str, this.zzd);
            zzlfVar4 = this.zze.zza;
            zzlfVar4.zzR(this.zzb, zziqVar);
            return;
        }
        String str2 = this.zza;
        if (str2 == null) {
            zzlfVar3 = this.zze.zza;
            zzlfVar3.zzq().zzs().zzy(this.zzb, null);
            return;
        }
        zziq zziqVar2 = new zziq(this.zzc, str2, this.zzd);
        zzlfVar2 = this.zze.zza;
        zzlfVar2.zzq().zzs().zzy(this.zzb, zziqVar2);
    }
}
