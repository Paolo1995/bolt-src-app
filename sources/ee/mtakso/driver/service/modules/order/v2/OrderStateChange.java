package ee.mtakso.driver.service.modules.order.v2;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OrderStateChange.kt */
/* loaded from: classes3.dex */
public abstract class OrderStateChange {

    /* renamed from: a  reason: collision with root package name */
    private final OrderStateChangeType f24921a;

    private OrderStateChange(OrderStateChangeType orderStateChangeType) {
        this.f24921a = orderStateChangeType;
    }

    public /* synthetic */ OrderStateChange(OrderStateChangeType orderStateChangeType, DefaultConstructorMarker defaultConstructorMarker) {
        this(orderStateChangeType);
    }

    public final OrderStateChangeType a() {
        return this.f24921a;
    }
}
