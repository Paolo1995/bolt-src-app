package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzei extends zzka implements zzlm {
    private zzei() {
        super(zzej.zzd());
    }

    public final int zza() {
        return ((zzej) this.zza).zza();
    }

    public final zzei zzb(String str) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzej.zzi((zzej) this.zza, str);
        return this;
    }

    public final zzei zzc(int i8, zzel zzelVar) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzej.zzj((zzej) this.zza, i8, zzelVar);
        return this;
    }

    public final zzel zzd(int i8) {
        return ((zzej) this.zza).zze(i8);
    }

    public final String zze() {
        return ((zzej) this.zza).zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzei(zzef zzefVar) {
        super(zzej.zzd());
    }
}
