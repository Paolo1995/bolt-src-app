package com.mixpanel.android.util;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSONUtils {
    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str) && !jSONObject.isNull(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }
}
