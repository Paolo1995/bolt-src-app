package com.google.firebase.perf.metrics;

import androidx.annotation.NonNull;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class TraceMetricBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final Trace f16790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TraceMetricBuilder(@NonNull Trace trace) {
        this.f16790a = trace;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TraceMetric a() {
        TraceMetric.Builder E = TraceMetric.newBuilder().G(this.f16790a.f()).D(this.f16790a.h().d()).E(this.f16790a.h().c(this.f16790a.e()));
        for (Counter counter : this.f16790a.d().values()) {
            E.C(counter.b(), counter.a());
        }
        List<Trace> i8 = this.f16790a.i();
        if (!i8.isEmpty()) {
            for (Trace trace : i8) {
                E.z(new TraceMetricBuilder(trace).a());
            }
        }
        E.B(this.f16790a.getAttributes());
        PerfSession[] b8 = com.google.firebase.perf.internal.PerfSession.b(this.f16790a.g());
        if (b8 != null) {
            E.u(Arrays.asList(b8));
        }
        return E.build();
    }
}
