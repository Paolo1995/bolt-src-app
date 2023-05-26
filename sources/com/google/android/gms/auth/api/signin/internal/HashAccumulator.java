package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class HashAccumulator {
    @VisibleForTesting
    static int zaa = 31;
    private int zab = 1;

    @NonNull
    @KeepForSdk
    public HashAccumulator addObject(Object obj) {
        int hashCode;
        int i8 = zaa * this.zab;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        this.zab = i8 + hashCode;
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zab;
    }

    @NonNull
    public final HashAccumulator zaa(boolean z7) {
        this.zab = (zaa * this.zab) + (z7 ? 1 : 0);
        return this;
    }
}
