package com.google.firebase.perf.gauges;

import com.google.firebase.perf.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class MemoryGaugeCollector$$Lambda$4 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final MemoryGaugeCollector f16701f;

    /* renamed from: g  reason: collision with root package name */
    private final Timer f16702g;

    private MemoryGaugeCollector$$Lambda$4(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.f16701f = memoryGaugeCollector;
        this.f16702g = timer;
    }

    public static Runnable a(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        return new MemoryGaugeCollector$$Lambda$4(memoryGaugeCollector, timer);
    }

    @Override // java.lang.Runnable
    public void run() {
        MemoryGaugeCollector.e(this.f16701f, this.f16702g);
    }
}
