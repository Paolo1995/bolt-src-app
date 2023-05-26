package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1xSDK;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    private static final AppsFlyerProperties AFInAppEventType = new AppsFlyerProperties();
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_NETWORK_DATA = "disableCollectNetworkData";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String HTTP_CACHE = "http_cache";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";
    public String valueOf;
    public boolean values;
    private final Map<String, Object> AFKeystoreWrapper = new HashMap();
    private boolean AFInAppEventParameterName = false;

    /* loaded from: classes.dex */
    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);
        
        private final int values;

        EmailsCryptType(int i8) {
            this.values = i8;
        }

        public final int getValue() {
            return this.values;
        }
    }

    private AppsFlyerProperties() {
    }

    private boolean AFInAppEventParameterName() {
        return this.AFInAppEventParameterName;
    }

    public static AppsFlyerProperties getInstance() {
        return AFInAppEventType;
    }

    public final boolean AFKeystoreWrapper() {
        return this.values;
    }

    public boolean getBoolean(String str, boolean z7) {
        String string = getString(str);
        if (string == null) {
            return z7;
        }
        return Boolean.parseBoolean(string);
    }

    public int getInt(String str, int i8) {
        String string = getString(str);
        if (string == null) {
            return i8;
        }
        return Integer.parseInt(string);
    }

    public long getLong(String str, long j8) {
        String string = getString(str);
        if (string == null) {
            return j8;
        }
        return Long.parseLong(string);
    }

    public synchronized Object getObject(String str) {
        return this.AFKeystoreWrapper.get(str);
    }

    public String getReferrer(Context context) {
        String str = this.valueOf;
        if (str != null) {
            return str;
        }
        if (getString("AF_REFERRER") != null) {
            return getString("AF_REFERRER");
        }
        if (context == null) {
            return null;
        }
        return AFb1xSDK.AFKeystoreWrapper(context).getString("referrer", null);
    }

    public synchronized String getString(String str) {
        return (String) this.AFKeystoreWrapper.get(str);
    }

    public boolean isEnableLog() {
        AFLogger.LogLevel logLevel = AFLogger.LogLevel.NONE;
        if (getInt("logLevel", logLevel.getLevel()) > logLevel.getLevel()) {
            return true;
        }
        return false;
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    public synchronized void loadProperties(Context context) {
        if (AFInAppEventParameterName()) {
            return;
        }
        SharedPreferences AFKeystoreWrapper = AFb1xSDK.AFKeystoreWrapper(context);
        String string = AFKeystoreWrapper.getString("savedProperties", null);
        if (string != null) {
            AFLogger.afDebugLog("Loading properties..");
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (this.AFKeystoreWrapper.get(next) == null) {
                        this.AFKeystoreWrapper.put(next, jSONObject.getString(next));
                    }
                }
                String[] strArr = {"AppsFlyerKey", "custom_host", "custom_host_prefix"};
                for (int i8 = 0; i8 < 3; i8++) {
                    this.AFKeystoreWrapper.remove(strArr[i8]);
                }
                saveProperties(AFKeystoreWrapper);
                this.AFInAppEventParameterName = true;
            } catch (JSONException e8) {
                AFLogger.afErrorLog("Failed loading properties", e8);
            }
            StringBuilder sb = new StringBuilder("Done loading properties: ");
            sb.append(this.AFInAppEventParameterName);
            AFLogger.afDebugLog(sb.toString());
        }
    }

    public synchronized void remove(String str) {
        this.AFKeystoreWrapper.remove(str);
    }

    public synchronized void saveProperties(SharedPreferences sharedPreferences) {
        this.AFKeystoreWrapper.remove("AppsFlyerKey");
        sharedPreferences.edit().putString("savedProperties", new JSONObject(this.AFKeystoreWrapper).toString()).apply();
    }

    public synchronized void set(String str, String str2) {
        this.AFKeystoreWrapper.put(str, str2);
    }

    public synchronized void setCustomData(String str) {
        this.AFKeystoreWrapper.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    public synchronized void setUserEmails(String str) {
        this.AFKeystoreWrapper.put(USER_EMAILS, str);
    }

    public synchronized void set(String str, String[] strArr) {
        this.AFKeystoreWrapper.put(str, strArr);
    }

    public synchronized void set(String str, int i8) {
        this.AFKeystoreWrapper.put(str, Integer.toString(i8));
    }

    public synchronized void set(String str, long j8) {
        this.AFKeystoreWrapper.put(str, Long.toString(j8));
    }

    public synchronized void set(String str, boolean z7) {
        this.AFKeystoreWrapper.put(str, Boolean.toString(z7));
    }
}
