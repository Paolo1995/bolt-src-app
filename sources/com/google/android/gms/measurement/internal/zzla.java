package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzla implements zzlm {
    final /* synthetic */ zzlf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzla(zzlf zzlfVar) {
        this.zza = zzlfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(String str, String str2, Bundle bundle) {
        zzge zzgeVar;
        zzge zzgeVar2;
        if (TextUtils.isEmpty(str)) {
            zzlf zzlfVar = this.zza;
            zzgeVar = zzlfVar.zzn;
            if (zzgeVar != null) {
                zzgeVar2 = zzlfVar.zzn;
                zzgeVar2.zzay().zzd().zzb("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.zza.zzaz().zzp(new zzkz(this, str, "_err", bundle));
    }
}
