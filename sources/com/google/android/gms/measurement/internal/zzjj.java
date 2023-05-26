package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzjj implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zzc;
    final /* synthetic */ zzjy zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjj(zzjy zzjyVar, zzaw zzawVar, String str, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzd = zzjyVar;
        this.zza = zzawVar;
        this.zzb = str;
        this.zzc = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzge zzgeVar;
        zzek zzekVar;
        byte[] bArr = null;
        try {
            try {
                zzjy zzjyVar = this.zzd;
                zzekVar = zzjyVar.zzb;
                if (zzekVar == null) {
                    zzjyVar.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service to bundle");
                    zzgeVar = this.zzd.zzs;
                } else {
                    bArr = zzekVar.zzu(this.zza, this.zzb);
                    this.zzd.zzQ();
                    zzgeVar = this.zzd.zzs;
                }
            } catch (RemoteException e8) {
                this.zzd.zzs.zzay().zzd().zzb("Failed to send event to the service to bundle", e8);
                zzgeVar = this.zzd.zzs;
            }
            zzgeVar.zzv().zzS(this.zzc, bArr);
        } catch (Throwable th) {
            this.zzd.zzs.zzv().zzS(this.zzc, bArr);
            throw th;
        }
    }
}
