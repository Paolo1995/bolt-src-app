package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzgf extends zzke implements zzlm {
    private static final zzgf zza;
    private int zze;
    private int zzf = 1;
    private zzkl zzg = zzke.zzbD();

    static {
        zzgf zzgfVar = new zzgf();
        zza = zzgfVar;
        zzke.zzbJ(zzgf.class, zzgfVar);
    }

    private zzgf() {
    }

    public static zzgd zza() {
        return (zzgd) zza.zzbx();
    }

    public static /* synthetic */ void zzc(zzgf zzgfVar, zzfu zzfuVar) {
        zzfuVar.getClass();
        zzkl zzklVar = zzgfVar.zzg;
        if (!zzklVar.zzc()) {
            zzgfVar.zzg = zzke.zzbE(zzklVar);
        }
        zzgfVar.zzg.add(zzfuVar);
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
                    return new zzgd(null);
                }
                return new zzgf();
            }
            return zzke.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zze", "zzf", zzge.zza, "zzg", zzfu.class});
        }
        return (byte) 1;
    }
}
