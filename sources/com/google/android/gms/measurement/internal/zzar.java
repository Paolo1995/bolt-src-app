package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzar {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzau zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzge zzgeVar, String str, String str2, String str3, long j8, long j9, Bundle bundle) {
        zzau zzauVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j8;
        this.zze = j9;
        if (j9 != 0 && j9 > j8) {
            zzgeVar.zzay().zzk().zzb("Event created with reverse previous/current timestamps. appId", zzeu.zzn(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzgeVar.zzay().zzd().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzA = zzgeVar.zzv().zzA(next, bundle2.get(next));
                    if (zzA == null) {
                        zzgeVar.zzay().zzk().zzb("Param value can't be null", zzgeVar.zzj().zze(next));
                        it.remove();
                    } else {
                        zzgeVar.zzv().zzO(bundle2, next, zzA);
                    }
                }
            }
            zzauVar = new zzau(bundle2);
        } else {
            zzauVar = new zzau(new Bundle());
        }
        this.zzf = zzauVar;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String obj = this.zzf.toString();
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + obj + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzar zza(zzge zzgeVar, long j8) {
        return new zzar(zzgeVar, this.zzc, this.zza, this.zzb, this.zzd, j8, this.zzf);
    }

    private zzar(zzge zzgeVar, String str, String str2, String str3, long j8, long j9, zzau zzauVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzauVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j8;
        this.zze = j9;
        if (j9 != 0 && j9 > j8) {
            zzgeVar.zzay().zzk().zzc("Event created with reverse previous/current timestamps. appId, name", zzeu.zzn(str2), zzeu.zzn(str3));
        }
        this.zzf = zzauVar;
    }
}
