package com.google.firebase.perf.transport;

import androidx.annotation.NonNull;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.PerfMetric;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class PendingPerfEvent {

    /* renamed from: a  reason: collision with root package name */
    protected final PerfMetric.Builder f16823a;

    /* renamed from: b  reason: collision with root package name */
    protected final ApplicationProcessState f16824b;

    public PendingPerfEvent(@NonNull PerfMetric.Builder builder, @NonNull ApplicationProcessState applicationProcessState) {
        this.f16823a = builder;
        this.f16824b = applicationProcessState;
    }
}
