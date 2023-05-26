package com.appsflyer.internal;

import android.net.TrafficStats;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class AFd1pSDK<Result> implements Comparable<AFd1pSDK<?>>, Callable<AFd1tSDK> {
    private static final AtomicInteger afErrorLog = new AtomicInteger();
    public volatile int AFInAppEventParameterName;
    @NonNull
    public final AFd1rSDK AFInAppEventType;
    @NonNull
    public final Set<AFd1rSDK> AFKeystoreWrapper;
    private long AFLogger;
    private boolean AFLogger$LogLevel;
    private final int afDebugLog;
    private Throwable afInfoLog;
    private final String afRDLog;
    public AFd1tSDK valueOf;
    @NonNull
    public final Set<AFd1rSDK> values;

    public AFd1pSDK(@NonNull AFd1rSDK aFd1rSDK, @NonNull AFd1rSDK[] aFd1rSDKArr, String str) {
        HashSet hashSet = new HashSet();
        this.values = hashSet;
        this.AFKeystoreWrapper = new HashSet();
        int incrementAndGet = afErrorLog.incrementAndGet();
        this.afDebugLog = incrementAndGet;
        this.AFLogger$LogLevel = false;
        this.AFInAppEventParameterName = 0;
        this.AFInAppEventType = aFd1rSDK;
        Collections.addAll(hashSet, aFd1rSDKArr);
        if (str != null) {
            this.afRDLog = str;
        } else {
            this.afRDLog = String.valueOf(incrementAndGet);
        }
    }

    public void AFInAppEventParameterName() {
        this.AFLogger$LogLevel = true;
    }

    protected void AFInAppEventParameterName(Throwable th) {
    }

    @NonNull
    protected abstract AFd1tSDK AFInAppEventType() throws Exception;

    @Override // java.lang.Comparable
    /* renamed from: AFKeystoreWrapper */
    public final int compareTo(AFd1pSDK<?> aFd1pSDK) {
        int i8 = this.AFInAppEventType.AppsFlyer2dXConversionCallback - aFd1pSDK.AFInAppEventType.AppsFlyer2dXConversionCallback;
        if (i8 == 0) {
            if (this.afRDLog.equals(aFd1pSDK.afRDLog)) {
                return 0;
            }
            return this.afDebugLog - aFd1pSDK.afDebugLog;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean AFKeystoreWrapper();

    @Override // java.util.concurrent.Callable
    /* renamed from: afDebugLog */
    public final AFd1tSDK call() throws Exception {
        TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
        this.valueOf = null;
        this.afInfoLog = null;
        long currentTimeMillis = System.currentTimeMillis();
        this.AFInAppEventParameterName++;
        try {
            AFd1tSDK AFInAppEventType = AFInAppEventType();
            this.valueOf = AFInAppEventType;
            return AFInAppEventType;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean afErrorLog() {
        return this.AFLogger$LogLevel;
    }

    public final Throwable afInfoLog() {
        return this.afInfoLog;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFd1pSDK aFd1pSDK = (AFd1pSDK) obj;
        if (this.AFInAppEventType != aFd1pSDK.AFInAppEventType) {
            return false;
        }
        return this.afRDLog.equals(aFd1pSDK.afRDLog);
    }

    public final int hashCode() {
        return (this.AFInAppEventType.hashCode() * 31) + this.afRDLog.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.AFInAppEventType);
        sb.append("-");
        sb.append(this.afRDLog);
        String obj = sb.toString();
        if (!String.valueOf(this.afDebugLog).equals(this.afRDLog)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append("-");
            sb2.append(this.afDebugLog);
            return sb2.toString();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long valueOf();

    protected void values() {
    }
}
