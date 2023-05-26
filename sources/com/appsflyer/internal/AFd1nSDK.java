package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.PurchaseHandler;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFd1nSDK extends AFd1kSDK {
    public AFd1nSDK(@NonNull Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, @NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.ARS_VALIDATE, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, null, map, purchaseValidationCallback);
        this.AFKeystoreWrapper.add(AFd1rSDK.CONVERSION);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        return ((AFd1iSDK) this).AFLogger.AFKeystoreWrapper(afWarnLog(), str);
    }
}
