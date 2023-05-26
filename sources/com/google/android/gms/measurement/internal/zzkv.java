package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzkv implements Runnable {
    final /* synthetic */ zzlg zza;
    final /* synthetic */ zzlf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkv(zzlf zzlfVar, zzlg zzlgVar) {
        this.zzb = zzlfVar;
        this.zza = zzlgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
