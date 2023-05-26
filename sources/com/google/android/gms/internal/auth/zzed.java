package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzed extends zzee {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzed(byte[] bArr, int i8, int i9, boolean z7, zzec zzecVar) {
        super(null);
        this.zze = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i8) throws zzew {
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
