package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzho implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ String zzh;
    final /* synthetic */ zzij zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzho(zzij zzijVar, String str, String str2, long j8, Bundle bundle, boolean z7, boolean z8, boolean z9, String str3) {
        this.zzi = zzijVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = j8;
        this.zzd = bundle;
        this.zze = z7;
        this.zzf = z8;
        this.zzg = z9;
        this.zzh = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzi.zzI(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }
}
