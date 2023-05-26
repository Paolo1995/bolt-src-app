package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SettingsJsonParser {

    /* renamed from: a  reason: collision with root package name */
    private final CurrentTimeProvider f16183a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.f16183a = currentTimeProvider;
    }

    private static SettingsJsonTransform a(int i8) {
        if (i8 != 3) {
            Logger f8 = Logger.f();
            f8.d("Could not determine SettingsJsonTransform for settings version " + i8 + ". Using default settings values.");
            return new DefaultSettingsJsonTransform();
        }
        return new SettingsV3JsonTransform();
    }

    public Settings b(JSONObject jSONObject) throws JSONException {
        return a(jSONObject.getInt("settings_version")).a(this.f16183a, jSONObject);
    }
}
