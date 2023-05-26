package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class AFd1iSDK<Result> extends AFd1pSDK<AFd1zSDK<Result>> {
    protected final AFc1kSDK AFLogger;
    public final AFe1nSDK afDebugLog;
    public AFd1zSDK<Result> afErrorLog;
    protected final AFb1sSDK afInfoLog;
    private AFb1zSDK afRDLog;
    private String afWarnLog;

    private AFd1iSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @NonNull AFc1kSDK aFc1kSDK, @NonNull AFe1nSDK aFe1nSDK, @NonNull AFb1sSDK aFb1sSDK, @NonNull AFb1zSDK aFb1zSDK, String str) {
        super(aFd1rSDK, aFd1rSDKArr, str);
        this.AFLogger = aFc1kSDK;
        this.afDebugLog = aFe1nSDK;
        this.afInfoLog = aFb1sSDK;
        this.afRDLog = aFb1zSDK;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final void AFInAppEventParameterName() {
        String str;
        super.AFInAppEventParameterName();
        if (!afRDLog() || (str = this.afDebugLog.values) == null || str.trim().isEmpty()) {
            return;
        }
        AFKeystoreWrapper(AFInAppEventType(str).AFKeystoreWrapper);
    }

    protected abstract AFc1jSDK<Result> AFInAppEventType(@NonNull String str);

    @Override // com.appsflyer.internal.AFd1pSDK
    @NonNull
    public AFd1tSDK AFInAppEventType() throws Exception {
        if (getLevel() && this.afDebugLog.AFInAppEventParameterName()) {
            AppsFlyerRequestListener AFLogger = AFLogger();
            if (AFLogger != null) {
                AFLogger.onError(RequestError.STOP_TRACKING, AFb1aSDK.AFInAppEventType);
            }
            throw new AFd1jSDK();
        }
        String str = this.afDebugLog.values;
        if (str != null && !str.trim().isEmpty()) {
            AFc1jSDK<Result> AFInAppEventType = AFInAppEventType(str);
            if (afRDLog()) {
                AFKeystoreWrapper(AFInAppEventType.AFKeystoreWrapper);
            }
            AFd1zSDK<Result> AFInAppEventParameterName = AFInAppEventType.AFInAppEventParameterName();
            this.afErrorLog = AFInAppEventParameterName;
            this.afInfoLog.AFKeystoreWrapper(AFInAppEventType.AFKeystoreWrapper.valueOf(), AFInAppEventParameterName.getStatusCode(), AFInAppEventParameterName.getBody().toString());
            AppsFlyerRequestListener AFLogger2 = AFLogger();
            if (AFLogger2 != null) {
                if (AFInAppEventParameterName.isSuccessful()) {
                    AFLogger2.onSuccess();
                } else {
                    int i8 = RequestError.RESPONSE_CODE_FAILURE;
                    StringBuilder sb = new StringBuilder();
                    sb.append(AFb1aSDK.AFInAppEventParameterName);
                    sb.append(" ");
                    sb.append(AFInAppEventParameterName.getStatusCode());
                    AFLogger2.onError(i8, sb.toString());
                }
            }
            if (AFInAppEventParameterName.isSuccessful()) {
                return AFd1tSDK.SUCCESS;
            }
            return AFd1tSDK.FAILURE;
        }
        AppsFlyerRequestListener AFLogger3 = AFLogger();
        if (AFLogger3 != null) {
            AFLogger3.onError(RequestError.NO_DEV_KEY, AFb1aSDK.valueOf);
        }
        throw new AFd1qSDK();
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public boolean AFKeystoreWrapper() {
        if (afInfoLog() instanceof AFd1jSDK) {
            return false;
        }
        if (this.valueOf == AFd1tSDK.TIMEOUT) {
            return true;
        }
        Throwable afInfoLog = afInfoLog();
        return (afInfoLog instanceof IOException) && !(afInfoLog instanceof ParsingException);
    }

    protected abstract AppsFlyerRequestListener AFLogger();

    protected abstract boolean afRDLog();

    protected boolean getLevel() {
        return true;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public long valueOf() {
        return 60000L;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public void values() {
        String str;
        if (this.valueOf == AFd1tSDK.SUCCESS) {
            String str2 = this.afWarnLog;
            if (str2 != null) {
                this.afRDLog.AFKeystoreWrapper(str2);
            }
        } else if (!AFKeystoreWrapper() && (str = this.afWarnLog) != null) {
            this.afRDLog.AFKeystoreWrapper(str);
        }
    }

    public AFd1iSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @NonNull AFc1vSDK aFc1vSDK, String str) {
        this(aFd1rSDK, aFd1rSDKArr, aFc1vSDK.AFInAppEventType(), aFc1vSDK.getLevel(), aFc1vSDK.afErrorLogForExcManagerOnly(), aFc1vSDK.afWarnLog(), str);
    }

    private void AFKeystoreWrapper(AFc1rSDK aFc1rSDK) {
        String str = this.afWarnLog;
        this.afWarnLog = this.afRDLog.AFInAppEventType(new AFa1oSDK(aFc1rSDK.valueOf(), aFc1rSDK.AFInAppEventType(), "6.10.2", this.AFInAppEventType));
        if (str != null) {
            this.afRDLog.AFKeystoreWrapper(str);
        }
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final void AFInAppEventParameterName(Throwable th) {
        AFLogger.afErrorLog("Error while sending request to server: ".concat(String.valueOf(th)), th, true);
        AppsFlyerRequestListener AFLogger = AFLogger();
        if (AFLogger != null) {
            String message = th.getMessage();
            int i8 = RequestError.NETWORK_FAILURE;
            if (message == null) {
                message = "";
            }
            AFLogger.onError(i8, message);
        }
    }

    public AFd1iSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, @NonNull AFc1vSDK aFc1vSDK, String str, String str2) {
        this(aFd1rSDK, aFd1rSDKArr, aFc1vSDK.AFInAppEventType(), aFc1vSDK.getLevel(), aFc1vSDK.afErrorLogForExcManagerOnly(), aFc1vSDK.afWarnLog(), str);
        this.afWarnLog = str2;
    }
}
