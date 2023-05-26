package com.google.firebase.perf.gauges;

import com.google.firebase.perf.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class CpuGaugeCollector$$Lambda$1 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final CpuGaugeCollector f16688f;

    /* renamed from: g  reason: collision with root package name */
    private final Timer f16689g;

    private CpuGaugeCollector$$Lambda$1(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        this.f16688f = cpuGaugeCollector;
        this.f16689g = timer;
    }

    public static Runnable a(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        return new CpuGaugeCollector$$Lambda$1(cpuGaugeCollector, timer);
    }

    @Override // java.lang.Runnable
    public void run() {
        CpuGaugeCollector.g(this.f16688f, this.f16689g);
    }
}
