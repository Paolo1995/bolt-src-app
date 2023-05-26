package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzoe;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzu {
    final /* synthetic */ zzaa zza;
    private String zzb;
    private boolean zzc;
    private com.google.android.gms.internal.measurement.zzgh zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzu(zzaa zzaaVar, String str, zzt zztVar) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ BitSet zzb(zzu zzuVar) {
        return zzuVar.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final com.google.android.gms.internal.measurement.zzfo zza(int i8) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzfn zzb = com.google.android.gms.internal.measurement.zzfo.zzb();
        zzb.zza(i8);
        zzb.zzc(this.zzc);
        com.google.android.gms.internal.measurement.zzgh zzghVar = this.zzd;
        if (zzghVar != null) {
            zzb.zzd(zzghVar);
        }
        com.google.android.gms.internal.measurement.zzgg zzf = com.google.android.gms.internal.measurement.zzgh.zzf();
        zzf.zzb(zzlh.zzr(this.zze));
        zzf.zzd(zzlh.zzr(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.zzg.keySet()) {
                int intValue = num.intValue();
                Long l8 = (Long) this.zzg.get(Integer.valueOf(intValue));
                if (l8 != null) {
                    com.google.android.gms.internal.measurement.zzfp zzc = com.google.android.gms.internal.measurement.zzfq.zzc();
                    zzc.zzb(intValue);
                    zzc.zza(l8.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzfq) zzc.zzaE());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzf.zza(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.zzh.keySet()) {
                com.google.android.gms.internal.measurement.zzgi zzd = com.google.android.gms.internal.measurement.zzgj.zzd();
                zzd.zzb(num2.intValue());
                List list2 = (List) this.zzh.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zza(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzgj) zzd.zzaE());
            }
            list = arrayList3;
        }
        zzf.zzc(list);
        zzb.zzb(zzf);
        return (com.google.android.gms.internal.measurement.zzfo) zzb.zzaE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(@NonNull zzy zzyVar) {
        int zza = zzyVar.zza();
        Boolean bool = zzyVar.zzd;
        if (bool != null) {
            this.zzf.set(zza, bool.booleanValue());
        }
        Boolean bool2 = zzyVar.zze;
        if (bool2 != null) {
            this.zze.set(zza, bool2.booleanValue());
        }
        if (zzyVar.zzf != null) {
            Map map = this.zzg;
            Integer valueOf = Integer.valueOf(zza);
            Long l8 = (Long) map.get(valueOf);
            long longValue = zzyVar.zzf.longValue() / 1000;
            if (l8 == null || longValue > l8.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzyVar.zzg != null) {
            Map map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzyVar.zzc()) {
                list.clear();
            }
            zzoe.zzc();
            zzag zzf = this.zza.zzs.zzf();
            String str = this.zzb;
            zzeg zzegVar = zzeh.zzW;
            if (zzf.zzs(str, zzegVar) && zzyVar.zzb()) {
                list.clear();
            }
            zzoe.zzc();
            if (this.zza.zzs.zzf().zzs(this.zzb, zzegVar)) {
                Long valueOf3 = Long.valueOf(zzyVar.zzg.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(zzyVar.zzg.longValue() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzu(zzaa zzaaVar, String str, com.google.android.gms.internal.measurement.zzgh zzghVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzt zztVar) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzghVar;
    }
}
