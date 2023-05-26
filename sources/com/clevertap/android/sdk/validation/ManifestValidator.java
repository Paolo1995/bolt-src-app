package com.clevertap.android.sdk.validation;

import android.app.Application;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
import com.clevertap.android.sdk.pushnotification.CTNotificationIntentService;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationReceiver;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.pushnotification.amp.CTBackgroundIntentService;
import com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class ManifestValidator {
    private static void a(Context context) {
        String str = context.getApplicationInfo().className;
        if (str != null && !str.isEmpty()) {
            if (str.equals("com.clevertap.android.sdk.Application")) {
                Logger.j("AndroidManifest.xml uses the CleverTap Application class, be sure you have properly added the CleverTap Account ID and Token to your AndroidManifest.xml, \nor set them programmatically in the onCreate method of your custom application class prior to calling super.onCreate()");
                return;
            }
            Logger.j("Application Class is " + str);
            return;
        }
        Logger.j("Unable to determine Application Class");
    }

    private static void b(Context context, PushProviders pushProviders) {
        try {
            f((Application) context.getApplicationContext(), CTPushNotificationReceiver.class.getName());
            g((Application) context.getApplicationContext(), CTNotificationIntentService.class.getName());
            e((Application) context.getApplicationContext(), InAppNotificationActivity.class);
            e((Application) context.getApplicationContext(), CTInboxActivity.class);
            f((Application) context.getApplicationContext(), "com.clevertap.android.geofence.CTGeofenceReceiver");
            f((Application) context.getApplicationContext(), "com.clevertap.android.geofence.CTLocationUpdateReceiver");
            f((Application) context.getApplicationContext(), "com.clevertap.android.geofence.CTGeofenceBootReceiver");
            g((Application) context.getApplicationContext(), CTBackgroundJobService.class.getName());
            g((Application) context.getApplicationContext(), CTBackgroundIntentService.class.getName());
        } catch (Exception e8) {
            Logger.n("Receiver/Service issue : " + e8.toString());
        }
        ArrayList<PushConstants.PushType> y7 = pushProviders.y();
        if (y7 == null) {
            return;
        }
        Iterator<PushConstants.PushType> it = y7.iterator();
        while (it.hasNext()) {
            PushConstants.PushType next = it.next();
            if (next == PushConstants.PushType.FCM) {
                try {
                    g((Application) context.getApplicationContext(), "com.clevertap.android.sdk.pushnotification.fcm.FcmMessageListenerService");
                } catch (Error e9) {
                    Logger.n("FATAL : " + e9.getMessage());
                } catch (Exception e10) {
                    Logger.n("Receiver/Service issue : " + e10.toString());
                }
            } else if (next == PushConstants.PushType.HPS) {
                try {
                    g((Application) context.getApplicationContext(), "com.clevertap.android.hms.CTHmsMessageService");
                } catch (Error e11) {
                    Logger.n("FATAL : " + e11.getMessage());
                } catch (Exception e12) {
                    Logger.n("Receiver/Service issue : " + e12.toString());
                }
            } else if (next == PushConstants.PushType.XPS) {
                try {
                    f((Application) context.getApplicationContext(), "com.clevertap.android.xps.XiaomiMessageReceiver");
                } catch (Error e13) {
                    Logger.n("FATAL : " + e13.getMessage());
                } catch (Exception e14) {
                    Logger.n("Receiver/Service issue : " + e14.toString());
                }
            }
        }
    }

    private static void c(DeviceInfo deviceInfo) {
        Logger.j("SDK Version Code is " + deviceInfo.L());
    }

    public static void d(Context context, DeviceInfo deviceInfo, PushProviders pushProviders) {
        if (!Utils.t(context, "android.permission.INTERNET")) {
            Logger.a("Missing Permission: android.permission.INTERNET");
        }
        c(deviceInfo);
        h(context);
        b(context, pushProviders);
        if (!TextUtils.isEmpty(ManifestInfo.i(context).h())) {
            Logger.j("We have noticed that your app is using a custom FCM Sender ID, this feature will be DISCONTINUED from the next version of the CleverTap Android SDK. With the next release, CleverTap Android SDK will only fetch the token using the google-services.json. Please reach out to CleverTap Support for any questions.");
        }
    }

    private static void e(Application application, Class cls) throws PackageManager.NameNotFoundException {
        ActivityInfo[] activityInfoArr = application.getPackageManager().getPackageInfo(application.getPackageName(), 1).activities;
        String name = cls.getName();
        for (ActivityInfo activityInfo : activityInfoArr) {
            if (activityInfo.name.equals(name)) {
                Logger.j(name.replaceFirst("com.clevertap.android.sdk.", "") + " is present");
                return;
            }
        }
        Logger.j(name.replaceFirst("com.clevertap.android.sdk.", "") + " not present");
    }

    private static void f(Application application, String str) throws PackageManager.NameNotFoundException {
        for (ActivityInfo activityInfo : application.getPackageManager().getPackageInfo(application.getPackageName(), 2).receivers) {
            if (activityInfo.name.equals(str)) {
                Logger.j(str.replaceFirst("com.clevertap.android.", "") + " is present");
                return;
            }
        }
        Logger.j(str.replaceFirst("com.clevertap.android.", "") + " not present");
    }

    private static void g(Application application, String str) throws PackageManager.NameNotFoundException {
        for (ServiceInfo serviceInfo : application.getPackageManager().getPackageInfo(application.getPackageName(), 4).services) {
            if (serviceInfo.name.equals(str)) {
                Logger.j(str.replaceFirst("com.clevertap.android.sdk.", "") + " is present");
                return;
            }
        }
        Logger.j(str.replaceFirst("com.clevertap.android.sdk.", "") + " not present");
    }

    private static void h(Context context) {
        if (!ActivityLifecycleCallback.f10807a && !CleverTapAPI.M()) {
            Logger.j("Activity Lifecycle Callback not registered. Either set the android:name in your AndroidManifest.xml application tag to com.clevertap.android.sdk.Application, \n or, if you have a custom Application class, call ActivityLifecycleCallback.register(this); before super.onCreate() in your class");
            a(context);
        }
    }
}
