package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.1.0 */
/* loaded from: classes.dex */
public final class zzo implements zzhe {
    public final com.google.android.gms.internal.measurement.zzci zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzci zzciVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzciVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhe
    public final void interceptEvent(String str, String str2, Bundle bundle, long j8) {
        try {
            this.zza.zze(str, str2, bundle, j8);
        } catch (RemoteException e8) {
            zzge zzgeVar = this.zzb.zza;
            if (zzgeVar != null) {
                zzgeVar.zzay().zzk().zzb("Event interceptor threw exception", e8);
            }
        }
    }
}
