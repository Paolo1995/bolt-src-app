package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzdw extends zzdz {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdw(byte[] bArr, int i8, int i9) {
        super(bArr);
        zzeb.zzi(0, i9, bArr.length);
        this.zzc = i9;
    }

    @Override // com.google.android.gms.internal.auth.zzdz, com.google.android.gms.internal.auth.zzeb
    public final byte zza(int i8) {
        int i9 = this.zzc;
        if (((i9 - (i8 + 1)) | i8) < 0) {
            if (i8 < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i8);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i8);
            sb2.append(", ");
            sb2.append(i9);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return this.zza[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzdz, com.google.android.gms.internal.auth.zzeb
    public final byte zzb(int i8) {
        return this.zza[i8];
    }

    @Override // com.google.android.gms.internal.auth.zzdz
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzdz, com.google.android.gms.internal.auth.zzeb
    public final int zzd() {
        return this.zzc;
    }
}
