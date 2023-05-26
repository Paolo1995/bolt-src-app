package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public abstract class zzj extends com.google.android.gms.internal.maps.zzb implements ILocationSourceDelegate {
    public zzj() {
        super("com.google.android.gms.maps.internal.ILocationSourceDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        zzaj zzaiVar;
        if (i8 != 1) {
            if (i8 != 2) {
                return false;
            }
            deactivate();
        } else {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaiVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                if (queryLocalInterface instanceof zzaj) {
                    zzaiVar = (zzaj) queryLocalInterface;
                } else {
                    zzaiVar = new zzai(readStrongBinder);
                }
            }
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            activate(zzaiVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
