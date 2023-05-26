package com.google.android.gms.internal.auth;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzfu<T> implements zzgb<T> {
    private final zzfq zza;
    private final zzgp<?, ?> zzb;
    private final zzeh<?> zzc;

    private zzfu(zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfq zzfqVar) {
        this.zzb = zzgpVar;
        zzehVar.zzc(zzfqVar);
        this.zzc = zzehVar;
        this.zza = zzfqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzfu<T> zzb(zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfq zzfqVar) {
        return new zzfu<>(zzgpVar, zzehVar, zzfqVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final int zza(T t7) {
        return this.zzb.zza(t7).hashCode();
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final T zzd() {
        return (T) ((zzeo) ((zzeq) this.zza).zzj(5, null, null)).zzg();
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zze(T t7) {
        this.zzb.zze(t7);
        this.zzc.zzb(t7);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzf(T t7, T t8) {
        zzgd.zzf(this.zzb, t7, t8);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzg(T t7, byte[] bArr, int i8, int i9, zzdp zzdpVar) throws IOException {
        zzeq zzeqVar = (zzeq) t7;
        if (zzeqVar.zzc == zzgq.zza()) {
            zzeqVar.zzc = zzgq.zzc();
        }
        zzep zzepVar = (zzep) t7;
        throw null;
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzh(T t7, T t8) {
        if (!this.zzb.zza(t7).equals(this.zzb.zza(t8))) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzi(T t7) {
        this.zzc.zza(t7);
        throw null;
    }
}
