package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishedOrderDetails.kt */
/* loaded from: classes3.dex */
public final class FinishedOrderDetails extends OrderDetails {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f25415a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25416b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderState f25417c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f25418d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25419e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinishedOrderDetails(OrderHandle orderHandle, int i8, OrderState orderState, Long l8, String str) {
        super(null);
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(orderState, "orderState");
        this.f25415a = orderHandle;
        this.f25416b = i8;
        this.f25417c = orderState;
        this.f25418d = l8;
        this.f25419e = str;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public OrderHandle a() {
        return this.f25415a;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public OrderState b() {
        return this.f25417c;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public Long c() {
        return this.f25418d;
    }

    @Override // ee.mtakso.driver.service.order.details.OrderDetails
    public int d() {
        return this.f25416b;
    }

    public final String e() {
        return this.f25419e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FinishedOrderDetails) {
            FinishedOrderDetails finishedOrderDetails = (FinishedOrderDetails) obj;
            return Intrinsics.a(a(), finishedOrderDetails.a()) && d() == finishedOrderDetails.d() && b() == finishedOrderDetails.b() && Intrinsics.a(c(), finishedOrderDetails.c()) && Intrinsics.a(this.f25419e, finishedOrderDetails.f25419e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((a().hashCode() * 31) + d()) * 31) + b().hashCode()) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
        String str = this.f25419e;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        OrderHandle a8 = a();
        int d8 = d();
        OrderState b8 = b();
        Long c8 = c();
        String str = this.f25419e;
        return "FinishedOrderDetails(orderHandle=" + a8 + ", version=" + d8 + ", orderState=" + b8 + ", userId=" + c8 + ", orderFinishedMessage=" + str + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FinishedOrderDetails(OrderSummary summary, String str) {
        this(summary.b(), summary.h(), summary.f(), summary.g(), str);
        Intrinsics.f(summary, "summary");
    }
}
