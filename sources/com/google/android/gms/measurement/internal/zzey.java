package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzey implements Runnable {
    private final zzew zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzey(String str, zzew zzewVar, int i8, Throwable th, byte[] bArr, Map map, zzex zzexVar) {
        Preconditions.checkNotNull(zzewVar);
        this.zza = zzewVar;
        this.zzb = i8;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
