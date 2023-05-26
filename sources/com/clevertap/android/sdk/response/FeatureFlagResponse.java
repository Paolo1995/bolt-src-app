package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FeatureFlagResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapResponse f11743a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11744b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f11745c;

    /* renamed from: d  reason: collision with root package name */
    private final ControllerManager f11746d;

    public FeatureFlagResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig, ControllerManager controllerManager) {
        this.f11743a = cleverTapResponse;
        this.f11744b = cleverTapInstanceConfig;
        this.f11745c = cleverTapInstanceConfig.n();
        this.f11746d = controllerManager;
    }

    private void b(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getJSONArray("kv") != null && this.f11746d.d() != null) {
            this.f11746d.d().q(jSONObject);
        }
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        this.f11745c.s(this.f11744b.c(), "Processing Feature Flags response...");
        if (this.f11744b.p()) {
            this.f11745c.s(this.f11744b.c(), "CleverTap instance is configured to analytics only, not processing Feature Flags response");
            this.f11743a.a(jSONObject, str, context);
        } else if (jSONObject == null) {
            this.f11745c.s(this.f11744b.c(), "Feature Flag : Can't parse Feature Flags Response, JSON response object is null");
        } else if (!jSONObject.has("ff_notifs")) {
            this.f11745c.s(this.f11744b.c(), "Feature Flag : JSON object doesn't contain the Feature Flags key");
            this.f11743a.a(jSONObject, str, context);
        } else {
            try {
                this.f11745c.s(this.f11744b.c(), "Feature Flag : Processing Feature Flags response");
                b(jSONObject.getJSONObject("ff_notifs"));
            } catch (Throwable th) {
                this.f11745c.t(this.f11744b.c(), "Feature Flag : Failed to parse response", th);
            }
            this.f11743a.a(jSONObject, str, context);
        }
    }
}
