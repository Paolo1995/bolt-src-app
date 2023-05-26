package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzni implements zznh {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;
    public static final zzia zzd;
    public static final zzia zze;
    public static final zzia zzf;
    public static final zzia zzg;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.adid_zero.app_instance_id_fix", true);
        zzb = zza2.zzf("measurement.adid_zero.service", true);
        zzc = zza2.zzf("measurement.adid_zero.adid_uid", true);
        zzd = zza2.zzf("measurement.adid_zero.only_request_adid_if_enabled", true);
        zze = zza2.zzf("measurement.adid_zero.remove_lair_if_adidzero_false", true);
        zzf = zza2.zzf("measurement.adid_zero.remove_lair_if_userid_cleared", true);
        zzg = zza2.zzf("measurement.adid_zero.remove_lair_on_id_value_change_only", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznh
    public final boolean zza() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }
}
