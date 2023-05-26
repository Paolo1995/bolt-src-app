package ee.mtakso.driver.service.analytics.event.consumer;

import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.event.AnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.Event;
import ee.mtakso.driver.service.analytics.event.Property;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CrashlyticsAnalyticsConsumer.kt */
/* loaded from: classes3.dex */
public final class CrashlyticsAnalyticsConsumer implements AnalyticsConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final ReportManager f23478a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticScope f23479b;

    @Inject
    public CrashlyticsAnalyticsConsumer(ReportManager reportManager) {
        Intrinsics.f(reportManager, "reportManager");
        this.f23478a = reportManager;
        this.f23479b = Scopes.f23428a.a();
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public AnalyticScope a() {
        return this.f23479b;
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void b(String id) {
        Intrinsics.f(id, "id");
        this.f23478a.b(id);
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void c(Property property) {
        Intrinsics.f(property, "property");
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void d(Event event) {
        Intrinsics.f(event, "event");
        throw new UnsupportedOperationException("Platform-crash doesn't support events");
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void e(Property property) {
        Intrinsics.f(property, "property");
        this.f23478a.c(property.a(), property.c());
    }
}
