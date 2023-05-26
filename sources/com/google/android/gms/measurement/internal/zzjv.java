package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
final class zzjv implements Runnable {
    final /* synthetic */ zzjx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjv(zzjx zzjxVar) {
        this.zza = zzjxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjy zzjyVar = this.zza.zza;
        Context zzau = zzjyVar.zzs.zzau();
        this.zza.zza.zzs.zzaw();
        zzjy.zzo(zzjyVar, new ComponentName(zzau, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
