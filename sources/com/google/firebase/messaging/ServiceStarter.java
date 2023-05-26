package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
@KeepForSdk
/* loaded from: classes3.dex */
public class ServiceStarter {

    /* renamed from: e  reason: collision with root package name */
    private static ServiceStarter f16570e;
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private String f16571a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f16572b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f16573c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Intent> f16574d = new ArrayDeque();

    private ServiceStarter() {
    }

    private int a(Context context, Intent intent) {
        ComponentName startService;
        String str;
        String f8 = f(context, intent);
        if (f8 != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                if (f8.length() != 0) {
                    str = "Restricting intent to a specific service: ".concat(f8);
                } else {
                    str = new String("Restricting intent to a specific service: ");
                }
                Log.d("FirebaseMessaging", str);
            }
            intent.setClassName(context.getPackageName(), f8);
        }
        try {
            if (e(context)) {
                startService = WakeLockHolder.e(context, intent);
            } else {
                startService = context.startService(intent);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if (startService == null) {
                Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            return -1;
        } catch (IllegalStateException e8) {
            String valueOf = String.valueOf(e8);
            StringBuilder sb = new StringBuilder(valueOf.length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf);
            Log.e("FirebaseMessaging", sb.toString());
            return 402;
        } catch (SecurityException e9) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e9);
            return 401;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized ServiceStarter b() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (f16570e == null) {
                f16570e = new ServiceStarter();
            }
            serviceStarter = f16570e;
        }
        return serviceStarter;
    }

    private synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2;
        String str3 = this.f16571a;
        if (str3 != null) {
            return str3;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(serviceInfo.name);
                    if (valueOf2.length() != 0) {
                        str2 = valueOf.concat(valueOf2);
                    } else {
                        str2 = new String(valueOf);
                    }
                    this.f16571a = str2;
                } else {
                    this.f16571a = serviceInfo.name;
                }
                return this.f16571a;
            }
            String str4 = serviceInfo.packageName;
            String str5 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 94 + String.valueOf(str5).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str4);
            sb.append("/");
            sb.append(str5);
            Log.e("FirebaseMessaging", sb.toString());
            return null;
        }
        Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent c() {
        return this.f16574d.poll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Context context) {
        boolean z7;
        if (this.f16573c == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f16573c = Boolean.valueOf(z7);
        }
        if (!this.f16572b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f16573c.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(Context context) {
        boolean z7;
        if (this.f16572b == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f16572b = Boolean.valueOf(z7);
        }
        if (!this.f16572b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f16572b.booleanValue();
    }

    public int g(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        this.f16574d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
