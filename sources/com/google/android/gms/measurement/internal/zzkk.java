package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzkk {
    final /* synthetic */ zzko zza;
    private zzkj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkk(zzko zzkoVar) {
        this.zza = zzkoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j8) {
        Handler handler;
        this.zzb = new zzkj(this, this.zza.zzs.zzav().currentTimeMillis(), j8);
        handler = this.zza.zzd;
        handler.postDelayed(this.zzb, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        Handler handler;
        this.zza.zzg();
        zzkj zzkjVar = this.zzb;
        if (zzkjVar != null) {
            handler = this.zza.zzd;
            handler.removeCallbacks(zzkjVar);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
