package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFd1hSDK extends AFd1kSDK {
    private final AFc1zSDK afRDLog;

    public AFd1hSDK(@NonNull Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, @NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.PURCHASE_VALIDATE, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, null, map, purchaseValidationCallback);
        this.afRDLog = aFc1vSDK.values();
        this.AFKeystoreWrapper.add(AFd1rSDK.CONVERSION);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("https://%sviap.%s/api/v1/android/validate_purchase?app_id=", AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
        sb.append(this.afRDLog.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        String obj = sb.toString();
        String jSONObject = new JSONObject(afWarnLog()).toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this);
        sb2.append(": preparing data: ");
        sb2.append(jSONObject);
        AFc1rSDK.AFInAppEventParameterName(sb2.toString());
        ((AFd1iSDK) this).afInfoLog.AFInAppEventParameterName(obj, jSONObject);
        return ((AFd1iSDK) this).AFLogger.AFInAppEventParameterName(afWarnLog(), str);
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final boolean AFKeystoreWrapper() {
        ResponseNetwork responseNetwork = this.afErrorLog;
        if (responseNetwork != null && responseNetwork.getStatusCode() == 503) {
            return true;
        }
        return super.AFKeystoreWrapper();
    }
}
