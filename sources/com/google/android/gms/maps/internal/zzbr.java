package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public abstract class zzbr extends com.google.android.gms.internal.maps.zzb implements zzbs {
    public zzbr() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        IStreetViewPanoramaDelegate zzbwVar;
        if (i8 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzbwVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (queryLocalInterface instanceof IStreetViewPanoramaDelegate) {
                    zzbwVar = (IStreetViewPanoramaDelegate) queryLocalInterface;
                } else {
                    zzbwVar = new zzbw(readStrongBinder);
                }
            }
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzb(zzbwVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
