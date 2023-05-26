package com.google.firebase.perf.gauges;

import android.annotation.SuppressLint;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MemoryGaugeCollector {

    /* renamed from: f  reason: collision with root package name */
    private static final AndroidLogger f16692f = AndroidLogger.e();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    private static final MemoryGaugeCollector f16693g = new MemoryGaugeCollector();

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f16694a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentLinkedQueue<AndroidMemoryReading> f16695b;

    /* renamed from: c  reason: collision with root package name */
    private final Runtime f16696c;

    /* renamed from: d  reason: collision with root package name */
    private ScheduledFuture f16697d;

    /* renamed from: e  reason: collision with root package name */
    private long f16698e;

    private MemoryGaugeCollector() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    private int b() {
        return Utils.c(StorageUnit.BYTES.a(this.f16696c.totalMemory() - this.f16696c.freeMemory()));
    }

    public static MemoryGaugeCollector c() {
        return f16693g;
    }

    public static boolean d(long j8) {
        return j8 <= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        AndroidMemoryReading k8 = memoryGaugeCollector.k(timer);
        if (k8 != null) {
            memoryGaugeCollector.f16695b.add(k8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        AndroidMemoryReading k8 = memoryGaugeCollector.k(timer);
        if (k8 != null) {
            memoryGaugeCollector.f16695b.add(k8);
        }
    }

    private synchronized void g(Timer timer) {
        try {
            this.f16694a.schedule(MemoryGaugeCollector$$Lambda$4.a(this, timer), 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e8) {
            AndroidLogger androidLogger = f16692f;
            androidLogger.i("Unable to collect Memory Metric: " + e8.getMessage());
        }
    }

    private synchronized void h(long j8, Timer timer) {
        this.f16698e = j8;
        try {
            this.f16697d = this.f16694a.scheduleAtFixedRate(MemoryGaugeCollector$$Lambda$1.a(this, timer), 0L, j8, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e8) {
            AndroidLogger androidLogger = f16692f;
            androidLogger.i("Unable to start collecting Memory Metrics: " + e8.getMessage());
        }
    }

    private AndroidMemoryReading k(Timer timer) {
        if (timer == null) {
            return null;
        }
        return AndroidMemoryReading.newBuilder().u(timer.a()).v(b()).build();
    }

    public void a(Timer timer) {
        g(timer);
    }

    public void i(long j8, Timer timer) {
        if (d(j8)) {
            return;
        }
        if (this.f16697d != null) {
            if (this.f16698e != j8) {
                j();
                h(j8, timer);
                return;
            }
            return;
        }
        h(j8, timer);
    }

    public void j() {
        ScheduledFuture scheduledFuture = this.f16697d;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f16697d = null;
        this.f16698e = -1L;
    }

    MemoryGaugeCollector(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.f16697d = null;
        this.f16698e = -1L;
        this.f16694a = scheduledExecutorService;
        this.f16695b = new ConcurrentLinkedQueue<>();
        this.f16696c = runtime;
    }
}
