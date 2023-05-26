package com.google.android.gms.measurement.internal;

import android.util.Log;
import j$.util.Spliterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzer implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzeu zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzer(zzeu zzeuVar, int i8, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzeuVar;
        this.zza = i8;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c8;
        long j8;
        char c9;
        long j9;
        zzfj zzm = this.zzf.zzs.zzm();
        if (zzm.zzx()) {
            zzeu zzeuVar = this.zzf;
            c8 = zzeuVar.zza;
            if (c8 == 0) {
                if (zzeuVar.zzs.zzf().zzy()) {
                    zzeu zzeuVar2 = this.zzf;
                    zzeuVar2.zzs.zzaw();
                    zzeuVar2.zza = 'C';
                } else {
                    zzeu zzeuVar3 = this.zzf;
                    zzeuVar3.zzs.zzaw();
                    zzeuVar3.zza = 'c';
                }
            }
            zzeu zzeuVar4 = this.zzf;
            j8 = zzeuVar4.zzb;
            if (j8 < 0) {
                zzeuVar4.zzs.zzf().zzh();
                zzeuVar4.zzb = 68000L;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzeu zzeuVar5 = this.zzf;
            c9 = zzeuVar5.zza;
            j9 = zzeuVar5.zzb;
            String str = "2" + charAt + c9 + j9 + ":" + zzeu.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            if (str.length() > 1024) {
                str = this.zzb.substring(0, Spliterator.IMMUTABLE);
            }
            zzfh zzfhVar = zzm.zzb;
            if (zzfhVar != null) {
                zzfhVar.zzb(str, 1L);
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
    }
}
