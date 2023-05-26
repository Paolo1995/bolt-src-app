package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzhm implements Runnable {
    final /* synthetic */ zzij zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhm(zzij zzijVar) {
        this.zza = zzijVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zzb();
    }
}
