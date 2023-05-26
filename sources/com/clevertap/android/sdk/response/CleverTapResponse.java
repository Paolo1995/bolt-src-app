package com.clevertap.android.sdk.response;

import android.content.Context;
import android.util.Log;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class CleverTapResponse {
    public void a(JSONObject jSONObject, String str, Context context) {
        Log.i("CleverTapResponse", "Done processing response!");
    }
}
