package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzlc {
    com.google.android.gms.internal.measurement.zzgc zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzlf zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlc(zzlf zzlfVar, zzlb zzlbVar) {
        this.zze = zzlfVar;
    }

    private static final long zzb(com.google.android.gms.internal.measurement.zzfs zzfsVar) {
        return ((zzfsVar.zzd() / 1000) / 60) / 60;
    }

    public final boolean zza(long j8, com.google.android.gms.internal.measurement.zzfs zzfsVar) {
        Preconditions.checkNotNull(zzfsVar);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (!this.zzc.isEmpty() && zzb((com.google.android.gms.internal.measurement.zzfs) this.zzc.get(0)) != zzb(zzfsVar)) {
            return false;
        }
        long zzbw = this.zzd + zzfsVar.zzbw();
        this.zze.zzg();
        if (zzbw >= Math.max(0, ((Integer) zzeh.zzh.zza(null)).intValue())) {
            return false;
        }
        this.zzd = zzbw;
        this.zzc.add(zzfsVar);
        this.zzb.add(Long.valueOf(j8));
        int size = this.zzc.size();
        this.zze.zzg();
        if (size >= Math.max(1, ((Integer) zzeh.zzi.zza(null)).intValue())) {
            return false;
        }
        return true;
    }
}
