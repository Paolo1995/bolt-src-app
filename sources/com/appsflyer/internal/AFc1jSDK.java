package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class AFc1jSDK<ResponseBody> {
    private final AFc1fSDK AFInAppEventParameterName;
    private final AtomicBoolean AFInAppEventType = new AtomicBoolean(false);
    public final AFc1rSDK AFKeystoreWrapper;
    private final ExecutorService valueOf;
    private final AFc1cSDK<ResponseBody> values;

    public AFc1jSDK(AFc1rSDK aFc1rSDK, ExecutorService executorService, AFc1fSDK aFc1fSDK, AFc1cSDK<ResponseBody> aFc1cSDK) {
        this.AFKeystoreWrapper = aFc1rSDK;
        this.valueOf = executorService;
        this.AFInAppEventParameterName = aFc1fSDK;
        this.values = aFc1cSDK;
    }

    public final AFd1zSDK<ResponseBody> AFInAppEventParameterName() throws IOException {
        if (!this.AFInAppEventType.getAndSet(true)) {
            AFd1zSDK<String> AFKeystoreWrapper = this.AFInAppEventParameterName.AFKeystoreWrapper(this.AFKeystoreWrapper);
            try {
                return new AFd1zSDK<>(this.values.valueOf(AFKeystoreWrapper.getBody()), AFKeystoreWrapper.AFInAppEventParameterName, AFKeystoreWrapper.AFInAppEventType, AFKeystoreWrapper.values, AFKeystoreWrapper.valueOf);
            } catch (JSONException e8) {
                AFLogger.afErrorLogForExcManagerOnly("could not parse raw response - execute", e8);
                throw new ParsingException(e8.getMessage(), e8, AFKeystoreWrapper);
            }
        }
        throw new IllegalStateException("Http call is already executed");
    }
}
