package com.google.android.gms.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public class UserRecoverableNotifiedException extends GoogleAuthException {
    @VisibleForTesting
    public UserRecoverableNotifiedException(@NonNull String str) {
        super(str);
    }
}
