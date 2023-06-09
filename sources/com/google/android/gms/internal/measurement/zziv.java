package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zziv implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzjd zzjdVar = (zzjd) obj;
        zzjd zzjdVar2 = (zzjd) obj2;
        zziu zziuVar = new zziu(zzjdVar);
        zziu zziuVar2 = new zziu(zzjdVar2);
        while (zziuVar.hasNext() && zziuVar2.hasNext()) {
            int compareTo = Integer.valueOf(zziuVar.zza() & 255).compareTo(Integer.valueOf(zziuVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzjdVar.zzd()).compareTo(Integer.valueOf(zzjdVar2.zzd()));
    }
}
