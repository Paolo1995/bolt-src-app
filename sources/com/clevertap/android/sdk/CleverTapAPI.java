package com.clevertap.android.sdk;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.inbox.CTMessageDAO;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.pushnotification.NotificationInfo;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.validation.ManifestValidator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class CleverTapAPI implements CTInboxActivity.InboxActivityListener {

    /* renamed from: d  reason: collision with root package name */
    private static int f10874d = LogLevel.INFO.a();

    /* renamed from: e  reason: collision with root package name */
    static CleverTapInstanceConfig f10875e;

    /* renamed from: f  reason: collision with root package name */
    private static HashMap<String, CleverTapAPI> f10876f;

    /* renamed from: g  reason: collision with root package name */
    private static String f10877g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f10878a;

    /* renamed from: b  reason: collision with root package name */
    private CoreState f10879b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<InboxMessageButtonListener> f10880c;

    /* loaded from: classes.dex */
    public interface DevicePushTokenRefreshListener {
        void a(String str, PushConstants.PushType pushType);
    }

    /* loaded from: classes.dex */
    public enum LogLevel {
        OFF(-1),
        INFO(0),
        DEBUG(2),
        VERBOSE(3);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f10904f;

        LogLevel(int i8) {
            this.f10904f = i8;
        }

        public int a() {
            return this.f10904f;
        }
    }

    private CleverTapAPI(final Context context, final CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        this.f10878a = context;
        j0(CleverTapFactory.a(context, cleverTapInstanceConfig, str));
        Logger u7 = u();
        u7.s(cleverTapInstanceConfig.c() + ":async_deviceID", "CoreState is set");
        CTExecutorFactory.a(cleverTapInstanceConfig).c().d("CleverTapAPI#initializeDeviceInfo", new Callable<Void>() { // from class: com.clevertap.android.sdk.CleverTapAPI.9
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                if (cleverTapInstanceConfig.t()) {
                    CleverTapAPI.this.O();
                    return null;
                }
                return null;
            }
        });
        if (Utils.r() - CoreMetaData.l() > 5) {
            this.f10879b.e().C();
        }
        CTExecutorFactory.a(cleverTapInstanceConfig).c().d("setStatesAsync", new Callable<Void>() { // from class: com.clevertap.android.sdk.CleverTapAPI.10
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                CleverTapAPI.this.f10879b.l().f();
                CleverTapAPI.this.f10879b.g().Z();
                CleverTapAPI.this.f10879b.g().Y();
                return null;
            }
        });
        CTExecutorFactory.a(cleverTapInstanceConfig).c().d("saveConfigtoSharedPrefs", new Callable<Void>() { // from class: com.clevertap.android.sdk.CleverTapAPI.11
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                String D = cleverTapInstanceConfig.D();
                if (D == null) {
                    Logger.n("Unable to save config to SharedPrefs, config Json is null");
                    return null;
                }
                StorageHelper.p(context, StorageHelper.s(cleverTapInstanceConfig, "instance"), D);
                return null;
            }
        });
        Logger.j("CleverTap SDK initialized with accountId: " + cleverTapInstanceConfig.c() + " accountToken: " + cleverTapInstanceConfig.e() + " accountRegion: " + cleverTapInstanceConfig.d());
    }

    private static CleverTapAPI A(Context context) {
        HashMap<String, CleverTapAPI> hashMap;
        CleverTapAPI y7 = y(context);
        if (y7 == null && (hashMap = f10876f) != null && !hashMap.isEmpty()) {
            for (String str : f10876f.keySet()) {
                y7 = f10876f.get(str);
                if (y7 != null) {
                    break;
                }
            }
        }
        return y7;
    }

    public static NotificationInfo E(Bundle bundle) {
        boolean z7 = false;
        if (bundle == null) {
            return new NotificationInfo(false, false);
        }
        boolean containsKey = bundle.containsKey("wzrk_pn");
        if (containsKey && bundle.containsKey("nm")) {
            z7 = true;
        }
        return new NotificationInfo(containsKey, z7);
    }

    public static void I(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String str = null;
        try {
            str = bundle.getString("wzrk_acct_id");
        } catch (Throwable unused) {
        }
        HashMap<String, CleverTapAPI> hashMap = f10876f;
        if (hashMap == null) {
            CleverTapAPI k8 = k(context, str);
            if (k8 != null) {
                k8.b0(bundle);
                return;
            }
            return;
        }
        for (String str2 : hashMap.keySet()) {
            CleverTapAPI cleverTapAPI = f10876f.get(str2);
            boolean z7 = false;
            if (cleverTapAPI != null && ((str == null && cleverTapAPI.f10879b.e().t()) || cleverTapAPI.q().equals(str))) {
                z7 = true;
                continue;
            }
            if (z7) {
                cleverTapAPI.b0(bundle);
                return;
            }
        }
    }

    public static CleverTapAPI K(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        return L(context, cleverTapInstanceConfig, null);
    }

    public static CleverTapAPI L(Context context, @NonNull CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        if (cleverTapInstanceConfig == null) {
            Logger.n("CleverTapInstanceConfig cannot be null");
            return null;
        }
        if (f10876f == null) {
            f10876f = new HashMap<>();
        }
        CleverTapAPI cleverTapAPI = f10876f.get(cleverTapInstanceConfig.c());
        if (cleverTapAPI == null) {
            cleverTapAPI = new CleverTapAPI(context, cleverTapInstanceConfig, str);
            f10876f.put(cleverTapInstanceConfig.c(), cleverTapAPI);
            CTExecutorFactory.a(cleverTapAPI.f10879b.e()).c().d("recordDeviceIDErrors", new Callable<Void>() { // from class: com.clevertap.android.sdk.CleverTapAPI.8
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    if (CleverTapAPI.this.s() != null) {
                        CleverTapAPI.this.f10879b.j().x();
                        return null;
                    }
                    return null;
                }
            });
        } else if (cleverTapAPI.N() && cleverTapAPI.t().i() && Utils.x(str)) {
            cleverTapAPI.f10879b.j().u(null, null, str);
        }
        Logger.o(cleverTapInstanceConfig.c() + ":async_deviceID", "CleverTapAPI instance = " + cleverTapAPI);
        return cleverTapAPI;
    }

    public static boolean M() {
        return CoreMetaData.v();
    }

    private boolean N() {
        return this.f10879b.g().R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        CTExecutorFactory.a(this.f10879b.e()).c().d("Manifest Validation", new Callable<Void>() { // from class: com.clevertap.android.sdk.CleverTapAPI.15
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                ManifestValidator.d(CleverTapAPI.this.f10878a, CleverTapAPI.this.f10879b.g(), CleverTapAPI.this.f10879b.k());
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Q(Activity activity) {
        R(activity, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:9|(2:10|11)|(6:(7:57|58|14|15|16|(7:20|(1:22)|35|(2:32|33)|25|(2:28|29)|27)|(5:39|40|(4:43|(3:45|46|47)(1:49)|48|41)|50|51)(1:38))|39|40|(1:41)|50|51)|13|14|15|16|(8:18|20|(0)|35|(0)|25|(0)|27)|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        if ("CTPushNotificationReceiver".equals(r3.get("wzrk_from")) != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #4 {all -> 0x008a, blocks: (B:17:0x0035, B:19:0x003f, B:21:0x0045, B:23:0x004b), top: B:58:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082 A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #2 {all -> 0x0079, blocks: (B:28:0x005b, B:31:0x007c, B:33:0x0082), top: B:54:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[Catch: all -> 0x00ba, TryCatch #3 {all -> 0x00ba, blocks: (B:39:0x0090, B:40:0x009a, B:42:0x00a0, B:44:0x00b0), top: B:56:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void R(android.app.Activity r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "wzrk_from"
            java.lang.String r1 = "wzrk_acct_id"
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r2 = com.clevertap.android.sdk.CleverTapAPI.f10876f
            r3 = 0
            if (r2 != 0) goto L10
            android.content.Context r2 = r6.getApplicationContext()
            l(r2, r3, r7)
        L10:
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r7 = com.clevertap.android.sdk.CleverTapAPI.f10876f
            if (r7 != 0) goto L1a
            java.lang.String r6 = "Instances is null in onActivityCreated!"
            com.clevertap.android.sdk.Logger.n(r6)
            return
        L1a:
            r7 = 1
            android.content.Intent r2 = r6.getIntent()     // Catch: java.lang.Throwable -> L32
            android.net.Uri r2 = r2.getData()     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L33
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L33
            android.os.Bundle r4 = com.clevertap.android.sdk.utils.UriHelper.a(r4, r7)     // Catch: java.lang.Throwable -> L33
            java.lang.String r4 = r4.getString(r1)     // Catch: java.lang.Throwable -> L33
            goto L34
        L32:
            r2 = r3
        L33:
            r4 = r3
        L34:
            r5 = 0
            android.content.Intent r6 = r6.getIntent()     // Catch: java.lang.Throwable -> L8a
            android.os.Bundle r3 = r6.getExtras()     // Catch: java.lang.Throwable -> L8a
            if (r3 == 0) goto L8b
            boolean r6 = r3.isEmpty()     // Catch: java.lang.Throwable -> L8a
            if (r6 != 0) goto L8b
            boolean r6 = r3.containsKey(r0)     // Catch: java.lang.Throwable -> L8a
            if (r6 == 0) goto L58
            java.lang.String r6 = "CTPushNotificationReceiver"
            java.lang.Object r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L8a
            boolean r6 = r6.equals(r0)     // Catch: java.lang.Throwable -> L8a
            if (r6 == 0) goto L58
            goto L59
        L58:
            r7 = 0
        L59:
            if (r7 == 0) goto L7c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r6.<init>()     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = "ActivityLifecycleCallback: Notification Clicked already processed for "
            r6.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L79
            r6.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = ", dropping duplicate."
            r6.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L79
            com.clevertap.android.sdk.Logger.n(r6)     // Catch: java.lang.Throwable -> L79
            goto L7c
        L79:
        L7a:
            r5 = r7
            goto L8b
        L7c:
            boolean r6 = r3.containsKey(r1)     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L7a
            java.lang.Object r6 = r3.get(r1)     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L79
            r4 = r6
            goto L7a
        L8a:
        L8b:
            if (r5 == 0) goto L90
            if (r2 != 0) goto L90
            return
        L90:
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r6 = com.clevertap.android.sdk.CleverTapAPI.f10876f     // Catch: java.lang.Throwable -> Lba
            java.util.Set r6 = r6.keySet()     // Catch: java.lang.Throwable -> Lba
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> Lba
        L9a:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> Lba
            if (r7 == 0) goto Ld3
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> Lba
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r0 = com.clevertap.android.sdk.CleverTapAPI.f10876f     // Catch: java.lang.Throwable -> Lba
            java.lang.Object r7 = r0.get(r7)     // Catch: java.lang.Throwable -> Lba
            com.clevertap.android.sdk.CleverTapAPI r7 = (com.clevertap.android.sdk.CleverTapAPI) r7     // Catch: java.lang.Throwable -> Lba
            if (r7 == 0) goto L9a
            com.clevertap.android.sdk.CoreState r7 = r7.f10879b     // Catch: java.lang.Throwable -> Lba
            com.clevertap.android.sdk.ActivityLifeCycleManager r7 = r7.a()     // Catch: java.lang.Throwable -> Lba
            r7.h(r3, r2, r4)     // Catch: java.lang.Throwable -> Lba
            goto L9a
        Lba:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Throwable - "
            r7.append(r0)
            java.lang.String r6 = r6.getLocalizedMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.clevertap.android.sdk.Logger.n(r6)
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.R(android.app.Activity, java.lang.String):void");
    }

    public static void S() {
        HashMap<String, CleverTapAPI> hashMap = f10876f;
        if (hashMap == null) {
            return;
        }
        for (String str : hashMap.keySet()) {
            CleverTapAPI cleverTapAPI = f10876f.get(str);
            if (cleverTapAPI != null) {
                try {
                    cleverTapAPI.f10879b.a().e();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void T(Activity activity) {
        U(activity, null);
    }

    public static void U(Activity activity, String str) {
        if (f10876f == null) {
            l(activity.getApplicationContext(), null, str);
        }
        CoreMetaData.G(true);
        if (f10876f == null) {
            Logger.n("Instances is null in onActivityResumed!");
            return;
        }
        String i8 = CoreMetaData.i();
        CoreMetaData.L(activity);
        if (i8 == null || !i8.equals(activity.getLocalClassName())) {
            CoreMetaData.u();
        }
        if (CoreMetaData.l() <= 0) {
            CoreMetaData.R(Utils.r());
        }
        for (String str2 : f10876f.keySet()) {
            CleverTapAPI cleverTapAPI = f10876f.get(str2);
            if (cleverTapAPI != null) {
                try {
                    cleverTapAPI.f10879b.a().f(activity);
                } catch (Throwable th) {
                    Logger.n("Throwable - " + th.getLocalizedMessage());
                }
            }
        }
    }

    public static void g0(Context context) {
        HashMap<String, CleverTapAPI> hashMap = f10876f;
        if (hashMap == null) {
            CleverTapAPI y7 = y(context);
            if (y7 != null) {
                if (y7.t().q()) {
                    y7.f10879b.k().R(context, null);
                    return;
                } else {
                    Logger.a("Instance doesn't allow Background sync, not running the Job");
                    return;
                }
            }
            return;
        }
        for (String str : hashMap.keySet()) {
            CleverTapAPI cleverTapAPI = f10876f.get(str);
            if (cleverTapAPI != null) {
                if (cleverTapAPI.t().p()) {
                    Logger.b(str, "Instance is Analytics Only not processing device token");
                } else if (!cleverTapAPI.t().q()) {
                    Logger.b(str, "Instance doesn't allow Background sync, not running the Job");
                } else {
                    cleverTapAPI.f10879b.k().R(context, null);
                }
            }
        }
    }

    public static void h0(Context context, JobParameters jobParameters) {
        HashMap<String, CleverTapAPI> hashMap = f10876f;
        if (hashMap == null) {
            CleverTapAPI y7 = y(context);
            if (y7 != null) {
                if (y7.t().q()) {
                    y7.f10879b.k().R(context, jobParameters);
                    return;
                } else {
                    Logger.a("Instance doesn't allow Background sync, not running the Job");
                    return;
                }
            }
            return;
        }
        for (String str : hashMap.keySet()) {
            CleverTapAPI cleverTapAPI = f10876f.get(str);
            if (cleverTapAPI != null && cleverTapAPI.t().p()) {
                Logger.b(str, "Instance is Analytics Only not running the Job");
            } else if (cleverTapAPI != null && cleverTapAPI.t().q()) {
                cleverTapAPI.f10879b.k().R(context, jobParameters);
            } else {
                Logger.b(str, "Instance doesn't allow Background sync, not running the Job");
            }
        }
    }

    public static void i(String str, String str2) {
        j(str, str2, null);
    }

    public static void j(String str, String str2, String str3) {
        if (f10875e != null) {
            Logger.j("CleverTap SDK already initialized with accountID:" + f10875e.c() + " and token:" + f10875e.e() + ". Cannot change credentials to " + str + " and " + str2);
            return;
        }
        ManifestInfo.b(str, str2, str3);
    }

    private static CleverTapAPI k(Context context, String str) {
        return l(context, str, null);
    }

    public static void k0(int i8) {
        f10874d = i8;
    }

    private static CleverTapAPI l(Context context, String str, String str2) {
        try {
            if (str == null) {
                return z(context, str2);
            }
            String i8 = StorageHelper.i(context, "instance:" + str, "");
            if (!i8.isEmpty()) {
                CleverTapInstanceConfig b8 = CleverTapInstanceConfig.b(i8);
                Logger.n("Inflated Instance Config: " + i8);
                if (b8 == null) {
                    return null;
                }
                return L(context, b8, str2);
            }
            CleverTapAPI y7 = y(context);
            if (y7 == null || !y7.f10879b.e().c().equals(str)) {
                return null;
            }
            return y7;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void l0(LogLevel logLevel) {
        f10874d = logLevel.a();
    }

    public static void m(Context context, Bundle bundle) {
        n(context, bundle, -1000);
    }

    public static void n(Context context, Bundle bundle, int i8) {
        String string = bundle.getString("wzrk_acct_id");
        HashMap<String, CleverTapAPI> hashMap = f10876f;
        if (hashMap == null) {
            CleverTapAPI k8 = k(context, string);
            if (k8 != null) {
                k8.f10879b.k().b(context, bundle, i8);
                return;
            }
            return;
        }
        for (String str : hashMap.keySet()) {
            CleverTapAPI cleverTapAPI = f10876f.get(str);
            boolean z7 = false;
            if (cleverTapAPI != null && ((string == null && cleverTapAPI.f10879b.e().t()) || cleverTapAPI.q().equals(string))) {
                z7 = true;
                continue;
            }
            if (z7) {
                try {
                    cleverTapAPI.f10879b.k().b(context, bundle, i8);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
        }
    }

    public static void o(final Context context, final String str, final CharSequence charSequence, final String str2, final int i8, final boolean z7) {
        final CleverTapAPI A = A(context);
        if (A == null) {
            Logger.n("No CleverTap Instance found in CleverTapAPI#createNotificatonChannel");
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                CTExecutorFactory.a(A.f10879b.e()).c().d("createNotificationChannel", new Callable<Void>() { // from class: com.clevertap.android.sdk.CleverTapAPI.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Void call() {
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                        if (notificationManager == null) {
                            return null;
                        }
                        NotificationChannel notificationChannel = new NotificationChannel(str, charSequence, i8);
                        notificationChannel.setDescription(str2);
                        notificationChannel.setShowBadge(z7);
                        notificationManager.createNotificationChannel(notificationChannel);
                        Logger u7 = A.u();
                        String q8 = A.q();
                        u7.m(q8, "Notification channel " + charSequence.toString() + " has been created");
                        return null;
                    }
                });
            }
        } catch (Throwable th) {
            A.u().t(A.q(), "Failure creating Notification Channel", th);
        }
    }

    private CleverTapInstanceConfig t() {
        return this.f10879b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Logger u() {
        return t().n();
    }

    public static int w() {
        return f10874d;
    }

    private static CleverTapInstanceConfig x(Context context) {
        ManifestInfo i8 = ManifestInfo.i(context);
        String d8 = i8.d();
        String f8 = i8.f();
        String e8 = i8.e();
        if (d8 != null && f8 != null) {
            if (e8 == null) {
                Logger.j("Account Region not specified in the AndroidManifest - using default region");
            }
            return CleverTapInstanceConfig.a(context, d8, f8, e8);
        }
        Logger.j("Account ID or Account token is missing from AndroidManifest.xml, unable to create default instance");
        return null;
    }

    public static CleverTapAPI y(Context context) {
        return z(context, null);
    }

    public static CleverTapAPI z(Context context, String str) {
        f10877g = "!SDK-VERSION-STRING!:com.clevertap.android:clevertap-android-sdk:4.3.0.0";
        CleverTapInstanceConfig cleverTapInstanceConfig = f10875e;
        if (cleverTapInstanceConfig != null) {
            return L(context, cleverTapInstanceConfig, str);
        }
        CleverTapInstanceConfig x7 = x(context);
        f10875e = x7;
        if (x7 != null) {
            return L(context, x7, str);
        }
        return null;
    }

    public int B() {
        synchronized (this.f10879b.c().b()) {
            if (this.f10879b.f().e() != null) {
                return this.f10879b.f().e().g();
            }
            u().f(q(), "Notification Inbox not initialized");
            return -1;
        }
    }

    public CTInboxMessage C(String str) {
        synchronized (this.f10879b.c().b()) {
            CTInboxMessage cTInboxMessage = null;
            if (this.f10879b.f().e() != null) {
                CTMessageDAO i8 = this.f10879b.f().e().i(str);
                if (i8 != null) {
                    cTInboxMessage = new CTInboxMessage(i8.v());
                }
                return cTInboxMessage;
            }
            u().f(q(), "Notification Inbox not initialized");
            return null;
        }
    }

    public int D() {
        synchronized (this.f10879b.c().b()) {
            if (this.f10879b.f().e() != null) {
                return this.f10879b.f().e().n();
            }
            u().f(q(), "Notification Inbox not initialized");
            return -1;
        }
    }

    public Object F(String str) {
        if (!this.f10879b.e().v()) {
            return null;
        }
        return this.f10879b.i().v(str);
    }

    public SyncListener G() {
        return this.f10879b.d().l();
    }

    public ArrayList<CTInboxMessage> H() {
        ArrayList<CTInboxMessage> arrayList = new ArrayList<>();
        synchronized (this.f10879b.c().b()) {
            if (this.f10879b.f().e() != null) {
                Iterator<CTMessageDAO> it = this.f10879b.f().e().k().iterator();
                while (it.hasNext()) {
                    arrayList.add(new CTInboxMessage(it.next().v()));
                }
                return arrayList;
            }
            u().f(q(), "Notification Inbox not initialized");
            return arrayList;
        }
    }

    public void J() {
        this.f10879b.f().j();
    }

    public void P(CTInboxMessage cTInboxMessage) {
        if (this.f10879b.f().e() != null) {
            this.f10879b.f().e().l(cTInboxMessage);
        } else {
            u().f(q(), "Notification Inbox not initialized");
        }
    }

    public void V(Map<String, Object> map) {
        W(map, null);
    }

    public void W(Map<String, Object> map, String str) {
        this.f10879b.j().w(map, str);
    }

    public void X(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList) {
        this.f10879b.b().z(hashMap, arrayList);
    }

    public void Y(String str) {
        if (str != null && !str.trim().equals("")) {
            Z(str, null);
        }
    }

    public void Z(String str, Map<String, Object> map) {
        this.f10879b.b().B(str, map);
    }

    @Override // com.clevertap.android.sdk.inbox.CTInboxActivity.InboxActivityListener
    public void a(CTInboxActivity cTInboxActivity, final CTInboxMessage cTInboxMessage, final Bundle bundle) {
        CTExecutorFactory.a(this.f10879b.e()).c().d("handleMessageDidShow", new Callable<Void>() { // from class: com.clevertap.android.sdk.CleverTapAPI.12
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                if (!CleverTapAPI.this.C(cTInboxMessage.g()).o()) {
                    CleverTapAPI.this.P(cTInboxMessage);
                    CleverTapAPI.this.f10879b.b().D(false, cTInboxMessage, bundle);
                    return null;
                }
                return null;
            }
        });
    }

    public void a0(String str, boolean z7) {
        this.f10879b.k().C(str, PushConstants.PushType.FCM, z7);
    }

    @Override // com.clevertap.android.sdk.inbox.CTInboxActivity.InboxActivityListener
    public void b(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap) {
        WeakReference<InboxMessageButtonListener> weakReference;
        this.f10879b.b().D(true, cTInboxMessage, bundle);
        if (hashMap != null && !hashMap.isEmpty() && (weakReference = this.f10880c) != null && weakReference.get() != null) {
            this.f10880c.get().a(hashMap);
        }
    }

    public void b0(Bundle bundle) {
        this.f10879b.b().F(bundle);
    }

    public void c0(Map<String, Object> map) {
        this.f10879b.b().H(map);
    }

    public void d0(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            e0(str, new ArrayList<>(Collections.singletonList(str2)));
        } else {
            this.f10879b.b().d(str);
        }
    }

    public void e0(String str, ArrayList<String> arrayList) {
        this.f10879b.b().J(str, arrayList);
    }

    public void f0(String str) {
        this.f10879b.b().K(str);
    }

    public void g(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            h(str, new ArrayList<>(Collections.singletonList(str2)));
        } else {
            this.f10879b.b().d(str);
        }
    }

    public void h(String str, ArrayList<String> arrayList) {
        this.f10879b.b().u(str, arrayList);
    }

    public void i0(CTInboxListener cTInboxListener) {
        this.f10879b.d().p(cTInboxListener);
    }

    void j0(CoreState coreState) {
        this.f10879b = coreState;
    }

    public void m0(String str, ArrayList<String> arrayList) {
        this.f10879b.b().O(str, arrayList);
    }

    public void n0(CTInboxStyleConfig cTInboxStyleConfig) {
        synchronized (this.f10879b.c().b()) {
            if (this.f10879b.f().e() == null) {
                u().f(q(), "Notification Inbox not initialized");
                return;
            }
            CTInboxStyleConfig cTInboxStyleConfig2 = new CTInboxStyleConfig(cTInboxStyleConfig);
            Intent intent = new Intent(this.f10878a, CTInboxActivity.class);
            intent.putExtra("styleConfig", cTInboxStyleConfig2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("config", t());
            intent.putExtra("configBundle", bundle);
            try {
                Activity h8 = CoreMetaData.h();
                if (h8 != null) {
                    h8.startActivity(intent);
                    Logger.a("Displaying Notification Inbox");
                    return;
                }
                throw new IllegalStateException("Current activity reference not found");
            } catch (Throwable th) {
                Logger.q("Please verify the integration of your app. It is not setup to support Notification Inbox yet.", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(String str) {
        String c8 = this.f10879b.e().c();
        if (this.f10879b.f() == null) {
            u().s(c8 + ":async_deviceID", "ControllerManager not set yet! Returning from deviceIDCreated()");
            return;
        }
        if (this.f10879b.f().h() == null) {
            u().s(c8 + ":async_deviceID", "Initializing InAppFC after Device ID Created = " + str);
            this.f10879b.f().p(new InAppFCManager(this.f10878a, this.f10879b.e(), str));
        }
        CTFeatureFlagsController d8 = this.f10879b.f().d();
        if (d8 != null && TextUtils.isEmpty(d8.j())) {
            u().s(c8 + ":async_deviceID", "Initializing Feature Flags after Device ID Created = " + str);
            d8.p(str);
        }
        CTProductConfigController f8 = this.f10879b.f().f();
        if (f8 != null && TextUtils.isEmpty(f8.j().g())) {
            u().s(c8 + ":async_deviceID", "Initializing Product Config after Device ID Created = " + str);
            f8.w(str);
        }
        u().s(c8 + ":async_deviceID", "Got device id from DeviceInfo, notifying user profile initialized to SyncListener");
        this.f10879b.d().n(str);
        if (this.f10879b.d().h() != null) {
            this.f10879b.d().h().a(str);
        }
    }

    public String q() {
        return this.f10879b.e().c();
    }

    public ArrayList<CTInboxMessage> r() {
        ArrayList<CTInboxMessage> arrayList = new ArrayList<>();
        synchronized (this.f10879b.c().b()) {
            if (this.f10879b.f().e() != null) {
                Iterator<CTMessageDAO> it = this.f10879b.f().e().j().iterator();
                while (it.hasNext()) {
                    CTMessageDAO next = it.next();
                    Logger.n("CTMessage Dao - " + next.v().toString());
                    arrayList.add(new CTInboxMessage(next.v()));
                }
                return arrayList;
            }
            u().f(q(), "Notification Inbox not initialized");
            return arrayList;
        }
    }

    public String s() {
        return this.f10879b.g().x();
    }

    public CoreState v() {
        return this.f10879b;
    }
}
