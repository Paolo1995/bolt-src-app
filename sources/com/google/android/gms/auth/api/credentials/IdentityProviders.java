package com.google.android.gms.auth.api.credentials;

import android.accounts.Account;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
@Deprecated
/* loaded from: classes.dex */
public final class IdentityProviders {
    @NonNull
    public static final String FACEBOOK = "https://www.facebook.com";
    @NonNull
    public static final String GOOGLE = "https://accounts.google.com";
    @NonNull
    public static final String LINKEDIN = "https://www.linkedin.com";
    @NonNull
    public static final String MICROSOFT = "https://login.live.com";
    @NonNull
    public static final String PAYPAL = "https://www.paypal.com";
    @NonNull
    public static final String TWITTER = "https://twitter.com";
    @NonNull
    public static final String YAHOO = "https://login.yahoo.com";

    private IdentityProviders() {
    }

    public static final String getIdentityProviderForAccount(@NonNull Account account) {
        Preconditions.checkNotNull(account, "account cannot be null");
        if ("com.google".equals(account.type)) {
            return GOOGLE;
        }
        if ("com.facebook.auth.login".equals(account.type)) {
            return FACEBOOK;
        }
        return null;
    }
}
