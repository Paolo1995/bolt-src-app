package ee.mtakso.driver.service.analytics.event.consumer;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.event.AnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.Event;
import ee.mtakso.driver.service.analytics.event.Property;
import ee.mtakso.driver.service.analytics.event.PropertyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MixpanelAnalyticsConsumer.kt */
/* loaded from: classes3.dex */
public final class MixpanelAnalyticsConsumer implements AnalyticsConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final MixpanelAPI f23494a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticScope f23495b;

    public MixpanelAnalyticsConsumer(MixpanelAPI mixpanel) {
        Intrinsics.f(mixpanel, "mixpanel");
        this.f23494a = mixpanel;
        this.f23495b = Scopes.f23428a.g();
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public AnalyticScope a() {
        return this.f23495b;
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void b(String id) {
        Intrinsics.f(id, "id");
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void c(Property property) {
        Intrinsics.f(property, "property");
        synchronized (this.f23494a) {
            this.f23494a.Q(PropertyKt.a(property));
            Unit unit = Unit.f50853a;
        }
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void d(Event event) {
        Intrinsics.f(event, "event");
        synchronized (this.f23494a) {
            this.f23494a.V(event.b(), event.e());
            Unit unit = Unit.f50853a;
        }
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void e(Property property) {
        Intrinsics.f(property, "property");
        synchronized (this.f23494a) {
            this.f23494a.C().g(property.a(), property.c());
            Unit unit = Unit.f50853a;
        }
    }

    public final void f(String id) {
        Intrinsics.f(id, "id");
        synchronized (this.f23494a) {
            this.f23494a.G(id);
            this.f23494a.C().l(id);
            Unit unit = Unit.f50853a;
        }
    }

    public final void g() {
        synchronized (this.f23494a) {
            this.f23494a.s();
            this.f23494a.R();
            Unit unit = Unit.f50853a;
        }
    }
}
