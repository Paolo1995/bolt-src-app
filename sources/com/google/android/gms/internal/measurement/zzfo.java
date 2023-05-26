package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzfo extends zzke implements zzlm {
    private static final zzfo zza;
    private int zze;
    private int zzf;
    private zzgh zzg;
    private zzgh zzh;
    private boolean zzi;

    static {
        zzfo zzfoVar = new zzfo();
        zza = zzfoVar;
        zzke.zzbJ(zzfo.class, zzfoVar);
    }

    private zzfo() {
    }

    public static zzfn zzb() {
        return (zzfn) zza.zzbx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzfo zzfoVar, int i8) {
        zzfoVar.zze |= 1;
        zzfoVar.zzf = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzfo zzfoVar, zzgh zzghVar) {
        zzghVar.getClass();
        zzfoVar.zzg = zzghVar;
        zzfoVar.zze |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzfo zzfoVar, zzgh zzghVar) {
        zzfoVar.zzh = zzghVar;
        zzfoVar.zze |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzfo zzfoVar, boolean z7) {
        zzfoVar.zze |= 8;
        zzfoVar.zzi = z7;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgh zzd() {
        zzgh zzghVar = this.zzg;
        if (zzghVar == null) {
            return zzgh.zzh();
        }
        return zzghVar;
    }

    public final zzgh zze() {
        zzgh zzghVar = this.zzh;
        if (zzghVar == null) {
            return zzgh.zzh();
        }
        return zzghVar;
    }

    public final boolean zzj() {
        return this.zzi;
    }

    public final boolean zzk() {
        return (this.zze & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    return new zzfn(null);
                }
                return new zzfo();
            }
            return zzke.zzbI(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }

    public final boolean zzm() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzn() {
        return (this.zze & 4) != 0;
    }
}
