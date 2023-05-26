package ee.mtakso.driver.service.modules.order.v2;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStateChange.kt */
/* loaded from: classes3.dex */
public final class OrderStateChangeSuccess extends OrderStateChange {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderStateChangeSuccess(OrderStateChangeType type) {
        super(type, null);
        Intrinsics.f(type, "type");
    }
}
