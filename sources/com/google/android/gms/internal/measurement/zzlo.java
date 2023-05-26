package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzlo<T> implements zzlw<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmx.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzll zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkz zzm;
    private final zzmn zzn;
    private final zzjr zzo;
    private final zzlq zzp;
    private final zzlg zzq;

    private zzlo(int[] iArr, Object[] objArr, int i8, int i9, zzll zzllVar, boolean z7, boolean z8, int[] iArr2, int i10, int i11, zzlq zzlqVar, zzkz zzkzVar, zzmn zzmnVar, zzjr zzjrVar, zzlg zzlgVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i8;
        this.zzf = i9;
        this.zzi = z7;
        boolean z9 = false;
        if (zzjrVar != null && zzjrVar.zzc(zzllVar)) {
            z9 = true;
        }
        this.zzh = z9;
        this.zzj = iArr2;
        this.zzk = i10;
        this.zzl = i11;
        this.zzp = zzlqVar;
        this.zzm = zzkzVar;
        this.zzn = zzmnVar;
        this.zzo = zzjrVar;
        this.zzg = zzllVar;
        this.zzq = zzlgVar;
    }

    private static int zzA(int i8) {
        return (i8 >>> 20) & 255;
    }

    private final int zzB(int i8) {
        return this.zzc[i8 + 1];
    }

    private static long zzC(Object obj, long j8) {
        return ((Long) zzmx.zzf(obj, j8)).longValue();
    }

    private final zzki zzD(int i8) {
        int i9 = i8 / 3;
        return (zzki) this.zzd[i9 + i9 + 1];
    }

    private final zzlw zzE(int i8) {
        int i9 = i8 / 3;
        int i10 = i9 + i9;
        zzlw zzlwVar = (zzlw) this.zzd[i10];
        if (zzlwVar != null) {
            return zzlwVar;
        }
        zzlw zzb2 = zzlt.zza().zzb((Class) this.zzd[i10 + 1]);
        this.zzd[i10] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i8) {
        int i9 = i8 / 3;
        return this.zzd[i9 + i9];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzH(Object obj, Object obj2, int i8) {
        long zzB = zzB(i8) & 1048575;
        if (!zzO(obj2, i8)) {
            return;
        }
        Object zzf = zzmx.zzf(obj, zzB);
        Object zzf2 = zzmx.zzf(obj2, zzB);
        if (zzf != null && zzf2 != null) {
            zzmx.zzs(obj, zzB, zzkm.zzg(zzf, zzf2));
            zzJ(obj, i8);
        } else if (zzf2 != null) {
            zzmx.zzs(obj, zzB, zzf2);
            zzJ(obj, i8);
        }
    }

    private final void zzI(Object obj, Object obj2, int i8) {
        Object obj3;
        int zzB = zzB(i8);
        int i9 = this.zzc[i8];
        long j8 = zzB & 1048575;
        if (!zzR(obj2, i9, i8)) {
            return;
        }
        if (zzR(obj, i9, i8)) {
            obj3 = zzmx.zzf(obj, j8);
        } else {
            obj3 = null;
        }
        Object zzf = zzmx.zzf(obj2, j8);
        if (obj3 != null && zzf != null) {
            zzmx.zzs(obj, j8, zzkm.zzg(obj3, zzf));
            zzK(obj, i9, i8);
        } else if (zzf != null) {
            zzmx.zzs(obj, j8, zzf);
            zzK(obj, i9, i8);
        }
    }

    private final void zzJ(Object obj, int i8) {
        int zzy = zzy(i8);
        long j8 = 1048575 & zzy;
        if (j8 == 1048575) {
            return;
        }
        zzmx.zzq(obj, j8, (1 << (zzy >>> 20)) | zzmx.zzc(obj, j8));
    }

    private final void zzK(Object obj, int i8, int i9) {
        zzmx.zzq(obj, zzy(i9) & 1048575, i8);
    }

    private final void zzL(Object obj, zznf zznfVar) throws IOException {
        int i8;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i9 = 1048575;
            int i10 = 0;
            int i11 = 0;
            int i12 = 1048575;
            while (i10 < length) {
                int zzB = zzB(i10);
                int[] iArr = this.zzc;
                int i13 = iArr[i10];
                int zzA = zzA(zzB);
                if (zzA <= 17) {
                    int i14 = iArr[i10 + 2];
                    int i15 = i14 & i9;
                    if (i15 != i12) {
                        i11 = unsafe.getInt(obj, i15);
                        i12 = i15;
                    }
                    i8 = 1 << (i14 >>> 20);
                } else {
                    i8 = 0;
                }
                long j8 = zzB & i9;
                switch (zzA) {
                    case 0:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzf(i13, zzmx.zza(obj, j8));
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 1:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzo(i13, zzmx.zzb(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 2:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzt(i13, unsafe.getLong(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 3:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzJ(i13, unsafe.getLong(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 4:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzr(i13, unsafe.getInt(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 5:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzm(i13, unsafe.getLong(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 6:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzk(i13, unsafe.getInt(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 7:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzb(i13, zzmx.zzw(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 8:
                        if ((i11 & i8) != 0) {
                            zzT(i13, unsafe.getObject(obj, j8), zznfVar);
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 9:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzv(i13, unsafe.getObject(obj, j8), zzE(i10));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 10:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzd(i13, (zzjd) unsafe.getObject(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 11:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzH(i13, unsafe.getInt(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 12:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzi(i13, unsafe.getInt(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 13:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzw(i13, unsafe.getInt(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 14:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzy(i13, unsafe.getLong(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 15:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzA(i13, unsafe.getInt(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 16:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzC(i13, unsafe.getLong(obj, j8));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 17:
                        if ((i11 & i8) != 0) {
                            zznfVar.zzq(i13, unsafe.getObject(obj, j8), zzE(i10));
                        } else {
                            continue;
                        }
                        i10 += 3;
                        i9 = 1048575;
                    case 18:
                        zzly.zzJ(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        continue;
                        i10 += 3;
                        i9 = 1048575;
                    case 19:
                        zzly.zzN(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        continue;
                        i10 += 3;
                        i9 = 1048575;
                    case 20:
                        zzly.zzQ(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        continue;
                        i10 += 3;
                        i9 = 1048575;
                    case 21:
                        zzly.zzY(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        continue;
                        i10 += 3;
                        i9 = 1048575;
                    case 22:
                        zzly.zzP(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        continue;
                        i10 += 3;
                        i9 = 1048575;
                    case 23:
                        zzly.zzM(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        continue;
                        i10 += 3;
                        i9 = 1048575;
                    case 24:
                        zzly.zzL(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        continue;
                        i10 += 3;
                        i9 = 1048575;
                    case 25:
                        zzly.zzH(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        continue;
                        i10 += 3;
                        i9 = 1048575;
                    case 26:
                        zzly.zzW(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar);
                        break;
                    case 27:
                        zzly.zzR(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, zzE(i10));
                        break;
                    case 28:
                        zzly.zzI(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar);
                        break;
                    case 29:
                        zzly.zzX(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        break;
                    case 30:
                        zzly.zzK(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        break;
                    case 31:
                        zzly.zzS(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        break;
                    case 32:
                        zzly.zzT(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        break;
                    case 33:
                        zzly.zzU(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        break;
                    case 34:
                        zzly.zzV(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, false);
                        break;
                    case 35:
                        zzly.zzJ(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 36:
                        zzly.zzN(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 37:
                        zzly.zzQ(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 38:
                        zzly.zzY(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 39:
                        zzly.zzP(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 40:
                        zzly.zzM(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 41:
                        zzly.zzL(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 42:
                        zzly.zzH(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 43:
                        zzly.zzX(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 44:
                        zzly.zzK(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 45:
                        zzly.zzS(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 46:
                        zzly.zzT(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 47:
                        zzly.zzU(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 48:
                        zzly.zzV(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, true);
                        break;
                    case 49:
                        zzly.zzO(this.zzc[i10], (List) unsafe.getObject(obj, j8), zznfVar, zzE(i10));
                        break;
                    case 50:
                        zzM(zznfVar, i13, unsafe.getObject(obj, j8), i10);
                        break;
                    case 51:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzf(i13, zzn(obj, j8));
                            break;
                        }
                        break;
                    case 52:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzo(i13, zzo(obj, j8));
                            break;
                        }
                        break;
                    case 53:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzt(i13, zzC(obj, j8));
                            break;
                        }
                        break;
                    case 54:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzJ(i13, zzC(obj, j8));
                            break;
                        }
                        break;
                    case 55:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzr(i13, zzr(obj, j8));
                            break;
                        }
                        break;
                    case 56:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzm(i13, zzC(obj, j8));
                            break;
                        }
                        break;
                    case 57:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzk(i13, zzr(obj, j8));
                            break;
                        }
                        break;
                    case 58:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzb(i13, zzS(obj, j8));
                            break;
                        }
                        break;
                    case 59:
                        if (zzR(obj, i13, i10)) {
                            zzT(i13, unsafe.getObject(obj, j8), zznfVar);
                            break;
                        }
                        break;
                    case 60:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzv(i13, unsafe.getObject(obj, j8), zzE(i10));
                            break;
                        }
                        break;
                    case 61:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzd(i13, (zzjd) unsafe.getObject(obj, j8));
                            break;
                        }
                        break;
                    case 62:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzH(i13, zzr(obj, j8));
                            break;
                        }
                        break;
                    case 63:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzi(i13, zzr(obj, j8));
                            break;
                        }
                        break;
                    case 64:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzw(i13, zzr(obj, j8));
                            break;
                        }
                        break;
                    case 65:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzy(i13, zzC(obj, j8));
                            break;
                        }
                        break;
                    case 66:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzA(i13, zzr(obj, j8));
                            break;
                        }
                        break;
                    case 67:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzC(i13, zzC(obj, j8));
                            break;
                        }
                        break;
                    case 68:
                        if (zzR(obj, i13, i10)) {
                            zznfVar.zzq(i13, unsafe.getObject(obj, j8), zzE(i10));
                            break;
                        }
                        break;
                }
                i10 += 3;
                i9 = 1048575;
            }
            zzmn zzmnVar = this.zzn;
            zzmnVar.zzi(zzmnVar.zzc(obj), zznfVar);
            return;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private final void zzM(zznf zznfVar, int i8, Object obj, int i9) throws IOException {
        if (obj == null) {
            return;
        }
        zzle zzleVar = (zzle) zzF(i9);
        throw null;
    }

    private final boolean zzN(Object obj, Object obj2, int i8) {
        if (zzO(obj, i8) == zzO(obj2, i8)) {
            return true;
        }
        return false;
    }

    private final boolean zzO(Object obj, int i8) {
        int zzy = zzy(i8);
        long j8 = zzy & 1048575;
        if (j8 == 1048575) {
            int zzB = zzB(i8);
            long j9 = zzB & 1048575;
            switch (zzA(zzB)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzmx.zza(obj, j9)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzmx.zzb(obj, j9)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzmx.zzd(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzmx.zzd(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzmx.zzc(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzmx.zzd(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzmx.zzc(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzmx.zzw(obj, j9);
                case 8:
                    Object zzf = zzmx.zzf(obj, j9);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    } else if (zzf instanceof zzjd) {
                        if (zzjd.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (zzmx.zzf(obj, j9) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzjd.zzb.equals(zzmx.zzf(obj, j9))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzmx.zzc(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzmx.zzc(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzmx.zzc(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzmx.zzd(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzmx.zzc(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzmx.zzd(obj, j9) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzmx.zzf(obj, j9) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzmx.zzc(obj, j8) & (1 << (zzy >>> 20))) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private final boolean zzP(Object obj, int i8, int i9, int i10, int i11) {
        if (i9 == 1048575) {
            return zzO(obj, i8);
        }
        if ((i10 & i11) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzQ(Object obj, int i8, zzlw zzlwVar) {
        return zzlwVar.zzk(zzmx.zzf(obj, i8 & 1048575));
    }

    private final boolean zzR(Object obj, int i8, int i9) {
        if (zzmx.zzc(obj, zzy(i9) & 1048575) == i8) {
            return true;
        }
        return false;
    }

    private static boolean zzS(Object obj, long j8) {
        return ((Boolean) zzmx.zzf(obj, j8)).booleanValue();
    }

    private static final void zzT(int i8, Object obj, zznf zznfVar) throws IOException {
        if (obj instanceof String) {
            zznfVar.zzF(i8, (String) obj);
        } else {
            zznfVar.zzd(i8, (zzjd) obj);
        }
    }

    static zzmo zzd(Object obj) {
        zzke zzkeVar = (zzke) obj;
        zzmo zzmoVar = zzkeVar.zzc;
        if (zzmoVar == zzmo.zzc()) {
            zzmo zze = zzmo.zze();
            zzkeVar.zzc = zze;
            return zze;
        }
        return zzmoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlo zzl(Class cls, zzli zzliVar, zzlq zzlqVar, zzkz zzkzVar, zzmn zzmnVar, zzjr zzjrVar, zzlg zzlgVar) {
        if (zzliVar instanceof zzlv) {
            return zzm((zzlv) zzliVar, zzlqVar, zzkzVar, zzmnVar, zzjrVar, zzlgVar);
        }
        zzmk zzmkVar = (zzmk) zzliVar;
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0385  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.measurement.zzlo zzm(com.google.android.gms.internal.measurement.zzlv r34, com.google.android.gms.internal.measurement.zzlq r35, com.google.android.gms.internal.measurement.zzkz r36, com.google.android.gms.internal.measurement.zzmn r37, com.google.android.gms.internal.measurement.zzjr r38, com.google.android.gms.internal.measurement.zzlg r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzm(com.google.android.gms.internal.measurement.zzlv, com.google.android.gms.internal.measurement.zzlq, com.google.android.gms.internal.measurement.zzkz, com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzjr, com.google.android.gms.internal.measurement.zzlg):com.google.android.gms.internal.measurement.zzlo");
    }

    private static double zzn(Object obj, long j8) {
        return ((Double) zzmx.zzf(obj, j8)).doubleValue();
    }

    private static float zzo(Object obj, long j8) {
        return ((Float) zzmx.zzf(obj, j8)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i8;
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int i9;
        int zzu;
        int zzi;
        int zzz;
        int zzA8;
        int i10;
        int zzA9;
        int zzA10;
        int zzA11;
        int zzB2;
        int zzA12;
        int zzd2;
        int zzA13;
        int i11;
        Unsafe unsafe = zzb;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1048575;
        while (i13 < this.zzc.length) {
            int zzB3 = zzB(i13);
            int[] iArr = this.zzc;
            int i17 = iArr[i13];
            int zzA14 = zzA(zzB3);
            if (zzA14 <= 17) {
                int i18 = iArr[i13 + 2];
                int i19 = i18 & i12;
                i8 = 1 << (i18 >>> 20);
                if (i19 != i16) {
                    i15 = unsafe.getInt(obj, i19);
                    i16 = i19;
                }
            } else {
                i8 = 0;
            }
            long j8 = zzB3 & i12;
            switch (zzA14) {
                case 0:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA = zzjl.zzA(i17 << 3);
                        zzA5 = zzA + 8;
                        i14 += zzA5;
                        break;
                    }
                case 1:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA2 = zzjl.zzA(i17 << 3);
                        zzA5 = zzA2 + 4;
                        i14 += zzA5;
                        break;
                    }
                case 2:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        long j9 = unsafe.getLong(obj, j8);
                        zzA3 = zzjl.zzA(i17 << 3);
                        zzB = zzjl.zzB(j9);
                        i14 += zzA3 + zzB;
                        break;
                    }
                case 3:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        long j10 = unsafe.getLong(obj, j8);
                        zzA3 = zzjl.zzA(i17 << 3);
                        zzB = zzjl.zzB(j10);
                        i14 += zzA3 + zzB;
                        break;
                    }
                case 4:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        int i20 = unsafe.getInt(obj, j8);
                        zzA4 = zzjl.zzA(i17 << 3);
                        zzv = zzjl.zzv(i20);
                        i9 = zzA4 + zzv;
                        i14 += i9;
                        break;
                    }
                case 5:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA = zzjl.zzA(i17 << 3);
                        zzA5 = zzA + 8;
                        i14 += zzA5;
                        break;
                    }
                case 6:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA2 = zzjl.zzA(i17 << 3);
                        zzA5 = zzA2 + 4;
                        i14 += zzA5;
                        break;
                    }
                case 7:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA5 = zzjl.zzA(i17 << 3) + 1;
                        i14 += zzA5;
                        break;
                    }
                case 8:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j8);
                        if (object instanceof zzjd) {
                            zzA6 = zzjl.zzA(i17 << 3);
                            zzd = ((zzjd) object).zzd();
                            zzA7 = zzjl.zzA(zzd);
                            i9 = zzA6 + zzA7 + zzd;
                            i14 += i9;
                            break;
                        } else {
                            zzA4 = zzjl.zzA(i17 << 3);
                            zzv = zzjl.zzy((String) object);
                            i9 = zzA4 + zzv;
                            i14 += i9;
                        }
                    }
                case 9:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA5 = zzly.zzo(i17, unsafe.getObject(obj, j8), zzE(i13));
                        i14 += zzA5;
                        break;
                    }
                case 10:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA6 = zzjl.zzA(i17 << 3);
                        zzd = ((zzjd) unsafe.getObject(obj, j8)).zzd();
                        zzA7 = zzjl.zzA(zzd);
                        i9 = zzA6 + zzA7 + zzd;
                        i14 += i9;
                        break;
                    }
                case 11:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        int i21 = unsafe.getInt(obj, j8);
                        zzA4 = zzjl.zzA(i17 << 3);
                        zzv = zzjl.zzA(i21);
                        i9 = zzA4 + zzv;
                        i14 += i9;
                        break;
                    }
                case 12:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        int i22 = unsafe.getInt(obj, j8);
                        zzA4 = zzjl.zzA(i17 << 3);
                        zzv = zzjl.zzv(i22);
                        i9 = zzA4 + zzv;
                        i14 += i9;
                        break;
                    }
                case 13:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA2 = zzjl.zzA(i17 << 3);
                        zzA5 = zzA2 + 4;
                        i14 += zzA5;
                        break;
                    }
                case 14:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA = zzjl.zzA(i17 << 3);
                        zzA5 = zzA + 8;
                        i14 += zzA5;
                        break;
                    }
                case 15:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        int i23 = unsafe.getInt(obj, j8);
                        zzA4 = zzjl.zzA(i17 << 3);
                        zzv = zzjl.zzA((i23 >> 31) ^ (i23 + i23));
                        i9 = zzA4 + zzv;
                        i14 += i9;
                        break;
                    }
                case 16:
                    if ((i8 & i15) == 0) {
                        break;
                    } else {
                        long j11 = unsafe.getLong(obj, j8);
                        i14 += zzjl.zzA(i17 << 3) + zzjl.zzB((j11 >> 63) ^ (j11 + j11));
                        break;
                    }
                case 17:
                    if ((i15 & i8) == 0) {
                        break;
                    } else {
                        zzA5 = zzjl.zzu(i17, (zzll) unsafe.getObject(obj, j8), zzE(i13));
                        i14 += zzA5;
                        break;
                    }
                case 18:
                    zzA5 = zzly.zzh(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzA5;
                    break;
                case 19:
                    zzA5 = zzly.zzf(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzA5;
                    break;
                case 20:
                    zzA5 = zzly.zzm(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzA5;
                    break;
                case 21:
                    zzA5 = zzly.zzx(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzA5;
                    break;
                case 22:
                    zzA5 = zzly.zzk(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzA5;
                    break;
                case 23:
                    zzA5 = zzly.zzh(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzA5;
                    break;
                case 24:
                    zzA5 = zzly.zzf(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzA5;
                    break;
                case 25:
                    zzA5 = zzly.zza(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzA5;
                    break;
                case 26:
                    zzu = zzly.zzu(i17, (List) unsafe.getObject(obj, j8));
                    i14 += zzu;
                    break;
                case 27:
                    zzu = zzly.zzp(i17, (List) unsafe.getObject(obj, j8), zzE(i13));
                    i14 += zzu;
                    break;
                case 28:
                    zzu = zzly.zzc(i17, (List) unsafe.getObject(obj, j8));
                    i14 += zzu;
                    break;
                case 29:
                    zzu = zzly.zzv(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzu;
                    break;
                case 30:
                    zzu = zzly.zzd(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzu;
                    break;
                case 31:
                    zzu = zzly.zzf(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzu;
                    break;
                case 32:
                    zzu = zzly.zzh(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzu;
                    break;
                case 33:
                    zzu = zzly.zzq(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzu;
                    break;
                case 34:
                    zzu = zzly.zzs(i17, (List) unsafe.getObject(obj, j8), false);
                    i14 += zzu;
                    break;
                case 35:
                    zzi = zzly.zzi((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 36:
                    zzi = zzly.zzg((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 37:
                    zzi = zzly.zzn((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 38:
                    zzi = zzly.zzy((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 39:
                    zzi = zzly.zzl((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 40:
                    zzi = zzly.zzi((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 41:
                    zzi = zzly.zzg((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 42:
                    zzi = zzly.zzb((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 43:
                    zzi = zzly.zzw((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 44:
                    zzi = zzly.zze((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 45:
                    zzi = zzly.zzg((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 46:
                    zzi = zzly.zzi((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 47:
                    zzi = zzly.zzr((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 48:
                    zzi = zzly.zzt((List) unsafe.getObject(obj, j8));
                    if (zzi > 0) {
                        zzz = zzjl.zzz(i17);
                        zzA8 = zzjl.zzA(zzi);
                        i10 = zzz + zzA8;
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 49:
                    zzu = zzly.zzj(i17, (List) unsafe.getObject(obj, j8), zzE(i13));
                    i14 += zzu;
                    break;
                case 50:
                    zzlg.zza(i17, unsafe.getObject(obj, j8), zzF(i13));
                    break;
                case 51:
                    if (zzR(obj, i17, i13)) {
                        zzA9 = zzjl.zzA(i17 << 3);
                        zzu = zzA9 + 8;
                        i14 += zzu;
                    }
                    break;
                case 52:
                    if (zzR(obj, i17, i13)) {
                        zzA10 = zzjl.zzA(i17 << 3);
                        zzu = zzA10 + 4;
                        i14 += zzu;
                    }
                    break;
                case 53:
                    if (zzR(obj, i17, i13)) {
                        long zzC = zzC(obj, j8);
                        zzA11 = zzjl.zzA(i17 << 3);
                        zzB2 = zzjl.zzB(zzC);
                        i14 += zzA11 + zzB2;
                    }
                    break;
                case 54:
                    if (zzR(obj, i17, i13)) {
                        long zzC2 = zzC(obj, j8);
                        zzA11 = zzjl.zzA(i17 << 3);
                        zzB2 = zzjl.zzB(zzC2);
                        i14 += zzA11 + zzB2;
                    }
                    break;
                case 55:
                    if (zzR(obj, i17, i13)) {
                        int zzr = zzr(obj, j8);
                        i10 = zzjl.zzA(i17 << 3);
                        zzi = zzjl.zzv(zzr);
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 56:
                    if (zzR(obj, i17, i13)) {
                        zzA9 = zzjl.zzA(i17 << 3);
                        zzu = zzA9 + 8;
                        i14 += zzu;
                    }
                    break;
                case 57:
                    if (zzR(obj, i17, i13)) {
                        zzA10 = zzjl.zzA(i17 << 3);
                        zzu = zzA10 + 4;
                        i14 += zzu;
                    }
                    break;
                case 58:
                    if (zzR(obj, i17, i13)) {
                        zzu = zzjl.zzA(i17 << 3) + 1;
                        i14 += zzu;
                    }
                    break;
                case 59:
                    if (zzR(obj, i17, i13)) {
                        Object object2 = unsafe.getObject(obj, j8);
                        if (object2 instanceof zzjd) {
                            zzA12 = zzjl.zzA(i17 << 3);
                            zzd2 = ((zzjd) object2).zzd();
                            zzA13 = zzjl.zzA(zzd2);
                            i11 = zzA12 + zzA13 + zzd2;
                            i14 += i11;
                        } else {
                            i10 = zzjl.zzA(i17 << 3);
                            zzi = zzjl.zzy((String) object2);
                            i11 = i10 + zzi;
                            i14 += i11;
                        }
                    }
                    break;
                case 60:
                    if (zzR(obj, i17, i13)) {
                        zzu = zzly.zzo(i17, unsafe.getObject(obj, j8), zzE(i13));
                        i14 += zzu;
                    }
                    break;
                case 61:
                    if (zzR(obj, i17, i13)) {
                        zzA12 = zzjl.zzA(i17 << 3);
                        zzd2 = ((zzjd) unsafe.getObject(obj, j8)).zzd();
                        zzA13 = zzjl.zzA(zzd2);
                        i11 = zzA12 + zzA13 + zzd2;
                        i14 += i11;
                    }
                    break;
                case 62:
                    if (zzR(obj, i17, i13)) {
                        int zzr2 = zzr(obj, j8);
                        i10 = zzjl.zzA(i17 << 3);
                        zzi = zzjl.zzA(zzr2);
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 63:
                    if (zzR(obj, i17, i13)) {
                        int zzr3 = zzr(obj, j8);
                        i10 = zzjl.zzA(i17 << 3);
                        zzi = zzjl.zzv(zzr3);
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 64:
                    if (zzR(obj, i17, i13)) {
                        zzA10 = zzjl.zzA(i17 << 3);
                        zzu = zzA10 + 4;
                        i14 += zzu;
                    }
                    break;
                case 65:
                    if (zzR(obj, i17, i13)) {
                        zzA9 = zzjl.zzA(i17 << 3);
                        zzu = zzA9 + 8;
                        i14 += zzu;
                    }
                    break;
                case 66:
                    if (zzR(obj, i17, i13)) {
                        int zzr4 = zzr(obj, j8);
                        i10 = zzjl.zzA(i17 << 3);
                        zzi = zzjl.zzA((zzr4 >> 31) ^ (zzr4 + zzr4));
                        i11 = i10 + zzi;
                        i14 += i11;
                    }
                    break;
                case 67:
                    if (zzR(obj, i17, i13)) {
                        long zzC3 = zzC(obj, j8);
                        i14 += zzjl.zzA(i17 << 3) + zzjl.zzB((zzC3 >> 63) ^ (zzC3 + zzC3));
                    }
                    break;
                case 68:
                    if (zzR(obj, i17, i13)) {
                        zzu = zzjl.zzu(i17, (zzll) unsafe.getObject(obj, j8), zzE(i13));
                        i14 += zzu;
                    }
                    break;
            }
            i13 += 3;
            i12 = 1048575;
        }
        zzmn zzmnVar = this.zzn;
        int zza2 = i14 + zzmnVar.zza(zzmnVar.zzc(obj));
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        return zza2;
    }

    private final int zzq(Object obj) {
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzv;
        int zzA5;
        int zzA6;
        int zzd;
        int zzA7;
        int zzo;
        int zzz;
        int zzA8;
        int i8;
        Unsafe unsafe = zzb;
        int i9 = 0;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzB2 = zzB(i10);
            int zzA9 = zzA(zzB2);
            int i11 = this.zzc[i10];
            long j8 = zzB2 & 1048575;
            if (zzA9 >= zzjw.zzJ.zza() && zzA9 <= zzjw.zzW.zza()) {
                int i12 = this.zzc[i10 + 2];
            }
            switch (zzA9) {
                case 0:
                    if (zzO(obj, i10)) {
                        zzA = zzjl.zzA(i11 << 3);
                        zzo = zzA + 8;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj, i10)) {
                        zzA2 = zzjl.zzA(i11 << 3);
                        zzo = zzA2 + 4;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj, i10)) {
                        long zzd2 = zzmx.zzd(obj, j8);
                        zzA3 = zzjl.zzA(i11 << 3);
                        zzB = zzjl.zzB(zzd2);
                        i9 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj, i10)) {
                        long zzd3 = zzmx.zzd(obj, j8);
                        zzA3 = zzjl.zzA(i11 << 3);
                        zzB = zzjl.zzB(zzd3);
                        i9 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj, i10)) {
                        int zzc = zzmx.zzc(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzv(zzc);
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj, i10)) {
                        zzA = zzjl.zzA(i11 << 3);
                        zzo = zzA + 8;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj, i10)) {
                        zzA2 = zzjl.zzA(i11 << 3);
                        zzo = zzA2 + 4;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj, i10)) {
                        zzA5 = zzjl.zzA(i11 << 3);
                        zzo = zzA5 + 1;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzO(obj, i10)) {
                        break;
                    } else {
                        Object zzf = zzmx.zzf(obj, j8);
                        if (zzf instanceof zzjd) {
                            zzA6 = zzjl.zzA(i11 << 3);
                            zzd = ((zzjd) zzf).zzd();
                            zzA7 = zzjl.zzA(zzd);
                            i8 = zzA6 + zzA7 + zzd;
                            i9 += i8;
                            break;
                        } else {
                            zzA4 = zzjl.zzA(i11 << 3);
                            zzv = zzjl.zzy((String) zzf);
                            i8 = zzA4 + zzv;
                            i9 += i8;
                        }
                    }
                case 9:
                    if (zzO(obj, i10)) {
                        zzo = zzly.zzo(i11, zzmx.zzf(obj, j8), zzE(i10));
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzO(obj, i10)) {
                        zzA6 = zzjl.zzA(i11 << 3);
                        zzd = ((zzjd) zzmx.zzf(obj, j8)).zzd();
                        zzA7 = zzjl.zzA(zzd);
                        i8 = zzA6 + zzA7 + zzd;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj, i10)) {
                        int zzc2 = zzmx.zzc(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzA(zzc2);
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj, i10)) {
                        int zzc3 = zzmx.zzc(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzv(zzc3);
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj, i10)) {
                        zzA2 = zzjl.zzA(i11 << 3);
                        zzo = zzA2 + 4;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj, i10)) {
                        zzA = zzjl.zzA(i11 << 3);
                        zzo = zzA + 8;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj, i10)) {
                        int zzc4 = zzmx.zzc(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzA((zzc4 >> 31) ^ (zzc4 + zzc4));
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj, i10)) {
                        long zzd4 = zzmx.zzd(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzB((zzd4 >> 63) ^ (zzd4 + zzd4));
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzO(obj, i10)) {
                        zzo = zzjl.zzu(i11, (zzll) zzmx.zzf(obj, j8), zzE(i10));
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzo = zzly.zzh(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 19:
                    zzo = zzly.zzf(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 20:
                    zzo = zzly.zzm(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 21:
                    zzo = zzly.zzx(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 22:
                    zzo = zzly.zzk(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 23:
                    zzo = zzly.zzh(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 24:
                    zzo = zzly.zzf(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 25:
                    zzo = zzly.zza(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 26:
                    zzo = zzly.zzu(i11, (List) zzmx.zzf(obj, j8));
                    i9 += zzo;
                    break;
                case 27:
                    zzo = zzly.zzp(i11, (List) zzmx.zzf(obj, j8), zzE(i10));
                    i9 += zzo;
                    break;
                case 28:
                    zzo = zzly.zzc(i11, (List) zzmx.zzf(obj, j8));
                    i9 += zzo;
                    break;
                case 29:
                    zzo = zzly.zzv(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 30:
                    zzo = zzly.zzd(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 31:
                    zzo = zzly.zzf(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 32:
                    zzo = zzly.zzh(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 33:
                    zzo = zzly.zzq(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 34:
                    zzo = zzly.zzs(i11, (List) zzmx.zzf(obj, j8), false);
                    i9 += zzo;
                    break;
                case 35:
                    zzv = zzly.zzi((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzly.zzg((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzly.zzn((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzly.zzy((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzly.zzl((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzly.zzi((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzly.zzg((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzly.zzb((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzly.zzw((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzly.zze((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzly.zzg((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzly.zzi((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzly.zzr((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzly.zzt((List) unsafe.getObject(obj, j8));
                    if (zzv > 0) {
                        zzz = zzjl.zzz(i11);
                        zzA8 = zzjl.zzA(zzv);
                        zzA4 = zzz + zzA8;
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzo = zzly.zzj(i11, (List) zzmx.zzf(obj, j8), zzE(i10));
                    i9 += zzo;
                    break;
                case 50:
                    zzlg.zza(i11, zzmx.zzf(obj, j8), zzF(i10));
                    break;
                case 51:
                    if (zzR(obj, i11, i10)) {
                        zzA = zzjl.zzA(i11 << 3);
                        zzo = zzA + 8;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i11, i10)) {
                        zzA2 = zzjl.zzA(i11 << 3);
                        zzo = zzA2 + 4;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i11, i10)) {
                        long zzC = zzC(obj, j8);
                        zzA3 = zzjl.zzA(i11 << 3);
                        zzB = zzjl.zzB(zzC);
                        i9 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i11, i10)) {
                        long zzC2 = zzC(obj, j8);
                        zzA3 = zzjl.zzA(i11 << 3);
                        zzB = zzjl.zzB(zzC2);
                        i9 += zzA3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i11, i10)) {
                        int zzr = zzr(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzv(zzr);
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i11, i10)) {
                        zzA = zzjl.zzA(i11 << 3);
                        zzo = zzA + 8;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i11, i10)) {
                        zzA2 = zzjl.zzA(i11 << 3);
                        zzo = zzA2 + 4;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i11, i10)) {
                        zzA5 = zzjl.zzA(i11 << 3);
                        zzo = zzA5 + 1;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzR(obj, i11, i10)) {
                        break;
                    } else {
                        Object zzf2 = zzmx.zzf(obj, j8);
                        if (zzf2 instanceof zzjd) {
                            zzA6 = zzjl.zzA(i11 << 3);
                            zzd = ((zzjd) zzf2).zzd();
                            zzA7 = zzjl.zzA(zzd);
                            i8 = zzA6 + zzA7 + zzd;
                            i9 += i8;
                            break;
                        } else {
                            zzA4 = zzjl.zzA(i11 << 3);
                            zzv = zzjl.zzy((String) zzf2);
                            i8 = zzA4 + zzv;
                            i9 += i8;
                        }
                    }
                case 60:
                    if (zzR(obj, i11, i10)) {
                        zzo = zzly.zzo(i11, zzmx.zzf(obj, j8), zzE(i10));
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i11, i10)) {
                        zzA6 = zzjl.zzA(i11 << 3);
                        zzd = ((zzjd) zzmx.zzf(obj, j8)).zzd();
                        zzA7 = zzjl.zzA(zzd);
                        i8 = zzA6 + zzA7 + zzd;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i11, i10)) {
                        int zzr2 = zzr(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzA(zzr2);
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i11, i10)) {
                        int zzr3 = zzr(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzv(zzr3);
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i11, i10)) {
                        zzA2 = zzjl.zzA(i11 << 3);
                        zzo = zzA2 + 4;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i11, i10)) {
                        zzA = zzjl.zzA(i11 << 3);
                        zzo = zzA + 8;
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i11, i10)) {
                        int zzr4 = zzr(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzA((zzr4 >> 31) ^ (zzr4 + zzr4));
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i11, i10)) {
                        long zzC3 = zzC(obj, j8);
                        zzA4 = zzjl.zzA(i11 << 3);
                        zzv = zzjl.zzB((zzC3 >> 63) ^ (zzC3 + zzC3));
                        i8 = zzA4 + zzv;
                        i9 += i8;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i11, i10)) {
                        zzo = zzjl.zzu(i11, (zzll) zzmx.zzf(obj, j8), zzE(i10));
                        i9 += zzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzmn zzmnVar = this.zzn;
        return i9 + zzmnVar.zza(zzmnVar.zzc(obj));
    }

    private static int zzr(Object obj, long j8) {
        return ((Integer) zzmx.zzf(obj, j8)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i8, int i9, int i10, long j8, zziq zziqVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i10);
        Object object = unsafe.getObject(obj, j8);
        if (!((zzlf) object).zze()) {
            zzlf zzb2 = zzlf.zza().zzb();
            zzlg.zzb(zzb2, object);
            unsafe.putObject(obj, j8, zzb2);
        }
        zzle zzleVar = (zzle) zzF;
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j8, int i15, zziq zziqVar) throws IOException {
        Unsafe unsafe = zzb;
        long j9 = this.zzc[i15 + 2] & 1048575;
        switch (i14) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(obj, j8, Double.valueOf(Double.longBitsToDouble(zzir.zzn(bArr, i8))));
                    unsafe.putInt(obj, j9, i11);
                    return i8 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(obj, j8, Float.valueOf(Float.intBitsToFloat(zzir.zzb(bArr, i8))));
                    unsafe.putInt(obj, j9, i11);
                    return i8 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm = zzir.zzm(bArr, i8, zziqVar);
                    unsafe.putObject(obj, j8, Long.valueOf(zziqVar.zzb));
                    unsafe.putInt(obj, j9, i11);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj = zzir.zzj(bArr, i8, zziqVar);
                    unsafe.putObject(obj, j8, Integer.valueOf(zziqVar.zza));
                    unsafe.putInt(obj, j9, i11);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(obj, j8, Long.valueOf(zzir.zzn(bArr, i8)));
                    unsafe.putInt(obj, j9, i11);
                    return i8 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj, j8, Integer.valueOf(zzir.zzb(bArr, i8)));
                    unsafe.putInt(obj, j9, i11);
                    return i8 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm2 = zzir.zzm(bArr, i8, zziqVar);
                    unsafe.putObject(obj, j8, Boolean.valueOf(zziqVar.zzb != 0));
                    unsafe.putInt(obj, j9, i11);
                    return zzm2;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj2 = zzir.zzj(bArr, i8, zziqVar);
                    int i16 = zziqVar.zza;
                    if (i16 == 0) {
                        unsafe.putObject(obj, j8, "");
                    } else if ((i13 & 536870912) != 0 && !zznc.zzf(bArr, zzj2, zzj2 + i16)) {
                        throw zzko.zzc();
                    } else {
                        unsafe.putObject(obj, j8, new String(bArr, zzj2, i16, zzkm.zzb));
                        zzj2 += i16;
                    }
                    unsafe.putInt(obj, j9, i11);
                    return zzj2;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd = zzir.zzd(zzE(i15), bArr, i8, i9, zziqVar);
                    Object object = unsafe.getInt(obj, j9) == i11 ? unsafe.getObject(obj, j8) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j8, zziqVar.zzc);
                    } else {
                        unsafe.putObject(obj, j8, zzkm.zzg(object, zziqVar.zzc));
                    }
                    unsafe.putInt(obj, j9, i11);
                    return zzd;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzir.zza(bArr, i8, zziqVar);
                    unsafe.putObject(obj, j8, zziqVar.zzc);
                    unsafe.putInt(obj, j9, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj3 = zzir.zzj(bArr, i8, zziqVar);
                    int i17 = zziqVar.zza;
                    zzki zzD = zzD(i15);
                    if (zzD != null && !zzD.zza(i17)) {
                        zzd(obj).zzh(i10, Long.valueOf(i17));
                    } else {
                        unsafe.putObject(obj, j8, Integer.valueOf(i17));
                        unsafe.putInt(obj, j9, i11);
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj4 = zzir.zzj(bArr, i8, zziqVar);
                    unsafe.putObject(obj, j8, Integer.valueOf(zzjh.zzb(zziqVar.zza)));
                    unsafe.putInt(obj, j9, i11);
                    return zzj4;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm3 = zzir.zzm(bArr, i8, zziqVar);
                    unsafe.putObject(obj, j8, Long.valueOf(zzjh.zzc(zziqVar.zzb)));
                    unsafe.putInt(obj, j9, i11);
                    return zzm3;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc = zzir.zzc(zzE(i15), bArr, i8, i9, (i10 & (-8)) | 4, zziqVar);
                    Object object2 = unsafe.getInt(obj, j9) == i11 ? unsafe.getObject(obj, j8) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj, j8, zziqVar.zzc);
                    } else {
                        unsafe.putObject(obj, j8, zzkm.zzg(object2, zziqVar.zzc));
                    }
                    unsafe.putInt(obj, j9, i11);
                    return zzc;
                }
                break;
        }
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02e7, code lost:
        if (r0 != r5) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02e9, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r1 = r20;
        r2 = r23;
        r6 = r26;
        r7 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02fd, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x032e, code lost:
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0351, code lost:
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzu(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zziq r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zziq):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x021a -> B:120:0x021b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x014f -> B:67:0x0150). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01cc -> B:100:0x01cd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzv(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zziq r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zziq):int");
    }

    private final int zzw(int i8) {
        if (i8 >= this.zze && i8 <= this.zzf) {
            return zzz(i8, 0);
        }
        return -1;
    }

    private final int zzx(int i8, int i9) {
        if (i8 >= this.zze && i8 <= this.zzf) {
            return zzz(i8, i9);
        }
        return -1;
    }

    private final int zzy(int i8) {
        return this.zzc[i8 + 2];
    }

    private final int zzz(int i8, int i9) {
        int length = (this.zzc.length / 3) - 1;
        while (i9 <= length) {
            int i10 = (length + i9) >>> 1;
            int i11 = i10 * 3;
            int i12 = this.zzc[i11];
            if (i8 == i12) {
                return i11;
            }
            if (i8 < i12) {
                length = i10 - 1;
            } else {
                i9 = i10 + 1;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zza(Object obj) {
        if (this.zzi) {
            return zzq(obj);
        }
        return zzp(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzb(Object obj) {
        int i8;
        int zzc;
        int length = this.zzc.length;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzB = zzB(i10);
            int i11 = this.zzc[i10];
            long j8 = 1048575 & zzB;
            int i12 = 37;
            switch (zzA(zzB)) {
                case 0:
                    i8 = i9 * 53;
                    zzc = zzkm.zzc(Double.doubleToLongBits(zzmx.zza(obj, j8)));
                    i9 = i8 + zzc;
                    break;
                case 1:
                    i8 = i9 * 53;
                    zzc = Float.floatToIntBits(zzmx.zzb(obj, j8));
                    i9 = i8 + zzc;
                    break;
                case 2:
                    i8 = i9 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j8));
                    i9 = i8 + zzc;
                    break;
                case 3:
                    i8 = i9 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j8));
                    i9 = i8 + zzc;
                    break;
                case 4:
                    i8 = i9 * 53;
                    zzc = zzmx.zzc(obj, j8);
                    i9 = i8 + zzc;
                    break;
                case 5:
                    i8 = i9 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j8));
                    i9 = i8 + zzc;
                    break;
                case 6:
                    i8 = i9 * 53;
                    zzc = zzmx.zzc(obj, j8);
                    i9 = i8 + zzc;
                    break;
                case 7:
                    i8 = i9 * 53;
                    zzc = zzkm.zza(zzmx.zzw(obj, j8));
                    i9 = i8 + zzc;
                    break;
                case 8:
                    i8 = i9 * 53;
                    zzc = ((String) zzmx.zzf(obj, j8)).hashCode();
                    i9 = i8 + zzc;
                    break;
                case 9:
                    Object zzf = zzmx.zzf(obj, j8);
                    if (zzf != null) {
                        i12 = zzf.hashCode();
                    }
                    i9 = (i9 * 53) + i12;
                    break;
                case 10:
                    i8 = i9 * 53;
                    zzc = zzmx.zzf(obj, j8).hashCode();
                    i9 = i8 + zzc;
                    break;
                case 11:
                    i8 = i9 * 53;
                    zzc = zzmx.zzc(obj, j8);
                    i9 = i8 + zzc;
                    break;
                case 12:
                    i8 = i9 * 53;
                    zzc = zzmx.zzc(obj, j8);
                    i9 = i8 + zzc;
                    break;
                case 13:
                    i8 = i9 * 53;
                    zzc = zzmx.zzc(obj, j8);
                    i9 = i8 + zzc;
                    break;
                case 14:
                    i8 = i9 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j8));
                    i9 = i8 + zzc;
                    break;
                case 15:
                    i8 = i9 * 53;
                    zzc = zzmx.zzc(obj, j8);
                    i9 = i8 + zzc;
                    break;
                case 16:
                    i8 = i9 * 53;
                    zzc = zzkm.zzc(zzmx.zzd(obj, j8));
                    i9 = i8 + zzc;
                    break;
                case 17:
                    Object zzf2 = zzmx.zzf(obj, j8);
                    if (zzf2 != null) {
                        i12 = zzf2.hashCode();
                    }
                    i9 = (i9 * 53) + i12;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i8 = i9 * 53;
                    zzc = zzmx.zzf(obj, j8).hashCode();
                    i9 = i8 + zzc;
                    break;
                case 50:
                    i8 = i9 * 53;
                    zzc = zzmx.zzf(obj, j8).hashCode();
                    i9 = i8 + zzc;
                    break;
                case 51:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzkm.zzc(Double.doubleToLongBits(zzn(obj, j8)));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = Float.floatToIntBits(zzo(obj, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzkm.zzc(zzC(obj, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzkm.zzc(zzC(obj, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzr(obj, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzkm.zzc(zzC(obj, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzr(obj, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzkm.zza(zzS(obj, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = ((String) zzmx.zzf(obj, j8)).hashCode();
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzmx.zzf(obj, j8).hashCode();
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzmx.zzf(obj, j8).hashCode();
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzr(obj, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzr(obj, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzr(obj, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzkm.zzc(zzC(obj, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzr(obj, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzkm.zzc(zzC(obj, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzmx.zzf(obj, j8).hashCode();
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i9 * 53) + this.zzn.zzc(obj).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzc(Object obj, byte[] bArr, int i8, int i9, int i10, zziq zziqVar) throws IOException {
        Unsafe unsafe;
        int i11;
        Object obj2;
        zzlo<T> zzloVar;
        byte b8;
        int zzw;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Object obj3;
        int i17;
        zziq zziqVar2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        zzlo<T> zzloVar2 = this;
        Object obj4 = obj;
        byte[] bArr2 = bArr;
        int i28 = i9;
        int i29 = i10;
        zziq zziqVar3 = zziqVar;
        Unsafe unsafe2 = zzb;
        int i30 = i8;
        int i31 = 0;
        int i32 = -1;
        int i33 = 0;
        int i34 = 0;
        int i35 = 1048575;
        while (true) {
            if (i30 < i28) {
                int i36 = i30 + 1;
                byte b9 = bArr2[i30];
                if (b9 < 0) {
                    int zzk = zzir.zzk(b9, bArr2, i36, zziqVar3);
                    b8 = zziqVar3.zza;
                    i36 = zzk;
                } else {
                    b8 = b9;
                }
                int i37 = b8 >>> 3;
                int i38 = b8 & 7;
                if (i37 > i32) {
                    zzw = zzloVar2.zzx(i37, i33 / 3);
                } else {
                    zzw = zzloVar2.zzw(i37);
                }
                if (zzw == -1) {
                    i12 = i37;
                    i13 = i36;
                    i14 = b8;
                    i15 = i34;
                    unsafe = unsafe2;
                    i11 = i29;
                    i16 = 0;
                } else {
                    int[] iArr = zzloVar2.zzc;
                    int i39 = iArr[zzw + 1];
                    int zzA = zzA(i39);
                    int i40 = i36;
                    long j8 = i39 & 1048575;
                    if (zzA <= 17) {
                        int i41 = iArr[zzw + 2];
                        int i42 = 1 << (i41 >>> 20);
                        int i43 = i41 & 1048575;
                        if (i43 != i35) {
                            i18 = b8;
                            if (i35 != 1048575) {
                                unsafe2.putInt(obj4, i35, i34);
                            }
                            i34 = unsafe2.getInt(obj4, i43);
                            i19 = i43;
                        } else {
                            i18 = b8;
                            i19 = i35;
                        }
                        int i44 = i34;
                        switch (zzA) {
                            case 0:
                                i20 = zzw;
                                i12 = i37;
                                i21 = i40;
                                if (i38 == 1) {
                                    zzmx.zzo(obj4, j8, Double.longBitsToDouble(zzir.zzn(bArr2, i21)));
                                    i30 = i21 + 8;
                                    i34 = i44 | i42;
                                    i32 = i12;
                                    i29 = i10;
                                    i33 = i20;
                                    i31 = i18;
                                    i35 = i19;
                                    i28 = i9;
                                    break;
                                } else {
                                    i40 = i21;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 1:
                                i20 = zzw;
                                i12 = i37;
                                i21 = i40;
                                if (i38 == 5) {
                                    zzmx.zzp(obj4, j8, Float.intBitsToFloat(zzir.zzb(bArr2, i21)));
                                    i30 = i21 + 4;
                                    i34 = i44 | i42;
                                    i32 = i12;
                                    i29 = i10;
                                    i33 = i20;
                                    i31 = i18;
                                    i35 = i19;
                                    i28 = i9;
                                    break;
                                } else {
                                    i40 = i21;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 2:
                            case 3:
                                i20 = zzw;
                                i12 = i37;
                                i21 = i40;
                                if (i38 == 0) {
                                    int zzm = zzir.zzm(bArr2, i21, zziqVar3);
                                    unsafe2.putLong(obj, j8, zziqVar3.zzb);
                                    i34 = i44 | i42;
                                    i32 = i12;
                                    i29 = i10;
                                    i30 = zzm;
                                    i33 = i20;
                                    i31 = i18;
                                    i35 = i19;
                                    i28 = i9;
                                    break;
                                } else {
                                    i40 = i21;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 4:
                            case 11:
                                i20 = zzw;
                                i12 = i37;
                                i21 = i40;
                                if (i38 == 0) {
                                    i30 = zzir.zzj(bArr2, i21, zziqVar3);
                                    unsafe2.putInt(obj4, j8, zziqVar3.zza);
                                    i34 = i44 | i42;
                                    i32 = i12;
                                    i29 = i10;
                                    i33 = i20;
                                    i31 = i18;
                                    i35 = i19;
                                    i28 = i9;
                                    break;
                                } else {
                                    i40 = i21;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 5:
                            case 14:
                                int i45 = i18;
                                i12 = i37;
                                if (i38 == 1) {
                                    i20 = zzw;
                                    i18 = i45;
                                    i21 = i40;
                                    unsafe2.putLong(obj, j8, zzir.zzn(bArr2, i40));
                                    i30 = i21 + 8;
                                    i34 = i44 | i42;
                                    i32 = i12;
                                    i29 = i10;
                                    i33 = i20;
                                    i31 = i18;
                                    i35 = i19;
                                    i28 = i9;
                                    break;
                                } else {
                                    i20 = zzw;
                                    i18 = i45;
                                    i40 = i40;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 6:
                            case 13:
                                i22 = i18;
                                i12 = i37;
                                i23 = i40;
                                if (i38 == 5) {
                                    unsafe2.putInt(obj4, j8, zzir.zzb(bArr2, i23));
                                    i30 = i23 + 4;
                                    i34 = i44 | i42;
                                    i33 = zzw;
                                    i31 = i22;
                                    i35 = i19;
                                    i32 = i12;
                                    i29 = i10;
                                    break;
                                } else {
                                    i20 = zzw;
                                    i40 = i23;
                                    i18 = i22;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 7:
                                i22 = i18;
                                i12 = i37;
                                i23 = i40;
                                if (i38 == 0) {
                                    i30 = zzir.zzm(bArr2, i23, zziqVar3);
                                    zzmx.zzm(obj4, j8, zziqVar3.zzb != 0);
                                    i34 = i44 | i42;
                                    i33 = zzw;
                                    i31 = i22;
                                    i35 = i19;
                                    i32 = i12;
                                    i29 = i10;
                                    break;
                                } else {
                                    i20 = zzw;
                                    i40 = i23;
                                    i18 = i22;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 8:
                                i22 = i18;
                                i12 = i37;
                                i23 = i40;
                                if (i38 == 2) {
                                    if ((536870912 & i39) == 0) {
                                        i30 = zzir.zzg(bArr2, i23, zziqVar3);
                                    } else {
                                        i30 = zzir.zzh(bArr2, i23, zziqVar3);
                                    }
                                    unsafe2.putObject(obj4, j8, zziqVar3.zzc);
                                    i34 = i44 | i42;
                                    i33 = zzw;
                                    i31 = i22;
                                    i35 = i19;
                                    i32 = i12;
                                    i29 = i10;
                                    break;
                                } else {
                                    i20 = zzw;
                                    i40 = i23;
                                    i18 = i22;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 9:
                                i24 = zzw;
                                i22 = i18;
                                i12 = i37;
                                i25 = i40;
                                if (i38 == 2) {
                                    i30 = zzir.zzd(zzloVar2.zzE(i24), bArr2, i25, i28, zziqVar3);
                                    if ((i44 & i42) == 0) {
                                        unsafe2.putObject(obj4, j8, zziqVar3.zzc);
                                    } else {
                                        unsafe2.putObject(obj4, j8, zzkm.zzg(unsafe2.getObject(obj4, j8), zziqVar3.zzc));
                                    }
                                    i34 = i44 | i42;
                                    i32 = i12;
                                    i33 = i24;
                                    i31 = i22;
                                    i35 = i19;
                                    i29 = i10;
                                    break;
                                } else {
                                    i40 = i25;
                                    i20 = i24;
                                    i18 = i22;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 10:
                                i24 = zzw;
                                i22 = i18;
                                i12 = i37;
                                i25 = i40;
                                if (i38 == 2) {
                                    i30 = zzir.zza(bArr2, i25, zziqVar3);
                                    unsafe2.putObject(obj4, j8, zziqVar3.zzc);
                                    i34 = i44 | i42;
                                    i32 = i12;
                                    i33 = i24;
                                    i31 = i22;
                                    i35 = i19;
                                    i29 = i10;
                                    break;
                                } else {
                                    i40 = i25;
                                    i20 = i24;
                                    i18 = i22;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 12:
                                i24 = zzw;
                                i22 = i18;
                                i12 = i37;
                                i25 = i40;
                                if (i38 == 0) {
                                    i30 = zzir.zzj(bArr2, i25, zziqVar3);
                                    int i46 = zziqVar3.zza;
                                    zzki zzD = zzloVar2.zzD(i24);
                                    if (zzD != null && !zzD.zza(i46)) {
                                        zzd(obj).zzh(i22, Long.valueOf(i46));
                                        i32 = i12;
                                        i34 = i44;
                                        i33 = i24;
                                        i31 = i22;
                                        i35 = i19;
                                        i29 = i10;
                                    } else {
                                        unsafe2.putInt(obj4, j8, i46);
                                        i34 = i44 | i42;
                                        i32 = i12;
                                        i33 = i24;
                                        i31 = i22;
                                        i35 = i19;
                                        i29 = i10;
                                        break;
                                    }
                                } else {
                                    i40 = i25;
                                    i20 = i24;
                                    i18 = i22;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                                break;
                            case 15:
                                i24 = zzw;
                                i22 = i18;
                                i12 = i37;
                                i25 = i40;
                                if (i38 == 0) {
                                    i30 = zzir.zzj(bArr2, i25, zziqVar3);
                                    unsafe2.putInt(obj4, j8, zzjh.zzb(zziqVar3.zza));
                                    i34 = i44 | i42;
                                    i32 = i12;
                                    i33 = i24;
                                    i31 = i22;
                                    i35 = i19;
                                    i29 = i10;
                                    break;
                                } else {
                                    i40 = i25;
                                    i20 = i24;
                                    i18 = i22;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            case 16:
                                if (i38 == 0) {
                                    int zzm2 = zzir.zzm(bArr2, i40, zziqVar3);
                                    i24 = zzw;
                                    i22 = i18;
                                    unsafe2.putLong(obj, j8, zzjh.zzc(zziqVar3.zzb));
                                    i34 = i44 | i42;
                                    i32 = i37;
                                    i30 = zzm2;
                                    i33 = i24;
                                    i31 = i22;
                                    i35 = i19;
                                    i29 = i10;
                                    break;
                                } else {
                                    i12 = i37;
                                    i20 = zzw;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                            default:
                                i20 = zzw;
                                i12 = i37;
                                i21 = i40;
                                if (i38 == 3) {
                                    i30 = zzir.zzc(zzloVar2.zzE(i20), bArr, i21, i9, (i12 << 3) | 4, zziqVar);
                                    if ((i44 & i42) == 0) {
                                        unsafe2.putObject(obj4, j8, zziqVar3.zzc);
                                    } else {
                                        unsafe2.putObject(obj4, j8, zzkm.zzg(unsafe2.getObject(obj4, j8), zziqVar3.zzc));
                                    }
                                    i34 = i44 | i42;
                                    bArr2 = bArr;
                                    i32 = i12;
                                    i29 = i10;
                                    i33 = i20;
                                    i31 = i18;
                                    i35 = i19;
                                    i28 = i9;
                                    break;
                                } else {
                                    i40 = i21;
                                    i11 = i10;
                                    i15 = i44;
                                    unsafe = unsafe2;
                                    i14 = i18;
                                    i13 = i40;
                                    i35 = i19;
                                    i16 = i20;
                                    break;
                                }
                        }
                    } else {
                        int i47 = zzw;
                        int i48 = b8;
                        if (zzA != 27) {
                            i15 = i34;
                            i26 = i35;
                            if (zzA <= 49) {
                                i12 = i37;
                                unsafe = unsafe2;
                                i16 = i47;
                                i30 = zzv(obj, bArr, i40, i9, i48, i12, i38, i47, i39, zzA, j8, zziqVar);
                                if (i30 != i40) {
                                    zzloVar2 = this;
                                    obj4 = obj;
                                    bArr2 = bArr;
                                    i32 = i12;
                                    i28 = i9;
                                    i29 = i10;
                                    zziqVar3 = zziqVar;
                                    i31 = i48;
                                    i33 = i16;
                                    i34 = i15;
                                    i35 = i26;
                                    unsafe2 = unsafe;
                                } else {
                                    i11 = i10;
                                    i13 = i30;
                                    i14 = i48;
                                    i35 = i26;
                                }
                            } else {
                                i12 = i37;
                                unsafe = unsafe2;
                                i27 = i40;
                                i16 = i47;
                                if (zzA != 50) {
                                    i30 = zzt(obj, bArr, i27, i9, i48, i12, i38, i39, zzA, j8, i16, zziqVar);
                                    if (i30 != i27) {
                                        zzloVar2 = this;
                                        obj4 = obj;
                                        bArr2 = bArr;
                                        i32 = i12;
                                        i28 = i9;
                                        i29 = i10;
                                        zziqVar3 = zziqVar;
                                        i31 = i48;
                                        i33 = i16;
                                        i34 = i15;
                                        i35 = i26;
                                        unsafe2 = unsafe;
                                    } else {
                                        i11 = i10;
                                        i13 = i30;
                                        i14 = i48;
                                        i35 = i26;
                                    }
                                } else if (i38 == 2) {
                                    i30 = zzs(obj, bArr, i27, i9, i16, j8, zziqVar);
                                    if (i30 != i27) {
                                        zzloVar2 = this;
                                        obj4 = obj;
                                        bArr2 = bArr;
                                        i32 = i12;
                                        i28 = i9;
                                        i29 = i10;
                                        zziqVar3 = zziqVar;
                                        i31 = i48;
                                        i33 = i16;
                                        i34 = i15;
                                        i35 = i26;
                                        unsafe2 = unsafe;
                                    } else {
                                        i11 = i10;
                                        i13 = i30;
                                        i14 = i48;
                                        i35 = i26;
                                    }
                                }
                            }
                        } else if (i38 == 2) {
                            zzkl zzklVar = (zzkl) unsafe2.getObject(obj4, j8);
                            if (!zzklVar.zzc()) {
                                int size = zzklVar.size();
                                zzklVar = zzklVar.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj4, j8, zzklVar);
                            }
                            i31 = i48;
                            i19 = i35;
                            i30 = zzir.zze(zzloVar2.zzE(i47), i31, bArr, i40, i9, zzklVar, zziqVar);
                            bArr2 = bArr;
                            i29 = i10;
                            i32 = i37;
                            i33 = i47;
                            i34 = i34;
                            i35 = i19;
                            i28 = i9;
                        } else {
                            i15 = i34;
                            i26 = i35;
                            i12 = i37;
                            unsafe = unsafe2;
                            i27 = i40;
                            i16 = i47;
                        }
                        i11 = i10;
                        i13 = i27;
                        i14 = i48;
                        i35 = i26;
                    }
                }
                if (i14 != i11 || i11 == 0) {
                    if (this.zzh) {
                        zziqVar2 = zziqVar;
                        if (zziqVar2.zzd != zzjq.zza()) {
                            i17 = i12;
                            if (zziqVar2.zzd.zzc(this.zzg, i17) == null) {
                                i30 = zzir.zzi(i14, bArr, i13, i9, zzd(obj), zziqVar);
                                obj3 = obj;
                                i28 = i9;
                                i31 = i14;
                                zzloVar2 = this;
                                zziqVar3 = zziqVar2;
                                i32 = i17;
                                obj4 = obj3;
                                i33 = i16;
                                i34 = i15;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i29 = i11;
                            } else {
                                zzkb zzkbVar = (zzkb) obj;
                                throw null;
                            }
                        } else {
                            obj3 = obj;
                            i17 = i12;
                        }
                    } else {
                        obj3 = obj;
                        i17 = i12;
                        zziqVar2 = zziqVar;
                    }
                    i30 = zzir.zzi(i14, bArr, i13, i9, zzd(obj), zziqVar);
                    i28 = i9;
                    i31 = i14;
                    zzloVar2 = this;
                    zziqVar3 = zziqVar2;
                    i32 = i17;
                    obj4 = obj3;
                    i33 = i16;
                    i34 = i15;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i29 = i11;
                } else {
                    zzloVar = this;
                    obj2 = obj;
                    i30 = i13;
                    i31 = i14;
                    i34 = i15;
                }
            } else {
                unsafe = unsafe2;
                i11 = i29;
                obj2 = obj4;
                zzloVar = zzloVar2;
            }
        }
        if (i35 != 1048575) {
            unsafe.putInt(obj2, i35, i34);
        }
        for (int i49 = zzloVar.zzk; i49 < zzloVar.zzl; i49++) {
            int i50 = zzloVar.zzj[i49];
            int i51 = zzloVar.zzc[i50];
            Object zzf = zzmx.zzf(obj2, zzloVar.zzB(i50) & 1048575);
            if (zzf != null && zzloVar.zzD(i50) != null) {
                zzlf zzlfVar = (zzlf) zzf;
                zzle zzleVar = (zzle) zzloVar.zzF(i50);
                throw null;
            }
        }
        if (i11 == 0) {
            if (i30 != i9) {
                throw zzko.zze();
            }
        } else if (i30 > i9 || i31 != i11) {
            throw zzko.zze();
        }
        return i30;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final Object zze() {
        return ((zzke) this.zzg).zzl(4, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzf(Object obj) {
        int i8;
        int i9 = this.zzk;
        while (true) {
            i8 = this.zzl;
            if (i9 >= i8) {
                break;
            }
            long zzB = zzB(this.zzj[i9]) & 1048575;
            Object zzf = zzmx.zzf(obj, zzB);
            if (zzf != null) {
                ((zzlf) zzf).zzc();
                zzmx.zzs(obj, zzB, zzf);
            }
            i9++;
        }
        int length = this.zzj.length;
        while (i8 < length) {
            this.zzm.zza(obj, this.zzj[i8]);
            i8++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i8 = 0; i8 < this.zzc.length; i8 += 3) {
            int zzB = zzB(i8);
            long j8 = 1048575 & zzB;
            int i9 = this.zzc[i8];
            switch (zzA(zzB)) {
                case 0:
                    if (zzO(obj2, i8)) {
                        zzmx.zzo(obj, j8, zzmx.zza(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj2, i8)) {
                        zzmx.zzp(obj, j8, zzmx.zzb(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj2, i8)) {
                        zzmx.zzr(obj, j8, zzmx.zzd(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj2, i8)) {
                        zzmx.zzr(obj, j8, zzmx.zzd(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj2, i8)) {
                        zzmx.zzq(obj, j8, zzmx.zzc(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj2, i8)) {
                        zzmx.zzr(obj, j8, zzmx.zzd(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj2, i8)) {
                        zzmx.zzq(obj, j8, zzmx.zzc(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj2, i8)) {
                        zzmx.zzm(obj, j8, zzmx.zzw(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzO(obj2, i8)) {
                        zzmx.zzs(obj, j8, zzmx.zzf(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i8);
                    break;
                case 10:
                    if (zzO(obj2, i8)) {
                        zzmx.zzs(obj, j8, zzmx.zzf(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj2, i8)) {
                        zzmx.zzq(obj, j8, zzmx.zzc(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj2, i8)) {
                        zzmx.zzq(obj, j8, zzmx.zzc(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj2, i8)) {
                        zzmx.zzq(obj, j8, zzmx.zzc(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj2, i8)) {
                        zzmx.zzr(obj, j8, zzmx.zzd(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj2, i8)) {
                        zzmx.zzq(obj, j8, zzmx.zzc(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj2, i8)) {
                        zzmx.zzr(obj, j8, zzmx.zzd(obj2, j8));
                        zzJ(obj, i8);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i8);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j8);
                    break;
                case 50:
                    zzly.zzaa(this.zzq, obj, obj2, j8);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzR(obj2, i9, i8)) {
                        zzmx.zzs(obj, j8, zzmx.zzf(obj2, j8));
                        zzK(obj, i9, i8);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i8);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i9, i8)) {
                        zzmx.zzs(obj, j8, zzmx.zzf(obj2, j8));
                        zzK(obj, i9, i8);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i8);
                    break;
            }
        }
        zzly.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzly.zzE(this.zzo, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzh(Object obj, byte[] bArr, int i8, int i9, zziq zziqVar) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i8, i9, zziqVar);
        } else {
            zzc(obj, bArr, i8, i9, 0, zziqVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzi(Object obj, zznf zznfVar) throws IOException {
        if (this.zzi) {
            if (!this.zzh) {
                int length = this.zzc.length;
                for (int i8 = 0; i8 < length; i8 += 3) {
                    int zzB = zzB(i8);
                    int i9 = this.zzc[i8];
                    switch (zzA(zzB)) {
                        case 0:
                            if (zzO(obj, i8)) {
                                zznfVar.zzf(i9, zzmx.zza(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (zzO(obj, i8)) {
                                zznfVar.zzo(i9, zzmx.zzb(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (zzO(obj, i8)) {
                                zznfVar.zzt(i9, zzmx.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (zzO(obj, i8)) {
                                zznfVar.zzJ(i9, zzmx.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (zzO(obj, i8)) {
                                zznfVar.zzr(i9, zzmx.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (zzO(obj, i8)) {
                                zznfVar.zzm(i9, zzmx.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (zzO(obj, i8)) {
                                zznfVar.zzk(i9, zzmx.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (zzO(obj, i8)) {
                                zznfVar.zzb(i9, zzmx.zzw(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (zzO(obj, i8)) {
                                zzT(i9, zzmx.zzf(obj, zzB & 1048575), zznfVar);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (zzO(obj, i8)) {
                                zznfVar.zzv(i9, zzmx.zzf(obj, zzB & 1048575), zzE(i8));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (zzO(obj, i8)) {
                                zznfVar.zzd(i9, (zzjd) zzmx.zzf(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (zzO(obj, i8)) {
                                zznfVar.zzH(i9, zzmx.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (zzO(obj, i8)) {
                                zznfVar.zzi(i9, zzmx.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (zzO(obj, i8)) {
                                zznfVar.zzw(i9, zzmx.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (zzO(obj, i8)) {
                                zznfVar.zzy(i9, zzmx.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (zzO(obj, i8)) {
                                zznfVar.zzA(i9, zzmx.zzc(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (zzO(obj, i8)) {
                                zznfVar.zzC(i9, zzmx.zzd(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (zzO(obj, i8)) {
                                zznfVar.zzq(i9, zzmx.zzf(obj, zzB & 1048575), zzE(i8));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            zzly.zzJ(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 19:
                            zzly.zzN(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 20:
                            zzly.zzQ(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 21:
                            zzly.zzY(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 22:
                            zzly.zzP(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 23:
                            zzly.zzM(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 24:
                            zzly.zzL(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 25:
                            zzly.zzH(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 26:
                            zzly.zzW(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar);
                            break;
                        case 27:
                            zzly.zzR(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, zzE(i8));
                            break;
                        case 28:
                            zzly.zzI(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar);
                            break;
                        case 29:
                            zzly.zzX(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 30:
                            zzly.zzK(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 31:
                            zzly.zzS(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 32:
                            zzly.zzT(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 33:
                            zzly.zzU(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 34:
                            zzly.zzV(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, false);
                            break;
                        case 35:
                            zzly.zzJ(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 36:
                            zzly.zzN(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 37:
                            zzly.zzQ(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 38:
                            zzly.zzY(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 39:
                            zzly.zzP(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 40:
                            zzly.zzM(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 41:
                            zzly.zzL(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 42:
                            zzly.zzH(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 43:
                            zzly.zzX(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 44:
                            zzly.zzK(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 45:
                            zzly.zzS(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 46:
                            zzly.zzT(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 47:
                            zzly.zzU(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 48:
                            zzly.zzV(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, true);
                            break;
                        case 49:
                            zzly.zzO(i9, (List) zzmx.zzf(obj, zzB & 1048575), zznfVar, zzE(i8));
                            break;
                        case 50:
                            zzM(zznfVar, i9, zzmx.zzf(obj, zzB & 1048575), i8);
                            break;
                        case 51:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzf(i9, zzn(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzo(i9, zzo(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzt(i9, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzJ(i9, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzr(i9, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzm(i9, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzk(i9, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzb(i9, zzS(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (zzR(obj, i9, i8)) {
                                zzT(i9, zzmx.zzf(obj, zzB & 1048575), zznfVar);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzv(i9, zzmx.zzf(obj, zzB & 1048575), zzE(i8));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzd(i9, (zzjd) zzmx.zzf(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzH(i9, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzi(i9, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzw(i9, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzy(i9, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzA(i9, zzr(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzC(i9, zzC(obj, zzB & 1048575));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (zzR(obj, i9, i8)) {
                                zznfVar.zzq(i9, zzmx.zzf(obj, zzB & 1048575), zzE(i8));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                zzmn zzmnVar = this.zzn;
                zzmnVar.zzi(zzmnVar.zzc(obj), zznfVar);
                return;
            }
            this.zzo.zza(obj);
            throw null;
        }
        zzL(obj, zznfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzZ;
        int length = this.zzc.length;
        for (int i8 = 0; i8 < length; i8 += 3) {
            int zzB = zzB(i8);
            long j8 = zzB & 1048575;
            switch (zzA(zzB)) {
                case 0:
                    if (zzN(obj, obj2, i8) && Double.doubleToLongBits(zzmx.zza(obj, j8)) == Double.doubleToLongBits(zzmx.zza(obj2, j8))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzN(obj, obj2, i8) && Float.floatToIntBits(zzmx.zzb(obj, j8)) == Float.floatToIntBits(zzmx.zzb(obj2, j8))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzN(obj, obj2, i8) && zzmx.zzd(obj, j8) == zzmx.zzd(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzN(obj, obj2, i8) && zzmx.zzd(obj, j8) == zzmx.zzd(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzN(obj, obj2, i8) && zzmx.zzc(obj, j8) == zzmx.zzc(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzN(obj, obj2, i8) && zzmx.zzd(obj, j8) == zzmx.zzd(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzN(obj, obj2, i8) && zzmx.zzc(obj, j8) == zzmx.zzc(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzN(obj, obj2, i8) && zzmx.zzw(obj, j8) == zzmx.zzw(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzN(obj, obj2, i8) && zzly.zzZ(zzmx.zzf(obj, j8), zzmx.zzf(obj2, j8))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzN(obj, obj2, i8) && zzly.zzZ(zzmx.zzf(obj, j8), zzmx.zzf(obj2, j8))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzN(obj, obj2, i8) && zzly.zzZ(zzmx.zzf(obj, j8), zzmx.zzf(obj2, j8))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzN(obj, obj2, i8) && zzmx.zzc(obj, j8) == zzmx.zzc(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzN(obj, obj2, i8) && zzmx.zzc(obj, j8) == zzmx.zzc(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzN(obj, obj2, i8) && zzmx.zzc(obj, j8) == zzmx.zzc(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzN(obj, obj2, i8) && zzmx.zzd(obj, j8) == zzmx.zzd(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzN(obj, obj2, i8) && zzmx.zzc(obj, j8) == zzmx.zzc(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzN(obj, obj2, i8) && zzmx.zzd(obj, j8) == zzmx.zzd(obj2, j8)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzN(obj, obj2, i8) && zzly.zzZ(zzmx.zzf(obj, j8), zzmx.zzf(obj2, j8))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzZ = zzly.zzZ(zzmx.zzf(obj, j8), zzmx.zzf(obj2, j8));
                    break;
                case 50:
                    zzZ = zzly.zzZ(zzmx.zzf(obj, j8), zzmx.zzf(obj2, j8));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzy = zzy(i8) & 1048575;
                    if (zzmx.zzc(obj, zzy) == zzmx.zzc(obj2, zzy) && zzly.zzZ(zzmx.zzf(obj, j8), zzmx.zzf(obj2, j8))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzZ) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzk(Object obj) {
        int i8;
        int i9;
        int i10 = 1048575;
        int i11 = 0;
        int i12 = 0;
        while (i12 < this.zzk) {
            int i13 = this.zzj[i12];
            int i14 = this.zzc[i13];
            int zzB = zzB(i13);
            int i15 = this.zzc[i13 + 2];
            int i16 = i15 & 1048575;
            int i17 = 1 << (i15 >>> 20);
            if (i16 != i10) {
                if (i16 != 1048575) {
                    i11 = zzb.getInt(obj, i16);
                }
                i9 = i11;
                i8 = i16;
            } else {
                i8 = i10;
                i9 = i11;
            }
            if ((268435456 & zzB) != 0 && !zzP(obj, i13, i8, i9, i17)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA != 60 && zzA != 68) {
                        if (zzA != 49) {
                            if (zzA == 50 && !((zzlf) zzmx.zzf(obj, zzB & 1048575)).isEmpty()) {
                                zzle zzleVar = (zzle) zzF(i13);
                                throw null;
                            }
                        }
                    } else if (zzR(obj, i14, i13) && !zzQ(obj, zzB, zzE(i13))) {
                        return false;
                    }
                }
                List list = (List) zzmx.zzf(obj, zzB & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzlw zzE = zzE(i13);
                    for (int i18 = 0; i18 < list.size(); i18++) {
                        if (!zzE.zzk(list.get(i18))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzP(obj, i13, i8, i9, i17) && !zzQ(obj, zzB, zzE(i13))) {
                return false;
            }
            i12++;
            i10 = i8;
            i11 = i9;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }
}
