package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zziu implements Runnable {
    final /* synthetic */ zziy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziu(zziy zziyVar) {
        this.zza = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zziq zziqVar;
        zziy zziyVar = this.zza;
        zziqVar = zziyVar.zzh;
        zziyVar.zza = zziqVar;
    }
}
