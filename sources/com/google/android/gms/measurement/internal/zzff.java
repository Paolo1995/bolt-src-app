package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzff {
    final /* synthetic */ zzfj zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzff(zzfj zzfjVar, String str, long j8) {
        this.zza = zzfjVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j8;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j8) {
        SharedPreferences.Editor edit = this.zza.zza().edit();
        edit.putLong(this.zzb, j8);
        edit.apply();
        this.zze = j8;
    }
}
