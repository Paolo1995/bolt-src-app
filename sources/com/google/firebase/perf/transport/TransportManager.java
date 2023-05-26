package com.google.firebase.perf.transport;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class TransportManager implements AppStateMonitor.AppStateCallback {

    /* renamed from: u  reason: collision with root package name */
    private static final AndroidLogger f16842u = AndroidLogger.e();

    /* renamed from: v  reason: collision with root package name */
    private static final TransportManager f16843v = new TransportManager();

    /* renamed from: f  reason: collision with root package name */
    private FirebaseApp f16844f;

    /* renamed from: g  reason: collision with root package name */
    private FirebasePerformance f16845g;

    /* renamed from: h  reason: collision with root package name */
    private FirebaseInstallationsApi f16846h;

    /* renamed from: i  reason: collision with root package name */
    private Provider<TransportFactory> f16847i;

    /* renamed from: j  reason: collision with root package name */
    private FlgTransport f16848j;

    /* renamed from: m  reason: collision with root package name */
    private Context f16851m;

    /* renamed from: n  reason: collision with root package name */
    private ConfigResolver f16852n;

    /* renamed from: o  reason: collision with root package name */
    private RateLimiter f16853o;

    /* renamed from: p  reason: collision with root package name */
    private AppStateMonitor f16854p;

    /* renamed from: s  reason: collision with root package name */
    private final Map<String, Integer> f16857s;

    /* renamed from: q  reason: collision with root package name */
    private final AtomicBoolean f16855q = new AtomicBoolean(false);

    /* renamed from: r  reason: collision with root package name */
    private boolean f16856r = false;

    /* renamed from: t  reason: collision with root package name */
    private final ConcurrentLinkedQueue<PendingPerfEvent> f16858t = new ConcurrentLinkedQueue<>();

    /* renamed from: k  reason: collision with root package name */
    private ExecutorService f16849k = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: l  reason: collision with root package name */
    private final ApplicationInfo.Builder f16850l = ApplicationInfo.newBuilder();

    private TransportManager() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f16857s = concurrentHashMap;
        concurrentHashMap.put("KEY_AVAILABLE_TRACES_FOR_CACHING", 50);
        concurrentHashMap.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", 50);
        concurrentHashMap.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", 50);
    }

    private void A() {
        if (this.f16852n.I()) {
            if (this.f16850l.u() && !this.f16856r) {
                return;
            }
            String str = null;
            try {
                str = (String) Tasks.await(this.f16846h.getId(), 60000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e8) {
                f16842u.d("Task to retrieve Installation Id is interrupted: %s", e8.getMessage());
            } catch (ExecutionException e9) {
                f16842u.d("Unable to retrieve Installation Id: %s", e9.getMessage());
            } catch (TimeoutException e10) {
                f16842u.d("Task to retrieve Installation Id is timed out: %s", e10.getMessage());
            }
            if (!TextUtils.isEmpty(str)) {
                this.f16850l.z(str);
            } else {
                f16842u.i("Firebase Installation Id is empty, contact Firebase Support for debugging.");
            }
        }
    }

    private void B() {
        if (this.f16845g == null && o()) {
            this.f16845g = FirebasePerformance.c();
        }
    }

    private void b(PerfMetric perfMetric) {
        f16842u.g("Logging %s", h(perfMetric));
        this.f16848j.b(perfMetric);
    }

    private void c() {
        this.f16854p.j(new WeakReference<>(f16843v));
        this.f16850l.B(this.f16844f.m().c()).x(AndroidApplicationInfo.newBuilder().u(this.f16851m.getPackageName()).v(BuildConfig.f16644b).x(j(this.f16851m)));
        this.f16855q.set(true);
        while (!this.f16858t.isEmpty()) {
            PendingPerfEvent poll = this.f16858t.poll();
            if (poll != null) {
                this.f16849k.execute(TransportManager$$Lambda$2.a(this, poll));
            }
        }
    }

    private Map<String, String> d() {
        B();
        FirebasePerformance firebasePerformance = this.f16845g;
        if (firebasePerformance != null) {
            return firebasePerformance.b();
        }
        return Collections.emptyMap();
    }

    public static TransportManager e() {
        return f16843v;
    }

    private static String f(GaugeMetric gaugeMetric) {
        return String.format(Locale.ENGLISH, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", Boolean.valueOf(gaugeMetric.hasGaugeMetadata()), Integer.valueOf(gaugeMetric.getCpuMetricReadingsCount()), Integer.valueOf(gaugeMetric.getAndroidMemoryReadingsCount()));
    }

    private static String g(NetworkRequestMetric networkRequestMetric) {
        long j8;
        String str;
        if (networkRequestMetric.hasTimeToResponseCompletedUs()) {
            j8 = networkRequestMetric.getTimeToResponseCompletedUs();
        } else {
            j8 = 0;
        }
        if (networkRequestMetric.hasHttpResponseCode()) {
            str = String.valueOf(networkRequestMetric.getHttpResponseCode());
        } else {
            str = "UNKNOWN";
        }
        return String.format(Locale.ENGLISH, "network request trace: %s (responseCode: %s, responseTime: %.4fms)", networkRequestMetric.getUrl(), str, Double.valueOf(j8 / 1000.0d));
    }

    private static String h(PerfMetricOrBuilder perfMetricOrBuilder) {
        if (perfMetricOrBuilder.hasTraceMetric()) {
            return i(perfMetricOrBuilder.getTraceMetric());
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric()) {
            return g(perfMetricOrBuilder.getNetworkRequestMetric());
        }
        if (perfMetricOrBuilder.hasGaugeMetric()) {
            return f(perfMetricOrBuilder.getGaugeMetric());
        }
        return "log";
    }

    private static String i(TraceMetric traceMetric) {
        return String.format(Locale.ENGLISH, "trace metric: %s (duration: %.4fms)", traceMetric.getName(), Double.valueOf(traceMetric.getDurationUs() / 1000.0d));
    }

    private static String j(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str == null) {
                return "";
            }
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    private void k(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            this.f16854p.e(Constants$CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        } else if (perfMetric.hasNetworkRequestMetric()) {
            this.f16854p.e(Constants$CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        }
    }

    private boolean m(PerfMetricOrBuilder perfMetricOrBuilder) {
        int intValue = this.f16857s.get("KEY_AVAILABLE_TRACES_FOR_CACHING").intValue();
        int intValue2 = this.f16857s.get("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING").intValue();
        int intValue3 = this.f16857s.get("KEY_AVAILABLE_GAUGES_FOR_CACHING").intValue();
        if (perfMetricOrBuilder.hasTraceMetric() && intValue > 0) {
            this.f16857s.put("KEY_AVAILABLE_TRACES_FOR_CACHING", Integer.valueOf(intValue - 1));
            return true;
        } else if (perfMetricOrBuilder.hasNetworkRequestMetric() && intValue2 > 0) {
            this.f16857s.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", Integer.valueOf(intValue2 - 1));
            return true;
        } else if (perfMetricOrBuilder.hasGaugeMetric() && intValue3 > 0) {
            this.f16857s.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", Integer.valueOf(intValue3 - 1));
            return true;
        } else {
            f16842u.b("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", h(perfMetricOrBuilder), Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
            return false;
        }
    }

    private boolean n(PerfMetric perfMetric) {
        if (!this.f16852n.I()) {
            f16842u.g("Performance collection is not enabled, dropping %s", h(perfMetric));
            return false;
        } else if (!perfMetric.getApplicationInfo().hasAppInstanceId()) {
            f16842u.j("App Instance ID is null or empty, dropping %s", h(perfMetric));
            return false;
        } else if (!PerfMetricValidator.b(perfMetric, this.f16851m)) {
            f16842u.j("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", h(perfMetric));
            return false;
        } else if (this.f16853o.b(perfMetric)) {
            return true;
        } else {
            k(perfMetric);
            if (perfMetric.hasTraceMetric()) {
                f16842u.g("Rate Limited - %s", i(perfMetric.getTraceMetric()));
            } else if (perfMetric.hasNetworkRequestMetric()) {
                f16842u.g("Rate Limited - %s", g(perfMetric.getNetworkRequestMetric()));
            }
            return false;
        }
    }

    private PerfMetric x(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        A();
        ApplicationInfo.Builder A = this.f16850l.A(applicationProcessState);
        if (builder.hasTraceMetric()) {
            A = A.clone().v(d());
        }
        return builder.u(A).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.f16851m = this.f16844f.j();
        this.f16852n = ConfigResolver.f();
        this.f16853o = new RateLimiter(this.f16851m, 100.0d, 500L);
        this.f16854p = AppStateMonitor.b();
        this.f16848j = new FlgTransport(this.f16847i, this.f16852n.a());
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        if (!o()) {
            if (m(builder)) {
                f16842u.b("Transport is not initialized yet, %s will be queued for to be dispatched later", h(builder));
                this.f16858t.add(new PendingPerfEvent(builder, applicationProcessState));
                return;
            }
            return;
        }
        PerfMetric x7 = x(builder, applicationProcessState);
        if (n(x7)) {
            b(x7);
            SessionManager.getInstance().updatePerfSessionIfExpired();
        }
    }

    public void l(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseInstallationsApi firebaseInstallationsApi, @NonNull Provider<TransportFactory> provider) {
        this.f16844f = firebaseApp;
        this.f16846h = firebaseInstallationsApi;
        this.f16847i = provider;
        this.f16849k.execute(TransportManager$$Lambda$1.a(this));
    }

    public boolean o() {
        return this.f16855q.get();
    }

    @Override // com.google.firebase.perf.internal.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        boolean z7;
        if (applicationProcessState == ApplicationProcessState.FOREGROUND) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f16856r = z7;
        if (o()) {
            this.f16849k.execute(TransportManager$$Lambda$3.a(this));
        }
    }

    public void u(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        this.f16849k.execute(TransportManager$$Lambda$6.a(this, gaugeMetric, applicationProcessState));
    }

    public void v(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        this.f16849k.execute(TransportManager$$Lambda$5.a(this, networkRequestMetric, applicationProcessState));
    }

    public void w(TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        this.f16849k.execute(TransportManager$$Lambda$4.a(this, traceMetric, applicationProcessState));
    }
}
