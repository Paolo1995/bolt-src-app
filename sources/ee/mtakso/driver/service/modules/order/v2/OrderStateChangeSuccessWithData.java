package ee.mtakso.driver.service.modules.order.v2;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStateChange.kt */
/* loaded from: classes3.dex */
public final class OrderStateChangeSuccessWithData extends OrderStateChange {

    /* renamed from: b  reason: collision with root package name */
    private final Object f24923b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderStateChangeSuccessWithData(OrderStateChangeType type, Object obj) {
        super(type, null);
        Intrinsics.f(type, "type");
        this.f24923b = obj;
    }

    public final Object b() {
        return this.f24923b;
    }
}
