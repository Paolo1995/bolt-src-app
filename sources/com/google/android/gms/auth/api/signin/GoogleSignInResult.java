package com.google.android.gms.auth.api.signin;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public class GoogleSignInResult implements Result {
    private Status zba;
    private GoogleSignInAccount zbb;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.zbb = googleSignInAccount;
        this.zba = status;
    }

    public GoogleSignInAccount getSignInAccount() {
        return this.zbb;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.zba;
    }

    public boolean isSuccess() {
        return this.zba.isSuccess();
    }
}
