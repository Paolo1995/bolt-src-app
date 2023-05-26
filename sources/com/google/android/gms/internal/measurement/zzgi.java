package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzgi extends zzka implements zzlm {
    private zzgi() {
        super(zzgj.zze());
    }

    public final zzgi zza(Iterable iterable) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzgj.zzh((zzgj) this.zza, iterable);
        return this;
    }

    public final zzgi zzb(int i8) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzgj.zzg((zzgj) this.zza, i8);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgi(zzfj zzfjVar) {
        super(zzgj.zze());
    }
}
