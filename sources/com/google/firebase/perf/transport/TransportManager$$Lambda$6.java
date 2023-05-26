package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.PerfMetric;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class TransportManager$$Lambda$6 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final TransportManager f16869f;

    /* renamed from: g  reason: collision with root package name */
    private final GaugeMetric f16870g;

    /* renamed from: h  reason: collision with root package name */
    private final ApplicationProcessState f16871h;

    private TransportManager$$Lambda$6(TransportManager transportManager, GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        this.f16869f = transportManager;
        this.f16870g = gaugeMetric;
        this.f16871h = applicationProcessState;
    }

    public static Runnable a(TransportManager transportManager, GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        return new TransportManager$$Lambda$6(transportManager, gaugeMetric, applicationProcessState);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16869f.z(PerfMetric.newBuilder().v(this.f16870g), this.f16871h);
    }
}
