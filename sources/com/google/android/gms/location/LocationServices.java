package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public class LocationServices {
    @RecentlyNonNull
    public static final Api<Api.ApiOptions.NoOptions> API;
    @RecentlyNonNull
    @Deprecated
    public static final FusedLocationProviderApi FusedLocationApi;
    @RecentlyNonNull
    @Deprecated
    public static final GeofencingApi GeofencingApi;
    @RecentlyNonNull
    @Deprecated
    public static final SettingsApi SettingsApi;
    private static final Api.ClientKey<com.google.android.gms.internal.location.zzaz> zza;
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.location.zzaz, Api.ApiOptions.NoOptions> zzb;

    static {
        Api.ClientKey<com.google.android.gms.internal.location.zzaz> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzbh zzbhVar = new zzbh();
        zzb = zzbhVar;
        API = new Api<>("LocationServices.API", zzbhVar, clientKey);
        FusedLocationApi = new com.google.android.gms.internal.location.zzz();
        GeofencingApi = new com.google.android.gms.internal.location.zzaf();
        SettingsApi = new com.google.android.gms.internal.location.zzbi();
    }

    private LocationServices() {
    }

    @RecentlyNonNull
    public static FusedLocationProviderClient getFusedLocationProviderClient(@RecentlyNonNull Activity activity) {
        return new FusedLocationProviderClient(activity);
    }

    @RecentlyNonNull
    public static GeofencingClient getGeofencingClient(@RecentlyNonNull Activity activity) {
        return new GeofencingClient(activity);
    }

    @RecentlyNonNull
    public static SettingsClient getSettingsClient(@RecentlyNonNull Activity activity) {
        return new SettingsClient(activity);
    }

    public static com.google.android.gms.internal.location.zzaz zza(GoogleApiClient googleApiClient) {
        boolean z7;
        boolean z8 = true;
        if (googleApiClient != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7, "GoogleApiClient parameter is required.");
        com.google.android.gms.internal.location.zzaz zzazVar = (com.google.android.gms.internal.location.zzaz) googleApiClient.getClient(zza);
        if (zzazVar == null) {
            z8 = false;
        }
        Preconditions.checkState(z8, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzazVar;
    }

    @RecentlyNonNull
    public static FusedLocationProviderClient getFusedLocationProviderClient(@RecentlyNonNull Context context) {
        return new FusedLocationProviderClient(context);
    }

    @RecentlyNonNull
    public static GeofencingClient getGeofencingClient(@RecentlyNonNull Context context) {
        return new GeofencingClient(context);
    }

    @RecentlyNonNull
    public static SettingsClient getSettingsClient(@RecentlyNonNull Context context) {
        return new SettingsClient(context);
    }
}
