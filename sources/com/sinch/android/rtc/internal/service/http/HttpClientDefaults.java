package com.sinch.android.rtc.internal.service.http;

import android.util.Log;
import com.sinch.httpclient.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class HttpClientDefaults {
    private static byte[] defaultEmptyBody;
    private static Map<String, String> defaultEmptyHeaders;
    private static Logger logger;

    public static byte[] getDefaultEmptyBody() {
        if (defaultEmptyBody == null) {
            defaultEmptyBody = new byte[0];
        }
        return defaultEmptyBody;
    }

    public static Map<String, String> getDefaultEmptyHeaders() {
        if (defaultEmptyHeaders == null) {
            defaultEmptyHeaders = new HashMap();
        }
        return defaultEmptyHeaders;
    }

    public static synchronized Logger getDefaultLogger() {
        Logger logger2;
        synchronized (HttpClientDefaults.class) {
            if (logger == null) {
                logger = new Logger() { // from class: com.sinch.android.rtc.internal.service.http.HttpClientDefaults.1
                    @Override // com.sinch.httpclient.Logger
                    public void d(String str, String str2) {
                        Log.d(str, str2);
                    }
                };
            }
            logger2 = logger;
        }
        return logger2;
    }
}
