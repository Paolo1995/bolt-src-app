package ee.mtakso.driver.service.analytics.timed.consumer.log;

import ee.mtakso.driver.service.analytics.timed.TimedEvent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogTimedEvent.kt */
/* loaded from: classes3.dex */
public final class LogTimedEvent implements TimedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final LogTrace f23541a;

    public LogTimedEvent(LogTrace trace) {
        Intrinsics.f(trace, "trace");
        this.f23541a = trace;
    }

    public final LogTrace a() {
        return this.f23541a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LogTimedEvent) && Intrinsics.a(this.f23541a, ((LogTimedEvent) obj).f23541a);
    }

    public int hashCode() {
        return this.f23541a.hashCode();
    }

    public String toString() {
        LogTrace logTrace = this.f23541a;
        return "LogTimedEvent(trace=" + logTrace + ")";
    }
}
