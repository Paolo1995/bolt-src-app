package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OrderDetails.kt */
/* loaded from: classes3.dex */
public abstract class OrderDetails {
    private OrderDetails() {
    }

    public /* synthetic */ OrderDetails(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract OrderHandle a();

    public abstract OrderState b();

    public abstract Long c();

    public abstract int d();
}
