package ee.mtakso.driver.service.analytics.timed.consumer.firebase;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.timed.CompositeTimedEvent;
import ee.mtakso.driver.service.analytics.timed.CompositeTimedEventKt;
import ee.mtakso.driver.service.analytics.timed.TimedConsumer;
import ee.mtakso.driver.service.analytics.timed.TimedEvent;
import ee.mtakso.driver.service.analytics.timed.TimedEventRequest;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseTimedConsumer.kt */
@Singleton
/* loaded from: classes3.dex */
public final class FirebaseTimedConsumer implements TimedConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticScope f23538a = Scopes.f23428a.d();

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public AnalyticScope a() {
        return this.f23538a;
    }

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public void b(CompositeTimedEvent event) {
        Intrinsics.f(event, "event");
        Trace a8 = ((FirebaseTimedEvent) CompositeTimedEventKt.b(event, FirebaseTimedEvent.class)).a();
        for (Map.Entry<String, String> entry : event.b().entrySet()) {
            a8.putAttribute(entry.getKey(), entry.getValue());
        }
        a8.stop();
    }

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public TimedEvent c(TimedEventRequest request) {
        Intrinsics.f(request, "request");
        Trace d8 = FirebasePerformance.c().d(request.a());
        Intrinsics.e(d8, "getInstance().newTrace(request.key)");
        d8.start();
        return new FirebaseTimedEvent(d8);
    }
}
