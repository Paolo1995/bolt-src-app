package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
final class zzjt implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzjx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjt(zzjx zzjxVar, ComponentName componentName) {
        this.zzb = zzjxVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjy.zzo(this.zzb.zza, this.zza);
    }
}
