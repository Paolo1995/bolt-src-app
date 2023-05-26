package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.order.OrderCompletionReason;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PastOrderDetails.kt */
/* loaded from: classes3.dex */
public final class PastOrderDetails extends OrderDetails {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f25481a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25482b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderState f25483c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f25484d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderCompletionReason f25485e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PastOrderDetails(OrderHandle orderHandle, int i8, OrderState orderState, Long l8, OrderCompletionReason completionReason) {
        super(null);
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(orderState, "orderState");
        Intrinsics.f(completionReason, "completionReason");
        this.f25481a = orderHandle;
        this.f25482b = i8;
        this.f25483c = orderState;
        this.f25484d = l8;
        this.f25485e = completionReason;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public OrderHandle a() {
        return this.f25481a;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public OrderState b() {
        return this.f25483c;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public Long c() {
        return this.f25484d;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public int d() {
        return this.f25482b;
    }

    public final OrderCompletionReason e() {
        return this.f25485e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PastOrderDetails) {
            PastOrderDetails pastOrderDetails = (PastOrderDetails) obj;
            return Intrinsics.a(a(), pastOrderDetails.a()) && d() == pastOrderDetails.d() && b() == pastOrderDetails.b() && Intrinsics.a(c(), pastOrderDetails.c()) && Intrinsics.a(this.f25485e, pastOrderDetails.f25485e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((a().hashCode() * 31) + d()) * 31) + b().hashCode()) * 31) + (c() == null ? 0 : c().hashCode())) * 31) + this.f25485e.hashCode();
    }

    public String toString() {
        OrderHandle a8 = a();
        int d8 = d();
        OrderState b8 = b();
        Long c8 = c();
        OrderCompletionReason orderCompletionReason = this.f25485e;
        return "PastOrderDetails(orderHandle=" + a8 + ", version=" + d8 + ", orderState=" + b8 + ", userId=" + c8 + ", completionReason=" + orderCompletionReason + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PastOrderDetails(OrderSummary summary, OrderCompletionReason completionReason) {
        this(summary.b(), summary.h(), summary.f(), summary.g(), completionReason);
        Intrinsics.f(summary, "summary");
        Intrinsics.f(completionReason, "completionReason");
    }
}
