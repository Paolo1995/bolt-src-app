package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzeq extends zzke implements zzlm {
    private static final zzeq zza;
    private int zze;
    private int zzf;
    private boolean zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzeq zzeqVar = new zzeq();
        zza = zzeqVar;
        zzke.zzbJ(zzeq.class, zzeqVar);
    }

    private zzeq() {
    }

    public static zzeq zzb() {
        return zza;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zzj;
    }

    public final String zze() {
        return this.zzi;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzk() {
        return (this.zze & 8) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final Object zzl(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 != 0) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 != 4) {
                        if (i9 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzem(null);
                }
                return new zzeq();
            }
            return zzke.zzbI(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", zzeo.zza, "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }

    public final int zzm() {
        int zza2 = zzep.zza(this.zzf);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }
}
