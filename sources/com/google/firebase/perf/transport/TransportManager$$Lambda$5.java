package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class TransportManager$$Lambda$5 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final TransportManager f16866f;

    /* renamed from: g  reason: collision with root package name */
    private final NetworkRequestMetric f16867g;

    /* renamed from: h  reason: collision with root package name */
    private final ApplicationProcessState f16868h;

    private TransportManager$$Lambda$5(TransportManager transportManager, NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        this.f16866f = transportManager;
        this.f16867g = networkRequestMetric;
        this.f16868h = applicationProcessState;
    }

    public static Runnable a(TransportManager transportManager, NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        return new TransportManager$$Lambda$5(transportManager, networkRequestMetric, applicationProcessState);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16866f.z(PerfMetric.newBuilder().x(this.f16867g), this.f16868h);
    }
}
