package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@KeepForSdk
/* loaded from: classes3.dex */
public class ServiceStarter {

    /* renamed from: c  reason: collision with root package name */
    private static ServiceStarter f16329c;

    /* renamed from: a  reason: collision with root package name */
    private Boolean f16330a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f16331b = null;

    private ServiceStarter() {
    }

    @KeepForSdk
    public static synchronized ServiceStarter a() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (f16329c == null) {
                f16329c = new ServiceStarter();
            }
            serviceStarter = f16329c;
        }
        return serviceStarter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Context context) {
        boolean z7;
        if (this.f16331b == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f16331b = Boolean.valueOf(z7);
        }
        if (!this.f16330a.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f16331b.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Context context) {
        boolean z7;
        if (this.f16330a == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f16330a = Boolean.valueOf(z7);
        }
        if (!this.f16330a.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f16330a.booleanValue();
    }
}
