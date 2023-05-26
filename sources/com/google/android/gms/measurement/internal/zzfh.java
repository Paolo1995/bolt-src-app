package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzfh {
    @VisibleForTesting
    final String zza;
    final /* synthetic */ zzfj zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfh(zzfj zzfjVar, String str, long j8, zzfg zzfgVar) {
        boolean z7;
        this.zzb = zzfjVar;
        Preconditions.checkNotEmpty("health_monitor");
        if (j8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j8;
    }

    private final long zzc() {
        return this.zzb.zza().getLong(this.zza, 0L);
    }

    private final void zzd() {
        this.zzb.zzg();
        long currentTimeMillis = this.zzb.zzs.zzav().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzb.zza().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    public final Pair zza() {
        long abs;
        this.zzb.zzg();
        this.zzb.zzg();
        long zzc = zzc();
        if (zzc == 0) {
            zzd();
            abs = 0;
        } else {
            abs = Math.abs(zzc - this.zzb.zzs.zzav().currentTimeMillis());
        }
        long j8 = this.zze;
        if (abs < j8) {
            return null;
        }
        if (abs > j8 + j8) {
            zzd();
            return null;
        }
        String string = this.zzb.zza().getString(this.zzd, null);
        long j9 = this.zzb.zza().getLong(this.zzc, 0L);
        zzd();
        if (string != null && j9 > 0) {
            return new Pair(string, Long.valueOf(j9));
        }
        return zzfj.zza;
    }

    public final void zzb(String str, long j8) {
        this.zzb.zzg();
        if (zzc() == 0) {
            zzd();
        }
        if (str == null) {
            str = "";
        }
        long j9 = this.zzb.zza().getLong(this.zzc, 0L);
        if (j9 <= 0) {
            SharedPreferences.Editor edit = this.zzb.zza().edit();
            edit.putString(this.zzd, str);
            edit.putLong(this.zzc, 1L);
            edit.apply();
            return;
        }
        long nextLong = this.zzb.zzs.zzv().zzG().nextLong();
        long j10 = j9 + 1;
        SharedPreferences.Editor edit2 = this.zzb.zza().edit();
        if ((nextLong & Long.MAX_VALUE) < Long.MAX_VALUE / j10) {
            edit2.putString(this.zzd, str);
        }
        edit2.putLong(this.zzc, j10);
        edit2.apply();
    }
}
