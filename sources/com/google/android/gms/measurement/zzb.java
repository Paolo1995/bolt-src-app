package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzhe;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzik;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
final class zzb extends zzd {
    private final zzik zza;

    public zzb(zzik zzikVar) {
        super(null);
        Preconditions.checkNotNull(zzikVar);
        this.zza = zzikVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final int zza(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final long zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Boolean zzc() {
        return (Boolean) this.zza.zzg(4);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Double zzd() {
        return (Double) this.zza.zzg(2);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Integer zze() {
        return (Integer) this.zza.zzg(3);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Long zzf() {
        return (Long) this.zza.zzg(1);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final Object zzg(int i8) {
        return this.zza.zzg(i8);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final String zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final String zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final String zzj() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final String zzk() {
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final String zzl() {
        return (String) this.zza.zzg(0);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final List zzm(String str, String str2) {
        return this.zza.zzm(str, str2);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Map zzn(boolean z7) {
        return this.zza.zzo(null, null, z7);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final Map zzo(String str, String str2, boolean z7) {
        return this.zza.zzo(str, str2, z7);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzp(String str) {
        this.zza.zzp(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzq(String str, String str2, Bundle bundle) {
        this.zza.zzq(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzr(String str) {
        this.zza.zzr(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzs(String str, String str2, Bundle bundle) {
        this.zza.zzs(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzt(String str, String str2, Bundle bundle, long j8) {
        this.zza.zzt(str, str2, bundle, j8);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzu(zzhf zzhfVar) {
        this.zza.zzu(zzhfVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzv(Bundle bundle) {
        this.zza.zzv(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzw(zzhe zzheVar) {
        this.zza.zzw(zzheVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzik
    public final void zzx(zzhf zzhfVar) {
        this.zza.zzx(zzhfVar);
    }
}
