package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzft implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzfv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzft(zzfv zzfvVar) {
        this.zza = zzfvVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i8, String str, List list, boolean z7, boolean z8) {
        zzes zzc;
        int i9 = i8 - 1;
        if (i9 != 0) {
            if (i9 != 1) {
                if (i9 != 3) {
                    if (i9 != 4) {
                        zzc = this.zza.zzs.zzay().zzi();
                    } else if (z7) {
                        zzc = this.zza.zzs.zzay().zzm();
                    } else if (!z8) {
                        zzc = this.zza.zzs.zzay().zzl();
                    } else {
                        zzc = this.zza.zzs.zzay().zzk();
                    }
                } else {
                    zzc = this.zza.zzs.zzay().zzj();
                }
            } else if (z7) {
                zzc = this.zza.zzs.zzay().zzh();
            } else if (!z8) {
                zzc = this.zza.zzs.zzay().zze();
            } else {
                zzc = this.zza.zzs.zzay().zzd();
            }
        } else {
            zzc = this.zza.zzs.zzay().zzc();
        }
        int size = list.size();
        if (size != 1) {
            if (size != 2) {
                if (size != 3) {
                    zzc.zza(str);
                    return;
                } else {
                    zzc.zzd(str, list.get(0), list.get(1), list.get(2));
                    return;
                }
            }
            zzc.zzc(str, list.get(0), list.get(1));
            return;
        }
        zzc.zzb(str, list.get(0));
    }
}
