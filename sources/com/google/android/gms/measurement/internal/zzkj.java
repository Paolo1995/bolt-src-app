package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzkj implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzkk zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkj(zzkk zzkkVar, long j8, long j9) {
        this.zzc = zzkkVar;
        this.zza = j8;
        this.zzb = j9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzki
            @Override // java.lang.Runnable
            public final void run() {
                zzkj zzkjVar = zzkj.this;
                zzkk zzkkVar = zzkjVar.zzc;
                long j8 = zzkjVar.zza;
                long j9 = zzkjVar.zzb;
                zzkkVar.zza.zzg();
                zzkkVar.zza.zzs.zzay().zzc().zza("Application going to the background");
                zzkkVar.zza.zzs.zzm().zzl.zza(true);
                Bundle bundle = new Bundle();
                if (!zzkkVar.zza.zzs.zzf().zzu()) {
                    zzkkVar.zza.zzb.zzb(j9);
                    zzkkVar.zza.zzb.zzd(false, false, j9);
                }
                zzkkVar.zza.zzs.zzq().zzH("auto", "_ab", j8, bundle);
            }
        });
    }
}
