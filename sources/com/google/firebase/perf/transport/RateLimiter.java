package com.google.firebase.perf.transport;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RateLimiter {

    /* renamed from: a  reason: collision with root package name */
    private final float f16825a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16826b;

    /* renamed from: c  reason: collision with root package name */
    private RateLimiterImpl f16827c;

    /* renamed from: d  reason: collision with root package name */
    private RateLimiterImpl f16828d;

    /* renamed from: e  reason: collision with root package name */
    private final ConfigResolver f16829e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RateLimiterImpl {

        /* renamed from: k  reason: collision with root package name */
        private static final AndroidLogger f16830k = AndroidLogger.e();

        /* renamed from: l  reason: collision with root package name */
        private static final long f16831l = TimeUnit.SECONDS.toMicros(1);

        /* renamed from: a  reason: collision with root package name */
        private long f16832a;

        /* renamed from: b  reason: collision with root package name */
        private double f16833b;

        /* renamed from: c  reason: collision with root package name */
        private Timer f16834c;

        /* renamed from: d  reason: collision with root package name */
        private long f16835d;

        /* renamed from: e  reason: collision with root package name */
        private final Clock f16836e;

        /* renamed from: f  reason: collision with root package name */
        private double f16837f;

        /* renamed from: g  reason: collision with root package name */
        private long f16838g;

        /* renamed from: h  reason: collision with root package name */
        private double f16839h;

        /* renamed from: i  reason: collision with root package name */
        private long f16840i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f16841j;

        RateLimiterImpl(double d8, long j8, Clock clock, ConfigResolver configResolver, String str, boolean z7) {
            this.f16836e = clock;
            this.f16832a = j8;
            this.f16833b = d8;
            this.f16835d = j8;
            this.f16834c = clock.a();
            g(configResolver, str, z7);
            this.f16841j = z7;
        }

        private static long c(ConfigResolver configResolver, String str) {
            if (str == "Trace") {
                return configResolver.C();
            }
            return configResolver.o();
        }

        private static long d(ConfigResolver configResolver, String str) {
            if (str == "Trace") {
                return configResolver.r();
            }
            return configResolver.r();
        }

        private static long e(ConfigResolver configResolver, String str) {
            if (str == "Trace") {
                return configResolver.D();
            }
            return configResolver.p();
        }

        private static long f(ConfigResolver configResolver, String str) {
            if (str == "Trace") {
                return configResolver.r();
            }
            return configResolver.r();
        }

        private void g(ConfigResolver configResolver, String str, boolean z7) {
            long f8 = f(configResolver, str);
            long e8 = e(configResolver, str);
            double d8 = e8 / f8;
            this.f16837f = d8;
            this.f16838g = e8;
            if (z7) {
                f16830k.b("Foreground %s logging rate:%f, burst capacity:%d", str, Double.valueOf(d8), Long.valueOf(this.f16838g));
            }
            long d9 = d(configResolver, str);
            long c8 = c(configResolver, str);
            double d10 = c8 / d9;
            this.f16839h = d10;
            this.f16840i = c8;
            if (z7) {
                f16830k.b("Background %s logging rate:%f, capacity:%d", str, Double.valueOf(d10), Long.valueOf(this.f16840i));
            }
        }

        synchronized void a(boolean z7) {
            double d8;
            long j8;
            if (z7) {
                d8 = this.f16837f;
            } else {
                d8 = this.f16839h;
            }
            this.f16833b = d8;
            if (z7) {
                j8 = this.f16838g;
            } else {
                j8 = this.f16840i;
            }
            this.f16832a = j8;
        }

        synchronized boolean b(@NonNull PerfMetric perfMetric) {
            Timer a8 = this.f16836e.a();
            long min = Math.min(this.f16835d + Math.max(0L, (long) ((this.f16834c.c(a8) * this.f16833b) / f16831l)), this.f16832a);
            this.f16835d = min;
            if (min > 0) {
                this.f16835d = min - 1;
                this.f16834c = a8;
                return true;
            }
            if (this.f16841j) {
                f16830k.i("Exceeded log rate limit, dropping the log.");
            }
            return false;
        }
    }

    public RateLimiter(@NonNull Context context, double d8, long j8) {
        this(d8, j8, new Clock(), c(), ConfigResolver.f());
        this.f16826b = Utils.b(context);
    }

    @VisibleForTesting
    static float c() {
        return new Random().nextFloat();
    }

    private boolean d(List<PerfSession> list) {
        if (list.size() <= 0 || list.get(0).getSessionVerbosityCount() <= 0 || list.get(0).getSessionVerbosity(0) != SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
            return false;
        }
        return true;
    }

    private boolean e() {
        if (this.f16825a < this.f16829e.q()) {
            return true;
        }
        return false;
    }

    private boolean f() {
        if (this.f16825a < this.f16829e.E()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z7) {
        this.f16827c.a(z7);
        this.f16828d.a(z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric() && !f() && !d(perfMetric.getTraceMetric().getPerfSessionsList())) {
            return false;
        }
        if (perfMetric.hasNetworkRequestMetric() && !e() && !d(perfMetric.getNetworkRequestMetric().getPerfSessionsList())) {
            return false;
        }
        if (!g(perfMetric)) {
            return true;
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            return this.f16828d.b(perfMetric);
        }
        if (!perfMetric.hasTraceMetric()) {
            return false;
        }
        return this.f16827c.b(perfMetric);
    }

    boolean g(@NonNull PerfMetric perfMetric) {
        if ((perfMetric.hasTraceMetric() && ((perfMetric.getTraceMetric().getName().equals(Constants$TraceNames.FOREGROUND_TRACE_NAME.toString()) || perfMetric.getTraceMetric().getName().equals(Constants$TraceNames.BACKGROUND_TRACE_NAME.toString())) && perfMetric.getTraceMetric().getCountersCount() > 0)) || perfMetric.hasGaugeMetric()) {
            return false;
        }
        return true;
    }

    RateLimiter(double d8, long j8, Clock clock, float f8, ConfigResolver configResolver) {
        boolean z7 = false;
        this.f16826b = false;
        this.f16827c = null;
        this.f16828d = null;
        if (0.0f <= f8 && f8 < 1.0f) {
            z7 = true;
        }
        Utils.a(z7, "Sampling bucket ID should be in range [0.0f, 1.0f).");
        this.f16825a = f8;
        this.f16829e = configResolver;
        this.f16827c = new RateLimiterImpl(d8, j8, clock, configResolver, "Trace", this.f16826b);
        this.f16828d = new RateLimiterImpl(d8, j8, clock, configResolver, "Network", this.f16826b);
    }
}
