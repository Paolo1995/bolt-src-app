package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public abstract class zzbu extends com.google.android.gms.internal.maps.zzb implements zzbv {
    public zzbu() {
        super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        if (i8 != 1) {
            if (i8 != 2) {
                return false;
            }
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzc(asInterface);
        } else {
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzb((Bitmap) com.google.android.gms.internal.maps.zzc.zza(parcel, Bitmap.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
