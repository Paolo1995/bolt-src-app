package com.google.android.gms.internal.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzfi implements zzgc {
    private static final zzfo zza = new zzfg();
    private final zzfo zzb;

    public zzfi() {
        zzfo zzfoVar;
        zzfo[] zzfoVarArr = new zzfo[2];
        zzfoVarArr[0] = zzen.zza();
        try {
            zzfoVar = (zzfo) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzfoVar = zza;
        }
        zzfoVarArr[1] = zzfoVar;
        zzfh zzfhVar = new zzfh(zzfoVarArr);
        zzev.zzf(zzfhVar, "messageInfoFactory");
        this.zzb = zzfhVar;
    }

    private static boolean zzb(zzfn zzfnVar) {
        if (zzfnVar.zzc() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.auth.zzgc
    public final <T> zzgb<T> zza(Class<T> cls) {
        zzgd.zzg(cls);
        zzfn zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzeq.class.isAssignableFrom(cls)) {
                return zzfu.zzb(zzgd.zzc(), zzej.zzb(), zzb.zza());
            }
            return zzfu.zzb(zzgd.zza(), zzej.zza(), zzb.zza());
        } else if (zzeq.class.isAssignableFrom(cls)) {
            if (zzb(zzb)) {
                return zzft.zzj(cls, zzb, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), zzej.zzb(), zzfm.zzb());
            }
            return zzft.zzj(cls, zzb, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), null, zzfm.zzb());
        } else if (zzb(zzb)) {
            return zzft.zzj(cls, zzb, zzfw.zza(), zzfe.zzc(), zzgd.zza(), zzej.zza(), zzfm.zza());
        } else {
            return zzft.zzj(cls, zzb, zzfw.zza(), zzfe.zzc(), zzgd.zzb(), null, zzfm.zza());
        }
    }
}
