package com.google.android.gms.auth.api.accounttransfer;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public class AccountTransferException extends ApiException {
    public AccountTransferException(@NonNull Status status) {
        super(status);
    }
}
