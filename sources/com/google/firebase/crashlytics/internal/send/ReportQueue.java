package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ReportQueue {

    /* renamed from: a  reason: collision with root package name */
    private final double f16138a;

    /* renamed from: b  reason: collision with root package name */
    private final double f16139b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16140c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16141d;

    /* renamed from: e  reason: collision with root package name */
    private final BlockingQueue<Runnable> f16142e;

    /* renamed from: f  reason: collision with root package name */
    private final ThreadPoolExecutor f16143f;

    /* renamed from: g  reason: collision with root package name */
    private final Transport<CrashlyticsReport> f16144g;

    /* renamed from: h  reason: collision with root package name */
    private final OnDemandCounter f16145h;

    /* renamed from: i  reason: collision with root package name */
    private int f16146i;

    /* renamed from: j  reason: collision with root package name */
    private long f16147j;

    /* loaded from: classes3.dex */
    private final class ReportRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final CrashlyticsReportWithSessionId f16148f;

        /* renamed from: g  reason: collision with root package name */
        private final TaskCompletionSource<CrashlyticsReportWithSessionId> f16149g;

        @Override // java.lang.Runnable
        public void run() {
            ReportQueue.this.m(this.f16148f, this.f16149g);
            ReportQueue.this.f16145h.c();
            double f8 = ReportQueue.this.f();
            Logger f9 = Logger.f();
            f9.b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(f8 / 1000.0d)) + " s for report: " + this.f16148f.d());
            ReportQueue.n(f8);
        }

        private ReportRunnable(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
            this.f16148f = crashlyticsReportWithSessionId;
            this.f16149g = taskCompletionSource;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReportQueue(Transport<CrashlyticsReport> transport, Settings settings, OnDemandCounter onDemandCounter) {
        this(settings.f16162f, settings.f16163g, settings.f16164h * 1000, transport, onDemandCounter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double f() {
        return Math.min(3600000.0d, (60000.0d / this.f16138a) * Math.pow(this.f16139b, g()));
    }

    private int g() {
        int max;
        if (this.f16147j == 0) {
            this.f16147j = l();
        }
        int l8 = (int) ((l() - this.f16147j) / this.f16140c);
        if (j()) {
            max = Math.min(100, this.f16146i + l8);
        } else {
            max = Math.max(0, this.f16146i - l8);
        }
        if (this.f16146i != max) {
            this.f16146i = max;
            this.f16147j = l();
        }
        return max;
    }

    private boolean i() {
        if (this.f16142e.size() < this.f16141d) {
            return true;
        }
        return false;
    }

    private boolean j() {
        if (this.f16142e.size() == this.f16141d) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
        } else {
            taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
        }
    }

    private long l() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
        Logger f8 = Logger.f();
        f8.b("Sending report through Google DataTransport: " + crashlyticsReportWithSessionId.d());
        this.f16144g.a(Event.f(crashlyticsReportWithSessionId.b()), new TransportScheduleCallback() { // from class: com.google.firebase.crashlytics.internal.send.a
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void a(Exception exc) {
                ReportQueue.k(TaskCompletionSource.this, crashlyticsReportWithSessionId, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(double d8) {
        try {
            Thread.sleep((long) d8);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskCompletionSource<CrashlyticsReportWithSessionId> h(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z7) {
        synchronized (this.f16142e) {
            TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource = new TaskCompletionSource<>();
            if (z7) {
                this.f16145h.b();
                if (i()) {
                    Logger f8 = Logger.f();
                    f8.b("Enqueueing report: " + crashlyticsReportWithSessionId.d());
                    Logger f9 = Logger.f();
                    f9.b("Queue size: " + this.f16142e.size());
                    this.f16143f.execute(new ReportRunnable(crashlyticsReportWithSessionId, taskCompletionSource));
                    Logger f10 = Logger.f();
                    f10.b("Closing task for report: " + crashlyticsReportWithSessionId.d());
                    taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                    return taskCompletionSource;
                }
                g();
                Logger f11 = Logger.f();
                f11.b("Dropping report due to queue being full: " + crashlyticsReportWithSessionId.d());
                this.f16145h.a();
                taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                return taskCompletionSource;
            }
            m(crashlyticsReportWithSessionId, taskCompletionSource);
            return taskCompletionSource;
        }
    }

    ReportQueue(double d8, double d9, long j8, Transport<CrashlyticsReport> transport, OnDemandCounter onDemandCounter) {
        this.f16138a = d8;
        this.f16139b = d9;
        this.f16140c = j8;
        this.f16144g = transport;
        this.f16145h = onDemandCounter;
        int i8 = (int) d8;
        this.f16141d = i8;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i8);
        this.f16142e = arrayBlockingQueue;
        this.f16143f = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f16146i = 0;
        this.f16147j = 0L;
    }
}
