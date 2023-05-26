package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFa1ySDK;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AFe1zSDK extends AFd1iSDK<String> {
    private static final AFd1rSDK[] getLevel = {AFd1rSDK.DLSDK, AFd1rSDK.ONELINK, AFd1rSDK.MONITORSDK, AFd1rSDK.REGISTER};
    @NonNull
    private final AFc1zSDK AFLogger$LogLevel;
    private final AFd1wSDK AFVersionDeclaration;
    private final AFb1rSDK afErrorLogForExcManagerOnly;
    public final AFa1sSDK afRDLog;
    protected final AFc1ySDK afWarnLog;

    public AFe1zSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1vSDK aFc1vSDK) {
        this(aFa1sSDK, aFc1vSDK, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e5  */
    @Override // com.appsflyer.internal.AFd1iSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.appsflyer.internal.AFc1jSDK<java.lang.String> AFInAppEventType(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1zSDK.AFInAppEventType(java.lang.String):com.appsflyer.internal.AFc1jSDK");
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return this.afRDLog.values;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected boolean afRDLog() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void values(AFa1sSDK aFa1sSDK) {
        boolean z7;
        AFd1vSDK aFd1vSDK;
        boolean y7;
        if (aFa1sSDK.AFLogger()) {
            aFa1sSDK.AFKeystoreWrapper(new AFa1ySDK.AFa1xSDK(aFa1sSDK.AFKeystoreWrapper(), ((AFd1iSDK) this).afDebugLog.valueOf.AFKeystoreWrapper));
        }
        if (aFa1sSDK.afDebugLog()) {
            aFa1sSDK.AFKeystoreWrapper(((AFd1iSDK) this).afDebugLog.valueOf());
        }
        Set<AFd1rSDK> set = this.values;
        boolean z8 = true;
        if (!set.contains(AFd1rSDK.LAUNCH) && !set.contains(AFd1rSDK.CONVERSION)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (afErrorLog() && z7) {
            aFa1sSDK.AFInAppEventParameterName(this.afWarnLog.AFInAppEventType("appsFlyerCount", 0));
        }
        try {
            if (aFa1sSDK.AFKeystoreWrapper().containsKey("appsflyerKey") && aFa1sSDK.AFLogger()) {
                new AFb1ySDK();
                aFa1sSDK.AFKeystoreWrapper("af_v", AFb1ySDK.values(aFa1sSDK.AFKeystoreWrapper()));
                new AFb1ySDK();
                aFa1sSDK.AFKeystoreWrapper("af_v2", AFb1ySDK.AFInAppEventParameterName(aFa1sSDK.AFKeystoreWrapper()));
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("QUEUE: failed to update the event, is missing DevKey? Error: ".concat(String.valueOf(th)), th);
        }
        if (aFa1sSDK.afRDLog()) {
            Map<String, Object> AFInAppEventType = AFInAppEventType(aFa1sSDK);
            AFd1wSDK aFd1wSDK = this.AFVersionDeclaration;
            String values = aFd1wSDK.values();
            String AFInAppEventType2 = aFd1wSDK.AFInAppEventType();
            if (AFd1wSDK.AFInAppEventParameterName()) {
                aFd1vSDK = AFd1vSDK.DEFAULT;
            } else {
                aFd1vSDK = AFd1vSDK.API;
            }
            AFd1xSDK aFd1xSDK = new AFd1xSDK(values, AFInAppEventType2, aFd1vSDK);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", aFd1xSDK.valueOf);
            AFd1vSDK aFd1vSDK2 = aFd1xSDK.AFInAppEventParameterName;
            if (aFd1vSDK2 != AFd1vSDK.DEFAULT) {
                jSONObject.put("method", aFd1vSDK2.AFKeystoreWrapper);
            }
            String str = aFd1xSDK.values;
            if (str != null) {
                y7 = StringsKt__StringsJVMKt.y(str);
                if (!y7) {
                    z8 = false;
                }
            }
            if (!z8) {
                jSONObject.put("prefix", aFd1xSDK.values);
            }
            AFInAppEventType.put("host", jSONObject);
        }
        if (this.AFLogger$LogLevel.valueOf("AF_PREINSTALL_DISABLED")) {
            AFInAppEventType(aFa1sSDK).put("preinstall_disabled", Boolean.TRUE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFe1zSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1vSDK aFc1vSDK, String str) {
        super(aFa1sSDK.AFInAppEventType(), new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, str);
        this.afRDLog = aFa1sSDK;
        this.AFVersionDeclaration = aFc1vSDK.init();
        this.afWarnLog = aFc1vSDK.afInfoLog();
        this.afErrorLogForExcManagerOnly = aFc1vSDK.afRDLog();
        this.AFLogger$LogLevel = aFc1vSDK.values();
        for (AFd1rSDK aFd1rSDK : getLevel) {
            if (this.AFInAppEventType == aFd1rSDK) {
                return;
            }
        }
        int i8 = this.afRDLog.afInfoLog;
        AFd1rSDK aFd1rSDK2 = this.AFInAppEventType;
        if (i8 <= 0) {
            AFd1rSDK aFd1rSDK3 = AFd1rSDK.CONVERSION;
            if (aFd1rSDK2 != aFd1rSDK3) {
                this.values.add(aFd1rSDK3);
                return;
            }
            return;
        }
        this.AFKeystoreWrapper.add(AFd1rSDK.CONVERSION);
    }

    @NonNull
    private static Map<String, Object> AFInAppEventType(AFa1sSDK aFa1sSDK) {
        Map<String, Object> map = (Map) aFa1sSDK.AFKeystoreWrapper().get("meta");
        if (map == null) {
            HashMap hashMap = new HashMap();
            aFa1sSDK.AFKeystoreWrapper().put("meta", hashMap);
            return hashMap;
        }
        return map;
    }
}
