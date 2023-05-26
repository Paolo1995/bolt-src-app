package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDetails.kt */
/* loaded from: classes3.dex */
public final class OrderDetailsKt {
    public static final boolean a(OrderDetails orderDetails, OrderState state) {
        Intrinsics.f(orderDetails, "<this>");
        Intrinsics.f(state, "state");
        if (orderDetails.b() == state) {
            return true;
        }
        return false;
    }
}
