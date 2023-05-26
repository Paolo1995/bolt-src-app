package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.auth.zzap;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
abstract class zzk<T> extends TaskApiCall<zzap, T> {
    protected TaskCompletionSource<T> zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzk(int i8, zzb zzbVar) {
        super(null, false, i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* bridge */ /* synthetic */ void doExecute(zzap zzapVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzb = taskCompletionSource;
        zza((zzau) zzapVar.getService());
    }

    protected abstract void zza(zzau zzauVar) throws RemoteException;
}
