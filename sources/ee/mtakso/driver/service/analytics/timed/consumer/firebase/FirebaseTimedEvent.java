package ee.mtakso.driver.service.analytics.timed.consumer.firebase;

import com.google.firebase.perf.metrics.Trace;
import ee.mtakso.driver.service.analytics.timed.TimedEvent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Firebase.kt */
/* loaded from: classes3.dex */
public final class FirebaseTimedEvent implements TimedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final Trace f23540a;

    public FirebaseTimedEvent(Trace trace) {
        Intrinsics.f(trace, "trace");
        this.f23540a = trace;
    }

    public final Trace a() {
        return this.f23540a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FirebaseTimedEvent) && Intrinsics.a(this.f23540a, ((FirebaseTimedEvent) obj).f23540a);
    }

    public int hashCode() {
        return this.f23540a.hashCode();
    }

    public String toString() {
        Trace trace = this.f23540a;
        return "FirebaseTimedEvent(trace=" + trace + ")";
    }
}
