package ee.mtakso.driver.service.analytics.timed;

import ee.mtakso.driver.service.analytics.AnalyticScope;

/* compiled from: TimedConsumer.kt */
/* loaded from: classes3.dex */
public interface TimedConsumer {
    AnalyticScope a();

    void b(CompositeTimedEvent compositeTimedEvent);

    TimedEvent c(TimedEventRequest timedEventRequest);
}
