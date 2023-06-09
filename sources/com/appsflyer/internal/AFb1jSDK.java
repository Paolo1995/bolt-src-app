package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class AFb1jSDK<T> {
    private final String[] AFInAppEventParameterName;
    public final String AFInAppEventType;
    public final AFc1vSDK AFKeystoreWrapper;
    public final FutureTask<T> valueOf = new FutureTask<>(new Callable<T>() { // from class: com.appsflyer.internal.AFb1jSDK.1
        @Override // java.util.concurrent.Callable
        public final T call() {
            if (AFb1jSDK.this.AFInAppEventParameterName()) {
                return (T) AFb1jSDK.this.values();
            }
            return null;
        }
    });
    public final Context values;

    public AFb1jSDK(Context context, AFc1vSDK aFc1vSDK, String str, String... strArr) {
        this.values = context;
        this.AFInAppEventType = str;
        this.AFInAppEventParameterName = strArr;
        this.AFKeystoreWrapper = aFc1vSDK;
    }

    public final boolean AFInAppEventParameterName() {
        try {
            ProviderInfo resolveContentProvider = this.values.getPackageManager().resolveContentProvider(this.AFInAppEventType, 128);
            if (resolveContentProvider == null) {
                return false;
            }
            if (!Arrays.asList(this.AFInAppEventParameterName).contains(AFa1cSDK.valueOf(this.values.getPackageManager(), ((PackageItemInfo) resolveContentProvider).packageName))) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e8) {
            AFLogger.afErrorLog(e8.getMessage(), e8);
            return false;
        }
    }

    public T valueOf() {
        try {
            return this.valueOf.get(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e8) {
            AFLogger.afErrorLog(e8.getMessage(), e8);
            return null;
        }
    }

    protected abstract T values();
}
