package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzjm implements zznf {
    private final zzjl zza;

    private zzjm(zzjl zzjlVar) {
        zzkm.zzf(zzjlVar, "output");
        this.zza = zzjlVar;
        zzjlVar.zza = this;
    }

    public static zzjm zza(zzjl zzjlVar) {
        zzjm zzjmVar = zzjlVar.zza;
        if (zzjmVar != null) {
            return zzjmVar;
        }
        return new zzjm(zzjlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzA(int i8, int i9) throws IOException {
        this.zza.zzp(i8, (i9 >> 31) ^ (i9 + i9));
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzB(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i10 += zzjl.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                zzjl zzjlVar = this.zza;
                int intValue2 = ((Integer) list.get(i9)).intValue();
                zzjlVar.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            zzjl zzjlVar2 = this.zza;
            int intValue3 = ((Integer) list.get(i9)).intValue();
            zzjlVar2.zzp(i8, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzC(int i8, long j8) throws IOException {
        this.zza.zzr(i8, (j8 >> 63) ^ (j8 + j8));
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzD(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                long longValue = ((Long) list.get(i11)).longValue();
                i10 += zzjl.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                zzjl zzjlVar = this.zza;
                long longValue2 = ((Long) list.get(i9)).longValue();
                zzjlVar.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            zzjl zzjlVar2 = this.zza;
            long longValue3 = ((Long) list.get(i9)).longValue();
            zzjlVar2.zzr(i8, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    @Deprecated
    public final void zzE(int i8) throws IOException {
        this.zza.zzo(i8, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzF(int i8, String str) throws IOException {
        this.zza.zzm(i8, str);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzG(int i8, List list) throws IOException {
        int i9 = 0;
        if (list instanceof zzkt) {
            zzkt zzktVar = (zzkt) list;
            while (i9 < list.size()) {
                Object zzf = zzktVar.zzf(i9);
                if (zzf instanceof String) {
                    this.zza.zzm(i8, (String) zzf);
                } else {
                    this.zza.zze(i8, (zzjd) zzf);
                }
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzm(i8, (String) list.get(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzH(int i8, int i9) throws IOException {
        this.zza.zzp(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzI(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += zzjl.zzA(((Integer) list.get(i11)).intValue());
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzq(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzp(i8, ((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzJ(int i8, long j8) throws IOException {
        this.zza.zzr(i8, j8);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzK(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += zzjl.zzB(((Long) list.get(i11)).longValue());
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzs(((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzr(i8, ((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzb(int i8, boolean z7) throws IOException {
        this.zza.zzd(i8, z7);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzc(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Boolean) list.get(i11)).booleanValue();
                i10++;
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i9)).booleanValue() ? (byte) 1 : (byte) 0);
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzd(i8, ((Boolean) list.get(i9)).booleanValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzd(int i8, zzjd zzjdVar) throws IOException {
        this.zza.zze(i8, zzjdVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zze(int i8, List list) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.zza.zze(i8, (zzjd) list.get(i9));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzf(int i8, double d8) throws IOException {
        this.zza.zzh(i8, Double.doubleToRawLongBits(d8));
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzg(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Double) list.get(i11)).doubleValue();
                i10 += 8;
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzh(i8, Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    @Deprecated
    public final void zzh(int i8) throws IOException {
        this.zza.zzo(i8, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzi(int i8, int i9) throws IOException {
        this.zza.zzj(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzj(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += zzjl.zzv(((Integer) list.get(i11)).intValue());
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzk(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzj(i8, ((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzk(int i8, int i9) throws IOException {
        this.zza.zzf(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzl(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Integer) list.get(i11)).intValue();
                i10 += 4;
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzg(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzf(i8, ((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzm(int i8, long j8) throws IOException {
        this.zza.zzh(i8, j8);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzn(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Long) list.get(i11)).longValue();
                i10 += 8;
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzi(((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzh(i8, ((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzo(int i8, float f8) throws IOException {
        this.zza.zzf(i8, Float.floatToRawIntBits(f8));
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzp(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Float) list.get(i11)).floatValue();
                i10 += 4;
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzf(i8, Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzq(int i8, Object obj, zzlw zzlwVar) throws IOException {
        zzjl zzjlVar = this.zza;
        zzjlVar.zzo(i8, 3);
        zzlwVar.zzi((zzll) obj, zzjlVar.zza);
        zzjlVar.zzo(i8, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzr(int i8, int i9) throws IOException {
        this.zza.zzj(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzs(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += zzjl.zzv(((Integer) list.get(i11)).intValue());
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzk(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzj(i8, ((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzt(int i8, long j8) throws IOException {
        this.zza.zzr(i8, j8);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzu(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                i10 += zzjl.zzB(((Long) list.get(i11)).longValue());
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzs(((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzr(i8, ((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzv(int i8, Object obj, zzlw zzlwVar) throws IOException {
        Object obj2 = (zzll) obj;
        zzji zzjiVar = (zzji) this.zza;
        zzjiVar.zzq((i8 << 3) | 2);
        zzin zzinVar = (zzin) obj2;
        int zzbr = zzinVar.zzbr();
        if (zzbr == -1) {
            zzbr = zzlwVar.zza(zzinVar);
            zzinVar.zzbu(zzbr);
        }
        zzjiVar.zzq(zzbr);
        zzlwVar.zzi(obj2, zzjiVar.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzw(int i8, int i9) throws IOException {
        this.zza.zzf(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzx(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Integer) list.get(i11)).intValue();
                i10 += 4;
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzg(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzf(i8, ((Integer) list.get(i9)).intValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzy(int i8, long j8) throws IOException {
        this.zza.zzh(i8, j8);
    }

    @Override // com.google.android.gms.internal.measurement.zznf
    public final void zzz(int i8, List list, boolean z7) throws IOException {
        int i9 = 0;
        if (z7) {
            this.zza.zzo(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Long) list.get(i11)).longValue();
                i10 += 8;
            }
            this.zza.zzq(i10);
            while (i9 < list.size()) {
                this.zza.zzi(((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        while (i9 < list.size()) {
            this.zza.zzh(i8, ((Long) list.get(i9)).longValue());
            i9++;
        }
    }
}
