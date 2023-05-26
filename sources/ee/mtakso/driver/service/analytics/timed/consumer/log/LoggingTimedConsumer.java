package ee.mtakso.driver.service.analytics.timed.consumer.log;

import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.timed.CompositeTimedEvent;
import ee.mtakso.driver.service.analytics.timed.CompositeTimedEventKt;
import ee.mtakso.driver.service.analytics.timed.TimedConsumer;
import ee.mtakso.driver.service.analytics.timed.TimedEvent;
import ee.mtakso.driver.service.analytics.timed.TimedEventRequest;
import eu.bolt.kalev.Kalev;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggingTimedConsumer.kt */
/* loaded from: classes3.dex */
public final class LoggingTimedConsumer implements TimedConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticScope f23546a = Scopes.f23428a.b();

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public AnalyticScope a() {
        return this.f23546a;
    }

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public void b(CompositeTimedEvent event) {
        Intrinsics.f(event, "event");
        Kalev.j("TimedEvent").n("key", event.c().a()).a("Stop");
        LogTrace a8 = ((LogTimedEvent) CompositeTimedEventKt.b(event, LogTimedEvent.class)).a();
        a8.a().putAll(event.b());
        a8.b();
    }

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public TimedEvent c(TimedEventRequest request) {
        Map u7;
        Intrinsics.f(request, "request");
        Kalev.j("TimedEvent").n("key", request.a()).a("Start");
        String a8 = request.a();
        u7 = MapsKt__MapsKt.u(request.b());
        return new LogTimedEvent(new LogTrace(a8, u7));
    }
}
