package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1dSDK;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AFb1fSDK implements Application.ActivityLifecycleCallbacks {
    private final AFa1tSDK AFInAppEventParameterName;
    boolean AFInAppEventType;
    final AFb1dSDK.AFa1wSDK AFKeystoreWrapper;
    private final Executor valueOf;
    private boolean values;

    /* loaded from: classes.dex */
    public static final class AFa1ySDK extends TimerTask {
        private /* synthetic */ Context AFInAppEventParameterName;

        AFa1ySDK(Context context) {
            this.AFInAppEventParameterName = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (AFb1fSDK.this.AFInAppEventType && AFb1fSDK.this.values) {
                AFb1fSDK aFb1fSDK = AFb1fSDK.this;
                aFb1fSDK.AFInAppEventType = false;
                try {
                    aFb1fSDK.AFKeystoreWrapper.AFKeystoreWrapper(this.AFInAppEventParameterName);
                } catch (Exception e8) {
                    AFLogger.afErrorLog("Listener threw exception! ", e8);
                }
            }
        }
    }

    public AFb1fSDK(Executor executor, AFa1tSDK aFa1tSDK, AFb1dSDK.AFa1wSDK aFa1wSDK) {
        Intrinsics.f(executor, "");
        Intrinsics.f(aFa1tSDK, "");
        Intrinsics.f(aFa1wSDK, "");
        this.valueOf = executor;
        this.AFInAppEventParameterName = aFa1tSDK;
        this.AFKeystoreWrapper = aFa1wSDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFKeystoreWrapper(AFb1fSDK aFb1fSDK, Activity activity) {
        Intrinsics.f(aFb1fSDK, "");
        Intrinsics.f(activity, "");
        aFb1fSDK.values = true;
        Context applicationContext = activity.getApplicationContext();
        try {
            Timer timer = new Timer();
            AFa1ySDK aFa1ySDK = new AFa1ySDK(applicationContext);
            AFb1dSDK.AFa1xSDK aFa1xSDK = AFb1dSDK.AFa1xSDK;
            timer.schedule(aFa1ySDK, AFb1dSDK.AFa1xSDK.AFKeystoreWrapper());
        } catch (Throwable th) {
            AFLogger.afErrorLog("Background task failed with a throwable: ", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(final Activity activity, Bundle bundle) {
        Intrinsics.f(activity, "");
        this.valueOf.execute(new Runnable() { // from class: com.appsflyer.internal.c
            @Override // java.lang.Runnable
            public final void run() {
                AFb1fSDK.values(AFb1fSDK.this, activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.f(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(final Activity activity) {
        Intrinsics.f(activity, "");
        this.valueOf.execute(new Runnable() { // from class: com.appsflyer.internal.b
            @Override // java.lang.Runnable
            public final void run() {
                AFb1fSDK.AFKeystoreWrapper(AFb1fSDK.this, activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(final Activity activity) {
        Intrinsics.f(activity, "");
        this.valueOf.execute(new Runnable() { // from class: com.appsflyer.internal.d
            @Override // java.lang.Runnable
            public final void run() {
                AFb1fSDK.AFInAppEventType(AFb1fSDK.this, activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.f(activity, "");
        Intrinsics.f(bundle, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.f(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.f(activity, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFInAppEventType(AFb1fSDK aFb1fSDK, Activity activity) {
        Intrinsics.f(aFb1fSDK, "");
        Intrinsics.f(activity, "");
        if (!aFb1fSDK.AFInAppEventType) {
            try {
                aFb1fSDK.AFKeystoreWrapper.valueOf(activity);
            } catch (Exception e8) {
                AFLogger.afErrorLog("Listener thrown an exception: ", e8, true);
            }
        }
        aFb1fSDK.values = false;
        aFb1fSDK.AFInAppEventType = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void values(AFb1fSDK aFb1fSDK, Activity activity) {
        Intrinsics.f(aFb1fSDK, "");
        Intrinsics.f(activity, "");
        AFa1tSDK aFa1tSDK = aFb1fSDK.AFInAppEventParameterName;
        AFa1tSDK.AFInAppEventParameterName(activity.getIntent());
    }
}
