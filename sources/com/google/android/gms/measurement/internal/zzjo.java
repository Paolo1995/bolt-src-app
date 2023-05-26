package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzjo implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzac zzc;
    final /* synthetic */ zzac zzd;
    final /* synthetic */ zzjy zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(zzjy zzjyVar, boolean z7, zzq zzqVar, boolean z8, zzac zzacVar, zzac zzacVar2) {
        this.zze = zzjyVar;
        this.zza = zzqVar;
        this.zzb = z8;
        this.zzc = zzacVar;
        this.zzd = zzacVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzek zzekVar;
        zzac zzacVar;
        zzjy zzjyVar = this.zze;
        zzekVar = zzjyVar.zzb;
        if (zzekVar == null) {
            zzjyVar.zzs.zzay().zzd().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjy zzjyVar2 = this.zze;
        if (this.zzb) {
            zzacVar = null;
        } else {
            zzacVar = this.zzc;
        }
        zzjyVar2.zzD(zzekVar, zzacVar, this.zza);
        this.zze.zzQ();
    }
}
