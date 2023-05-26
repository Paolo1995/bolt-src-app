package com.google.android.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: BaseStub.java */
/* loaded from: classes.dex */
public class b extends Binder implements IInterface {
    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        attachInterface(this, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        if (i8 > 16777215) {
            if (super.onTransact(i8, parcel, parcel2, i9)) {
                return true;
            }
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
        }
        return y(i8, parcel, parcel2);
    }

    protected boolean y(int i8, Parcel parcel, Parcel parcel2) throws RemoteException {
        throw null;
    }
}
