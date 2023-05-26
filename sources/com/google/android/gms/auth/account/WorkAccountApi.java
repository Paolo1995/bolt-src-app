package com.google.android.gms.auth.account;

import android.accounts.Account;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
@Deprecated
/* loaded from: classes.dex */
public interface WorkAccountApi {

    /* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface AddAccountResult extends Result {
        @NonNull
        Account getAccount();
    }

    @NonNull
    @Deprecated
    PendingResult<AddAccountResult> addWorkAccount(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    @Deprecated
    PendingResult<Result> removeWorkAccount(@NonNull GoogleApiClient googleApiClient, @NonNull Account account);

    @Deprecated
    void setWorkAuthenticatorEnabled(@NonNull GoogleApiClient googleApiClient, boolean z7);

    @NonNull
    @Deprecated
    PendingResult<Result> setWorkAuthenticatorEnabledWithResult(@NonNull GoogleApiClient googleApiClient, boolean z7);
}
