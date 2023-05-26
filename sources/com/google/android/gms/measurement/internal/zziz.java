package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zziz implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zze;
    final /* synthetic */ zzjy zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziz(zzjy zzjyVar, String str, String str2, zzq zzqVar, boolean z7, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzf = zzjyVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = z7;
        this.zze = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        RemoteException e8;
        zzek zzekVar;
        Bundle bundle2 = new Bundle();
        try {
            zzjy zzjyVar = this.zzf;
            zzekVar = zzjyVar.zzb;
            if (zzekVar == null) {
                zzjyVar.zzs.zzay().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzs.zzv().zzR(this.zze, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzli> zzh = zzekVar.zzh(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (zzh != null) {
                for (zzli zzliVar : zzh) {
                    String str = zzliVar.zze;
                    if (str != null) {
                        bundle.putString(zzliVar.zzb, str);
                    } else {
                        Long l8 = zzliVar.zzd;
                        if (l8 != null) {
                            bundle.putLong(zzliVar.zzb, l8.longValue());
                        } else {
                            Double d8 = zzliVar.zzg;
                            if (d8 != null) {
                                bundle.putDouble(zzliVar.zzb, d8.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    this.zzf.zzQ();
                    this.zzf.zzs.zzv().zzR(this.zze, bundle);
                } catch (Throwable th) {
                    th = th;
                    bundle2 = bundle;
                    this.zzf.zzs.zzv().zzR(this.zze, bundle2);
                    throw th;
                }
            } catch (RemoteException e9) {
                e8 = e9;
                this.zzf.zzs.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e8);
                this.zzf.zzs.zzv().zzR(this.zze, bundle);
            }
        } catch (RemoteException e10) {
            bundle = bundle2;
            e8 = e10;
        } catch (Throwable th2) {
            th = th2;
            this.zzf.zzs.zzv().zzR(this.zze, bundle2);
            throw th;
        }
    }
}
