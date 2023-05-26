package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public final class f extends a implements h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
    }

    @Override // com.google.android.play.integrity.internal.h
    public final void v(Bundle bundle, j jVar) throws RemoteException {
        Parcel y7 = y();
        c.c(y7, bundle);
        c.d(y7, jVar);
        z(2, y7);
    }
}
