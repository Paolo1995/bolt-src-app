package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzja implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzli zzc;
    final /* synthetic */ zzjy zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzja(zzjy zzjyVar, zzq zzqVar, boolean z7, zzli zzliVar) {
        this.zzd = zzjyVar;
        this.zza = zzqVar;
        this.zzb = z7;
        this.zzc = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzek zzekVar;
        zzli zzliVar;
        zzjy zzjyVar = this.zzd;
        zzekVar = zzjyVar.zzb;
        if (zzekVar == null) {
            zzjyVar.zzs.zzay().zzd().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjy zzjyVar2 = this.zzd;
        if (this.zzb) {
            zzliVar = null;
        } else {
            zzliVar = this.zzc;
        }
        zzjyVar2.zzD(zzekVar, zzliVar, this.zza);
        this.zzd.zzQ();
    }
}
