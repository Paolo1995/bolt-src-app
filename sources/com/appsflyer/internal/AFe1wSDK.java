package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import java.io.InterruptedIOException;

/* loaded from: classes.dex */
public final class AFe1wSDK extends AFd1pSDK<AFe1vSDK> {
    public AFb1cSDK AFLogger;
    private final AFe1sSDK AFLogger$LogLevel;
    private final AFe1qSDK AFVersionDeclaration;
    private final AFc1zSDK afDebugLog;
    public final AFe1xSDK afErrorLog;
    private final String afErrorLogForExcManagerOnly;
    private final AFe1ySDK afInfoLog;
    public AFe1vSDK afRDLog;
    private final AFc1kSDK afWarnLog;
    private final AFe1nSDK getLevel;

    public AFe1wSDK(@NonNull AFe1ySDK aFe1ySDK, @NonNull AFc1zSDK aFc1zSDK, @NonNull AFe1nSDK aFe1nSDK, @NonNull AFe1qSDK aFe1qSDK, @NonNull AFc1kSDK aFc1kSDK, @NonNull AFe1sSDK aFe1sSDK, @NonNull String str, AFe1xSDK aFe1xSDK) {
        super(AFd1rSDK.RC_CDN, new AFd1rSDK[0], "UpdateRemoteConfiguration");
        this.afRDLog = null;
        this.afInfoLog = aFe1ySDK;
        this.afDebugLog = aFc1zSDK;
        this.getLevel = aFe1nSDK;
        this.AFVersionDeclaration = aFe1qSDK;
        this.afWarnLog = aFc1kSDK;
        this.AFLogger$LogLevel = aFe1sSDK;
        this.afErrorLogForExcManagerOnly = str;
        this.afErrorLog = aFe1xSDK;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.appsflyer.internal.AFe1vSDK AFLogger() throws java.lang.InterruptedException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1wSDK.AFLogger():com.appsflyer.internal.AFe1vSDK");
    }

    private void values(String str, long j8, AFf1tSDK aFf1tSDK, String str2, AFd1zSDK<AFb1iSDK> aFd1zSDK) {
        AFb1iSDK aFb1iSDK;
        String str3;
        if (aFd1zSDK != null) {
            aFb1iSDK = aFd1zSDK.getBody();
        } else {
            aFb1iSDK = null;
        }
        if (str2 != null) {
            str3 = str2;
        } else {
            str3 = null;
        }
        AFInAppEventType(str, j8, aFd1zSDK, aFb1iSDK, aFf1tSDK, str3, null);
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        try {
            AFe1vSDK AFLogger = AFLogger();
            this.afRDLog = AFLogger;
            if (AFLogger == AFe1vSDK.FAILURE) {
                return AFd1tSDK.FAILURE;
            }
            return AFd1tSDK.SUCCESS;
        } catch (InterruptedIOException | InterruptedException e8) {
            AFLogger.afErrorLogForExcManagerOnly("RC update config failed", e8);
            this.afRDLog = AFe1vSDK.FAILURE;
            return AFd1tSDK.TIMEOUT;
        }
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final boolean AFKeystoreWrapper() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1pSDK
    public final long valueOf() {
        return 1500L;
    }

    private void AFInAppEventType(String str, long j8, AFd1zSDK<?> aFd1zSDK, AFb1iSDK aFb1iSDK, AFf1tSDK aFf1tSDK, String str2, Throwable th) {
        long j9;
        int i8;
        Throwable th2;
        long j10;
        if (aFd1zSDK != null) {
            j9 = aFd1zSDK.valueOf.AFInAppEventType;
            i8 = aFd1zSDK.getStatusCode();
        } else {
            j9 = 0;
            i8 = 0;
        }
        if (th instanceof HttpException) {
            th2 = th.getCause();
            j10 = ((HttpException) th).getMetrics().AFInAppEventType;
        } else {
            th2 = th;
            j10 = j9;
        }
        this.AFLogger = new AFb1cSDK(aFb1iSDK != null ? aFb1iSDK.AFInAppEventParameterName : null, str, j10, System.currentTimeMillis() - j8, i8, aFf1tSDK, str2, th2);
    }
}
