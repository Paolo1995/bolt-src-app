package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzjq {
    static final zzjq zza = new zzjq(true);
    private static volatile boolean zzb = false;
    private static volatile zzjq zzc;
    private static volatile zzjq zzd;
    private final Map zze;

    zzjq() {
        this.zze = new HashMap();
    }

    public static zzjq zza() {
        zzjq zzjqVar = zzc;
        if (zzjqVar == null) {
            synchronized (zzjq.class) {
                zzjqVar = zzc;
                if (zzjqVar == null) {
                    zzjqVar = zza;
                    zzc = zzjqVar;
                }
            }
        }
        return zzjqVar;
    }

    public static zzjq zzb() {
        zzjq zzjqVar = zzd;
        if (zzjqVar != null) {
            return zzjqVar;
        }
        synchronized (zzjq.class) {
            zzjq zzjqVar2 = zzd;
            if (zzjqVar2 != null) {
                return zzjqVar2;
            }
            zzjq zzb2 = zzjy.zzb(zzjq.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzkc zzc(zzll zzllVar, int i8) {
        return (zzkc) this.zze.get(new zzjp(zzllVar, i8));
    }

    zzjq(boolean z7) {
        this.zze = Collections.emptyMap();
    }
}
