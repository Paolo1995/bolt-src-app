package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzgn implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgn(zzgw zzgwVar, zzq zzqVar) {
        this.zzb = zzgwVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf zzlfVar;
        zzlf zzlfVar2;
        zzlfVar = this.zzb.zza;
        zzlfVar.zzA();
        zzlfVar2 = this.zzb.zza;
        zzq zzqVar = this.zza;
        zzlfVar2.zzaz().zzg();
        zzlfVar2.zzB();
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzlfVar2.zzd(zzqVar);
    }
}
