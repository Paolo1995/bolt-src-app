package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.1.0 */
/* loaded from: classes.dex */
public final class zzdr extends zzdt {
    final /* synthetic */ Long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ zzee zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdr(zzee zzeeVar, Long l8, String str, String str2, Bundle bundle, boolean z7, boolean z8) {
        super(zzeeVar, true);
        this.zzg = zzeeVar;
        this.zza = l8;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z7;
        this.zzf = z8;
    }

    @Override // com.google.android.gms.internal.measurement.zzdt
    final void zza() throws RemoteException {
        long longValue;
        zzcc zzccVar;
        Long l8 = this.zza;
        if (l8 == null) {
            longValue = this.zzh;
        } else {
            longValue = l8.longValue();
        }
        long j8 = longValue;
        zzccVar = this.zzg.zzj;
        ((zzcc) Preconditions.checkNotNull(zzccVar)).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j8);
    }
}
