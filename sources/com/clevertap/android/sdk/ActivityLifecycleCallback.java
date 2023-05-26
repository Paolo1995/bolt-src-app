package com.clevertap.android.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class ActivityLifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10807a = false;

    @TargetApi(14)
    public static synchronized void a(Application application) {
        synchronized (ActivityLifecycleCallback.class) {
            b(application, null);
        }
    }

    @TargetApi(14)
    public static synchronized void b(Application application, final String str) {
        synchronized (ActivityLifecycleCallback.class) {
            if (application == null) {
                Logger.j("Application instance is null/system API is too old");
            } else if (f10807a) {
                Logger.n("Lifecycle callbacks have already been registered");
            } else {
                f10807a = true;
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.clevertap.android.sdk.ActivityLifecycleCallback.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        String str2 = str;
                        if (str2 != null) {
                            CleverTapAPI.R(activity, str2);
                        } else {
                            CleverTapAPI.Q(activity);
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        CleverTapAPI.S();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        String str2 = str;
                        if (str2 != null) {
                            CleverTapAPI.U(activity, str2);
                        } else {
                            CleverTapAPI.T(activity);
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }
                });
                Logger.j("Activity Lifecycle Callback successfully registered");
            }
        }
    }
}
