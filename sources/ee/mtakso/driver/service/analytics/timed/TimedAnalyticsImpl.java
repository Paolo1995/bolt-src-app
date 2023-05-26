package ee.mtakso.driver.service.analytics.timed;

import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.timed.facade.OrderTracing;
import ee.mtakso.driver.service.analytics.timed.facade.RateMeTracing;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimedAnalyticsImpl.kt */
/* loaded from: classes3.dex */
public final class TimedAnalyticsImpl implements OrderTracing, StartUpTracing, RateMeTracing {

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f23529b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final TimedAnalyticsManager f23530a;

    /* compiled from: TimedAnalyticsImpl.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TimedAnalyticsImpl(TimedAnalyticsManager manager) {
        Intrinsics.f(manager, "manager");
        this.f23530a = manager;
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void a() {
        TimedAnalyticsManager.e(this.f23530a, Scopes.f23428a.d(), "(ENG) Order Acceptance Presented", null, 4, null);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void b() {
        TimedAnalyticsManager.g(this.f23530a, "(ENG) Order State Set", null, 2, null);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing
    public void c() {
        TimedAnalyticsManager.e(this.f23530a, Scopes.f23428a.d(), "(ENG) App Launched", null, 4, null);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.RateMeTracing
    public void d(String category) {
        Map<String, String> c8;
        Intrinsics.f(category, "category");
        TimedAnalyticsManager timedAnalyticsManager = this.f23530a;
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("Section", category));
        timedAnalyticsManager.f("Negative Feedback Section Presence Time Tracked", c8);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void e() {
        Map<String, String> c8;
        TimedAnalyticsManager timedAnalyticsManager = this.f23530a;
        AnalyticScope d8 = Scopes.f23428a.d();
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("newState", "Finished"));
        timedAnalyticsManager.c(d8, "(ENG) Order State Set", c8);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.RateMeTracing
    public void f(String category) {
        Map<String, String> c8;
        Intrinsics.f(category, "category");
        TimedAnalyticsManager timedAnalyticsManager = this.f23530a;
        AnalyticScope g8 = Scopes.f23428a.g();
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("Section", category));
        timedAnalyticsManager.c(g8, "Negative Feedback Section Presence Time Tracked", c8);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void g() {
        Map<String, String> c8;
        TimedAnalyticsManager timedAnalyticsManager = this.f23530a;
        AnalyticScope d8 = Scopes.f23428a.d();
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("newState", "Driving To Client"));
        timedAnalyticsManager.c(d8, "(ENG) Order State Set", c8);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void h() {
        TimedAnalyticsManager.g(this.f23530a, "(ENG) Order State Set", null, 2, null);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void i() {
        TimedAnalyticsManager.g(this.f23530a, "(ENG) Order State Set", null, 2, null);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void j() {
        TimedAnalyticsManager.g(this.f23530a, "(ENG) Order State Set", null, 2, null);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void k() {
        Map<String, String> c8;
        TimedAnalyticsManager timedAnalyticsManager = this.f23530a;
        AnalyticScope d8 = Scopes.f23428a.d();
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("newState", "Waiting For Client"));
        timedAnalyticsManager.c(d8, "(ENG) Order State Set", c8);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void l(boolean z7) {
        Map<String, String> c8;
        TimedAnalyticsManager timedAnalyticsManager = this.f23530a;
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("isB2B", String.valueOf(z7)));
        timedAnalyticsManager.f("(ENG) Order Acceptance Presented", c8);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void m() {
        Map<String, String> c8;
        TimedAnalyticsManager timedAnalyticsManager = this.f23530a;
        AnalyticScope d8 = Scopes.f23428a.d();
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("newState", "Confirm Price"));
        timedAnalyticsManager.c(d8, "(ENG) Order State Set", c8);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void n() {
        Map<String, String> c8;
        TimedAnalyticsManager timedAnalyticsManager = this.f23530a;
        AnalyticScope d8 = Scopes.f23428a.d();
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("newState", "Driving With Client"));
        timedAnalyticsManager.c(d8, "(ENG) Order State Set", c8);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.OrderTracing
    public void o() {
        TimedAnalyticsManager.g(this.f23530a, "(ENG) Order State Set", null, 2, null);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing
    public void p() {
        TimedAnalyticsManager.g(this.f23530a, "(ENG) App Launched", null, 2, null);
    }
}
