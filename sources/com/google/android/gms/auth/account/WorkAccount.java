package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzal;
import com.google.android.gms.internal.auth.zzam;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public class WorkAccount {
    @NonNull
    public static final Api<Api.ApiOptions.NoOptions> API;
    @NonNull
    @Deprecated
    public static final WorkAccountApi WorkAccountApi;
    private static final Api.ClientKey<zzam> zza;
    private static final Api.AbstractClientBuilder<zzam, Api.ApiOptions.NoOptions> zzb;

    static {
        Api.ClientKey<zzam> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzf zzfVar = new zzf();
        zzb = zzfVar;
        API = new Api<>("WorkAccount.API", zzfVar, clientKey);
        WorkAccountApi = new zzal();
    }

    private WorkAccount() {
    }

    @NonNull
    public static WorkAccountClient getClient(@NonNull Activity activity) {
        return new WorkAccountClient(activity);
    }

    @NonNull
    public static WorkAccountClient getClient(@NonNull Context context) {
        return new WorkAccountClient(context);
    }
}
