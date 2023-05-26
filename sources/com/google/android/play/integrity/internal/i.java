package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public abstract class i extends b implements j {
    public i() {
        super("com.google.android.play.core.integrity.protocol.IIntegrityServiceCallback");
    }

    @Override // com.google.android.play.integrity.internal.b
    protected final boolean y(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        if (i8 == 2) {
            c.b(parcel);
            g((Bundle) c.a(parcel, Bundle.CREATOR));
            return true;
        }
        return false;
    }
}
