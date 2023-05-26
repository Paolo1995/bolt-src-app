package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFf1kSDK;
import com.appsflyer.internal.AFf1pSDK;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class AFf1pSDK extends AFf1nSDK {
    @NonNull
    private final ExecutorService AFInAppEventParameterName;
    public final Map<String, Object> AFKeystoreWrapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.appsflyer.internal.AFf1pSDK$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements InstallReferrerStateListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ InstallReferrerClient val$referrerClient;

        AnonymousClass1(InstallReferrerClient installReferrerClient, Context context) {
            this.val$referrerClient = installReferrerClient;
            this.val$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInstallReferrerSetupFinished$0(InstallReferrerClient installReferrerClient, Context context, int i8) {
            AFf1pSDK.values(AFf1pSDK.this, installReferrerClient, context, i8);
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public final void onInstallReferrerServiceDisconnected() {
            AFLogger.afDebugLog("Install Referrer service disconnected");
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public final void onInstallReferrerSetupFinished(final int i8) {
            ExecutorService executorService = AFf1pSDK.this.AFInAppEventParameterName;
            final InstallReferrerClient installReferrerClient = this.val$referrerClient;
            final Context context = this.val$context;
            executorService.execute(new Runnable() { // from class: com.appsflyer.internal.r
                @Override // java.lang.Runnable
                public final void run() {
                    AFf1pSDK.AnonymousClass1.this.lambda$onInstallReferrerSetupFinished$0(installReferrerClient, context, i8);
                }
            });
        }
    }

    public AFf1pSDK(@NonNull Runnable runnable, @NonNull ExecutorService executorService) {
        super("store", "google", runnable);
        this.AFKeystoreWrapper = new HashMap();
        this.AFInAppEventParameterName = executorService;
    }

    static /* synthetic */ void values(AFf1pSDK aFf1pSDK, InstallReferrerClient installReferrerClient, Context context, int i8) {
        aFf1pSDK.AFKeystoreWrapper.put("code", String.valueOf(i8));
        aFf1pSDK.AFInAppEventType.put("api_ver", Long.valueOf(AFa1cSDK.AFKeystoreWrapper(context, "com.android.vending")));
        aFf1pSDK.AFInAppEventType.put("api_ver_name", AFa1cSDK.values(context, "com.android.vending"));
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            AFLogger.afWarnLog("responseCode not found.");
                        } else {
                            AFLogger.afWarnLog("InstallReferrer DEVELOPER_ERROR");
                            aFf1pSDK.AFInAppEventType.put("response", "DEVELOPER_ERROR");
                        }
                    } else {
                        AFLogger.afWarnLog("InstallReferrer FEATURE_NOT_SUPPORTED");
                        aFf1pSDK.AFInAppEventType.put("response", "FEATURE_NOT_SUPPORTED");
                    }
                } else {
                    aFf1pSDK.AFInAppEventType.put("response", "SERVICE_UNAVAILABLE");
                    AFLogger.afWarnLog("InstallReferrer not supported");
                }
            } else {
                aFf1pSDK.AFInAppEventType.put("response", "OK");
                try {
                    AFLogger.afDebugLog("InstallReferrer connected");
                    if (installReferrerClient.isReady()) {
                        ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
                        String installReferrer2 = installReferrer.getInstallReferrer();
                        if (installReferrer2 != null) {
                            aFf1pSDK.AFKeystoreWrapper.put("val", installReferrer2);
                            aFf1pSDK.AFInAppEventType.put("referrer", installReferrer2);
                        }
                        long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                        aFf1pSDK.AFKeystoreWrapper.put("clk", Long.toString(referrerClickTimestampSeconds));
                        aFf1pSDK.AFInAppEventType.put("click_ts", Long.valueOf(referrerClickTimestampSeconds));
                        long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
                        aFf1pSDK.AFKeystoreWrapper.put("install", Long.toString(installBeginTimestampSeconds));
                        aFf1pSDK.AFInAppEventType.put("install_begin_ts", Long.valueOf(installBeginTimestampSeconds));
                        HashMap hashMap = new HashMap();
                        try {
                            boolean googlePlayInstantParam = installReferrer.getGooglePlayInstantParam();
                            aFf1pSDK.AFKeystoreWrapper.put("instant", Boolean.valueOf(googlePlayInstantParam));
                            hashMap.put("instant", Boolean.valueOf(googlePlayInstantParam));
                        } catch (NoSuchMethodError e8) {
                            AFLogger.afErrorLogForExcManagerOnly("getGooglePlayInstantParam not exist", e8);
                        }
                        try {
                            hashMap.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                            hashMap.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                            hashMap.put("install_version", installReferrer.getInstallVersion());
                        } catch (NoSuchMethodError e9) {
                            AFLogger.afErrorLogForExcManagerOnly("some method not exist", e9);
                        }
                        if (!hashMap.isEmpty()) {
                            aFf1pSDK.AFInAppEventType.put("google_custom", hashMap);
                        }
                    } else {
                        AFLogger.afWarnLog("ReferrerClient: InstallReferrer is not ready");
                        aFf1pSDK.AFKeystoreWrapper.put("err", "ReferrerClient: InstallReferrer is not ready");
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                    sb.append(th.getMessage());
                    AFLogger.afWarnLog(sb.toString());
                    aFf1pSDK.AFKeystoreWrapper.put("err", th.getMessage());
                    AFLogger.afErrorLogForExcManagerOnly("Failed to get install referrer", th);
                }
            }
        } else {
            AFLogger.afWarnLog("InstallReferrer SERVICE_DISCONNECTED");
            aFf1pSDK.AFInAppEventType.put("response", "SERVICE_DISCONNECTED");
        }
        AFLogger.afDebugLog("Install Referrer collected locally");
        aFf1pSDK.AFInAppEventType();
        installReferrerClient.endConnection();
    }

    @Override // com.appsflyer.internal.AFf1kSDK
    public final void valueOf(Context context) {
        if (!AFInAppEventParameterName(context)) {
            return;
        }
        this.afInfoLog = System.currentTimeMillis();
        this.afRDLog = AFf1kSDK.AFa1wSDK.STARTED;
        addObserver(new AFf1kSDK.AnonymousClass2());
        try {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
            AFLogger.afDebugLog("Connecting to Install Referrer Library...");
            build.startConnection(new AnonymousClass1(build, context));
        } catch (Throwable th) {
            AFLogger.afErrorLog("referrerClient -> startConnection", th);
        }
    }

    private static boolean AFInAppEventParameterName(@NonNull Context context) {
        if (AFf1nSDK.AFKeystoreWrapper(context)) {
            try {
                if (AFa1cSDK.AFInAppEventParameterName(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                    AFLogger.afDebugLog("Install referrer is allowed");
                    return true;
                }
                AFLogger.afDebugLog("Install referrer is not allowed");
                return false;
            } catch (ClassNotFoundException e8) {
                AFLogger.afErrorLogForExcManagerOnly("InstallReferrerClient not found", e8);
                StringBuilder sb = new StringBuilder("Class ");
                sb.append("com.android.installreferrer.api.InstallReferrerClient");
                sb.append(" not found");
                AFLogger.afRDLog(sb.toString());
                return false;
            } catch (Throwable th) {
                AFLogger.afErrorLog("An error occurred while trying to verify manifest : ".concat("com.android.installreferrer.api.InstallReferrerClient"), th);
                return false;
            }
        }
        return false;
    }
}
