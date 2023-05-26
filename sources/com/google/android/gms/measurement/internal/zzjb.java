package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzjb implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzjy zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjb(zzjy zzjyVar, AtomicReference atomicReference, zzq zzqVar, boolean z7) {
        this.zzd = zzjyVar;
        this.zza = atomicReference;
        this.zzb = zzqVar;
        this.zzc = z7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzjy zzjyVar;
        zzek zzekVar;
        synchronized (this.zza) {
            try {
                zzjyVar = this.zzd;
                zzekVar = zzjyVar.zzb;
            } catch (RemoteException e8) {
                this.zzd.zzs.zzay().zzd().zzb("Failed to get all user properties; remote exception", e8);
                atomicReference = this.zza;
            }
            if (zzekVar == null) {
                zzjyVar.zzs.zzay().zzd().zza("Failed to get all user properties; not connected to service");
                this.zza.notify();
                return;
            }
            Preconditions.checkNotNull(this.zzb);
            this.zza.set(zzekVar.zze(this.zzb, this.zzc));
            this.zzd.zzQ();
            atomicReference = this.zza;
            atomicReference.notify();
        }
    }
}
