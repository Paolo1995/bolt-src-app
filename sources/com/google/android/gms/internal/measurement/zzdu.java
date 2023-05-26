package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.1.0 */
/* loaded from: classes.dex */
final class zzdu extends zzch {
    private final com.google.android.gms.measurement.internal.zzhe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(com.google.android.gms.measurement.internal.zzhe zzheVar) {
        this.zza = zzheVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final void zze(String str, String str2, Bundle bundle, long j8) {
        this.zza.interceptEvent(str, str2, bundle, j8);
    }
}
