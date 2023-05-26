package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzow;
import com.google.android.gms.internal.measurement.zzpi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzlh extends zzkt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlh(zzlf zzlfVar) {
        super(zzlfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean zzA(zzaw zzawVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzawVar);
        Preconditions.checkNotNull(zzqVar);
        if (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final com.google.android.gms.internal.measurement.zzfw zzB(com.google.android.gms.internal.measurement.zzfs zzfsVar, String str) {
        for (com.google.android.gms.internal.measurement.zzfw zzfwVar : zzfsVar.zzi()) {
            if (zzfwVar.zzg().equals(str)) {
                return zzfwVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object zzC(com.google.android.gms.internal.measurement.zzfs zzfsVar, String str) {
        com.google.android.gms.internal.measurement.zzfw zzB = zzB(zzfsVar, str);
        if (zzB != null) {
            if (zzB.zzy()) {
                return zzB.zzh();
            }
            if (zzB.zzw()) {
                return Long.valueOf(zzB.zzd());
            }
            if (zzB.zzu()) {
                return Double.valueOf(zzB.zza());
            }
            if (zzB.zzc() > 0) {
                List<com.google.android.gms.internal.measurement.zzfw> zzi = zzB.zzi();
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzfw zzfwVar : zzi) {
                    if (zzfwVar != null) {
                        Bundle bundle = new Bundle();
                        for (com.google.android.gms.internal.measurement.zzfw zzfwVar2 : zzfwVar.zzi()) {
                            if (zzfwVar2.zzy()) {
                                bundle.putString(zzfwVar2.zzg(), zzfwVar2.zzh());
                            } else if (zzfwVar2.zzw()) {
                                bundle.putLong(zzfwVar2.zzg(), zzfwVar2.zzd());
                            } else if (zzfwVar2.zzu()) {
                                bundle.putDouble(zzfwVar2.zzg(), zzfwVar2.zza());
                            }
                        }
                        if (!bundle.isEmpty()) {
                            arrayList.add(bundle);
                        }
                    }
                }
                return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return null;
        }
        return null;
    }

    private final void zzD(StringBuilder sb, int i8, List list) {
        String str;
        String str2;
        Long l8;
        if (list == null) {
            return;
        }
        int i9 = i8 + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzfw zzfwVar = (com.google.android.gms.internal.measurement.zzfw) it.next();
            if (zzfwVar != null) {
                zzF(sb, i9);
                sb.append("param {\n");
                Double d8 = null;
                if (zzfwVar.zzx()) {
                    str = this.zzs.zzj().zze(zzfwVar.zzg());
                } else {
                    str = null;
                }
                zzI(sb, i9, "name", str);
                if (zzfwVar.zzy()) {
                    str2 = zzfwVar.zzh();
                } else {
                    str2 = null;
                }
                zzI(sb, i9, "string_value", str2);
                if (zzfwVar.zzw()) {
                    l8 = Long.valueOf(zzfwVar.zzd());
                } else {
                    l8 = null;
                }
                zzI(sb, i9, "int_value", l8);
                if (zzfwVar.zzu()) {
                    d8 = Double.valueOf(zzfwVar.zza());
                }
                zzI(sb, i9, "double_value", d8);
                if (zzfwVar.zzc() > 0) {
                    zzD(sb, i9, zzfwVar.zzi());
                }
                zzF(sb, i9);
                sb.append("}\n");
            }
        }
    }

    private final void zzE(StringBuilder sb, int i8, com.google.android.gms.internal.measurement.zzel zzelVar) {
        String str;
        if (zzelVar == null) {
            return;
        }
        zzF(sb, i8);
        sb.append("filter {\n");
        if (zzelVar.zzh()) {
            zzI(sb, i8, "complement", Boolean.valueOf(zzelVar.zzg()));
        }
        if (zzelVar.zzj()) {
            zzI(sb, i8, "param_name", this.zzs.zzj().zze(zzelVar.zze()));
        }
        if (zzelVar.zzk()) {
            int i9 = i8 + 1;
            com.google.android.gms.internal.measurement.zzex zzd = zzelVar.zzd();
            if (zzd != null) {
                zzF(sb, i9);
                sb.append("string_filter {\n");
                if (zzd.zzi()) {
                    switch (zzd.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    zzI(sb, i9, "match_type", str);
                }
                if (zzd.zzh()) {
                    zzI(sb, i9, "expression", zzd.zzd());
                }
                if (zzd.zzg()) {
                    zzI(sb, i9, "case_sensitive", Boolean.valueOf(zzd.zzf()));
                }
                if (zzd.zza() > 0) {
                    zzF(sb, i9 + 1);
                    sb.append("expression_list {\n");
                    for (String str2 : zzd.zze()) {
                        zzF(sb, i9 + 2);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zzF(sb, i9);
                sb.append("}\n");
            }
        }
        if (zzelVar.zzi()) {
            zzJ(sb, i8 + 1, "number_filter", zzelVar.zzc());
        }
        zzF(sb, i8);
        sb.append("}\n");
    }

    private static final void zzF(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            sb.append("  ");
        }
    }

    private static final String zzG(boolean z7, boolean z8, boolean z9) {
        StringBuilder sb = new StringBuilder();
        if (z7) {
            sb.append("Dynamic ");
        }
        if (z8) {
            sb.append("Sequence ");
        }
        if (z9) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void zzH(StringBuilder sb, int i8, String str, com.google.android.gms.internal.measurement.zzgh zzghVar) {
        Integer num;
        Integer num2;
        Long l8;
        if (zzghVar == null) {
            return;
        }
        zzF(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzghVar.zzb() != 0) {
            zzF(sb, 4);
            sb.append("results: ");
            int i9 = 0;
            for (Long l9 : zzghVar.zzk()) {
                int i10 = i9 + 1;
                if (i9 != 0) {
                    sb.append(", ");
                }
                sb.append(l9);
                i9 = i10;
            }
            sb.append('\n');
        }
        if (zzghVar.zzd() != 0) {
            zzF(sb, 4);
            sb.append("status: ");
            int i11 = 0;
            for (Long l10 : zzghVar.zzn()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb.append(", ");
                }
                sb.append(l10);
                i11 = i12;
            }
            sb.append('\n');
        }
        if (zzghVar.zza() != 0) {
            zzF(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i13 = 0;
            for (com.google.android.gms.internal.measurement.zzfq zzfqVar : zzghVar.zzj()) {
                int i14 = i13 + 1;
                if (i13 != 0) {
                    sb.append(", ");
                }
                if (zzfqVar.zzh()) {
                    num2 = Integer.valueOf(zzfqVar.zza());
                } else {
                    num2 = null;
                }
                sb.append(num2);
                sb.append(":");
                if (zzfqVar.zzg()) {
                    l8 = Long.valueOf(zzfqVar.zzb());
                } else {
                    l8 = null;
                }
                sb.append(l8);
                i13 = i14;
            }
            sb.append("}\n");
        }
        if (zzghVar.zzc() != 0) {
            zzF(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i15 = 0;
            for (com.google.android.gms.internal.measurement.zzgj zzgjVar : zzghVar.zzm()) {
                int i16 = i15 + 1;
                if (i15 != 0) {
                    sb.append(", ");
                }
                if (zzgjVar.zzi()) {
                    num = Integer.valueOf(zzgjVar.zzb());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(": [");
                int i17 = 0;
                for (Long l11 : zzgjVar.zzf()) {
                    long longValue = l11.longValue();
                    int i18 = i17 + 1;
                    if (i17 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i17 = i18;
                }
                sb.append("]");
                i15 = i16;
            }
            sb.append("}\n");
        }
        zzF(sb, 3);
        sb.append("}\n");
    }

    private static final void zzI(StringBuilder sb, int i8, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzF(sb, i8 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void zzJ(StringBuilder sb, int i8, String str, com.google.android.gms.internal.measurement.zzeq zzeqVar) {
        String str2;
        if (zzeqVar == null) {
            return;
        }
        zzF(sb, i8);
        sb.append(str);
        sb.append(" {\n");
        if (zzeqVar.zzg()) {
            int zzm = zzeqVar.zzm();
            if (zzm != 1) {
                if (zzm != 2) {
                    if (zzm != 3) {
                        if (zzm != 4) {
                            str2 = "BETWEEN";
                        } else {
                            str2 = "EQUAL";
                        }
                    } else {
                        str2 = "GREATER_THAN";
                    }
                } else {
                    str2 = "LESS_THAN";
                }
            } else {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            }
            zzI(sb, i8, "comparison_type", str2);
        }
        if (zzeqVar.zzi()) {
            zzI(sb, i8, "match_as_float", Boolean.valueOf(zzeqVar.zzf()));
        }
        if (zzeqVar.zzh()) {
            zzI(sb, i8, "comparison_value", zzeqVar.zzc());
        }
        if (zzeqVar.zzk()) {
            zzI(sb, i8, "min_comparison_value", zzeqVar.zze());
        }
        if (zzeqVar.zzj()) {
            zzI(sb, i8, "max_comparison_value", zzeqVar.zzd());
        }
        zzF(sb, i8);
        sb.append("}\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(com.google.android.gms.internal.measurement.zzgb zzgbVar, String str) {
        if (zzgbVar != null) {
            for (int i8 = 0; i8 < zzgbVar.zzb(); i8++) {
                if (str.equals(zzgbVar.zzao(i8).zzf())) {
                    return i8;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.internal.measurement.zzlk zzl(com.google.android.gms.internal.measurement.zzlk zzlkVar, byte[] bArr) throws com.google.android.gms.internal.measurement.zzko {
        com.google.android.gms.internal.measurement.zzjq zzb = com.google.android.gms.internal.measurement.zzjq.zzb();
        if (zzb != null) {
            return zzlkVar.zzaA(bArr, zzb);
        }
        return zzlkVar.zzaz(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zzr(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i8 = 0; i8 < length; i8++) {
            long j8 = 0;
            for (int i9 = 0; i9 < 64; i9++) {
                int i10 = (i8 * 64) + i9;
                if (i10 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i10)) {
                    j8 |= 1 << i9;
                }
            }
            arrayList.add(Long.valueOf(j8));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzv(List list, int i8) {
        if (i8 < list.size() * 64) {
            if (((1 << (i8 % 64)) & ((Long) list.get(i8 / 64)).longValue()) != 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzx(String str) {
        if (str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzz(com.google.android.gms.internal.measurement.zzfr zzfrVar, String str, Object obj) {
        List zzp = zzfrVar.zzp();
        int i8 = 0;
        while (true) {
            if (i8 < zzp.size()) {
                if (str.equals(((com.google.android.gms.internal.measurement.zzfw) zzp.get(i8)).zzg())) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        com.google.android.gms.internal.measurement.zzfv zze = com.google.android.gms.internal.measurement.zzfw.zze();
        zze.zzj(str);
        if (obj instanceof Long) {
            zze.zzi(((Long) obj).longValue());
        }
        if (i8 >= 0) {
            zzfrVar.zzj(i8, zze);
        } else {
            zzfrVar.zze(zze);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkt
    protected final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzd(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        this.zzs.zzv().zzg();
        MessageDigest zzF = zzln.zzF();
        if (zzF == null) {
            this.zzs.zzay().zzd().zza("Failed to get MD5");
            return 0L;
        }
        return zzln.zzp(zzF.digest(bArr));
    }

    final Bundle zzf(Map map, boolean z7) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof ArrayList) {
                if (z7) {
                    zzow.zzc();
                    if (this.zzs.zzf().zzs(null, zzeh.zzai)) {
                        ArrayList arrayList = (ArrayList) obj;
                        ArrayList arrayList2 = new ArrayList();
                        int size = arrayList.size();
                        for (int i8 = 0; i8 < size; i8++) {
                            arrayList2.add(zzf((Map) arrayList.get(i8), false));
                        }
                        bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
                    } else {
                        ArrayList arrayList3 = (ArrayList) obj;
                        ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
                        int size2 = arrayList3.size();
                        for (int i9 = 0; i9 < size2; i9++) {
                            arrayList4.add(zzf((Map) arrayList3.get(i9), false));
                        }
                        bundle.putParcelableArrayList(str, arrayList4);
                    }
                }
            } else {
                bundle.putString(str, obj.toString());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Parcelable zzh(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            this.zzs.zzay().zzd().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzaw zzi(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        String str;
        Object obj;
        Bundle zzf = zzf(zzaaVar.zze(), true);
        if (zzf.containsKey("_o") && (obj = zzf.get("_o")) != null) {
            str = obj.toString();
        } else {
            str = "app";
        }
        String str2 = str;
        String zzb = zzhb.zzb(zzaaVar.zzd());
        if (zzb == null) {
            zzb = zzaaVar.zzd();
        }
        return new zzaw(zzb, new zzau(zzf), str2, zzaaVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzfs zzj(zzar zzarVar) {
        com.google.android.gms.internal.measurement.zzfr zze = com.google.android.gms.internal.measurement.zzfs.zze();
        zze.zzl(zzarVar.zze);
        zzat zzatVar = new zzat(zzarVar.zzf);
        while (zzatVar.hasNext()) {
            String next = zzatVar.next();
            com.google.android.gms.internal.measurement.zzfv zze2 = com.google.android.gms.internal.measurement.zzfw.zze();
            zze2.zzj(next);
            Object zzf = zzarVar.zzf.zzf(next);
            Preconditions.checkNotNull(zzf);
            zzt(zze2, zzf);
            zze.zze(zze2);
        }
        return (com.google.android.gms.internal.measurement.zzfs) zze.zzaE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzm(com.google.android.gms.internal.measurement.zzga zzgaVar) {
        Long l8;
        Long l9;
        Double d8;
        if (zzgaVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.zzgc zzgcVar : zzgaVar.zzd()) {
            if (zzgcVar != null) {
                zzF(sb, 1);
                sb.append("bundle {\n");
                if (zzgcVar.zzbj()) {
                    zzI(sb, 1, "protocol_version", Integer.valueOf(zzgcVar.zzd()));
                }
                zzpi.zzc();
                if (this.zzs.zzf().zzs(null, zzeh.zzay) && zzgcVar.zzbm()) {
                    zzI(sb, 1, "session_stitching_token", zzgcVar.zzK());
                }
                zzI(sb, 1, "platform", zzgcVar.zzI());
                if (zzgcVar.zzbf()) {
                    zzI(sb, 1, "gmp_version", Long.valueOf(zzgcVar.zzm()));
                }
                if (zzgcVar.zzbq()) {
                    zzI(sb, 1, "uploading_gmp_version", Long.valueOf(zzgcVar.zzr()));
                }
                if (zzgcVar.zzbd()) {
                    zzI(sb, 1, "dynamite_version", Long.valueOf(zzgcVar.zzj()));
                }
                if (zzgcVar.zzba()) {
                    zzI(sb, 1, "config_version", Long.valueOf(zzgcVar.zzh()));
                }
                zzI(sb, 1, "gmp_app_id", zzgcVar.zzF());
                zzI(sb, 1, "admob_app_id", zzgcVar.zzw());
                zzI(sb, 1, "app_id", zzgcVar.zzx());
                zzI(sb, 1, "app_version", zzgcVar.zzA());
                if (zzgcVar.zzaY()) {
                    zzI(sb, 1, "app_version_major", Integer.valueOf(zzgcVar.zza()));
                }
                zzI(sb, 1, "firebase_instance_id", zzgcVar.zzE());
                if (zzgcVar.zzbc()) {
                    zzI(sb, 1, "dev_cert_hash", Long.valueOf(zzgcVar.zzi()));
                }
                zzI(sb, 1, "app_store", zzgcVar.zzz());
                if (zzgcVar.zzbp()) {
                    zzI(sb, 1, "upload_timestamp_millis", Long.valueOf(zzgcVar.zzq()));
                }
                if (zzgcVar.zzbn()) {
                    zzI(sb, 1, "start_timestamp_millis", Long.valueOf(zzgcVar.zzp()));
                }
                if (zzgcVar.zzbe()) {
                    zzI(sb, 1, "end_timestamp_millis", Long.valueOf(zzgcVar.zzk()));
                }
                if (zzgcVar.zzbi()) {
                    zzI(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgcVar.zzo()));
                }
                if (zzgcVar.zzbh()) {
                    zzI(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgcVar.zzn()));
                }
                zzI(sb, 1, "app_instance_id", zzgcVar.zzy());
                zzI(sb, 1, "resettable_device_id", zzgcVar.zzJ());
                zzI(sb, 1, "ds_id", zzgcVar.zzD());
                if (zzgcVar.zzbg()) {
                    zzI(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzgcVar.zzaW()));
                }
                zzI(sb, 1, "os_version", zzgcVar.zzH());
                zzI(sb, 1, "device_model", zzgcVar.zzC());
                zzI(sb, 1, "user_default_language", zzgcVar.zzL());
                if (zzgcVar.zzbo()) {
                    zzI(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzgcVar.zzf()));
                }
                if (zzgcVar.zzaZ()) {
                    zzI(sb, 1, "bundle_sequential_index", Integer.valueOf(zzgcVar.zzb()));
                }
                if (zzgcVar.zzbl()) {
                    zzI(sb, 1, "service_upload", Boolean.valueOf(zzgcVar.zzaX()));
                }
                zzI(sb, 1, "health_monitor", zzgcVar.zzG());
                if (zzgcVar.zzbk()) {
                    zzI(sb, 1, "retry_counter", Integer.valueOf(zzgcVar.zze()));
                }
                if (zzgcVar.zzbb()) {
                    zzI(sb, 1, "consent_signals", zzgcVar.zzB());
                }
                List<com.google.android.gms.internal.measurement.zzgl> zzO = zzgcVar.zzO();
                if (zzO != null) {
                    for (com.google.android.gms.internal.measurement.zzgl zzglVar : zzO) {
                        if (zzglVar != null) {
                            zzF(sb, 2);
                            sb.append("user_property {\n");
                            if (zzglVar.zzs()) {
                                l8 = Long.valueOf(zzglVar.zzc());
                            } else {
                                l8 = null;
                            }
                            zzI(sb, 2, "set_timestamp_millis", l8);
                            zzI(sb, 2, "name", this.zzs.zzj().zzf(zzglVar.zzf()));
                            zzI(sb, 2, "string_value", zzglVar.zzg());
                            if (zzglVar.zzr()) {
                                l9 = Long.valueOf(zzglVar.zzb());
                            } else {
                                l9 = null;
                            }
                            zzI(sb, 2, "int_value", l9);
                            if (zzglVar.zzq()) {
                                d8 = Double.valueOf(zzglVar.zza());
                            } else {
                                d8 = null;
                            }
                            zzI(sb, 2, "double_value", d8);
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzfo> zzM = zzgcVar.zzM();
                if (zzM != null) {
                    for (com.google.android.gms.internal.measurement.zzfo zzfoVar : zzM) {
                        if (zzfoVar != null) {
                            zzF(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzfoVar.zzk()) {
                                zzI(sb, 2, "audience_id", Integer.valueOf(zzfoVar.zza()));
                            }
                            if (zzfoVar.zzm()) {
                                zzI(sb, 2, "new_audience", Boolean.valueOf(zzfoVar.zzj()));
                            }
                            zzH(sb, 2, "current_data", zzfoVar.zzd());
                            if (zzfoVar.zzn()) {
                                zzH(sb, 2, "previous_data", zzfoVar.zze());
                            }
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzfs> zzN = zzgcVar.zzN();
                if (zzN != null) {
                    for (com.google.android.gms.internal.measurement.zzfs zzfsVar : zzN) {
                        if (zzfsVar != null) {
                            zzF(sb, 2);
                            sb.append("event {\n");
                            zzI(sb, 2, "name", this.zzs.zzj().zzd(zzfsVar.zzh()));
                            if (zzfsVar.zzu()) {
                                zzI(sb, 2, "timestamp_millis", Long.valueOf(zzfsVar.zzd()));
                            }
                            if (zzfsVar.zzt()) {
                                zzI(sb, 2, "previous_timestamp_millis", Long.valueOf(zzfsVar.zzc()));
                            }
                            if (zzfsVar.zzs()) {
                                zzI(sb, 2, "count", Integer.valueOf(zzfsVar.zza()));
                            }
                            if (zzfsVar.zzb() != 0) {
                                zzD(sb, 2, zzfsVar.zzi());
                            }
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zzF(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzo(com.google.android.gms.internal.measurement.zzej zzejVar) {
        if (zzejVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzejVar.zzp()) {
            zzI(sb, 0, "filter_id", Integer.valueOf(zzejVar.zzb()));
        }
        zzI(sb, 0, "event_name", this.zzs.zzj().zzd(zzejVar.zzg()));
        String zzG = zzG(zzejVar.zzk(), zzejVar.zzm(), zzejVar.zzn());
        if (!zzG.isEmpty()) {
            zzI(sb, 0, "filter_type", zzG);
        }
        if (zzejVar.zzo()) {
            zzJ(sb, 1, "event_count_filter", zzejVar.zzf());
        }
        if (zzejVar.zza() > 0) {
            sb.append("  filters {\n");
            for (com.google.android.gms.internal.measurement.zzel zzelVar : zzejVar.zzh()) {
                zzE(sb, 2, zzelVar);
            }
        }
        zzF(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzp(com.google.android.gms.internal.measurement.zzes zzesVar) {
        if (zzesVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzesVar.zzj()) {
            zzI(sb, 0, "filter_id", Integer.valueOf(zzesVar.zza()));
        }
        zzI(sb, 0, "property_name", this.zzs.zzj().zzf(zzesVar.zze()));
        String zzG = zzG(zzesVar.zzg(), zzesVar.zzh(), zzesVar.zzi());
        if (!zzG.isEmpty()) {
            zzI(sb, 0, "filter_type", zzG);
        }
        zzE(sb, 1, zzesVar.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzq(List list, List list2) {
        int i8;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzs.zzay().zzk().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzs.zzay().zzk().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i9 = size2;
            i8 = size;
            size = i9;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        r4 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
        if ((r3 instanceof android.os.Parcelable[]) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
        r3 = (android.os.Parcelable[]) r3;
        r5 = r3.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
        if (r7 >= r5) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
        r8 = r3[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
        if ((r8 instanceof android.os.Bundle) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
        r4.add(zzs((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
        if ((r3 instanceof java.util.ArrayList) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
        r3 = (java.util.ArrayList) r3;
        r5 = r3.size();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
        if (r7 >= r5) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
        r8 = r3.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
        if ((r8 instanceof android.os.Bundle) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
        r4.add(zzs((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
        if ((r3 instanceof android.os.Bundle) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0098, code lost:
        r4.add(zzs((android.os.Bundle) r3, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a1, code lost:
        r0.put(r2, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map zzs(android.os.Bundle r11, boolean r12) {
        /*
            r10 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r1 = r1.iterator()
        Ld:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto La6
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r11.get(r2)
            com.google.android.gms.internal.measurement.zzow.zzc()
            com.google.android.gms.measurement.internal.zzge r4 = r10.zzs
            com.google.android.gms.measurement.internal.zzag r4 = r4.zzf()
            r5 = 0
            com.google.android.gms.measurement.internal.zzeg r6 = com.google.android.gms.measurement.internal.zzeh.zzai
            boolean r4 = r4.zzs(r5, r6)
            if (r4 == 0) goto L3c
            boolean r4 = r3 instanceof android.os.Parcelable[]
            if (r4 != 0) goto L4f
            boolean r4 = r3 instanceof java.util.ArrayList
            if (r4 != 0) goto L4f
            boolean r4 = r3 instanceof android.os.Bundle
            if (r4 == 0) goto L49
            goto L4f
        L3c:
            boolean r4 = r3 instanceof android.os.Bundle[]
            if (r4 != 0) goto L4f
            boolean r4 = r3 instanceof java.util.ArrayList
            if (r4 != 0) goto L4f
            boolean r4 = r3 instanceof android.os.Bundle
            if (r4 == 0) goto L49
            goto L4f
        L49:
            if (r3 == 0) goto Ld
            r0.put(r2, r3)
            goto Ld
        L4f:
            if (r12 == 0) goto Ld
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r5 = r3 instanceof android.os.Parcelable[]
            r6 = 0
            if (r5 == 0) goto L73
            android.os.Parcelable[] r3 = (android.os.Parcelable[]) r3
            int r5 = r3.length
            r7 = 0
        L5f:
            if (r7 >= r5) goto La1
            r8 = r3[r7]
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L70
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.Map r8 = r10.zzs(r8, r6)
            r4.add(r8)
        L70:
            int r7 = r7 + 1
            goto L5f
        L73:
            boolean r5 = r3 instanceof java.util.ArrayList
            if (r5 == 0) goto L94
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r5 = r3.size()
            r7 = 0
        L7e:
            if (r7 >= r5) goto La1
            java.lang.Object r8 = r3.get(r7)
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L91
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.Map r8 = r10.zzs(r8, r6)
            r4.add(r8)
        L91:
            int r7 = r7 + 1
            goto L7e
        L94:
            boolean r5 = r3 instanceof android.os.Bundle
            if (r5 == 0) goto La1
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.util.Map r3 = r10.zzs(r3, r6)
            r4.add(r3)
        La1:
            r0.put(r2, r4)
            goto Ld
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zzs(android.os.Bundle, boolean):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt(com.google.android.gms.internal.measurement.zzfv zzfvVar, Object obj) {
        Bundle[] bundleArr;
        Preconditions.checkNotNull(obj);
        zzfvVar.zzg();
        zzfvVar.zze();
        zzfvVar.zzd();
        zzfvVar.zzf();
        if (obj instanceof String) {
            zzfvVar.zzk((String) obj);
        } else if (obj instanceof Long) {
            zzfvVar.zzi(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzfvVar.zzh(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    com.google.android.gms.internal.measurement.zzfv zze = com.google.android.gms.internal.measurement.zzfw.zze();
                    for (String str : bundle.keySet()) {
                        com.google.android.gms.internal.measurement.zzfv zze2 = com.google.android.gms.internal.measurement.zzfw.zze();
                        zze2.zzj(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zze2.zzi(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zze2.zzk((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zze2.zzh(((Double) obj2).doubleValue());
                        }
                        zze.zzc(zze2);
                    }
                    if (zze.zza() > 0) {
                        arrayList.add((com.google.android.gms.internal.measurement.zzfw) zze.zzaE());
                    }
                }
            }
            zzfvVar.zzb(arrayList);
        } else {
            this.zzs.zzay().zzd().zzb("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(com.google.android.gms.internal.measurement.zzgk zzgkVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzgkVar.zzc();
        zzgkVar.zzb();
        zzgkVar.zza();
        if (obj instanceof String) {
            zzgkVar.zzh((String) obj);
        } else if (obj instanceof Long) {
            zzgkVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzgkVar.zzd(((Double) obj).doubleValue());
        } else {
            this.zzs.zzay().zzd().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzw(long j8, long j9) {
        if (j8 != 0 && j9 > 0 && Math.abs(this.zzs.zzav().currentTimeMillis() - j8) <= j9) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzy(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e8) {
            this.zzs.zzay().zzd().zzb("Failed to gzip content", e8);
            throw e8;
        }
    }
}
