package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzgh extends zzke implements zzlm {
    private static final zzgh zza;
    private zzkk zze = zzke.zzbB();
    private zzkk zzf = zzke.zzbB();
    private zzkl zzg = zzke.zzbD();
    private zzkl zzh = zzke.zzbD();

    static {
        zzgh zzghVar = new zzgh();
        zza = zzghVar;
        zzke.zzbJ(zzgh.class, zzghVar);
    }

    private zzgh() {
    }

    public static zzgg zzf() {
        return (zzgg) zza.zzbx();
    }

    public static zzgh zzh() {
        return zza;
    }

    public static /* synthetic */ void zzo(zzgh zzghVar, Iterable iterable) {
        zzkk zzkkVar = zzghVar.zze;
        if (!zzkkVar.zzc()) {
            zzghVar.zze = zzke.zzbC(zzkkVar);
        }
        zzin.zzbt(iterable, zzghVar.zze);
    }

    public static /* synthetic */ void zzq(zzgh zzghVar, Iterable iterable) {
        zzkk zzkkVar = zzghVar.zzf;
        if (!zzkkVar.zzc()) {
            zzghVar.zzf = zzke.zzbC(zzkkVar);
        }
        zzin.zzbt(iterable, zzghVar.zzf);
    }

    public static /* synthetic */ void zzs(zzgh zzghVar, Iterable iterable) {
        zzghVar.zzy();
        zzin.zzbt(iterable, zzghVar.zzg);
    }

    public static /* synthetic */ void zzu(zzgh zzghVar, int i8) {
        zzghVar.zzy();
        zzghVar.zzg.remove(i8);
    }

    public static /* synthetic */ void zzv(zzgh zzghVar, Iterable iterable) {
        zzghVar.zzz();
        zzin.zzbt(iterable, zzghVar.zzh);
    }

    public static /* synthetic */ void zzx(zzgh zzghVar, int i8) {
        zzghVar.zzz();
        zzghVar.zzh.remove(i8);
    }

    private final void zzy() {
        zzkl zzklVar = this.zzg;
        if (!zzklVar.zzc()) {
            this.zzg = zzke.zzbE(zzklVar);
        }
    }

    private final void zzz() {
        zzkl zzklVar = this.zzh;
        if (!zzklVar.zzc()) {
            this.zzh = zzke.zzbE(zzklVar);
        }
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final zzfq zze(int i8) {
        return (zzfq) this.zzg.get(i8);
    }

    public final zzgj zzi(int i8) {
        return (zzgj) this.zzh.get(i8);
    }

    public final List zzj() {
        return this.zzg;
    }

    public final List zzk() {
        return this.zzf;
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
                    return new zzgg(null);
                }
                return new zzgh();
            }
            return zzke.zzbI(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", zzfq.class, "zzh", zzgj.class});
        }
        return (byte) 1;
    }

    public final List zzm() {
        return this.zzh;
    }

    public final List zzn() {
        return this.zze;
    }
}
