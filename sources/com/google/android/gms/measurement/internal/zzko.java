package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzko extends zzf {
    protected final zzkn zza;
    protected final zzkm zzb;
    protected final zzkk zzc;
    private Handler zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzko(zzge zzgeVar) {
        super(zzgeVar);
        this.zza = new zzkn(this);
        this.zzb = new zzkm(this);
        this.zzc = new zzkk(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzj(zzko zzkoVar, long j8) {
        zzkoVar.zzg();
        zzkoVar.zzm();
        zzkoVar.zzs.zzay().zzj().zzb("Activity paused, time", Long.valueOf(j8));
        zzkoVar.zzc.zza(j8);
        if (zzkoVar.zzs.zzf().zzu()) {
            zzkoVar.zzb.zzb(j8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzl(zzko zzkoVar, long j8) {
        zzkoVar.zzg();
        zzkoVar.zzm();
        zzkoVar.zzs.zzay().zzj().zzb("Activity resumed, time", Long.valueOf(j8));
        if (zzkoVar.zzs.zzf().zzu() || zzkoVar.zzs.zzm().zzl.zzb()) {
            zzkoVar.zzb.zzc(j8);
        }
        zzkoVar.zzc.zzb();
        zzkn zzknVar = zzkoVar.zza;
        zzknVar.zza.zzg();
        if (!zzknVar.zza.zzs.zzJ()) {
            return;
        }
        zzknVar.zzb(zzknVar.zza.zzs.zzav().currentTimeMillis(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new com.google.android.gms.internal.measurement.zzby(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }
}
