package com.google.android.gms.internal.auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzft<T> implements zzgb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfq zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfe zzl;
    private final zzgp<?, ?> zzm;
    private final zzeh<?> zzn;
    private final zzfv zzo;
    private final zzfl zzp;

    /* JADX WARN: Multi-variable type inference failed */
    private zzft(int[] iArr, int[] iArr2, Object[] objArr, int i8, int i9, zzfq zzfqVar, boolean z7, boolean z8, int[] iArr3, int i10, int i11, zzfv zzfvVar, zzfe zzfeVar, zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfl zzflVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zze = objArr;
        this.zzf = i8;
        this.zzh = zzfqVar;
        this.zzi = z8;
        this.zzj = iArr3;
        this.zzk = i10;
        this.zzo = i11;
        this.zzl = zzfvVar;
        this.zzm = zzfeVar;
        this.zzn = zzgpVar;
        this.zzg = i9;
        this.zzp = zzehVar;
    }

    private static Field zzA(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzB(T t7, T t8, int i8) {
        long zzv = zzv(i8) & 1048575;
        if (!zzG(t8, i8)) {
            return;
        }
        Object zzf = zzgz.zzf(t7, zzv);
        Object zzf2 = zzgz.zzf(t8, zzv);
        if (zzf != null && zzf2 != null) {
            zzgz.zzp(t7, zzv, zzev.zzg(zzf, zzf2));
            zzD(t7, i8);
        } else if (zzf2 != null) {
            zzgz.zzp(t7, zzv, zzf2);
            zzD(t7, i8);
        }
    }

    private final void zzC(T t7, T t8, int i8) {
        Object obj;
        int zzv = zzv(i8);
        int i9 = this.zzc[i8];
        long j8 = zzv & 1048575;
        if (!zzJ(t8, i9, i8)) {
            return;
        }
        if (zzJ(t7, i9, i8)) {
            obj = zzgz.zzf(t7, j8);
        } else {
            obj = null;
        }
        Object zzf = zzgz.zzf(t8, j8);
        if (obj != null && zzf != null) {
            zzgz.zzp(t7, j8, zzev.zzg(obj, zzf));
            zzE(t7, i9, i8);
        } else if (zzf != null) {
            zzgz.zzp(t7, j8, zzf);
            zzE(t7, i9, i8);
        }
    }

    private final void zzD(T t7, int i8) {
        int zzs = zzs(i8);
        long j8 = 1048575 & zzs;
        if (j8 == 1048575) {
            return;
        }
        zzgz.zzn(t7, j8, (1 << (zzs >>> 20)) | zzgz.zzc(t7, j8));
    }

    private final void zzE(T t7, int i8, int i9) {
        zzgz.zzn(t7, zzs(i9) & 1048575, i8);
    }

    private final boolean zzF(T t7, T t8, int i8) {
        if (zzG(t7, i8) == zzG(t8, i8)) {
            return true;
        }
        return false;
    }

    private final boolean zzG(T t7, int i8) {
        int zzs = zzs(i8);
        long j8 = zzs & 1048575;
        if (j8 == 1048575) {
            int zzv = zzv(i8);
            long j9 = zzv & 1048575;
            switch (zzu(zzv)) {
                case 0:
                    if (zzgz.zza(t7, j9) == 0.0d) {
                        return false;
                    }
                    return true;
                case 1:
                    if (zzgz.zzb(t7, j9) == 0.0f) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzgz.zzd(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzgz.zzd(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzgz.zzc(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzgz.zzd(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzgz.zzc(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzgz.zzt(t7, j9);
                case 8:
                    Object zzf = zzgz.zzf(t7, j9);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    } else if (zzf instanceof zzeb) {
                        if (zzeb.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (zzgz.zzf(t7, j9) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzeb.zzb.equals(zzgz.zzf(t7, j9))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzgz.zzc(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzgz.zzc(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzgz.zzc(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzgz.zzd(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzgz.zzc(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzgz.zzd(t7, j9) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzgz.zzf(t7, j9) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzgz.zzc(t7, j8) & (1 << (zzs >>> 20))) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private final boolean zzH(T t7, int i8, int i9, int i10, int i11) {
        if (i9 == 1048575) {
            return zzG(t7, i8);
        }
        if ((i10 & i11) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzI(Object obj, int i8, zzgb zzgbVar) {
        return zzgbVar.zzi(zzgz.zzf(obj, i8 & 1048575));
    }

    private final boolean zzJ(T t7, int i8, int i9) {
        if (zzgz.zzc(t7, zzs(i9) & 1048575) == i8) {
            return true;
        }
        return false;
    }

    static zzgq zzc(Object obj) {
        zzeq zzeqVar = (zzeq) obj;
        zzgq zzgqVar = zzeqVar.zzc;
        if (zzgqVar == zzgq.zza()) {
            zzgq zzc = zzgq.zzc();
            zzeqVar.zzc = zzc;
            return zzc;
        }
        return zzgqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzft<T> zzj(Class<T> cls, zzfn zzfnVar, zzfv zzfvVar, zzfe zzfeVar, zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfl zzflVar) {
        if (zzfnVar instanceof zzga) {
            return zzk((zzga) zzfnVar, zzfvVar, zzfeVar, zzgpVar, zzehVar, zzflVar);
        }
        zzgm zzgmVar = (zzgm) zzfnVar;
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
    static <T> com.google.android.gms.internal.auth.zzft<T> zzk(com.google.android.gms.internal.auth.zzga r34, com.google.android.gms.internal.auth.zzfv r35, com.google.android.gms.internal.auth.zzfe r36, com.google.android.gms.internal.auth.zzgp<?, ?> r37, com.google.android.gms.internal.auth.zzeh<?> r38, com.google.android.gms.internal.auth.zzfl r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzk(com.google.android.gms.internal.auth.zzga, com.google.android.gms.internal.auth.zzfv, com.google.android.gms.internal.auth.zzfe, com.google.android.gms.internal.auth.zzgp, com.google.android.gms.internal.auth.zzeh, com.google.android.gms.internal.auth.zzfl):com.google.android.gms.internal.auth.zzft");
    }

    private static <T> int zzl(T t7, long j8) {
        return ((Integer) zzgz.zzf(t7, j8)).intValue();
    }

    private final <K, V> int zzm(T t7, byte[] bArr, int i8, int i9, int i10, long j8, zzdp zzdpVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzz = zzz(i10);
        Object object = unsafe.getObject(t7, j8);
        if (!((zzfk) object).zze()) {
            zzfk<K, V> zzb2 = zzfk.zza().zzb();
            zzfl.zza(zzb2, object);
            unsafe.putObject(t7, j8, zzb2);
        }
        zzfj zzfjVar = (zzfj) zzz;
        throw null;
    }

    private final int zzn(T t7, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j8, int i15, zzdp zzdpVar) throws IOException {
        Unsafe unsafe = zzb;
        long j9 = this.zzc[i15 + 2] & 1048575;
        switch (i14) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t7, j8, Double.valueOf(Double.longBitsToDouble(zzdq.zzn(bArr, i8))));
                    unsafe.putInt(t7, j9, i11);
                    return i8 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t7, j8, Float.valueOf(Float.intBitsToFloat(zzdq.zzb(bArr, i8))));
                    unsafe.putInt(t7, j9, i11);
                    return i8 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm = zzdq.zzm(bArr, i8, zzdpVar);
                    unsafe.putObject(t7, j8, Long.valueOf(zzdpVar.zzb));
                    unsafe.putInt(t7, j9, i11);
                    return zzm;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj = zzdq.zzj(bArr, i8, zzdpVar);
                    unsafe.putObject(t7, j8, Integer.valueOf(zzdpVar.zza));
                    unsafe.putInt(t7, j9, i11);
                    return zzj;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t7, j8, Long.valueOf(zzdq.zzn(bArr, i8)));
                    unsafe.putInt(t7, j9, i11);
                    return i8 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t7, j8, Integer.valueOf(zzdq.zzb(bArr, i8)));
                    unsafe.putInt(t7, j9, i11);
                    return i8 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm2 = zzdq.zzm(bArr, i8, zzdpVar);
                    unsafe.putObject(t7, j8, Boolean.valueOf(zzdpVar.zzb != 0));
                    unsafe.putInt(t7, j9, i11);
                    return zzm2;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj2 = zzdq.zzj(bArr, i8, zzdpVar);
                    int i16 = zzdpVar.zza;
                    if (i16 == 0) {
                        unsafe.putObject(t7, j8, "");
                    } else if ((i13 & 536870912) != 0 && !zzhd.zzd(bArr, zzj2, zzj2 + i16)) {
                        throw zzew.zzb();
                    } else {
                        unsafe.putObject(t7, j8, new String(bArr, zzj2, i16, zzev.zza));
                        zzj2 += i16;
                    }
                    unsafe.putInt(t7, j9, i11);
                    return zzj2;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd = zzdq.zzd(zzy(i15), bArr, i8, i9, zzdpVar);
                    Object object = unsafe.getInt(t7, j9) == i11 ? unsafe.getObject(t7, j8) : null;
                    if (object == null) {
                        unsafe.putObject(t7, j8, zzdpVar.zzc);
                    } else {
                        unsafe.putObject(t7, j8, zzev.zzg(object, zzdpVar.zzc));
                    }
                    unsafe.putInt(t7, j9, i11);
                    return zzd;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzdq.zza(bArr, i8, zzdpVar);
                    unsafe.putObject(t7, j8, zzdpVar.zzc);
                    unsafe.putInt(t7, j9, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj3 = zzdq.zzj(bArr, i8, zzdpVar);
                    int i17 = zzdpVar.zza;
                    zzet zzx = zzx(i15);
                    if (zzx != null && !zzx.zza()) {
                        zzc(t7).zzf(i10, Long.valueOf(i17));
                    } else {
                        unsafe.putObject(t7, j8, Integer.valueOf(i17));
                        unsafe.putInt(t7, j9, i11);
                    }
                    return zzj3;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj4 = zzdq.zzj(bArr, i8, zzdpVar);
                    unsafe.putObject(t7, j8, Integer.valueOf(zzee.zzb(zzdpVar.zza)));
                    unsafe.putInt(t7, j9, i11);
                    return zzj4;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm3 = zzdq.zzm(bArr, i8, zzdpVar);
                    unsafe.putObject(t7, j8, Long.valueOf(zzee.zzc(zzdpVar.zzb)));
                    unsafe.putInt(t7, j9, i11);
                    return zzm3;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc = zzdq.zzc(zzy(i15), bArr, i8, i9, (i10 & (-8)) | 4, zzdpVar);
                    Object object2 = unsafe.getInt(t7, j9) == i11 ? unsafe.getObject(t7, j8) : null;
                    if (object2 == null) {
                        unsafe.putObject(t7, j8, zzdpVar.zzc);
                    } else {
                        unsafe.putObject(t7, j8, zzev.zzg(object2, zzdpVar.zzc));
                    }
                    unsafe.putInt(t7, j9, i11);
                    return zzc;
                }
                break;
        }
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a8, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02aa, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r19;
        r1 = r20;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02be, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02f1, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0314, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzo(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.auth.zzdp r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzo(java.lang.Object, byte[], int, int, com.google.android.gms.internal.auth.zzdp):int");
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
    private final int zzp(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.auth.zzdp r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzp(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.auth.zzdp):int");
    }

    private final int zzq(int i8) {
        if (i8 >= this.zze && i8 <= this.zzf) {
            return zzt(i8, 0);
        }
        return -1;
    }

    private final int zzr(int i8, int i9) {
        if (i8 >= this.zze && i8 <= this.zzf) {
            return zzt(i8, i9);
        }
        return -1;
    }

    private final int zzs(int i8) {
        return this.zzc[i8 + 2];
    }

    private final int zzt(int i8, int i9) {
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

    private static int zzu(int i8) {
        return (i8 >>> 20) & 255;
    }

    private final int zzv(int i8) {
        return this.zzc[i8 + 1];
    }

    private static <T> long zzw(T t7, long j8) {
        return ((Long) zzgz.zzf(t7, j8)).longValue();
    }

    private final zzet zzx(int i8) {
        int i9 = i8 / 3;
        return (zzet) this.zzd[i9 + i9 + 1];
    }

    private final zzgb zzy(int i8) {
        int i9 = i8 / 3;
        int i10 = i9 + i9;
        zzgb zzgbVar = (zzgb) this.zzd[i10];
        if (zzgbVar != null) {
            return zzgbVar;
        }
        zzgb<T> zzb2 = zzfy.zza().zzb((Class) this.zzd[i10 + 1]);
        this.zzd[i10] = zzb2;
        return zzb2;
    }

    private final Object zzz(int i8) {
        int i9 = i8 / 3;
        return this.zzd[i9 + i9];
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final int zza(T t7) {
        int i8;
        int zzc;
        int length = this.zzc.length;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzv = zzv(i10);
            int i11 = this.zzc[i10];
            long j8 = 1048575 & zzv;
            int i12 = 37;
            switch (zzu(zzv)) {
                case 0:
                    i8 = i9 * 53;
                    zzc = zzev.zzc(Double.doubleToLongBits(zzgz.zza(t7, j8)));
                    i9 = i8 + zzc;
                    break;
                case 1:
                    i8 = i9 * 53;
                    zzc = Float.floatToIntBits(zzgz.zzb(t7, j8));
                    i9 = i8 + zzc;
                    break;
                case 2:
                    i8 = i9 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t7, j8));
                    i9 = i8 + zzc;
                    break;
                case 3:
                    i8 = i9 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t7, j8));
                    i9 = i8 + zzc;
                    break;
                case 4:
                    i8 = i9 * 53;
                    zzc = zzgz.zzc(t7, j8);
                    i9 = i8 + zzc;
                    break;
                case 5:
                    i8 = i9 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t7, j8));
                    i9 = i8 + zzc;
                    break;
                case 6:
                    i8 = i9 * 53;
                    zzc = zzgz.zzc(t7, j8);
                    i9 = i8 + zzc;
                    break;
                case 7:
                    i8 = i9 * 53;
                    zzc = zzev.zza(zzgz.zzt(t7, j8));
                    i9 = i8 + zzc;
                    break;
                case 8:
                    i8 = i9 * 53;
                    zzc = ((String) zzgz.zzf(t7, j8)).hashCode();
                    i9 = i8 + zzc;
                    break;
                case 9:
                    Object zzf = zzgz.zzf(t7, j8);
                    if (zzf != null) {
                        i12 = zzf.hashCode();
                    }
                    i9 = (i9 * 53) + i12;
                    break;
                case 10:
                    i8 = i9 * 53;
                    zzc = zzgz.zzf(t7, j8).hashCode();
                    i9 = i8 + zzc;
                    break;
                case 11:
                    i8 = i9 * 53;
                    zzc = zzgz.zzc(t7, j8);
                    i9 = i8 + zzc;
                    break;
                case 12:
                    i8 = i9 * 53;
                    zzc = zzgz.zzc(t7, j8);
                    i9 = i8 + zzc;
                    break;
                case 13:
                    i8 = i9 * 53;
                    zzc = zzgz.zzc(t7, j8);
                    i9 = i8 + zzc;
                    break;
                case 14:
                    i8 = i9 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t7, j8));
                    i9 = i8 + zzc;
                    break;
                case 15:
                    i8 = i9 * 53;
                    zzc = zzgz.zzc(t7, j8);
                    i9 = i8 + zzc;
                    break;
                case 16:
                    i8 = i9 * 53;
                    zzc = zzev.zzc(zzgz.zzd(t7, j8));
                    i9 = i8 + zzc;
                    break;
                case 17:
                    Object zzf2 = zzgz.zzf(t7, j8);
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
                    zzc = zzgz.zzf(t7, j8).hashCode();
                    i9 = i8 + zzc;
                    break;
                case 50:
                    i8 = i9 * 53;
                    zzc = zzgz.zzf(t7, j8).hashCode();
                    i9 = i8 + zzc;
                    break;
                case 51:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzev.zzc(Double.doubleToLongBits(((Double) zzgz.zzf(t7, j8)).doubleValue()));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = Float.floatToIntBits(((Float) zzgz.zzf(t7, j8)).floatValue());
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzev.zzc(zzw(t7, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzev.zzc(zzw(t7, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzl(t7, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzev.zzc(zzw(t7, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzl(t7, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzev.zza(((Boolean) zzgz.zzf(t7, j8)).booleanValue());
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = ((String) zzgz.zzf(t7, j8)).hashCode();
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzgz.zzf(t7, j8).hashCode();
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzgz.zzf(t7, j8).hashCode();
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzl(t7, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzl(t7, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzl(t7, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzev.zzc(zzw(t7, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzl(t7, j8);
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzev.zzc(zzw(t7, j8));
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzJ(t7, i11, i10)) {
                        i8 = i9 * 53;
                        zzc = zzgz.zzf(t7, j8).hashCode();
                        i9 = i8 + zzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return (i9 * 53) + this.zzm.zza(t7).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0322, code lost:
        if (r0 != r2) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0324, code lost:
        r15 = r28;
        r14 = r29;
        r12 = r30;
        r13 = r32;
        r11 = r33;
        r9 = r34;
        r1 = r18;
        r2 = r19;
        r3 = r20;
        r5 = r22;
        r6 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x033c, code lost:
        r7 = r33;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0366, code lost:
        if (r0 != r15) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0388, code lost:
        if (r0 != r15) goto L178;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzb(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.auth.zzdp r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1086
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdp):int");
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final T zzd() {
        return (T) ((zzeq) this.zzg).zzj(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zze(T t7) {
        int i8;
        int i9 = this.zzj;
        while (true) {
            i8 = this.zzk;
            if (i9 >= i8) {
                break;
            }
            long zzv = zzv(this.zzi[i9]) & 1048575;
            Object zzf = zzgz.zzf(t7, zzv);
            if (zzf != null) {
                ((zzfk) zzf).zzc();
                zzgz.zzp(t7, zzv, zzf);
            }
            i9++;
        }
        int length = this.zzi.length;
        while (i8 < length) {
            this.zzl.zza(t7, this.zzi[i8]);
            i8++;
        }
        this.zzm.zze(t7);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzf(T t7, T t8) {
        t8.getClass();
        for (int i8 = 0; i8 < this.zzc.length; i8 += 3) {
            int zzv = zzv(i8);
            long j8 = 1048575 & zzv;
            int i9 = this.zzc[i8];
            switch (zzu(zzv)) {
                case 0:
                    if (zzG(t8, i8)) {
                        zzgz.zzl(t7, j8, zzgz.zza(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzG(t8, i8)) {
                        zzgz.zzm(t7, j8, zzgz.zzb(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzG(t8, i8)) {
                        zzgz.zzo(t7, j8, zzgz.zzd(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzG(t8, i8)) {
                        zzgz.zzo(t7, j8, zzgz.zzd(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzG(t8, i8)) {
                        zzgz.zzn(t7, j8, zzgz.zzc(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzG(t8, i8)) {
                        zzgz.zzo(t7, j8, zzgz.zzd(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzG(t8, i8)) {
                        zzgz.zzn(t7, j8, zzgz.zzc(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzG(t8, i8)) {
                        zzgz.zzk(t7, j8, zzgz.zzt(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzG(t8, i8)) {
                        zzgz.zzp(t7, j8, zzgz.zzf(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(t7, t8, i8);
                    break;
                case 10:
                    if (zzG(t8, i8)) {
                        zzgz.zzp(t7, j8, zzgz.zzf(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzG(t8, i8)) {
                        zzgz.zzn(t7, j8, zzgz.zzc(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzG(t8, i8)) {
                        zzgz.zzn(t7, j8, zzgz.zzc(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzG(t8, i8)) {
                        zzgz.zzn(t7, j8, zzgz.zzc(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzG(t8, i8)) {
                        zzgz.zzo(t7, j8, zzgz.zzd(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzG(t8, i8)) {
                        zzgz.zzn(t7, j8, zzgz.zzc(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzG(t8, i8)) {
                        zzgz.zzo(t7, j8, zzgz.zzd(t8, j8));
                        zzD(t7, i8);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(t7, t8, i8);
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
                    this.zzl.zzb(t7, t8, j8);
                    break;
                case 50:
                    zzgd.zzi(this.zzp, t7, t8, j8);
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
                    if (zzJ(t8, i9, i8)) {
                        zzgz.zzp(t7, j8, zzgz.zzf(t8, j8));
                        zzE(t7, i9, i8);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(t7, t8, i8);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzJ(t8, i9, i8)) {
                        zzgz.zzp(t7, j8, zzgz.zzf(t8, j8));
                        zzE(t7, i9, i8);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(t7, t8, i8);
                    break;
            }
        }
        zzgd.zzf(this.zzm, t7, t8);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzg(T t7, byte[] bArr, int i8, int i9, zzdp zzdpVar) throws IOException {
        if (this.zzh) {
            zzo(t7, bArr, i8, i9, zzdpVar);
        } else {
            zzb(t7, bArr, i8, i9, 0, zzdpVar);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzh(T t7, T t8) {
        boolean zzh;
        int length = this.zzc.length;
        for (int i8 = 0; i8 < length; i8 += 3) {
            int zzv = zzv(i8);
            long j8 = zzv & 1048575;
            switch (zzu(zzv)) {
                case 0:
                    if (zzF(t7, t8, i8) && Double.doubleToLongBits(zzgz.zza(t7, j8)) == Double.doubleToLongBits(zzgz.zza(t8, j8))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzF(t7, t8, i8) && Float.floatToIntBits(zzgz.zzb(t7, j8)) == Float.floatToIntBits(zzgz.zzb(t8, j8))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzF(t7, t8, i8) && zzgz.zzd(t7, j8) == zzgz.zzd(t8, j8)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzF(t7, t8, i8) && zzgz.zzd(t7, j8) == zzgz.zzd(t8, j8)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzF(t7, t8, i8) && zzgz.zzc(t7, j8) == zzgz.zzc(t8, j8)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzF(t7, t8, i8) && zzgz.zzd(t7, j8) == zzgz.zzd(t8, j8)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzF(t7, t8, i8) && zzgz.zzc(t7, j8) == zzgz.zzc(t8, j8)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzF(t7, t8, i8) && zzgz.zzt(t7, j8) == zzgz.zzt(t8, j8)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzF(t7, t8, i8) && zzgd.zzh(zzgz.zzf(t7, j8), zzgz.zzf(t8, j8))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzF(t7, t8, i8) && zzgd.zzh(zzgz.zzf(t7, j8), zzgz.zzf(t8, j8))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzF(t7, t8, i8) && zzgd.zzh(zzgz.zzf(t7, j8), zzgz.zzf(t8, j8))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzF(t7, t8, i8) && zzgz.zzc(t7, j8) == zzgz.zzc(t8, j8)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzF(t7, t8, i8) && zzgz.zzc(t7, j8) == zzgz.zzc(t8, j8)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzF(t7, t8, i8) && zzgz.zzc(t7, j8) == zzgz.zzc(t8, j8)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzF(t7, t8, i8) && zzgz.zzd(t7, j8) == zzgz.zzd(t8, j8)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzF(t7, t8, i8) && zzgz.zzc(t7, j8) == zzgz.zzc(t8, j8)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzF(t7, t8, i8) && zzgz.zzd(t7, j8) == zzgz.zzd(t8, j8)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzF(t7, t8, i8) && zzgd.zzh(zzgz.zzf(t7, j8), zzgz.zzf(t8, j8))) {
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
                    zzh = zzgd.zzh(zzgz.zzf(t7, j8), zzgz.zzf(t8, j8));
                    break;
                case 50:
                    zzh = zzgd.zzh(zzgz.zzf(t7, j8), zzgz.zzf(t8, j8));
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
                    long zzs = zzs(i8) & 1048575;
                    if (zzgz.zzc(t7, zzs) == zzgz.zzc(t8, zzs) && zzgd.zzh(zzgz.zzf(t7, j8), zzgz.zzf(t8, j8))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzh) {
                return false;
            }
        }
        if (!this.zzm.zza(t7).equals(this.zzm.zza(t8))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzi(T t7) {
        int i8;
        int i9;
        int i10 = 1048575;
        int i11 = 0;
        int i12 = 0;
        while (i12 < this.zzj) {
            int i13 = this.zzi[i12];
            int i14 = this.zzc[i13];
            int zzv = zzv(i13);
            int i15 = this.zzc[i13 + 2];
            int i16 = i15 & 1048575;
            int i17 = 1 << (i15 >>> 20);
            if (i16 != i10) {
                if (i16 != 1048575) {
                    i11 = zzb.getInt(t7, i16);
                }
                i9 = i11;
                i8 = i16;
            } else {
                i8 = i10;
                i9 = i11;
            }
            if ((268435456 & zzv) != 0 && !zzH(t7, i13, i8, i9, i17)) {
                return false;
            }
            int zzu = zzu(zzv);
            if (zzu != 9 && zzu != 17) {
                if (zzu != 27) {
                    if (zzu != 60 && zzu != 68) {
                        if (zzu != 49) {
                            if (zzu == 50 && !((zzfk) zzgz.zzf(t7, zzv & 1048575)).isEmpty()) {
                                zzfj zzfjVar = (zzfj) zzz(i13);
                                throw null;
                            }
                        }
                    } else if (zzJ(t7, i14, i13) && !zzI(t7, zzv, zzy(i13))) {
                        return false;
                    }
                }
                List list = (List) zzgz.zzf(t7, zzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgb zzy = zzy(i13);
                    for (int i18 = 0; i18 < list.size(); i18++) {
                        if (!zzy.zzi(list.get(i18))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzH(t7, i13, i8, i9, i17) && !zzI(t7, zzv, zzy(i13))) {
                return false;
            }
            i12++;
            i10 = i8;
            i11 = i9;
        }
        return true;
    }
}
