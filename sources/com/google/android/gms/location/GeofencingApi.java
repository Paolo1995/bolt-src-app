package com.google.android.gms.location;

import android.app.PendingIntent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
@Deprecated
/* loaded from: classes.dex */
public interface GeofencingApi {
    @RecentlyNonNull
    PendingResult<Status> addGeofences(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull GeofencingRequest geofencingRequest, @RecentlyNonNull PendingIntent pendingIntent);

    @RecentlyNonNull
    @Deprecated
    PendingResult<Status> addGeofences(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull List<Geofence> list, @RecentlyNonNull PendingIntent pendingIntent);

    @RecentlyNonNull
    PendingResult<Status> removeGeofences(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull PendingIntent pendingIntent);

    @RecentlyNonNull
    PendingResult<Status> removeGeofences(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull List<String> list);
}
