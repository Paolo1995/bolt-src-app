package ee.mtakso.driver.service.analytics.timed;

import ee.mtakso.driver.service.analytics.AnalyticScope;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimedEventRequest.kt */
/* loaded from: classes3.dex */
public final class TimedEventRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f23535a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticScope f23536b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f23537c;

    public TimedEventRequest(String key, AnalyticScope scope, Map<String, String> payload) {
        Intrinsics.f(key, "key");
        Intrinsics.f(scope, "scope");
        Intrinsics.f(payload, "payload");
        this.f23535a = key;
        this.f23536b = scope;
        this.f23537c = payload;
    }

    public final String a() {
        return this.f23535a;
    }

    public final Map<String, String> b() {
        return this.f23537c;
    }

    public final AnalyticScope c() {
        return this.f23536b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimedEventRequest) {
            TimedEventRequest timedEventRequest = (TimedEventRequest) obj;
            return Intrinsics.a(this.f23535a, timedEventRequest.f23535a) && Intrinsics.a(this.f23536b, timedEventRequest.f23536b) && Intrinsics.a(this.f23537c, timedEventRequest.f23537c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f23535a.hashCode() * 31) + this.f23536b.hashCode()) * 31) + this.f23537c.hashCode();
    }

    public String toString() {
        String str = this.f23535a;
        AnalyticScope analyticScope = this.f23536b;
        Map<String, String> map = this.f23537c;
        return "TimedEventRequest(key=" + str + ", scope=" + analyticScope + ", payload=" + map + ")";
    }
}
