package com.google.firebase.perf.internal;

import com.google.firebase.perf.v1.ApplicationProcessState;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class GaugeManager$$Lambda$1 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final GaugeManager f16737f;

    /* renamed from: g  reason: collision with root package name */
    private final String f16738g;

    /* renamed from: h  reason: collision with root package name */
    private final ApplicationProcessState f16739h;

    private GaugeManager$$Lambda$1(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        this.f16737f = gaugeManager;
        this.f16738g = str;
        this.f16739h = applicationProcessState;
    }

    public static Runnable a(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        return new GaugeManager$$Lambda$1(gaugeManager, str, applicationProcessState);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16737f.syncFlush(this.f16738g, this.f16739h);
    }
}
