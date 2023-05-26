package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;

/* loaded from: classes.dex */
public interface InAppListener {
    void m(CTInAppNotification cTInAppNotification, Bundle bundle, HashMap<String, String> hashMap);

    void r(Context context, CTInAppNotification cTInAppNotification, Bundle bundle);

    void y(CTInAppNotification cTInAppNotification, Bundle bundle);
}
