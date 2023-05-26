package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzjm implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzjy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjm(zzjy zzjyVar, zzq zzqVar) {
        this.zzb = zzjyVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzek zzekVar;
        zzjy zzjyVar = this.zzb;
        zzekVar = zzjyVar.zzb;
        if (zzekVar == null) {
            zzjyVar.zzs.zzay().zzd().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzekVar.zzp(this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e8) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send consent settings to the service", e8);
        }
    }
}
