package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzob;
import com.google.android.gms.internal.measurement.zzpi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzkn {
    final /* synthetic */ zzko zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkn(zzko zzkoVar) {
        this.zza = zzkoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzs.zzm().zzk(this.zza.zzs.zzav().currentTimeMillis())) {
            this.zza.zzs.zzm().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzs.zzay().zzj().zza("Detected application was in foreground");
                zzc(this.zza.zzs.zzav().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j8, boolean z7) {
        this.zza.zzg();
        this.zza.zzm();
        if (this.zza.zzs.zzm().zzk(j8)) {
            this.zza.zzs.zzm().zzg.zza(true);
            zzpi.zzc();
            if (this.zza.zzs.zzf().zzs(null, zzeh.zzaz)) {
                this.zza.zzs.zzh().zzo();
            }
        }
        this.zza.zzs.zzm().zzj.zzb(j8);
        if (this.zza.zzs.zzm().zzg.zzb()) {
            zzc(j8, z7);
        }
    }

    @VisibleForTesting
    final void zzc(long j8, boolean z7) {
        this.zza.zzg();
        if (!this.zza.zzs.zzJ()) {
            return;
        }
        this.zza.zzs.zzm().zzj.zzb(j8);
        this.zza.zzs.zzay().zzj().zzb("Session started, time", Long.valueOf(this.zza.zzs.zzav().elapsedRealtime()));
        Long valueOf = Long.valueOf(j8 / 1000);
        this.zza.zzs.zzq().zzY("auto", "_sid", valueOf, j8);
        this.zza.zzs.zzm().zzg.zza(false);
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", valueOf.longValue());
        if (this.zza.zzs.zzf().zzs(null, zzeh.zzZ) && z7) {
            bundle.putLong("_aib", 1L);
        }
        this.zza.zzs.zzq().zzH("auto", "_s", j8, bundle);
        zzob.zzc();
        if (this.zza.zzs.zzf().zzs(null, zzeh.zzac)) {
            String zza = this.zza.zzs.zzm().zzo.zza();
            if (!TextUtils.isEmpty(zza)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza);
                this.zza.zzs.zzq().zzH("auto", "_ssr", j8, bundle2);
            }
        }
    }
}
