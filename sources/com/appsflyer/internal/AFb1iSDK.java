package com.appsflyer.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFb1iSDK {
    @NonNull
    public final String AFInAppEventParameterName;
    public final AFb1mSDK AFInAppEventType;
    private final boolean AFKeystoreWrapper;
    @NonNull
    public final AFf1qSDK valueOf;
    @NonNull
    public final String values;

    public AFb1iSDK() {
    }

    public AFb1iSDK(String str) throws JSONException {
        AFf1qSDK aFf1qSDK;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("ver");
                this.AFInAppEventParameterName = string;
                this.AFKeystoreWrapper = jSONObject.optBoolean("test_mode");
                this.values = str;
                if (string.startsWith("default")) {
                    aFf1qSDK = AFf1qSDK.DEFAULT;
                } else {
                    aFf1qSDK = AFf1qSDK.CUSTOM;
                }
                this.valueOf = aFf1qSDK;
                JSONObject optJSONObject = jSONObject.optJSONObject("features");
                this.AFInAppEventType = optJSONObject != null ? new AFb1mSDK(optJSONObject) : null;
                return;
            } catch (JSONException e8) {
                AFLogger.afErrorLogForExcManagerOnly("Error in RC config parsing", e8);
                throw new JSONException("Failed to parse remote configuration JSON");
            }
        }
        throw new JSONException("Failed to parse remote configuration JSON: originalJson is null");
    }

    public static Uri values(Activity activity) {
        Uri referrer;
        if (Build.VERSION.SDK_INT >= 22) {
            referrer = activity.getReferrer();
            return referrer;
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AFb1iSDK.class != obj.getClass()) {
            return false;
        }
        AFb1iSDK aFb1iSDK = (AFb1iSDK) obj;
        if (this.AFKeystoreWrapper != aFb1iSDK.AFKeystoreWrapper || !this.AFInAppEventParameterName.equals(aFb1iSDK.AFInAppEventParameterName)) {
            return false;
        }
        return this.values.equals(aFb1iSDK.values);
    }

    public final int hashCode() {
        int hashCode = ((((this.AFKeystoreWrapper ? 1 : 0) * 31) + this.AFInAppEventParameterName.hashCode()) * 31) + this.values.hashCode();
        AFb1mSDK aFb1mSDK = this.AFInAppEventType;
        if (aFb1mSDK != null) {
            return (hashCode * 31) + aFb1mSDK.hashCode();
        }
        return hashCode;
    }
}
