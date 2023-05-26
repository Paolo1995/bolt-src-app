package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzjf extends zzjh {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjf(byte[] bArr, int i8, int i9, boolean z7, zzje zzjeVar) {
        super(null);
        this.zze = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i8) throws zzko {
        int i9 = this.zze;
        this.zze = 0;
        int i10 = this.zzc + this.zzd;
        this.zzc = i10;
        if (i10 > 0) {
            this.zzd = i10;
            this.zzc = 0;
        } else {
            this.zzd = 0;
        }
        return i9;
    }
}
