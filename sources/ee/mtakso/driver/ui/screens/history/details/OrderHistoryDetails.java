package ee.mtakso.driver.ui.screens.history.details;

import ee.mtakso.driver.network.client.order.PreviousOrderDetails;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHistoryDetails.kt */
/* loaded from: classes3.dex */
public final class OrderHistoryDetails {

    /* renamed from: a  reason: collision with root package name */
    private final PreviousOrderDetails f29424a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29425b;

    public OrderHistoryDetails(PreviousOrderDetails order, boolean z7) {
        Intrinsics.f(order, "order");
        this.f29424a = order;
        this.f29425b = z7;
    }

    public final PreviousOrderDetails a() {
        return this.f29424a;
    }

    public final boolean b() {
        return this.f29425b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderHistoryDetails) {
            OrderHistoryDetails orderHistoryDetails = (OrderHistoryDetails) obj;
            return Intrinsics.a(this.f29424a, orderHistoryDetails.f29424a) && this.f29425b == orderHistoryDetails.f29425b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f29424a.hashCode() * 31;
        boolean z7 = this.f29425b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        PreviousOrderDetails previousOrderDetails = this.f29424a;
        boolean z7 = this.f29425b;
        return "OrderHistoryDetails(order=" + previousOrderDetails + ", waybillEnabled=" + z7 + ")";
    }
}
