package com.clevertap.android.sdk.utils;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.validation.ValidationResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CTJsonConverter {
    public static JSONObject a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String string = bundle.getString("wzrk_adunit");
        Logger.n("Received Display Unit via push payload: " + string);
        JSONArray jSONArray = new JSONArray();
        jSONObject.put("adUnit_notifs", jSONArray);
        jSONArray.put(new JSONObject(string));
        return jSONObject;
    }

    public static JSONObject b(DeviceInfo deviceInfo, Location location, boolean z7, boolean z8) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Build", deviceInfo.q() + "");
        jSONObject.put("Version", deviceInfo.N());
        jSONObject.put("OS Version", deviceInfo.K());
        jSONObject.put("SDK Version", deviceInfo.L());
        if (location != null) {
            jSONObject.put("Latitude", location.getLatitude());
            jSONObject.put("Longitude", location.getLongitude());
        }
        if (deviceInfo.C() != null) {
            String str = "GoogleAdID";
            if (z8) {
                str = "mt_GoogleAdID";
            }
            jSONObject.put(str, deviceInfo.C());
            jSONObject.put("GoogleAdIDLimit", deviceInfo.S());
        }
        try {
            jSONObject.put("Make", deviceInfo.F());
            jSONObject.put("Model", deviceInfo.G());
            jSONObject.put("Carrier", deviceInfo.r());
            jSONObject.put("useIP", z7);
            jSONObject.put("OS", deviceInfo.J());
            jSONObject.put("wdt", deviceInfo.O());
            jSONObject.put("hgt", deviceInfo.D());
            jSONObject.put("dpi", deviceInfo.v());
            jSONObject.put("dt", DeviceInfo.z(deviceInfo.t()));
            if (Build.VERSION.SDK_INT >= 28) {
                jSONObject.put("abckt", deviceInfo.m());
            }
            if (deviceInfo.E() != null) {
                jSONObject.put("lib", deviceInfo.E());
            }
            if (!TextUtils.isEmpty(ManifestInfo.i(deviceInfo.t()).h())) {
                jSONObject.put("fcmsid", true);
            }
            String u7 = deviceInfo.u();
            if (u7 != null && !u7.equals("")) {
                jSONObject.put("cc", u7);
            }
            if (z7) {
                Boolean T = deviceInfo.T();
                if (T != null) {
                    jSONObject.put("wifi", T);
                }
                Boolean Q = deviceInfo.Q();
                if (Q != null) {
                    jSONObject.put("BluetoothEnabled", Q);
                }
                String p8 = deviceInfo.p();
                if (p8 != null) {
                    jSONObject.put("BluetoothVersion", p8);
                }
                String H = deviceInfo.H();
                if (H != null) {
                    jSONObject.put("Radio", H);
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject c(ValidationResult validationResult) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("c", validationResult.a());
            jSONObject.put("d", validationResult.b());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONArray d(DBAdapter dBAdapter) {
        String[] A = dBAdapter.A();
        JSONArray jSONArray = new JSONArray();
        for (String str : A) {
            Logger.n("RTL IDs -" + str);
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static JSONObject e(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                JSONObject e8 = e((Bundle) obj);
                Iterator<String> keys = e8.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, e8.get(next));
                }
            } else if (str.startsWith("wzrk_")) {
                jSONObject.put(str, bundle.get(str));
            }
        }
        return jSONObject;
    }

    public static JSONObject f(CTInAppNotification cTInAppNotification) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject s7 = cTInAppNotification.s();
        Iterator<String> keys = s7.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith("wzrk_")) {
                jSONObject.put(next, s7.get(next));
            }
        }
        return jSONObject;
    }

    public static JSONObject g(CTInboxMessage cTInboxMessage) {
        return cTInboxMessage.n();
    }

    public static <T> Object[] h(@NonNull JSONArray jSONArray) {
        Object[] objArr = new Object[jSONArray.length()];
        for (int i8 = 0; i8 < jSONArray.length(); i8++) {
            try {
                objArr[i8] = jSONArray.get(i8);
            } catch (JSONException e8) {
                e8.printStackTrace();
            }
        }
        return objArr;
    }

    public static JSONArray i(@NonNull List<?> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj != null) {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject j(java.lang.String r2, com.clevertap.android.sdk.Logger r3, java.lang.String r4) {
        /*
            if (r2 == 0) goto L21
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L8
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L8
            goto L22
        L8:
            r2 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error reading guid cache: "
            r0.append(r1)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            r3.s(r4, r2)
        L21:
            r0 = 0
        L22:
            if (r0 == 0) goto L25
            goto L2a
        L25:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.utils.CTJsonConverter.j(java.lang.String, com.clevertap.android.sdk.Logger, java.lang.String):org.json.JSONObject");
    }

    public static String k(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static ArrayList<?> l(@NonNull JSONArray jSONArray) {
        ArrayList<?> arrayList = new ArrayList<>();
        for (int i8 = 0; i8 < jSONArray.length(); i8++) {
            try {
                arrayList.add(jSONArray.get(i8));
            } catch (JSONException e8) {
                e8.printStackTrace();
            }
        }
        return arrayList;
    }
}
