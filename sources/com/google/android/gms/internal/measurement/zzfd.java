package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzfd extends zzka implements zzlm {
    private zzfd() {
        super(zzfe.zzf());
    }

    public final int zza() {
        return ((zzfe) this.zza).zzb();
    }

    public final zzfc zzb(int i8) {
        return ((zzfe) this.zza).zzd(i8);
    }

    public final zzfd zzc() {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfe.zzp((zzfe) this.zza);
        return this;
    }

    public final zzfd zzd(int i8, zzfb zzfbVar) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfe.zzo((zzfe) this.zza, i8, (zzfc) zzfbVar.zzaE());
        return this;
    }

    public final String zze() {
        return ((zzfe) this.zza).zzi();
    }

    public final List zzf() {
        return Collections.unmodifiableList(((zzfe) this.zza).zzj());
    }

    public final List zzg() {
        return Collections.unmodifiableList(((zzfe) this.zza).zzk());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfd(zzey zzeyVar) {
        super(zzfe.zzf());
    }
}
