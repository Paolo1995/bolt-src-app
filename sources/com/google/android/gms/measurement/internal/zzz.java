package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzoe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzz extends zzy {
    final /* synthetic */ zzaa zza;
    private final com.google.android.gms.internal.measurement.zzes zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(zzaa zzaaVar, String str, int i8, com.google.android.gms.internal.measurement.zzes zzesVar) {
        super(str, i8);
        this.zza = zzaaVar;
        this.zzh = zzesVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final int zza() {
        return this.zzh.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(Long l8, Long l9, com.google.android.gms.internal.measurement.zzgl zzglVar, boolean z7) {
        boolean z8;
        Object obj;
        zzoe.zzc();
        boolean zzs = this.zza.zzs.zzf().zzs(this.zzb, zzeh.zzU);
        boolean zzg = this.zzh.zzg();
        boolean zzh = this.zzh.zzh();
        boolean zzi = this.zzh.zzi();
        if (!zzg && !zzh && !zzi) {
            z8 = false;
        } else {
            z8 = true;
        }
        Boolean bool = null;
        Integer num = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z7 && !z8) {
            zzes zzj = this.zza.zzs.zzay().zzj();
            Integer valueOf = Integer.valueOf(this.zzc);
            if (this.zzh.zzj()) {
                num = Integer.valueOf(this.zzh.zza());
            }
            zzj.zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf, num);
            return true;
        }
        com.google.android.gms.internal.measurement.zzel zzb = this.zzh.zzb();
        boolean zzg2 = zzb.zzg();
        if (zzglVar.zzr()) {
            if (!zzb.zzi()) {
                this.zza.zzs.zzay().zzk().zzb("No number filter for long property. property", this.zza.zzs.zzj().zzf(zzglVar.zzf()));
            } else {
                bool = zzy.zzj(zzy.zzh(zzglVar.zzb(), zzb.zzc()), zzg2);
            }
        } else if (zzglVar.zzq()) {
            if (!zzb.zzi()) {
                this.zza.zzs.zzay().zzk().zzb("No number filter for double property. property", this.zza.zzs.zzj().zzf(zzglVar.zzf()));
            } else {
                bool = zzy.zzj(zzy.zzg(zzglVar.zza(), zzb.zzc()), zzg2);
            }
        } else if (zzglVar.zzt()) {
            if (!zzb.zzk()) {
                if (!zzb.zzi()) {
                    this.zza.zzs.zzay().zzk().zzb("No string or number filter defined. property", this.zza.zzs.zzj().zzf(zzglVar.zzf()));
                } else if (zzlh.zzx(zzglVar.zzg())) {
                    bool = zzy.zzj(zzy.zzi(zzglVar.zzg(), zzb.zzc()), zzg2);
                } else {
                    this.zza.zzs.zzay().zzk().zzc("Invalid user property value for Numeric number filter. property, value", this.zza.zzs.zzj().zzf(zzglVar.zzf()), zzglVar.zzg());
                }
            } else {
                bool = zzy.zzj(zzy.zzf(zzglVar.zzg(), zzb.zzd(), this.zza.zzs.zzay()), zzg2);
            }
        } else {
            this.zza.zzs.zzay().zzk().zzb("User property has no value, property", this.zza.zzs.zzj().zzf(zzglVar.zzf()));
        }
        zzes zzj2 = this.zza.zzs.zzay().zzj();
        if (bool == null) {
            obj = "null";
        } else {
            obj = bool;
        }
        zzj2.zzb("Property filter result", obj);
        if (bool == null) {
            return false;
        }
        this.zzd = Boolean.TRUE;
        if (zzi && !bool.booleanValue()) {
            return true;
        }
        if (!z7 || this.zzh.zzg()) {
            this.zze = bool;
        }
        if (bool.booleanValue() && z8 && zzglVar.zzs()) {
            long zzc = zzglVar.zzc();
            if (l8 != null) {
                zzc = l8.longValue();
            }
            if (zzs && this.zzh.zzg() && !this.zzh.zzh() && l9 != null) {
                zzc = l9.longValue();
            }
            if (this.zzh.zzh()) {
                this.zzg = Long.valueOf(zzc);
            } else {
                this.zzf = Long.valueOf(zzc);
            }
        }
        return true;
    }
}
