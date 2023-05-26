package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ProductConfigResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapResponse f11769a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11770b;

    /* renamed from: c  reason: collision with root package name */
    private final CoreMetaData f11771c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f11772d;

    /* renamed from: e  reason: collision with root package name */
    private final ControllerManager f11773e;

    public ProductConfigResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData, ControllerManager controllerManager) {
        this.f11769a = cleverTapResponse;
        this.f11770b = cleverTapInstanceConfig;
        this.f11772d = cleverTapInstanceConfig.n();
        this.f11771c = coreMetaData;
        this.f11773e = controllerManager;
    }

    private void b() {
        if (this.f11771c.E()) {
            if (this.f11773e.f() != null) {
                this.f11773e.f().o();
            }
            this.f11771c.W(false);
        }
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getJSONArray("kv") != null && this.f11773e.f() != null) {
            this.f11773e.f().p(jSONObject);
        } else {
            b();
        }
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        this.f11772d.s(this.f11770b.c(), "Processing Product Config response...");
        if (this.f11770b.p()) {
            this.f11772d.s(this.f11770b.c(), "CleverTap instance is configured to analytics only, not processing Product Config response");
            this.f11769a.a(jSONObject, str, context);
        } else if (jSONObject == null) {
            this.f11772d.s(this.f11770b.c(), "Product Config : Can't parse Product Config Response, JSON response object is null");
            b();
        } else if (!jSONObject.has("pc_notifs")) {
            this.f11772d.s(this.f11770b.c(), "Product Config : JSON object doesn't contain the Product Config key");
            b();
            this.f11769a.a(jSONObject, str, context);
        } else {
            try {
                this.f11772d.s(this.f11770b.c(), "Product Config : Processing Product Config response");
                c(jSONObject.getJSONObject("pc_notifs"));
            } catch (Throwable th) {
                b();
                this.f11772d.t(this.f11770b.c(), "Product Config : Failed to parse Product Config response", th);
            }
            this.f11769a.a(jSONObject, str, context);
        }
    }
}
