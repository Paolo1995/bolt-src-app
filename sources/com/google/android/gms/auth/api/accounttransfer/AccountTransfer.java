package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzao;
import com.google.android.gms.internal.auth.zzap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class AccountTransfer {
    @NonNull
    public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
    @NonNull
    public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
    @NonNull
    public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
    @NonNull
    public static final String KEY_EXTRA_ACCOUNT_TYPE = "key_extra_account_type";
    @NonNull
    public static final Api<zzq> zza;
    @Deprecated
    public static final zzao zzb;
    @Deprecated
    public static final zzao zzc;
    private static final Api.ClientKey<zzap> zzd;
    private static final Api.AbstractClientBuilder<zzap, zzq> zze;

    static {
        Api.ClientKey<zzap> clientKey = new Api.ClientKey<>();
        zzd = clientKey;
        zza zzaVar = new zza();
        zze = zzaVar;
        zza = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", zzaVar, clientKey);
        zzb = new zzao();
        zzc = new zzao();
    }

    private AccountTransfer() {
    }

    @NonNull
    public static AccountTransferClient getAccountTransferClient(@NonNull Activity activity) {
        return new AccountTransferClient(activity, (zzq) null);
    }

    @NonNull
    public static AccountTransferClient getAccountTransferClient(@NonNull Context context) {
        return new AccountTransferClient(context, (zzq) null);
    }
}
