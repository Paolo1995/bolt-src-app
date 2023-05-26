package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public interface GoogleSignInApi {
    @NonNull
    public static final String EXTRA_SIGN_IN_ACCOUNT = "signInAccount";

    @NonNull
    Intent getSignInIntent(@NonNull GoogleApiClient googleApiClient);

    GoogleSignInResult getSignInResultFromIntent(@NonNull Intent intent);

    @NonNull
    PendingResult<Status> revokeAccess(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    PendingResult<Status> signOut(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    OptionalPendingResult<GoogleSignInResult> silentSignIn(@NonNull GoogleApiClient googleApiClient);
}
