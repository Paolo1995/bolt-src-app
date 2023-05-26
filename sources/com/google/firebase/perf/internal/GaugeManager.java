package com.google.firebase.perf.internal;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.gauges.CpuGaugeCollector;
import com.google.firebase.perf.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetric;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Keep
/* loaded from: classes3.dex */
public class GaugeManager {
    private static final long APPROX_NUMBER_OF_DATA_POINTS_PER_GAUGE_METRIC = 20;
    private static final long INVALID_GAUGE_COLLECTION_FREQUENCY = -1;
    private static final long TIME_TO_WAIT_BEFORE_FLUSHING_GAUGES_QUEUE_MS = 20;
    private static final AndroidLogger logger = AndroidLogger.e();
    private static GaugeManager sharedInstance = new GaugeManager();
    private ApplicationProcessState applicationProcessState;
    private final ConfigResolver configResolver;
    private final CpuGaugeCollector cpuGaugeCollector;
    private ScheduledFuture gaugeManagerDataCollectionJob;
    private final ScheduledExecutorService gaugeManagerExecutor;
    private GaugeMetadataManager gaugeMetadataManager;
    private final MemoryGaugeCollector memoryGaugeCollector;
    private String sessionId;
    private final TransportManager transportManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.perf.internal.GaugeManager$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16743a;

        static {
            int[] iArr = new int[ApplicationProcessState.values().length];
            f16743a = iArr;
            try {
                iArr[ApplicationProcessState.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16743a[ApplicationProcessState.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private GaugeManager() {
        this(Executors.newSingleThreadScheduledExecutor(), TransportManager.e(), ConfigResolver.f(), null, CpuGaugeCollector.d(), MemoryGaugeCollector.c());
    }

    private long getCpuGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState) {
        long w7;
        int i8 = AnonymousClass1.f16743a[applicationProcessState.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                w7 = -1;
            } else {
                w7 = this.configResolver.x();
            }
        } else {
            w7 = this.configResolver.w();
        }
        if (CpuGaugeCollector.e(w7)) {
            return -1L;
        }
        return w7;
    }

    private GaugeMetadata getGaugeMetadata() {
        return GaugeMetadata.newBuilder().z(this.gaugeMetadataManager.e()).u(this.gaugeMetadataManager.b()).v(this.gaugeMetadataManager.c()).x(this.gaugeMetadataManager.d()).build();
    }

    public static synchronized GaugeManager getInstance() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            gaugeManager = sharedInstance;
        }
        return gaugeManager;
    }

