package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public interface zzak extends IInterface {
    void zzb(int i8, String[] strArr) throws RemoteException;

    void zzc(int i8, String[] strArr) throws RemoteException;

    void zzd(int i8, PendingIntent pendingIntent) throws RemoteException;
}
