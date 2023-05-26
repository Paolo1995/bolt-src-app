package com.google.firebase.perf.gauges;

import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class CpuGaugeCollector {

    /* renamed from: g  reason: collision with root package name */
    private static final AndroidLogger f16679g = AndroidLogger.e();

    /* renamed from: h  reason: collision with root package name */
    private static final long f16680h = TimeUnit.SECONDS.toMicros(1);

    /* renamed from: i  reason: collision with root package name */
    private static CpuGaugeCollector f16681i = null;

    /* renamed from: d  reason: collision with root package name */
    private final long f16685d;

    /* renamed from: e  reason: collision with root package name */
    private final String f16686e;

    /* renamed from: a  reason: collision with root package name */
    private ScheduledFuture f16682a = null;

    /* renamed from: c  reason: collision with root package name */
    private long f16684c = -1;

    /* renamed from: f  reason: collision with root package name */
    public final ConcurrentLinkedQueue<CpuMetricReading> f16687f = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f16683b = Executors.newSingleThreadScheduledExecutor();

    private CpuGaugeCollector() {
        int myPid = Process.myPid();
        this.f16686e = "/proc/" + Integer.toString(myPid) + "/stat";
        this.f16685d = c();
    }

    private long b(long j8) {
        return Math.round((j8 / this.f16685d) * f16680h);
    }

    private long c() {
        return Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    public static CpuGaugeCollector d() {
        if (f16681i == null) {
            f16681i = new CpuGaugeCollector();
        }
        return f16681i;
    }

    public static boolean e(long j8) {
        return j8 <= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        CpuMetricReading l8 = cpuGaugeCollector.l(timer);
        if (l8 != null) {
            cpuGaugeCollector.f16687f.add(l8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        CpuMetricReading l8 = cpuGaugeCollector.l(timer);
        if (l8 != null) {
            cpuGaugeCollector.f16687f.add(l8);
        }
    }

    private synchronized void h(Timer timer) {
        try {
            this.f16683b.schedule(CpuGaugeCollector$$Lambda$2.a(this, timer), 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e8) {
            AndroidLogger androidLogger = f16679g;
            androidLogger.i("Unable to collect Cpu Metric: " + e8.getMessage());
        }
    }

    private synchronized void i(long j8, Timer timer) {
        this.f16684c = j8;
        try {
            this.f16682a = this.f16683b.scheduleAtFixedRate(CpuGaugeCollector$$Lambda$1.a(this, timer), 0L, j8, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e8) {
            AndroidLogger androidLogger = f16679g;
            androidLogger.i("Unable to start collecting Cpu Metrics: " + e8.getMessage());
        }
    }

    private CpuMetricReading l(Timer timer) {
        if (timer == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f16686e));
            try {
                long a8 = timer.a();
                String[] split = bufferedReader.readLine().split(" ");
                long parseLong = Long.parseLong(split[13]);
                long parseLong2 = Long.parseLong(split[15]);
                CpuMetricReading build = CpuMetricReading.newBuilder().u(a8).v(b(Long.parseLong(split[14]) + Long.parseLong(split[16]))).x(b(parseLong + parseLong2)).build();
                bufferedReader.close();
                return build;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e8) {
            AndroidLogger androidLogger = f16679g;
            androidLogger.i("Unable to read 'proc/[pid]/stat' file: " + e8.getMessage());
            return null;
        } catch (ArrayIndexOutOfBoundsException e9) {
            e = e9;
            AndroidLogger androidLogger2 = f16679g;
            androidLogger2.i("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        } catch (NullPointerException e10) {
            e = e10;
            AndroidLogger androidLogger22 = f16679g;
            androidLogger22.i("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        } catch (NumberFormatException e11) {
            e = e11;
            AndroidLogger androidLogger222 = f16679g;
            androidLogger222.i("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        }
    }

    public void a(Timer timer) {
        h(timer);
    }

    public void j(long j8, Timer timer) {
        long j9 = this.f16685d;
        if (j9 == -1 || j9 == 0 || e(j8)) {
            return;
        }
        if (this.f16682a != null) {
            if (this.f16684c != j8) {
                k();
                i(j8, timer);
                return;
            }
            return;
        }
        i(j8, timer);
    }

    public void k() {
        ScheduledFuture scheduledFuture = this.f16682a;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f16682a = null;
        this.f16684c = -1L;
    }
}
