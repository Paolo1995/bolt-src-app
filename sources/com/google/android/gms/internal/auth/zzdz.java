package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public class zzdz extends zzdy {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdz(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.auth.zzeb
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeb) || zzd() != ((zzeb) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzdz) {
            zzdz zzdzVar = (zzdz) obj;
            int zzj = zzj();
            int zzj2 = zzdzVar.zzj();
            if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzdzVar.zzd()) {
                if (zzd <= zzdzVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzdzVar.zza;
                    zzdzVar.zzc();
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < zzd) {
                        if (bArr[i8] != bArr2[i9]) {
                            return false;
                        }
                        i8++;
                        i9++;
                    }
                    return true;
                }
                int zzd2 = zzdzVar.zzd();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: 0, ");
                sb.append(zzd);
                sb.append(", ");
                sb.append(zzd2);
                throw new IllegalArgumentException(sb.toString());
            }
            int zzd3 = zzd();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(zzd);
            sb2.append(zzd3);
            throw new IllegalArgumentException(sb2.toString());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.auth.zzeb
    public byte zza(int i8) {
        return this.zza[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzeb
    public byte zzb(int i8) {
        return this.zza[i8];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzeb
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.auth.zzeb
    protected final int zze(int i8, int i9, int i10) {
        return zzev.zzd(i8, this.zza, 0, i10);
    }

    @Override // com.google.android.gms.internal.auth.zzeb
    public final zzeb zzf(int i8, int i9) {
        int zzi = zzeb.zzi(0, i9, zzd());
        if (zzi == 0) {
            return zzeb.zzb;
        }
        return new zzdw(this.zza, 0, zzi);
    }

    @Override // com.google.android.gms.internal.auth.zzeb
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.auth.zzeb
    public final boolean zzh() {
        return zzhd.zzd(this.zza, 0, zzd());
    }
}
