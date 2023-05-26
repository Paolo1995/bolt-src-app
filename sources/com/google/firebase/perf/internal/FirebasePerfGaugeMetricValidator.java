package com.google.firebase.perf.internal;

import com.google.firebase.perf.v1.GaugeMetric;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class FirebasePerfGaugeMetricValidator extends PerfMetricValidator {

    /* renamed from: a  reason: collision with root package name */
    private final GaugeMetric f16731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebasePerfGaugeMetricValidator(GaugeMetric gaugeMetric) {
        this.f16731a = gaugeMetric;
    }

    @Override // com.google.firebase.perf.internal.PerfMetricValidator
    public boolean c() {
        if (this.f16731a.hasSessionId() && (this.f16731a.getCpuMetricReadingsCount() > 0 || this.f16731a.getAndroidMemoryReadingsCount() > 0 || (this.f16731a.hasGaugeMetadata() && this.f16731a.getGaugeMetadata().hasMaxAppJavaHeapMemoryKb()))) {
            return true;
        }
        return false;
    }
}
