package ee.mtakso.driver.service.modules.distance;

import ee.mtakso.driver.utils.Optional;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderWithOptionalDistance.kt */
/* loaded from: classes3.dex */
public final class OrderWithOptionalDistanceKt {
    public static final Optional<OrderWithDistance> a(OrderWithOptionalDistance orderWithOptionalDistance) {
        Intrinsics.f(orderWithOptionalDistance, "<this>");
        if (orderWithOptionalDistance.a() == null) {
            Optional<OrderWithDistance> a8 = Optional.a();
            Intrinsics.e(a8, "empty()");
            return a8;
        }
        Optional<OrderWithDistance> f8 = Optional.f(new OrderWithDistance(orderWithOptionalDistance.b(), orderWithOptionalDistance.a().doubleValue()));
        Intrinsics.e(f8, "of(OrderWithDistance(model, distance))");
        return f8;
    }
}
