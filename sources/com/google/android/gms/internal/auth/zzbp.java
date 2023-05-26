package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzbp extends zzbd {
    final /* synthetic */ zzbq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbp(zzbq zzbqVar) {
        this.zza = zzbqVar;
    }

    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void zzb(ProxyResponse proxyResponse) {
        this.zza.setResult((zzbq) new zzbu(proxyResponse));
    }
}
