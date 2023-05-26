package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public abstract class zzy {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(String str, int i8) {
        this.zzb = str;
        this.zzc = i8;
    }

    private static Boolean zzd(String str, int i8, boolean z7, String str2, List list, String str3, zzeu zzeuVar) {
        int i9;
        if (i8 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z7 && i8 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i8 - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                if (true != z7) {
                    i9 = 66;
                } else {
                    i9 = 0;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, i9).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzeuVar != null) {
                        zzeuVar.zzk().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    @VisibleForTesting
    static Boolean zze(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzeq zzeqVar, double d8) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzeqVar);
        if (zzeqVar.zzg()) {
            boolean z7 = true;
            if (zzeqVar.zzm() != 1) {
                if (zzeqVar.zzm() == 5) {
                    if (!zzeqVar.zzk() || !zzeqVar.zzj()) {
                        return null;
                    }
                } else if (!zzeqVar.zzh()) {
                    return null;
                }
                int zzm = zzeqVar.zzm();
                if (zzeqVar.zzm() == 5) {
                    if (zzlh.zzx(zzeqVar.zze()) && zzlh.zzx(zzeqVar.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzeqVar.zze());
                            bigDecimal4 = new BigDecimal(zzeqVar.zzd());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!zzlh.zzx(zzeqVar.zzc())) {
                    return null;
                } else {
                    try {
                        bigDecimal2 = new BigDecimal(zzeqVar.zzc());
                        bigDecimal3 = null;
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i8 = zzm - 1;
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 != 4 || bigDecimal3 == null) {
                                return null;
                            }
                            return Boolean.valueOf((bigDecimal.compareTo(bigDecimal3) < 0 || bigDecimal.compareTo(bigDecimal4) > 0) ? false : false);
                        } else if (bigDecimal2 == null) {
                            return null;
                        } else {
                            if (d8 != 0.0d) {
                                return Boolean.valueOf((bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d8).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d8).multiply(new BigDecimal(2)))) >= 0) ? false : false);
                            }
                            if (bigDecimal.compareTo(bigDecimal2) != 0) {
                                z7 = false;
                            }
                            return Boolean.valueOf(z7);
                        }
                    } else if (bigDecimal2 == null) {
                        return null;
                    } else {
                        if (bigDecimal.compareTo(bigDecimal2) <= 0) {
                            z7 = false;
                        }
                        return Boolean.valueOf(z7);
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal2) >= 0) {
                        z7 = false;
                    }
                    return Boolean.valueOf(z7);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Boolean zzf(String str, com.google.android.gms.internal.measurement.zzex zzexVar, zzeu zzeuVar) {
        String zzd;
        List list;
        String str2;
        Preconditions.checkNotNull(zzexVar);
        if (str == null || !zzexVar.zzi() || zzexVar.zzj() == 1) {
            return null;
        }
        if (zzexVar.zzj() == 7) {
            if (zzexVar.zza() == 0) {
                return null;
            }
        } else if (!zzexVar.zzh()) {
            return null;
        }
        int zzj = zzexVar.zzj();
        boolean zzf = zzexVar.zzf();
        if (!zzf && zzj != 2 && zzj != 7) {
            zzd = zzexVar.zzd().toUpperCase(Locale.ENGLISH);
        } else {
            zzd = zzexVar.zzd();
        }
        String str3 = zzd;
        if (zzexVar.zza() == 0) {
            list = null;
        } else {
            List<String> zze = zzexVar.zze();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zze.size());
                for (String str4 : zze) {
                    arrayList.add(str4.toUpperCase(Locale.ENGLISH));
                }
                zze = Collections.unmodifiableList(arrayList);
            }
            list = zze;
        }
        if (zzj == 2) {
            str2 = str3;
        } else {
            str2 = null;
        }
        return zzd(str, zzj, zzf, str3, list, str2, zzeuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzg(double d8, com.google.android.gms.internal.measurement.zzeq zzeqVar) {
        try {
            return zze(new BigDecimal(d8), zzeqVar, Math.ulp(d8));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzh(long j8, com.google.android.gms.internal.measurement.zzeq zzeqVar) {
        try {
            return zze(new BigDecimal(j8), zzeqVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzi(String str, com.google.android.gms.internal.measurement.zzeq zzeqVar) {
        if (!zzlh.zzx(str)) {
            return null;
        }
        try {
            return zze(new BigDecimal(str), zzeqVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Boolean zzj(Boolean bool, boolean z7) {
        boolean z8;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue() != z7) {
            z8 = true;
        } else {
            z8 = false;
        }
        return Boolean.valueOf(z8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzc();
}
