package ee.mtakso.driver.ui.screens.history.details;

import ee.mtakso.driver.network.client.order.OrderStop;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStopExt.kt */
/* loaded from: classes3.dex */
public final class OrderStopExtKt {
    public static final GeoCoordinate a(OrderStop orderStop) {
        Intrinsics.f(orderStop, "<this>");
        if (orderStop.b() != null && orderStop.c() != null) {
            return new GeoCoordinate(orderStop.b().doubleValue(), orderStop.c().doubleValue());
        }
        return null;
    }
}
