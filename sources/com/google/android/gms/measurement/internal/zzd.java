package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzd extends zze {
    private final Map zza;
    private final Map zzb;
    private long zzc;

    public zzd(zzge zzgeVar) {
        super(zzgeVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzd zzdVar, String str, long j8) {
        zzdVar.zzg();
        Preconditions.checkNotEmpty(str);
        if (zzdVar.zzb.isEmpty()) {
            zzdVar.zzc = j8;
        }
        Integer num = (Integer) zzdVar.zzb.get(str);
        if (num != null) {
            zzdVar.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzdVar.zzb.size() >= 100) {
            zzdVar.zzs.zzay().zzk().zza("Too many ads visible");
        } else {
            zzdVar.zzb.put(str, 1);
            zzdVar.zza.put(str, Long.valueOf(j8));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zzd zzdVar, String str, long j8) {
        zzdVar.zzg();
        Preconditions.checkNotEmpty(str);
        Integer num = (Integer) zzdVar.zzb.get(str);
        if (num != null) {
            zziq zzj = zzdVar.zzs.zzs().zzj(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zzdVar.zzb.remove(str);
                Long l8 = (Long) zzdVar.zza.get(str);
                if (l8 == null) {
                    zzdVar.zzs.zzay().zzd().zza("First ad unit exposure time was never set");
                } else {
                    long longValue = l8.longValue();
                    zzdVar.zza.remove(str);
                    zzdVar.zzi(str, j8 - longValue, zzj);
                }
                if (zzdVar.zzb.isEmpty()) {
                    long j9 = zzdVar.zzc;
                    if (j9 == 0) {
                        zzdVar.zzs.zzay().zzd().zza("First ad exposure time was never set");
                        return;
                    }
                    zzdVar.zzh(j8 - j9, zzj);
                    zzdVar.zzc = 0L;
                    return;
                }
                return;
            }
            zzdVar.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzdVar.zzs.zzay().zzd().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    private final void zzh(long j8, zziq zziqVar) {
        if (zziqVar == null) {
            this.zzs.zzay().zzj().zza("Not logging ad exposure. No active activity");
        } else if (j8 < 1000) {
            this.zzs.zzay().zzj().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j8));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j8);
            zzln.zzK(zziqVar, bundle, true);
            this.zzs.zzq().zzG("am", "_xa", bundle);
        }
    }

    private final void zzi(String str, long j8, zziq zziqVar) {
        if (zziqVar == null) {
            this.zzs.zzay().zzj().zza("Not logging ad unit exposure. No active activity");
        } else if (j8 < 1000) {
            this.zzs.zzay().zzj().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j8));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j8);
            zzln.zzK(zziqVar, bundle, true);
            this.zzs.zzq().zzG("am", "_xu", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(long j8) {
        for (String str : this.zza.keySet()) {
            this.zza.put(str, Long.valueOf(j8));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j8;
        }
    }

    public final void zzd(String str, long j8) {
        if (str != null && str.length() != 0) {
            this.zzs.zzaz().zzp(new zza(this, str, j8));
        } else {
            this.zzs.zzay().zzd().zza("Ad unit id must be a non-empty string");
        }
    }

    public final void zze(String str, long j8) {
        if (str != null && str.length() != 0) {
            this.zzs.zzaz().zzp(new zzb(this, str, j8));
        } else {
            this.zzs.zzay().zzd().zza("Ad unit id must be a non-empty string");
        }
    }

    public final void zzf(long j8) {
        zziq zzj = this.zzs.zzs().zzj(false);
        for (String str : this.zza.keySet()) {
            zzi(str, j8 - ((Long) this.zza.get(str)).longValue(), zzj);
        }
        if (!this.zza.isEmpty()) {
            zzh(j8 - this.zzc, zzj);
        }
        zzj(j8);
    }
}
