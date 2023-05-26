package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.displayunits.CTDisplayUnitController;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DisplayUnitResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11737a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final BaseCallbackManager f11738b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapResponse f11739c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f11740d;

    /* renamed from: e  reason: collision with root package name */
    private final ControllerManager f11741e;

    /* renamed from: f  reason: collision with root package name */
    private final Logger f11742f;

    public DisplayUnitResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig, BaseCallbackManager baseCallbackManager, ControllerManager controllerManager) {
        this.f11739c = cleverTapResponse;
        this.f11740d = cleverTapInstanceConfig;
        this.f11742f = cleverTapInstanceConfig.n();
        this.f11738b = baseCallbackManager;
        this.f11741e = controllerManager;
    }

    private void b(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            synchronized (this.f11737a) {
                if (this.f11741e.c() == null) {
                    this.f11741e.k(new CTDisplayUnitController());
                }
            }
            this.f11738b.m(this.f11741e.c().b(jSONArray));
            return;
        }
        this.f11742f.s(this.f11740d.c(), "DisplayUnit : Can't parse Display Units, jsonArray is either empty or null");
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        this.f11742f.s(this.f11740d.c(), "Processing Display Unit items...");
        if (this.f11740d.p()) {
            this.f11742f.s(this.f11740d.c(), "CleverTap instance is configured to analytics only, not processing Display Unit response");
            this.f11739c.a(jSONObject, str, context);
        } else if (jSONObject == null) {
            this.f11742f.s(this.f11740d.c(), "DisplayUnit : Can't parse Display Unit Response, JSON response object is null");
        } else if (!jSONObject.has("adUnit_notifs")) {
            this.f11742f.s(this.f11740d.c(), "DisplayUnit : JSON object doesn't contain the Display Units key");
            this.f11739c.a(jSONObject, str, context);
        } else {
            try {
                this.f11742f.s(this.f11740d.c(), "DisplayUnit : Processing Display Unit response");
                b(jSONObject.getJSONArray("adUnit_notifs"));
            } catch (Throwable th) {
                this.f11742f.t(this.f11740d.c(), "DisplayUnit : Failed to parse response", th);
            }
            this.f11739c.a(jSONObject, str, context);
        }
    }
}
