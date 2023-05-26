package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.os.Build;
import android.os.Process;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFc1oSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class AFd1dSDK extends AFe1zSDK {
    private static int AFVersionDeclaration = 0;
    private static int AppsFlyer2dXConversionCallback = 1;
    private static int getLevel = 120;
    private final String AFLogger$LogLevel;
    private final AFc1sSDK afErrorLogForExcManagerOnly;

    public AFd1dSDK(@NonNull String str, @NonNull AFc1vSDK aFc1vSDK) {
        super(new AFe1kSDK(aFc1vSDK.AFLogger$LogLevel().AFKeystoreWrapper), aFc1vSDK, str);
        this.afErrorLogForExcManagerOnly = aFc1vSDK.AFLogger$LogLevel();
        this.AFLogger$LogLevel = str;
    }

    private void AFLogger$LogLevel() {
        boolean z7;
        int i8 = AFVersionDeclaration + 67;
        AppsFlyer2dXConversionCallback = i8 % 128;
        if (i8 % 2 == 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            ((AFe1zSDK) this).afWarnLog.AFInAppEventType("sentRegisterRequestToAF", true);
        } else {
            ((AFe1zSDK) this).afWarnLog.AFInAppEventType("sentRegisterRequestToAF", false);
        }
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
    }

    @Override // com.appsflyer.internal.AFe1zSDK, com.appsflyer.internal.AFd1iSDK
    protected final boolean afRDLog() {
        boolean z7;
        int i8 = AppsFlyer2dXConversionCallback + 101;
        AFVersionDeclaration = i8 % 128;
        if (i8 % 2 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return false;
        }
        return true;
    }

    @Override // com.appsflyer.internal.AFd1iSDK, com.appsflyer.internal.AFd1pSDK
    public final void values() {
        super.values();
        ResponseNetwork responseNetwork = this.afErrorLog;
        if (responseNetwork == null) {
            return;
        }
        int i8 = AFVersionDeclaration + 81;
        AppsFlyer2dXConversionCallback = i8 % 128;
        int i9 = i8 % 2;
        if (responseNetwork.isSuccessful()) {
            int i10 = AFVersionDeclaration + 13;
            AppsFlyer2dXConversionCallback = i10 % 128;
            int i11 = i10 % 2;
            AFLogger$LogLevel();
            if (i11 == 0) {
                throw null;
            }
            int i12 = AFVersionDeclaration + 53;
            AppsFlyer2dXConversionCallback = i12 % 128;
            int i13 = i12 % 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.appsflyer.internal.AFe1zSDK
    public final void values(AFa1sSDK aFa1sSDK) {
        super.values(aFa1sSDK);
        Context context = this.afErrorLogForExcManagerOnly.AFKeystoreWrapper;
        AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
        if (context != null) {
            if (!AFInAppEventType.valueOf()) {
                PackageManager packageManager = context.getPackageManager();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                    aFa1sSDK.AFKeystoreWrapper("app_version_code", Integer.toString(packageInfo.versionCode));
                    aFa1sSDK.AFKeystoreWrapper("app_version_name", packageInfo.versionName);
                    aFa1sSDK.AFKeystoreWrapper("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
                    aFa1sSDK.AFKeystoreWrapper("installDate", AFb1xSDK.AFInAppEventType(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), packageInfo.firstInstallTime));
                } catch (Throwable th) {
                    AFLogger.afErrorLog("Exception while collecting application version info.", th);
                }
                AFInAppEventType.AFInAppEventType(context, aFa1sSDK.AFKeystoreWrapper());
                String values = AFb1xSDK.values();
                if (!(values == null)) {
                    aFa1sSDK.AFKeystoreWrapper("appUserId", values);
                    int i8 = AppsFlyer2dXConversionCallback + 113;
                    AFVersionDeclaration = i8 % 128;
                    int i9 = i8 % 2;
                }
                try {
                    aFa1sSDK.AFKeystoreWrapper("model", Build.MODEL);
                    Object[] objArr = new Object[1];
                    values("\ufffb�\u0007\ufffa\u000b", true, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 222 - ImageFormat.getBitsPerPixel(0), 6 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr);
                    aFa1sSDK.AFKeystoreWrapper(((String) objArr[0]).intern(), Build.BRAND);
                } catch (Throwable th2) {
                    AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
                }
                if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                    aFa1sSDK.AFKeystoreWrapper(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
                }
                AFc1oSDK.AFa1xSDK values2 = AFa1bSDK.values(context.getContentResolver());
                if (values2 != null) {
                    int i10 = AppsFlyer2dXConversionCallback + 45;
                    AFVersionDeclaration = i10 % 128;
                    if ((i10 % 2 != 0 ? (char) 29 : '_') != '_') {
                        aFa1sSDK.AFKeystoreWrapper("amazon_aid", values2.AFInAppEventParameterName);
                        aFa1sSDK.AFKeystoreWrapper("amazon_aid_limit", String.valueOf(values2.valueOf));
                        int i11 = 84 / 0;
                    } else {
                        aFa1sSDK.AFKeystoreWrapper("amazon_aid", values2.AFInAppEventParameterName);
                        aFa1sSDK.AFKeystoreWrapper("amazon_aid_limit", String.valueOf(values2.valueOf));
                    }
                }
                String string = AppsFlyerProperties.getInstance().getString("advertiserId");
                if (string != null) {
                    aFa1sSDK.AFKeystoreWrapper("advertiserId", string);
                }
                aFa1sSDK.AFKeystoreWrapper("devkey", ((AFd1iSDK) this).afDebugLog.values);
                aFa1sSDK.AFKeystoreWrapper("uid", AFb1wSDK.AFKeystoreWrapper(new WeakReference(context)));
                aFa1sSDK.AFKeystoreWrapper("af_gcm_token", this.AFLogger$LogLevel);
                aFa1sSDK.AFKeystoreWrapper("launch_counter", Integer.toString(((AFe1zSDK) this).afWarnLog.AFInAppEventType("appsFlyerCount", 0)));
                aFa1sSDK.AFKeystoreWrapper("sdk", Integer.toString(Build.VERSION.SDK_INT));
                String AFInAppEventParameterName = AFInAppEventType.AFInAppEventParameterName(context);
                if ((AFInAppEventParameterName != null ? 'J' : 'a') != 'J') {
                    return;
                }
                aFa1sSDK.AFKeystoreWrapper(AppsFlyerProperties.CHANNEL, AFInAppEventParameterName);
                int i12 = AppsFlyer2dXConversionCallback + 105;
                AFVersionDeclaration = i12 % 128;
                int i13 = i12 % 2;
                return;
            }
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            throw new IllegalStateException("CustomerUserId not set, register is not sent");
        }
        throw new IllegalStateException("Context is not provided, can't send register request");
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r6 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void values(java.lang.String r6, boolean r7, int r8, int r9, int r10, java.lang.Object[] r11) {
        /*
            if (r6 == 0) goto L6
            char[] r6 = r6.toCharArray()
        L6:
            char[] r6 = (char[]) r6
            java.lang.Object r0 = com.appsflyer.internal.AFg1pSDK.values
            monitor-enter(r0)
            char[] r1 = new char[r10]     // Catch: java.lang.Throwable -> L67
            r2 = 0
            com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r2     // Catch: java.lang.Throwable -> L67
        L10:
            int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L67
            if (r3 >= r10) goto L2f
            char r3 = r6[r3]     // Catch: java.lang.Throwable -> L67
            com.appsflyer.internal.AFg1pSDK.AFKeystoreWrapper = r3     // Catch: java.lang.Throwable -> L67
            int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L67
            int r4 = com.appsflyer.internal.AFg1pSDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> L67
            int r4 = r4 + r9
            char r4 = (char) r4     // Catch: java.lang.Throwable -> L67
            r1[r3] = r4     // Catch: java.lang.Throwable -> L67
            int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L67
            char r4 = r1[r3]     // Catch: java.lang.Throwable -> L67
            int r5 = com.appsflyer.internal.AFd1dSDK.getLevel     // Catch: java.lang.Throwable -> L67
            int r4 = r4 - r5
            char r4 = (char) r4     // Catch: java.lang.Throwable -> L67
            r1[r3] = r4     // Catch: java.lang.Throwable -> L67
            int r3 = r3 + 1
            com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r3     // Catch: java.lang.Throwable -> L67
            goto L10
        L2f:
            if (r8 <= 0) goto L46
            com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName = r8     // Catch: java.lang.Throwable -> L67
            char[] r6 = new char[r10]     // Catch: java.lang.Throwable -> L67
            java.lang.System.arraycopy(r1, r2, r6, r2, r10)     // Catch: java.lang.Throwable -> L67
            int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName     // Catch: java.lang.Throwable -> L67
            int r9 = r10 - r8
            java.lang.System.arraycopy(r6, r2, r1, r9, r8)     // Catch: java.lang.Throwable -> L67
            int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName     // Catch: java.lang.Throwable -> L67
            int r9 = r10 - r8
            java.lang.System.arraycopy(r6, r8, r1, r2, r9)     // Catch: java.lang.Throwable -> L67
        L46:
            if (r7 == 0) goto L5e
            char[] r6 = new char[r10]     // Catch: java.lang.Throwable -> L67
            com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r2     // Catch: java.lang.Throwable -> L67
        L4c:
            int r7 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L67
            if (r7 >= r10) goto L5d
            int r8 = r10 - r7
            int r8 = r8 + (-1)
            char r8 = r1[r8]     // Catch: java.lang.Throwable -> L67
            r6[r7] = r8     // Catch: java.lang.Throwable -> L67
            int r7 = r7 + 1
            com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r7     // Catch: java.lang.Throwable -> L67
            goto L4c
        L5d:
            r1 = r6
        L5e:
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L67
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L67
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
            r11[r2] = r6
            return
        L67:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1dSDK.values(java.lang.String, boolean, int, int, int, java.lang.Object[]):void");
    }
}
