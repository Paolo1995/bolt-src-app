package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzh {
    private long zzA;
    private String zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private final zzge zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private String zzq;
    private Boolean zzr;
    private long zzs;
    private List zzt;
    private String zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(zzge zzgeVar, String str) {
        Preconditions.checkNotNull(zzgeVar);
        Preconditions.checkNotEmpty(str);
        this.zza = zzgeVar;
        this.zzb = str;
        zzgeVar.zzaz().zzg();
    }

    public final String zzA() {
        this.zza.zzaz().zzg();
        return this.zze;
    }

    public final String zzB() {
        this.zza.zzaz().zzg();
        return this.zzu;
    }

    public final List zzC() {
        this.zza.zzaz().zzg();
        return this.zzt;
    }

    public final void zzD() {
        this.zza.zzaz().zzg();
        this.zzC = false;
    }

    public final void zzE() {
        this.zza.zzaz().zzg();
        long j8 = this.zzg + 1;
        if (j8 > 2147483647L) {
            this.zza.zzay().zzk().zzb("Bundle index overflow. appId", zzeu.zzn(this.zzb));
            j8 = 0;
        }
        this.zzC = true;
        this.zzg = j8;
    }

    public final void zzF(String str) {
        this.zza.zzaz().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ zzg.zza(this.zzq, str);
        this.zzq = str;
    }

    public final void zzG(boolean z7) {
        boolean z8;
        this.zza.zzaz().zzg();
        boolean z9 = this.zzC;
        if (this.zzp != z7) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.zzC = z9 | z8;
        this.zzp = z7;
    }

    public final void zzH(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzc, str);
        this.zzc = str;
    }

    public final void zzI(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzl, str);
        this.zzl = str;
    }

    public final void zzJ(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzj, str);
        this.zzj = str;
    }

    public final void zzK(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzk != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzk = j8;
    }

    public final void zzL(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzD != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzD = j8;
    }

    public final void zzM(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzy != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzy = j8;
    }

    public final void zzN(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzz != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzz = j8;
    }

    public final void zzO(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzx != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzx = j8;
    }

    public final void zzP(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzw != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzw = j8;
    }

    public final void zzQ(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzA != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzA = j8;
    }

    public final void zzR(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzv != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzv = j8;
    }

    public final void zzS(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzn != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzn = j8;
    }

    public final void zzT(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzs != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzs = j8;
    }

    public final void zzU(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzE != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzE = j8;
    }

    public final void zzV(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzf, str);
        this.zzf = str;
    }

    public final void zzW(String str) {
        this.zza.zzaz().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ zzg.zza(this.zzd, str);
        this.zzd = str;
    }

    public final void zzX(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzm != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzm = j8;
    }

    public final void zzY(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzB, str);
        this.zzB = str;
    }

    public final void zzZ(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzi != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzi = j8;
    }

    public final long zza() {
        this.zza.zzaz().zzg();
        return 0L;
    }

    public final void zzaa(long j8) {
        boolean z7;
        boolean z8 = true;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7);
        this.zza.zzaz().zzg();
        boolean z9 = this.zzC;
        if (this.zzg == j8) {
            z8 = false;
        }
        this.zzC = z8 | z9;
        this.zzg = j8;
    }

    public final void zzab(long j8) {
        boolean z7;
        this.zza.zzaz().zzg();
        boolean z8 = this.zzC;
        if (this.zzh != j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.zzC = z8 | z7;
        this.zzh = j8;
    }

    public final void zzac(boolean z7) {
        boolean z8;
        this.zza.zzaz().zzg();
        boolean z9 = this.zzC;
        if (this.zzo != z7) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.zzC = z9 | z8;
        this.zzo = z7;
    }

    public final void zzad(Boolean bool) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzr, bool);
        this.zzr = bool;
    }

    public final void zzae(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zze, str);
        this.zze = str;
    }

    public final void zzaf(List list) {
        ArrayList arrayList;
        this.zza.zzaz().zzg();
        if (!zzg.zza(this.zzt, list)) {
            this.zzC = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.zzt = arrayList;
        }
    }

    public final void zzag(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzu, str);
        this.zzu = str;
    }

    public final boolean zzah() {
        this.zza.zzaz().zzg();
        return this.zzp;
    }

    public final boolean zzai() {
        this.zza.zzaz().zzg();
        return this.zzo;
    }

    public final boolean zzaj() {
        this.zza.zzaz().zzg();
        return this.zzC;
    }

    public final long zzb() {
        this.zza.zzaz().zzg();
        return this.zzk;
    }

    public final long zzc() {
        this.zza.zzaz().zzg();
        return this.zzD;
    }

    public final long zzd() {
        this.zza.zzaz().zzg();
        return this.zzy;
    }

    public final long zze() {
        this.zza.zzaz().zzg();
        return this.zzz;
    }

    public final long zzf() {
        this.zza.zzaz().zzg();
        return this.zzx;
    }

    public final long zzg() {
        this.zza.zzaz().zzg();
        return this.zzw;
    }

    public final long zzh() {
        this.zza.zzaz().zzg();
        return this.zzA;
    }

    public final long zzi() {
        this.zza.zzaz().zzg();
        return this.zzv;
    }

    public final long zzj() {
        this.zza.zzaz().zzg();
        return this.zzn;
    }

    public final long zzk() {
        this.zza.zzaz().zzg();
        return this.zzs;
    }

    public final long zzl() {
        this.zza.zzaz().zzg();
        return this.zzE;
    }

    public final long zzm() {
        this.zza.zzaz().zzg();
        return this.zzm;
    }

    public final long zzn() {
        this.zza.zzaz().zzg();
        return this.zzi;
    }

    public final long zzo() {
        this.zza.zzaz().zzg();
        return this.zzg;
    }

    public final long zzp() {
        this.zza.zzaz().zzg();
        return this.zzh;
    }

    public final Boolean zzq() {
        this.zza.zzaz().zzg();
        return this.zzr;
    }

    public final String zzr() {
        this.zza.zzaz().zzg();
        return this.zzq;
    }

    public final String zzs() {
        this.zza.zzaz().zzg();
        String str = this.zzB;
        zzY(null);
        return str;
    }

    public final String zzt() {
        this.zza.zzaz().zzg();
        return this.zzb;
    }

    public final String zzu() {
        this.zza.zzaz().zzg();
        return this.zzc;
    }

    public final String zzv() {
        this.zza.zzaz().zzg();
        return this.zzl;
    }

    public final String zzw() {
        this.zza.zzaz().zzg();
        return this.zzj;
    }

    public final String zzx() {
        this.zza.zzaz().zzg();
        return this.zzf;
    }

    public final String zzy() {
        this.zza.zzaz().zzg();
        return this.zzd;
    }

    public final String zzz() {
        this.zza.zzaz().zzg();
        return this.zzB;
    }
}
