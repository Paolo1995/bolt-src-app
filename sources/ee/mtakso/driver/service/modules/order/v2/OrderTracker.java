package ee.mtakso.driver.service.modules.order.v2;

import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.OrderTracing;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderTracker.kt */
/* loaded from: classes3.dex */
public final class OrderTracker {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f24989g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final OrderTracing f24990a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderFlowAnalytics f24991b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderAnalytics f24992c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderStateStrategy f24993d;

    /* renamed from: e  reason: collision with root package name */
    private final NotRespondReporter f24994e;

    /* renamed from: f  reason: collision with root package name */
    private final WrongStateReporter f24995f;

    /* compiled from: OrderTracker.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public OrderTracker(OrderTracing orderTracing, OrderFlowAnalytics orderFlowAnalytics, OrderAnalytics orderAnalytics, OrderStateStrategy orderStateStrategy, NotRespondReporter notRespondReporter, WrongStateReporter wrongStateReporter) {
        Intrinsics.f(orderTracing, "orderTracing");
        Intrinsics.f(orderFlowAnalytics, "orderFlowAnalytics");
        Intrinsics.f(orderAnalytics, "orderAnalytics");
        Intrinsics.f(orderStateStrategy, "orderStateStrategy");
        Intrinsics.f(notRespondReporter, "notRespondReporter");
        Intrinsics.f(wrongStateReporter, "wrongStateReporter");
        this.f24990a = orderTracing;
        this.f24991b = orderFlowAnalytics;
        this.f24992c = orderAnalytics;
        this.f24993d = orderStateStrategy;
        this.f24994e = notRespondReporter;
        this.f24995f = wrongStateReporter;
    }

    public final void A() {
        Kalev.b("Routing to new order by notification");
        this.f24994e.a();
    }

    public final void B(OrderState orderState) {
        Intrinsics.f(orderState, "orderState");
        this.f24992c.i0(orderState);
        this.f24991b.f1(orderState);
    }

    public final void C(OrderState orderState, String str, String str2, String orderShardId) {
        Intrinsics.f(orderState, "orderState");
        Intrinsics.f(orderShardId, "orderShardId");
        OrderAnalytics.DefaultImpls.a(this.f24992c, orderState, str, str2, orderShardId, false, 16, null);
    }

    public final void D() {
        this.f24991b.S1();
    }

    public final void E() {
        this.f24991b.j();
    }

    public final void F() {
        OrderFlowAnalytics.DefaultImpls.d(this.f24991b, false, 1, null);
    }

    public final void G(OrderHandle orderHandle, boolean z7) {
        Intrinsics.f(orderHandle, "orderHandle");
        Kalev.n("order", orderHandle.toString()).k("order_track").a("Incoming order shown");
        this.f24990a.l(z7);
    }

    public final void H() {
        this.f24990a.e();
    }

    public final void I(String message, String status) {
        Intrinsics.f(message, "message");
        Intrinsics.f(status, "status");
        this.f24991b.n2(message, status);
    }

    public final void J(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        this.f24995f.d(throwable);
    }

    public final void K() {
        this.f24991b.u2();
    }

    public final void L() {
        this.f24991b.Q0();
    }

    public final void M() {
        this.f24991b.x0();
    }

    public final void N() {
        this.f24991b.A();
    }

    public final void O() {
        this.f24991b.M();
    }

    public final void P() {
        this.f24992c.G();
        this.f24991b.L1();
    }

    public final void Q() {
        this.f24990a.o();
        R();
    }

    public final void R() {
        this.f24991b.J();
    }

    public final void S() {
        this.f24991b.w3();
    }

    public final void T() {
        this.f24991b.N2();
    }

    public final void U() {
        this.f24991b.X1();
    }

    public final void V() {
        this.f24991b.a3();
    }

    public final void W(String str) {
        this.f24991b.J1(str);
    }

    public final void X() {
        OrderFlowAnalytics.DefaultImpls.b(this.f24991b, false, false, 2, null);
    }

    public final void Y() {
        this.f24991b.H1(false);
    }

    public final void Z(boolean z7, boolean z8) {
        this.f24991b.J2(z7, z8);
    }

    public final void a(PollingResult pollingResult) {
        Intrinsics.f(pollingResult, "pollingResult");
        this.f24994e.f(pollingResult);
    }

    public final void a0() {
        this.f24991b.c2();
    }

    public final void b(boolean z7) {
        Kalev.j("order_track").a("Accept clicked");
        this.f24991b.B2(z7);
        this.f24990a.g();
    }

    public final void b0() {
        this.f24991b.K0();
    }

    public final void c() {
        this.f24990a.b();
        this.f24991b.k1();
    }

    public final void c0() {
        this.f24991b.p();
    }

    public final void d(boolean z7) {
        this.f24991b.a2(z7);
    }

    public final void d0() {
        this.f24991b.t();
    }

    public final void e() {
        this.f24991b.F();
    }

    public final void e0() {
        this.f24991b.b2();
    }

    public final void f(boolean z7) {
        this.f24991b.q0(z7);
    }

    public final void f0() {
        this.f24991b.E3();
    }

    public final void g() {
        this.f24991b.v3();
    }

    public final void g0() {
        this.f24990a.j();
        this.f24991b.w1();
    }

    public final void h() {
        OrderFlowAnalytics.DefaultImpls.a(this.f24991b, false, 1, null);
        this.f24990a.k();
    }

    public final void i(boolean z7) {
        this.f24991b.D(z7);
    }

    public final void j(String message) {
        Intrinsics.f(message, "message");
        this.f24991b.G2(message);
    }

    public final void k() {
        this.f24991b.L0();
    }

    public final void l() {
        this.f24991b.F2();
    }

    public final void m() {
        this.f24991b.e1();
    }

    public final void n(OrderState orderState) {
        Intrinsics.f(orderState, "orderState");
        this.f24992c.l1(orderState);
        this.f24991b.M2();
    }

    public final void o() {
        Kalev.j("order_track").a("Decline confirmed");
        this.f24991b.X0();
    }

    public final void p() {
        this.f24991b.q2();
    }

    public final void q() {
        Kalev.j("order_track").a("Driver did not respond");
        this.f24994e.c();
        this.f24993d.d();
    }

    public final void r() {
        this.f24991b.r();
    }

    public final void s() {
        OrderFlowAnalytics.DefaultImpls.c(this.f24991b, false, 1, null);
        this.f24990a.n();
    }

    public final void t() {
        this.f24990a.i();
        this.f24991b.S0();
    }

    public final void u() {
        OrderFlowAnalytics.DefaultImpls.b(this.f24991b, true, false, 2, null);
        this.f24990a.m();
    }

    public final void v() {
        this.f24991b.H1(true);
        this.f24990a.m();
    }

    public final void w() {
        this.f24990a.h();
    }

    public final void x(OrderSummary orderSummary) {
        Intrinsics.f(orderSummary, "orderSummary");
        this.f24993d.g();
        this.f24990a.a();
        Kalev.n("order", orderSummary.toString()).k("order_track").a("Found incoming order");
    }

    public final void y(boolean z7) {
        Kalev.j("order_track").n("haveState", Boolean.valueOf(z7)).a("Incoming order activity created");
        this.f24991b.g4();
        this.f24994e.b();
    }

    public final void z() {
        Kalev.b("Routing to new order by intent");
        this.f24994e.a();
    }
}
