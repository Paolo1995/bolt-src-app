package com.google.android.gms.auth.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyClient;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.auth.zzbe;
import com.google.android.gms.internal.auth.zzbo;
import com.google.android.gms.internal.auth.zzbt;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public final class AuthProxy {
    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Api<AuthProxyOptions> API;
    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final ProxyApi ProxyApi;
    @NonNull
    public static final Api.ClientKey<zzbe> zza;
    private static final Api.AbstractClientBuilder<zzbe, AuthProxyOptions> zzb;

    static {
        Api.ClientKey<zzbe> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zza zzaVar = new zza();
        zzb = zzaVar;
        API = new Api<>("Auth.PROXY_API", zzaVar, clientKey);
        ProxyApi = new zzbt();
    }

    @NonNull
    @KeepForSdk
    public static ProxyClient getClient(@NonNull Activity activity, AuthProxyOptions authProxyOptions) {
        return new zzbo(activity, authProxyOptions);
    }

    @NonNull
    @KeepForSdk
    public static ProxyClient getClient(@NonNull Context context, AuthProxyOptions authProxyOptions) {
        return new zzbo(context, authProxyOptions);
    }
}
