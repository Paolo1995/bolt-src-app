package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzgi implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgw zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgi(zzgw zzgwVar, String str, String str2, String str3) {
        this.zzd = zzgwVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlf zzlfVar;
        zzlf zzlfVar2;
        zzlfVar = this.zzd.zza;
        zzlfVar.zzA();
        zzlfVar2 = this.zzd.zza;
        return zzlfVar2.zzi().zzv(this.zza, this.zzb, this.zzc);
    }
}
