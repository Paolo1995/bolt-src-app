package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzok;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzkm {
    @VisibleForTesting
    protected long zza;
    @VisibleForTesting
    protected long zzb;
    final /* synthetic */ zzko zzc;
    private final zzap zzd;

    public zzkm(zzko zzkoVar) {
        this.zzc = zzkoVar;
        this.zzd = new zzkl(this, zzkoVar.zzs);
        long elapsedRealtime = zzkoVar.zzs.zzav().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zzb();
        this.zza = 0L;
        this.zzb = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j8) {
        this.zzd.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(long j8) {
        this.zzc.zzg();
        this.zzd.zzb();
        this.zza = j8;
        this.zzb = j8;
    }

    public final boolean zzd(boolean z7, boolean z8, long j8) {
        this.zzc.zzg();
        this.zzc.zza();
        zzok.zzc();
        if (this.zzc.zzs.zzf().zzs(null, zzeh.zzad)) {
            if (this.zzc.zzs.zzJ()) {
                this.zzc.zzs.zzm().zzj.zzb(this.zzc.zzs.zzav().currentTimeMillis());
            }
        } else {
            this.zzc.zzs.zzm().zzj.zzb(this.zzc.zzs.zzav().currentTimeMillis());
        }
        long j9 = j8 - this.zza;
        if (!z7 && j9 < 1000) {
            this.zzc.zzs.zzay().zzj().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j9));
            return false;
        }
        if (!z8) {
            j9 = j8 - this.zzb;
            this.zzb = j8;
        }
        this.zzc.zzs.zzay().zzj().zzb("Recording user engagement, ms", Long.valueOf(j9));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j9);
        zzln.zzK(this.zzc.zzs.zzs().zzj(!this.zzc.zzs.zzf().zzu()), bundle, true);
        if (!z8) {
            this.zzc.zzs.zzq().zzG("auto", "_e", bundle);
        }
        this.zza = j8;
        this.zzd.zzb();
        this.zzd.zzd(3600000L);
        return true;
    }
}
