package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Personalization {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsConnector f17135a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f17136b = DesugarCollections.synchronizedMap(new HashMap());

    public Personalization(@NonNull AnalyticsConnector analyticsConnector) {
        this.f17135a = analyticsConnector;
    }

    public void a(@NonNull String str, @NonNull ConfigContainer configContainer) {
        JSONObject optJSONObject;
        JSONObject f8 = configContainer.f();
        if (f8.length() < 1) {
            return;
        }
        JSONObject d8 = configContainer.d();
        if (d8.length() < 1 || (optJSONObject = f8.optJSONObject(str)) == null) {
            return;
        }
        String optString = optJSONObject.optString("choiceId");
        if (optString.isEmpty()) {
            return;
        }
        synchronized (this.f17136b) {
            if (optString.equals(this.f17136b.get(str))) {
                return;
            }
            this.f17136b.put(str, optString);
            Bundle bundle = new Bundle();
            bundle.putString("arm_key", str);
            bundle.putString("arm_value", d8.optString(str));
            bundle.putString("personalization_id", optJSONObject.optString("personalizationId"));
            bundle.putInt("arm_index", optJSONObject.optInt("armIndex", -1));
            bundle.putString("group", optJSONObject.optString("group"));
            this.f17135a.b("fp", "personalization_assignment", bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString("_fpid", optString);
            this.f17135a.b("fp", "_fpc", bundle2);
        }
    }
}
