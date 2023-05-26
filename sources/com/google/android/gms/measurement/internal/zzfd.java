package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzfd {
    final /* synthetic */ zzfj zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzfd(zzfj zzfjVar, String str, boolean z7) {
        this.zza = zzfjVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = z7;
    }

    public final void zza(boolean z7) {
        SharedPreferences.Editor edit = this.zza.zza().edit();
        edit.putBoolean(this.zzb, z7);
        edit.apply();
        this.zze = z7;
    }

    public final boolean zzb() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }
}
