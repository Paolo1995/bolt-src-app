package com.clevertap.android.sdk.response;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.network.NetworkManager;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.validation.Validator;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ARPResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final CTProductConfigController f11723a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapResponse f11724b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f11725c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f11726d;

    /* renamed from: e  reason: collision with root package name */
    private final NetworkManager f11727e;

    /* renamed from: f  reason: collision with root package name */
    private final Validator f11728f;

    public ARPResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig, NetworkManager networkManager, Validator validator, ControllerManager controllerManager) {
        this.f11724b = cleverTapResponse;
        this.f11725c = cleverTapInstanceConfig;
        this.f11723a = controllerManager.f();
        this.f11726d = cleverTapInstanceConfig.n();
        this.f11727e = networkManager;
        this.f11728f = validator;
    }

    private void b(Context context, JSONObject jSONObject) {
        String r7;
        if (jSONObject == null || jSONObject.length() == 0 || (r7 = this.f11727e.r()) == null) {
            return;
        }
        SharedPreferences.Editor edit = StorageHelper.h(context, r7).edit();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof Number) {
                    edit.putInt(next, ((Number) obj).intValue());
                } else if (obj instanceof String) {
                    if (((String) obj).length() < 100) {
                        edit.putString(next, (String) obj);
                    } else {
                        Logger logger = this.f11726d;
                        String c8 = this.f11725c.c();
                        logger.s(c8, "ARP update for key " + next + " rejected (string value too long)");
                    }
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(next, ((Boolean) obj).booleanValue());
                } else {
                    Logger logger2 = this.f11726d;
                    String c9 = this.f11725c.c();
                    logger2.s(c9, "ARP update for key " + next + " rejected (invalid data type)");
                }
            } catch (JSONException unused) {
            }
        }
        Logger logger3 = this.f11726d;
        String c10 = this.f11725c.c();
        logger3.s(c10, "Stored ARP for namespace key: " + r7 + " values: " + jSONObject.toString());
        StorageHelper.l(edit);
    }

    private void c(JSONObject jSONObject) {
        if (!jSONObject.has("d_e")) {
            this.f11726d.s(this.f11725c.c(), "ARP doesn't contain the Discarded Events key");
            return;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("d_e");
            if (jSONArray != null) {
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    arrayList.add(jSONArray.getString(i8));
                }
            }
            Validator validator = this.f11728f;
            if (validator != null) {
                validator.l(arrayList);
            } else {
                this.f11726d.s(this.f11725c.c(), "Validator object is NULL");
            }
        } catch (JSONException e8) {
            Logger logger = this.f11726d;
            String c8 = this.f11725c.c();
            logger.s(c8, "Error parsing discarded events list" + e8.getLocalizedMessage());
        }
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        try {
            if (jSONObject.has("arp")) {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("arp");
                if (jSONObject2.length() > 0) {
                    CTProductConfigController cTProductConfigController = this.f11723a;
                    if (cTProductConfigController != null) {
                        cTProductConfigController.v(jSONObject2);
                    }
                    c(jSONObject2);
                    b(context, jSONObject2);
                }
            }
        } catch (Throwable th) {
            this.f11726d.t(this.f11725c.c(), "Failed to process ARP", th);
        }
        this.f11724b.a(jSONObject, str, context);
    }
}
