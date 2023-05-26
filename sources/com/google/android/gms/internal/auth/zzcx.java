package com.google.android.gms.internal.auth;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzcx {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;
    @Nullable
    final zzdd<Context, Boolean> zzi;

    public zzcx(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzcx(String str, Uri uri, String str2, String str3, boolean z7, boolean z8, boolean z9, boolean z10, @Nullable zzdd<Context, Boolean> zzddVar) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = z7;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzcx zza() {
        if (this.zzc.isEmpty()) {
            return new zzcx(null, this.zzb, this.zzc, this.zzd, true, false, false, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzcz<Double> zzb(String str, double d8) {
        return new zzcv(this, str, Double.valueOf(0.0d), true);
    }

    public final zzcz<Long> zzc(String str, long j8) {
        return new zzct(this, str, Long.valueOf(j8), true);
    }

    public final zzcz<Boolean> zzd(String str, boolean z7) {
        return new zzcu(this, str, Boolean.valueOf(z7), true);
    }

    public final <T> zzcz<T> zze(String str, T t7, zzhl zzhlVar) {
        return new zzcw(this, "getTokenRefactor__blocked_packages", t7, true, zzhlVar, null);
    }
}
