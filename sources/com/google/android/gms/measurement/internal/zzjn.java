package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzjn implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaw zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzjy zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(zzjy zzjyVar, boolean z7, zzq zzqVar, boolean z8, zzaw zzawVar, String str) {
        this.zze = zzjyVar;
        this.zza = zzqVar;
        this.zzb = z8;
        this.zzc = zzawVar;
        this.zzd = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzek zzekVar;
        zzaw zzawVar;
        zzjy zzjyVar = this.zze;
        zzekVar = zzjyVar.zzb;
        if (zzekVar == null) {
            zzjyVar.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjy zzjyVar2 = this.zze;
        if (this.zzb) {
            zzawVar = null;
        } else {
            zzawVar = this.zzc;
        }
        zzjyVar2.zzD(zzekVar, zzawVar, this.zza);
        this.zze.zzQ();
    }
}
