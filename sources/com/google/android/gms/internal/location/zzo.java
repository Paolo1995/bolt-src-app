package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
final class zzo extends zzx {
    final /* synthetic */ boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzo(zzz zzzVar, GoogleApiClient googleApiClient, boolean z7) {
        super(googleApiClient);
        this.zza = z7;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(zzaz zzazVar) throws RemoteException {
        zzazVar.zzI(this.zza);
        setResult((zzo) Status.RESULT_SUCCESS);
    }
}