    private long getMemoryGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState) {
        long z7;
        int i8 = AnonymousClass1.f16743a[applicationProcessState.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                z7 = -1;
            } else {
                z7 = this.configResolver.A();
            }
        } else {
            z7 = this.configResolver.z();
        }
        if (MemoryGaugeCollector.d(z7)) {
            return -1L;
        }
        return z7;
    }

    private boolean startCollectingCpuMetrics(long j8, Timer timer) {
        if (j8 == -1) {
            logger.a("Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.");
            return false;
        }
        this.cpuGaugeCollector.j(j8, timer);
        return true;
    }

    private boolean startCollectingMemoryMetrics(long j8, Timer timer) {
        if (j8 == -1) {
            logger.a("Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.");
            return false;
        }
        this.memoryGaugeCollector.i(j8, timer);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncFlush(String str, ApplicationProcessState applicationProcessState) {
        GaugeMetric.Builder newBuilder = GaugeMetric.newBuilder();
        while (!this.cpuGaugeCollector.f16687f.isEmpty()) {
            newBuilder.v(this.cpuGaugeCollector.f16687f.poll());
        }
        while (!this.memoryGaugeCollector.f16695b.isEmpty()) {
            newBuilder.u(this.memoryGaugeCollector.f16695b.poll());
        }
        newBuilder.z(str);
        this.transportManager.u(newBuilder.build(), applicationProcessState);
    }

    public void collectGaugeMetricOnce(Timer timer) {
        collectGaugeMetricOnce(this.cpuGaugeCollector, this.memoryGaugeCollector, timer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean logGaugeMetadata(String str, ApplicationProcessState applicationProcessState) {
        if (this.gaugeMetadataManager != null) {
            this.transportManager.u(GaugeMetric.newBuilder().z(str).x(getGaugeMetadata()).build(), applicationProcessState);
            return true;
        }
        return false;
    }

    public void setApplicationContext(Context context) {
        this.gaugeMetadataManager = new GaugeMetadataManager(context);
    }

    public void startCollectingGauges(PerfSession perfSession, ApplicationProcessState applicationProcessState) {
        if (this.sessionId != null) {
            stopCollectingGauges();
        }
        long startCollectingGauges = startCollectingGauges(applicationProcessState, perfSession.d());
        if (startCollectingGauges == -1) {
            logger.i("Invalid gauge collection frequency. Unable to start collecting Gauges.");
            return;
        }
        String h8 = perfSession.h();
        this.sessionId = h8;
        this.applicationProcessState = applicationProcessState;
        try {
            long j8 = startCollectingGauges * 20;
            this.gaugeManagerDataCollectionJob = this.gaugeManagerExecutor.scheduleAtFixedRate(GaugeManager$$Lambda$1.a(this, h8, applicationProcessState), j8, j8, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e8) {
            AndroidLogger androidLogger = logger;
            androidLogger.i("Unable to start collecting Gauges: " + e8.getMessage());
        }
    }

    public void stopCollectingGauges() {
        String str = this.sessionId;
        if (str == null) {
            return;
        }
        ApplicationProcessState applicationProcessState = this.applicationProcessState;
        this.cpuGaugeCollector.k();
        this.memoryGaugeCollector.j();
        ScheduledFuture scheduledFuture = this.gaugeManagerDataCollectionJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.gaugeManagerExecutor.schedule(GaugeManager$$Lambda$2.a(this, str, applicationProcessState), 20L, TimeUnit.MILLISECONDS);
        this.sessionId = null;
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
    }

    private static void collectGaugeMetricOnce(CpuGaugeCollector cpuGaugeCollector, MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        cpuGaugeCollector.a(timer);
        memoryGaugeCollector.a(timer);
    }

    GaugeManager(ScheduledExecutorService scheduledExecutorService, TransportManager transportManager, ConfigResolver configResolver, GaugeMetadataManager gaugeMetadataManager, CpuGaugeCollector cpuGaugeCollector, MemoryGaugeCollector memoryGaugeCollector) {
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.sessionId = null;
        this.gaugeManagerDataCollectionJob = null;
        this.gaugeManagerExecutor = scheduledExecutorService;
        this.transportManager = transportManager;
        this.configResolver = configResolver;
        this.gaugeMetadataManager = gaugeMetadataManager;
        this.cpuGaugeCollector = cpuGaugeCollector;
        this.memoryGaugeCollector = memoryGaugeCollector;
    }

    private long startCollectingGauges(ApplicationProcessState applicationProcessState, Timer timer) {
        long cpuGaugeCollectionFrequencyMs = getCpuGaugeCollectionFrequencyMs(applicationProcessState);
        if (!startCollectingCpuMetrics(cpuGaugeCollectionFrequencyMs, timer)) {
            cpuGaugeCollectionFrequencyMs = -1;
        }
        long memoryGaugeCollectionFrequencyMs = getMemoryGaugeCollectionFrequencyMs(applicationProcessState);
        return startCollectingMemoryMetrics(memoryGaugeCollectionFrequencyMs, timer) ? cpuGaugeCollectionFrequencyMs == -1 ? memoryGaugeCollectionFrequencyMs : Math.min(cpuGaugeCollectionFrequencyMs, memoryGaugeCollectionFrequencyMs) : cpuGaugeCollectionFrequencyMs;
    }
}
