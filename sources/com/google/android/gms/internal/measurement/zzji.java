package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzji extends zzjl {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzji(byte[] bArr, int i8, int i9) {
        super(null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i9) | i9) >= 0) {
                this.zzb = bArr;
                this.zzd = 0;
                this.zzc = i9;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i9)));
        }
        throw new NullPointerException("buffer");
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzb(byte b8) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i8 = this.zzd;
            this.zzd = i8 + 1;
            bArr[i8] = b8;
        } catch (IndexOutOfBoundsException e8) {
            throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e8);
        }
    }

    public final void zzc(byte[] bArr, int i8, int i9) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i9);
            this.zzd += i9;
        } catch (IndexOutOfBoundsException e8) {
            throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i9)), e8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzd(int i8, boolean z7) throws IOException {
        zzq(i8 << 3);
        zzb(z7 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zze(int i8, zzjd zzjdVar) throws IOException {
        zzq((i8 << 3) | 2);
        zzq(zzjdVar.zzd());
        zzjdVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzf(int i8, int i9) throws IOException {
        zzq((i8 << 3) | 5);
        zzg(i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzg(int i8) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i9 = this.zzd;
            int i10 = i9 + 1;
            bArr[i9] = (byte) (i8 & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((i8 >> 8) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((i8 >> 16) & 255);
            this.zzd = i12 + 1;
            bArr[i12] = (byte) ((i8 >> 24) & 255);
        } catch (IndexOutOfBoundsException e8) {
            throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzh(int i8, long j8) throws IOException {
        zzq((i8 << 3) | 1);
        zzi(j8);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzi(long j8) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i8 = this.zzd;
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((int) j8) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j8 >> 8)) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) (j8 >> 16)) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (((int) (j8 >> 24)) & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
            this.zzd = i15 + 1;
            bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e8) {
            throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzj(int i8, int i9) throws IOException {
        zzq(i8 << 3);
        zzk(i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzk(int i8) throws IOException {
        if (i8 >= 0) {
            zzq(i8);
        } else {
            zzs(i8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzl(byte[] bArr, int i8, int i9) throws IOException {
        zzc(bArr, 0, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzm(int i8, String str) throws IOException {
        zzq((i8 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i8 = this.zzd;
        try {
            int zzA = zzjl.zzA(str.length() * 3);
            int zzA2 = zzjl.zzA(str.length());
            if (zzA2 == zzA) {
                int i9 = i8 + zzA2;
                this.zzd = i9;
                int zzb = zznc.zzb(str, this.zzb, i9, this.zzc - i9);
                this.zzd = i8;
                zzq((zzb - i8) - zzA2);
                this.zzd = zzb;
                return;
            }
            zzq(zznc.zzc(str));
            byte[] bArr = this.zzb;
            int i10 = this.zzd;
            this.zzd = zznc.zzb(str, bArr, i10, this.zzc - i10);
        } catch (zznb e8) {
            this.zzd = i8;
            zzE(str, e8);
        } catch (IndexOutOfBoundsException e9) {
            throw new zzjj(e9);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzo(int i8, int i9) throws IOException {
        zzq((i8 << 3) | i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzp(int i8, int i9) throws IOException {
        zzq(i8 << 3);
        zzq(i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzq(int i8) throws IOException {
        while ((i8 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i9 = this.zzd;
                this.zzd = i9 + 1;
                bArr[i9] = (byte) ((i8 & 127) | 128);
                i8 >>>= 7;
            } catch (IndexOutOfBoundsException e8) {
                throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e8);
            }
        }
        byte[] bArr2 = this.zzb;
        int i10 = this.zzd;
        this.zzd = i10 + 1;
        bArr2[i10] = (byte) i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzr(int i8, long j8) throws IOException {
        zzq(i8 << 3);
        zzs(j8);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    public final void zzs(long j8) throws IOException {
        boolean z7;
        z7 = zzjl.zzc;
        if (z7 && this.zzc - this.zzd >= 10) {
            while ((j8 & (-128)) != 0) {
                byte[] bArr = this.zzb;
                int i8 = this.zzd;
                this.zzd = i8 + 1;
                zzmx.zzn(bArr, i8, (byte) ((((int) j8) & 127) | 128));
                j8 >>>= 7;
            }
            byte[] bArr2 = this.zzb;
            int i9 = this.zzd;
            this.zzd = i9 + 1;
            zzmx.zzn(bArr2, i9, (byte) j8);
            return;
        }
        while ((j8 & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zzb;
                int i10 = this.zzd;
                this.zzd = i10 + 1;
                bArr3[i10] = (byte) ((((int) j8) & 127) | 128);
                j8 >>>= 7;
            } catch (IndexOutOfBoundsException e8) {
                throw new zzjj(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e8);
            }
        }
        byte[] bArr4 = this.zzb;
        int i11 = this.zzd;
        this.zzd = i11 + 1;
        bArr4[i11] = (byte) j8;
    }
}
