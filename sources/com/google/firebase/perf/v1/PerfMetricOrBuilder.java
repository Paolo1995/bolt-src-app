package com.google.firebase.perf.v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes3.dex */
public interface PerfMetricOrBuilder extends MessageLiteOrBuilder {
    GaugeMetric getGaugeMetric();

    NetworkRequestMetric getNetworkRequestMetric();

    TraceMetric getTraceMetric();

    boolean hasGaugeMetric();

    boolean hasNetworkRequestMetric();

    boolean hasTraceMetric();
}
