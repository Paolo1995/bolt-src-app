package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzeg {
    private static final Object zza = new Object();
    private final String zzb;
    private final zzed zzc;
    private final Object zzd;
    private final Object zze;
    private final Object zzf = new Object();
    private volatile Object zzg = null;
    private volatile Object zzh = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeg(String str, Object obj, Object obj2, zzed zzedVar, zzef zzefVar) {
        this.zzb = str;
        this.zzd = obj;
        this.zze = obj2;
        this.zzc = zzedVar;
    }

    public final Object zza(Object obj) {
        Object obj2;
        synchronized (this.zzf) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzee.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            if (zzab.zza()) {
                if (this.zzh == null) {
                    obj2 = this.zzd;
                } else {
                    obj2 = this.zzh;
                }
                return obj2;
            }
            try {
                for (zzeg zzegVar : zzeh.zzb()) {
                    if (!zzab.zza()) {
                        Object obj3 = null;
                        try {
                            zzed zzedVar = zzegVar.zzc;
                            if (zzedVar != null) {
                                obj3 = zzedVar.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (zza) {
                            zzegVar.zzh = obj3;
                        }
                    } else {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzed zzedVar2 = this.zzc;
            if (zzedVar2 == null) {
                return this.zzd;
            }
            try {
                return zzedVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.zzd;
            } catch (SecurityException unused4) {
                return this.zzd;
            }
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
