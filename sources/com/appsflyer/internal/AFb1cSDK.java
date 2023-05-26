package com.appsflyer.internal;

import android.app.Application;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class AFb1cSDK {
    public static Application AFKeystoreWrapper;
    public long AFInAppEventParameterName;
    public String AFInAppEventType;
    public AFf1tSDK AFLogger;
    public String afDebugLog;
    public Throwable afInfoLog;
    public int afRDLog;
    public long valueOf;
    @NonNull
    public String values;

    public AFb1cSDK() {
    }

    public AFb1cSDK(String str, String str2, long j8, long j9, int i8, AFf1tSDK aFf1tSDK, String str3, Throwable th) {
        this.AFInAppEventType = str;
        this.values = str2;
        this.AFInAppEventParameterName = j8;
        this.valueOf = j9;
        this.afRDLog = i8;
        this.AFLogger = aFf1tSDK;
        this.afDebugLog = str3;
        this.afInfoLog = th;
    }
}
