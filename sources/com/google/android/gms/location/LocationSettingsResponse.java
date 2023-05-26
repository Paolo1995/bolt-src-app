package com.google.android.gms.location;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Response;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public class LocationSettingsResponse extends Response<LocationSettingsResult> {
    public LocationSettingsResponse() {
    }

    @RecentlyNullable
    public LocationSettingsStates getLocationSettingsStates() {
        return getResult().getLocationSettingsStates();
    }

    public LocationSettingsResponse(@RecentlyNonNull LocationSettingsResult locationSettingsResult) {
        super(locationSettingsResult);
    }
}
