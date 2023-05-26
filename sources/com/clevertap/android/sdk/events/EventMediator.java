package com.clevertap.android.sdk.events;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EventMediator {

    /* renamed from: a  reason: collision with root package name */
    private final CoreMetaData f11168a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11169b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f11170c;

    public EventMediator(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData) {
        this.f11170c = context;
        this.f11169b = cleverTapInstanceConfig;
        this.f11168a = coreMetaData;
    }

    private boolean a() {
        if (((int) (System.currentTimeMillis() / 1000)) - StorageHelper.d(this.f11170c, this.f11169b, "comms_mtd", 0) >= 86400) {
            return false;
        }
        return true;
    }

    public boolean b(JSONObject jSONObject, int i8) {
        if (this.f11169b.s()) {
            return false;
        }
        if (jSONObject.has("evtName")) {
            try {
                if (Arrays.asList(Constants.f10926b).contains(jSONObject.getString("evtName"))) {
                    return false;
                }
            } catch (JSONException unused) {
            }
        }
        if (i8 != 4 || this.f11168a.w()) {
            return false;
        }
        return true;
    }

    public boolean c(JSONObject jSONObject, int i8) {
        String jSONObject2;
        if (i8 == 7) {
            return false;
        }
        if (this.f11168a.y()) {
            if (jSONObject == null) {
                jSONObject2 = "null";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            Logger n8 = this.f11169b.n();
            String c8 = this.f11169b.c();
            n8.f(c8, "Current user is opted out dropping event: " + jSONObject2);
            return true;
        } else if (!a()) {
            return false;
        } else {
            Logger n9 = this.f11169b.n();
            String c9 = this.f11169b.c();
            n9.s(c9, "CleverTap is muted, dropping event - " + jSONObject.toString());
            return true;
        }
    }
}
