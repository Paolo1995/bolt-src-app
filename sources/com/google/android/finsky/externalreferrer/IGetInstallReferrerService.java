package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.a.a;
import com.google.android.a.b;
import com.google.android.a.c;

/* loaded from: classes.dex */
public interface IGetInstallReferrerService extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends b implements IGetInstallReferrerService {

        /* loaded from: classes.dex */
        public static class Proxy extends a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
            public final Bundle f(Bundle bundle) throws RemoteException {
                Parcel y7 = y();
                c.b(y7, bundle);
                Parcel z7 = z(y7);
                Bundle bundle2 = (Bundle) c.a(z7, Bundle.CREATOR);
                z7.recycle();
                return bundle2;
            }
        }

        public static IGetInstallReferrerService z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof IGetInstallReferrerService) {
                return (IGetInstallReferrerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // com.google.android.a.b
        protected final boolean y(int i8, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i8 == 1) {
                Bundle f8 = f((Bundle) c.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                c.c(parcel2, f8);
                return true;
            }
            return false;
        }
    }

    Bundle f(Bundle bundle) throws RemoteException;
}
