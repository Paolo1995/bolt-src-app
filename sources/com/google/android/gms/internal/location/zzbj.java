package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public final class zzbj {
    public static Looper zza(Looper looper) {
        if (looper != null) {
            return looper;
        }
        return zzb();
    }

    public static Looper zzb() {
        boolean z7;
        if (Looper.myLooper() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkState(z7, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
