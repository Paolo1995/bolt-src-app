package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public abstract class zzar extends com.google.android.gms.internal.maps.zzb implements zzas {
    public zzar() {
        super("com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        IGoogleMapDelegate zzgVar;
        if (i8 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzgVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                if (queryLocalInterface instanceof IGoogleMapDelegate) {
                    zzgVar = (IGoogleMapDelegate) queryLocalInterface;
                } else {
                    zzgVar = new zzg(readStrongBinder);
                }
            }
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzb(zzgVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
