package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzlg {
    public static final int zza(int i8, Object obj, Object obj2) {
        zzlf zzlfVar = (zzlf) obj;
        zzle zzleVar = (zzle) obj2;
        if (!zzlfVar.isEmpty()) {
            Iterator it = zzlfVar.entrySet().iterator();
            if (!it.hasNext()) {
                return 0;
            }
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
        return 0;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzlf zzlfVar = (zzlf) obj;
        zzlf zzlfVar2 = (zzlf) obj2;
        if (!zzlfVar2.isEmpty()) {
            if (!zzlfVar.zze()) {
                zzlfVar = zzlfVar.zzb();
            }
            zzlfVar.zzd(zzlfVar2);
        }
        return zzlfVar;
    }
}
