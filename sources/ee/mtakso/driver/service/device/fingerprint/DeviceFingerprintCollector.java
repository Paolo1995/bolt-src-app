package ee.mtakso.driver.service.device.fingerprint;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ee.mtakso.driver.platform.installation.InstallationIdProvider;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import j$.util.Spliterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DeviceFingerprintCollector.kt */
/* loaded from: classes3.dex */
public final class DeviceFingerprintCollector {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f24286c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f24287d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f24288a;

    /* renamed from: b  reason: collision with root package name */
    private final InstallationIdProvider f24289b;

    /* compiled from: DeviceFingerprintCollector.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        List<String> n8;
        n8 = CollectionsKt__CollectionsKt.n("eth0", "wlan0");
        f24287d = n8;
    }

    @Inject
    public DeviceFingerprintCollector(Context context, InstallationIdProvider idProvider) {
        Intrinsics.f(context, "context");
        Intrinsics.f(idProvider, "idProvider");
        this.f24288a = context;
        this.f24289b = idProvider;
    }

    private final void A(StringBuilder sb) {
        boolean z7;
        if (sb.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private final void b(JsonObject jsonObject, String str, Function0<String> function0) {
        try {
            jsonObject.addProperty(str, function0.invoke());
        } catch (SecurityException e8) {
            Kalev.c(e8, "Cannot add property to JSON: " + str);
        }
    }

    private final JsonArray c(String[] strArr) {
        JsonArray jsonArray = new JsonArray();
        for (String str : strArr) {
            jsonArray.add(str);
        }
        return jsonArray;
    }

    private final Boolean d() {
        try {
            boolean z7 = false;
            if (Settings.Global.getInt(this.f24288a.getContentResolver(), "development_settings_enabled", 0) == 1) {
                z7 = true;
            }
            return Boolean.valueOf(z7);
        } catch (Exception e8) {
            Kalev.e(e8, "Failed to dev options status!");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject f(DeviceFingerprintCollector this$0) {
        Intrinsics.f(this$0, "this$0");
        JsonObject jsonObject = new JsonObject();
        this$0.k(jsonObject);
        this$0.h(jsonObject);
        this$0.p(jsonObject);
        this$0.n(jsonObject);
        this$0.j(jsonObject);
        this$0.o(jsonObject);
        this$0.g(jsonObject);
        this$0.i(jsonObject);
        this$0.l(jsonObject);
        this$0.m(jsonObject);
        Kalev.h("Data points collected: " + jsonObject);
        return jsonObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c A[Catch: Exception -> 0x00a4, TRY_ENTER, TryCatch #0 {Exception -> 0x00a4, blocks: (B:2:0x0000, B:5:0x0013, B:14:0x0023, B:17:0x002c, B:19:0x0032, B:22:0x003d, B:24:0x0043, B:26:0x005e, B:28:0x0066, B:31:0x0071, B:33:0x0077, B:36:0x0082, B:38:0x0088, B:41:0x0093, B:42:0x0097), top: B:47:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d A[Catch: Exception -> 0x00a4, TRY_ENTER, TryCatch #0 {Exception -> 0x00a4, blocks: (B:2:0x0000, B:5:0x0013, B:14:0x0023, B:17:0x002c, B:19:0x0032, B:22:0x003d, B:24:0x0043, B:26:0x005e, B:28:0x0066, B:31:0x0071, B:33:0x0077, B:36:0x0082, B:38:0x0088, B:41:0x0093, B:42:0x0097), top: B:47:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e A[Catch: Exception -> 0x00a4, TryCatch #0 {Exception -> 0x00a4, blocks: (B:2:0x0000, B:5:0x0013, B:14:0x0023, B:17:0x002c, B:19:0x0032, B:22:0x003d, B:24:0x0043, B:26:0x005e, B:28:0x0066, B:31:0x0071, B:33:0x0077, B:36:0x0082, B:38:0x0088, B:41:0x0093, B:42:0x0097), top: B:47:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071 A[Catch: Exception -> 0x00a4, TRY_ENTER, TryCatch #0 {Exception -> 0x00a4, blocks: (B:2:0x0000, B:5:0x0013, B:14:0x0023, B:17:0x002c, B:19:0x0032, B:22:0x003d, B:24:0x0043, B:26:0x005e, B:28:0x0066, B:31:0x0071, B:33:0x0077, B:36:0x0082, B:38:0x0088, B:41:0x0093, B:42:0x0097), top: B:47:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[Catch: Exception -> 0x00a4, TRY_ENTER, TryCatch #0 {Exception -> 0x00a4, blocks: (B:2:0x0000, B:5:0x0013, B:14:0x0023, B:17:0x002c, B:19:0x0032, B:22:0x003d, B:24:0x0043, B:26:0x005e, B:28:0x0066, B:31:0x0071, B:33:0x0077, B:36:0x0082, B:38:0x0088, B:41:0x0093, B:42:0x0097), top: B:47:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093 A[Catch: Exception -> 0x00a4, TRY_ENTER, TryCatch #0 {Exception -> 0x00a4, blocks: (B:2:0x0000, B:5:0x0013, B:14:0x0023, B:17:0x002c, B:19:0x0032, B:22:0x003d, B:24:0x0043, B:26:0x005e, B:28:0x0066, B:31:0x0071, B:33:0x0077, B:36:0x0082, B:38:0x0088, B:41:0x0093, B:42:0x0097), top: B:47:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void g(com.google.gson.JsonObject r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.f24288a     // Catch: java.lang.Exception -> La4
            r1 = 0
            android.content.IntentFilter r2 = new android.content.IntentFilter     // Catch: java.lang.Exception -> La4
            java.lang.String r3 = "android.intent.action.BATTERY_CHANGED"
            r2.<init>(r3)     // Catch: java.lang.Exception -> La4
            android.content.Intent r0 = r0.registerReceiver(r1, r2)     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = "status"
            r2 = -1
            if (r0 == 0) goto L18
            int r3 = r0.getIntExtra(r1, r2)     // Catch: java.lang.Exception -> La4
            goto L19
        L18:
            r3 = -1
        L19:
            r4 = 2
            if (r3 == r4) goto L22
            r4 = 5
            if (r3 != r4) goto L20
            goto L22
        L20:
            r4 = 0
            goto L23
        L22:
            r4 = 1
        L23:
            com.google.gson.JsonObject r5 = new com.google.gson.JsonObject     // Catch: java.lang.Exception -> La4
            r5.<init>()     // Catch: java.lang.Exception -> La4
            java.lang.String r6 = "level"
            if (r0 == 0) goto L31
            int r7 = r0.getIntExtra(r6, r2)     // Catch: java.lang.Exception -> La4
            goto L32
        L31:
            r7 = -1
        L32:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> La4
            r5.addProperty(r6, r7)     // Catch: java.lang.Exception -> La4
            java.lang.String r6 = "scale"
            if (r0 == 0) goto L42
            int r7 = r0.getIntExtra(r6, r2)     // Catch: java.lang.Exception -> La4
            goto L43
        L42:
            r7 = -1
        L43:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> La4
            r5.addProperty(r6, r7)     // Catch: java.lang.Exception -> La4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> La4
            r5.addProperty(r1, r3)     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = "charging"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> La4
            r5.addProperty(r1, r3)     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = "chargeplug"
            if (r0 == 0) goto L65
            java.lang.String r3 = "plugged"
            int r3 = r0.getIntExtra(r3, r2)     // Catch: java.lang.Exception -> La4
            goto L66
        L65:
            r3 = -1
        L66:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> La4
            r5.addProperty(r1, r3)     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = "temperature"
            if (r0 == 0) goto L76
            int r3 = r0.getIntExtra(r1, r2)     // Catch: java.lang.Exception -> La4
            goto L77
        L76:
            r3 = -1
        L77:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> La4
            r5.addProperty(r1, r3)     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = "voltage"
            if (r0 == 0) goto L87
            int r3 = r0.getIntExtra(r1, r2)     // Catch: java.lang.Exception -> La4
            goto L88
        L87:
            r3 = -1
        L88:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> La4
            r5.addProperty(r1, r3)     // Catch: java.lang.Exception -> La4
            java.lang.String r1 = "health"
            if (r0 == 0) goto L97
            int r2 = r0.getIntExtra(r1, r2)     // Catch: java.lang.Exception -> La4
        L97:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> La4
            r5.addProperty(r1, r0)     // Catch: java.lang.Exception -> La4
            java.lang.String r0 = "73"
            r9.add(r0, r5)     // Catch: java.lang.Exception -> La4
            goto Laa
        La4:
            r9 = move-exception
            java.lang.String r0 = "Failed to get battery status!"
            eu.bolt.kalev.Kalev.c(r9, r0)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintCollector.g(com.google.gson.JsonObject):void");
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private final void h(JsonObject jsonObject) {
        jsonObject.addProperty("1", Build.MANUFACTURER);
        jsonObject.addProperty("2", Build.MODEL);
        jsonObject.addProperty("3", Build.BOARD);
        jsonObject.addProperty("4", Build.BOOTLOADER);
        jsonObject.addProperty("5", Build.BRAND);
        String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
        Intrinsics.e(SUPPORTED_ABIS, "SUPPORTED_ABIS");
        jsonObject.add("6", c(SUPPORTED_ABIS));
        jsonObject.addProperty("7", Build.DEVICE);
        jsonObject.addProperty("8", Build.FINGERPRINT);
        jsonObject.addProperty("9", Build.HARDWARE);
        jsonObject.addProperty("10", Build.ID);
        jsonObject.addProperty("11", Build.getRadioVersion());
        b(jsonObject, "12", new Function0<String>() { // from class: ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintCollector$collectBuild$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final String invoke() {
                String SERIAL = Build.SERIAL;
                Intrinsics.e(SERIAL, "SERIAL");
                return SERIAL;
            }
        });
        jsonObject.addProperty("13", Integer.valueOf(Build.VERSION.SDK_INT));
        jsonObject.addProperty("14", Build.VERSION.RELEASE);
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private final void i(JsonObject jsonObject) {
        TelephonyManager telephonyManager;
        String str;
        String str2;
        jsonObject.addProperty("36", Settings.Secure.getString(this.f24288a.getContentResolver(), "android_id"));
        Object systemService = this.f24288a.getSystemService("phone");
        String str3 = null;
        if (systemService instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) systemService;
        } else {
            telephonyManager = null;
        }
        jsonObject.addProperty("29", "");
        if (telephonyManager != null) {
            str = telephonyManager.getSimCountryIso();
        } else {
            str = null;
        }
        jsonObject.addProperty("87", str);
        if (telephonyManager != null) {
            str2 = telephonyManager.getSimOperator();
        } else {
            str2 = null;
        }
        jsonObject.addProperty("33", str2);
        if (telephonyManager != null) {
            str3 = telephonyManager.getNetworkOperatorName();
        }
        jsonObject.addProperty("34", str3);
    }

    private final void j(JsonObject jsonObject) {
        WindowManager windowManager;
        Display display;
        Object systemService = this.f24288a.getSystemService("window");
        Integer num = null;
        if (systemService instanceof WindowManager) {
            windowManager = (WindowManager) systemService;
        } else {
            windowManager = null;
        }
        jsonObject.addProperty("16", Float.valueOf(this.f24288a.getResources().getConfiguration().fontScale));
        if (windowManager != null) {
            display = windowManager.getDefaultDisplay();
        } else {
            display = null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 30) {
            if (display != null) {
                display.getRealMetrics(displayMetrics);
            }
        } else if (display != null) {
            display.getMetrics(displayMetrics);
        }
        if (display != null) {
            num = Integer.valueOf(display.getRotation());
        }
        jsonObject.addProperty("28", num);
        jsonObject.addProperty("21", Float.valueOf(displayMetrics.density));
        jsonObject.addProperty("22", Integer.valueOf(displayMetrics.densityDpi));
        jsonObject.addProperty("23", Integer.valueOf(displayMetrics.heightPixels));
        jsonObject.addProperty("24", Float.valueOf(displayMetrics.scaledDensity));
        jsonObject.addProperty("25", Integer.valueOf(displayMetrics.widthPixels));
        jsonObject.addProperty("26", Float.valueOf(displayMetrics.xdpi));
        jsonObject.addProperty("27", Float.valueOf(displayMetrics.ydpi));
    }

    private final void k(JsonObject jsonObject) {
        try {
            jsonObject.addProperty("64", InetAddress.getByName(r("wlan0", true)).getHostName());
        } catch (UnknownHostException e8) {
            Kalev.c(e8, "Failed to get InetAddress");
        }
    }

    @SuppressLint({"HardwareIds", "", "MissingPermission"})
    private final void l(JsonObject jsonObject) {
        WifiManager wifiManager;
        ConnectivityManager connectivityManager;
        String str;
        Object systemService = this.f24288a.getApplicationContext().getSystemService("wifi");
        String str2 = null;
        if (systemService instanceof WifiManager) {
            wifiManager = (WifiManager) systemService;
        } else {
            wifiManager = null;
        }
        if (wifiManager != null) {
            String bssid = wifiManager.getConnectionInfo().getBSSID();
            String str3 = "";
            if (bssid == null) {
                bssid = "";
            }
            jsonObject.addProperty("49", bssid);
            String ssid = wifiManager.getConnectionInfo().getSSID();
            if (ssid == null) {
                ssid = "";
            }
            jsonObject.addProperty("50", ssid);
            String macAddress = wifiManager.getConnectionInfo().getMacAddress();
            if (macAddress != null) {
                str3 = macAddress;
            }
            jsonObject.addProperty("51", str3);
            jsonObject.addProperty("52", t(wifiManager.getConnectionInfo().getIpAddress()));
            jsonObject.addProperty("53", Integer.valueOf(wifiManager.getConnectionInfo().getRssi()));
            jsonObject.addProperty("54", Integer.valueOf(wifiManager.getConnectionInfo().getLinkSpeed()));
            jsonObject.addProperty("55", t(wifiManager.getDhcpInfo().ipAddress));
            jsonObject.addProperty("56", t(wifiManager.getDhcpInfo().gateway));
            jsonObject.addProperty("57", t(wifiManager.getDhcpInfo().dns1));
            jsonObject.addProperty("58", t(wifiManager.getDhcpInfo().dns2));
            jsonObject.addProperty("59", t(wifiManager.getDhcpInfo().serverAddress));
            jsonObject.addProperty("60", Integer.valueOf(wifiManager.getDhcpInfo().netmask));
            jsonObject.addProperty("61", Integer.valueOf(wifiManager.getDhcpInfo().leaseDuration));
        }
        try {
            Object systemService2 = this.f24288a.getSystemService("connectivity");
            if (systemService2 instanceof ConnectivityManager) {
                connectivityManager = (ConnectivityManager) systemService2;
            } else {
                connectivityManager = null;
            }
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    str = activeNetworkInfo.getTypeName();
                } else {
                    str = null;
                }
                jsonObject.addProperty("62", str);
                NetworkInfo activeNetworkInfo2 = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo2 != null) {
                    str2 = activeNetworkInfo2.getSubtypeName();
                }
                jsonObject.addProperty("63", str2);
            }
            jsonObject.addProperty("65", s("wlan0"));
            jsonObject.addProperty("66", r("wlan0", false));
            jsonObject.addProperty("67", r("wlan0", true));
        } catch (Exception e8) {
            Kalev.c(e8, "Failed to get network info!");
        }
    }

    private final void m(JsonObject jsonObject) {
        jsonObject.addProperty("37", Long.valueOf(SystemClock.elapsedRealtime()));
        jsonObject.addProperty("38", Long.valueOf(SystemClock.uptimeMillis()));
        jsonObject.addProperty("39", Integer.valueOf(Settings.System.getInt(this.f24288a.getContentResolver(), "screen_brightness", -1)));
        Runtime runtime = Runtime.getRuntime();
        jsonObject.addProperty("40", Long.valueOf(runtime.totalMemory()));
        jsonObject.addProperty("41", Long.valueOf(runtime.freeMemory()));
        jsonObject.addProperty("42", Integer.valueOf(runtime.availableProcessors()));
        jsonObject.addProperty("43", this.f24288a.getResources().getConfiguration().locale.getCountry());
        jsonObject.addProperty("44", this.f24288a.getResources().getConfiguration().locale.getLanguage());
        jsonObject.addProperty("45", TimeZone.getDefault().getID());
        jsonObject.addProperty("46", System.getProperty("os.name"));
        jsonObject.addProperty("47", System.getProperty("os.arch"));
        jsonObject.addProperty("48", System.getProperty("os.version"));
        jsonObject.add("69", c((String[]) System.getenv().values().toArray(new String[0])));
        jsonObject.addProperty("70", Integer.valueOf(Process.myPid()));
        jsonObject.addProperty("71", q());
        try {
            jsonObject.addProperty("79", this.f24289b.a().d());
        } catch (Exception e8) {
            Kalev.c(e8, "Failed to get installation id!");
        }
        Boolean d8 = d();
        if (d8 != null) {
            jsonObject.addProperty("80", Boolean.valueOf(d8.booleanValue()));
        }
    }

    private final void n(JsonObject jsonObject) {
        String str;
        String str2;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), Spliterator.NONNULL);
            str2 = bufferedReader.readLine();
            CloseableKt.a(bufferedReader, null);
        } catch (Exception unused) {
            Kalev.b("Failed to read /proc/version!");
            try {
                str = System.getProperty("os.version");
            } catch (Exception unused2) {
                Kalev.b("Failed to get system prob os.version!");
                str = "unavailable";
            }
            str2 = str;
        }
        jsonObject.addProperty("68", str2);
    }

    private final void o(JsonObject jsonObject) {
        try {
            Object systemService = this.f24288a.getSystemService("sensor");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            List<Sensor> sensorList = ((SensorManager) systemService).getSensorList(-1);
            JsonObject jsonObject2 = new JsonObject();
            for (Sensor sensor : sensorList) {
                String name = sensor.getName();
                String vendor = sensor.getVendor();
                int version = sensor.getVersion();
                jsonObject2.addProperty(name, vendor + "/" + version);
            }
            jsonObject.add("72", jsonObject2);
        } catch (Exception e8) {
            Kalev.c(e8, "Failed to get device sensors!");
        }
    }

    @SuppressLint({"UsableSpace"})
    private final void p(JsonObject jsonObject) {
        Long l8;
        jsonObject.addProperty("17", Long.valueOf(Environment.getDataDirectory().getUsableSpace()));
        jsonObject.addProperty("18", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
        if (Build.VERSION.SDK_INT >= 29) {
            Long l9 = null;
            File externalFilesDir = this.f24288a.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                l8 = Long.valueOf(externalFilesDir.getUsableSpace());
            } else {
                l8 = null;
            }
            jsonObject.addProperty("19", l8);
            File externalFilesDir2 = this.f24288a.getExternalFilesDir(null);
            if (externalFilesDir2 != null) {
                l9 = Long.valueOf(externalFilesDir2.getUsableSpace());
            }
            jsonObject.addProperty("19", l9);
            return;
        }
        jsonObject.addProperty("19", Long.valueOf(Environment.getExternalStorageDirectory().getUsableSpace()));
        jsonObject.addProperty("20", Long.valueOf(Environment.getExternalStorageDirectory().getTotalSpace()));
    }

    private final String q() {
        int myPid = Process.myPid();
        Object systemService = this.f24288a.getSystemService("activity");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    Intrinsics.e(str, "processInfo.processName");
                    return str;
                }
            }
        }
        return "";
    }

    private final String r(String str, boolean z7) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            Intrinsics.e(networkInterfaces, "getNetworkInterfaces()");
            ArrayList<NetworkInterface> list = Collections.list(networkInterfaces);
            Intrinsics.e(list, "list(this)");
            for (NetworkInterface it : list) {
                Intrinsics.e(it, "it");
                Pair<Boolean, String> x7 = x(it, str, z7);
                if (x7.d().booleanValue()) {
                    return x7.e();
                }
            }
            return "";
        } catch (SocketException e8) {
            Kalev.e(e8, "Failed to get IP Address!");
            return "";
        }
    }

    private final String s(String str) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            Intrinsics.e(networkInterfaces, "getNetworkInterfaces()");
            ArrayList<NetworkInterface> list = Collections.list(networkInterfaces);
            Intrinsics.e(list, "list(this)");
            for (NetworkInterface it : list) {
                Intrinsics.e(it, "it");
                Pair<Boolean, String> y7 = y(it, str);
                if (y7.d().booleanValue()) {
                    return y7.e();
                }
            }
            return "";
        } catch (SocketException e8) {
            Kalev.e(e8, "Failed to read MAC Address!");
            return "";
        }
    }

    private final String t(int i8) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%d.%d.%d.%d", Arrays.copyOf(new Object[]{Integer.valueOf(i8 & 255), Integer.valueOf((i8 >>> 8) & 255), Integer.valueOf((i8 >>> 16) & 255), Integer.valueOf((i8 >>> 24) & 255)}, 4));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    private final String u(InetAddress inetAddress, boolean z7) {
        if (z7) {
            return v(inetAddress);
        }
        return w(inetAddress);
    }

    private final String v(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            String hostAddress = ((Inet4Address) inetAddress).getHostAddress();
            Intrinsics.e(hostAddress, "address.hostAddress");
            return hostAddress;
        }
        return "";
    }

    private final String w(InetAddress inetAddress) {
        Inet6Address inet6Address;
        String hostAddress;
        String z7;
        if (inetAddress instanceof Inet6Address) {
            inet6Address = (Inet6Address) inetAddress;
        } else {
            inet6Address = null;
        }
        if (inet6Address == null || (hostAddress = inet6Address.getHostAddress()) == null || (z7 = z(hostAddress)) == null) {
            return "";
        }
        return z7;
    }

    private final Pair<Boolean, String> x(NetworkInterface networkInterface, String str, boolean z7) {
        boolean y7;
        boolean w7;
        Pair<Boolean, String> a8 = TuplesKt.a(Boolean.FALSE, "");
        if (str != null) {
            w7 = StringsKt__StringsJVMKt.w(networkInterface.getName(), str, true);
            if (!w7) {
                return a8;
            }
        }
        if (!f24287d.contains(networkInterface.getName())) {
            return a8;
        }
        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
        Intrinsics.e(inetAddresses, "networkInterface.inetAddresses");
        ArrayList<InetAddress> list = Collections.list(inetAddresses);
        Intrinsics.e(list, "list(this)");
        for (InetAddress it : list) {
            if (!it.isLoopbackAddress()) {
                Intrinsics.e(it, "it");
                String u7 = u(it, z7);
                y7 = StringsKt__StringsJVMKt.y(u7);
                if (!y7) {
                    return TuplesKt.a(Boolean.TRUE, u7);
                }
            }
        }
        return a8;
    }

    private final Pair<Boolean, String> y(NetworkInterface networkInterface, String str) {
        boolean w7;
        Pair<Boolean, String> a8 = TuplesKt.a(Boolean.FALSE, "");
        if (str != null) {
            w7 = StringsKt__StringsJVMKt.w(networkInterface.getName(), str, true);
            if (!w7) {
                return a8;
            }
        }
        if (!f24287d.contains(networkInterface.getName())) {
            return a8;
        }
        byte[] hardwareAddress = networkInterface.getHardwareAddress();
        if (hardwareAddress == null) {
            return a8;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b8 : hardwareAddress) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            String format = String.format("%02X:", Arrays.copyOf(new Object[]{Byte.valueOf(b8)}, 1));
            Intrinsics.e(format, "format(format, *args)");
            sb.append(format);
        }
        A(sb);
        Boolean bool = Boolean.TRUE;
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "buf.toString()");
        return TuplesKt.a(bool, sb2);
    }

    private final String z(String str) {
        int b02;
        b02 = StringsKt__StringsKt.b0(str, "%", 0, false, 6, null);
        if (b02 >= 0) {
            String substring = str.substring(0, b02);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public final Single<JsonObject> e() {
        Single<JsonObject> u7 = Single.u(new Callable() { // from class: ee.mtakso.driver.service.device.fingerprint.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                JsonObject f8;
                f8 = DeviceFingerprintCollector.f(DeviceFingerprintCollector.this);
                return f8;
            }
        });
        Intrinsics.e(u7, "fromCallable {\n         …    fingerprint\n        }");
        return u7;
    }
}
