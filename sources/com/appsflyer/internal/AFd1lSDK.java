package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;

/* loaded from: classes.dex */
public final class AFd1lSDK extends AFd1iSDK<String> {
    @NonNull
    private final String afRDLog;
    private final AFe1oSDK afWarnLog;

    public AFd1lSDK(@NonNull AFc1vSDK aFc1vSDK, @NonNull String str, AFe1oSDK aFe1oSDK) {
        super(AFd1rSDK.IMPRESSIONS, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, str);
        this.afRDLog = str;
        this.afWarnLog = aFe1oSDK;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        return ((AFd1iSDK) this).AFLogger.values(this.afRDLog);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final boolean afRDLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final void values() {
        super.values();
        AFd1zSDK<Result> aFd1zSDK = this.afErrorLog;
        if (aFd1zSDK != 0) {
            int statusCode = aFd1zSDK.getStatusCode();
            if (statusCode != 200) {
                if (statusCode != 301 && statusCode != 302) {
                    StringBuilder sb = new StringBuilder("call to ");
                    sb.append(this.afRDLog);
                    sb.append(" failed: ");
                    sb.append(statusCode);
                    AFLogger.afInfoLog(sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder("Cross promotion redirection success: ");
                sb2.append(this.afRDLog);
                AFLogger.afInfoLog(sb2.toString(), false);
                String values = aFd1zSDK.values("Location");
                AFe1oSDK aFe1oSDK = this.afWarnLog;
                if (aFe1oSDK != null && values != null) {
                    aFe1oSDK.AFKeystoreWrapper = values;
                    Context context = aFe1oSDK.valueOf.get();
                    if (context != null) {
                        try {
                            if (aFe1oSDK.AFKeystoreWrapper != null) {
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aFe1oSDK.AFKeystoreWrapper)).setFlags(268435456));
                                return;
                            }
                            return;
                        } catch (Exception e8) {
                            AFLogger.afErrorLog("Failed to open cross promotion url, does OS have browser installed?".concat(String.valueOf(e8)), e8);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder("Cross promotion impressions success: ");
            sb3.append(this.afRDLog);
            AFLogger.afInfoLog(sb3.toString(), false);
        }
    }
}
