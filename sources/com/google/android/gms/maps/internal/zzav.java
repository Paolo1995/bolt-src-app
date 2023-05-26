package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public abstract class zzav extends com.google.android.gms.internal.maps.zzb implements zzaw {
    public zzav() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return false;
                }
                com.google.android.gms.internal.maps.zzaa zzb = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
                com.google.android.gms.internal.maps.zzc.zzc(parcel);
                zzc(zzb);
            } else {
                com.google.android.gms.internal.maps.zzaa zzb2 = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
                com.google.android.gms.internal.maps.zzc.zzc(parcel);
                zzb(zzb2);
            }
        } else {
            com.google.android.gms.internal.maps.zzaa zzb3 = com.google.android.gms.internal.maps.zzz.zzb(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.zzc(parcel);
            zzd(zzb3);
        }
        parcel2.writeNoException();
        return true;
    }
}
