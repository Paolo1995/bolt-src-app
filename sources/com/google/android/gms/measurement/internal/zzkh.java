package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
final class zzkh implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzko zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkh(zzko zzkoVar, long j8) {
        this.zzb = zzkoVar;
        this.zza = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzko.zzj(this.zzb, this.zza);
    }
}
