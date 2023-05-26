package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.1.0 */
/* loaded from: classes.dex */
final class zzdv extends zzch {
    private final com.google.android.gms.measurement.internal.zzhf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(com.google.android.gms.measurement.internal.zzhf zzhfVar) {
        this.zza = zzhfVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final void zze(String str, String str2, Bundle bundle, long j8) {
        this.zza.onEvent(str, str2, bundle, j8);
    }
}
