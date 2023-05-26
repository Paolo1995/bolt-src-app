package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.FirelogAnalyticsEvent;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class MessagingAnalytics {

    /* renamed from: a  reason: collision with root package name */
    private static final DataEncoder f16528a = new JsonDataEncoderBuilder().a(FirelogAnalyticsEvent.FirelogAnalyticsEventWrapper.class, new FirelogAnalyticsEvent.FirelogAnalyticsEventWrapperEncoder()).a(FirelogAnalyticsEvent.class, new FirelogAnalyticsEvent.FirelogAnalyticsEventEncoder()).i();

    public static boolean A(Intent intent) {
        if (intent != null && !s(intent)) {
            return a();
        }
        return false;
    }

    public static boolean B(Intent intent) {
        if (intent != null && !s(intent)) {
            return "1".equals(intent.getStringExtra("google.c.a.e"));
        }
        return false;
    }

    static boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            FirebaseApp.k();
            Context j8 = FirebaseApp.k().j();
            SharedPreferences sharedPreferences = j8.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = j8.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(j8.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Intent intent) {
        return intent.getStringExtra("collapse_key");
    }

    static String c(Intent intent) {
        return intent.getStringExtra("google.c.a.c_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Intent intent) {
        return intent.getStringExtra("google.c.a.c_l");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static String e(Intent intent) {
        String stringExtra = intent.getStringExtra("google.to");
        if (TextUtils.isEmpty(stringExtra)) {
            try {
                return (String) Tasks.await(FirebaseInstallations.o(FirebaseApp.k()).getId());
            } catch (InterruptedException | ExecutionException e8) {
                throw new RuntimeException(e8);
            }
        }
        return stringExtra;
    }

    static String f(Intent intent) {
        return intent.getStringExtra("google.c.a.m_c");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return intent.getStringExtra("message_id");
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Intent intent) {
        return intent.getStringExtra("google.c.a.m_l");
    }

    @NonNull
    private static int i(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        if ("normal".equals(str)) {
            return 2;
        }
        return 0;
    }

    static String j(Intent intent) {
        return intent.getStringExtra("google.c.a.ts");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static String k(Intent intent) {
        if (intent.getExtras() != null && NotificationParams.t(intent.getExtras())) {
            return "DISPLAY_NOTIFICATION";
        }
        return "DATA_MESSAGE";
    }

    @NonNull
    static String l(Intent intent) {
        if (intent.getExtras() != null && NotificationParams.t(intent.getExtras())) {
            return "display";
        }
        return "data";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static String m() {
        return FirebaseApp.k().j().getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static int n(Intent intent) {
        String stringExtra = intent.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if ("1".equals(intent.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = intent.getStringExtra("google.priority");
        }
        return i(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String o(Intent intent) {
        if (intent.hasExtra("google.c.sender.id")) {
            return intent.getStringExtra("google.c.sender.id");
        }
        FirebaseApp k8 = FirebaseApp.k();
        String d8 = k8.m().d();
        if (d8 != null) {
            return d8;
        }
        String c8 = k8.m().c();
        if (!c8.startsWith("1:")) {
            return c8;
        }
        String[] split = c8.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra != null && stringExtra.startsWith("/topics/")) {
            return stringExtra;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static int q(Intent intent) {
        Object obj = intent.getExtras().get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 13);
                sb.append("Invalid TTL: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString());
                return 0;
            }
        }
        return 0;
    }

    static String r(Intent intent) {
        if (intent.hasExtra("google.c.a.udt")) {
            return intent.getStringExtra("google.c.a.udt");
        }
        return null;
    }

    private static boolean s(Intent intent) {
        return FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction());
    }

    public static void t(Intent intent) {
        y("_nd", intent);
    }

    public static void u(Intent intent) {
        y("_nf", intent);
    }

    public static void v(Intent intent) {
        z(intent);
        y("_no", intent);
    }

    public static void w(Intent intent) {
        if (B(intent)) {
            y("_nr", intent);
        }
        if (A(intent)) {
            TransportFactory k8 = FirebaseMessaging.k();
            if (k8 != null) {
                x("MESSAGE_DELIVERED", intent, k8.a("FCM_CLIENT_EVENT_LOGGING", String.class, Encoding.b("json"), MessagingAnalytics$$Lambda$0.f16529a));
            } else {
                Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            }
        }
    }

    private static void x(String str, Intent intent, Transport<String> transport) {
        try {
            transport.b(Event.e(f16528a.b(new FirelogAnalyticsEvent.FirelogAnalyticsEventWrapper(new FirelogAnalyticsEvent("MESSAGE_DELIVERED", intent)))));
        } catch (EncodingException unused) {
            Log.d("FirebaseMessaging", "Failed to encode big query analytics payload. Skip sending");
        }
    }

    static void y(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String c8 = c(intent);
        if (c8 != null) {
            bundle.putString("_nmid", c8);
        }
        String d8 = d(intent);
        if (d8 != null) {
            bundle.putString("_nmn", d8);
        }
        String h8 = h(intent);
        if (!TextUtils.isEmpty(h8)) {
            bundle.putString("label", h8);
        }
        String f8 = f(intent);
        if (!TextUtils.isEmpty(f8)) {
            bundle.putString("message_channel", f8);
        }
        String p8 = p(intent);
        if (p8 != null) {
            bundle.putString("_nt", p8);
        }
        String j8 = j(intent);
        if (j8 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(j8));
            } catch (NumberFormatException e8) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e8);
            }
        }
        String r7 = r(intent);
        if (r7 != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(r7));
            } catch (NumberFormatException e9) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e9);
            }
        }
        String l8 = l(intent);
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", l8);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(str.length() + 37 + valueOf.length());
            sb.append("Logging to scion event=");
            sb.append(str);
            sb.append(" scionPayload=");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.k().i(AnalyticsConnector.class);
        if (analyticsConnector != null) {
            analyticsConnector.b(AppMeasurement.FCM_ORIGIN, str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    private static void z(Intent intent) {
        if (intent == null) {
            return;
        }
        if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
            AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.k().i(AnalyticsConnector.class);
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
            }
            if (analyticsConnector != null) {
                String stringExtra = intent.getStringExtra("google.c.a.c_id");
                analyticsConnector.c(AppMeasurement.FCM_ORIGIN, "_ln", stringExtra);
                Bundle bundle = new Bundle();
                bundle.putString("source", "Firebase");
                bundle.putString("medium", "notification");
                bundle.putString("campaign", stringExtra);
                analyticsConnector.b(AppMeasurement.FCM_ORIGIN, "_cmp", bundle);
                return;
            }
            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
        } else if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
        }
    }
}
