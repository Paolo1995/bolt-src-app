package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.mixpanel.android.util.MPLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SystemInformation {

    /* renamed from: h  reason: collision with root package name */
    private static SystemInformation f19364h;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f19365i = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f19366a;

    /* renamed from: b  reason: collision with root package name */
    private final Boolean f19367b;

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f19368c;

    /* renamed from: d  reason: collision with root package name */
    private final DisplayMetrics f19369d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19370e;

    /* renamed from: f  reason: collision with root package name */
    private final Integer f19371f;

    /* renamed from: g  reason: collision with root package name */
    private final String f19372g;

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:2|3)|(2:4|5)|6|(2:8|(1:10)(1:35))(1:36)|11|12|13|(5:19|20|22|23|24)(1:15)|16|17|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private SystemInformation(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it."
            java.lang.String r1 = "MixpanelAPI.SysInfo"
            r9.<init>()
            r9.f19366a = r10
            android.content.pm.PackageManager r2 = r10.getPackageManager()
            r3 = 0
            r4 = 0
            java.lang.String r5 = r10.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.PackageInfo r5 = r2.getPackageInfo(r5, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            java.lang.String r6 = r5.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            int r5 = r5.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L21
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L21
            goto L27
        L20:
            r6 = r4
        L21:
            java.lang.String r5 = "System information constructed with a context that apparently doesn't exist."
            com.mixpanel.android.util.MPLog.k(r1, r5)
            r5 = r4
        L27:
            android.content.pm.ApplicationInfo r7 = r10.getApplicationInfo()
            int r8 = r7.labelRes
            r9.f19370e = r6
            r9.f19371f = r5
            if (r8 != 0) goto L3f
            java.lang.CharSequence r10 = r7.nonLocalizedLabel
            if (r10 != 0) goto L3a
            java.lang.String r10 = "Misc"
            goto L43
        L3a:
            java.lang.String r10 = r10.toString()
            goto L43
        L3f:
            java.lang.String r10 = r10.getString(r8)
        L43:
            r9.f19372g = r10
            java.lang.Class r10 = r2.getClass()
            r5 = 1
            java.lang.String r6 = "hasSystemFeature"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.NoSuchMethodException -> L57
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r3] = r8     // Catch: java.lang.NoSuchMethodException -> L57
            java.lang.reflect.Method r10 = r10.getMethod(r6, r7)     // Catch: java.lang.NoSuchMethodException -> L57
            goto L59
        L57:
            r10 = r4
        L59:
            if (r10 == 0) goto L80
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.IllegalAccessException -> L74 java.lang.reflect.InvocationTargetException -> L79
            java.lang.String r7 = "android.hardware.nfc"
            r6[r3] = r7     // Catch: java.lang.IllegalAccessException -> L74 java.lang.reflect.InvocationTargetException -> L79
            java.lang.Object r6 = r10.invoke(r2, r6)     // Catch: java.lang.IllegalAccessException -> L74 java.lang.reflect.InvocationTargetException -> L79
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.IllegalAccessException -> L74 java.lang.reflect.InvocationTargetException -> L79
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.IllegalAccessException -> L75 java.lang.reflect.InvocationTargetException -> L7a
            java.lang.String r7 = "android.hardware.telephony"
            r5[r3] = r7     // Catch: java.lang.IllegalAccessException -> L75 java.lang.reflect.InvocationTargetException -> L7a
            java.lang.Object r10 = r10.invoke(r2, r5)     // Catch: java.lang.IllegalAccessException -> L75 java.lang.reflect.InvocationTargetException -> L7a
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.IllegalAccessException -> L75 java.lang.reflect.InvocationTargetException -> L7a
            goto L7e
        L74:
            r6 = r4
        L75:
            com.mixpanel.android.util.MPLog.k(r1, r0)
            goto L7d
        L79:
            r6 = r4
        L7a:
            com.mixpanel.android.util.MPLog.k(r1, r0)
        L7d:
            r10 = r4
        L7e:
            r4 = r6
            goto L81
        L80:
            r10 = r4
        L81:
            r9.f19367b = r4
            r9.f19368c = r10
            android.util.DisplayMetrics r10 = new android.util.DisplayMetrics
            r10.<init>()
            r9.f19369d = r10
            android.content.Context r0 = r9.f19366a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getMetrics(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.SystemInformation.<init>(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SystemInformation g(Context context) {
        synchronized (f19365i) {
            if (f19364h == null) {
                f19364h = new SystemInformation(context.getApplicationContext());
            }
        }
        return f19364h;
    }

    public String a() {
        return this.f19372g;
    }

    public Integer b() {
        return this.f19371f;
    }

    public String c() {
        return this.f19370e;
    }

    public String d() {
        if (this.f19366a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return "ble";
        }
        if (this.f19366a.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
            return "classic";
        }
        return "none";
    }

    public String e() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f19366a.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    public DisplayMetrics f() {
        return this.f19369d;
    }

    @SuppressLint({"MissingPermission"})
    public String h(Context context) {
        int networkType;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager != null && packageName != null) {
            if (packageManager.checkPermission("android.permission.READ_PHONE_STATE", packageName) != 0) {
                MPLog.k("MixpanelAPI.SysInfo", "Permission READ_PHONE_STATE not granted. Property $radio will not be available.");
                return null;
            }
            TelephonyManager telephonyManager = (TelephonyManager) this.f19366a.getSystemService("phone");
            if (telephonyManager != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    networkType = telephonyManager.getDataNetworkType();
                } else {
                    networkType = telephonyManager.getNetworkType();
                }
                switch (networkType) {
                    case 0:
                        return "Unknown";
                    case 1:
                        return "GPRS";
                    case 2:
                        return "EDGE";
                    case 3:
                        return "UMTS";
                    case 4:
                        return "CDMA";
                    case 5:
                        return "EVDO rev. 0";
                    case 6:
                        return "EVDO rev. A";
                    case 7:
                        return "1xRTT";
                    case 8:
                        return "HSDPA";
                    case 9:
                        return "HSUPA";
                    case 10:
                        return "HSPA";
                    case 11:
                        return "iDen";
                    case 12:
                        return "EVDO rev. B";
                    case 13:
                        return "LTE";
                    case 14:
                        return "eHRPD";
                    case 15:
                        return "HSPA+";
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    public boolean i() {
        return this.f19367b.booleanValue();
    }

    public boolean j() {
        return this.f19368c.booleanValue();
    }

    @SuppressLint({"MissingPermission"})
    public Boolean k() {
        BluetoothAdapter defaultAdapter;
        try {
            if (this.f19366a.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.f19366a.getPackageName()) != 0 || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
                return null;
            }
            return Boolean.valueOf(defaultAdapter.isEnabled());
        } catch (NoClassDefFoundError | SecurityException unused) {
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public Boolean l() {
        if (this.f19366a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f19366a.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z7 = true;
            return Boolean.valueOf((activeNetworkInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected()) ? false : false);
        }
        return null;
    }
}
