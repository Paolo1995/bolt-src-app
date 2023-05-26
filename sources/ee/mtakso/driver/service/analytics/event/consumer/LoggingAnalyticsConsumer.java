package ee.mtakso.driver.service.analytics.event.consumer;

import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.event.AnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.Event;
import ee.mtakso.driver.service.analytics.event.Property;
import eu.bolt.kalev.Kalev;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggingAnalyticsConsumer.kt */
/* loaded from: classes3.dex */
public final class LoggingAnalyticsConsumer implements AnalyticsConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticScope f23492a = Scopes.f23428a.b();

    private final String f(AnalyticScope analyticScope, AnalyticScope analyticScope2, String str) {
        if (!analyticScope.b(analyticScope2)) {
            return null;
        }
        return str;
    }

    private final String g(AnalyticScope analyticScope) {
        List p8;
        String f02;
        Scopes scopes = Scopes.f23428a;
        p8 = CollectionsKt__CollectionsKt.p(f(analyticScope, scopes.d(), "FIREBASE"), f(analyticScope, scopes.g(), "MIXPANEL"), f(analyticScope, scopes.a(), "CRASHLYTICS"), f(analyticScope, scopes.e(), "INTERNAL"), f(analyticScope, scopes.f(), "LEAD_INTERNAL"));
        f02 = CollectionsKt___CollectionsKt.f0(p8, "|", null, null, 0, null, null, 62, null);
        return f02;
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public AnalyticScope a() {
        return this.f23492a;
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void b(String id) {
        Intrinsics.f(id, "id");
        Kalev.b("user id set to " + id);
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void c(Property property) {
        Intrinsics.f(property, "property");
        String g8 = g(property.b());
        String a8 = property.a();
        String c8 = property.c();
        Kalev.b("new super property [" + g8 + "]: " + a8 + " = " + c8);
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void d(Event event) {
        Intrinsics.f(event, "event");
        String g8 = g(event.d());
        String b8 = event.b();
        Map<String, Object> c8 = event.c();
        Kalev.b("new event [" + g8 + "]: " + b8 + " = " + c8);
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void e(Property property) {
        Intrinsics.f(property, "property");
        String g8 = g(property.b());
        String a8 = property.a();
        String c8 = property.c();
        Kalev.b("new user property [" + g8 + "]: " + a8 + " = " + c8);
    }
}
