package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFf1kSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFd1aSDK extends AFe1zSDK {
    @NonNull
    private final AFf1jSDK AFLogger$LogLevel;
    @NonNull
    private final AFe1jSDK AFVersionDeclaration;
    @NonNull
    private final AppsFlyerProperties AppsFlyer2dXConversionCallback;
    public Map<String, Object> afErrorLogForExcManagerOnly;
    @NonNull
    private final AFc1ySDK getLevel;
    @NonNull
    private final AFb1rSDK init;

    /* renamed from: com.appsflyer.internal.AFd1aSDK$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] valueOf;

        static {
            int[] iArr = new int[AFf1kSDK.AFa1wSDK.values().length];
            valueOf = iArr;
            try {
                iArr[AFf1kSDK.AFa1wSDK.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                valueOf[AFf1kSDK.AFa1wSDK.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public AFd1aSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1vSDK aFc1vSDK) {
        super(aFa1sSDK, aFc1vSDK);
        this.AFLogger$LogLevel = aFc1vSDK.AFVersionDeclaration();
        this.getLevel = aFc1vSDK.afInfoLog();
        this.AFVersionDeclaration = aFc1vSDK.AFLogger();
        this.init = aFc1vSDK.afRDLog();
        this.AppsFlyer2dXConversionCallback = AppsFlyerProperties.getInstance();
        this.AFKeystoreWrapper.add(AFd1rSDK.RESOLVE_ESP);
        this.AFKeystoreWrapper.add(AFd1rSDK.DLSDK);
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final void values() {
        super.values();
        AFe1jSDK aFe1jSDK = this.AFVersionDeclaration;
        int i8 = ((AFe1zSDK) this).afRDLog.afInfoLog;
        long currentTimeMillis = System.currentTimeMillis();
        if (i8 == 1) {
            long j8 = aFe1jSDK.afDebugLog;
            if (j8 != 0) {
                aFe1jSDK.valueOf.put("net", Long.valueOf(currentTimeMillis - j8));
                aFe1jSDK.values.valueOf("first_launch", new JSONObject(aFe1jSDK.valueOf).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: launch start ts is missing");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.appsflyer.internal.AFe1zSDK
    public final void values(AFa1sSDK aFa1sSDK) {
        AFf1kSDK[] AFInAppEventParameterName;
        super.values(aFa1sSDK);
        int i8 = aFa1sSDK.afInfoLog;
        this.AFVersionDeclaration.AFInAppEventType(i8);
        Map map = (Map) aFa1sSDK.AFKeystoreWrapper().get("meta");
        if (map == null) {
            map = new HashMap();
            aFa1sSDK.AFKeystoreWrapper().put("meta", map);
        }
        AFb1cSDK AFInAppEventType = this.init.AFInAppEventType();
        if (AFInAppEventType != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cdn_token", AFInAppEventType.values);
            String str = AFInAppEventType.AFInAppEventType;
            if (str != null) {
                hashMap.put("c_ver", str);
            }
            long j8 = AFInAppEventType.AFInAppEventParameterName;
            if (j8 > 0) {
                hashMap.put("latency", Long.valueOf(j8));
            }
            long j9 = AFInAppEventType.valueOf;
            if (j9 > 0) {
                hashMap.put("delay", Long.valueOf(j9));
            }
            int i9 = AFInAppEventType.afRDLog;
            if (i9 > 0) {
                hashMap.put("res_code", Integer.valueOf(i9));
            }
            if (AFInAppEventType.afInfoLog != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(AFInAppEventType.afInfoLog.getClass().getSimpleName());
                sb.append(": ");
                sb.append(AFInAppEventType.afInfoLog.getMessage());
                hashMap.put("error", sb.toString());
            }
            AFf1tSDK aFf1tSDK = AFInAppEventType.AFLogger;
            if (aFf1tSDK != null) {
                hashMap.put("sig", aFf1tSDK.toString());
            }
            String str2 = AFInAppEventType.afDebugLog;
            if (str2 != null) {
                hashMap.put("cdn_cache_status", str2);
            }
            map.put("rc", hashMap);
        }
        if (i8 == 1) {
            if (this.AppsFlyer2dXConversionCallback.getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                aFa1sSDK.AFKeystoreWrapper().put("wait_cid", Boolean.toString(true));
            }
            HashMap hashMap2 = new HashMap(this.AFVersionDeclaration.AFInAppEventParameterName);
            this.AFVersionDeclaration.values.valueOf("ddl");
            if (!hashMap2.isEmpty()) {
                map.put("ddl", hashMap2);
            }
            HashMap hashMap3 = new HashMap(this.AFVersionDeclaration.valueOf);
            if (!hashMap3.isEmpty()) {
                map.put("first_launch", hashMap3);
            }
        } else if (i8 == 2) {
            HashMap hashMap4 = new HashMap(this.AFVersionDeclaration.valueOf);
            if (!hashMap4.isEmpty()) {
                map.put("first_launch", hashMap4);
            }
            this.AFVersionDeclaration.values.valueOf("first_launch");
        }
        if (map.isEmpty()) {
            aFa1sSDK.AFKeystoreWrapper().remove("meta");
        }
        if (i8 <= 2) {
            ArrayList arrayList = new ArrayList();
            for (AFf1kSDK aFf1kSDK : this.AFLogger$LogLevel.AFInAppEventParameterName()) {
                boolean z7 = aFf1kSDK instanceof AFf1pSDK;
                int i10 = AnonymousClass1.valueOf[aFf1kSDK.afRDLog.ordinal()];
                if (i10 == 1) {
                    if (z7) {
                        aFa1sSDK.AFKeystoreWrapper("rfr", ((AFf1pSDK) aFf1kSDK).AFKeystoreWrapper);
                        this.getLevel.AFInAppEventType(AppsFlyerProperties.NEW_REFERRER_SENT, true);
                    }
                    arrayList.add(aFf1kSDK.AFInAppEventType);
                } else if (i10 == 2 && i8 == 2 && !z7) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("source", aFf1kSDK.valueOf);
                    hashMap5.put("response", "TIMEOUT");
                    hashMap5.put("type", aFf1kSDK.AFLogger);
                    arrayList.add(hashMap5);
                }
            }
            if (!arrayList.isEmpty()) {
                aFa1sSDK.AFKeystoreWrapper("referrers", arrayList);
            }
            Object obj = this.afErrorLogForExcManagerOnly;
            if (obj != null) {
                aFa1sSDK.AFKeystoreWrapper("fb_ddl", obj);
            }
        }
    }
}
