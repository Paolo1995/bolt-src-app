package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.share.LinkGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public final class AFd1mSDK extends AFd1iSDK<String> {
    private final String AFLogger$LogLevel;
    private final Map<String, String> AFVersionDeclaration;
    private final UUID afErrorLogForExcManagerOnly;
    private final AFc1zSDK afRDLog;
    private final String afWarnLog;
    private final LinkGenerator.ResponseListener getLevel;

    public AFd1mSDK(@NonNull AFc1vSDK aFc1vSDK, @NonNull UUID uuid, @NonNull String str, @NonNull Map<String, String> map, String str2, LinkGenerator.ResponseListener responseListener) {
        super(AFd1rSDK.ONELINK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, uuid.toString());
        this.afRDLog = aFc1vSDK.values();
        this.afErrorLogForExcManagerOnly = uuid;
        this.AFLogger$LogLevel = str;
        this.AFVersionDeclaration = new HashMap(map);
        this.getLevel = responseListener;
        this.afWarnLog = str2;
    }

    private String afErrorLogForExcManagerOnly() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN);
        String packageName = this.afRDLog.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName();
        LinkGenerator addParameters = new LinkGenerator("af_app_invites").setBaseURL(this.AFLogger$LogLevel, string, packageName).addParameter("af_siteid", packageName).addParameters(this.AFVersionDeclaration);
        AFb1xSDK.AFInAppEventType();
        String values = AFb1xSDK.values();
        if (values != null) {
            addParameters.setReferrerCustomerId(values);
        }
        return addParameters.generateLink();
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        return ((AFd1iSDK) this).AFLogger.values(this.AFLogger$LogLevel, this.AFVersionDeclaration, this.afWarnLog, this.afErrorLogForExcManagerOnly, str);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final boolean afRDLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final boolean getLevel() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final long valueOf() {
        return 3000L;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final void values() {
        ResponseNetwork responseNetwork;
        super.values();
        LinkGenerator.ResponseListener responseListener = this.getLevel;
        if (responseListener != null) {
            if (this.valueOf == AFd1tSDK.SUCCESS && (responseNetwork = this.afErrorLog) != null) {
                responseListener.onResponse((String) responseNetwork.getBody());
                return;
            }
            Throwable afInfoLog = afInfoLog();
            if (afInfoLog instanceof ParsingException) {
                if (((ParsingException) afInfoLog).getRawResponse().isSuccessful()) {
                    responseListener.onResponseError("Can't parse one link data");
                    return;
                } else {
                    responseListener.onResponse(afErrorLogForExcManagerOnly());
                    return;
                }
            }
            responseListener.onResponse(afErrorLogForExcManagerOnly());
        }
    }
}
