package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class AFe1qSDK {
    public static final Charset AFInAppEventType = Charset.forName("UTF-8");
    public final AFc1ySDK AFInAppEventParameterName;
    public long AFKeystoreWrapper;
    public AFb1iSDK valueOf = values();
    public long values;

    public AFe1qSDK(AFc1ySDK aFc1ySDK) {
        this.AFInAppEventParameterName = aFc1ySDK;
        this.AFKeystoreWrapper = aFc1ySDK.AFInAppEventParameterName("af_rc_timestamp", 0L);
        this.values = aFc1ySDK.AFInAppEventParameterName("af_rc_max_age", 0L);
    }

    private AFb1iSDK values() {
        String values = this.AFInAppEventParameterName.values("af_remote_config", null);
        if (values == null) {
            AFLogger.afDebugLog("CFG: No configuration found in cache");
            return null;
        }
        try {
            return new AFb1iSDK(new String(Base64.decode(values, 2), AFInAppEventType));
        } catch (Exception e8) {
            AFLogger.afErrorLog("CFG: Error reading malformed configuration from cache, requires fetching from remote again", e8, true);
            return null;
        }
    }
}
