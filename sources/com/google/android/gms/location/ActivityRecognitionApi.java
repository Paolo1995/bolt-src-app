package com.google.android.gms.location;

import android.app.PendingIntent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
@Deprecated
/* loaded from: classes.dex */
public interface ActivityRecognitionApi {
    @RecentlyNonNull
    PendingResult<Status> removeActivityUpdates(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull PendingIntent pendingIntent);

    @RecentlyNonNull
    PendingResult<Status> requestActivityUpdates(@RecentlyNonNull GoogleApiClient googleApiClient, long j8, @RecentlyNonNull PendingIntent pendingIntent);
}
