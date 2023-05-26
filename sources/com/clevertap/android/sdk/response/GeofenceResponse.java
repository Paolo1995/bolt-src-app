package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GeofenceResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final BaseCallbackManager f11747a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapResponse f11748b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f11749c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f11750d;

    public GeofenceResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig, BaseCallbackManager baseCallbackManager) {
        this.f11748b = cleverTapResponse;
        this.f11749c = cleverTapInstanceConfig;
        this.f11750d = cleverTapInstanceConfig.n();
        this.f11747a = baseCallbackManager;
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        this.f11750d.s(this.f11749c.c(), "Processing GeoFences response...");
        if (this.f11749c.p()) {
            this.f11750d.s(this.f11749c.c(), "CleverTap instance is configured to analytics only, not processing geofence response");
            this.f11748b.a(jSONObject, str, context);
        } else if (jSONObject == null) {
            this.f11750d.s(this.f11749c.c(), "Geofences : Can't parse Geofences Response, JSON response object is null");
        } else if (!jSONObject.has("geofences")) {
            this.f11750d.s(this.f11749c.c(), "Geofences : JSON object doesn't contain the Geofences key");
            this.f11748b.a(jSONObject, str, context);
        } else {
            try {
                if (this.f11747a.e() != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("geofences", jSONObject.getJSONArray("geofences"));
                    this.f11750d.s(this.f11749c.c(), "Geofences : Processing Geofences response");
                    this.f11747a.e().b(jSONObject2);
                } else {
                    this.f11750d.f(this.f11749c.c(), "Geofences : Geofence SDK has not been initialized to handle the response");
                }
            } catch (Throwable th) {
                this.f11750d.t(this.f11749c.c(), "Geofences : Failed to handle Geofences response", th);
            }
            this.f11748b.a(jSONObject, str, context);
        }
    }
}
