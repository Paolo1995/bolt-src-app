package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFf1kSDK;
import com.miui.referrer.api.GetAppsReferrerClient;
import com.miui.referrer.api.GetAppsReferrerDetails;
import com.miui.referrer.api.GetAppsReferrerStateListener;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class AFf1gSDK extends AFf1nSDK {
    public AFf1gSDK(Runnable runnable) {
        super("store", "xiaomi", runnable);
    }

    private static boolean AFInAppEventType(@NonNull Context context) {
        if (!AFf1nSDK.AFKeystoreWrapper(context)) {
            return false;
        }
        try {
            Class.forName("com.miui.referrer.api.GetAppsReferrerClient");
            AFLogger.afDebugLog("Xiaomi Install Referrer is allowed");
            return true;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Class ");
            sb.append("com.miui.referrer.api.GetAppsReferrerClient");
            sb.append(" not found");
            AFLogger.afRDLog(sb.toString());
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to access GetAppsReferrerClient", th);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFf1kSDK
    public final void valueOf(final Context context) {
        if (!AFInAppEventType(context)) {
            return;
        }
        this.afInfoLog = System.currentTimeMillis();
        this.afRDLog = AFf1kSDK.AFa1wSDK.STARTED;
        addObserver(new AFf1kSDK.AnonymousClass2());
        final GetAppsReferrerClient build = GetAppsReferrerClient.Companion.newBuilder(context).build();
        build.startConnection(new GetAppsReferrerStateListener() { // from class: com.appsflyer.internal.AFf1gSDK.1
            public final void onGetAppsReferrerSetupFinished(int i8) {
                AFf1gSDK.this.AFInAppEventType.put("api_ver", Long.valueOf(AFa1cSDK.AFKeystoreWrapper(context, "com.xiaomi.mipicks")));
                AFf1gSDK.this.AFInAppEventType.put("api_ver_name", AFa1cSDK.values(context, "com.xiaomi.mipicks"));
                if (i8 != -1) {
                    if (i8 != 0) {
                        if (i8 != 1) {
                            if (i8 != 2) {
                                if (i8 != 3) {
                                    if (i8 != 4) {
                                        AFLogger.afWarnLog("responseCode not found.");
                                    } else {
                                        AFLogger.afWarnLog("XiaomiInstallReferrer DEVELOPER_ERROR");
                                        AFf1gSDK.this.AFInAppEventType.put("response", "PERMISSION_ERROR");
                                    }
                                } else {
                                    AFLogger.afWarnLog("XiaomiInstallReferrer DEVELOPER_ERROR");
                                    AFf1gSDK.this.AFInAppEventType.put("response", "DEVELOPER_ERROR");
                                }
                            } else {
                                AFLogger.afWarnLog("XiaomiInstallReferrer FEATURE_NOT_SUPPORTED");
                                AFf1gSDK.this.AFInAppEventType.put("response", "FEATURE_NOT_SUPPORTED");
                            }
                        } else {
                            AFf1gSDK.this.AFInAppEventType.put("response", "SERVICE_UNAVAILABLE");
                            AFLogger.afWarnLog("XiaomiInstallReferrer not supported");
                        }
                    } else {
                        AFf1gSDK aFf1gSDK = AFf1gSDK.this;
                        GetAppsReferrerClient getAppsReferrerClient = build;
                        aFf1gSDK.AFInAppEventType.put("response", "OK");
                        try {
                            AFLogger.afDebugLog("XiaomiInstallReferrer connected");
                            if (getAppsReferrerClient.isReady()) {
                                GetAppsReferrerDetails installReferrer = getAppsReferrerClient.getInstallReferrer();
                                String installReferrer2 = installReferrer.getInstallReferrer();
                                if (installReferrer2 != null) {
                                    aFf1gSDK.AFInAppEventType.put("referrer", installReferrer2);
                                }
                                aFf1gSDK.AFInAppEventType.put("click_ts", Long.valueOf(installReferrer.getReferrerClickTimestampSeconds()));
                                aFf1gSDK.AFInAppEventType.put("install_begin_ts", Long.valueOf(installReferrer.getInstallBeginTimestampSeconds()));
                                HashMap hashMap = new HashMap();
                                hashMap.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                                hashMap.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                                hashMap.put("install_version", installReferrer.getInstallVersion());
                                aFf1gSDK.AFInAppEventType.put("xiaomi_custom", hashMap);
                            } else {
                                AFLogger.afWarnLog("XiaomiReferrerClient: XiaomiInstallReferrer is not ready");
                            }
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder("Failed to get Xiaomi install referrer: ");
                            sb.append(th.getMessage());
                            AFLogger.afWarnLog(sb.toString());
                        }
                    }
                } else {
                    AFLogger.afWarnLog("XiaomiInstallReferrer SERVICE_DISCONNECTED");
                    AFf1gSDK.this.AFInAppEventType.put("response", "SERVICE_DISCONNECTED");
                }
                AFLogger.afDebugLog("Xiaomi Install Referrer collected locally");
                AFf1gSDK.this.AFInAppEventType();
                build.endConnection();
            }

            public final void onGetAppsServiceDisconnected() {
            }
        });
    }
}
