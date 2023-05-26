package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zbab  reason: invalid package */
/* loaded from: classes.dex */
public interface zbab extends IInterface {
    void zbb(Status status, PendingIntent pendingIntent) throws RemoteException;
}
