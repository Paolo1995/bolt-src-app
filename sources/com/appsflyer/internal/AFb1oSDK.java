package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.internal.AFc1oSDK;
import com.appsflyer.internal.AFf1kSDK;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import j$.util.DesugarTimeZone;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class AFb1oSDK extends AFe1bSDK {
    private static String afErrorLogForExcManagerOnly = "https://%sdlsdk.%s/v1.0/android/";
    public static long afWarnLog;
    private final CountDownLatch AFLogger$LogLevel;
    private final AFe1nSDK AppsFlyer2dXConversionCallback;
    private final List<AFf1kSDK> getLevel;
    private final AFc1zSDK init;
    private final ExecutorService onAppOpenAttributionNative;
    private int onAttributionFailureNative;
    private boolean onConversionDataSuccess;
    private final AFb1sSDK onDeepLinkingNative;
    private final AFe1jSDK onInstallConversionDataLoadedNative;
    private final AFf1jSDK onInstallConversionFailureNative;
    private int onResponseErrorNative;
    private int onResponseNative;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.appsflyer.internal.AFb1oSDK$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] AFKeystoreWrapper;

        static {
            int[] iArr = new int[AFf1kSDK.AFa1wSDK.values().length];
            AFKeystoreWrapper = iArr;
            try {
                iArr[AFf1kSDK.AFa1wSDK.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                AFKeystoreWrapper[AFf1kSDK.AFa1wSDK.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public AFb1oSDK(Context context, AFc1vSDK aFc1vSDK) {
        super(null, afErrorLogForExcManagerOnly, Boolean.FALSE, Boolean.TRUE, null, context);
        this.getLevel = new ArrayList();
        this.AFLogger$LogLevel = new CountDownLatch(1);
        this.onInstallConversionDataLoadedNative = aFc1vSDK.AFLogger();
        this.init = aFc1vSDK.values();
        this.AppsFlyer2dXConversionCallback = aFc1vSDK.getLevel();
        this.onInstallConversionFailureNative = aFc1vSDK.AFVersionDeclaration();
        this.onAppOpenAttributionNative = aFc1vSDK.AFKeystoreWrapper();
        this.onDeepLinkingNative = aFc1vSDK.afErrorLogForExcManagerOnly();
    }

    private static Map<String, String> AFInAppEventParameterName(AFf1kSDK aFf1kSDK) {
        if (aFf1kSDK.afRDLog == AFf1kSDK.AFa1wSDK.FINISHED) {
            HashMap hashMap = new HashMap();
            String str = (String) aFf1kSDK.AFInAppEventType.get("referrer");
            if (str != null) {
                hashMap.put("source", (String) aFf1kSDK.AFInAppEventType.get("source"));
                hashMap.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str);
                return hashMap;
            }
            return null;
        }
        return null;
    }

    private static boolean AFKeystoreWrapper(AFf1kSDK aFf1kSDK) {
        Long l8 = (Long) aFf1kSDK.AFInAppEventType.get("click_ts");
        if (l8 == null || System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l8.longValue()) >= TimeUnit.DAYS.toMillis(1L)) {
            return false;
        }
        return true;
    }

    private boolean AFVersionDeclaration() {
        int i8;
        List list = (List) this.AFKeystoreWrapper.get("referrers");
        if (list != null) {
            i8 = list.size();
        } else {
            i8 = 0;
        }
        if (i8 >= this.onResponseNative || this.AFKeystoreWrapper.containsKey("referrers")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLevel() {
        String[] strArr;
        boolean z7 = true;
        this.onResponseErrorNative++;
        StringBuilder sb = new StringBuilder("[DDL] Preparing request ");
        sb.append(this.onResponseErrorNative);
        AFLogger.afDebugLog(sb.toString());
        if (this.onResponseErrorNative == 1) {
            AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
            Map<String, Object> map = this.AFKeystoreWrapper;
            if (this.init.valueOf.AFInAppEventType("appsFlyerCount", 0) != 0) {
                z7 = false;
            }
            map.put("is_first", Boolean.valueOf(z7));
            Map<String, Object> map2 = this.AFKeystoreWrapper;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Locale.getDefault().getLanguage());
            sb2.append("-");
            sb2.append(Locale.getDefault().getCountry());
            map2.put("lang", sb2.toString());
            this.AFKeystoreWrapper.put("os", Build.VERSION.RELEASE);
            this.AFKeystoreWrapper.put("type", Build.MODEL);
            this.AFKeystoreWrapper.put("request_id", AFb1wSDK.AFKeystoreWrapper(new WeakReference(this.init.AFKeystoreWrapper.AFKeystoreWrapper)));
            AFa1eSDK aFa1eSDK = AFInAppEventType.AFLogger;
            if (aFa1eSDK != null && (strArr = aFa1eSDK.AFInAppEventType) != null) {
                this.AFKeystoreWrapper.put("sharing_filter", strArr);
            }
            Map<String, Object> AFInAppEventType2 = AFInAppEventType(AFa1bSDK.values(this.init.AFKeystoreWrapper.AFKeystoreWrapper, new HashMap()));
            Map<String, Object> AFInAppEventType3 = AFInAppEventType(AFa1bSDK.valueOf(this.init.AFKeystoreWrapper.AFKeystoreWrapper));
            if (AFInAppEventType2 != null) {
                this.AFKeystoreWrapper.put("gaid", AFInAppEventType2);
            }
            if (AFInAppEventType3 != null) {
                this.AFKeystoreWrapper.put("oaid", AFInAppEventType3);
            }
        }
        Map<String, Object> map3 = this.AFKeystoreWrapper;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        long currentTimeMillis = System.currentTimeMillis();
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        map3.put("timestamp", simpleDateFormat.format(new Date(currentTimeMillis)));
        this.AFKeystoreWrapper.put("request_count", Integer.valueOf(this.onResponseErrorNative));
        ArrayList arrayList = new ArrayList();
        for (AFf1kSDK aFf1kSDK : this.getLevel) {
            Map<String, String> AFInAppEventParameterName = AFInAppEventParameterName(aFf1kSDK);
            if (AFInAppEventParameterName != null) {
                arrayList.add(AFInAppEventParameterName);
            }
        }
        if (!arrayList.isEmpty()) {
            this.AFKeystoreWrapper.put("referrers", arrayList);
        }
        AFKeystoreWrapper(onInstallConversionDataLoadedNative());
    }

    private String onInstallConversionDataLoadedNative() {
        String str;
        String str2 = this.AppsFlyer2dXConversionCallback.values;
        String packageName = this.init.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName();
        String AFInAppEventType = this.init.AFInAppEventType();
        if (AFInAppEventType != null && !AFInAppEventType.trim().isEmpty()) {
            str = "-".concat(AFInAppEventType);
        } else {
            str = "";
        }
        Uri.Builder buildUpon = Uri.parse(String.format(afErrorLogForExcManagerOnly, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName())).buildUpon();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(str);
        Uri.Builder appendPath = buildUpon.appendPath(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.AFKeystoreWrapper.get("timestamp"));
        sb2.append(str2);
        return appendPath.appendQueryParameter("af_sig", AFb1ySDK.AFKeystoreWrapper(sb2.toString(), str2)).appendQueryParameter("sdk_version", AFb1xSDK.AFKeystoreWrapper).build().toString();
    }

    static /* synthetic */ void values(AFb1oSDK aFb1oSDK) {
        AFf1kSDK[] AFInAppEventParameterName;
        ArrayList<AFf1kSDK> arrayList = new ArrayList();
        for (AFf1kSDK aFf1kSDK : aFb1oSDK.onInstallConversionFailureNative.AFInAppEventParameterName()) {
            if (aFf1kSDK != null && aFf1kSDK.afRDLog != AFf1kSDK.AFa1wSDK.NOT_STARTED) {
                arrayList.add(aFf1kSDK);
            }
        }
        aFb1oSDK.onResponseNative = arrayList.size();
        for (final AFf1kSDK aFf1kSDK2 : arrayList) {
            int i8 = AnonymousClass3.AFKeystoreWrapper[aFf1kSDK2.afRDLog.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    aFf1kSDK2.addObserver(new Observer() { // from class: com.appsflyer.internal.AFb1oSDK.1
                        @Override // java.util.Observer
                        public final void update(Observable observable, Object obj) {
                            StringBuilder sb = new StringBuilder("[DDL] ");
                            sb.append(aFf1kSDK2.AFInAppEventType.get("source"));
                            sb.append(" referrer collected via observer");
                            AFLogger.afDebugLog(sb.toString());
                            AFb1oSDK.this.AFInAppEventType((AFf1kSDK) observable);
                        }
                    });
                }
            } else {
                StringBuilder sb = new StringBuilder("[DDL] ");
                sb.append(aFf1kSDK2.AFInAppEventType.get("source"));
                sb.append(" referrer collected earlier");
                AFLogger.afDebugLog(sb.toString());
                aFb1oSDK.AFInAppEventType(aFf1kSDK2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.appsflyer.deeplink.DeepLinkResult afInfoLog() {
        /*
            r5 = this;
            java.lang.String r0 = "[DDL] start"
            com.appsflyer.AFLogger.afDebugLog(r0)
            java.util.concurrent.FutureTask r0 = new java.util.concurrent.FutureTask
            com.appsflyer.internal.AFb1oSDK$4 r1 = new com.appsflyer.internal.AFb1oSDK$4
            r1.<init>()
            r0.<init>(r1)
            java.util.concurrent.ExecutorService r1 = r5.onAppOpenAttributionNative
            r1.execute(r0)
            r1 = 0
            long r2 = com.appsflyer.internal.AFb1oSDK.afWarnLog     // Catch: java.util.concurrent.TimeoutException -> L2a java.lang.InterruptedException -> L64 java.util.concurrent.ExecutionException -> L66
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L2a java.lang.InterruptedException -> L64 java.util.concurrent.ExecutionException -> L66
            java.lang.Object r0 = r0.get(r2, r4)     // Catch: java.util.concurrent.TimeoutException -> L2a java.lang.InterruptedException -> L64 java.util.concurrent.ExecutionException -> L66
            com.appsflyer.deeplink.DeepLinkResult r0 = (com.appsflyer.deeplink.DeepLinkResult) r0     // Catch: java.util.concurrent.TimeoutException -> L2a java.lang.InterruptedException -> L64 java.util.concurrent.ExecutionException -> L66
            com.appsflyer.internal.AFe1jSDK r2 = r5.onInstallConversionDataLoadedNative     // Catch: java.util.concurrent.TimeoutException -> L2a java.lang.InterruptedException -> L64 java.util.concurrent.ExecutionException -> L66
            long r3 = com.appsflyer.internal.AFb1oSDK.afWarnLog     // Catch: java.util.concurrent.TimeoutException -> L2a java.lang.InterruptedException -> L64 java.util.concurrent.ExecutionException -> L66
            r2.values(r0, r3)     // Catch: java.util.concurrent.TimeoutException -> L2a java.lang.InterruptedException -> L64 java.util.concurrent.ExecutionException -> L66
            com.appsflyer.internal.AFb1nSDK.AFInAppEventType(r0)     // Catch: java.util.concurrent.TimeoutException -> L2a java.lang.InterruptedException -> L64 java.util.concurrent.ExecutionException -> L66
            return r0
        L2a:
            r0 = move-exception
            java.lang.String r2 = "[DDL] Timeout"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "[DDL] Timeout, didn't manage to find deferred deep link after "
            r0.<init>(r2)
            int r2 = r5.onResponseErrorNative
            r0.append(r2)
            java.lang.String r2 = " attempt(s) within "
            r0.append(r2)
            long r2 = com.appsflyer.internal.AFb1oSDK.afWarnLog
            r0.append(r2)
            java.lang.String r2 = " milliseconds"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afDebugLog(r0)
            com.appsflyer.deeplink.DeepLinkResult r0 = new com.appsflyer.deeplink.DeepLinkResult
            com.appsflyer.deeplink.DeepLinkResult$Error r2 = com.appsflyer.deeplink.DeepLinkResult.Error.TIMEOUT
            r0.<init>(r1, r2)
            com.appsflyer.internal.AFe1jSDK r1 = r5.onInstallConversionDataLoadedNative
            long r2 = com.appsflyer.internal.AFb1oSDK.afWarnLog
            r1.values(r0, r2)
            com.appsflyer.internal.AFb1nSDK.AFInAppEventType(r0)
            goto L8a
        L64:
            r0 = move-exception
            goto L67
        L66:
            r0 = move-exception
        L67:
            r2 = 1
            java.lang.String r3 = "[DDL] Error occurred"
            com.appsflyer.AFLogger.afErrorLog(r3, r0, r2)
            com.appsflyer.deeplink.DeepLinkResult r2 = new com.appsflyer.deeplink.DeepLinkResult
            java.lang.Throwable r0 = r0.getCause()
            boolean r0 = r0 instanceof java.io.IOException
            if (r0 == 0) goto L7a
            com.appsflyer.deeplink.DeepLinkResult$Error r0 = com.appsflyer.deeplink.DeepLinkResult.Error.NETWORK
            goto L7c
        L7a:
            com.appsflyer.deeplink.DeepLinkResult$Error r0 = com.appsflyer.deeplink.DeepLinkResult.Error.UNEXPECTED
        L7c:
            r2.<init>(r1, r0)
            com.appsflyer.internal.AFe1jSDK r0 = r5.onInstallConversionDataLoadedNative
            long r3 = com.appsflyer.internal.AFb1oSDK.afWarnLog
            r0.values(r2, r3)
            com.appsflyer.internal.AFb1nSDK.AFInAppEventType(r2)
            r0 = r2
        L8a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1oSDK.afInfoLog():com.appsflyer.deeplink.DeepLinkResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AFInAppEventType(AFf1kSDK aFf1kSDK) {
        if (AFKeystoreWrapper(aFf1kSDK)) {
            this.getLevel.add(aFf1kSDK);
            this.AFLogger$LogLevel.countDown();
            StringBuilder sb = new StringBuilder("[DDL] Added non-organic ");
            sb.append(aFf1kSDK.getClass().getSimpleName());
            AFLogger.afDebugLog(sb.toString());
            return;
        }
        int i8 = this.onAttributionFailureNative + 1;
        this.onAttributionFailureNative = i8;
        if (i8 == this.onResponseNative) {
            this.AFLogger$LogLevel.countDown();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x016c, code lost:
        return new com.appsflyer.deeplink.DeepLinkResult(null, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ com.appsflyer.deeplink.DeepLinkResult AFInAppEventParameterName(com.appsflyer.internal.AFb1oSDK r12, android.content.Context r13) throws java.io.IOException, org.json.JSONException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1oSDK.AFInAppEventParameterName(com.appsflyer.internal.AFb1oSDK, android.content.Context):com.appsflyer.deeplink.DeepLinkResult");
    }

    @Override // com.appsflyer.internal.AFa1sSDK
    public final AFd1rSDK AFInAppEventType() {
        return AFd1rSDK.DLSDK;
    }

    private Map<String, Object> AFInAppEventType(final AFc1oSDK.AFa1xSDK aFa1xSDK) {
        Boolean bool;
        boolean z7 = false;
        if (aFa1xSDK != null && aFa1xSDK.AFInAppEventParameterName != null && ((bool = aFa1xSDK.valueOf) == null || !bool.booleanValue())) {
            z7 = true;
        }
        if (z7) {
            return new HashMap<String, Object>() { // from class: com.appsflyer.internal.AFb1oSDK.2
                {
                    put("type", "unhashed");
                    put(AppMeasurementSdk.ConditionalUserProperty.VALUE, aFa1xSDK.AFInAppEventParameterName);
                }
            };
        }
        return null;
    }
}
