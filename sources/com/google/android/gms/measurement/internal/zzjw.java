package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
final class zzjw implements Runnable {
    final /* synthetic */ zzjx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjw(zzjx zzjxVar) {
        this.zza = zzjxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzP();
    }
}
