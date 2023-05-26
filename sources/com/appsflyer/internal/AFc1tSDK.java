package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class AFc1tSDK implements AFc1vSDK {
    private ExecutorService AFInAppEventParameterName;
    private ExecutorService AFInAppEventType;
    private PurchaseHandler AFLogger;
    private AFd1sSDK AFLogger$LogLevel;
    private AFf1jSDK AFVersionDeclaration;
    private AFb1bSDK AppsFlyer2dXConversionCallback;
    private ScheduledExecutorService afDebugLog;
    private AFc1zSDK afErrorLog;
    private AFb1sSDK afErrorLogForExcManagerOnly;
    private AFb1rSDK afInfoLog;
    private CreateOneLinkHttpTask afRDLog;
    private AFe1jSDK afWarnLog;
    private AFe1nSDK getLevel;
    private AFc1qSDK init;
    private AFf1uSDK onAppOpenAttributionNative;
    private AFa1hSDK onDeepLinkingNative;
    private AFd1wSDK onInstallConversionDataLoadedNative;
    private AFb1zSDK onInstallConversionFailureNative;
    private AFa1tSDK onResponseNative;
    public AFb1dSDK values;
    private final int valueOf = (int) TimeUnit.SECONDS.toMillis(30);
    public final AFc1sSDK AFKeystoreWrapper = new AFc1sSDK();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AFa1xSDK implements ThreadFactory {
        private static final AtomicInteger AFInAppEventParameterName = new AtomicInteger();
        private final AtomicInteger valueOf = new AtomicInteger();

        public AFa1xSDK() {
            AFInAppEventParameterName.incrementAndGet();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            int i8 = AFInAppEventParameterName.get();
            int incrementAndGet = this.valueOf.incrementAndGet();
            StringBuilder sb = new StringBuilder("queue-");
            sb.append(i8);
            sb.append("-");
            sb.append(incrementAndGet);
            return new Thread(runnable, sb.toString());
        }
    }

    @NonNull
    private synchronized CreateOneLinkHttpTask onResponseErrorNative() {
        if (this.afRDLog == null) {
            this.afRDLog = new CreateOneLinkHttpTask(new AFc1fSDK(this.valueOf), AFKeystoreWrapper());
        }
        return this.afRDLog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    /* renamed from: onResponseNative */
    public synchronized AFc1qSDK onConversionDataSuccess() {
        if (this.init == null) {
            this.init = new AFc1qSDK(this);
        }
        return this.init;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized ScheduledExecutorService AFInAppEventParameterName() {
        if (this.afDebugLog == null) {
            this.afDebugLog = Executors.newScheduledThreadPool(2);
        }
        return this.afDebugLog;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final AFc1kSDK AFInAppEventType() {
        return new AFc1kSDK(onResponseErrorNative(), values(), AppsFlyerProperties.getInstance(), init());
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized ExecutorService AFKeystoreWrapper() {
        if (this.AFInAppEventParameterName == null) {
            this.AFInAppEventParameterName = Executors.newCachedThreadPool();
        }
        return this.AFInAppEventParameterName;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFe1jSDK AFLogger() {
        if (this.afWarnLog == null) {
            this.afWarnLog = new AFe1jSDK(afInfoLog());
        }
        return this.afWarnLog;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFc1sSDK AFLogger$LogLevel() {
        return this.AFKeystoreWrapper;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFf1jSDK AFVersionDeclaration() {
        if (this.AFVersionDeclaration == null) {
            this.AFVersionDeclaration = new AFf1jSDK();
        }
        return this.AFVersionDeclaration;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final AFf1uSDK AppsFlyer2dXConversionCallback() {
        if (this.onAppOpenAttributionNative == null) {
            this.onAppOpenAttributionNative = new AFf1sSDK();
        }
        return this.onAppOpenAttributionNative;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFd1sSDK afDebugLog() {
        if (this.AFLogger$LogLevel == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 300L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() { // from class: com.appsflyer.internal.AFc1tSDK.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
                /* renamed from: AFKeystoreWrapper */
                public boolean offer(Runnable runnable) {
                    if (isEmpty()) {
                        return super.offer(runnable);
                    }
                    return false;
                }
            }, new AFa1xSDK());
            threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.appsflyer.internal.o
                @Override // java.util.concurrent.RejectedExecutionHandler
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                    AFc1tSDK.AFInAppEventParameterName(runnable, threadPoolExecutor2);
                }
            });
            this.AFLogger$LogLevel = new AFd1sSDK(threadPoolExecutor);
        }
        return this.AFLogger$LogLevel;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized PurchaseHandler afErrorLog() {
        if (this.AFLogger == null) {
            this.AFLogger = new PurchaseHandler(this);
        }
        return this.AFLogger;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFb1sSDK afErrorLogForExcManagerOnly() {
        if (this.afErrorLogForExcManagerOnly == null) {
            this.afErrorLogForExcManagerOnly = new AFb1tSDK();
        }
        return this.afErrorLogForExcManagerOnly;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final AFc1ySDK afInfoLog() {
        Context context = this.AFKeystoreWrapper.AFKeystoreWrapper;
        if (context != null) {
            return new AFc1xSDK(AFb1xSDK.AFKeystoreWrapper(context));
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFb1rSDK afRDLog() {
        if (this.afInfoLog == null) {
            AFe1qSDK aFe1qSDK = new AFe1qSDK(afInfoLog());
            this.afInfoLog = new AFb1rSDK(new AFe1ySDK(), values(), getLevel(), aFe1qSDK, new AFc1kSDK(onResponseErrorNative(), values(), AppsFlyerProperties.getInstance(), init()), new AFe1sSDK(values(), aFe1qSDK), afDebugLog());
        }
        return this.afInfoLog;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFb1zSDK afWarnLog() {
        if (this.onInstallConversionFailureNative == null) {
            this.onInstallConversionFailureNative = new AFc1lSDK(AFLogger$LogLevel());
        }
        return this.onInstallConversionFailureNative;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFe1nSDK getLevel() {
        if (this.getLevel == null) {
            this.getLevel = new AFe1nSDK(AFLogger$LogLevel(), new AFe1pSDK());
        }
        return this.getLevel;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFd1wSDK init() {
        if (this.onInstallConversionDataLoadedNative == null) {
            this.onInstallConversionDataLoadedNative = new AFd1wSDK(values(), afInfoLog());
        }
        return this.onInstallConversionDataLoadedNative;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final AFb1bSDK onAppOpenAttributionNative() {
        if (this.AppsFlyer2dXConversionCallback == null) {
            this.AppsFlyer2dXConversionCallback = new AFa1wSDK();
        }
        return this.AppsFlyer2dXConversionCallback;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final AFb1dSDK onAttributionFailureNative() {
        if (this.values == null) {
            this.values = new AFb1gSDK(valueOf(), onInstallConversionDataLoadedNative());
        }
        return this.values;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFa1tSDK onInstallConversionDataLoadedNative() {
        if (this.onResponseNative == null) {
            this.onResponseNative = new AFa1tSDK();
        }
        return this.onResponseNative;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final AFa1hSDK onInstallConversionFailureNative() {
        if (this.onDeepLinkingNative == null) {
            this.onDeepLinkingNative = new AFa1hSDK();
        }
        return this.onDeepLinkingNative;
    }

    @NonNull
    public final synchronized ExecutorService valueOf() {
        if (this.AFInAppEventType == null) {
            this.AFInAppEventType = Executors.newSingleThreadExecutor();
        }
        return this.AFInAppEventType;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    @NonNull
    public final synchronized AFc1zSDK values() {
        if (this.afErrorLog == null) {
            AFc1sSDK AFLogger$LogLevel = AFLogger$LogLevel();
            Context context = this.AFKeystoreWrapper.AFKeystoreWrapper;
            if (context != null) {
                this.afErrorLog = new AFc1zSDK(AFLogger$LogLevel, new AFc1xSDK(AFb1xSDK.AFKeystoreWrapper(context)));
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.afErrorLog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void AFInAppEventParameterName(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.getQueue().put(runnable);
        } catch (InterruptedException e8) {
            AFLogger.afErrorLogForExcManagerOnly("could not create executor for queue", e8);
            Thread.currentThread().interrupt();
        }
    }
}
