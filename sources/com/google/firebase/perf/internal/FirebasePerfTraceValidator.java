package com.google.firebase.perf.internal;

import androidx.annotation.NonNull;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class FirebasePerfTraceValidator extends PerfMetricValidator {

    /* renamed from: b  reason: collision with root package name */
    private static final AndroidLogger f16735b = AndroidLogger.e();

    /* renamed from: a  reason: collision with root package name */
    private TraceMetric f16736a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebasePerfTraceValidator(@NonNull TraceMetric traceMetric) {
        this.f16736a = traceMetric;
    }

    private boolean g(@NonNull TraceMetric traceMetric) {
        return h(traceMetric, 0);
    }

    private boolean h(TraceMetric traceMetric, int i8) {
        if (traceMetric == null) {
            return false;
        }
        if (i8 > 1) {
            f16735b.i("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        for (Map.Entry<String, Long> entry : traceMetric.getCountersMap().entrySet()) {
            if (!k(entry.getKey())) {
                AndroidLogger androidLogger = f16735b;
                androidLogger.i("invalid CounterId:" + entry.getKey());
                return false;
            } else if (!l(entry.getValue())) {
                AndroidLogger androidLogger2 = f16735b;
                androidLogger2.i("invalid CounterValue:" + entry.getValue());
                return false;
            }
        }
        for (TraceMetric traceMetric2 : traceMetric.getSubtracesList()) {
            if (!h(traceMetric2, i8 + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean i(@NonNull TraceMetric traceMetric) {
        boolean z7;
        boolean z8;
        if (traceMetric.getCountersCount() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return true;
        }
        for (TraceMetric traceMetric2 : traceMetric.getSubtracesList()) {
            if (traceMetric2.getCountersCount() > 0) {
                z8 = true;
                continue;
            } else {
                z8 = false;
                continue;
            }
            if (z8) {
                return true;
            }
        }
        return false;
    }

    private boolean j(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String d8 = PerfMetricValidator.d(entry);
            if (d8 != null) {
                f16735b.i(d8);
                return false;
            }
        }
        return true;
    }

    private boolean k(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            f16735b.i("counterId is empty");
            return false;
        } else if (trim.length() > 100) {
            f16735b.i("counterId exceeded max length 100");
            return false;
        } else {
            return true;
        }
    }

    private boolean l(Long l8) {
        return l8 != null;
    }

    private boolean m(TraceMetric traceMetric, int i8) {
        if (traceMetric == null) {
            f16735b.i("TraceMetric is null");
            return false;
        } else if (i8 > 1) {
            f16735b.i("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        } else if (!o(traceMetric.getName())) {
            AndroidLogger androidLogger = f16735b;
            androidLogger.i("invalid TraceId:" + traceMetric.getName());
            return false;
        } else if (!n(traceMetric)) {
            AndroidLogger androidLogger2 = f16735b;
            androidLogger2.i("invalid TraceDuration:" + traceMetric.getDurationUs());
            return false;
        } else if (!traceMetric.hasClientStartTimeUs()) {
            f16735b.i("clientStartTimeUs is null.");
            return false;
        } else {
            for (TraceMetric traceMetric2 : traceMetric.getSubtracesList()) {
                if (!m(traceMetric2, i8 + 1)) {
                    return false;
                }
            }
            if (!j(traceMetric.getCustomAttributesMap())) {
                return false;
            }
            return true;
        }
    }

    private boolean n(TraceMetric traceMetric) {
        if (traceMetric != null && traceMetric.getDurationUs() > 0) {
            return true;
        }
        return false;
    }

    private boolean o(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty() || trim.length() > 100) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.perf.internal.PerfMetricValidator
    public boolean c() {
        if (!m(this.f16736a, 0)) {
            AndroidLogger androidLogger = f16735b;
            androidLogger.i("Invalid Trace:" + this.f16736a.getName());
            return false;
        } else if (i(this.f16736a) && !g(this.f16736a)) {
            AndroidLogger androidLogger2 = f16735b;
            androidLogger2.i("Invalid Counters for Trace:" + this.f16736a.getName());
            return false;
        } else {
            return true;
        }
    }
}
