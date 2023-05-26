package com.google.firebase.perf.gauges;

import com.google.firebase.perf.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class MemoryGaugeCollector$$Lambda$1 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final MemoryGaugeCollector f16699f;

    /* renamed from: g  reason: collision with root package name */
    private final Timer f16700g;

    private MemoryGaugeCollector$$Lambda$1(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.f16699f = memoryGaugeCollector;
        this.f16700g = timer;
    }

    public static Runnable a(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        return new MemoryGaugeCollector$$Lambda$1(memoryGaugeCollector, timer);
    }

    @Override // java.lang.Runnable
    public void run() {
        MemoryGaugeCollector.f(this.f16699f, this.f16700g);
    }
}
