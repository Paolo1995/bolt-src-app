package ee.mtakso.driver.service.analytics.timed;

import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositeTimedEvent.kt */
/* loaded from: classes3.dex */
public final class CompositeTimedEvent implements TimedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final TimedEventRequest f23526a;

    /* renamed from: b  reason: collision with root package name */
    private final List<TimedEvent> f23527b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f23528c;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeTimedEvent(TimedEventRequest request, List<? extends TimedEvent> children) {
        Map<String, String> u7;
        Intrinsics.f(request, "request");
        Intrinsics.f(children, "children");
        this.f23526a = request;
        this.f23527b = children;
        u7 = MapsKt__MapsKt.u(request.b());
        this.f23528c = u7;
    }

    public final List<TimedEvent> a() {
        return this.f23527b;
    }

    public final Map<String, String> b() {
        return this.f23528c;
    }

    public final TimedEventRequest c() {
        return this.f23526a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompositeTimedEvent) {
            CompositeTimedEvent compositeTimedEvent = (CompositeTimedEvent) obj;
            return Intrinsics.a(this.f23526a, compositeTimedEvent.f23526a) && Intrinsics.a(this.f23527b, compositeTimedEvent.f23527b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f23526a.hashCode() * 31) + this.f23527b.hashCode();
    }

    public String toString() {
        TimedEventRequest timedEventRequest = this.f23526a;
        List<TimedEvent> list = this.f23527b;
        return "CompositeTimedEvent(request=" + timedEventRequest + ", children=" + list + ")";
    }
}
