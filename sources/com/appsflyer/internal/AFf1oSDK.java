package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.internal.AFf1kSDK;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AFf1oSDK extends AFf1kSDK {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AFf1oSDK(String str, String str2, Runnable runnable) {
        super(str, str2, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void AFInAppEventType(Context context, AFb1jSDK<Map<String, Object>> aFb1jSDK) {
        if (AFb1xSDK.AFInAppEventType().valueOf(AFb1xSDK.AFKeystoreWrapper(context), false) <= 0 && aFb1jSDK.AFInAppEventParameterName()) {
            aFb1jSDK.AFKeystoreWrapper.AFKeystoreWrapper().execute(aFb1jSDK.valueOf);
            this.afInfoLog = System.currentTimeMillis();
            this.afRDLog = AFf1kSDK.AFa1wSDK.STARTED;
            addObserver(new AFf1kSDK.AnonymousClass2());
        }
    }
}
