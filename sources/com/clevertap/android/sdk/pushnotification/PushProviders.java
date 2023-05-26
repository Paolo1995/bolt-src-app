package com.clevertap.android.sdk.pushnotification;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.AnalyticsManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public class PushProviders implements CTPushProviderListener {

    /* renamed from: d  reason: collision with root package name */
    private final AnalyticsManager f11694d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseDatabaseManager f11695e;

    /* renamed from: f  reason: collision with root package name */
    private final CleverTapInstanceConfig f11696f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f11697g;

    /* renamed from: h  reason: collision with root package name */
    private final ValidationResultStack f11698h;

    /* renamed from: j  reason: collision with root package name */
    private CleverTapAPI.DevicePushTokenRefreshListener f11700j;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<PushConstants.PushType> f11691a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<CTPushProvider> f11692b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<PushConstants.PushType> f11693c = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private final Object f11699i = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.clevertap.android.sdk.pushnotification.PushProviders$8  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11715a;

        static {
            int[] iArr = new int[PushConstants.PushType.values().length];
            f11715a = iArr;
            try {
                iArr[PushConstants.PushType.FCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11715a[PushConstants.PushType.XPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11715a[PushConstants.PushType.HPS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11715a[PushConstants.PushType.BPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11715a[PushConstants.PushType.ADM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private PushProviders(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, BaseDatabaseManager baseDatabaseManager, ValidationResultStack validationResultStack, AnalyticsManager analyticsManager) {
        this.f11697g = context;
        this.f11696f = cleverTapInstanceConfig;
        this.f11695e = baseDatabaseManager;
        this.f11698h = validationResultStack;
        this.f11694d = analyticsManager;
        E();
    }

    private static JobInfo A(int i8, JobScheduler jobScheduler) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            if (jobInfo.getId() == i8) {
                return jobInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B(Context context) {
        return StorageHelper.c(context, "pf", 240);
    }

    private void D() {
        w();
        u(r());
        v();
    }

    private void E() {
        if (this.f11696f.q() && !this.f11696f.p()) {
            CTExecutorFactory.a(this.f11696f).c().d("createOrResetJobScheduler", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.6
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    PushProviders pushProviders = PushProviders.this;
                    pushProviders.q(pushProviders.f11697g);
                    return null;
                }
            });
        }
    }

    private boolean G(Context context, Class cls) {
        ServiceInfo[] serviceInfoArr;
        if (cls == null) {
            return false;
        }
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services) {
                if (serviceInfo.name.equals(cls.getName())) {
                    Logger.n("Service " + serviceInfo.name + " found");
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException e8) {
            Logger.a("Intent Service name not found exception - " + e8.getLocalizedMessage());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H(Date date, Date date2, Date date3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date3);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date2);
        if (date2.compareTo(date) < 0) {
            if (calendar2.compareTo(calendar3) < 0) {
                calendar2.add(5, 1);
            }
            calendar3.add(5, 1);
        }
        if (calendar2.compareTo(calendar) >= 0 && calendar2.compareTo(calendar3) < 0) {
            return true;
        }
        return false;
    }

    private boolean I(CTPushProvider cTPushProvider) {
        if (40300 < cTPushProvider.minSDKSupportVersionCode()) {
            this.f11696f.A("PushProvider", "Provider: %s version %s does not match the SDK version %s. Make sure all CleverTap dependencies are the same version.");
            return false;
        }
        int i8 = AnonymousClass8.f11715a[cTPushProvider.getPushType().ordinal()];
        if (i8 != 1 && i8 != 2 && i8 != 3 && i8 != 4) {
            if (i8 == 5 && cTPushProvider.getPlatform() != 2) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11696f;
                cleverTapInstanceConfig.A("PushProvider", "Invalid Provider: " + cTPushProvider.getClass() + " ADM delivery is only available for Amazon platforms." + cTPushProvider.getPushType());
                return false;
            }
        } else if (cTPushProvider.getPlatform() != 1) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f11696f;
            cleverTapInstanceConfig2.A("PushProvider", "Invalid Provider: " + cTPushProvider.getClass() + " delivery is only available for Android platforms." + cTPushProvider.getPushType());
            return false;
        }
        return true;
    }

    @NonNull
    public static PushProviders J(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, BaseDatabaseManager baseDatabaseManager, ValidationResultStack validationResultStack, AnalyticsManager analyticsManager, ControllerManager controllerManager) {
        PushProviders pushProviders = new PushProviders(context, cleverTapInstanceConfig, baseDatabaseManager, validationResultStack, analyticsManager);
        pushProviders.D();
        controllerManager.q(pushProviders);
        return pushProviders;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Date L(String str) {
        try {
            return new SimpleDateFormat("HH:mm", Locale.US).parse(str);
        } catch (ParseException unused) {
            return new Date(0L);
        }
    }

    private void M(String str, boolean z7, PushConstants.PushType pushType) {
        String str2;
        if (pushType == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = z(pushType);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f11699i) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (z7) {
                str2 = "register";
            } else {
                str2 = "unregister";
            }
            jSONObject2.put("action", str2);
            jSONObject2.put(Name.MARK, str);
            jSONObject2.put("type", pushType.f());
            jSONObject.put("data", jSONObject2);
            Logger n8 = this.f11696f.n();
            String c8 = this.f11696f.c();
            n8.s(c8, pushType + str2 + " device token " + str);
            this.f11694d.L(jSONObject);
        }
    }

    private void N() {
        CTExecutorFactory.a(this.f11696f).a().d("PushProviders#refreshAllTokens", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.7
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                PushProviders.this.O();
                PushProviders.this.P();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Iterator<CTPushProvider> it = this.f11692b.iterator();
        while (it.hasNext()) {
            CTPushProvider next = it.next();
            try {
                next.requestToken();
            } catch (Throwable th) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11696f;
                cleverTapInstanceConfig.B("PushProvider", "Token Refresh error " + next, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        Iterator<PushConstants.PushType> it = this.f11693c.iterator();
        while (it.hasNext()) {
            PushConstants.PushType next = it.next();
            try {
                M(z(next), true, next);
            } catch (Throwable th) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11696f;
                cleverTapInstanceConfig.B("PushProvider", "Token Refresh error " + next, th);
            }
        }
    }

    private void Q(String str, PushConstants.PushType pushType) {
        M(str, true, pushType);
        p(str, pushType);
    }

    private void S(Context context, int i8) {
        StorageHelper.n(context, "pf", i8);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:264:0x0533
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public void T(android.content.Context r29, android.os.Bundle r30, java.lang.String r31, java.lang.String r32, int r33) {
        /*
            Method dump skipped, instructions count: 1609
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.PushProviders.T(android.content.Context, android.os.Bundle, java.lang.String, java.lang.String, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(String str, PushConstants.PushType pushType) {
        boolean z7;
        if (!TextUtils.isEmpty(str) && pushType != null && str.equalsIgnoreCase(z(pushType))) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (pushType != null) {
            CleverTapInstanceConfig cleverTapInstanceConfig = this.f11696f;
            cleverTapInstanceConfig.A("PushProvider", pushType + "Token Already available value: " + z7);
        }
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void q(Context context) {
        boolean z7;
        int c8 = StorageHelper.c(context, "pfjobid", -1);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (Build.VERSION.SDK_INT < 26) {
            if (c8 >= 0) {
                jobScheduler.cancel(c8);
                StorageHelper.n(context, "pfjobid", -1);
            }
            this.f11696f.n().f(this.f11696f.c(), "Push Amplification feature is not supported below Oreo");
        } else if (jobScheduler == null) {
        } else {
            int B = B(context);
            if (c8 < 0 && B < 0) {
                return;
            }
            if (B < 0) {
                jobScheduler.cancel(c8);
                StorageHelper.n(context, "pfjobid", -1);
                return;
            }
            ComponentName componentName = new ComponentName(context, CTBackgroundJobService.class);
            if (c8 < 0 && B > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            JobInfo A = A(c8, jobScheduler);
            if (A != null && A.getIntervalMillis() != B * 60000) {
                jobScheduler.cancel(c8);
                StorageHelper.n(context, "pfjobid", -1);
                z7 = true;
            }
            if (z7) {
                int hashCode = this.f11696f.c().hashCode();
                JobInfo.Builder builder = new JobInfo.Builder(hashCode, componentName);
                builder.setRequiredNetworkType(1);
                builder.setRequiresCharging(false);
                builder.setPeriodic(B * 60000, 300000L);
                builder.setRequiresBatteryNotLow(true);
                if (Utils.t(context, "android.permission.RECEIVE_BOOT_COMPLETED")) {
                    builder.setPersisted(true);
                }
                if (jobScheduler.schedule(builder.build()) == 1) {
                    String c9 = this.f11696f.c();
                    Logger.b(c9, "Job scheduled - " + hashCode);
                    StorageHelper.n(context, "pfjobid", hashCode);
                    return;
                }
                String c10 = this.f11696f.c();
                Logger.b(c10, "Job not scheduled - " + hashCode);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x000d A[SYNTHETIC] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.clevertap.android.sdk.pushnotification.CTPushProvider> r() {
        /*
            r13 = this;
            java.lang.String r0 = "PushProvider"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r2 = r13.f11691a
            java.util.Iterator r2 = r2.iterator()
        Ld:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Le3
            java.lang.Object r3 = r2.next()
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r3 = (com.clevertap.android.sdk.pushnotification.PushConstants.PushType) r3
            java.lang.String r3 = r3.a()
            r4 = 0
            java.lang.Class r5 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            r6 = 3
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            java.lang.Class<com.clevertap.android.sdk.pushnotification.CTPushProviderListener> r8 = com.clevertap.android.sdk.pushnotification.CTPushProviderListener.class
            r9 = 0
            r7[r9] = r8     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r10 = 1
            r7[r10] = r8     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            java.lang.Class<com.clevertap.android.sdk.CleverTapInstanceConfig> r8 = com.clevertap.android.sdk.CleverTapInstanceConfig.class
            r11 = 2
            r7[r11] = r8     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            java.lang.reflect.Constructor r5 = r5.getConstructor(r7)     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            r6[r9] = r13     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            android.content.Context r7 = r13.f11697g     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            r6[r10] = r7     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r13.f11696f     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            r6[r11] = r7     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            java.lang.Object r5 = r5.newInstance(r6)     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            com.clevertap.android.sdk.pushnotification.CTPushProvider r5 = (com.clevertap.android.sdk.pushnotification.CTPushProvider) r5     // Catch: java.lang.Exception -> L6a java.lang.ClassNotFoundException -> L95 java.lang.IllegalAccessException -> Lac java.lang.InstantiationException -> Lc3
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r13.f11696f     // Catch: java.lang.Exception -> L62 java.lang.ClassNotFoundException -> L64 java.lang.IllegalAccessException -> L66 java.lang.InstantiationException -> L68
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L62 java.lang.ClassNotFoundException -> L64 java.lang.IllegalAccessException -> L66 java.lang.InstantiationException -> L68
            r6.<init>()     // Catch: java.lang.Exception -> L62 java.lang.ClassNotFoundException -> L64 java.lang.IllegalAccessException -> L66 java.lang.InstantiationException -> L68
            java.lang.String r7 = "Found provider:"
            r6.append(r7)     // Catch: java.lang.Exception -> L62 java.lang.ClassNotFoundException -> L64 java.lang.IllegalAccessException -> L66 java.lang.InstantiationException -> L68
            r6.append(r3)     // Catch: java.lang.Exception -> L62 java.lang.ClassNotFoundException -> L64 java.lang.IllegalAccessException -> L66 java.lang.InstantiationException -> L68
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L62 java.lang.ClassNotFoundException -> L64 java.lang.IllegalAccessException -> L66 java.lang.InstantiationException -> L68
            r4.A(r0, r6)     // Catch: java.lang.Exception -> L62 java.lang.ClassNotFoundException -> L64 java.lang.IllegalAccessException -> L66 java.lang.InstantiationException -> L68
            goto Lda
        L62:
            r4 = move-exception
            goto L6e
        L64:
            r4 = r5
            goto L95
        L66:
            r4 = r5
            goto Lac
        L68:
            r4 = r5
            goto Lc3
        L6a:
            r5 = move-exception
            r12 = r5
            r5 = r4
            r4 = r12
        L6e:
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r13.f11696f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unable to create provider "
            r7.append(r8)
            r7.append(r3)
            java.lang.String r3 = " Exception:"
            r7.append(r3)
            java.lang.Class r3 = r4.getClass()
            java.lang.String r3 = r3.getName()
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r6.A(r0, r3)
            goto Lda
        L95:
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r13.f11696f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unable to create provider ClassNotFoundException"
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r5.A(r0, r3)
            goto Ld9
        Lac:
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r13.f11696f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unable to create provider IllegalAccessException"
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r5.A(r0, r3)
            goto Ld9
        Lc3:
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r13.f11696f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unable to create provider InstantiationException"
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            r5.A(r0, r3)
        Ld9:
            r5 = r4
        Lda:
            if (r5 != 0) goto Lde
            goto Ld
        Lde:
            r1.add(r5)
            goto Ld
        Le3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.PushProviders.r():java.util.List");
    }

    private void s(String str, PushConstants.PushType pushType) {
        if (this.f11700j != null) {
            Logger n8 = this.f11696f.n();
            String c8 = this.f11696f.c();
            n8.f(c8, "Notifying devicePushTokenDidRefresh: " + str);
            this.f11700j.a(str, pushType);
        }
    }

    private void u(List<CTPushProvider> list) {
        if (list.isEmpty()) {
            this.f11696f.A("PushProvider", "No push providers found!. Make sure to install at least one push provider");
            return;
        }
        for (CTPushProvider cTPushProvider : list) {
            if (!I(cTPushProvider)) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11696f;
                cleverTapInstanceConfig.A("PushProvider", "Invalid Provider: " + cTPushProvider.getClass());
            } else if (!cTPushProvider.isSupported()) {
                CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f11696f;
                cleverTapInstanceConfig2.A("PushProvider", "Unsupported Provider: " + cTPushProvider.getClass());
            } else if (cTPushProvider.isAvailable()) {
                CleverTapInstanceConfig cleverTapInstanceConfig3 = this.f11696f;
                cleverTapInstanceConfig3.A("PushProvider", "Available Provider: " + cTPushProvider.getClass());
                this.f11692b.add(cTPushProvider);
            } else {
                CleverTapInstanceConfig cleverTapInstanceConfig4 = this.f11696f;
                cleverTapInstanceConfig4.A("PushProvider", "Unavailable Provider: " + cTPushProvider.getClass());
            }
        }
    }

    private void v() {
        this.f11693c.addAll(this.f11691a);
        Iterator<CTPushProvider> it = this.f11692b.iterator();
        while (it.hasNext()) {
            this.f11693c.remove(it.next().getPushType());
        }
    }

    private void w() {
        PushConstants.PushType[] b8;
        for (PushConstants.PushType pushType : PushNotificationUtil.b(this.f11696f.f())) {
            String c8 = pushType.c();
            try {
                Class.forName(c8);
                this.f11691a.add(pushType);
                this.f11696f.A("PushProvider", "SDK Class Available :" + c8);
            } catch (Exception e8) {
                this.f11696f.A("PushProvider", "SDK class Not available " + c8 + " Exception:" + e8.getClass().getName());
            }
        }
    }

    public void C(String str, PushConstants.PushType pushType, boolean z7) {
        if (z7) {
            Q(str, pushType);
        } else {
            U(str, pushType);
        }
    }

    public boolean F() {
        Iterator<PushConstants.PushType> it = y().iterator();
        while (it.hasNext()) {
            if (z(it.next()) != null) {
                return true;
            }
        }
        return false;
    }

    public void K() {
        N();
    }

    public void R(final Context context, final JobParameters jobParameters) {
        CTExecutorFactory.a(this.f11696f).c().d("runningJobService", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                if (!PushProviders.this.F()) {
                    Logger.o(PushProviders.this.f11696f.c(), "Token is not present, not running the Job");
                    return null;
                }
                Calendar calendar = Calendar.getInstance();
                int i8 = calendar.get(11);
                int i9 = calendar.get(12);
                PushProviders pushProviders = PushProviders.this;
                Date L = pushProviders.L(i8 + ":" + i9);
                if (PushProviders.this.H(PushProviders.this.L("22:00"), PushProviders.this.L("06:00"), L)) {
                    Logger.o(PushProviders.this.f11696f.c(), "Job Service won't run in default DND hours");
                    return null;
                }
                long E = PushProviders.this.f11695e.c(context).E();
                if (E == 0 || E > System.currentTimeMillis() - 86400000) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bk", 1);
                        PushProviders.this.f11694d.N(jSONObject);
                        int i10 = 134217728;
                        if (Build.VERSION.SDK_INT >= 31) {
                            i10 = 167772160;
                        }
                        if (jobParameters == null) {
                            int B = PushProviders.this.B(context);
                            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                            Intent intent = new Intent("com.clevertap.BG_EVENT");
                            intent.setPackage(context.getPackageName());
                            PendingIntent service = PendingIntent.getService(context, PushProviders.this.f11696f.c().hashCode(), intent, i10);
                            if (alarmManager != null) {
                                alarmManager.cancel(service);
                            }
                            Intent intent2 = new Intent("com.clevertap.BG_EVENT");
                            intent2.setPackage(context.getPackageName());
                            PendingIntent service2 = PendingIntent.getService(context, PushProviders.this.f11696f.c().hashCode(), intent2, i10);
                            if (alarmManager != null && B != -1) {
                                long j8 = B * 60000;
                                alarmManager.setInexactRepeating(2, SystemClock.elapsedRealtime() + j8, j8, service2);
                            }
                        }
                    } catch (JSONException unused) {
                        Logger.n("Unable to raise background Ping event");
                    }
                }
                return null;
            }
        });
    }

    public void U(String str, PushConstants.PushType pushType) {
        M(str, false, pushType);
    }

    public void V(final Context context, int i8) {
        Logger n8 = this.f11696f.n();
        n8.r("Ping frequency received - " + i8);
        Logger n9 = this.f11696f.n();
        n9.r("Stored Ping Frequency - " + B(context));
        if (i8 != B(context)) {
            S(context, i8);
            if (this.f11696f.q() && !this.f11696f.p()) {
                CTExecutorFactory.a(this.f11696f).c().d("createOrResetJobScheduler", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.4
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Void call() {
                        PushProviders.this.f11696f.n().r("Creating job");
                        PushProviders.this.q(context);
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.clevertap.android.sdk.pushnotification.CTPushProviderListener
    public void a(String str, PushConstants.PushType pushType) {
        if (!TextUtils.isEmpty(str)) {
            t(str, pushType);
            s(str, pushType);
        }
    }

    public void b(final Context context, final Bundle bundle, final int i8) {
        if (bundle != null && bundle.get("wzrk_pn") != null) {
            if (this.f11696f.p()) {
                this.f11696f.n().f(this.f11696f.c(), "Instance is set for Analytics only, cannot create notification");
                return;
            }
            try {
                CTExecutorFactory.a(this.f11696f).c().d("CleverTapAPI#_createNotification", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Void call() {
                        String str;
                        try {
                            Logger n8 = PushProviders.this.f11696f.n();
                            String c8 = PushProviders.this.f11696f.c();
                            n8.f(c8, "Handling notification: " + bundle.toString());
                        } catch (Throwable th) {
                            PushProviders.this.f11696f.n().g(PushProviders.this.f11696f.c(), "Couldn't render notification: ", th);
                        }
                        if (bundle.getString("wzrk_pid") != null && PushProviders.this.f11695e.c(context).x(bundle.getString("wzrk_pid"))) {
                            PushProviders.this.f11696f.n().f(PushProviders.this.f11696f.c(), "Push Notification already rendered, not showing again");
                            return null;
                        }
                        String string = bundle.getString("nm");
                        if (string == null) {
                            str = "";
                        } else {
                            str = string;
                        }
                        if (str.isEmpty()) {
                            PushProviders.this.f11696f.n().s(PushProviders.this.f11696f.c(), "Push notification message is empty, not rendering");
                            PushProviders.this.f11695e.c(context).L();
                            String string2 = bundle.getString("pf", "");
                            if (!TextUtils.isEmpty(string2)) {
                                PushProviders.this.V(context, Integer.parseInt(string2));
                            }
                            return null;
                        }
                        String string3 = bundle.getString("nt", "");
                        if (string3.isEmpty()) {
                            string3 = context.getApplicationInfo().name;
                        }
                        PushProviders.this.T(context, bundle, str, string3, i8);
                        return null;
                    }
                });
            } catch (Throwable th) {
                this.f11696f.n().g(this.f11696f.c(), "Failed to process push notification", th);
            }
        }
    }

    public void p(final String str, final PushConstants.PushType pushType) {
        if (!TextUtils.isEmpty(str) && pushType != null) {
            try {
                CTExecutorFactory.a(this.f11696f).a().d("PushProviders#cacheToken", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.2
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Void call() {
                        if (PushProviders.this.o(str, pushType)) {
                            return null;
                        }
                        String e8 = pushType.e();
                        if (TextUtils.isEmpty(e8)) {
                            return null;
                        }
                        StorageHelper.q(PushProviders.this.f11697g, StorageHelper.s(PushProviders.this.f11696f, e8), str);
                        CleverTapInstanceConfig cleverTapInstanceConfig = PushProviders.this.f11696f;
                        cleverTapInstanceConfig.A("PushProvider", pushType + "Cached New Token successfully " + str);
                        return null;
                    }
                });
            } catch (Throwable th) {
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11696f;
                cleverTapInstanceConfig.B("PushProvider", pushType + "Unable to cache token " + str, th);
            }
        }
    }

    public void t(String str, PushConstants.PushType pushType) {
        if (!TextUtils.isEmpty(str) && pushType != null) {
            int i8 = AnonymousClass8.f11715a[pushType.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5) {
                                C(str, PushConstants.PushType.ADM, true);
                                return;
                            }
                            return;
                        }
                        C(str, PushConstants.PushType.BPS, true);
                        return;
                    }
                    C(str, PushConstants.PushType.HPS, true);
                    return;
                }
                C(str, PushConstants.PushType.XPS, true);
                return;
            }
            C(str, PushConstants.PushType.FCM, true);
        }
    }

    public void x(boolean z7) {
        Iterator<PushConstants.PushType> it = this.f11691a.iterator();
        while (it.hasNext()) {
            M(null, z7, it.next());
        }
    }

    @NonNull
    public ArrayList<PushConstants.PushType> y() {
        ArrayList<PushConstants.PushType> arrayList = new ArrayList<>();
        Iterator<CTPushProvider> it = this.f11692b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPushType());
        }
        return arrayList;
    }

    public String z(PushConstants.PushType pushType) {
        if (pushType != null) {
            String e8 = pushType.e();
            if (!TextUtils.isEmpty(e8)) {
                String k8 = StorageHelper.k(this.f11697g, this.f11696f, e8, null);
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f11696f;
                cleverTapInstanceConfig.A("PushProvider", pushType + "getting Cached Token - " + k8);
                return k8;
            }
        }
        if (pushType != null) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f11696f;
            cleverTapInstanceConfig2.A("PushProvider", pushType + " Unable to find cached Token for type ");
        }
        return null;
    }
}
