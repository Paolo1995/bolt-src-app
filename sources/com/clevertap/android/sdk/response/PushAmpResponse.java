package com.clevertap.android.sdk.response;

import android.content.Context;
import android.os.Bundle;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PushAmpResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final BaseCallbackManager f11774a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapResponse f11775b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f11776c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f11777d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f11778e;

    /* renamed from: f  reason: collision with root package name */
    private final ControllerManager f11779f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseDatabaseManager f11780g;

    public PushAmpResponse(CleverTapResponse cleverTapResponse, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, BaseDatabaseManager baseDatabaseManager, BaseCallbackManager baseCallbackManager, ControllerManager controllerManager) {
        this.f11775b = cleverTapResponse;
        this.f11777d = context;
        this.f11776c = cleverTapInstanceConfig;
        this.f11778e = cleverTapInstanceConfig.n();
        this.f11780g = baseDatabaseManager;
        this.f11774a = baseCallbackManager;
        this.f11779f = controllerManager;
    }

    private void b(JSONArray jSONArray) {
        for (int i8 = 0; i8 < jSONArray.length(); i8++) {
            try {
                Bundle bundle = new Bundle();
                JSONObject jSONObject = jSONArray.getJSONObject(i8);
                if (jSONObject.has("wzrk_ttl")) {
                    bundle.putLong("wzrk_ttl", jSONObject.getLong("wzrk_ttl"));
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    bundle.putString(obj, jSONObject.getString(obj));
                }
                if (!bundle.isEmpty() && !this.f11780g.c(this.f11777d).x(jSONObject.getString("wzrk_pid"))) {
                    this.f11778e.r("Creating Push Notification locally");
                    if (this.f11774a.j() != null) {
                        this.f11774a.j().a(bundle);
                    } else {
                        this.f11779f.i().b(this.f11777d, bundle, -1000);
                    }
                } else {
                    Logger logger = this.f11778e;
                    String c8 = this.f11776c.c();
                    logger.s(c8, "Push Notification already shown, ignoring local notification :" + jSONObject.getString("wzrk_pid"));
                }
            } catch (JSONException unused) {
                this.f11778e.s(this.f11776c.c(), "Error parsing push notification JSON");
                return;
            }
        }
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        if (this.f11776c.p()) {
            this.f11778e.s(this.f11776c.c(), "CleverTap instance is configured to analytics only, not processing push amp response");
            this.f11775b.a(jSONObject, str, context);
            return;
        }
        try {
            if (jSONObject.has("pushamp_notifs")) {
                this.f11778e.s(this.f11776c.c(), "Processing pushamp messages...");
                JSONObject jSONObject2 = jSONObject.getJSONObject("pushamp_notifs");
                JSONArray jSONArray = jSONObject2.getJSONArray("list");
                if (jSONArray.length() > 0) {
                    this.f11778e.s(this.f11776c.c(), "Handling Push payload locally");
                    b(jSONArray);
                }
                if (jSONObject2.has("pf")) {
                    this.f11779f.i().V(context, jSONObject2.getInt("pf"));
                }
                if (jSONObject2.has("ack")) {
                    boolean z7 = jSONObject2.getBoolean("ack");
                    Logger logger = this.f11778e;
                    logger.r("Received ACK -" + z7);
                    if (z7) {
                        JSONArray d8 = CTJsonConverter.d(this.f11780g.c(context));
                        String[] strArr = new String[0];
                        if (d8 != null) {
                            strArr = new String[d8.length()];
                        }
                        for (int i8 = 0; i8 < strArr.length; i8++) {
                            strArr[i8] = d8.getString(i8);
                        }
                        this.f11778e.r("Updating RTL values...");
                        this.f11780g.c(context).N(strArr);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.f11775b.a(jSONObject, str, context);
    }
}
