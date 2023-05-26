package com.google.firebase.perf.internal;

import com.google.firebase.perf.v1.ApplicationProcessState;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class GaugeManager$$Lambda$2 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final GaugeManager f16740f;

    /* renamed from: g  reason: collision with root package name */
    private final String f16741g;

    /* renamed from: h  reason: collision with root package name */
    private final ApplicationProcessState f16742h;

    private GaugeManager$$Lambda$2(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        this.f16740f = gaugeManager;
        this.f16741g = str;
        this.f16742h = applicationProcessState;
    }

    public static Runnable a(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        return new GaugeManager$$Lambda$2(gaugeManager, str, applicationProcessState);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16740f.syncFlush(this.f16741g, this.f16742h);
    }
}
