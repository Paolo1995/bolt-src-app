package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InboxResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11758a;

    /* renamed from: b  reason: collision with root package name */
    private final BaseCallbackManager f11759b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapResponse f11760c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f11761d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f11762e;

    /* renamed from: f  reason: collision with root package name */
    private final ControllerManager f11763f;

    public InboxResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig, CTLockManager cTLockManager, BaseCallbackManager baseCallbackManager, ControllerManager controllerManager) {
        this.f11760c = cleverTapResponse;
        this.f11761d = cleverTapInstanceConfig;
        this.f11759b = baseCallbackManager;
        this.f11762e = cleverTapInstanceConfig.n();
        this.f11758a = cTLockManager.b();
        this.f11763f = controllerManager;
    }

    private void b(JSONArray jSONArray) {
        synchronized (this.f11758a) {
            if (this.f11763f.e() == null) {
                this.f11763f.j();
            }
            if (this.f11763f.e() != null && this.f11763f.e().o(jSONArray)) {
                this.f11759b.b();
            }
        }
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        if (this.f11761d.p()) {
            this.f11762e.s(this.f11761d.c(), "CleverTap instance is configured to analytics only, not processing inbox messages");
            this.f11760c.a(jSONObject, str, context);
            return;
        }
        this.f11762e.s(this.f11761d.c(), "Inbox: Processing response");
        if (!jSONObject.has("inbox_notifs")) {
            this.f11762e.s(this.f11761d.c(), "Inbox: Response JSON object doesn't contain the inbox key");
            this.f11760c.a(jSONObject, str, context);
            return;
        }
        try {
            b(jSONObject.getJSONArray("inbox_notifs"));
        } catch (Throwable th) {
            this.f11762e.t(this.f11761d.c(), "InboxResponse: Failed to parse response", th);
        }
        this.f11760c.a(jSONObject, str, context);
    }
}
