package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public final class AFd1bSDK extends AFd1iSDK<String> {
    private final AFe1aSDK afRDLog;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AFd1bSDK(@androidx.annotation.NonNull com.appsflyer.internal.AFe1aSDK r8, @androidx.annotation.NonNull com.appsflyer.internal.AFc1vSDK r9) {
        /*
            r7 = this;
            com.appsflyer.internal.AFd1rSDK r0 = r8.getLevel
            if (r0 == 0) goto L5
            goto L7
        L5:
            com.appsflyer.internal.AFd1rSDK r0 = com.appsflyer.internal.AFd1rSDK.CACHED_EVENT
        L7:
            r2 = r0
            r0 = 1
            com.appsflyer.internal.AFd1rSDK[] r3 = new com.appsflyer.internal.AFd1rSDK[r0]
            r0 = 0
            com.appsflyer.internal.AFd1rSDK r1 = com.appsflyer.internal.AFd1rSDK.RC_CDN
            r3[r0] = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r8.afRDLog
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            java.lang.String r1 = valueOf(r8)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r6 = r8.afRDLog
            r1 = r7
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.afRDLog = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1bSDK.<init>(com.appsflyer.internal.AFe1aSDK, com.appsflyer.internal.AFc1vSDK):void");
    }

    private static String valueOf(AFe1aSDK aFe1aSDK) {
        try {
            return new URL(aFe1aSDK.afErrorLog).getHost();
        } catch (MalformedURLException unused) {
            return "";
        }
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AFc1jSDK<String> AFInAppEventType(String str) {
        String encodeToString = Base64.encodeToString(this.afRDLog.values(), 2);
        AFLogger.afInfoLog("cached data: ".concat(String.valueOf(encodeToString)));
        ((AFd1iSDK) this).afInfoLog.AFInAppEventParameterName(this.afRDLog.afErrorLog, encodeToString);
        return ((AFd1iSDK) this).AFLogger.AFInAppEventType(this.afRDLog);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return this.afRDLog.values;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    protected final boolean afRDLog() {
        return false;
    }
}
