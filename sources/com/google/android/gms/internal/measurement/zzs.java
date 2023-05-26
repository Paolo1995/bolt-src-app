package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z7, boolean z8) {
        super("log");
        this.zzc = zztVar;
        this.zza = z7;
        this.zzb = z8;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        int i8;
        zzr zzrVar;
        zzr zzrVar2;
        zzr zzrVar3;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            zzrVar3 = this.zzc.zza;
            zzrVar3.zza(3, zzgVar.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        int zzb = zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
        if (zzb != 2) {
            if (zzb != 3) {
                if (zzb != 5) {
                    if (zzb != 6) {
                        i8 = 3;
                    } else {
                        i8 = 2;
                    }
                } else {
                    i8 = 5;
                }
            } else {
                i8 = 1;
            }
        } else {
            i8 = 4;
        }
        String zzi = zzgVar.zzb((zzap) list.get(1)).zzi();
        if (list.size() == 2) {
            zzrVar2 = this.zzc.zza;
            zzrVar2.zza(i8, zzi, Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        ArrayList arrayList = new ArrayList();
        for (int i9 = 2; i9 < Math.min(list.size(), 5); i9++) {
            arrayList.add(zzgVar.zzb((zzap) list.get(i9)).zzi());
        }
        zzrVar = this.zzc.zza;
        zzrVar.zza(i8, zzi, arrayList, this.zza, this.zzb);
        return zzap.zzf;
    }
}
