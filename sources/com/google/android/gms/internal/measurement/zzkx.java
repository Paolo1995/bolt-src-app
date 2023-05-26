package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzkx extends zzkz {
    private zzkx() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkx(zzkw zzkwVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkz
    public final void zza(Object obj, long j8) {
        ((zzkl) zzmx.zzf(obj, j8)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkz
    public final void zzb(Object obj, Object obj2, long j8) {
        zzkl zzklVar = (zzkl) zzmx.zzf(obj, j8);
        zzkl zzklVar2 = (zzkl) zzmx.zzf(obj2, j8);
        int size = zzklVar.size();
        int size2 = zzklVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzklVar.zzc()) {
                zzklVar = zzklVar.zzd(size2 + size);
            }
            zzklVar.addAll(zzklVar2);
        }
        if (size > 0) {
            zzklVar2 = zzklVar;
        }
        zzmx.zzs(obj, j8, zzklVar2);
    }
}
