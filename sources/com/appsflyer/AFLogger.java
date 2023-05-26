package com.appsflyer;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import com.appsflyer.internal.AFb1cSDK;
import com.appsflyer.internal.AFb1xSDK;

/* loaded from: classes.dex */
public class AFLogger {
    private static final long valueOf = System.currentTimeMillis();

    /* loaded from: classes.dex */
    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        private int AFInAppEventParameterName;

        LogLevel(int i8) {
            this.AFInAppEventParameterName = i8;
        }

        public final int getLevel() {
            return this.AFInAppEventParameterName;
        }
    }

    public static void AFInAppEventParameterName(String str) {
        if (AFKeystoreWrapper(LogLevel.WARNING)) {
            Log.w("AppsFlyer_6.10.2", values(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf("W", values(str, true));
    }

    private static boolean AFKeystoreWrapper(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    public static void afDebugLog(String str) {
        if (AFKeystoreWrapper(LogLevel.DEBUG)) {
            Log.d("AppsFlyer_6.10.2", values(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf("D", values(str, true));
    }

    public static void afErrorLog(String str, Throwable th, boolean z7, boolean z8, boolean z9) {
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(th.getClass().getSimpleName());
            sb.append(" at ");
            sb.append(th.getStackTrace()[0].toString());
            str = sb.toString();
        }
        if (AFKeystoreWrapper(LogLevel.ERROR)) {
            String values = values(str, false);
            if (z8) {
                Log.e("AppsFlyer_6.10.2", values, th);
            } else if (z7) {
                Log.d("AppsFlyer_6.10.2", values);
            }
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().values(th);
        Application application = AFb1cSDK.AFKeystoreWrapper;
        if (application != null) {
            SharedPreferences.Editor edit = AFb1xSDK.AFKeystoreWrapper(application).edit();
            Application application2 = AFb1cSDK.AFKeystoreWrapper;
            edit.putLong("exception_number", (application2 == null ? -1L : AFb1xSDK.AFKeystoreWrapper(application2).getLong("exception_number", 0L)) + 1).apply();
        }
        if (z9) {
            AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onConversionDataSuccess().valueOf(th, str);
        }
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th) {
        afErrorLogForExcManagerOnly(str, th, false);
    }

    public static void afInfoLog(String str, boolean z7) {
        if (AFKeystoreWrapper(LogLevel.INFO)) {
            Log.i("AppsFlyer_6.10.2", values(str, false));
        }
        if (z7) {
            AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf("I", values(str, true));
        }
    }

    public static void afRDLog(String str) {
        if (AFKeystoreWrapper(LogLevel.VERBOSE)) {
            Log.v("AppsFlyer_6.10.2", values(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf("V", values(str, true));
    }

    public static void afWarnLog(String str) {
        AFInAppEventParameterName(str);
    }

    @NonNull
    private static String values(String str, boolean z7) {
        if (str == null) {
            str = "null";
        }
        if (z7 || LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            StringBuilder sb = new StringBuilder("(");
            sb.append(System.currentTimeMillis() - valueOf);
            sb.append(") [");
            sb.append(Thread.currentThread().getName());
            sb.append("] ");
            sb.append(str);
            return sb.toString();
        }
        return str;
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th, boolean z7) {
        afErrorLog(str, th, false, false, !z7);
    }

    private static boolean AFKeystoreWrapper() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void values(String str) {
        if (!AFKeystoreWrapper()) {
            Log.d("AppsFlyer_6.10.2", values(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf("F", str);
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void afErrorLog(String str, Throwable th) {
        afErrorLog(str, th, true, false, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z7) {
        afErrorLog(str, th, true, z7, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z7, boolean z8) {
        afErrorLog(str, th, true, z7, z8);
    }

    @Deprecated
    public static void afErrorLog(Throwable th) {
        afErrorLogForExcManagerOnly("Unknown", th);
    }
}
