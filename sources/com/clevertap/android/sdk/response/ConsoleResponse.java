package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ConsoleResponse extends CleverTapResponseDecorator {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapResponse f11734a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11735b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f11736c;

    public ConsoleResponse(CleverTapResponse cleverTapResponse, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f11734a = cleverTapResponse;
        this.f11735b = cleverTapInstanceConfig;
        this.f11736c = cleverTapInstanceConfig.n();
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponse
    public void a(JSONObject jSONObject, String str, Context context) {
        int i8;
        try {
            if (jSONObject.has("console")) {
                JSONArray jSONArray = (JSONArray) jSONObject.get("console");
                if (jSONArray.length() > 0) {
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        this.f11736c.f(this.f11735b.c(), jSONArray.get(i9).toString());
                    }
                }
            }
        } catch (Throwable unused) {
        }
        try {
            if (jSONObject.has("dbg_lvl") && (i8 = jSONObject.getInt("dbg_lvl")) >= 0) {
                CleverTapAPI.k0(i8);
                Logger logger = this.f11736c;
                String c8 = this.f11735b.c();
                logger.s(c8, "Set debug level to " + i8 + " for this session (set by upstream)");
            }
        } catch (Throwable unused2) {
        }
        this.f11734a.a(jSONObject, str, context);
    }
}
