package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFe1mSDK extends AFd1iSDK<Map<String, Object>> {
    private static final List<String> afRDLog = Arrays.asList("googleplay", "playstore", "googleplaystore");
    private Map<String, Object> AFLogger$LogLevel;
    private final AFc1ySDK AFVersionDeclaration;
    private String AppsFlyer2dXConversionCallback;
    private final AFc1kSDK afErrorLogForExcManagerOnly;
    private final AFe1jSDK afWarnLog;
    private final AFc1zSDK getLevel;

    public AFe1mSDK(@NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.GCDSDK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, "GCD-FETCH");
        this.afErrorLogForExcManagerOnly = aFc1vSDK.AFInAppEventType();
        this.AFVersionDeclaration = aFc1vSDK.afInfoLog();
        this.afWarnLog = aFc1vSDK.AFLogger();
        this.getLevel = aFc1vSDK.values();
        this.AFKeystoreWrapper.add(AFd1rSDK.CONVERSION);
        this.AFKeystoreWrapper.add(AFd1rSDK.LAUNCH);
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    public final AFc1jSDK<Map<String, Object>> AFInAppEventType(@NonNull String str) {
        String str2;
        String AFInAppEventType = AFb1xSDK.AFInAppEventType(this.AFVersionDeclaration, this.getLevel.AFInAppEventType());
        if (AFInAppEventType != null && !AFInAppEventType.trim().isEmpty()) {
            if (!afRDLog.contains(AFInAppEventType.toLowerCase(Locale.getDefault()))) {
                str2 = "-".concat(AFInAppEventType);
                AFc1jSDK<Map<String, Object>> AFInAppEventType2 = this.afErrorLogForExcManagerOnly.AFInAppEventType(str2, str);
                StringBuilder sb = new StringBuilder("[GCD-B01] URL: ");
                sb.append(AFInAppEventType2.AFKeystoreWrapper.valueOf());
                AFc1rSDK.AFInAppEventParameterName(sb.toString());
                return AFInAppEventType2;
            }
            AFLogger.afWarnLog(String.format("[GCD] AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", AFInAppEventType));
        }
        str2 = "";
        AFc1jSDK<Map<String, Object>> AFInAppEventType22 = this.afErrorLogForExcManagerOnly.AFInAppEventType(str2, str);
        StringBuilder sb2 = new StringBuilder("[GCD-B01] URL: ");
        sb2.append(AFInAppEventType22.AFKeystoreWrapper.valueOf());
        AFc1rSDK.AFInAppEventParameterName(sb2.toString());
        return AFInAppEventType22;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final boolean AFKeystoreWrapper() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1iSDK
    public final boolean afRDLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final void values() {
        super.values();
        Map<String, Object> map = this.AFLogger$LogLevel;
        String str = this.AppsFlyer2dXConversionCallback;
        if (map != null) {
            AFe1oSDK.AFInAppEventParameterName(map);
        } else if (str != null && !str.isEmpty()) {
            AFe1oSDK.valueOf(str);
        } else {
            AFe1oSDK.valueOf("Unknown error");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d A[Catch: all -> 0x0105, Exception -> 0x0107, AFd1qSDK -> 0x0136, TryCatch #3 {AFd1qSDK -> 0x0136, Exception -> 0x0107, blocks: (B:12:0x0025, B:15:0x002f, B:22:0x003f, B:30:0x0052, B:33:0x0069, B:35:0x007d, B:37:0x0097, B:39:0x009d, B:40:0x00a8, B:42:0x00ae, B:44:0x00b4, B:45:0x00ca, B:46:0x00db, B:48:0x00fa, B:49:0x00ff), top: B:68:0x0025, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae A[Catch: all -> 0x0105, Exception -> 0x0107, AFd1qSDK -> 0x0136, TryCatch #3 {AFd1qSDK -> 0x0136, Exception -> 0x0107, blocks: (B:12:0x0025, B:15:0x002f, B:22:0x003f, B:30:0x0052, B:33:0x0069, B:35:0x007d, B:37:0x0097, B:39:0x009d, B:40:0x00a8, B:42:0x00ae, B:44:0x00b4, B:45:0x00ca, B:46:0x00db, B:48:0x00fa, B:49:0x00ff), top: B:68:0x0025, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fa A[Catch: all -> 0x0105, Exception -> 0x0107, AFd1qSDK -> 0x0136, TryCatch #3 {AFd1qSDK -> 0x0136, Exception -> 0x0107, blocks: (B:12:0x0025, B:15:0x002f, B:22:0x003f, B:30:0x0052, B:33:0x0069, B:35:0x007d, B:37:0x0097, B:39:0x009d, B:40:0x00a8, B:42:0x00ae, B:44:0x00b4, B:45:0x00ca, B:46:0x00db, B:48:0x00fa, B:49:0x00ff), top: B:68:0x0025, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0052 A[SYNTHETIC] */
    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.appsflyer.internal.AFd1tSDK AFInAppEventType() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1mSDK.AFInAppEventType():com.appsflyer.internal.AFd1tSDK");
    }
}
