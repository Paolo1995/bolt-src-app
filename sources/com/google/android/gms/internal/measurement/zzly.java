package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzly {
    private static final Class zza;
    private static final zzmn zzb;
    private static final zzmn zzc;
    private static final zzmn zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzmp();
    }

    public static zzmn zzA() {
        return zzc;
    }

    public static zzmn zzB() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzC(int i8, List list, zzki zzkiVar, Object obj, zzmn zzmnVar) {
        if (zzkiVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i9 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                int intValue = ((Integer) list.get(i10)).intValue();
                if (zzkiVar.zza(intValue)) {
                    if (i10 != i9) {
                        list.set(i9, Integer.valueOf(intValue));
                    }
                    i9++;
                } else {
                    obj = zzD(i8, intValue, obj, zzmnVar);
                }
            }
            if (i9 != size) {
                list.subList(i9, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzkiVar.zza(intValue2)) {
                    obj = zzD(i8, intValue2, obj, zzmnVar);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static Object zzD(int i8, int i9, Object obj, zzmn zzmnVar) {
        if (obj == null) {
            obj = zzmnVar.zze();
        }
        zzmnVar.zzf(obj, i8, i9);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzE(zzjr zzjrVar, Object obj, Object obj2) {
        zzjrVar.zza(obj2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzF(zzmn zzmnVar, Object obj, Object obj2) {
        zzmnVar.zzh(obj, zzmnVar.zzd(zzmnVar.zzc(obj), zzmnVar.zzc(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzke.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzc(i8, list, z7);
        }
    }

    public static void zzI(int i8, List list, zznf zznfVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zze(i8, list);
        }
    }

    public static void zzJ(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzg(i8, list, z7);
        }
    }

    public static void zzK(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzj(i8, list, z7);
        }
    }

    public static void zzL(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzl(i8, list, z7);
        }
    }

    public static void zzM(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzn(i8, list, z7);
        }
    }

    public static void zzN(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzp(i8, list, z7);
        }
    }

    public static void zzO(int i8, List list, zznf zznfVar, zzlw zzlwVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((zzjm) zznfVar).zzq(i8, list.get(i9), zzlwVar);
            }
        }
    }

    public static void zzP(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzs(i8, list, z7);
        }
    }

    public static void zzQ(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzu(i8, list, z7);
        }
    }

    public static void zzR(int i8, List list, zznf zznfVar, zzlw zzlwVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((zzjm) zznfVar).zzv(i8, list.get(i9), zzlwVar);
            }
        }
    }

    public static void zzS(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzx(i8, list, z7);
        }
    }

    public static void zzT(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzz(i8, list, z7);
        }
    }

    public static void zzU(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzB(i8, list, z7);
        }
    }

    public static void zzV(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzD(i8, list, z7);
        }
    }

    public static void zzW(int i8, List list, zznf zznfVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzG(i8, list);
        }
    }

    public static void zzX(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzI(i8, list, z7);
        }
    }

    public static void zzY(int i8, List list, zznf zznfVar, boolean z7) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznfVar.zzK(i8, list, z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzZ(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjl.zzA(i8 << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzaa(zzlg zzlgVar, Object obj, Object obj2, long j8) {
        zzmx.zzs(obj, j8, zzlg.zzb(zzmx.zzf(obj, j8), zzmx.zzf(obj2, j8)));
    }

    private static zzmn zzab(boolean z7) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzmn) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z7));
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i8, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzjl.zzz(i8);
        for (int i9 = 0; i9 < list.size(); i9++) {
            zzz += zzjl.zzt((zzjd) list.get(i9));
        }
        return zzz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjl.zzz(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzv(zzkfVar.zze(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzv(((Integer) list.get(i9)).intValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjl.zzA(i8 << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjl.zzA(i8 << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i8, List list, zzlw zzlwVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += zzjl.zzu(i8, (zzll) list.get(i10), zzlwVar);
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzjl.zzz(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzv(zzkfVar.zze(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzv(((Integer) list.get(i9)).intValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(int i8, List list, boolean z7) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzjl.zzz(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(List list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzla) {
            zzla zzlaVar = (zzla) list;
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzB(zzlaVar.zza(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzB(((Long) list.get(i9)).longValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i8, Object obj, zzlw zzlwVar) {
        if (obj instanceof zzkr) {
            int zzA = zzjl.zzA(i8 << 3);
            int zza2 = ((zzkr) obj).zza();
            return zzA + zzjl.zzA(zza2) + zza2;
        }
        return zzjl.zzA(i8 << 3) + zzjl.zzx((zzll) obj, zzlwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i8, List list, zzlw zzlwVar) {
        int zzx;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjl.zzz(i8) * size;
        for (int i9 = 0; i9 < size; i9++) {
            Object obj = list.get(i9);
            if (obj instanceof zzkr) {
                zzx = zzjl.zzw((zzkr) obj);
            } else {
                zzx = zzjl.zzx((zzll) obj, zzlwVar);
            }
            zzz += zzx;
        }
        return zzz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzjl.zzz(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(List list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            i8 = 0;
            while (i9 < size) {
                int zze = zzkfVar.zze(i9);
                i8 += zzjl.zzA((zze >> 31) ^ (zze + zze));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                int intValue = ((Integer) list.get(i9)).intValue();
                i8 += zzjl.zzA((intValue >> 31) ^ (intValue + intValue));
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzjl.zzz(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(List list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzla) {
            zzla zzlaVar = (zzla) list;
            i8 = 0;
            while (i9 < size) {
                long zza2 = zzlaVar.zza(i9);
                i8 += zzjl.zzB((zza2 >> 63) ^ (zza2 + zza2));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                long longValue = ((Long) list.get(i9)).longValue();
                i8 += zzjl.zzB((longValue >> 63) ^ (longValue + longValue));
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i8, List list) {
        int zzy;
        int zzy2;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzjl.zzz(i8) * size;
        if (list instanceof zzkt) {
            zzkt zzktVar = (zzkt) list;
            while (i9 < size) {
                Object zzf = zzktVar.zzf(i9);
                if (zzf instanceof zzjd) {
                    zzy2 = zzjl.zzt((zzjd) zzf);
                } else {
                    zzy2 = zzjl.zzy((String) zzf);
                }
                zzz += zzy2;
                i9++;
            }
        } else {
            while (i9 < size) {
                Object obj = list.get(i9);
                if (obj instanceof zzjd) {
                    zzy = zzjl.zzt((zzjd) obj);
                } else {
                    zzy = zzjl.zzy((String) obj);
                }
                zzz += zzy;
                i9++;
            }
        }
        return zzz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzjl.zzz(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(List list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzA(zzkfVar.zze(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzA(((Integer) list.get(i9)).intValue());
                i9++;
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i8, List list, boolean z7) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzjl.zzz(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(List list) {
        int i8;
        int size = list.size();
        int i9 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzla) {
            zzla zzlaVar = (zzla) list;
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzB(zzlaVar.zza(i9));
                i9++;
            }
        } else {
            i8 = 0;
            while (i9 < size) {
                i8 += zzjl.zzB(((Long) list.get(i9)).longValue());
                i9++;
            }
        }
        return i8;
    }

    public static zzmn zzz() {
        return zzb;
    }
}
