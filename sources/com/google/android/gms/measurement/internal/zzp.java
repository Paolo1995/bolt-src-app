package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.1.0 */
/* loaded from: classes.dex */
final class zzp implements zzhf {
    public final com.google.android.gms.internal.measurement.zzci zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzci zzciVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzciVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final void onEvent(String str, String str2, Bundle bundle, long j8) {
        try {
            this.zza.zze(str, str2, bundle, j8);
        } catch (RemoteException e8) {
            zzge zzgeVar = this.zzb.zza;
            if (zzgeVar != null) {
                zzgeVar.zzay().zzk().zzb("Event listener threw exception", e8);
            }
        }
    }
}
