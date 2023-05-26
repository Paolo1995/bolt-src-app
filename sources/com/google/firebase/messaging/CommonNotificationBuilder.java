package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import java.util.concurrent.atomic.AtomicInteger;
import org.jctools.util.Pow2;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public final class CommonNotificationBuilder {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f16452a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    public static class DisplayNotificationInfo {

        /* renamed from: a  reason: collision with root package name */
        public final NotificationCompat.Builder f16453a;

        /* renamed from: b  reason: collision with root package name */
        public final String f16454b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16455c = 0;

        DisplayNotificationInfo(NotificationCompat.Builder builder, String str, int i8) {
            this.f16453a = builder;
            this.f16454b = str;
        }
    }

    private CommonNotificationBuilder() {
    }

    private static PendingIntent a(Context context, NotificationParams notificationParams, String str, PackageManager packageManager) {
        Intent f8 = f(str, notificationParams, packageManager);
        if (f8 == null) {
            return null;
        }
        f8.addFlags(67108864);
        f8.putExtras(notificationParams.y());
        PendingIntent activity = PendingIntent.getActivity(context, g(), f8, l(Pow2.MAX_POW2));
        if (q(notificationParams)) {
            return r(context, notificationParams, activity);
        }
        return activity;
    }

    private static PendingIntent b(Context context, NotificationParams notificationParams) {
        if (!q(notificationParams)) {
            return null;
        }
        return c(context, new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS).putExtras(notificationParams.x()));
    }

    private static PendingIntent c(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra(CloudMessagingReceiver.IntentKeys.WRAPPED_INTENT, intent), l(Pow2.MAX_POW2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayNotificationInfo d(Context context, NotificationParams notificationParams) {
        Bundle j8 = j(context.getPackageManager(), context.getPackageName());
        return e(context, context.getPackageName(), notificationParams, k(context, notificationParams.k(), j8), context.getResources(), context.getPackageManager(), j8);
    }

    public static DisplayNotificationInfo e(Context context, String str, NotificationParams notificationParams, String str2, Resources resources, PackageManager packageManager, Bundle bundle) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, str2);
        String n8 = notificationParams.n(resources, str, "gcm.n.title");
        if (!TextUtils.isEmpty(n8)) {
            builder.o(n8);
        }
        String n9 = notificationParams.n(resources, str, "gcm.n.body");
        if (!TextUtils.isEmpty(n9)) {
            builder.n(n9);
            builder.F(new NotificationCompat.BigTextStyle().h(n9));
        }
        builder.C(m(packageManager, resources, str, notificationParams.p("gcm.n.icon"), bundle));
        Uri n10 = n(str, notificationParams, resources);
        if (n10 != null) {
            builder.D(n10);
        }
        builder.m(a(context, notificationParams, str, packageManager));
        PendingIntent b8 = b(context, notificationParams);
        if (b8 != null) {
            builder.s(b8);
        }
        Integer h8 = h(context, notificationParams.p("gcm.n.color"), bundle);
        if (h8 != null) {
            builder.k(h8.intValue());
        }
        builder.g(!notificationParams.a("gcm.n.sticky"));
        builder.x(notificationParams.a("gcm.n.local_only"));
        String p8 = notificationParams.p("gcm.n.ticker");
        if (p8 != null) {
            builder.H(p8);
        }
        Integer m8 = notificationParams.m();
        if (m8 != null) {
            builder.A(m8.intValue());
        }
        Integer r7 = notificationParams.r();
        if (r7 != null) {
            builder.J(r7.intValue());
        }
        Integer l8 = notificationParams.l();
        if (l8 != null) {
            builder.y(l8.intValue());
        }
        Long j8 = notificationParams.j("gcm.n.event_time");
        if (j8 != null) {
            builder.B(true);
            builder.K(j8.longValue());
        }
        long[] q8 = notificationParams.q();
        if (q8 != null) {
            builder.I(q8);
        }
        int[] e8 = notificationParams.e();
        if (e8 != null) {
            builder.w(e8[0], e8[1], e8[2]);
        }
        builder.r(i(notificationParams));
        return new DisplayNotificationInfo(builder, o(notificationParams), 0);
    }

    private static Intent f(String str, NotificationParams notificationParams, PackageManager packageManager) {
        String p8 = notificationParams.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p8)) {
            Intent intent = new Intent(p8);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f8 = notificationParams.f();
        if (f8 != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f8);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return f16452a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i8 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i8 != 0) {
            try {
                return Integer.valueOf(ContextCompat.getColor(context, i8));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    private static int i(NotificationParams notificationParams) {
        boolean a8 = notificationParams.a("gcm.n.default_sound");
        ?? r02 = a8;
        if (notificationParams.a("gcm.n.default_vibrate_timings")) {
            r02 = (a8 ? 1 : 0) | true;
        }
        if (notificationParams.a("gcm.n.default_light_settings")) {
            return r02 | 4;
        }
        return r02;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e8) {
            String valueOf = String.valueOf(e8);
            StringBuilder sb = new StringBuilder(valueOf.length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    public static String k(Context context, String str, Bundle bundle) {
        Object systemService;
        NotificationChannel notificationChannel;
        String string;
        NotificationChannel notificationChannel2;
        NotificationChannel notificationChannel3;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion >= 26) {
                systemService = context.getSystemService(NotificationManager.class);
                NotificationManager notificationManager = (NotificationManager) systemService;
                if (!TextUtils.isEmpty(str)) {
                    notificationChannel3 = notificationManager.getNotificationChannel(str);
                    if (notificationChannel3 != null) {
                        return str;
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                    sb.append("Notification Channel requested (");
                    sb.append(str);
                    sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                    Log.w("FirebaseMessaging", sb.toString());
                }
                String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                if (!TextUtils.isEmpty(string2)) {
                    notificationChannel2 = notificationManager.getNotificationChannel(string2);
                    if (notificationChannel2 != null) {
                        return string2;
                    }
                    Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                } else {
                    Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                }
                notificationChannel = notificationManager.getNotificationChannel("fcm_fallback_notification_channel");
                if (notificationChannel == null) {
                    int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                    if (identifier == 0) {
                        Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                        string = "Misc";
                    } else {
                        string = context.getString(identifier);
                    }
                    notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", string, 3));
                }
                return "fcm_fallback_notification_channel";
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static int l(int i8) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 1140850688;
        }
        return Pow2.MAX_POW2;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 61);
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i8 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i8 == 0 || !p(resources, i8)) {
            try {
                i8 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e8) {
                String valueOf = String.valueOf(e8);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        if (i8 == 0 || !p(resources, i8)) {
            return 17301651;
        }
        return i8;
    }

    private static Uri n(String str, NotificationParams notificationParams, Resources resources) {
        String o8 = notificationParams.o();
        if (TextUtils.isEmpty(o8)) {
            return null;
        }
        if (!"default".equals(o8) && resources.getIdentifier(o8, "raw", str) != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(o8).length());
            sb.append("android.resource://");
            sb.append(str);
            sb.append("/raw/");
            sb.append(o8);
            return Uri.parse(sb.toString());
        }
        return RingtoneManager.getDefaultUri(2);
    }

    private static String o(NotificationParams notificationParams) {
        String p8 = notificationParams.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p8)) {
            return p8;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        StringBuilder sb = new StringBuilder(37);
        sb.append("FCM-Notification:");
        sb.append(uptimeMillis);
        return sb.toString();
    }

    @TargetApi(26)
    private static boolean p(Resources resources, int i8) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i8, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i8);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i8);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    static boolean q(@NonNull NotificationParams notificationParams) {
        return notificationParams.a("google.c.a.e");
    }

    private static PendingIntent r(Context context, NotificationParams notificationParams, PendingIntent pendingIntent) {
        return c(context, new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_OPEN).putExtras(notificationParams.x()).putExtra(CloudMessagingReceiver.IntentKeys.PENDING_INTENT, pendingIntent));
    }
}
