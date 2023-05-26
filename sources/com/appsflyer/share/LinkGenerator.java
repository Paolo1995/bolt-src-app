package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.internal.AFb1rSDK;
import com.appsflyer.internal.AFb1xSDK;
import com.appsflyer.internal.AFc1vSDK;
import com.appsflyer.internal.AFd1mSDK;
import com.appsflyer.internal.AFd1sSDK;
import com.appsflyer.internal.AFf1bSDK;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class LinkGenerator {
    String AFInAppEventParameterName;
    private final String AFInAppEventType;
    private String AFKeystoreWrapper;
    private String AFLogger;
    private final Map<String, String> AFLogger$LogLevel = new HashMap();
    private String AFVersionDeclaration;
    private String afDebugLog;
    private String afErrorLog;
    private String afInfoLog;
    private String afRDLog;
    private String afWarnLog;
    String valueOf;
    private String values;

    /* loaded from: classes.dex */
    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public LinkGenerator(String str) {
        this.AFInAppEventType = str;
    }

    private Map<String, String> AFInAppEventType() {
        HashMap hashMap = new HashMap();
        hashMap.put("pid", this.AFInAppEventType);
        String str = this.afErrorLog;
        if (str != null) {
            hashMap.put("af_referrer_uid", str);
        }
        String str2 = this.AFKeystoreWrapper;
        if (str2 != null) {
            hashMap.put(AFInAppEventParameterName.AF_CHANNEL, str2);
        }
        String str3 = this.AFLogger;
        if (str3 != null) {
            hashMap.put("af_referrer_customer_id", str3);
        }
        String str4 = this.values;
        if (str4 != null) {
            hashMap.put("c", str4);
        }
        String str5 = this.afInfoLog;
        if (str5 != null) {
            hashMap.put("af_referrer_name", str5);
        }
        String str6 = this.afDebugLog;
        if (str6 != null) {
            hashMap.put("af_referrer_image_url", str6);
        }
        if (this.afWarnLog != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.afWarnLog);
            String str7 = this.afRDLog;
            if (str7 != null) {
                String str8 = "";
                this.afRDLog = str7.replaceFirst("^[/]", "");
                if (!this.afWarnLog.endsWith("/")) {
                    str8 = "/";
                }
                sb.append(str8);
                sb.append(this.afRDLog);
            }
            hashMap.put("af_dp", sb.toString());
        }
        for (Map.Entry<String, String> entry : this.AFLogger$LogLevel.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return AFb1rSDK.AFInAppEventParameterName(hashMap);
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.AFLogger$LogLevel.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.AFLogger$LogLevel.putAll(map);
        }
        return this;
    }

    public String generateLink() {
        StringBuilder sb = new StringBuilder();
        String str = this.AFInAppEventParameterName;
        if (str != null && str.startsWith("http")) {
            sb.append(this.AFInAppEventParameterName);
        } else {
            sb.append(String.format(AFf1bSDK.valueOf, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
        }
        if (this.valueOf != null) {
            sb.append('/');
            sb.append(this.valueOf);
        }
        Map<String, String> AFInAppEventType = AFInAppEventType();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : AFInAppEventType.entrySet()) {
            if (sb2.length() == 0) {
                sb2.append('?');
            } else {
                sb2.append('&');
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    public String getBrandDomain() {
        return this.AFVersionDeclaration;
    }

    public String getCampaign() {
        return this.values;
    }

    public String getChannel() {
        return this.AFKeystoreWrapper;
    }

    public String getMediaSource() {
        return this.AFInAppEventType;
    }

    public Map<String, String> getUserParams() {
        return new HashMap(this.AFLogger$LogLevel);
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.afWarnLog = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str != null && str.length() > 0) {
            this.AFInAppEventParameterName = String.format("https://%s/%s", (str2 == null || str2.length() < 5) ? "go.onelink.me" : "go.onelink.me", str);
        } else {
            this.AFInAppEventParameterName = String.format("https://%s/%s", String.format("%sapp.%s", AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()), str3);
        }
        return this;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.AFVersionDeclaration = str;
        return this;
    }

    public LinkGenerator setCampaign(String str) {
        this.values = str;
        return this;
    }

    public LinkGenerator setChannel(String str) {
        this.AFKeystoreWrapper = str;
        return this;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.afRDLog = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.AFLogger = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.afDebugLog = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.afInfoLog = str;
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.afErrorLog = str;
        return this;
    }

    public void generateLink(Context context, ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        String str = this.AFVersionDeclaration;
        Map<String, String> AFInAppEventType = AFInAppEventType();
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        AFb1xSDK.AFInAppEventType().values(context);
        AFc1vSDK AFKeystoreWrapper = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        AFd1mSDK aFd1mSDK = new AFd1mSDK(AFKeystoreWrapper, UUID.randomUUID(), string, AFInAppEventType, str, responseListener);
        AFd1sSDK afDebugLog = AFKeystoreWrapper.afDebugLog();
        afDebugLog.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFd1mSDK));
    }

    @Deprecated
    public void generateLink(Context context, final CreateOneLinkHttpTask.ResponseListener responseListener) {
        generateLink(context, new ResponseListener() { // from class: com.appsflyer.share.LinkGenerator.5
            @Override // com.appsflyer.share.LinkGenerator.ResponseListener
            public final void onResponse(String str) {
                responseListener.onResponse(str);
            }

            @Override // com.appsflyer.share.LinkGenerator.ResponseListener
            public final void onResponseError(String str) {
                responseListener.onResponseError(str);
            }
        });
    }
}
