package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.1.0 */
/* loaded from: classes.dex */
public abstract class zzdt implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzee zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(zzee zzeeVar, boolean z7) {
        this.zzk = zzeeVar;
        this.zzh = zzeeVar.zza.currentTimeMillis();
        this.zzi = zzeeVar.zza.elapsedRealtime();
        this.zzj = z7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z7;
        z7 = this.zzk.zzh;
        if (z7) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e8) {
            this.zzk.zzS(e8, false, this.zzj);
            zzb();
        }
    }

    abstract void zza() throws RemoteException;

    protected void zzb() {
    }
}
