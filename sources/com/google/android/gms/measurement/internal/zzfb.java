package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzfb implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzfc zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfb(zzfc zzfcVar, boolean z7) {
        this.zzb = zzfcVar;
        this.zza = z7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf zzlfVar;
        zzlfVar = this.zzb.zzb;
        zzlfVar.zzJ(this.zza);
    }
}
