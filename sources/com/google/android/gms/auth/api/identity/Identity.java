package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001authapi.zbao;
import com.google.android.gms.internal.p001authapi.zbay;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public final class Identity {
    private Identity() {
    }

    @NonNull
    public static CredentialSavingClient getCredentialSavingClient(@NonNull Activity activity) {
        return new zbao((Activity) Preconditions.checkNotNull(activity), new zbc());
    }

    @NonNull
    public static SignInClient getSignInClient(@NonNull Activity activity) {
        return new zbay((Activity) Preconditions.checkNotNull(activity), new zbn());
    }

    @NonNull
    public static CredentialSavingClient getCredentialSavingClient(@NonNull Context context) {
        return new zbao((Context) Preconditions.checkNotNull(context), new zbc());
    }

    @NonNull
    public static SignInClient getSignInClient(@NonNull Context context) {
        return new zbay((Context) Preconditions.checkNotNull(context), new zbn());
    }
}
