package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks {

    /* renamed from: q  reason: collision with root package name */
    private static final long f16759q = TimeUnit.MINUTES.toMicros(1);

    /* renamed from: r  reason: collision with root package name */
    private static volatile AppStartTrace f16760r;

    /* renamed from: g  reason: collision with root package name */
    private final TransportManager f16762g;

    /* renamed from: h  reason: collision with root package name */
    private final Clock f16763h;

    /* renamed from: i  reason: collision with root package name */
    private Context f16764i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<Activity> f16765j;

    /* renamed from: k  reason: collision with root package name */
    private WeakReference<Activity> f16766k;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16761f = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16767l = false;

    /* renamed from: m  reason: collision with root package name */
    private Timer f16768m = null;

    /* renamed from: n  reason: collision with root package name */
    private Timer f16769n = null;

    /* renamed from: o  reason: collision with root package name */
    private Timer f16770o = null;

    /* renamed from: p  reason: collision with root package name */
    private boolean f16771p = false;

    /* loaded from: classes3.dex */
    public static class StartFromBackgroundRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final AppStartTrace f16772f;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.f16772f = appStartTrace;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f16772f.f16768m == null) {
                this.f16772f.f16771p = true;
            }
        }
    }

    AppStartTrace(@NonNull TransportManager transportManager, @NonNull Clock clock) {
        this.f16762g = transportManager;
        this.f16763h = clock;
    }

    public static AppStartTrace c() {
        if (f16760r != null) {
            return f16760r;
        }
        return d(TransportManager.e(), new Clock());
    }

    static AppStartTrace d(TransportManager transportManager, Clock clock) {
        if (f16760r == null) {
            synchronized (AppStartTrace.class) {
                if (f16760r == null) {
                    f16760r = new AppStartTrace(transportManager, clock);
                }
            }
        }
        return f16760r;
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    public synchronized void e(@NonNull Context context) {
        if (this.f16761f) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.f16761f = true;
            this.f16764i = applicationContext;
        }
    }

    public synchronized void f() {
        if (!this.f16761f) {
            return;
        }
        ((Application) this.f16764i).unregisterActivityLifecycleCallbacks(this);
        this.f16761f = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f16771p && this.f16768m == null) {
            this.f16765j = new WeakReference<>(activity);
            this.f16768m = this.f16763h.a();
            if (FirebasePerfProvider.getAppStartTime().c(this.f16768m) > f16759q) {
                this.f16767l = true;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        if (!this.f16771p && this.f16770o == null && !this.f16767l) {
            this.f16766k = new WeakReference<>(activity);
            this.f16770o = this.f16763h.a();
            Timer appStartTime = FirebasePerfProvider.getAppStartTime();
            AndroidLogger e8 = AndroidLogger.e();
            e8.a("onResume(): " + activity.getClass().getName() + ": " + appStartTime.c(this.f16770o) + " microseconds");
            TraceMetric.Builder E = TraceMetric.newBuilder().G(Constants$TraceNames.APP_START_TRACE_NAME.toString()).D(appStartTime.d()).E(appStartTime.c(this.f16770o));
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(TraceMetric.newBuilder().G(Constants$TraceNames.ON_CREATE_TRACE_NAME.toString()).D(appStartTime.d()).E(appStartTime.c(this.f16768m)).build());
            TraceMetric.Builder newBuilder = TraceMetric.newBuilder();
            newBuilder.G(Constants$TraceNames.ON_START_TRACE_NAME.toString()).D(this.f16768m.d()).E(this.f16768m.c(this.f16769n));
            arrayList.add(newBuilder.build());
            TraceMetric.Builder newBuilder2 = TraceMetric.newBuilder();
            newBuilder2.G(Constants$TraceNames.ON_RESUME_TRACE_NAME.toString()).D(this.f16769n.d()).E(this.f16769n.c(this.f16770o));
            arrayList.add(newBuilder2.build());
            E.v(arrayList).x(SessionManager.getInstance().perfSession().a());
            this.f16762g.w(E.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
            if (this.f16761f) {
                f();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (!this.f16771p && this.f16769n == null && !this.f16767l) {
            this.f16769n = this.f16763h.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
    }
}
