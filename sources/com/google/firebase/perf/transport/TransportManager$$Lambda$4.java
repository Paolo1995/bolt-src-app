package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.TraceMetric;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class TransportManager$$Lambda$4 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final TransportManager f16863f;

    /* renamed from: g  reason: collision with root package name */
    private final TraceMetric f16864g;

    /* renamed from: h  reason: collision with root package name */
    private final ApplicationProcessState f16865h;

    private TransportManager$$Lambda$4(TransportManager transportManager, TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        this.f16863f = transportManager;
        this.f16864g = traceMetric;
        this.f16865h = applicationProcessState;
    }

    public static Runnable a(TransportManager transportManager, TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        return new TransportManager$$Lambda$4(transportManager, traceMetric, applicationProcessState);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16863f.z(PerfMetric.newBuilder().z(this.f16864g), this.f16865h);
    }
}
