package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.app.usage.UsageStatsManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowInsets$Type;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.app.NotificationManagerCompat;
import com.clevertap.android.sdk.login.LoginInfoProvider;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultFactory;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sinch.android.rtc.internal.client.DeviceInformation;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceInfo {

    /* renamed from: m  reason: collision with root package name */
    static int f10990m = -1;

    /* renamed from: c  reason: collision with root package name */
    private DeviceCachedInfo f10993c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f10994d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f10995e;

    /* renamed from: k  reason: collision with root package name */
    private final CoreMetaData f11001k;

    /* renamed from: a  reason: collision with root package name */
    private final Object f10991a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f10992b = false;

    /* renamed from: f  reason: collision with root package name */
    private final Object f10996f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private boolean f10997g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f10998h = null;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11000j = false;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<ValidationResult> f11002l = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private String f10999i = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DeviceCachedInfo {

        /* renamed from: r  reason: collision with root package name */
        private String f11024r;

        /* renamed from: o  reason: collision with root package name */
        private final String f11021o = F();

        /* renamed from: l  reason: collision with root package name */
        private final String f11018l = C();

        /* renamed from: m  reason: collision with root package name */
        private final String f11019m = D();

        /* renamed from: h  reason: collision with root package name */
        private final String f11014h = y();

        /* renamed from: i  reason: collision with root package name */
        private final String f11015i = z();

        /* renamed from: c  reason: collision with root package name */
        private final String f11009c = t();

        /* renamed from: b  reason: collision with root package name */
        private final int f11008b = s();

        /* renamed from: j  reason: collision with root package name */
        private final String f11016j = A();

        /* renamed from: a  reason: collision with root package name */
        private final String f11007a = r();

        /* renamed from: d  reason: collision with root package name */
        private final String f11010d = u();

        /* renamed from: n  reason: collision with root package name */
        private final int f11020n = E();

        /* renamed from: f  reason: collision with root package name */
        private final double f11012f = w();

        /* renamed from: g  reason: collision with root package name */
        private final int f11013g = x();

        /* renamed from: p  reason: collision with root package name */
        private final double f11022p = G();

        /* renamed from: q  reason: collision with root package name */
        private final int f11023q = H();

        /* renamed from: e  reason: collision with root package name */
        private final int f11011e = v();

        /* renamed from: k  reason: collision with root package name */
        private final boolean f11017k = B();

        DeviceCachedInfo() {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f11024r = q();
            }
        }

        @SuppressLint({"MissingPermission"})
        private String A() {
            return Utils.n(DeviceInfo.this.f10995e);
        }

        private boolean B() {
            try {
                return NotificationManagerCompat.b(DeviceInfo.this.f10995e).a();
            } catch (RuntimeException e8) {
                Logger.a("Runtime exception caused when checking whether notification are enabled or not");
                e8.printStackTrace();
                return true;
            }
        }

        private String C() {
            return DeviceInformation.osName;
        }

        private String D() {
            return Build.VERSION.RELEASE;
        }

        private int E() {
            return 40300;
        }

        private String F() {
            try {
                return DeviceInfo.this.f10995e.getPackageManager().getPackageInfo(DeviceInfo.this.f10995e.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.a("Unable to get app version");
                return null;
            }
        }

        private double G() {
            int i8;
            float f8;
            WindowMetrics currentWindowMetrics;
            Insets insetsIgnoringVisibility;
            WindowManager windowManager = (WindowManager) DeviceInfo.this.f10995e.getSystemService("window");
            if (windowManager == null) {
                return 0.0d;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Configuration configuration = DeviceInfo.this.f10995e.getResources().getConfiguration();
                insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemGestures());
                i8 = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.right) - insetsIgnoringVisibility.left;
                f8 = configuration.densityDpi;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i8 = displayMetrics.widthPixels;
                f8 = displayMetrics.xdpi;
            }
            return I(i8 / f8);
        }

        private int H() {
            WindowMetrics currentWindowMetrics;
            Insets insetsIgnoringVisibility;
            WindowManager windowManager = (WindowManager) DeviceInfo.this.f10995e.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemGestures());
                return (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.right) - insetsIgnoringVisibility.left;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }

        private double I(double d8) {
            return Math.round(d8 * 100.0d) / 100.0d;
        }

        private String q() {
            int appStandbyBucket;
            appStandbyBucket = ((UsageStatsManager) DeviceInfo.this.f10995e.getSystemService("usagestats")).getAppStandbyBucket();
            if (appStandbyBucket != 10) {
                if (appStandbyBucket != 20) {
                    if (appStandbyBucket != 30) {
                        if (appStandbyBucket != 40) {
                            if (appStandbyBucket != 45) {
                                return "";
                            }
                            return "restricted";
                        }
                        return "rare";
                    }
                    return "frequent";
                }
                return "working_set";
            }
            return AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
        }

        private String r() {
            if (DeviceInfo.this.f10995e.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                return "ble";
            }
            if (DeviceInfo.this.f10995e.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
                return "classic";
            }
            return "none";
        }

        private int s() {
            try {
                return DeviceInfo.this.f10995e.getPackageManager().getPackageInfo(DeviceInfo.this.f10995e.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.a("Unable to get app build");
                return 0;
            }
        }

        private String t() {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) DeviceInfo.this.f10995e.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getNetworkOperatorName();
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        private String u() {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) DeviceInfo.this.f10995e.getSystemService("phone");
                if (telephonyManager == null) {
                    return "";
                }
                return telephonyManager.getSimCountryIso();
            } catch (Throwable unused) {
                return "";
            }
        }

        private int v() {
            WindowManager windowManager = (WindowManager) DeviceInfo.this.f10995e.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return DeviceInfo.this.f10995e.getResources().getConfiguration().densityDpi;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.densityDpi;
        }

        private double w() {
            int i8;
            float f8;
            WindowMetrics currentWindowMetrics;
            Insets insetsIgnoringVisibility;
            WindowManager windowManager = (WindowManager) DeviceInfo.this.f10995e.getSystemService("window");
            if (windowManager == null) {
                return 0.0d;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Configuration configuration = DeviceInfo.this.f10995e.getResources().getConfiguration();
                insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemGestures());
                i8 = (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
                f8 = configuration.densityDpi;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i8 = displayMetrics.heightPixels;
                f8 = displayMetrics.ydpi;
            }
            return I(i8 / f8);
        }

        private int x() {
            WindowMetrics currentWindowMetrics;
            Insets insetsIgnoringVisibility;
            WindowManager windowManager = (WindowManager) DeviceInfo.this.f10995e.getSystemService("window");
            if (windowManager == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemGestures());
                return (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }

        private String y() {
            return Build.MANUFACTURER;
        }

        private String z() {
            return Build.MODEL.replace(y(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceInfo(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, CoreMetaData coreMetaData) {
        this.f10995e = context;
        this.f10994d = cleverTapInstanceConfig;
        this.f11001k = coreMetaData;
        U(str);
        Logger s7 = s();
        s7.s(cleverTapInstanceConfig.c() + ":async_deviceID", "DeviceInfo() called");
    }

    private String A() {
        return StorageHelper.i(this.f10995e, B(), null);
    }

    private String B() {
        return "fallbackId:" + this.f10994d.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(String str) {
        Logger s7 = s();
        s7.s(this.f10994d.c() + ":async_deviceID", "Called initDeviceID()");
        if (this.f10994d.i()) {
            if (str == null) {
                this.f10994d.n().l(W(18, new String[0]));
            }
        } else if (str != null) {
            this.f10994d.n().l(W(19, new String[0]));
        }
        Logger s8 = s();
        s8.s(this.f10994d.c() + ":async_deviceID", "Calling _getDeviceID");
        String a8 = a();
        Logger s9 = s();
        s9.s(this.f10994d.c() + ":async_deviceID", "Called _getDeviceID");
        if (a8 != null && a8.trim().length() > 2) {
            s().s(this.f10994d.c(), "CleverTap ID already present for profile");
            if (str != null) {
                s().m(this.f10994d.c(), W(20, a8, str));
            }
        } else if (this.f10994d.i()) {
            i(str);
        } else if (!this.f10994d.z()) {
            Logger s10 = s();
            s10.s(this.f10994d.c() + ":async_deviceID", "Calling generateDeviceID()");
            k();
            Logger s11 = s();
            s11.s(this.f10994d.c() + ":async_deviceID", "Called generateDeviceID()");
        } else {
            g();
            k();
            Logger s12 = s();
            s12.s(this.f10994d.c() + ":async_deviceID", "initDeviceID() done executing!");
        }
    }

    private String W(int i8, String... strArr) {
        ValidationResult b8 = ValidationResultFactory.b(514, i8, strArr);
        this.f11002l.add(b8);
        return b8.b();
    }

    private void X() {
        StorageHelper.r(this.f10995e, y());
    }

    private String a() {
        synchronized (this.f10996f) {
            if (this.f10994d.t()) {
                String i8 = StorageHelper.i(this.f10995e, y(), null);
                if (i8 == null) {
                    i8 = StorageHelper.i(this.f10995e, "deviceId", null);
                }
                return i8;
            }
            return StorageHelper.i(this.f10995e, y(), null);
        }
    }

    private synchronized void a0() {
        if (A() == null) {
            synchronized (this.f10996f) {
                String str = "__i" + UUID.randomUUID().toString().replace("-", "");
                if (str.trim().length() > 2) {
                    b0(str);
                } else {
                    s().s(this.f10994d.c(), "Unable to generate fallback error device ID");
                }
            }
        }
    }

    private void b0(String str) {
        Logger s7 = s();
        String c8 = this.f10994d.c();
        s7.s(c8, "Updating the fallback id - " + str);
        StorageHelper.p(this.f10995e, B(), str);
    }

    private synchronized void g() {
        s().s(this.f10994d.c() + ":async_deviceID", "fetchGoogleAdID() called!");
        if (C() == null && !this.f10992b) {
            boolean z7 = true;
            this.f10992b = true;
            Object invoke = AdvertisingIdClient.class.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.f10995e);
            Boolean bool = (Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0]);
            synchronized (this.f10991a) {
                if (bool == null || !bool.booleanValue()) {
                    z7 = false;
                }
                this.f11000j = z7;
                s().s(this.f10994d.c() + ":async_deviceID", "limitAdTracking = " + this.f11000j);
                if (this.f11000j) {
                    s().f(this.f10994d.c(), "Device user has opted out of sharing Advertising ID, falling back to random UUID for CleverTap ID generation");
                    return;
                }
                String str = (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
                if (str != null && str.trim().length() > 2) {
                    synchronized (this.f10991a) {
                        if (str.contains("00000000")) {
                            s().f(this.f10994d.c(), "Device user has opted out of sharing Advertising ID, falling back to random UUID for CleverTap ID generation");
                            return;
                        }
                        this.f10998h = str.replace("-", "");
                    }
                }
                s().s(this.f10994d.c() + ":async_deviceID", "fetchGoogleAdID() done executing!");
            }
        }
    }

    private synchronized void k() {
        String l8;
        String str;
        s().s(this.f10994d.c() + ":async_deviceID", "generateDeviceID() called!");
        String C = C();
        if (C != null) {
            str = "__g" + C;
        } else {
            synchronized (this.f10996f) {
                l8 = l();
            }
            str = l8;
        }
        j(str);
        s().s(this.f10994d.c() + ":async_deviceID", "generateDeviceID() done executing!");
    }

    private String l() {
        return "__" + UUID.randomUUID().toString().replace("-", "");
    }

    public static int n(Context context) {
        return context.getApplicationInfo().icon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Logger s() {
        return this.f10994d.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DeviceCachedInfo w() {
        if (this.f10993c == null) {
            this.f10993c = new DeviceCachedInfo();
        }
        return this.f10993c;
    }

    private String y() {
        return "deviceId:" + this.f10994d.c();
    }

    public static int z(Context context) {
        int i8;
        if (f10990m == -1) {
            try {
                if (((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4) {
                    f10990m = 3;
                    return 3;
                }
            } catch (Exception e8) {
                Logger.a("Failed to decide whether device is a TV!");
                e8.printStackTrace();
            }
            try {
                if (context.getResources().getBoolean(R$bool.ctIsTablet)) {
                    i8 = 2;
                } else {
                    i8 = 1;
                }
                f10990m = i8;
            } catch (Exception e9) {
                Logger.a("Failed to decide whether device is a smart phone or tablet!");
                e9.printStackTrace();
                f10990m = 0;
            }
        }
        return f10990m;
    }

    public String C() {
        String str;
        synchronized (this.f10991a) {
            str = this.f10998h;
        }
        return str;
    }

    public double D() {
        return w().f11012f;
    }

    public String E() {
        return this.f10999i;
    }

    public String F() {
        return w().f11014h;
    }

    public String G() {
        return w().f11015i;
    }

    public String H() {
        return w().f11016j;
    }

    public boolean I() {
        return w().f11017k;
    }

    public String J() {
        return w().f11018l;
    }

    public String K() {
        return w().f11019m;
    }

    public int L() {
        return w().f11020n;
    }

    public ArrayList<ValidationResult> M() {
        ArrayList<ValidationResult> arrayList = (ArrayList) this.f11002l.clone();
        this.f11002l.clear();
        return arrayList;
    }

    public String N() {
        return w().f11021o;
    }

    public double O() {
        return w().f11022p;
    }

    @SuppressLint({"MissingPermission"})
    public Boolean Q() {
        BluetoothAdapter defaultAdapter;
        try {
            if (this.f10995e.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.f10995e.getPackageName()) != 0 || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
                return null;
            }
            return Boolean.valueOf(defaultAdapter.isEnabled());
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean R() {
        if (x() != null && x().startsWith("__i")) {
            return true;
        }
        return false;
    }

    public boolean S() {
        boolean z7;
        synchronized (this.f10991a) {
            z7 = this.f11000j;
        }
        return z7;
    }

    public Boolean T() {
        ConnectivityManager connectivityManager;
        if (this.f10995e.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && (connectivityManager = (ConnectivityManager) this.f10995e.getSystemService("connectivity")) != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z7 = true;
            return Boolean.valueOf((activeNetworkInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected()) ? false : false);
        }
        return null;
    }

    void U(final String str) {
        CTExecutorFactory.a(this.f10994d).a().d("getDeviceCachedInfo", new Callable<Void>() { // from class: com.clevertap.android.sdk.DeviceInfo.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                DeviceInfo.this.w();
                return null;
            }
        });
        Task a8 = CTExecutorFactory.a(this.f10994d).a();
        a8.b(new OnSuccessListener<Void>() { // from class: com.clevertap.android.sdk.DeviceInfo.2
            @Override // com.clevertap.android.sdk.task.OnSuccessListener
            /* renamed from: a */
            public void onSuccess(Void r42) {
                DeviceInfo.this.s().s(DeviceInfo.this.f10994d.c() + ":async_deviceID", "DeviceID initialized successfully!" + Thread.currentThread());
                CleverTapAPI.K(DeviceInfo.this.f10995e, DeviceInfo.this.f10994d).p(DeviceInfo.this.x());
            }
        });
        a8.d("initDeviceID", new Callable<Void>() { // from class: com.clevertap.android.sdk.DeviceInfo.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                DeviceInfo.this.P(str);
                return null;
            }
        });
    }

    String V() {
        String x7 = x();
        if (x7 == null) {
            return null;
        }
        return "OptOut:" + x7;
    }

    public void Y() {
        String V = V();
        if (V == null) {
            this.f10994d.n().s(this.f10994d.c(), "Unable to set current user OptOut state from storage: storage key is null");
            return;
        }
        boolean b8 = StorageHelper.b(this.f10995e, this.f10994d, V);
        this.f11001k.N(b8);
        Logger n8 = this.f10994d.n();
        String c8 = this.f10994d.c();
        n8.s(c8, "Set current user OptOut state from storage to: " + b8 + " for key: " + V);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        boolean b8 = StorageHelper.b(this.f10995e, this.f10994d, "NetworkInfo");
        Logger n8 = this.f10994d.n();
        String c8 = this.f10994d.c();
        n8.s(c8, "Setting device network info reporting state from storage to " + b8);
        this.f10997g = b8;
    }

    public void h() {
        j(l());
    }

    public void i(String str) {
        if (Utils.x(str)) {
            Logger s7 = s();
            String c8 = this.f10994d.c();
            s7.m(c8, "Setting CleverTap ID to custom CleverTap ID : " + str);
            j("__h" + str);
            return;
        }
        a0();
        X();
        s().m(this.f10994d.c(), W(21, str, A()));
    }

    @SuppressLint({"CommitPrefEdits"})
    public void j(String str) {
        Logger s7 = s();
        String c8 = this.f10994d.c();
        s7.s(c8, "Force updating the device ID to " + str);
        synchronized (this.f10996f) {
            StorageHelper.p(this.f10995e, y(), str);
        }
    }

    public String m() {
        return w().f11024r;
    }

    public JSONObject o() {
        boolean z7 = false;
        try {
            if (C() != null) {
                z7 = new LoginInfoProvider(this.f10995e, this.f10994d, this).b();
            }
            return CTJsonConverter.b(this, this.f11001k.n(), this.f10997g, z7);
        } catch (Throwable th) {
            this.f10994d.n().t(this.f10994d.c(), "Failed to construct App Launched event", th);
            return new JSONObject();
        }
    }

    public String p() {
        return w().f11007a;
    }

    public int q() {
        return w().f11008b;
    }

    public String r() {
        return w().f11009c;
    }

    public Context t() {
        return this.f10995e;
    }

    public String u() {
        return w().f11010d;
    }

    public int v() {
        return w().f11011e;
    }

    public String x() {
        if (a() != null) {
            return a();
        }
        return A();
    }
}
