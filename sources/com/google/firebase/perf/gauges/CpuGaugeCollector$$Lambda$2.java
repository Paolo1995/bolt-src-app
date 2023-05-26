package com.google.firebase.perf.gauges;

import com.google.firebase.perf.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class CpuGaugeCollector$$Lambda$2 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final CpuGaugeCollector f16690f;

    /* renamed from: g  reason: collision with root package name */
    private final Timer f16691g;

    private CpuGaugeCollector$$Lambda$2(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        this.f16690f = cpuGaugeCollector;
        this.f16691g = timer;
    }

    public static Runnable a(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        return new CpuGaugeCollector$$Lambda$2(cpuGaugeCollector, timer);
    }

    @Override // java.lang.Runnable
    public void run() {
        CpuGaugeCollector.f(this.f16690f, this.f16691g);
    }
}
