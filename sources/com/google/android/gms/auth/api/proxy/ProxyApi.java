package com.google.android.gms.auth.api.proxy;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public interface ProxyApi {

    /* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public interface ProxyResult extends Result {
        @NonNull
        @KeepForSdk
        ProxyResponse getResponse();
    }

    /* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public interface SpatulaHeaderResult extends Result {
        @NonNull
        @ShowFirstParty
        @KeepForSdk
        String getSpatulaHeader();
    }

    @NonNull
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    PendingResult<SpatulaHeaderResult> getSpatulaHeader(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    @KeepForSdk
    @Deprecated
    PendingResult<ProxyResult> performProxyRequest(@NonNull GoogleApiClient googleApiClient, @NonNull ProxyRequest proxyRequest);
}
