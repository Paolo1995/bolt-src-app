package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public class zzja extends zziz {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzja(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjd) || zzd() != ((zzjd) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzja) {
            zzja zzjaVar = (zzja) obj;
            int zzk = zzk();
            int zzk2 = zzjaVar.zzk();
            if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzjaVar.zzd()) {
                if (zzd <= zzjaVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzjaVar.zza;
                    zzjaVar.zzc();
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
                int zzd2 = zzjaVar.zzd();
                throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd2);
            }
            int zzd3 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd3);
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public byte zza(int i8) {
        return this.zza[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjd
    public byte zzb(int i8) {
        return this.zza[i8];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    protected final int zze(int i8, int i9, int i10) {
        return zzkm.zzd(i8, this.zza, 0, i10);
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final zzjd zzf(int i8, int i9) {
        int zzj = zzjd.zzj(0, i9, zzd());
        if (zzj == 0) {
            return zzjd.zzb;
        }
        return new zzix(this.zza, 0, zzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjd
    public final void zzh(zzit zzitVar) throws IOException {
        ((zzji) zzitVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final boolean zzi() {
        return zznc.zzf(this.zza, 0, zzd());
    }
}
