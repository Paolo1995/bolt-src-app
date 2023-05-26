package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzaf extends zzah {
    final /* synthetic */ zzag zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzag zzagVar) {
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzc(boolean z7) {
        Status status;
        zzag zzagVar = this.zza;
        if (z7) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzal.zza;
        }
        zzagVar.setResult((zzag) new zzak(status));
    }
}
