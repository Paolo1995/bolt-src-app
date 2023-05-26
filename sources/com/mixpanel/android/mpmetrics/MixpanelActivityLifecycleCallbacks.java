package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.mixpanel.android.viewcrawler.GestureTracker;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
/* loaded from: classes3.dex */
public class MixpanelActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    /* renamed from: m  reason: collision with root package name */
    private static Double f19264m;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f19266g;

    /* renamed from: j  reason: collision with root package name */
    private final MixpanelAPI f19269j;

    /* renamed from: k  reason: collision with root package name */
    private final MPConfig f19270k;

    /* renamed from: l  reason: collision with root package name */
    private WeakReference<Activity> f19271l;

    /* renamed from: f  reason: collision with root package name */
    private Handler f19265f = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    private boolean f19267h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19268i = true;

    public MixpanelActivityLifecycleCallbacks(MixpanelAPI mixpanelAPI, MPConfig mPConfig) {
        this.f19269j = mixpanelAPI;
        this.f19270k = mPConfig;
        if (f19264m == null) {
            f19264m = Double.valueOf(System.currentTimeMillis());
        }
    }

    private void i(Intent intent) {
        if (intent != null && intent.hasExtra("mp_campaign_id") && intent.hasExtra("mp_message_id")) {
            MixpanelAPI.Y(this.f19269j.w(), intent, "$app_open");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity g() {
        WeakReference<Activity> weakReference = this.f19271l;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        return this.f19267h;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f19268i = true;
        Runnable runnable = this.f19266g;
        if (runnable != null) {
            this.f19265f.removeCallbacks(runnable);
        }
        this.f19271l = null;
        Handler handler = this.f19265f;
        Runnable runnable2 = new Runnable() { // from class: com.mixpanel.android.mpmetrics.MixpanelActivityLifecycleCallbacks.1
            @Override // java.lang.Runnable
            public void run() {
                if (MixpanelActivityLifecycleCallbacks.this.f19267h && MixpanelActivityLifecycleCallbacks.this.f19268i) {
                    MixpanelActivityLifecycleCallbacks.this.f19267h = false;
                    try {
                        double currentTimeMillis = System.currentTimeMillis() - MixpanelActivityLifecycleCallbacks.f19264m.doubleValue();
                        if (currentTimeMillis >= MixpanelActivityLifecycleCallbacks.this.f19270k.u() && currentTimeMillis < MixpanelActivityLifecycleCallbacks.this.f19270k.D()) {
                            double round = Math.round((currentTimeMillis / 1000.0d) * 10.0d) / 10.0d;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("$ae_session_length", round);
                            MixpanelActivityLifecycleCallbacks.this.f19269j.C().m("$ae_total_app_sessions", 1.0d);
                            MixpanelActivityLifecycleCallbacks.this.f19269j.C().m("$ae_total_app_session_length", round);
                            MixpanelActivityLifecycleCallbacks.this.f19269j.W("$ae_session", jSONObject, true);
                        }
                    } catch (JSONException e8) {
                        e8.printStackTrace();
                    }
                    MixpanelActivityLifecycleCallbacks.this.f19269j.J();
                }
            }
        };
        this.f19266g = runnable2;
        handler.postDelayed(runnable2, 500L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.f19270k.a()) {
            this.f19269j.C().f();
        }
        this.f19271l = new WeakReference<>(activity);
        this.f19268i = false;
        boolean z7 = !this.f19267h;
        this.f19267h = true;
        Runnable runnable = this.f19266g;
        if (runnable != null) {
            this.f19265f.removeCallbacks(runnable);
        }
        if (z7) {
            f19264m = Double.valueOf(System.currentTimeMillis());
            this.f19269j.K();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        i(activity.getIntent());
        if (this.f19270k.a()) {
            this.f19269j.C().j(activity);
        }
        new GestureTracker(this.f19269j, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
