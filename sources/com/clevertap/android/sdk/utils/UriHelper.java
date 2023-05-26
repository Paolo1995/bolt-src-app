package com.clevertap.android.sdk.utils;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import com.clevertap.android.sdk.Logger;
import java.net.URLDecoder;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class UriHelper {
    public static Bundle a(String str, boolean z7) {
        if (str == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        try {
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer.parseUrl(str);
            for (String str2 : urlQuerySanitizer.getParameterSet()) {
                String e8 = e(str2, urlQuerySanitizer, false);
                if (e8 != null) {
                    if (!z7 && !str2.equals("wzrk_c2a")) {
                        bundle.putString(str2, URLDecoder.decode(e8, "UTF-8"));
                    }
                    bundle.putString(str2, e8);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static JSONObject b(Uri uri) {
        JSONObject jSONObject = new JSONObject();
        try {
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.parseUrl(uri.toString());
            String c8 = c("source", urlQuerySanitizer);
            String c9 = c("medium", urlQuerySanitizer);
            String c10 = c("campaign", urlQuerySanitizer);
            jSONObject.put("us", c8);
            jSONObject.put("um", c9);
            jSONObject.put("uc", c10);
            String f8 = f("medium", urlQuerySanitizer);
            if (f8 != null && f8.matches("^email$|^social$|^search$")) {
                jSONObject.put("wm", f8);
            }
            Logger.a("Referrer data: " + jSONObject.toString(4));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static String c(String str, UrlQuerySanitizer urlQuerySanitizer) {
        String d8 = d(str, urlQuerySanitizer);
        if (d8 == null && (d8 = f(str, urlQuerySanitizer)) == null) {
            return null;
        }
        return d8;
    }

    private static String d(String str, UrlQuerySanitizer urlQuerySanitizer) {
        return e("utm_" + str, urlQuerySanitizer, true);
    }

    private static String e(String str, UrlQuerySanitizer urlQuerySanitizer, boolean z7) {
        if (str != null && urlQuerySanitizer != null) {
            try {
                String value = urlQuerySanitizer.getValue(str);
                if (value == null) {
                    return null;
                }
                if (z7 && value.length() > 120) {
                    return value.substring(0, 120);
                }
                return value;
            } catch (Throwable th) {
                Logger.q("Couldn't parse the URI", th);
            }
        }
        return null;
    }

    private static String f(String str, UrlQuerySanitizer urlQuerySanitizer) {
        return e("wzrk_" + str, urlQuerySanitizer, true);
    }
}
