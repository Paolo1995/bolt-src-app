package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzje implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zzb;
    final /* synthetic */ zzjy zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzje(zzjy zzjyVar, zzq zzqVar, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzc = zzjyVar;
        this.zza = zzqVar;
        this.zzb = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzge zzgeVar;
        zzek zzekVar;
        String str = null;
        try {
            try {
                if (!this.zzc.zzs.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                    this.zzc.zzs.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzs.zzq().zzO(null);
                    this.zzc.zzs.zzm().zze.zzb(null);
                    zzgeVar = this.zzc.zzs;
                } else {
                    zzjy zzjyVar = this.zzc;
                    zzekVar = zzjyVar.zzb;
                    if (zzekVar == null) {
                        zzjyVar.zzs.zzay().zzd().zza("Failed to get app instance id");
                        zzgeVar = this.zzc.zzs;
                    } else {
                        Preconditions.checkNotNull(this.zza);
                        str = zzekVar.zzd(this.zza);
                        if (str != null) {
                            this.zzc.zzs.zzq().zzO(str);
                            this.zzc.zzs.zzm().zze.zzb(str);
                        }
                        this.zzc.zzQ();
                        zzgeVar = this.zzc.zzs;
                    }
                }
            } catch (RemoteException e8) {
                this.zzc.zzs.zzay().zzd().zzb("Failed to get app instance id", e8);
                zzgeVar = this.zzc.zzs;
            }
            zzgeVar.zzv().zzV(this.zzb, str);
        } catch (Throwable th) {
            this.zzc.zzs.zzv().zzV(this.zzb, null);
            throw th;
        }
    }
}
