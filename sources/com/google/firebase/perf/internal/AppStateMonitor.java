package com.google.firebase.perf.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.core.app.FrameMetricsAggregator;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes3.dex */
public class AppStateMonitor implements Application.ActivityLifecycleCallbacks {

    /* renamed from: u  reason: collision with root package name */
    private static final AndroidLogger f16712u = AndroidLogger.e();

    /* renamed from: v  reason: collision with root package name */
    private static volatile AppStateMonitor f16713v;

    /* renamed from: g  reason: collision with root package name */
    private final TransportManager f16715g;

    /* renamed from: i  reason: collision with root package name */
    private final Clock f16717i;

    /* renamed from: l  reason: collision with root package name */
    private Timer f16720l;

    /* renamed from: m  reason: collision with root package name */
    private Timer f16721m;

    /* renamed from: r  reason: collision with root package name */
    private boolean f16726r;

    /* renamed from: s  reason: collision with root package name */
    private FrameMetricsAggregator f16727s;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16714f = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16718j = true;

    /* renamed from: k  reason: collision with root package name */
    private final WeakHashMap<Activity, Boolean> f16719k = new WeakHashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private final Map<String, Long> f16722n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    private AtomicInteger f16723o = new AtomicInteger(0);

    /* renamed from: p  reason: collision with root package name */
    private ApplicationProcessState f16724p = ApplicationProcessState.BACKGROUND;

    /* renamed from: q  reason: collision with root package name */
    private Set<WeakReference<AppStateCallback>> f16725q = new HashSet();

    /* renamed from: t  reason: collision with root package name */
    private final WeakHashMap<Activity, Trace> f16728t = new WeakHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private ConfigResolver f16716h = ConfigResolver.f();

    /* loaded from: classes3.dex */
    public interface AppStateCallback {
        void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }

    AppStateMonitor(TransportManager transportManager, Clock clock) {
        this.f16726r = false;
        this.f16715g = transportManager;
        this.f16717i = clock;
        boolean d8 = d();
        this.f16726r = d8;
        if (d8) {
            this.f16727s = new FrameMetricsAggregator();
        }
    }

    public static AppStateMonitor b() {
        if (f16713v == null) {
            synchronized (AppStateMonitor.class) {
                if (f16713v == null) {
                    f16713v = new AppStateMonitor(TransportManager.e(), new Clock());
                }
            }
        }
        return f16713v;
    }

    public static String c(Activity activity) {
        return "_st_" + activity.getClass().getSimpleName();
    }

    private boolean d() {
        return true;
    }

    private boolean h(Activity activity) {
        if (this.f16726r && activity.getWindow() != null && (activity.getWindow().getAttributes().flags & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0) {
            return true;
        }
        return false;
    }

    private void k(Activity activity) {
        Trace trace;
        int i8;
        int i9;
        SparseIntArray sparseIntArray;
        if (!this.f16728t.containsKey(activity) || (trace = this.f16728t.get(activity)) == null) {
            return;
        }
        this.f16728t.remove(activity);
        SparseIntArray[] b8 = this.f16727s.b(activity);
        int i10 = 0;
        if (b8 != null && (sparseIntArray = b8[0]) != null) {
            int i11 = 0;
            i8 = 0;
            i9 = 0;
            while (i10 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i10);
                int valueAt = sparseIntArray.valueAt(i10);
                i11 += valueAt;
                if (keyAt > 700) {
                    i9 += valueAt;
                }
                if (keyAt > 16) {
                    i8 += valueAt;
                }
                i10++;
            }
            i10 = i11;
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (i10 > 0) {
            trace.putMetric(Constants$CounterNames.FRAMES_TOTAL.toString(), i10);
        }
        if (i8 > 0) {
            trace.putMetric(Constants$CounterNames.FRAMES_SLOW.toString(), i8);
        }
        if (i9 > 0) {
            trace.putMetric(Constants$CounterNames.FRAMES_FROZEN.toString(), i9);
        }
        if (Utils.b(activity.getApplicationContext())) {
            AndroidLogger androidLogger = f16712u;
            androidLogger.a("sendScreenTrace name:" + c(activity) + " _fr_tot:" + i10 + " _fr_slo:" + i8 + " _fr_fzn:" + i9);
        }
        trace.stop();
    }

    private void l(String str, Timer timer, Timer timer2) {
        if (!this.f16716h.I()) {
            return;
        }
        TraceMetric.Builder x7 = TraceMetric.newBuilder().G(str).D(timer.d()).E(timer.c(timer2)).x(SessionManager.getInstance().perfSession().a());
        int andSet = this.f16723o.getAndSet(0);
        synchronized (this.f16722n) {
            x7.A(this.f16722n);
            if (andSet != 0) {
                x7.C(Constants$CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), andSet);
            }
            this.f16722n.clear();
        }
        this.f16715g.w(x7.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    private void n(ApplicationProcessState applicationProcessState) {
        this.f16724p = applicationProcessState;
        synchronized (this.f16725q) {
            Iterator<WeakReference<AppStateCallback>> it = this.f16725q.iterator();
            while (it.hasNext()) {
                AppStateCallback appStateCallback = it.next().get();
                if (appStateCallback != null) {
                    appStateCallback.onUpdateAppState(this.f16724p);
                } else {
                    it.remove();
                }
            }
        }
    }

    public ApplicationProcessState a() {
        return this.f16724p;
    }

    public void e(@NonNull String str, long j8) {
        synchronized (this.f16722n) {
            Long l8 = this.f16722n.get(str);
            if (l8 == null) {
                this.f16722n.put(str, Long.valueOf(j8));
            } else {
                this.f16722n.put(str, Long.valueOf(l8.longValue() + j8));
            }
        }
    }

    public void f(int i8) {
        this.f16723o.addAndGet(i8);
    }

    public boolean g() {
        return this.f16718j;
    }

    public synchronized void i(Context context) {
        if (this.f16714f) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.f16714f = true;
        }
    }

    public void j(WeakReference<AppStateCallback> weakReference) {
        synchronized (this.f16725q) {
            this.f16725q.add(weakReference);
        }
    }

    public void m(WeakReference<AppStateCallback> weakReference) {
        synchronized (this.f16725q) {
            this.f16725q.remove(weakReference);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        if (this.f16719k.isEmpty()) {
            this.f16721m = this.f16717i.a();
            this.f16719k.put(activity, Boolean.TRUE);
            n(ApplicationProcessState.FOREGROUND);
            if (this.f16718j) {
                this.f16718j = false;
            } else {
                l(Constants$TraceNames.BACKGROUND_TRACE_NAME.toString(), this.f16720l, this.f16721m);
            }
        } else {
            this.f16719k.put(activity, Boolean.TRUE);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (h(activity) && this.f16716h.I()) {
            this.f16727s.a(activity);
            Trace trace = new Trace(c(activity), this.f16715g, this.f16717i, this);
            trace.start();
            this.f16728t.put(activity, trace);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
        if (h(activity)) {
            k(activity);
        }
        if (this.f16719k.containsKey(activity)) {
            this.f16719k.remove(activity);
            if (this.f16719k.isEmpty()) {
                this.f16720l = this.f16717i.a();
                n(ApplicationProcessState.BACKGROUND);
                l(Constants$TraceNames.FOREGROUND_TRACE_NAME.toString(), this.f16721m, this.f16720l);
            }
        }
    }
}
