package com.google.android.gms.measurement.internal;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzhg implements zzeo {
    final /* synthetic */ zzge zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhg(zzhh zzhhVar, zzge zzgeVar) {
        this.zza = zzgeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final boolean zza() {
        if (this.zza.zzL() && Log.isLoggable(this.zza.zzay().zzq(), 3)) {
            return true;
        }
        return false;
    }
}
