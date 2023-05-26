package com.google.android.gms.location;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
@Deprecated
/* loaded from: classes.dex */
public final class LocationStatusCodes {
    public static final int ERROR = 1;
    public static final int GEOFENCE_NOT_AVAILABLE = 1000;
    public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
    public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
    public static final int SUCCESS = 0;

    private LocationStatusCodes() {
    }

    public static int zza(int i8) {
        if ((i8 < 0 || i8 > 1) && (i8 < 1000 || i8 >= 1006)) {
            return 1;
        }
        return i8;
    }

    @RecentlyNonNull
    public static Status zzb(int i8) {
        if (i8 == 1) {
            i8 = 13;
        }
        return new Status(i8);
    }
}
