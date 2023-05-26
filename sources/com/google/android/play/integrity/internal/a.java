package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f14611a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14612b = "com.google.android.play.core.integrity.protocol.IIntegrityService";

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f14611a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f14611a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel y() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f14612b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z(int i8, Parcel parcel) throws RemoteException {
        try {
            this.f14611a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
