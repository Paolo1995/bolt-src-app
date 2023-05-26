package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import java.util.List;

/* loaded from: classes.dex */
public interface ICustomTabsService extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ICustomTabsService {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ICustomTabsService {

            /* renamed from: b  reason: collision with root package name */
            public static ICustomTabsService f736b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f737a;

            Proxy(IBinder iBinder) {
                this.f737a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f737a;
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean i(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (iCustomTabsCallback != null) {
                        iBinder = iCustomTabsCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z7 = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f737a.transact(10, obtain, obtain2, 0) && Stub.z() != null) {
                        return Stub.z().i(iCustomTabsCallback, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z7 = false;
                    }
                    return z7;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean o(long j8) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeLong(j8);
                    boolean z7 = false;
                    if (!this.f737a.transact(2, obtain, obtain2, 0) && Stub.z() != null) {
                        return Stub.z().o(j8);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z7 = true;
                    }
                    return z7;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean q(ICustomTabsCallback iCustomTabsCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    if (iCustomTabsCallback != null) {
                        iBinder = iCustomTabsCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean z7 = false;
                    if (!this.f737a.transact(3, obtain, obtain2, 0) && Stub.z() != null) {
                        return Stub.z().q(iCustomTabsCallback);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z7 = true;
                    }
                    return z7;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        public static ICustomTabsService y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICustomTabsService)) {
                return (ICustomTabsService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ICustomTabsService z() {
            return Proxy.f736b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
            Uri uri;
            Uri uri2;
            Uri uri3;
            Uri uri4;
            if (i8 != 1598968902) {
                Bundle bundle = null;
                Bundle bundle2 = null;
                Bundle bundle3 = null;
                Bundle bundle4 = null;
                Bundle bundle5 = null;
                Bundle bundle6 = null;
                Uri uri5 = null;
                Bundle bundle7 = null;
                Bundle bundle8 = null;
                switch (i8) {
                    case 2:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean o8 = o(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(o8 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean q8 = q(ICustomTabsCallback.Stub.y(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(q8 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback y7 = ICustomTabsCallback.Stub.y(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        } else {
                            uri = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean m8 = m(y7, uri, bundle, parcel.createTypedArrayList(Bundle.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(m8 ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle8 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        Bundle e8 = e(readString, bundle8);
                        parcel2.writeNoException();
                        if (e8 != null) {
                            parcel2.writeInt(1);
                            e8.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback y8 = ICustomTabsCallback.Stub.y(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            bundle7 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean k8 = k(y8, bundle7);
                        parcel2.writeNoException();
                        parcel2.writeInt(k8 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback y9 = ICustomTabsCallback.Stub.y(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            uri5 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        }
                        boolean s7 = s(y9, uri5);
                        parcel2.writeNoException();
                        parcel2.writeInt(s7 ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback y10 = ICustomTabsCallback.Stub.y(parcel.readStrongBinder());
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle6 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        int p8 = p(y10, readString2, bundle6);
                        parcel2.writeNoException();
                        parcel2.writeInt(p8);
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback y11 = ICustomTabsCallback.Stub.y(parcel.readStrongBinder());
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        } else {
                            uri2 = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean a8 = a(y11, readInt, uri2, bundle5);
                        parcel2.writeNoException();
                        parcel2.writeInt(a8 ? 1 : 0);
                        return true;
                    case 10:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback y12 = ICustomTabsCallback.Stub.y(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean i10 = i(y12, bundle4);
                        parcel2.writeNoException();
                        parcel2.writeInt(i10 ? 1 : 0);
                        return true;
                    case 11:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback y13 = ICustomTabsCallback.Stub.y(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            uri3 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        } else {
                            uri3 = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean h8 = h(y13, uri3, bundle3);
                        parcel2.writeNoException();
                        parcel2.writeInt(h8 ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback y14 = ICustomTabsCallback.Stub.y(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            uri4 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        } else {
                            uri4 = null;
                        }
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        boolean c8 = c(y14, uri4, readInt2, bundle2);
                        parcel2.writeNoException();
                        parcel2.writeInt(c8 ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i8, parcel, parcel2, i9);
                }
            }
            parcel2.writeString("android.support.customtabs.ICustomTabsService");
            return true;
        }
    }

    boolean a(ICustomTabsCallback iCustomTabsCallback, int i8, Uri uri, Bundle bundle) throws RemoteException;

    boolean c(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i8, Bundle bundle) throws RemoteException;

    Bundle e(String str, Bundle bundle) throws RemoteException;

    boolean h(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) throws RemoteException;

    boolean i(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException;

    boolean k(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException;

    boolean m(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean o(long j8) throws RemoteException;

    int p(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) throws RemoteException;

    boolean q(ICustomTabsCallback iCustomTabsCallback) throws RemoteException;

    boolean s(ICustomTabsCallback iCustomTabsCallback, Uri uri) throws RemoteException;
}
