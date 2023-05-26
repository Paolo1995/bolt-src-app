package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFd1sSDK;
import com.sinch.android.rtc.internal.client.DeviceInformation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFb1tSDK implements AFb1sSDK {
    private static int AFLogger = 125;
    private static short[] AFLogger$LogLevel = null;
    private static int AFVersionDeclaration = 0;
    private static byte[] afErrorLogForExcManagerOnly = {20, -83, 11, -70, 0};
    private static int afRDLog = -146565613;
    private static int afWarnLog = -1891164548;
    private static int getLevel = 1;
    private final String valueOf = "yyyy-MM-dd HH:mm:ssZ";
    private List<String> values = new ArrayList();
    private boolean AFKeystoreWrapper = true;
    @NonNull
    private final Map<String, Object> AFInAppEventParameterName = new HashMap();
    private String afErrorLog = "-1";
    private boolean afInfoLog = true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
    private int AFInAppEventType = 0;
    private boolean afDebugLog = false;

    private synchronized void AFInAppEventType(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.AFInAppEventParameterName.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if ((str2 != null ? (char) 23 : 'a') != 'a') {
            try {
                int i8 = getLevel + 91;
                AFVersionDeclaration = i8 % 128;
                if (i8 % 2 != 0) {
                    str2.length();
                    throw null;
                } else if (str2.length() > 0) {
                    this.AFInAppEventParameterName.put("app_version", str2);
                    int i9 = getLevel + 109;
                    AFVersionDeclaration = i9 % 128;
                    int i10 = i9 % 2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str3 != null) {
            if ((str3.length() > 0 ? 'E' : 'Y') == 'E') {
                this.AFInAppEventParameterName.put(AppsFlyerProperties.CHANNEL, str3);
            }
        }
        if (str4 != null && str4.length() > 0) {
            int i11 = getLevel + 123;
            AFVersionDeclaration = i11 % 128;
            int i12 = i11 % 2;
            this.AFInAppEventParameterName.put("preInstall", str4);
        }
    }

    @NonNull
    private synchronized Map<String, Object> AFLogger() {
        Map<String, Object> map;
        int i8 = AFVersionDeclaration + 23;
        getLevel = i8 % 128;
        int i9 = i8 % 2;
        this.AFInAppEventParameterName.put("data", this.values);
        afErrorLog();
        map = this.AFInAppEventParameterName;
        int i10 = AFVersionDeclaration + 125;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        return map;
    }

    private synchronized void afErrorLog() {
        char c8;
        this.values = new ArrayList();
        this.AFInAppEventType = 0;
        int i8 = getLevel + 15;
        AFVersionDeclaration = i8 % 128;
        if (i8 % 2 != 0) {
            c8 = 14;
        } else {
            c8 = 19;
        }
        if (c8 != 19) {
            int i9 = 35 / 0;
        }
    }

    private boolean afRDLog() {
        boolean z7;
        char c8;
        if (this.afInfoLog) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i8 = AFVersionDeclaration + 41;
            getLevel = i8 % 128;
            int i9 = i8 % 2;
            if (!this.AFKeystoreWrapper) {
                c8 = 4;
            } else {
                c8 = 17;
            }
            if (c8 == 17 || this.afDebugLog) {
                return true;
            }
        }
        int i10 = AFVersionDeclaration + 53;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
        return false;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final synchronized void AFInAppEventParameterName() {
        this.afDebugLog = true;
        AFInAppEventParameterName("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        int i8 = AFVersionDeclaration + 95;
        getLevel = i8 % 128;
        int i9 = i8 % 2;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final synchronized void AFKeystoreWrapper(String str) {
        int i8 = getLevel;
        int i9 = i8 + 53;
        AFVersionDeclaration = i9 % 128;
        if (!(i9 % 2 != 0)) {
            this.afErrorLog = str;
        } else {
            this.afErrorLog = str;
            int i10 = 45 / 0;
        }
        int i11 = i8 + 13;
        AFVersionDeclaration = i11 % 128;
        int i12 = i11 % 2;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final boolean afInfoLog() {
        char c8;
        int i8 = AFVersionDeclaration + 7;
        int i9 = i8 % 128;
        getLevel = i9;
        int i10 = i8 % 2;
        boolean z7 = this.afDebugLog;
        int i11 = i9 + 63;
        AFVersionDeclaration = i11 % 128;
        if (i11 % 2 != 0) {
            c8 = '>';
        } else {
            c8 = ':';
        }
        if (c8 == ':') {
            return z7;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final void valueOf(String str, String str2) {
        int i8 = AFVersionDeclaration + 21;
        getLevel = i8 % 128;
        int i9 = i8 % 2;
        AFInAppEventParameterName((String) null, str, str2);
        int i10 = getLevel + 63;
        AFVersionDeclaration = i10 % 128;
        if ((i10 % 2 != 0 ? '\'' : 'Z') != '\'') {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final synchronized void values() {
        AFInAppEventParameterName("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.afDebugLog = false;
        this.AFKeystoreWrapper = false;
        int i8 = AFVersionDeclaration + 91;
        getLevel = i8 % 128;
        if ((i8 % 2 == 0 ? ';' : ')') != ')') {
            int i9 = 32 / 0;
        }
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final synchronized void AFKeystoreWrapper() {
        int i8 = AFVersionDeclaration + 23;
        getLevel = i8 % 128;
        int i9 = i8 % 2;
        this.AFInAppEventParameterName.clear();
        this.values.clear();
        this.AFInAppEventType = 0;
        int i10 = getLevel + 49;
        AFVersionDeclaration = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final void valueOf() {
        int i8 = getLevel + 77;
        int i9 = i8 % 128;
        AFVersionDeclaration = i9;
        int i10 = i8 % 2;
        this.afInfoLog = false;
        int i11 = i9 + 35;
        getLevel = i11 % 128;
        if (i11 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final void AFInAppEventParameterName(String str, PackageManager packageManager, AFc1vSDK aFc1vSDK) {
        try {
            AFe1uSDK aFe1uSDK = new AFe1uSDK(values(str, packageManager, aFc1vSDK), aFc1vSDK);
            AFd1sSDK afDebugLog = aFc1vSDK.afDebugLog();
            afDebugLog.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFe1uSDK));
            int i8 = AFVersionDeclaration + 21;
            getLevel = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("could not send proxy data", th);
        }
    }

    private Map<String, Object> values(String str, PackageManager packageManager, AFc1vSDK aFc1vSDK) {
        int i8 = getLevel + 103;
        AFVersionDeclaration = i8 % 128;
        if ((i8 % 2 != 0 ? '9' : '#') != '9') {
            values(str, packageManager, aFc1vSDK.getLevel());
            Map<String, Object> AFLogger2 = AFLogger();
            int i9 = getLevel + 43;
            AFVersionDeclaration = i9 % 128;
            int i10 = i9 % 2;
            return AFLogger2;
        }
        values(str, packageManager, aFc1vSDK.getLevel());
        AFLogger();
        throw null;
    }

    private synchronized void AFKeystoreWrapper(String str, String str2, String str3, String str4) {
        try {
            this.AFInAppEventParameterName.put("sdk_version", str);
            if ((str2 != null ? '\"' : '4') == '\"') {
                int i8 = AFVersionDeclaration + 53;
                getLevel = i8 % 128;
                int i9 = i8 % 2;
                if ((str2.length() > 0 ? (char) 22 : (char) 6) == 22) {
                    this.AFInAppEventParameterName.put("devkey", str2);
                }
            }
            if ((str3 != null ? '\'' : 'O') == '\'') {
                int i10 = AFVersionDeclaration + 29;
                getLevel = i10 % 128;
                int i11 = i10 % 2;
                if (str3.length() > 0) {
                    int i12 = getLevel + 29;
                    AFVersionDeclaration = i12 % 128;
                    int i13 = i12 % 2;
                    this.AFInAppEventParameterName.put("originalAppsFlyerId", str3);
                    int i14 = getLevel + 111;
                    AFVersionDeclaration = i14 % 128;
                    int i15 = i14 % 2;
                }
            }
            if (str4 != null) {
                if (!(str4.length() <= 0)) {
                    this.AFInAppEventParameterName.put("uid", str4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final void AFInAppEventParameterName(String str, String str2) {
        int i8 = getLevel + 5;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        AFInAppEventParameterName("server_request", str, str2);
        int i10 = getLevel + 41;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 == 0) {
            return;
        }
        throw null;
    }

    private synchronized void AFInAppEventParameterName(String str, String str2, String... strArr) {
        String obj;
        int i8 = getLevel + 75;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        if ((afRDLog() ? (char) 11 : 'V') == 11) {
            int i10 = AFVersionDeclaration + 39;
            getLevel = i10 % 128;
            int i11 = i10 % 2;
            if (this.AFInAppEventType < 98304) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String join = TextUtils.join(", ", strArr);
                    if (str != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(currentTimeMillis);
                        sb.append(" ");
                        sb.append(Thread.currentThread().getId());
                        sb.append(" _/AppsFlyer_6.10.2 [");
                        sb.append(str);
                        sb.append("] ");
                        sb.append(str2);
                        sb.append(" ");
                        sb.append(join);
                        obj = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(currentTimeMillis);
                        sb2.append(" ");
                        sb2.append(Thread.currentThread().getId());
                        sb2.append(" ");
                        sb2.append(str2);
                        sb2.append("/AppsFlyer_6.10.2 ");
                        sb2.append(join);
                        obj = sb2.toString();
                    }
                    this.values.add(obj);
                    this.AFInAppEventType += obj.length() << 1;
                    int i12 = getLevel + 47;
                    AFVersionDeclaration = i12 % 128;
                    if (!(i12 % 2 != 0)) {
                        return;
                    }
                    throw null;
                } catch (Throwable unused) {
                }
            }
        }
    }

    private synchronized void values(String str, String str2, String str3) {
        try {
            Map<String, Object> map = this.AFInAppEventParameterName;
            Object[] objArr = new Object[1];
            AFInAppEventType((ViewConfiguration.getFadingEdgeLength() >> 16) - 120, 146565612 - TextUtils.indexOf((CharSequence) "", '0', 0), (byte) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) - 57), 1891164645 - ExpandableListView.getPackedPositionChild(0L), (short) (TextUtils.indexOf("", "") + 29), objArr);
            map.put(((String) objArr[0]).intern(), Build.BRAND);
            this.AFInAppEventParameterName.put("model", Build.MODEL);
            this.AFInAppEventParameterName.put("platform", DeviceInformation.osName);
            this.AFInAppEventParameterName.put("platform_version", Build.VERSION.RELEASE);
            if (str != null) {
                int i8 = getLevel + 37;
                AFVersionDeclaration = i8 % 128;
                int i9 = i8 % 2;
                if (str.length() > 0) {
                    this.AFInAppEventParameterName.put("advertiserId", str);
                }
            }
            if (str2 != null) {
                int i10 = AFVersionDeclaration + 11;
                getLevel = i10 % 128;
                int i11 = i10 % 2;
                if ((str2.length() > 0 ? '7' : '\b') != '\b') {
                    this.AFInAppEventParameterName.put("imei", str2);
                }
            }
            if (str3 != null) {
                int i12 = getLevel + 57;
                AFVersionDeclaration = i12 % 128;
                int i13 = i12 % 2;
                if (str3.length() > 0) {
                    this.AFInAppEventParameterName.put("android_id", str3);
                }
            }
            int i14 = AFVersionDeclaration + 7;
            getLevel = i14 % 128;
            if (i14 % 2 == 0) {
                int i15 = 39 / 0;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final void AFInAppEventType(String str, String... strArr) {
        int i8 = AFVersionDeclaration + 27;
        getLevel = i8 % 128;
        char c8 = i8 % 2 == 0 ? '5' : 'X';
        AFInAppEventParameterName("public_api_call", str, strArr);
        if (c8 == '5') {
            throw null;
        }
        int i9 = AFVersionDeclaration + 13;
        getLevel = i9 % 128;
        int i10 = i9 % 2;
    }

    private static String[] AFInAppEventType(String str, StackTraceElement[] stackTraceElementArr) {
        int i8 = getLevel;
        int i9 = i8 + 85;
        AFVersionDeclaration = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
        int i10 = 1;
        if ((stackTraceElementArr == null ? '\'' : '.') != '.') {
            int i11 = i8 + 61;
            AFVersionDeclaration = i11 % 128;
            int i12 = i11 % 2;
            return new String[]{str};
        }
        String[] strArr = new String[stackTraceElementArr.length + 1];
        strArr[0] = str;
        while (i10 < stackTraceElementArr.length) {
            strArr[i10] = stackTraceElementArr[i10].toString();
            i10++;
            int i13 = getLevel + 51;
            AFVersionDeclaration = i13 % 128;
            int i14 = i13 % 2;
        }
        return strArr;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final void AFKeystoreWrapper(String str, int i8, String str2) {
        int i9 = getLevel + 97;
        AFVersionDeclaration = i9 % 128;
        if (i9 % 2 == 0) {
            AFInAppEventParameterName("server_response", str, String.valueOf(i8), str2);
        } else {
            String[] strArr = new String[3];
            strArr[1] = String.valueOf(i8);
            strArr[0] = str2;
            AFInAppEventParameterName("server_response", str, strArr);
        }
        int i10 = AFVersionDeclaration + 55;
        getLevel = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final synchronized void AFInAppEventType() {
        int i8 = AFVersionDeclaration + 15;
        getLevel = i8 % 128;
        if (!(i8 % 2 != 0)) {
            this.AFKeystoreWrapper = false;
        } else {
            this.AFKeystoreWrapper = false;
        }
        afErrorLog();
        int i9 = getLevel + 29;
        AFVersionDeclaration = i9 % 128;
        if (!(i9 % 2 != 0)) {
            return;
        }
        int i10 = 14 / 0;
    }

    @Override // com.appsflyer.internal.AFb1sSDK
    public final void values(Throwable th) {
        String message;
        StackTraceElement[] stackTrace;
        int i8 = AFVersionDeclaration + 71;
        getLevel = i8 % 128;
        if ((i8 % 2 == 0 ? (char) 30 : '+') == '+') {
            Throwable cause = th.getCause();
            String simpleName = th.getClass().getSimpleName();
            if ((cause == null ? '\b' : '*') != '*') {
                message = th.getMessage();
            } else {
                message = cause.getMessage();
                int i9 = getLevel + 45;
                AFVersionDeclaration = i9 % 128;
                int i10 = i9 % 2;
            }
            if (cause == null) {
                int i11 = getLevel + 115;
                AFVersionDeclaration = i11 % 128;
                int i12 = i11 % 2;
                stackTrace = th.getStackTrace();
            } else {
                stackTrace = cause.getStackTrace();
            }
            AFInAppEventParameterName("exception", simpleName, AFInAppEventType(message, stackTrace));
            return;
        }
        th.getCause();
        throw null;
    }

    private static void AFInAppEventType(int i8, int i9, byte b8, int i10, short s7, Object[] objArr) {
        String obj;
        synchronized (AFg1qSDK.valueOf) {
            StringBuilder sb = new StringBuilder();
            int i11 = AFLogger;
            int i12 = i8 + i11;
            boolean z7 = i12 == -1;
            if (z7) {
                byte[] bArr = afErrorLogForExcManagerOnly;
                if (bArr != null) {
                    i12 = (byte) (bArr[afRDLog + i9] + i11);
                } else {
                    i12 = (short) (AFLogger$LogLevel[afRDLog + i9] + i11);
                }
            }
            if (i12 > 0) {
                AFg1qSDK.values = ((i9 + i12) - 2) + afRDLog + (z7 ? 1 : 0);
                char c8 = (char) (i10 + afWarnLog);
                AFg1qSDK.AFKeystoreWrapper = c8;
                sb.append(c8);
                AFg1qSDK.AFInAppEventType = AFg1qSDK.AFKeystoreWrapper;
                AFg1qSDK.AFInAppEventParameterName = 1;
                while (AFg1qSDK.AFInAppEventParameterName < i12) {
                    byte[] bArr2 = afErrorLogForExcManagerOnly;
                    if (bArr2 != null) {
                        int i13 = AFg1qSDK.values;
                        AFg1qSDK.values = i13 - 1;
                        AFg1qSDK.AFKeystoreWrapper = (char) (AFg1qSDK.AFInAppEventType + (((byte) (bArr2[i13] + s7)) ^ b8));
                    } else {
                        short[] sArr = AFLogger$LogLevel;
                        int i14 = AFg1qSDK.values;
                        AFg1qSDK.values = i14 - 1;
                        AFg1qSDK.AFKeystoreWrapper = (char) (AFg1qSDK.AFInAppEventType + (((short) (sArr[i14] + s7)) ^ b8));
                    }
                    sb.append(AFg1qSDK.AFKeystoreWrapper);
                    AFg1qSDK.AFInAppEventType = AFg1qSDK.AFKeystoreWrapper;
                    AFg1qSDK.AFInAppEventParameterName++;
                }
            }
            obj = sb.toString();
        }
        objArr[0] = obj;
    }

    private synchronized void values(String str, PackageManager packageManager, AFe1nSDK aFe1nSDK) {
        int i8 = AFVersionDeclaration + 3;
        getLevel = i8 % 128;
        int i9 = i8 % 2;
        AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
        String string = appsFlyerProperties.getString("remote_debug_static_data");
        this.AFInAppEventParameterName.clear();
        if (string != null) {
            try {
                this.AFInAppEventParameterName.putAll(AFa1oSDK.AFInAppEventType(new JSONObject(string)));
                int i10 = getLevel + 49;
                AFVersionDeclaration = i10 % 128;
                int i11 = i10 % 2;
            } catch (Throwable unused) {
            }
        } else {
            AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
            values(appsFlyerProperties.getString("advertiserId"), aFe1nSDK.AFInAppEventType, AFInAppEventType.afErrorLog);
            StringBuilder sb = new StringBuilder("6.10.2.");
            sb.append(AFb1xSDK.valueOf);
            AFKeystoreWrapper(sb.toString(), AFInAppEventType.AFKeystoreWrapper().getLevel().values, appsFlyerProperties.getString("KSAppsFlyerId"), appsFlyerProperties.getString("uid"));
            try {
                int i12 = packageManager.getPackageInfo(str, 0).versionCode;
                AFInAppEventType(str, String.valueOf(i12), appsFlyerProperties.getString(AppsFlyerProperties.CHANNEL), appsFlyerProperties.getString("preInstallName"));
            } catch (Throwable unused2) {
            }
            appsFlyerProperties.set("remote_debug_static_data", new JSONObject(this.AFInAppEventParameterName).toString());
        }
        this.AFInAppEventParameterName.put("launch_counter", this.afErrorLog);
    }
}
