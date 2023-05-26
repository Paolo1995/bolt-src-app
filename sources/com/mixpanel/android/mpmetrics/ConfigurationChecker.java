package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import com.mixpanel.android.util.MPLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
class ConfigurationChecker {

    /* renamed from: a  reason: collision with root package name */
    public static String f19092a = "MixpanelAPI.ConfigurationChecker";

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f19093b;

    ConfigurationChecker() {
    }

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager != null && packageName != null) {
            if (packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
                MPLog.k(f19092a, "Package does not have permission android.permission.INTERNET - Mixpanel will not work at all!");
                MPLog.e(f19092a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
                return false;
            }
            return true;
        }
        MPLog.k(f19092a, "Can't check configuration when using a Context with null packageManager or packageName");
        return false;
    }

    public static boolean b(Future<SharedPreferences> future) {
        if (future != null) {
            try {
                if (future.get().getAll().size() == 0) {
                    return true;
                }
                return false;
            } catch (ClassNotFoundException unused) {
                MPLog.a(f19092a, "Missing com.android.installreferrer dependency. Google Play Store referrer information won't be available.");
                return false;
            } catch (InterruptedException unused2) {
                MPLog.k(f19092a, "Could not read referrer shared preferences.");
                return false;
            } catch (ExecutionException unused3) {
                MPLog.k(f19092a, "Could not read referrer shared preferences.");
                return false;
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager != null && packageName != null) {
            if (packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
                MPLog.k(f19092a, "Package does not have permission android.permission.INTERNET");
                MPLog.e(f19092a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
                return false;
            }
            try {
                ServiceInfo[] serviceInfoArr = packageManager.getPackageInfo(packageName, 4).services;
                if (serviceInfoArr != null && serviceInfoArr.length != 0) {
                    Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                    intent.setPackage(packageName);
                    List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
                    Iterator<ResolveInfo> it = queryIntentServices.iterator();
                    while (it.hasNext()) {
                        try {
                            if (!MixpanelFCMMessagingService.class.isAssignableFrom(Class.forName(it.next().serviceInfo.name))) {
                                it.remove();
                            }
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                    if (queryIntentServices.size() == 0) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            if (serviceInfo.name.equals(resolveInfo.serviceInfo.name) && serviceInfo.isEnabled()) {
                                arrayList.add(resolveInfo.serviceInfo);
                            }
                        }
                    }
                    if (arrayList.size() > 1) {
                        MPLog.k(f19092a, "You can't have more than one service handling \"com.google.firebase.MESSAGING_EVENT\" intent filter. Android will only use the first one that is declared on your AndroidManifest.xml. If you have more than one push provider you need to crate your own FirebaseMessagingService class.");
                    }
                    try {
                        String str = GooglePlayServicesUtil.GMS_ERROR_DIALOG;
                    } catch (ClassNotFoundException unused2) {
                        MPLog.k(f19092a, "Google Play Services aren't included in your build- push notifications won't work on Lollipop/API 21 or greater");
                        MPLog.e(f19092a, "You can fix this by adding com.google.android.gms:play-services as a dependency of your gradle or maven project");
                    }
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused3) {
            }
        }
        return false;
    }

    public static boolean d(Context context) {
        if (f19093b == null) {
            Intent intent = new Intent(context, TakeoverInAppActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(131072);
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
                String str = f19092a;
                MPLog.k(str, TakeoverInAppActivity.class.getName() + " is not registered as an activity in your application, so takeover in-apps can't be shown.");
                MPLog.e(f19092a, "Please add the child tag <activity android:name=\"com.mixpanel.android.takeoverinapp.TakeoverInAppActivity\" /> to your <application> tag.");
                Boolean bool = Boolean.FALSE;
                f19093b = bool;
                return bool.booleanValue();
            }
            f19093b = Boolean.TRUE;
        }
        return f19093b.booleanValue();
    }
}
