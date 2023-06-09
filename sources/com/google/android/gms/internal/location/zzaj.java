package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public abstract class zzaj extends zzb implements zzak {
    public zzaj() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i8, Parcel parcel, Parcel parcel2, int i9) throws RemoteException {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return false;
                }
                zzd(parcel.readInt(), (PendingIntent) zzc.zzb(parcel, PendingIntent.CREATOR));
            } else {
                zzc(parcel.readInt(), parcel.createStringArray());
            }
        } else {
            zzb(parcel.readInt(), parcel.createStringArray());
        }
        return true;
    }
}
