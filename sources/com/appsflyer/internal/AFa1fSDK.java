package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.internal.AFd1sSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFa1fSDK implements Runnable {
    private static String AFKeystoreWrapper = null;
    private static String valueOf = "https://%ssdk-services.%s/validate-android-signature";
    private WeakReference<Context> AFInAppEventParameterName;
    private final Intent AFInAppEventType;
    private String AFLogger;
    private Map<String, String> AFVersionDeclaration;
    private String afDebugLog;
    private String afErrorLog;
    private String afInfoLog;
    private String afRDLog;
    private String values;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(AFb1xSDK.AFKeystoreWrapper);
        sb.append("/androidevent?buildnumber=6.10.2&app_id=");
        AFKeystoreWrapper = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AFa1fSDK(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, Intent intent) {
        this.AFInAppEventParameterName = new WeakReference<>(context);
        this.values = str;
        this.afDebugLog = str2;
        this.afInfoLog = str4;
        this.afErrorLog = str5;
        this.afRDLog = str6;
        this.AFVersionDeclaration = map;
        this.AFLogger = str3;
        this.AFInAppEventType = intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void AFKeystoreWrapper(boolean z7, String str, String str2, String str3, String str4) {
        if (AFb1xSDK.values != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" ");
            sb.append(str3);
            AFLogger.afDebugLog(sb.toString());
            if (z7) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AFb1xSDK.values.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFb1xSDK.values;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    private static AFe1zSDK values(Context context, @NonNull AFf1vSDK aFf1vSDK) {
        AFb1xSDK.AFInAppEventType().values(context);
        AFc1vSDK AFKeystoreWrapper2 = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        aFf1vSDK.AFInAppEventParameterName(AFKeystoreWrapper2.values().valueOf.AFInAppEventType("appsFlyerCount", 0));
        AFe1zSDK aFe1zSDK = new AFe1zSDK(aFf1vSDK, AFKeystoreWrapper2);
        AFd1sSDK afDebugLog = AFKeystoreWrapper2.afDebugLog();
        afDebugLog.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFe1zSDK));
        return aFe1zSDK;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.values;
        if (str == null || str.length() == 0 || AppsFlyerLib.getInstance().isStopped()) {
            return;
        }
        try {
            Context context = this.AFInAppEventParameterName.get();
            if (context == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("public-key", this.afDebugLog);
            hashMap.put("sig-data", this.afInfoLog);
            hashMap.put("signature", this.AFLogger);
            Object hashMap2 = new HashMap(hashMap);
            Object obj = this.AFVersionDeclaration;
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(AFKeystoreWrapper, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
            sb.append(context.getPackageName());
            String obj2 = sb.toString();
            String string = AFb1xSDK.AFKeystoreWrapper(context).getString("referrer", "");
            AFa1sSDK aFf1rSDK = new AFf1rSDK(context);
            aFf1rSDK.AFLogger = string;
            AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
            Map<String, Object> AFInAppEventType2 = AFInAppEventType.AFInAppEventType(aFf1rSDK);
            AFInAppEventType2.put("price", this.afErrorLog);
            AFInAppEventType2.put("currency", this.afRDLog);
            AFInAppEventType2.put("receipt_data", hashMap2);
            if (obj != null) {
                AFInAppEventType2.put("extra_prms", obj);
            }
            AFInAppEventType2.putAll(AFInAppEventType.AFKeystoreWrapper().getLevel().valueOf());
            values(context, (AFf1rSDK) aFf1rSDK.AFKeystoreWrapper(AFInAppEventType2).AFKeystoreWrapper(obj2));
            hashMap.put("dev_key", this.values);
            hashMap.put("app_id", context.getPackageName());
            hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
            String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
            if (string2 != null) {
                hashMap.put("advertiserId", string2);
            }
            AFf1wSDK aFf1wSDK = (AFf1wSDK) new AFf1wSDK().AFKeystoreWrapper(hashMap).AFKeystoreWrapper(String.format(valueOf, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
            final AFe1zSDK values = values(context, aFf1wSDK);
            aFf1wSDK.values = new AppsFlyerRequestListener() { // from class: com.appsflyer.internal.AFa1fSDK.4
                @Override // com.appsflyer.attribution.AppsFlyerRequestListener
                public final void onError(int i8, @NonNull String str2) {
                    ResponseNetwork responseNetwork;
                    if (i8 == RequestError.RESPONSE_CODE_FAILURE && (responseNetwork = values.afErrorLog) != null) {
                        str2 = responseNetwork.toString();
                    }
                    AFa1fSDK.AFKeystoreWrapper(false, AFa1fSDK.this.afInfoLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.afRDLog, str2);
                }

                @Override // com.appsflyer.attribution.AppsFlyerRequestListener
                public final void onSuccess() {
                    try {
                        JSONObject jSONObject = new JSONObject((String) values.afErrorLog.getBody());
                        AFLogger.afInfoLog("Validate response ok: ".concat(String.valueOf(jSONObject)));
                        AFa1fSDK.AFKeystoreWrapper(jSONObject.optBoolean("result"), AFa1fSDK.this.afInfoLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.afRDLog, jSONObject.toString());
                    } catch (Exception e8) {
                        AFLogger.afErrorLog("Failed Validate request: ".concat(String.valueOf(e8)), e8);
                        AFa1fSDK.AFKeystoreWrapper(false, AFa1fSDK.this.afInfoLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.afRDLog, e8.getMessage());
                    }
                }
            };
        } catch (Throwable th) {
            if (AFb1xSDK.values != null) {
                AFLogger.afErrorLog("Failed Validate request + ex", th);
                AFKeystoreWrapper(false, this.afInfoLog, this.afErrorLog, this.afRDLog, th.getMessage());
            }
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }
}
