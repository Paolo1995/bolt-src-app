package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class AFd1eSDK extends AFd1pSDK<Map<String, Object>> {
    private static final int afErrorLog = (int) TimeUnit.SECONDS.toMillis(2);
    private final Map<String, Object> AFLogger;
    private Map<String, Object> afDebugLog;
    private final List<String> afErrorLogForExcManagerOnly;
    private final Uri afInfoLog;
    private final Context afRDLog;

    public AFd1eSDK(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull Uri uri, @NonNull List<String> list) {
        super(AFd1rSDK.RESOLVE_ESP, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, "ResolveEsp");
        this.afRDLog = context;
        this.AFLogger = map;
        this.afInfoLog = uri;
        this.afErrorLogForExcManagerOnly = list;
    }

    private static Map<String, Object> values(Uri uri) {
        HashMap hashMap = new HashMap();
        try {
            StringBuilder sb = new StringBuilder("ESP deeplink resolving is started: ");
            sb.append(uri.toString());
            AFLogger.afDebugLog(sb.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection()));
            httpURLConnection.setInstanceFollowRedirects(false);
            int i8 = afErrorLog;
            httpURLConnection.setReadTimeout(i8);
            httpURLConnection.setConnectTimeout(i8);
            httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
            httpURLConnection.setRequestProperty("af-esp", "6.10.2");
            int responseCode = httpURLConnection.getResponseCode();
            hashMap.put("status", Integer.valueOf(responseCode));
            if (300 <= responseCode && responseCode <= 305) {
                hashMap.put("res", httpURLConnection.getHeaderField("Location"));
            }
            httpURLConnection.disconnect();
            AFLogger.afDebugLog("ESP deeplink resolving is finished");
        } catch (Throwable th) {
            hashMap.put("error", th.getLocalizedMessage());
            AFLogger.afErrorLog(th.getMessage(), th);
        }
        return hashMap;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        if (!AFInAppEventType(this.afInfoLog.toString())) {
            AFb1xSDK.AFInAppEventType().values(this.afRDLog, this.AFLogger, this.afInfoLog);
            return AFd1tSDK.SUCCESS;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.afInfoLog.toString();
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        Integer num = null;
        String str = null;
        while (i8 < 5) {
            Map<String, Object> values = values(Uri.parse(obj));
            String str2 = (String) values.get("res");
            Integer num2 = (Integer) values.get("status");
            String str3 = (String) values.get("error");
            if (str2 == null || !AFInAppEventType(str2)) {
                str = str3;
                obj = str2;
                num = num2;
                break;
            }
            if (i8 < 4) {
                arrayList.add(str2);
            }
            i8++;
            str = str3;
            obj = str2;
            num = num2;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("res", obj != null ? obj : "");
        hashMap.put("status", Integer.valueOf(num != null ? num.intValue() : -1));
        if (str != null) {
            hashMap.put("error", str);
        }
        if (!arrayList.isEmpty()) {
            hashMap.put("redirects", arrayList);
        }
        hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        synchronized (this.AFLogger) {
            this.AFLogger.put("af_deeplink_r", hashMap);
            this.AFLogger.put("af_deeplink", this.afInfoLog.toString());
        }
        AFb1xSDK.AFInAppEventType().values(this.afRDLog, this.AFLogger, obj != null ? Uri.parse(obj) : this.afInfoLog);
        this.afDebugLog = hashMap;
        return AFd1tSDK.SUCCESS;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final boolean AFKeystoreWrapper() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final long valueOf() {
        return 60000L;
    }

    private boolean AFInAppEventType(String str) {
        if (str.contains("af_tranid=")) {
            return false;
        }
        StringBuilder sb = new StringBuilder("Validate if link ");
        sb.append(str);
        sb.append(" belongs to ESP domains: ");
        sb.append(this.afErrorLogForExcManagerOnly);
        AFLogger.afRDLog(sb.toString());
        try {
            return this.afErrorLogForExcManagerOnly.contains(new URL(str).getHost());
        } catch (MalformedURLException e8) {
            AFLogger.afErrorLogForExcManagerOnly("MalformedURLException ESP link", e8);
            return false;
        }
    }
}
