package com.clevertap.android.sdk.response;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapResponse f11751a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11752b;

    /* renamed from: c  reason: collision with root package name */
    private final ControllerManager f11753c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11754d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f11755e;

    public InAppResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig, ControllerManager controllerManager, boolean z7) {
        this.f11751a = cleverTapResponse;
        this.f11752b = cleverTapInstanceConfig;
        this.f11755e = cleverTapInstanceConfig.n();
        this.f11753c = controllerManager;
        this.f11754d = z7;
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, final Context context) {
        int i8;
        try {
        } catch (Throwable th) {
            Logger.q("InAppManager: Failed to parse response", th);
        }
        if (this.f11752b.p()) {
            this.f11755e.s(this.f11752b.c(), "CleverTap instance is configured to analytics only, not processing inapp messages");
            this.f11751a.a(jSONObject, str, context);
            return;
        }
        this.f11755e.s(this.f11752b.c(), "InApp: Processing response");
        if (!jSONObject.has("inapp_notifs")) {
            this.f11755e.s(this.f11752b.c(), "InApp: Response JSON object doesn't contain the inapp key, failing");
            this.f11751a.a(jSONObject, str, context);
            return;
        }
        int i9 = 10;
        if (jSONObject.has("imc") && (jSONObject.get("imc") instanceof Integer)) {
            i8 = jSONObject.getInt("imc");
        } else {
            i8 = 10;
        }
        if (jSONObject.has("imp") && (jSONObject.get("imp") instanceof Integer)) {
            i9 = jSONObject.getInt("imp");
        }
        if (!this.f11754d && this.f11753c.h() != null) {
            Logger.n("Updating InAppFC Limits");
            this.f11753c.h().w(context, i9, i8);
            this.f11753c.h().u(context, jSONObject);
        } else {
            this.f11755e.s(this.f11752b.c(), "controllerManager.getInAppFCManager() is NULL, not Updating InAppFC Limits");
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("inapp_notifs");
            SharedPreferences.Editor edit = StorageHelper.g(context).edit();
            JSONArray jSONArray2 = new JSONArray(StorageHelper.k(context, this.f11752b, "inApp", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    try {
                        jSONArray2.put(jSONArray.getJSONObject(i10));
                    } catch (JSONException unused) {
                        Logger.n("InAppManager: Malformed inapp notification");
                    }
                }
            }
            edit.putString(StorageHelper.s(this.f11752b, "inApp"), jSONArray2.toString());
            StorageHelper.l(edit);
            CTExecutorFactory.a(this.f11752b).d("TAG_FEATURE_IN_APPS").d("InAppResponse#processResponse", new Callable<Void>() { // from class: com.clevertap.android.sdk.response.InAppResponse.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    InAppResponse.this.f11753c.g().u(context);
                    return null;
                }
            });
            this.f11751a.a(jSONObject, str, context);
        } catch (JSONException unused2) {
            this.f11755e.f(this.f11752b.c(), "InApp: In-app key didn't contain a valid JSON array");
            this.f11751a.a(jSONObject, str, context);
        }
    }
}
