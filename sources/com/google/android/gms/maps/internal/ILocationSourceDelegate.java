package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public interface ILocationSourceDelegate extends IInterface {
    void activate(zzaj zzajVar) throws RemoteException;

    void deactivate() throws RemoteException;
}
