package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpi;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzgr implements Callable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgw zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgr(zzgw zzgwVar, zzaw zzawVar, String str) {
        this.zzc = zzgwVar;
        this.zza = zzawVar;
        this.zzb = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlf zzlfVar;
        zzlf zzlfVar2;
        byte[] bArr;
        zzlf zzlfVar3;
        zzlk zzlkVar;
        zzh zzhVar;
        com.google.android.gms.internal.measurement.zzfz zzfzVar;
        String str;
        Bundle bundle;
        com.google.android.gms.internal.measurement.zzgb zzgbVar;
        String str2;
        zzas zzc;
        long j8;
        zzlfVar = this.zzc.zza;
        zzlfVar.zzA();
        zzlfVar2 = this.zzc.zza;
        zzio zzr = zzlfVar2.zzr();
        zzaw zzawVar = this.zza;
        String str3 = this.zzb;
        zzr.zzg();
        zzge.zzO();
        Preconditions.checkNotNull(zzawVar);
        Preconditions.checkNotEmpty(str3);
        if (!zzr.zzs.zzf().zzs(str3, zzeh.zzS)) {
            zzr.zzs.zzay().zzc().zzb("Generating ScionPayload disabled. packageName", str3);
            return new byte[0];
        } else if (!"_iap".equals(zzawVar.zza) && !"_iapx".equals(zzawVar.zza)) {
            zzr.zzs.zzay().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str3, zzawVar.zza);
            return null;
        } else {
            com.google.android.gms.internal.measurement.zzfz zza = com.google.android.gms.internal.measurement.zzga.zza();
            zzr.zzf.zzi().zzw();
            try {
                zzh zzj = zzr.zzf.zzi().zzj(str3);
                if (zzj == null) {
                    zzr.zzs.zzay().zzc().zzb("Log and bundle not available. package_name", str3);
                    bArr = new byte[0];
                    zzlfVar3 = zzr.zzf;
                } else if (!zzj.zzai()) {
                    zzr.zzs.zzay().zzc().zzb("Log and bundle disabled. package_name", str3);
                    bArr = new byte[0];
                    zzlfVar3 = zzr.zzf;
                } else {
                    com.google.android.gms.internal.measurement.zzgb zzt = com.google.android.gms.internal.measurement.zzgc.zzt();
                    zzt.zzad(1);
                    zzt.zzZ("android");
                    if (!TextUtils.isEmpty(zzj.zzt())) {
                        zzt.zzD(zzj.zzt());
                    }
                    if (!TextUtils.isEmpty(zzj.zzv())) {
                        zzt.zzF((String) Preconditions.checkNotNull(zzj.zzv()));
                    }
                    if (!TextUtils.isEmpty(zzj.zzw())) {
                        zzt.zzG((String) Preconditions.checkNotNull(zzj.zzw()));
                    }
                    if (zzj.zzb() != -2147483648L) {
                        zzt.zzH((int) zzj.zzb());
                    }
                    zzt.zzV(zzj.zzm());
                    zzt.zzP(zzj.zzk());
                    String zzy = zzj.zzy();
                    String zzr2 = zzj.zzr();
                    if (!TextUtils.isEmpty(zzy)) {
                        zzt.zzU(zzy);
                    } else if (!TextUtils.isEmpty(zzr2)) {
                        zzt.zzC(zzr2);
                    }
                    zzai zzh = zzr.zzf.zzh(str3);
                    zzt.zzM(zzj.zzj());
                    if (zzr.zzs.zzJ() && zzr.zzs.zzf().zzt(zzt.zzap()) && zzh.zzi(zzah.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                        zzt.zzO(null);
                    }
                    zzt.zzL(zzh.zzh());
                    if (zzh.zzi(zzah.AD_STORAGE) && (!zzr.zzs.zzf().zzs(null, zzeh.zzaj) || zzj.zzah())) {
                        Pair zzd = zzr.zzf.zzs().zzd(zzj.zzt(), zzh);
                        if (zzj.zzah() && !TextUtils.isEmpty((CharSequence) zzd.first)) {
                            try {
                                zzt.zzae(zzio.zza((String) zzd.first, Long.toString(zzawVar.zzd)));
                                Object obj = zzd.second;
                                if (obj != null) {
                                    zzt.zzX(((Boolean) obj).booleanValue());
                                }
                            } catch (SecurityException e8) {
                                zzr.zzs.zzay().zzc().zzb("Resettable device id encryption failed", e8.getMessage());
                                bArr = new byte[0];
                                zzlfVar3 = zzr.zzf;
                            }
                        }
                    }
                    zzr.zzs.zzg().zzu();
                    zzt.zzN(Build.MODEL);
                    zzr.zzs.zzg().zzu();
                    zzt.zzY(Build.VERSION.RELEASE);
                    zzt.zzaj((int) zzr.zzs.zzg().zzb());
                    zzt.zzan(zzr.zzs.zzg().zzc());
                    try {
                        if (zzh.zzi(zzah.ANALYTICS_STORAGE) && zzj.zzu() != null) {
                            zzt.zzE(zzio.zza((String) Preconditions.checkNotNull(zzj.zzu()), Long.toString(zzawVar.zzd)));
                        }
                        if (!TextUtils.isEmpty(zzj.zzx())) {
                            zzt.zzT((String) Preconditions.checkNotNull(zzj.zzx()));
                        }
                        String zzt2 = zzj.zzt();
                        List zzu = zzr.zzf.zzi().zzu(zzt2);
                        Iterator it = zzu.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                zzlkVar = (zzlk) it.next();
                                if ("_lte".equals(zzlkVar.zzc)) {
                                    break;
                                }
                            } else {
                                zzlkVar = null;
                                break;
                            }
                        }
                        if (zzlkVar == null || zzlkVar.zze == null) {
                            zzlk zzlkVar2 = new zzlk(zzt2, "auto", "_lte", zzr.zzs.zzav().currentTimeMillis(), 0L);
                            zzu.add(zzlkVar2);
                            zzr.zzf.zzi().zzL(zzlkVar2);
                        }
                        zzlh zzu2 = zzr.zzf.zzu();
                        zzu2.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                        if (zzu2.zzs.zzg().zze()) {
                            String zzt3 = zzj.zzt();
                            Preconditions.checkNotNull(zzt3);
                            if (zzj.zzah() && zzu2.zzf.zzo().zzn(zzt3)) {
                                zzu2.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                                Iterator it2 = zzu.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    } else if ("_npa".equals(((zzlk) it2.next()).zzc)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                zzu.add(new zzlk(zzt3, "auto", "_npa", zzu2.zzs.zzav().currentTimeMillis(), 1L));
                            }
                        }
                        com.google.android.gms.internal.measurement.zzgl[] zzglVarArr = new com.google.android.gms.internal.measurement.zzgl[zzu.size()];
                        for (int i8 = 0; i8 < zzu.size(); i8++) {
                            com.google.android.gms.internal.measurement.zzgk zzd2 = com.google.android.gms.internal.measurement.zzgl.zzd();
                            zzd2.zzf(((zzlk) zzu.get(i8)).zzc);
                            zzd2.zzg(((zzlk) zzu.get(i8)).zzd);
                            zzr.zzf.zzu().zzu(zzd2, ((zzlk) zzu.get(i8)).zze);
                            zzglVarArr[i8] = (com.google.android.gms.internal.measurement.zzgl) zzd2.zzaE();
                        }
                        zzt.zzj(Arrays.asList(zzglVarArr));
                        zzev zzb = zzev.zzb(zzawVar);
                        zzr.zzs.zzv().zzL(zzb.zzd, zzr.zzf.zzi().zzi(str3));
                        zzr.zzs.zzv().zzM(zzb, zzr.zzs.zzf().zzd(str3));
                        Bundle bundle2 = zzb.zzd;
                        bundle2.putLong("_c", 1L);
                        zzr.zzs.zzay().zzc().zza("Marking in-app purchase as real-time");
                        bundle2.putLong("_r", 1L);
                        bundle2.putString("_o", zzawVar.zzc);
                        if (zzr.zzs.zzv().zzae(zzt.zzap())) {
                            zzr.zzs.zzv().zzO(bundle2, "_dbg", 1L);
                            zzr.zzs.zzv().zzO(bundle2, "_r", 1L);
                        }
                        zzas zzn = zzr.zzf.zzi().zzn(str3, zzawVar.zza);
                        if (zzn == null) {
                            zzgbVar = zzt;
                            zzhVar = zzj;
                            zzfzVar = zza;
                            str = str3;
                            bundle = bundle2;
                            str2 = null;
                            zzc = new zzas(str3, zzawVar.zza, 0L, 0L, 0L, zzawVar.zzd, 0L, null, null, null, null);
                            j8 = 0;
                        } else {
                            zzhVar = zzj;
                            zzfzVar = zza;
                            str = str3;
                            bundle = bundle2;
                            zzgbVar = zzt;
                            str2 = null;
                            long j9 = zzn.zzf;
                            zzc = zzn.zzc(zzawVar.zzd);
                            j8 = j9;
                        }
                        zzr.zzf.zzi().zzE(zzc);
                        zzar zzarVar = new zzar(zzr.zzs, zzawVar.zzc, str, zzawVar.zza, zzawVar.zzd, j8, bundle);
                        com.google.android.gms.internal.measurement.zzfr zze = com.google.android.gms.internal.measurement.zzfs.zze();
                        zze.zzm(zzarVar.zzd);
                        zze.zzi(zzarVar.zzb);
                        zze.zzl(zzarVar.zze);
                        zzat zzatVar = new zzat(zzarVar.zzf);
                        while (zzatVar.hasNext()) {
                            String next = zzatVar.next();
                            com.google.android.gms.internal.measurement.zzfv zze2 = com.google.android.gms.internal.measurement.zzfw.zze();
                            zze2.zzj(next);
                            Object zzf = zzarVar.zzf.zzf(next);
                            if (zzf != null) {
                                zzr.zzf.zzu().zzt(zze2, zzf);
                                zze.zze(zze2);
                            }
                        }
                        com.google.android.gms.internal.measurement.zzgb zzgbVar2 = zzgbVar;
                        zzgbVar2.zzk(zze);
                        com.google.android.gms.internal.measurement.zzgd zza2 = com.google.android.gms.internal.measurement.zzgf.zza();
                        com.google.android.gms.internal.measurement.zzft zza3 = com.google.android.gms.internal.measurement.zzfu.zza();
                        zza3.zza(zzc.zzc);
                        zza3.zzb(zzawVar.zza);
                        zza2.zza(zza3);
                        zzgbVar2.zzaa(zza2);
                        zzgbVar2.zzf(zzr.zzf.zzf().zza(zzhVar.zzt(), Collections.emptyList(), zzgbVar2.zzat(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                        if (zze.zzq()) {
                            zzgbVar2.zzai(zze.zzc());
                            zzgbVar2.zzQ(zze.zzc());
                        }
                        long zzn2 = zzhVar.zzn();
                        int i9 = (zzn2 > 0L ? 1 : (zzn2 == 0L ? 0 : -1));
                        if (i9 != 0) {
                            zzgbVar2.zzab(zzn2);
                        }
                        long zzp = zzhVar.zzp();
                        if (zzp != 0) {
                            zzgbVar2.zzac(zzp);
                        } else if (i9 != 0) {
                            zzgbVar2.zzac(zzn2);
                        }
                        String zzB = zzhVar.zzB();
                        zzpi.zzc();
                        if (zzr.zzs.zzf().zzs(str2, zzeh.zzay) && zzB != null) {
                            zzgbVar2.zzah(zzB);
                        }
                        zzhVar.zzE();
                        zzgbVar2.zzI((int) zzhVar.zzo());
                        zzr.zzs.zzf().zzh();
                        zzgbVar2.zzal(68000L);
                        zzgbVar2.zzak(zzr.zzs.zzav().currentTimeMillis());
                        zzgbVar2.zzag(true);
                        if (zzr.zzs.zzf().zzs(str2, zzeh.zzaG)) {
                            zzr.zzf.zzC(zzgbVar2.zzap(), zzgbVar2);
                        }
                        com.google.android.gms.internal.measurement.zzfz zzfzVar2 = zzfzVar;
                        zzfzVar2.zza(zzgbVar2);
                        zzh zzhVar2 = zzhVar;
                        zzhVar2.zzab(zzgbVar2.zzd());
                        zzhVar2.zzZ(zzgbVar2.zzc());
                        zzr.zzf.zzi().zzD(zzhVar2);
                        zzr.zzf.zzi().zzC();
                        try {
                            return zzr.zzf.zzu().zzy(((com.google.android.gms.internal.measurement.zzga) zzfzVar2.zzaE()).zzbv());
                        } catch (IOException e9) {
                            zzr.zzs.zzay().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzeu.zzn(str), e9);
                            return str2;
                        }
                    } catch (SecurityException e10) {
                        zzr.zzs.zzay().zzc().zzb("app instance id encryption failed", e10.getMessage());
                        bArr = new byte[0];
                        zzlfVar3 = zzr.zzf;
                    }
                }
                zzlfVar3.zzi().zzx();
                return bArr;
            } finally {
                zzr.zzf.zzi().zzx();
            }
        }
    }
}
