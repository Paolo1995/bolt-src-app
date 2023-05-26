package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.internal.AFd1sSDK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFa1tSDK {
    static final List<String> AFInAppEventParameterName = new ArrayList();
    public static String[] AFKeystoreWrapper;
    private static Intent afDebugLog;
    public Map<String, String> AFInAppEventType;
    public List<List<String>> afInfoLog = new ArrayList();
    public DeepLinkListener valueOf;
    public String values;

    public static void AFInAppEventParameterName(Intent intent) {
        Uri uri;
        if (intent != null && "android.intent.action.VIEW".equals(intent.getAction())) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        if (uri != null && intent != afDebugLog) {
            afDebugLog = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void values(Context context, Map<String, Object> map, Uri uri) {
        AFd1eSDK aFd1eSDK = new AFd1eSDK(context, map, uri, AFInAppEventParameterName);
        AFb1xSDK.AFInAppEventType().values(context);
        AFd1sSDK afDebugLog2 = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afDebugLog();
        afDebugLog2.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFd1eSDK));
        afDebugLog = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void valueOf(Map<String, Object> map, Intent intent, Context context) {
        AFb1xSDK.AFInAppEventType().values(context);
        AFc1vSDK AFKeystoreWrapper2 = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        AFc1ySDK afInfoLog = AFKeystoreWrapper2.afInfoLog();
        if (!valueOf(intent, context, map) && this.valueOf != null && AFKeystoreWrapper2.values().valueOf.AFInAppEventType("appsFlyerCount", 0) == 0 && !afInfoLog.AFKeystoreWrapper("ddl_sent")) {
            AFb1oSDK aFb1oSDK = new AFb1oSDK(context, AFKeystoreWrapper2);
            AFd1sSDK afDebugLog2 = AFKeystoreWrapper2.afDebugLog();
            afDebugLog2.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(new AFd1fSDK(aFb1oSDK)));
        }
        afInfoLog.AFInAppEventType("ddl_sent", true);
    }

    private Uri values(Object obj, Iterator<String> it) {
        while (obj != JSONObject.NULL) {
            if (!it.hasNext()) {
                Uri parse = Uri.parse(obj.toString());
                if (parse == null || parse.getScheme() == null || parse.getHost() == null) {
                    return null;
                }
                return parse;
            }
            try {
                obj = new JSONObject(obj.toString()).get(it.next());
            } catch (JSONException e8) {
                AFLogger.afErrorLogForExcManagerOnly("recursiveSearch error", e8);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri valueOf(Intent intent) {
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            return null;
        }
        return intent.getData();
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0076 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean valueOf(android.content.Intent r9, android.content.Context r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.valueOf(android.content.Intent, android.content.Context, java.util.Map):boolean");
    }
}
