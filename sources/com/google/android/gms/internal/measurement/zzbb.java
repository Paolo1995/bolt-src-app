package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzbb {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzap zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        String str2;
        char c8;
        String str3;
        double min;
        zzai zzaiVar;
        switch (str.hashCode()) {
            case -1776922004:
                str2 = "toString";
                if (str.equals(str2)) {
                    c8 = 18;
                    break;
                }
                c8 = 65535;
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str2 = "toString";
                    c8 = 0;
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    str2 = "toString";
                    c8 = 2;
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    c8 = '\n';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c8 = 17;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    c8 = 3;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c8 = 6;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c8 = 19;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c8 = 7;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c8 = '\b';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c8 = 5;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 3452698:
                if (str.equals("push")) {
                    c8 = '\t';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c8 = 15;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c8 = 16;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    str2 = "toString";
                    c8 = 1;
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c8 = '\r';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c8 = 14;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c8 = 11;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c8 = '\f';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c8 = 4;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c8 = 65535;
                break;
            default:
                str2 = "toString";
                c8 = 65535;
                break;
        }
        double d8 = 0.0d;
        switch (c8) {
            case 0:
                zzap zzd = zzaeVar.zzd();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzap zzb = zzgVar.zzb((zzap) it.next());
                        if (!(zzb instanceof zzag)) {
                            zzae zzaeVar2 = (zzae) zzd;
                            int zzc = zzaeVar2.zzc();
                            if (zzb instanceof zzae) {
                                zzae zzaeVar3 = (zzae) zzb;
                                Iterator zzk = zzaeVar3.zzk();
                                while (zzk.hasNext()) {
                                    Integer num = (Integer) zzk.next();
                                    zzaeVar2.zzq(num.intValue() + zzc, zzaeVar3.zze(num.intValue()));
                                }
                            } else {
                                zzaeVar2.zzq(zzc, zzb);
                            }
                        } else {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                    }
                }
                return zzd;
            case 1:
                zzh.zzh("every", 1, list);
                zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
                if (zzb2 instanceof zzao) {
                    if (zzaeVar.zzc() == 0) {
                        return zzap.zzk;
                    }
                    if (zzb(zzaeVar, zzgVar, (zzao) zzb2, Boolean.FALSE, Boolean.TRUE).zzc() != zzaeVar.zzc()) {
                        return zzap.zzl;
                    }
                    return zzap.zzk;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 2:
                zzh.zzh("filter", 1, list);
                zzap zzb3 = zzgVar.zzb((zzap) list.get(0));
                if (zzb3 instanceof zzao) {
                    if (zzaeVar.zzb() == 0) {
                        return new zzae();
                    }
                    zzap zzd2 = zzaeVar.zzd();
                    zzae zzb4 = zzb(zzaeVar, zzgVar, (zzao) zzb3, null, Boolean.TRUE);
                    zzae zzaeVar4 = new zzae();
                    Iterator zzk2 = zzb4.zzk();
                    while (zzk2.hasNext()) {
                        zzaeVar4.zzq(zzaeVar4.zzc(), ((zzae) zzd2).zze(((Integer) zzk2.next()).intValue()));
                    }
                    return zzaeVar4;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 3:
                zzh.zzh("forEach", 1, list);
                zzap zzb5 = zzgVar.zzb((zzap) list.get(0));
                if (zzb5 instanceof zzao) {
                    if (zzaeVar.zzb() == 0) {
                        return zzap.zzf;
                    }
                    zzb(zzaeVar, zzgVar, (zzao) zzb5, null, null);
                    return zzap.zzf;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 4:
                zzh.zzj("indexOf", 2, list);
                zzap zzapVar = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVar = zzgVar.zzb((zzap) list.get(0));
                }
                if (list.size() > 1) {
                    double zza = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (zza >= zzaeVar.zzc()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    if (zza < 0.0d) {
                        d8 = zzaeVar.zzc() + zza;
                    } else {
                        d8 = zza;
                    }
                }
                Iterator zzk3 = zzaeVar.zzk();
                while (zzk3.hasNext()) {
                    int intValue = ((Integer) zzk3.next()).intValue();
                    double d9 = intValue;
                    if (d9 >= d8 && zzh.zzl(zzaeVar.zze(intValue), zzapVar)) {
                        return new zzah(Double.valueOf(d9));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzj("join", 1, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzm;
                }
                if (!list.isEmpty()) {
                    zzap zzb6 = zzgVar.zzb((zzap) list.get(0));
                    if (!(zzb6 instanceof zzan) && !(zzb6 instanceof zzau)) {
                        str3 = zzb6.zzi();
                    } else {
                        str3 = "";
                    }
                } else {
                    str3 = ",";
                }
                return new zzat(zzaeVar.zzj(str3));
            case 6:
                zzh.zzj("lastIndexOf", 2, list);
                zzap zzapVar2 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVar2 = zzgVar.zzb((zzap) list.get(0));
                }
                double zzc2 = zzaeVar.zzc() - 1;
                if (list.size() > 1) {
                    zzap zzb7 = zzgVar.zzb((zzap) list.get(1));
                    zzc2 = Double.isNaN(zzb7.zzh().doubleValue()) ? zzaeVar.zzc() - 1 : zzh.zza(zzb7.zzh().doubleValue());
                    if (zzc2 < 0.0d) {
                        zzc2 += zzaeVar.zzc();
                    }
                }
                if (zzc2 < 0.0d) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int min2 = (int) Math.min(zzaeVar.zzc(), zzc2); min2 >= 0; min2--) {
                    if (zzaeVar.zzs(min2) && zzh.zzl(zzaeVar.zze(min2), zzapVar2)) {
                        return new zzah(Double.valueOf(min2));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zzh("map", 1, list);
                zzap zzb8 = zzgVar.zzb((zzap) list.get(0));
                if (zzb8 instanceof zzao) {
                    if (zzaeVar.zzc() == 0) {
                        return new zzae();
                    }
                    return zzb(zzaeVar, zzgVar, (zzao) zzb8, null, null);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case '\b':
                zzh.zzh("pop", 0, list);
                int zzc3 = zzaeVar.zzc();
                if (zzc3 == 0) {
                    return zzap.zzf;
                }
                int i8 = zzc3 - 1;
                zzap zze = zzaeVar.zze(i8);
                zzaeVar.zzp(i8);
                return zze;
            case '\t':
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzq(zzaeVar.zzc(), zzgVar.zzb((zzap) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            case '\n':
                return zzc(zzaeVar, zzgVar, list, true);
            case 11:
                return zzc(zzaeVar, zzgVar, list, false);
            case '\f':
                zzh.zzh("reverse", 0, list);
                int zzc4 = zzaeVar.zzc();
                if (zzc4 != 0) {
                    for (int i9 = 0; i9 < zzc4 / 2; i9++) {
                        if (zzaeVar.zzs(i9)) {
                            zzap zze2 = zzaeVar.zze(i9);
                            zzaeVar.zzq(i9, null);
                            int i10 = (zzc4 - 1) - i9;
                            if (zzaeVar.zzs(i10)) {
                                zzaeVar.zzq(i9, zzaeVar.zze(i10));
                            }
                            zzaeVar.zzq(i10, zze2);
                        }
                    }
                }
                return zzaeVar;
            case '\r':
                zzh.zzh("shift", 0, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzf;
                }
                zzap zze3 = zzaeVar.zze(0);
                zzaeVar.zzp(0);
                return zze3;
            case 14:
                zzh.zzj("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzd();
                }
                double zzc5 = zzaeVar.zzc();
                double zza2 = zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (zza2 < 0.0d) {
                    min = Math.max(zza2 + zzc5, 0.0d);
                } else {
                    min = Math.min(zza2, zzc5);
                }
                if (list.size() == 2) {
                    double zza3 = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (zza3 < 0.0d) {
                        zzc5 = Math.max(zzc5 + zza3, 0.0d);
                    } else {
                        zzc5 = Math.min(zzc5, zza3);
                    }
                }
                zzae zzaeVar5 = new zzae();
                for (int i11 = (int) min; i11 < zzc5; i11++) {
                    zzaeVar5.zzq(zzaeVar5.zzc(), zzaeVar.zze(i11));
                }
                return zzaeVar5;
            case 15:
                zzh.zzh("some", 1, list);
                zzap zzb9 = zzgVar.zzb((zzap) list.get(0));
                if (zzb9 instanceof zzai) {
                    if (zzaeVar.zzc() == 0) {
                        return zzap.zzl;
                    }
                    zzai zzaiVar2 = (zzai) zzb9;
                    Iterator zzk4 = zzaeVar.zzk();
                    while (zzk4.hasNext()) {
                        int intValue2 = ((Integer) zzk4.next()).intValue();
                        if (zzaeVar.zzs(intValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue2), new zzah(Double.valueOf(intValue2)), zzaeVar)).zzg().booleanValue()) {
                            return zzap.zzk;
                        }
                    }
                    return zzap.zzl;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 16:
                zzh.zzj("sort", 1, list);
                if (zzaeVar.zzc() >= 2) {
                    List<zzap> zzm = zzaeVar.zzm();
                    if (!list.isEmpty()) {
                        zzap zzb10 = zzgVar.zzb((zzap) list.get(0));
                        if (zzb10 instanceof zzai) {
                            zzaiVar = (zzai) zzb10;
                        } else {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                    } else {
                        zzaiVar = null;
                    }
                    Collections.sort(zzm, new zzba(zzaiVar, zzgVar));
                    zzaeVar.zzn();
                    int i12 = 0;
                    for (zzap zzapVar3 : zzm) {
                        zzaeVar.zzq(i12, zzapVar3);
                        i12++;
                    }
                }
                return zzaeVar;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int zza4 = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (zza4 < 0) {
                    zza4 = Math.max(0, zza4 + zzaeVar.zzc());
                } else if (zza4 > zzaeVar.zzc()) {
                    zza4 = zzaeVar.zzc();
                }
                int zzc6 = zzaeVar.zzc();
                zzae zzaeVar6 = new zzae();
                if (list.size() > 1) {
                    int max = Math.max(0, (int) zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                    if (max > 0) {
                        for (int i13 = zza4; i13 < Math.min(zzc6, zza4 + max); i13++) {
                            zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(zza4));
                            zzaeVar.zzp(zza4);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i14 = 2; i14 < list.size(); i14++) {
                            zzap zzb11 = zzgVar.zzb((zzap) list.get(i14));
                            if (!(zzb11 instanceof zzag)) {
                                zzaeVar.zzo((zza4 + i14) - 2, zzb11);
                            } else {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                        }
                    }
                } else {
                    while (zza4 < zzc6) {
                        zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(zza4));
                        zzaeVar.zzq(zza4, null);
                        zza4++;
                    }
                }
                return zzaeVar6;
            case 18:
                zzh.zzh(str2, 0, list);
                return new zzat(zzaeVar.zzj(","));
            case 19:
                if (!list.isEmpty()) {
                    zzae zzaeVar7 = new zzae();
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        zzap zzb12 = zzgVar.zzb((zzap) it3.next());
                        if (!(zzb12 instanceof zzag)) {
                            zzaeVar7.zzq(zzaeVar7.zzc(), zzb12);
                        } else {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                    }
                    int zzc7 = zzaeVar7.zzc();
                    Iterator zzk5 = zzaeVar.zzk();
                    while (zzk5.hasNext()) {
                        Integer num2 = (Integer) zzk5.next();
                        zzaeVar7.zzq(num2.intValue() + zzc7, zzaeVar.zze(num2.intValue()));
                    }
                    zzaeVar.zzn();
                    Iterator zzk6 = zzaeVar7.zzk();
                    while (zzk6.hasNext()) {
                        Integer num3 = (Integer) zzk6.next();
                        zzaeVar.zzq(num3.intValue(), zzaeVar7.zze(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzae zzb(zzae zzaeVar, zzg zzgVar, zzai zzaiVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator zzk = zzaeVar.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzaeVar.zzs(intValue)) {
                zzap zza = zzaiVar.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue), new zzah(Double.valueOf(intValue)), zzaeVar));
                if (zza.zzg().equals(bool)) {
                    return zzaeVar2;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzaeVar2.zzq(intValue, zza);
                }
            }
        }
        return zzaeVar2;
    }

    private static zzap zzc(zzae zzaeVar, zzg zzgVar, List list, boolean z7) {
        zzap zzapVar;
        int i8;
        int i9;
        zzh.zzi("reduce", 1, list);
        zzh.zzj("reduce", 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        if (zzb instanceof zzai) {
            if (list.size() == 2) {
                zzapVar = zzgVar.zzb((zzap) list.get(1));
                if (zzapVar instanceof zzag) {
                    throw new IllegalArgumentException("Failed to parse initial value");
                }
            } else if (zzaeVar.zzc() != 0) {
                zzapVar = null;
            } else {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzai zzaiVar = (zzai) zzb;
            int zzc = zzaeVar.zzc();
            if (z7) {
                i8 = 0;
            } else {
                i8 = zzc - 1;
            }
            int i10 = -1;
            if (z7) {
                i9 = zzc - 1;
            } else {
                i9 = 0;
            }
            if (true == z7) {
                i10 = 1;
            }
            if (zzapVar == null) {
                zzapVar = zzaeVar.zze(i8);
                i8 += i10;
            }
            while ((i9 - i8) * i10 >= 0) {
                if (zzaeVar.zzs(i8)) {
                    zzapVar = zzaiVar.zza(zzgVar, Arrays.asList(zzapVar, zzaeVar.zze(i8), new zzah(Double.valueOf(i8)), zzaeVar));
                    if (zzapVar instanceof zzag) {
                        throw new IllegalStateException("Reduce operation failed");
                    }
                    i8 += i10;
                } else {
                    i8 += i10;
                }
            }
            return zzapVar;
        }
        throw new IllegalArgumentException("Callback should be a method");
    }
}
