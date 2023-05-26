package com.google.android.gms.measurement.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzkw implements zzew {
    final /* synthetic */ String zza;
    final /* synthetic */ zzlf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(zzlf zzlfVar, String str) {
        this.zzb = zzlfVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzew
    public final void zza(String str, int i8, Throwable th, byte[] bArr, Map map) {
        this.zzb.zzK(i8, th, bArr, this.zza);
    }
}
