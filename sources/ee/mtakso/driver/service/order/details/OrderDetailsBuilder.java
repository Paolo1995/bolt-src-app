package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDetailsBuilder.kt */
/* loaded from: classes3.dex */
public final class OrderDetailsBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final OrderSummary f25420a;

    /* renamed from: b  reason: collision with root package name */
    private final Order f25421b;

    /* renamed from: c  reason: collision with root package name */
    private long f25422c;

    /* renamed from: d  reason: collision with root package name */
    private Long f25423d;

    /* renamed from: e  reason: collision with root package name */
    private Long f25424e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25425f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25426g;

    /* renamed from: h  reason: collision with root package name */
    private long f25427h;

    /* renamed from: i  reason: collision with root package name */
    private Long f25428i;

    /* renamed from: j  reason: collision with root package name */
    private String f25429j;

    /* renamed from: k  reason: collision with root package name */
    private AutoOrderAcceptance f25430k;

    public OrderDetailsBuilder(OrderSummary source, Order order) {
        Intrinsics.f(source, "source");
        Intrinsics.f(order, "order");
        this.f25420a = source;
        this.f25421b = order;
        this.f25422c = -1L;
        this.f25427h = -1L;
    }

    public final ActiveOrderDetails a() {
        return new ActiveOrderDetails(this.f25420a.b(), this.f25420a.h(), this.f25420a.f(), this.f25420a.g(), this.f25421b, this.f25422c, this.f25425f, this.f25426g, this.f25423d, this.f25427h, this.f25424e, this.f25428i, this.f25429j, this.f25430k, this.f25420a.c(), this.f25420a.a());
    }

    public final void b(AutoOrderAcceptance autoOrderAcceptance) {
        this.f25430k = autoOrderAcceptance;
    }

    public final void c(boolean z7) {
        this.f25425f = z7;
    }

    public final void d(boolean z7) {
        this.f25426g = z7;
    }

    public final void e(String str) {
        this.f25429j = str;
    }

    public final void f(long j8) {
        this.f25427h = j8;
    }

    public final void g(Long l8) {
        this.f25428i = l8;
    }

    public final void h(Long l8) {
        this.f25423d = l8;
    }

    public final void i(Long l8) {
        this.f25424e = l8;
    }

    public final void j(long j8) {
        this.f25422c = j8;
    }
}
