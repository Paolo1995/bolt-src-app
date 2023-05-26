package ee.mtakso.driver.service.modules.order.v2;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStateChange.kt */
/* loaded from: classes3.dex */
public final class OrderStateChangeError extends OrderStateChange {

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f24922b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderStateChangeError(OrderStateChangeType type, Throwable error) {
        super(type, null);
        Intrinsics.f(type, "type");
        Intrinsics.f(error, "error");
        this.f24922b = error;
    }

    public final Throwable b() {
        return this.f24922b;
    }
}
