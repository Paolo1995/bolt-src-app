package ee.mtakso.driver.ui.interactor.order;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.Order;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderDetails.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderDetails {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f26695a;

    /* renamed from: b  reason: collision with root package name */
    private final Order f26696b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26697c;

    /* renamed from: d  reason: collision with root package name */
    private final int f26698d;

    public IncomingOrderDetails(OrderHandle orderHandle, Order order, boolean z7, int i8) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(order, "order");
        this.f26695a = orderHandle;
        this.f26696b = order;
        this.f26697c = z7;
        this.f26698d = i8;
    }

    public final int a() {
        return this.f26698d;
    }

    public final Order b() {
        return this.f26696b;
    }

    public final OrderHandle c() {
        return this.f26695a;
    }

    public final boolean d() {
        return this.f26697c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IncomingOrderDetails) {
            IncomingOrderDetails incomingOrderDetails = (IncomingOrderDetails) obj;
            return Intrinsics.a(this.f26695a, incomingOrderDetails.f26695a) && Intrinsics.a(this.f26696b, incomingOrderDetails.f26696b) && this.f26697c == incomingOrderDetails.f26697c && this.f26698d == incomingOrderDetails.f26698d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f26695a.hashCode() * 31) + this.f26696b.hashCode()) * 31;
        boolean z7 = this.f26697c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return ((hashCode + i8) * 31) + this.f26698d;
    }

    public String toString() {
        OrderHandle orderHandle = this.f26695a;
        Order order = this.f26696b;
        boolean z7 = this.f26697c;
        int i8 = this.f26698d;
        return "IncomingOrderDetails(orderHandle=" + orderHandle + ", order=" + order + ", isB2bOrder=" + z7 + ", etaMinutes=" + i8 + ")";
    }
}
