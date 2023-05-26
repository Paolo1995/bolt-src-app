package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFc1oSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AFd1kSDK extends AFd1iSDK<String> {
    private final AFc1ySDK AFLogger$LogLevel;
    private final PurchaseHandler.PurchaseValidationCallback afErrorLogForExcManagerOnly;
    private final AFc1zSDK afRDLog;
    @NonNull
    private final Map<String, Object> afWarnLog;

    public AFd1kSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @NonNull AFc1vSDK aFc1vSDK, String str, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        super(aFd1rSDK, aFd1rSDKArr, aFc1vSDK, str);
        String str2;
        String str3;
        AFc1zSDK values = aFc1vSDK.values();
        this.afRDLog = values;
        AFc1ySDK afInfoLog = aFc1vSDK.afInfoLog();
        this.AFLogger$LogLevel = afInfoLog;
        HashMap hashMap = new HashMap(new HashMap(map));
        hashMap.put("app_id", values.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        String values2 = AFc1zSDK.values();
        if (values2 != null) {
            hashMap.put("cuid", values2);
        }
        Context context = values.AFKeystoreWrapper.AFKeystoreWrapper;
        hashMap.put("app_version_name", AFa1cSDK.values(context, context.getPackageName()));
        HashMap hashMap2 = new HashMap();
        AFc1oSDK.AFa1xSDK values3 = AFa1bSDK.values(values.AFKeystoreWrapper.AFKeystoreWrapper, new HashMap());
        if (values3 != null) {
            str2 = values3.AFInAppEventParameterName;
        } else {
            str2 = null;
        }
        if (!AFb1mSDK.valueOf(str2)) {
            hashMap2.put("advertising_id", str2);
        }
        AFc1oSDK.AFa1xSDK values4 = AFa1bSDK.values(values.AFKeystoreWrapper.AFKeystoreWrapper.getContentResolver());
        if (values4 != null) {
            str3 = values4.AFInAppEventParameterName;
        } else {
            str3 = null;
        }
        if (!AFb1mSDK.valueOf(str3)) {
            hashMap2.put("oaid", str3);
        }
        AFc1oSDK.AFa1xSDK values5 = AFa1bSDK.values(values.AFKeystoreWrapper.AFKeystoreWrapper.getContentResolver());
        String str4 = values5 != null ? values5.AFInAppEventParameterName : null;
        if (!AFb1mSDK.valueOf(str4)) {
            hashMap2.put("amazon_aid", str4);
        }
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            String values6 = ((AFd1iSDK) this).afDebugLog.values(afInfoLog);
            if (!AFb1mSDK.valueOf(values6)) {
                hashMap2.put("imei", values6);
            }
        }
        hashMap2.put("appsflyer_id", AFb1wSDK.AFKeystoreWrapper(new WeakReference(values.AFKeystoreWrapper.AFKeystoreWrapper)));
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        hashMap2.put("os_version", sb.toString());
        hashMap2.put("sdk_version", AFb1xSDK.AFKeystoreWrapper);
        hashMap.put("device_data", hashMap2);
        this.afWarnLog = hashMap;
        this.afErrorLogForExcManagerOnly = purchaseValidationCallback;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final boolean afRDLog() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public final Map<String, Object> afWarnLog() {
        return this.afWarnLog;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final void values() {
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback;
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback2;
        super.values();
        Throwable afInfoLog = afInfoLog();
        if (afInfoLog != null && (purchaseValidationCallback2 = this.afErrorLogForExcManagerOnly) != null) {
            purchaseValidationCallback2.onFailure(afInfoLog);
        }
        ResponseNetwork<String> responseNetwork = this.afErrorLog;
        if (responseNetwork != null && (purchaseValidationCallback = this.afErrorLogForExcManagerOnly) != null) {
            purchaseValidationCallback.onResponse(responseNetwork);
        }
    }
}
