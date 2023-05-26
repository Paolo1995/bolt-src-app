package com.clevertap.android.sdk.pushnotification.amp;

import android.app.IntentService;
import android.content.Intent;
import com.clevertap.android.sdk.CleverTapAPI;

/* loaded from: classes.dex */
public class CTBackgroundIntentService extends IntentService {
    public CTBackgroundIntentService() {
        super("CTBackgroundIntentService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        CleverTapAPI.g0(getApplicationContext());
    }
}
